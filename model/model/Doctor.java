package model;

public class Doctor extends model.Staff implements model.DoctorActions {
    private String specialization;
    public Doctor(int id , String name , String specalization , int experience , double salary){
        super(id , name , experience , salary);
        this.specialization = specalization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean canPerformSurgery() {
        return (specialization == "Surgeon" && experience >= 5);
    }

    @Override
    public void getRole() {
        System.out.println("Doctor");
    }

    @Override
    public void work(){
        System.out.println("Doctor" + name + " performs operation related to " + specialization);
    }
    @Override
    public boolean isExperienced(){
        if(experience >= 10){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void performCheckup(String patientName) {
        System.out.println("Dr. " + name + " is performing a checkup on " + patientName);
    }
    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString(){
        return "Doctor{ID: " + id + " , name: '" + name + ", title: '" + specialization + "', experience: " + experience + " years, salary: " + salary + "}";
    }

}
