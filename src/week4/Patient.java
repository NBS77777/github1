package week4;

public class Patient extends Person {
    private String disease ;
    private boolean admitted ;

    public Patient(int id, String fullName, int age, String phone , String disease , boolean admitted) {
        super(id, fullName, age, phone);
        this.disease=disease;
        this.admitted=admitted;
    }

    @Override
    public void work() {
        System.out.println("Patient " + fullName +
                " is receiving treatment for " + disease + ".");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public void takeMedicine() {
        System.out.println(fullName + " is taking prescribed medicine.");
    }

    public boolean isAdmitted() {
        return admitted;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDisease: " + disease +
                "\nAdmitted: " + (admitted ? "Yes" : "No");

    }
}
