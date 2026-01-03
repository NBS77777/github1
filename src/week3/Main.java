package week3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
        patients.add(new Patient(1 , "Baialy Nurassyl" , 17 , "4"));
        patients.add(new Patient(5 , "Orazob Serik" , 25 , "1"));
        doctors.add(new Doctor(8 , "Dr. Arman" , "Surgeon" ,  8));
        doctors.add(new Doctor(8 , "Dr. Aiman" , "Therapist" ,  15));

        boolean running = true;

        while (running){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                    addPatient();
                    break;
                case 2 :
                    ViewAllPatients();
                    break;
                case 3 :
                    AddDoctor ();
                    break;
                case 4 :
                    viewAllDoctors();
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
        System.out.println("\n========================================");
        System.out.println("        HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void ViewAllPatients() {
        System.out.println("\n========================================");
        System.out.println("           ALL PATIENTS");
        System.out.println("========================================");

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ".");
            System.out.println(patients.get(i));
            System.out.println("----------------------------------------");
        }

    }

    private static void addPatient() {
        System.out.println("\n--- ADD PATIENT ---");

        System.out.print("Enter patient ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter full name: ");
        String Name = scanner.nextLine();

        System.out.println("Enter age: ");
        int Age= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter blood type: ");
        String bloodtype = scanner.nextLine();

        Patient patient =new Patient(ID , Name , Age , bloodtype) ;
        patients.add(patient);

        System.out.println("\nPatient added successfully! ");
    }

    private static void AddDoctor() {
        System.out.println("\n--- ADD DOCTOR ---");

        System.out.print("Enter doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter experience years: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization, experience);
        doctors.add(doctor);

        System.out.println("\nDoctor added successfully! ");
    }

    private static void viewAllDoctors() {
        System.out.println("\n========================================");
        System.out.println("           ALL DOCTORS");
        System.out.println("========================================");

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }


        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ".");
            System.out.println(doctors.get(i));
            System.out.println("----------------------------------------");
        }
    }


}