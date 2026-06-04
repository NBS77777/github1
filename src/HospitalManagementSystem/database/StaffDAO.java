package HospitalManagementSystem.database;

import HospitalManagementSystem.model.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public boolean insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO staff(full_name, age, phone, specialization, experience_years, staff_type)" +
                "VALUES (?, ?, ?, ?, ?, 'DOCTOR')";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getFullName());
            statement.setInt(2, doctor.getAge());
            statement.setString(3, doctor.getPhone());
            statement.setString(4, doctor.getSpecialization());
            statement.setInt(5, doctor.getExperienceYears());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                return true;
            }

        }catch (SQLException e){
            System.out.println("Error in inserting Doctor");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean insertPatient(Patient patient) {
        String sql = "INSERT INTO staff(full_name , age , phone ,disease , admitted , staff_type)" +
                "VALUES (?,?,?,?,?'PATIENT')";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFullName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getPhone());
            statement.setString(4, patient.getDisease());
            statement.setBoolean(5, patient.getAdmitted());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                return true;
            }

        }catch (SQLException e){
            System.out.println("Error in inserting Patient");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public List<Staff> getAllStaffs() {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff ORDER BY staff_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return staffs;
        }

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);
                if (staff != null) {
                    staffs.add(staff);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println( " Retrieved " + staffs.size() + " staff from database");

        }catch (SQLException e){
            System.out.println("Get staff failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return staffs;
    }

    public Staff getStaffById(int staffId){
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staffId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);

                if (staff != null) {
                    System.out.println("Found staff with ID: " + staffId);
                }
                return staff;
            }

            resultSet.close();
            statement.close();

        }catch (
                SQLException e){
            System.out.println("Get staff by ID failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE staff_type = 'DOCTOR' ORDER BY staff_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return doctors;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);
                if (staff != null) {
                    doctors.add((Doctor) staff);
                }
            }
            resultSet.close();
            statement.close();

            System.out.println( " Retrieved " + doctors.size() + " doctors from database");

        }catch (SQLException e){
            System.out.println("Get doctors failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return doctors;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT  * FROM staff WHERE staff_type = 'PATIENT' ORDER BY staff_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return patients;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);
                if (staff != null) {
                    patients.add((Patient) staff);
                }
            }
            resultSet.close();
            statement.close();

            System.out.println( " Retrieved " + patients.size() + " patients from database");

        }catch (SQLException e){
            System.out.println("Get patients failed!");
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return patients;
    }

    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE  staff SET full_name = ? , age = ? , phone = ? , specialization = ? , experience_years = ?" +
                " WHERE staff_id = ? AND staff_type = 'DOCTOR'" ;
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctor.getFullName());
            statement.setInt(2, doctor.getAge());
            statement.setString(3, doctor.getPhone());
            statement.setString(4, doctor.getSpecialization());
            statement.setInt(5, doctor.getExperienceYears());
            statement.setInt(6, doctor.getId());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Doctor updated: + doctor.getFullName()");
                return true;
            }else  {
                System.out.println("No Patient found with ID: + patient.getId()");
            }

        }catch (SQLException e){
            System.out.println("Update doctor failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean updatePatient(Patient patient){
        String sql = "UPDATE staff SET full_name = ? , age = ? , phone = ? , disease = ? , admitted = ?" +
                "WHERE  staff_id = ? AND staff_type = 'PATIENT'";
        Connection connection = DatabaseConnection.getConnection();
        if(connection == null){
            return  false;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFullName());
            statement.setInt(2 , patient.getAge());
            statement.setString(1 , patient.getPhone());
            statement.setString(3 , patient.getDisease());
            statement.setBoolean(5 , patient.getAdmitted());
            statement.setInt(6 , patient.getId());

            int rowUp = statement.executeUpdate();
            if(rowUp > 0 ){
                System.out.println("Updatede patient" + patient.getFullName());
                return true;
            }

        }catch (SQLException e){
            System.out.println("Update patient filede");
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean deletestaff(int staffId) {
        String sql = "DELETE  FROM staff WHERE staff_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null){
            return false;
        }

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1 , staffId);
            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Deleted staff" + staffId);
                return true;
            }

        }catch (SQLException e){
            System.out.println("Delete filed");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }


    public List<Staff> searchByName(String name) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM STAFF WHERE full_name ILIKE ? ORDER BY full_name";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return staffs;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,'%' + name + '%');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);
                if (staff != null) {
                    staffs.add(staff);
                }
            }
            resultSet.close();
            statement.close();

            System.out.println( " Retrieved " + staffs.size() + " staffs from database");

        }catch (SQLException e){
            System.out.println("Get staffs failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return staffs;
    }

    public List<Staff> searchByDoctorExperienceYears(int minYears, int  maxYears) {
        List<Staff> staffs = new ArrayList<>();
        String sql ="SELECT * FROM staff WHERE staff_type = 'DOCTOR' AND experience_years BETWEEN ? AND ? ORDER BY experience_years DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null)
            return staffs;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minYears);
            statement.setInt(2, maxYears);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Staff staff = extractStaffFromResultSet(rs);
                if (staff != null) {
                    staffs.add(staff);
                }
            }
            rs.close();
            statement.close();

            System.out.println("Found " + staffs.size() + " doctors with experience between " + minYears + " and " + maxYears);

        }catch (
                SQLException e) {
            System.out.println("Search by doctor experience failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return staffs;
    }

    public List<Staff> searchByMinExperienceYears(int minYears) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE staff_type = 'DOCTOR' AND experience_years >= ? ORDER BY experience_years DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null)
            return staffs;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minYears);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Staff staff = extractStaffFromResultSet(rs);
                if (staff != null) {
                    staffs.add(staff);
                }
            }
            rs.close();
            statement.close();

            System.out.println("Found " + staffs.size() + " doctors with experience >= " + minYears);


        }catch (SQLException e) {
            System.out.println("Search by minimum experience years failed!");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return  staffs;
    }

    private Staff extractStaffFromResultSet(ResultSet resultSet) throws SQLException{
        int  staffid = resultSet.getInt("staff_id");
        String fullName = resultSet.getString("full_Name");
        int age = resultSet.getInt("age");
        String phone = resultSet.getString("phone");
        String staffType = resultSet.getString("staff_Type");

        Staff staff = null;

        if("DOCTOR".equalsIgnoreCase(staffType)){
            String specialization = resultSet.getString("specialization");
            int experienceYears = resultSet.getInt("experience_years");
            return new Doctor(staffid, fullName, age, phone, specialization, experienceYears);
        }else if("PATIENT".equalsIgnoreCase(staffType)){
            String disease = resultSet.getString(("disease"));
            boolean admitted = resultSet.getBoolean("admitted");
            return new Patient(staffid,fullName, age, phone, disease, admitted);
        }
        return staff;
    }
}
