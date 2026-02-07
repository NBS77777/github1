package HospitalManagementSystem.model;

import HospitalManagementSystem.Interface.Payable;

public class Doctor extends Staff implements Payable {
    private String specialization;
    private int experienceYears;

    public Doctor(int id , String fullName, int age, String phone, String specialization, int experienceYears) {
        super(id, fullName, age, phone);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty");
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) throw new IllegalArgumentException("Experience years cannot be negative");
        this.experienceYears = experienceYears;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + fullName + " is treating patients (" + specialization + ").");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public double calculateSalary() {
        return experienceYears * 5000 ;
    }

    public String getSpecialization() {
        return specialization;
    }
    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpecialization: " + specialization +
                "\nExperience: " + experienceYears + " years";
    }

}
