package week4;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalApp {
    private static ArrayList<Person> people = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        people.add(new Person(1, "Ali Bek", 45, "87011111111"));
        people.add(new Doctor(2, "Dr. Aigerim", 38, "87022222222", "Cardiology", 12));
        people.add(new Patient(3, "Nurasyl", 17, "87033333333", "Flu", true));

        boolean running = true;

        while (running){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                    AddPerson();
                    break;
                case 2 :
                    AddDoctor();
                    break;
                case 3 :
                    AddPatient();
                    break;
                case 4 :
                    ViewAll();
                    break;
                case 5 :
                    DemonstratePolymorphism();
                    break;
                case 6 :
                    ViewDoctorsOnly();
                    break;
                case 7 :
                    ViewPatientsOnly();
                    break;
                case 0 :
                    System.out.println("\nGoodbye Nurassyl");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! ");
            }
            if (running){
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }
    private static void displayMenu(){
        System.out.println("\n==============================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
        System.out.println("==============================");
        System.out.println("1. Add Person");
        System.out.println("2. Add Doctor");
        System.out.println("3. Add Patient");
        System.out.println("4. View All (Polymorphic)");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.println("6. View Doctors Only");
        System.out.println("7. View Patients Only");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void AddPerson() {
        System.out.println("\n--- ADD PERSON ---");

        System.out.print("Enter Person ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter full name: ");
        String fullname = scanner.nextLine();

        System.out.println("Enter age: ");
        int Age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter phone: ");
        String Phone = scanner.nextLine();

        people.add(new Person(ID , fullname , Age , Phone));
        System.out.println("Person added.");
    }

    private static void AddDoctor (){
        System.out.println("\n--- ADD DOCTOR ---");

        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter full name: ");
        String FullName = scanner.nextLine();

        System.out.println("Enter age: ");
        int Age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter phone: ");
        String Phone = scanner.nextLine();

        System.out.println("Specialization: ");
        String Specialization = scanner.nextLine();

        System.out.println("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        people.add(new Doctor(id , FullName, Age , Phone , Specialization , exp));
        System.out.println("Doctor added.");
    }

    private static void  AddPatient(){
        System.out.println("\n--- ADD Patient ---");

        System.out.print("Enter Patient ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter full name: ");
        String FullName = scanner.nextLine();

        System.out.println("Enter age: ");
        int Age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter phone: ");
        String Phone = scanner.nextLine();

        System.out.println("disease: ");
        String dis = scanner.nextLine();

        System.out.print("Admitted (true/false): ");
        boolean admitted = scanner.nextBoolean();
        scanner.nextLine();

        people.add(new Patient(ID , FullName, Age , Phone , dis , admitted));
        System.out.println("Patient added.");
    }

    private static void ViewAll() {
        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) {
            System.out.println(p);

            if (p instanceof Doctor) {
                Doctor d = (Doctor) p;
                if (d.isSeniorDoctor()) {
                    System.out.println(" Senior Doctor ");
                }
            } else if (p instanceof Patient) {
                Patient pat = (Patient) p;
                if (pat.isAdmitted()) {
                    System.out.println(" Currently Admitted ");
                }
            }
            System.out.println();
        }
    }

    private static void DemonstratePolymorphism(){
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : people){
            p.work();
        }

    }

    private static void ViewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        for (Person p : people) {
            if (p instanceof Doctor) {
                Doctor d = (Doctor) p;
                System.out.println(d);
            }
        }
    }

    private static void ViewPatientsOnly() {
        System.out.println("\n--- PATIENTS ONLY ---");
        for (Person p : people) {
            if (p instanceof Patient) {
                Patient pat = (Patient) p;
                System.out.println(pat);
            }
        }
    }
}
