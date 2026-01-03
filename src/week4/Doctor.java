package week4;

public class Doctor extends Person {
    private String specialization ;
    private int experienceYears ;

    public Doctor (int ID, String fullName , int age , String phone , String specialization , int experienceYears  ){
        super(ID , fullName , age , phone);
        this.specialization=specialization;
        this.experienceYears=experienceYears;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + fullName +
                " is treating patients (" + specialization + ").");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public void diagnosePatient() {
        System.out.println("Doctor " + fullName + " is making a diagnosis.");
    }

    public boolean isSeniorDoctor(){
        return experienceYears >= 10 ;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Specialization: " + specialization +
                ", Experience: " + experienceYears + " years";
    }
}
