public class Doctor{
    private int id;
    private String name;
    private String title;
    private int experience;
    private String state;

    public Doctor(int id , String name , String title , int experience){
        this.id = id;
        this.name = name;
        this.title = title;
        this.experience = experience;
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
    public String getState(){
        return state;
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
        this.experience = experience;
    }
    public void setState(String state){
        this.state = state;
    }

    public boolean titleCheck(String title){
        if(this.title == title){
            return true;
        }
        return false;
    }

    public String whichMastery(){
        if(this.experience <= 5){
            return "Begginner";
        }
        if(this.experience <= 10){
            return "Medium";
        }
        return "Master";
    }

    public String toString(){
        return "Doctor{ID = " + id + " , name = '" + name + "' , title = '" + title + "' , experience = " + experience + " , state = '" + state + "' }";
    }
}
