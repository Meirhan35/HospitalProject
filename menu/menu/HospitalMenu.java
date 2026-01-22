package menu;

import model.*;

import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;
public class HospitalMenu implements menu.Menu {
    public static int idP = 10000;
    public static int idS = 20000;
    public static int idA = 30000;
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Staff> allstaff = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public HospitalMenu(){
        try{
            patients.add(new Patient(idP++, "Abilda Meirhan" , 17 , "A-" , "+77476896790"));
            patients.add(new Patient(idP++, "Tazhidinov Nurislam" , 18 , "B+" , "+77716164711"));
            patients.add(new Patient(idP++, "Patchahanov Atabek" , 27 , "B-" , "+77755310106"));

            allstaff.add(new Nurse(idS++ , "Begimai Qalmakhan" , "Emergency", 3 , 250000));
            allstaff.add(new Nurse(idS++ , "Leyla Faizulla" , "Pediatrics", 10 , 400000));


            allstaff.add(new Doctor(idS++ , "Arman Darkhanov" , "Surgeon", 13 , 1000000));
            allstaff.add(new Doctor(idS++ , "Turar Karimov", "Cardiologist" , 5 , 600000));

            appointments.add(new Appointment(idA++ , "2025-12-25" , "A. Darkhanov" ,"Begimai Qalmakhan", "Abilda Meirhan"));
            appointments.add(new Appointment(idA++ , "2025-12-20" ,"T. Karimov","Leyla Faizulla" , "Patchahanov Atabek"));
        }
        catch (IllegalArgumentException e){
            System.out.println("Error initializing test data: " + e.getMessage());

        }
    }


    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Nurse");
        System.out.println("4. View All Nurses");
        System.out.println("5. Add Doctor");
        System.out.println("6. View All Doctors");
        System.out.println("7. Add Appointment");
        System.out.println("8. View All Appointments");
        System.out.println("9. View All Staff");
        System.out.println("10. Demonstrate Polymorphism");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private void addPatient() {
        try{
            System.out.println("\n--- ADD PATIENT ---");
            int id = idP;
            idP++;
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            while (age < 0) {
                System.out.print("Negative number found, please enter again: ");
                age = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.print("Enter blood type: ");
            String bloodtype = scanner.nextLine();
            System.out.print("Enter patients contact: ");
            String contact = scanner.nextLine();
            Patient patient = new Patient(id, name, age, bloodtype, contact);
            patients.add(patient);
            System.out.println("\n Patient added successfully!");
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void viewPatients() {
        System.out.println("\n========================================");
        System.out.println(" ALL PATIENTS");
        System.out.println("========================================");
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("Total patients: " + patients.size());
        System.out.println();
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
        System.out.println();
    }

    private void addNurse() {
        try{
            System.out.println("\n--- ADD NURSE ---");
            int id = idS;
            idS++;
            System.out.print("Enter nurse name: ");
            String name = scanner.nextLine();
            System.out.println("Enter specalization: ");
            String specalization = scanner.nextLine();
            System.out.print("Enter experience: ");
            int experience = scanner.nextInt();
            scanner.nextLine();
            while (experience < 0) {
                System.out.print("Negative number found, please enter again: ");
                experience = scanner.nextInt();
                scanner.nextLine();
            }
            double salary = scanner.nextDouble();
            scanner.nextLine();
            Staff staff = new Nurse(id, name, specalization, experience, salary);
            allstaff.add(staff);
            System.out.println("\n Nurse added successfully!");
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void viewNurses() {
        System.out.println("\n========================================");
        System.out.println("               ALL NURSES");
        System.out.println("========================================");

        int nurseCount = 0;

        for (Staff current : allstaff) {
            if (current instanceof Nurse) {
                Nurse nurse = (Nurse) current;
                nurseCount++;
                System.out.println(nurseCount + ". " + nurse.getName());
                System.out.println("  Specalization: " + nurse.getSpecialization());
                System.out.println("  Experience: " + nurse.getExperience() + " years");
                System.out.println("  Salary: " + nurse.getSalary() + " KZT");
                System.out.println();
            }
        }

        if (nurseCount == 0) {
            System.out.println("No nurses found.");
        }
    }

    private void addDoctor() {
        try{
            System.out.println("\n--- ADD DOCTOR ---");
            int id = idS;
            idS++;
            System.out.print("Enter doctor name: ");
            String name = scanner.nextLine();
            System.out.print("Enter specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter experience: ");
            int experience = scanner.nextInt();
            scanner.nextLine();
            while (experience < 0) {
                System.out.print("Negative number found, please enter again: ");
                experience = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            while (salary < 0) {
                System.out.print("Negative number found, please enter again: ");
                salary = scanner.nextDouble();
                scanner.nextLine();
            }
            Staff staff = new Doctor(id, name, specialization, experience, salary);
            allstaff.add(staff);
            System.out.println("\n Doctor added successfully!");
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }
    }

    private void viewDoctors() {
        System.out.println("\n========================================");
        System.out.println("               ALL DOCTORS");
        System.out.println("========================================");

        int doctorCount = 0;

        for (Staff current : allstaff) {
            if (current instanceof Doctor) {
                Doctor doctor = (Doctor) current;
                doctorCount++;
                System.out.println(doctorCount + ". " + doctor.getName());
                System.out.println("  Title: " + doctor.getSpecialization());
                System.out.println("  Experience: " + doctor.getExperience() + " years");
                System.out.println("  Salary: " + doctor.getSalary() + " KZT");
                System.out.println();
            }
        }

        if (doctorCount == 0) {
            System.out.println("No doctors found.");
        }
    }

    private void addAppointment() {
        try{
            System.out.println("\n--- ADD APPOINTMENT ---");
            int id = idA;
            idA++;
            System.out.println("Enter appointment date: ");
            String date = scanner.nextLine();
            if(date.length() != 8){
                throw new InvalidInputException("Invalid Type of Date!");
            }
            System.out.println("Enter doctors name: ");
            String doctor = scanner.nextLine();
            System.out.println("Enter nurses name: ");
            String nurse = scanner.nextLine();
            System.out.println("Enter patients name: ");
            String patient = scanner.nextLine();
            Appointment app = new Appointment(id, date, doctor, nurse, patient);
            appointments.add(app);
            System.out.println("\n Appointment added successfully!");
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid input type!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        }

    }

    private void viewAppointment(){
        System.out.println("\n========================================");
        System.out.println(" ALL APPOINTMENTS");
        System.out.println("========================================");
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        System.out.println("Total appointments: " + appointments.size());
        System.out.println();
        for (Appointment app : appointments) {
            System.out.println(app.toString());
        }
        System.out.println();
    }

    private void viewAllStaff(){
        System.out.println("\n========================================");
        System.out.println("     ALL STAFF (POLYMORPHIC LIST)");
        System.out.println("========================================");

        if (allstaff.isEmpty()) {
            System.out.println("No staff members found.");
        }

        System.out.println("Total staff: " + allstaff.size());
        System.out.println();

        for (int i = 0; i < allstaff.size(); i++) {
            Staff current = allstaff.get(i);
            System.out.println((i + 1) + ". " + current);
        }
        System.out.println();
    }

    private void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("      POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling getRole() on all staff members:");
        System.out.println();
        for (Staff s : allstaff) {
            s.getRole();
        }
        System.out.println();
        System.out.println(" Notice: Same method name (work), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }

    @Override
    public void run(){
        boolean running = true;
        while(running) {
            displayMenu();
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        addNurse();
                        break;
                    case 4:
                        viewNurses();
                        break;
                    case 5:
                        addDoctor();
                        break;
                    case 6:
                        viewDoctors();
                        break;
                    case 7:
                        addAppointment();
                        break;
                    case 8:
                        viewAppointment();
                        break;
                    case 9:
                        viewAllStaff();
                        break;
                    case 10:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        System.out.println("Good Bye!");
                        running = false;
                        break;
                    default:
                        System.out.println("\n Invalid choice!");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Invalid input type!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validation Error: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("\n=== Program Complete ===");
    }
}

