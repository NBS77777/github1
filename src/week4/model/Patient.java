package week4.model;

public class Patient extends Person {
    private String disease;
    private boolean admitted;

    public Patient(int id, String fullName, int age, String phone, String disease, boolean admitted) {
        super(id, fullName, age, phone);
        setDisease(disease);
        setAdmitted(admitted);
    }

    public void setDisease(String disease) {
        if (disease == null || disease.trim().isEmpty())
            throw new IllegalArgumentException("Disease cannot be empty");
        this.disease = disease;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void work() {
        System.out.println("Patient " + fullName + " is receiving treatment for " + disease + ".");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDisease: " + disease +
                "\nAdmitted: " + (admitted ? "Yes" : "No");
    }
}
