package model;

public class Nurse extends model.Staff {
    private String specialization;

    public Nurse(int id, String name , String specialization, int experience, double salary){
        super(id, name, experience, salary);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void getRole(){
        System.out.println("Nurse");
    }

    @Override
    public void work(){
        System.out.println("Nurse " + name + " takes care of " + specialization + "patients");
    }
    @Override
    public boolean isExperienced(){
        if(experience >= 5){
            return true;
        }
        else{
            return false;
        }
    }

}
