public class Patient {
    private String name;
    private String contact;
    private int age;
    private String disease;
    private int id;
    private int points;

    public Patient(String name, String contact, int age, String disease, int id , int points) {
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.disease = disease;
        this.id = id;
        this.points = points;
    }

    public String getName(){
        return name;
    }
    public String getContact(){
        return contact;
    }
    public int getAge(){
        return age;
    }
    public String getDisease(){
        return disease;
    }
    public int getId(){
        return id;
    }
    public int getPoints(){
        return points;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPoints(int points){
        this.points = points;
    }

    public void addLoyaltyPoints(int points){
        this.points += points;
    }
    public boolean CheckLoyalty() {
        if (this.points >= 100) {
            return true;
        }
        return false;
    }
    public String toString(){
        return "Patient{ID = ' + id + ' , name = '" + name + "' , age = " + age + " , disease = '" + disease + "' , points = " + points + " , contact = " + contact + "}";
    }
}
