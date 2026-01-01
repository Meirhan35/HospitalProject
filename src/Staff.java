public class Staff {
    protected int id;
    protected String name;
    protected int experience;
    protected double salary;

    public Staff(int id, String name , int experience , double salary){
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        if(experience < 0){
            System.out.println("Experience cannot be negative! setting to 0.");
        }
        else{
            this.experience = experience;
        }
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if(salary < 0){
            System.out.println("Salary cannot be negative! setting to 0.");
        }
        else{
            this.salary = salary;
        }
    }

    public void getRole(){
        System.out.println("Staff member");
    }

    public boolean isExperienced(){
        if(experience >= 5){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "[Staff member] " + name + "(ID: " + id + ", experience: " + experience + " years, salary: " + salary + " KZT)";
    }

}
