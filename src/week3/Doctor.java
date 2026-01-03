package week3;

public class Doctor {
    private int doctorId;
    private String name;
    private  String specialization;
    private int experienceYears;

    public Doctor(int doctorId , String name , String specialization , int experienceYears){
        this.doctorId= doctorId;
        setName(name);
        this.specialization=specialization;
        setExperienceYears(experienceYears);
    }

    public Doctor() {
        this.doctorId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
    }

    public int getDoctorId(){
        return doctorId;
    }
    public String getname(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getExperienceYears(){
        return experienceYears;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            this.name = "Unknown";
        }
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears){
        if (experienceYears >= 0){
            this.experienceYears = experienceYears;
        }else{
            this.experienceYears=0;
        }
    }

    public boolean isExperiensed(){
        return experienceYears >= 10;
    }

    @Override
    public String toString() {
        return "doctorID:" + doctorId +
                "\ndoctor Name: " + name +
                "\nspecialization: " + specialization +
                "\nExperience: " + experienceYears + " years" +
                "\nSenior Doctor: " + (isExperiensed() ? "Yes" : "No");
    }
}
