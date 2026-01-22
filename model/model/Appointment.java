package model;

public class Appointment{
    private int id;
    private String date;
    private String doctor;
    private String nurse;
    private String patient;

    public Appointment(int id, String date, String doctor, String nurse , String patient){
        this.id = id;
        this.date = date;
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
    }

    public int getId(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public String getDoctor(){
        return doctor;
    }
    public String getPatient(){
        return patient;
    }
    public String getNurse() {
        return nurse;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    public void setPatient(String patient){
        this.patient = patient;
    }
    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public void reschedule(String newDate) {
        this.date = newDate;
    }
    public void cancel() {
        this.date = "Cancelled";
    }

    public String toString(){
        return "Appointment{ID = " + id + " , date = '" + date + "' , doctor = '" + doctor + "' , patient = '" + patient + "'}";
    }
}