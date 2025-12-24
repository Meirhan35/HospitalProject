public class Patient {
    private int id;
    private String name;
    private int age;
    private String bloodtype;
    private String contact;

    public Patient(int id , String name, int age , String bloodtype, String contact) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.bloodtype = bloodtype;
        this.contact = contact;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBloodtype(){
        return bloodtype;
    }
    public String getContact(){
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }
        else{
            System.out.println("Warning: Age cannot be negative! Setting to 0.");
            this.age = 0;
        }
    }
    public void setBloodtype(String bloodtype){
        this.bloodtype = bloodtype;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public String getPatientInfo() {
        return "Age: " + age + ", Bloodtype: '" + bloodtype + "', Contact: " + contact;
    }
    public boolean isMinor() {
        return age < 18;
    }

    public String toString(){
        return "Patient{ID = " + id + " , name = '" + name + "' , age = " + age + "  , bloodtype = " + bloodtype + " , contact = " + contact + "}";
    }
}
