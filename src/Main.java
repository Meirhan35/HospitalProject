public class Main {
    public static void main(String[] args){
        System.out.println("Hospital Management System");
        Patient patient1 = new Patient(101, "Abilda Meirhan" , 17 , "A-" , "+77476896790");
        Patient patient2 = new Patient(102, "Tazhidinov Nurislam" , 18 , "B+" , "+77716164711");
        Patient patient3 = new Patient(103, "Patchahanov Atabek" , 27 , "B-" , "+77755310106");

        Doctor doctor1 = new Doctor(201 , "A. Darkhnov" , "Surgeon", 13);
        Doctor doctor2 = new Doctor(202 , "T. Karimov", "Cardiologist" , 5);

        Appointment app1 = new Appointment(301 , "2025-12-25" , "A. Darkhanov" , "Abilda Meirhan");
        Appointment app2 = new Appointment(302 , "2025-12-20" , "T. Karimov" , "Patchahanov Atabek");

        System.out.println("    PATIENTS    ");
        System.out.println(patient1);
        System.out.println(patient2);
        System.out.println(patient3);
        System.out.println();

        System.out.println("    DOCTORS    ");
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println();

        System.out.println("    APPOINTMENTS    ");
        System.out.println(app1);
        System.out.println(app2);
        System.out.println();

        System.out.println(patient1.getName() + " is minor: " + patient1.isMinor());
        System.out.println(patient2.getName() + " info: " + patient2.getPatientInfo());
        System.out.println();

        System.out.println(doctor1.getName() + " experienced: " + doctor1.isExperienced());
        System.out.println(doctor2.getName() + " can perform surgery: " + doctor2.canPerformSurgery());
        System.out.println();

        app1.reschedule("2025-03-25");
        System.out.println("Rescheduled appointment: " + app1);
        app2.cancel();
        System.out.println("Cancelled appointment: " + app2);
        System.out.println();

        System.out.println("   FINAL RESULT   ");
        System.out.println(patient1);
        System.out.println(patient2);
        System.out.println(patient3);
        System.out.println();
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println();
        System.out.println(app1);
        System.out.println(app2);
    }
}
