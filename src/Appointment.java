public class Appointment {
    private int id;
    private String date;
    private String doctor;
    private String patient;

    public Appointment(int id, String date, String doctor , String patient){
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
    public String getDoctor(){
        return doctor;
    }
    public String getPatient(){
        return patient;
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