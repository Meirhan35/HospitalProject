package model;

public abstract class Staff {
    protected int id;
    protected String name;
    protected int experience;
    protected double salary;

    public Staff(int id, String name , int experience , double salary){
        setId(id);
        setName(name);
        setExperience(experience);
        setSalary(salary);
    }

    public abstract void work();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("Id can not be negative!");
        }
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        if(experience < 0){
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experience = experience;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public abstract void getRole();

    public boolean isExperienced(){
        if(experience >= 5){
            return true;
        }
        else{
            return false;
        }
    }

    public String getInfo(){
        return "[Staff member] " + name + "(ID: " + id + ", experience: " + experience + " years, salary: " + salary + " KZT)";
    }

}
