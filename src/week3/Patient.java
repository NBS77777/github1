package week3;

public class Patient {
    private final int patientId;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientId, String fullName, int age, String bloodtype) {
        this.patientId = patientId;
        setFullName(fullName);
        setAge(age);
        setBloodtype(bloodType);
    }

    public Patient() {
        this.patientId = 0;
        this.fullName = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
    }

    public int getPatientId(){
        return patientId;
    }
    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public String getBloodtype(){
        return bloodType;
    }

    public void setFullName(String fullName){
        if (fullName != null && !fullName.trim().isEmpty()){
            this.fullName=fullName;
        } else{
            this.fullName="Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }else{
            this.age=0;
        }
    }

    public void setBloodtype(String bloodtype){
        if(bloodtype != null && !fullName.trim().isEmpty()){
            this.bloodType=bloodType;
        }else {
            this.bloodType="Unknown";
        }
    }

    public boolean isMinor(){
        return age < 18;
    }

    @Override
    public String toString() {
        return "PatientId: " + patientId +
                "\nName: " + fullName +
                "\nAge :" + age +
                "\nBloodType :" + bloodType +
                "\nMinor: " + (isMinor() ? "Yes" : "No");
    }
}



