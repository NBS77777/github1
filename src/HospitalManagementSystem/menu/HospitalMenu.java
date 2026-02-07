package HospitalManagementSystem.menu;

import HospitalManagementSystem.model.Doctor;
import HospitalManagementSystem.model.Patient;
import HospitalManagementSystem.database.*;
import HospitalManagementSystem.model.Staff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {

    private StaffDAO staffDAO;
    private Scanner scanner;

    public HospitalMenu() {
        staffDAO = new StaffDAO();
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║ HOSPITAL MANAGEMENT SYSTEM             ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ STAFF MANAGEMENT ─────────────────────┐");
        System.out.println("│ 1. Add Doctor                          │");
        System.out.println("│ 2. Add Patient                         │");
        System.out.println("│ 3. View All                            │");
        System.out.println("│ 4. View Doctors Only                   │");
        System.out.println("│ 5. View Patients Only                  │");
        System.out.println("│ 6. Update Steff                        │");
        System.out.println("│ 7. Delete Staff                        │");
        System.out.println("├─ SEARCH & FILTER ──────────────────────┤");
        System.out.println("│ 8. Search by Name                      │");
        System.out.println("│ 9. Search Doctor by Experience Range   │");
        System.out.println("│ 10. Doctors with Experience >= X Years │");
        System.out.println("├─ DEMO & OTHER ─────────────────────────┤");
        System.out.println("│ 11. Polymorphism Demo                  │");
        System.out.println("│ 0. Exit                                │");
        System.out.println("└────────────────────────────────────────┘");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
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
                        viewDoctorsOnly();
                        break;
                    case 5:
                        viewPatientsOnly();
                        break;
                    case 6:
                        updateStaff();
                        break;
                    case 7:
                        deleteStaff();
                        break;
                    case 8:
                        searchByName();
                        break;
                    case 9:
                        searchByDoctorExperienceYears();
                        break;
                    case 10:
                        searchByMinExperienceYears();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!       ║");
                        System.out.println("║  Goodbye!                              ║");
                        System.out.println("╚════════════════════════════════════════╝");
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
        try{
            System.out.println("\n ADD DOCTOR ");

            System.out.print(" Enter Doctor ID: ");
            int id  = scanner.nextInt();
            scanner.nextLine();

            System.out.print(" Enter Full Name: ");
            String name = scanner.nextLine();

            System.out.println(" Enter age: ");

            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println(" Enter phone number: ");
            String phoneNumber = scanner.nextLine();


            System.out.println(" Enter specialization: ");
            String specialization = scanner.nextLine();

            System.out.println(" Enter experience Years: ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine();

            Doctor doctor = new Doctor(id ,name, age, phoneNumber, specialization, experienceYears);
            staffDAO.insertDoctor(doctor);

            System.out.println(" Patient added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
        }catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }
    }

    private void addPatient() {
        try {
            System.out.println("\n ADD PATIENT  ");

            System.out.print(" Enter Patient ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print(" Enter Full Name: ");
            String name = scanner.nextLine();

            System.out.print(" Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print(" Enter Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print(" Enter Disease: ");
            String disease = scanner.nextLine();

            System.out.print(" Admitted (true/false): ");
            boolean admitted = scanner.nextBoolean();
            scanner.nextLine();

            Patient patient = new Patient(id, name, age, phone, disease, admitted);
            staffDAO.insertPatient(patient);
            System.out.println(" Patient added successfully!");

    } catch (InputMismatchException e) {
            System.out.println("Input error! Please enter the correct type.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void viewAll(){
        System.out.println("======= VIEW ALl =======");
        List<Staff>staffs = staffDAO.getAllStaffs();
        if  (staffs.isEmpty()){
            System.out.println("No staffs found!");
        }else {
            for (int i = 0 ;  i < staffs.size() ; i++ ){
                Staff staff = staffs.get(i);
                System.out.println((i +1) + ". ");
                System.out.println("[" + staff.getRole() + "]");
                System.out.println(staff.toString());
            }
        }
    }

    private void viewDoctorsOnly() {
        List<Doctor> doctors = staffDAO.getAllDoctors();

        System.out.println(" DOCTORS ONLY ");


        if(doctors.isEmpty()){
            System.out.println("NO DOCTOR FOUND");
        }else{
            for (int i = 0 ; i < doctors.size() ; i++){
                Doctor doctor = doctors.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println("[" + doctor.getRole() + "]");
                System.out.println(doctor.toString());
            }
            System.out.println();
        }
        System.out.println("Total Chefs: " + doctors.size());
    }

    private void viewPatientsOnly() {
        List<Patient> patients = staffDAO.getAllPatients();

        System.out.println(" ======== PATIENS ONLY ====== ");

        if(patients.isEmpty()){
            System.out.println("NO PATIENS FOUND");
        }else{
            for (int i = 0 ; i < patients.size() ; i++){
                Patient patient = patients.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println("[" + patient.getRole() + "]");
                System.out.println(patient.toString());
            }
            System.out.println();
        }
        System.out.println("Total Patients: " + patients.size());
    }

    private void updateStaff() {
        try {
            System.out.println("\n ======= UPDATE STAFF ======= ");

            System.out.print(" Enter Staff ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Staff staff = staffDAO.getStaffById(id);

            if (staff == null) {
                System.out.println(" Staff not found!");
                return;
            }

            System.out.println(" Found: " + staff.getRole());
            System.out.println(" Current info:");
            System.out.println(staff);

            // UPDATE DOCTOR
            if (staff instanceof Doctor) {
                Doctor doctor = (Doctor) staff;

                System.out.print(" Enter new Full Name: ");
                String name = scanner.nextLine();

                System.out.print(" Enter new Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print(" Enter new Phone: ");
                String phone = scanner.nextLine();

                System.out.print(" Enter new Specialization: ");
                String specialization = scanner.nextLine();

                System.out.print(" Enter new Experience Years: ");
                int exp = scanner.nextInt();
                scanner.nextLine();

                Doctor updatedDoctor = new Doctor(
                        id, name, age, phone, specialization, exp
                );

                staffDAO.updateDoctor(updatedDoctor);
                System.out.println(" Doctor updated successfully!");
            }


            // UPDATE PATIENT
            else if (staff instanceof Patient) {
                Patient patient = (Patient) staff;

                System.out.print(" Enter new Full Name: ");
                String name = scanner.nextLine();

                System.out.print(" Enter new Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print(" Enter new Phone: ");
                String phone = scanner.nextLine();

                System.out.print(" Enter new Disease: ");
                String disease = scanner.nextLine();

                System.out.print(" Admitted (true/false): ");
                boolean admitted = scanner.nextBoolean();
                scanner.nextLine();

                Patient updatedPatient = new Patient(
                        id, name, age, phone, disease, admitted
                );

                staffDAO.updatePatient(updatedPatient);
                System.out.println(" Patient updated successfully!");
            }

        } catch (Exception e) {
            System.out.println("Update failed!");
            scanner.nextLine();
        }
    }

    private  void deleteStaff(){
        try {
            System.out.println("\n DELETE STAFF ");

            System.out.println(" Enter Staff ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Staff staff = staffDAO.getStaffById(id);
            if (staff == null) {
                System.out.println("Staff not found!");
                return;
            }

            System.out.println(" Found: " + staff.getRole());
            System.out.println(staff);

            System.out.print(" Are you sure you want to delete? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equals("yes")) {
                System.out.println("Deletion cancelled.");
                return;
            }

            boolean deleted = staffDAO.deletestaff(id);
            if (confirm.equalsIgnoreCase("yes")) {
                staffDAO.deletestaff(id);
            }else  {
                System.out.println("Deletion failed!");
            }
        }catch (Exception e){
            System.out.println("Error deleting staff!");
            scanner.nextLine();
        }
    }

    private void searchByName(){
        System.out.println("\n SEARCH BY NAME ");
        System.out.print(" Enter name to search: ");
        String name = scanner.nextLine();

        List<Staff> results = staffDAO.searchByName(name);
        displaySearchResult(results, "Search: " + name );
    }

    private void displaySearchResult(List<Staff> results , String criteria){
        System.out.println(" SEARCH RESULTS ");

        System.out.println("Criteria" + criteria);

        if (results.isEmpty()){
            System.out.println("No staff found matching criteria.");
        }else  {
            for (int i = 0 ; i < results.size() ; i++) {
                Staff s = results.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println("[" + s.getRole() + "]");
                System.out.println(s.toString());
            }
            System.out.println("Total Results: " + results.size());
        }
    }

    private void searchByDoctorExperienceYears(){
        try {
            System.out.println("\n SEARCH BY DOCTOR EXPERIENCE YEARS ");
            System.out.print(" Enter min experience years: ");
            int minYears = scanner.nextInt();
            scanner.nextLine();

            System.out.print(" Enter max experience years: ");
            int maxYears = scanner.nextInt();
            scanner.nextLine();

            List<Staff> s = staffDAO.searchByDoctorExperienceYears(minYears, maxYears);
            displaySearchResult(s, " Search: " + minYears + " - " + maxYears);
        }catch (Exception e){
            System.out.println("Error: during search!");
            scanner.nextLine();
        }
    }

    private void searchByMinExperienceYears(){
        try {
            System.out.println("\n SEARCH BY DOCTOR MIN EXPERIENCE YEARS ");
            System.out.print(" Enter min experience years: ");
            int minYears = scanner.nextInt();
            scanner.nextLine();

            List<Staff> s = staffDAO.searchByMinExperienceYears(minYears);
            displaySearchResult(s, "Search: " + minYears);
        }catch (Exception e){
            System.out.println("Error: during search!");
            scanner.nextLine();
        }
    }

    private void demonstratePolymorphism() {
        List<Staff> staffs = staffDAO.getAllStaffs();
        System.out.println("  POLYMORPHISM: Staff from Database");

        if(staffs.isEmpty()){
            System.out.println("NO STAFF FOUND");
        }else{
            for(Staff s: staffs){
                s.work();
            }
        }
    }
}