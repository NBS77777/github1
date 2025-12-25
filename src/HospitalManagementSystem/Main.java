package HospitalManagementSystem;

public class Main {
    public static void main(String[] args) {


        System.out.println("=== Hospital Management System ===\n");


        Patient p1 = new Patient(1, "Nurasyl Baialy", 17, "O+");
        Patient p2 = new Patient(); // default
        Doctor d1 = new Doctor(101, "Dr. Smith", "Surgeon", 12);
        Doctor d2 = new Doctor(); // default
        Appointment a1 = new Appointment(501, p1.getFullName(), d1.getName(), "2025-12-25");


        System.out.println("--- INITIAL DATA ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(a1);
        System.out.println();


        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Patient name: " + p1.getFullName());
        System.out.println("Doctor specialization: " + d1.getSpecialization());
        System.out.println("Appointment date: " + a1.getDate());
        System.out.println();


        System.out.println("--- TESTING SETTERS ---");
        p2.setFullName("Ali Khan");
        p2.setAge(45);
        p2.setBloodType("A+");
        d2.setName("Dr. Brown");
        d2.setExperienceYears(6);
        System.out.println(p2);
        System.out.println(d2);
        System.out.println();


        System.out.println("--- TESTING METHODS ---");
        System.out.println(p1.getFullName() + " is minor: " + p1.isMinor());
        System.out.println("Age category: " + p1.getAgeCategory());
        System.out.println(d1.getName() + " experienced: " + d1.isExperienced());
        System.out.println(d2.getName() + " can perform surgery: " + d2.canPerformSurgery());
        a1.reschedule("2025-12-30");
        a1.cancel();
        System.out.println(a1);
        System.out.println();

        // 7. Completion message
        System.out.println("=== Program Complete ===");
    }
}
