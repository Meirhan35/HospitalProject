import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static int idP = 10000;
    public static int idD = 20000;
    public static int idA = 30000;
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors  = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("5. Add Appointment");
        System.out.println("6. View All Appointment");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addPatient() {
        System.out.println("\n--- ADD PATIENT ---");
        int id = idP;
        idP++;
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        while(age < 0){
            System.out.print("Negative number found, please enter again: ");
            age = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("Enter blood type: ");
        String bloodtype = scanner.nextLine();
        System.out.print("Enter patients contact: ");
        String contact = scanner.nextLine();
        Patient patient = new Patient(id , name , age , bloodtype , contact);
        patients.add(patient);
        System.out.println("\n Patient added successfully!");
    }

    private static void viewPatients() {
        System.out.println("\n========================================");
        System.out.println(" ALL PATIENTS");
        System.out.println("========================================");
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("Total patients: " + patients.size());
        System.out.println();
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println(patient.toString());
        }
        System.out.println();
    }

    private static void addDoctor() {
        System.out.println("\n--- ADD DOCTOR ---");
        int id = idD;
        idD++;
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();
        while(experience < 0){
            System.out.print("Negative number found, please enter again: ");
            experience = scanner.nextInt();
            scanner.nextLine();
        }
        Doctor doctor = new Doctor(id , name , title , experience);
        doctors.add(doctor);
        System.out.println("\n Doctor added successfully!");
    }

    private static void viewDoctors() {
        System.out.println("\n========================================");
        System.out.println(" ALL DOCTORS");
        System.out.println("========================================");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("Total doctors: " + doctors.size());
        System.out.println();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println(doctor.toString());
        }
        System.out.println();
    }

    private static void addAppointment() {
        System.out.println("\n--- ADD APPOINTMENT ---");
        int id = idA;
        idA++;
        System.out.println("Enter appointment date: ");
        String date = scanner.nextLine();
        System.out.println("Enter doctors name: ");
        String doctor = scanner.nextLine();
        System.out.println("Enter patients name: ");
        String patient = scanner.nextLine();
        Appointment app = new Appointment(id , date , doctor , patient);
        appointments.add(app);
        System.out.println("\n Appointment added successfully!");
    }

    private static void viewAppointment(){
        System.out.println("\n========================================");
        System.out.println(" ALL APPOINTMENTS");
        System.out.println("========================================");
        if(appointments.isEmpty()){
            System.out.println("No appointments found.");
            return;
        }
        System.out.println("Total appointments: " + appointments.size());
        System.out.println();
        for(int i = 0;i < appointments.size();i++){
            Appointment app = appointments.get(i);
            System.out.println(app.toString());
        }
        System.out.println();
    }


    public static void main(String[] args){
        patients.add(new Patient(idP++, "Abilda Meirhan" , 17 , "A-" , "+77476896790"));
        patients.add(new Patient(idP++, "Tazhidinov Nurislam" , 18 , "B+" , "+77716164711"));
        patients.add(new Patient(idP++, "Patchahanov Atabek" , 27 , "B-" , "+77755310106"));

        doctors.add(new Doctor(idD++ , "A. Darkhanov" , "Surgeon", 13));
        doctors.add(new Doctor(idD++ , "T. Karimov", "Cardiologist" , 5));

        appointments.add(new Appointment(idA++ , "2025-12-25" , "A. Darkhanov" , "Abilda Meirhan"));
        appointments.add(new Appointment(idA++ , "2025-12-20" ,"T. Karimov", "Patchahanov Atabek"));

        boolean running = true;
        while(running){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    addAppointment();
                    break;
                case 6:
                    viewAppointment();
                    break;
                case 0:
                    System.out.println("Good Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if(running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
        System.out.println("\n=== Program Complete ===");
    }
}
