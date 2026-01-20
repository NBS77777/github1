package week4.menu;

import week4.model.Person;
import week4.model.Doctor;
import week4.model.Patient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalMenu implements Menu {

    private ArrayList<Person> people;
    private Scanner scanner;

    public HospitalMenu() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Test data
        people.add(new Doctor(2, "Dr. Aigerim", 38, "87022222222", "Cardiology", 12));
        people.add(new Patient(3, "Nurasyl", 17, "87033333333", "Flu", true));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n==============================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
        System.out.println("==============================");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. View All Staff");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. View Doctors Only");
        System.out.println("6. View Patients Only");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        addPatient();
                        break;
                    case 3:
                        viewAll();
                        break;
                    case 4:
                        demonstratePolymorphism();
                        break;
                    case 5:
                        viewDoctorsOnly();
                        break;
                    case 6:
                        viewPatientsOnly();
                        break;
                    case 0:
                        System.out.println("\nGoodbye Nurassyl");
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice! ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void addDoctor() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Full name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            System.out.print("Experience years: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            people.add(new Doctor(id, name, age, phone, spec, exp));
            System.out.println("Doctor added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Input error! Please enter the correct type.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void addPatient() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Full name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Disease: ");
            String disease = scanner.nextLine();

            System.out.print("Admitted (true/false): ");
            boolean admitted = scanner.nextBoolean();
            scanner.nextLine();

            people.add(new Patient(id, name, age, phone, disease, admitted));
            System.out.println("Patient added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Input error! Please enter the correct type.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void viewAll() {
        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) {
            System.out.println(p);
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : people) {
            p.work();
        }
    }

    private void viewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        for (Person p : people) {
            if (p instanceof Doctor d) {
                System.out.println(d);
            }
        }
    }

    private void viewPatientsOnly() {
        System.out.println("\n--- PATIENTS ONLY ---");
        for (Person p : people) {
            if (p instanceof Patient pat) {
                System.out.println(pat);
            }
        }
    }
}
