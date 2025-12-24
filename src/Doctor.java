public class Doctor{
    private int id;
    private String name;
    private String title;
    private int experience;

    public Doctor(int id , String name , String title , int experience){
        this.id = id;
        this.name = name;
        this.title = title;
        setExperience(experience);
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTitle(){
        return title;
    }
    public int getExperience(){
        return experience;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setExperience(int experience){
        if(experience >= 0){
            this.experience = experience;
        }
        else{
            System.out.println("Warning: Experience cannot be negative! Setting to 0.");
            this.experience = 0;
        }
    }

    public boolean isExperienced() {
        return experience >= 10;
    }
    public boolean canPerformSurgery() {
        return (title == "Surgeon" && experience >= 5);
    }

    public String toString(){
        return "Doctor{ID = " + id + " , name = '" + name + "' , title = '" + title + "' , experience = " + experience + "' }";
    }
}
