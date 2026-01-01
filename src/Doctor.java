public class Doctor extends Staff{
    private String title;
    public Doctor(int id , String name , String title , int experience , double salary){
        super(id , name , experience , salary);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean canPerformSurgery() {
        return (title == "Surgeon" && experience >= 5);
    }

    @Override
    public void getRole() {
        System.out.println("Doctor");
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
    public String toString(){
        return "Doctor{ID: " + id + " , name: '" + name + ", title: '" + title + "', experience: " + experience + " years, salary: " + salary + "}";
    }

}
