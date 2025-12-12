public class Appointment {
    private int id;
    private String time;
    private String doctor;
    private String patient;
    private String disease;
    private String status;

    public Appointment(int id, String time , String doctor , String patient , String disease , String status){
        this.id = id;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
        this.disease = disease;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public String getTime(){
        return time;
    }
    public String getDoctor(){
        return doctor;
    }
    public String getPatient(){
        return patient;
    }
    public String getDisease(){
        return disease;
    }
    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    public void setPatient(String patient){
        this.patient = patient;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public boolean checkAvailabelity(String time){
        if(this.time == time){
            return true;
        }
        return false;
    }

    public void changeStatus(String time){
        int cur_hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int cur_min = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        int scheduled_hour = (this.time.charAt(0) - '0') * 10 + this.time.charAt(1) - '0';
        int scheduled_min = (this.time.charAt(3) - '0') * 10 + this.time.charAt(4) - '0';
        if(cur_hour < scheduled_hour || (cur_hour == scheduled_hour && cur_min < scheduled_min)){
            status = "waiting";
        }
        else if(cur_hour >= scheduled_hour && cur_min + cur_hour * 60 > scheduled_min + scheduled_hour * 60 + 30) {
            status = "existed";
        }
        else {
            status = "happening right now";
        }
    }

    public String toString(){
        return "Appointment{ID = " + id + " , time = '" + time + "' , doctor = '" + doctor + "' , patient = '" + patient + "' , disease = '" + disease + "' , status = '" + status + "'}";
    }
}