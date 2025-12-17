public class Appointment {
    private int id;
    private String date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(int id, String date, Doctor doctor , Patient patient){
        this.id = id;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getId(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public Patient getPatient(){
        return patient;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void reschedule(String newDate) {
        this.date = newDate;
    }
    public void cancel() {
        this.date = "Cancelled";
    }

    public String toString(){
        return "Appointment{ID = " + id + " , date = '" + date + "' , doctor = '" + doctor.getName() + "' , patient = '" + patient.getName() + "'}";
    }
}