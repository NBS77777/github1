package HospitalManagementSystem;

public class Appointment {


    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private boolean cancelled;


    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.cancelled = false;
    }


    public Appointment() {
        this.appointmentId = 0;
        this.patientName = "Unknown";
        this.doctorName = "Unknown";
        this.date = "Not set";
        this.cancelled = false;
    }


    public int getAppointmentId() {
        return appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDate() {
        return date;
    }

    public boolean isCancelled() {
        return cancelled;
    }


    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void reschedule(String newDate) {
        if (!cancelled) {
            this.date = newDate;
        }
    }

    public void cancel() {
        cancelled = true;
    }


    @Override
    public String toString() {
        return "Appointment{appointmentId=" + appointmentId +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", cancelled=" + cancelled +
                '}';
    }
}
