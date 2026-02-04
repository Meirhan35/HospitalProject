package menu;

import database.StaffDAO;
import model.*;

import java.util.Scanner;

public class HospitalMenu implements Menu {

    static Scanner scanner = new Scanner(System.in);
    private StaffDAO staffDAO = new StaffDAO();

    @Override
    public void displayMenu(){
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        HOSPITAL MANAGEMENT SYSTEM          ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("┌─ PERSON MANAGEMENT ───────────────────────┐");
        System.out.println("│ 1. Add Doctor                             │");
        System.out.println("│ 2. Add Nurses                             │");
        System.out.println("│ 3. View All Staff                         │");
        System.out.println("│ 4. View Doctors Only                      │");
        System.out.println("│ 5. View Nurses Only                       │");
        System.out.println("│ 6. Update Staff                           │");
        System.out.println("│ 7. Delete Staff                           │");
        System.out.println("├─ SEARCH & FILTER ─────────────────────────┤");
        System.out.println("│ 8. Search by Name                         │");
        System.out.println("│ 9. Doctors by Experience Range            │");
        System.out.println("│10. Experienced Doctors (Experience ≥ X)   │");
        System.out.println("├─ DEMO & OTHER ────────────────────────────┤");
        System.out.println("│11. Polymorphism Demo                      │");
        System.out.println("│ 0. Exit                                   │");
        System.out.println("└───────────────────────────────────────────┘");
    }

    @Override
    public void run() {
        boolean running = true;
        while(running){
            displayMenu();
            System.out.print("\n👉 Enter your choice: ");
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: addDoctor(); break;
                    case 2: addNurse(); break;
                    case 3: staffDAO.viewAllStaff(); break;
                    case 4: staffDAO.viewDoctors(); break;
                    case 5: staffDAO.viewNurse(); break;
                    case 6: updateStaff(); break;
                    case 7: deleteStaff(); break;
                    case 8: searchByName(); break;
                    case 9: searchDoctorsByExperienceRange(); break;
                    case 10: searchDoctorsByMinExperience(); break;
                    case 11: staffDAO.demonstratePolymorphism(); break;
                    case 0: running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!      ║");
                        System.out.println("║  Goodbye! 👋                          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default: System.out.println("Invalid choice. Try again.");
                }
                if (choice != 0) {
                    pressEnterToContinue();
                }
            }catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Please enter a valid number!");
                scanner.nextLine();
                pressEnterToContinue();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine();
                pressEnterToContinue();
            }
        }
    }
    private void pressEnterToContinue() {
        System.out.println("\n[Press Enter to continue...]");
        scanner.nextLine();
    }

    public void addDoctor() {

        System.out.println("\n--- ADD DOCTOR ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter experience years: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        try {
            Doctor doctor = new Doctor(1, name, specialization, experience , salary);
            staffDAO.insertDoctor(doctor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void addNurse() {

        System.out.println("\n--- ADD NURSE ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter experience years: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        try {
            Nurse nurse = new Nurse(1, name, specialization, experience , salary);
            staffDAO.insertNurse(nurse);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void updateStaff() {

        System.out.print("\nEnter Staff ID to update: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine();

            Staff existing = staffDAO.getStaffById(id);

            if (existing == null) {
                System.out.println("❌ No staff found with ID: " + id);
                return;
            }

            System.out.println("Current Info: " + existing.getInfo());
            System.out.println("Press Enter to keep old value");

            System.out.print("New Name [" + existing.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.isEmpty()) newName = existing.getName();

            System.out.print("New Experience [" + existing.getExperience() + "]: ");
            String experienceInput = scanner.nextLine();
            int newExperience = experienceInput.isEmpty() ? existing.getExperience() : Integer.parseInt(experienceInput);

            System.out.print("New Salary [" + existing.getSalary() + "]: ");
            String salaryInput = scanner.nextLine();
            double newSalary = salaryInput.isEmpty() ? existing.getSalary() : Double.parseDouble(salaryInput);
            if (existing instanceof Doctor) {
                Doctor doctor = (Doctor) existing;

                System.out.print("New Specialization [" + doctor.getSpecialization() + "]: ");
                String newSpecialization = scanner.nextLine();
                if (newSpecialization.isEmpty()) newSpecialization =  doctor.getSpecialization();

                Doctor updated = new Doctor(id, newName, newSpecialization,newExperience,newSalary);
                staffDAO.updateDoctor(updated);

            } else {
                Nurse nurse = (Nurse) existing;

                System.out.print("New Specialization [" + nurse.getSpecialization() + "]: ");
                String newSpecialization = scanner.nextLine();
                if (newSpecialization.isEmpty()) newSpecialization = existing.getName();

                Nurse updated = new Nurse(id, newName, newSpecialization,newExperience,newSalary);
                staffDAO.updateNurse(updated);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void deleteStaff() {

        System.out.print("\nEnter Staff ID to delete: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine();

            Staff staff = staffDAO.getStaffById(id);

            if (staff == null) {
                System.out.println("❌ No staff found with ID: " + id);
                return;
            }

            System.out.println("Staff to delete: " + staff.getInfo());
            System.out.print("⚠️  Are you sure? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                staffDAO.deleteStaff(id);
            } else {
                System.out.println("❌ Deletion cancelled.");
            }

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    private void searchByName() {
        System.out.print("\nEnter name to search: ");
        String name = scanner.nextLine();
        staffDAO.searchByName(name);
    }

    private void searchDoctorsByExperienceRange() {
        System.out.print("Enter min experience: ");
        int min = scanner.nextInt();
        System.out.print("Enter max experience: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        staffDAO.searchDoctorsByExperienceRange(min, max);
    }

    private void searchDoctorsByMinExperience() {
        System.out.print("Enter minimum experience: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        staffDAO.searchDoctorsByMinExperience(min);
    }
}

