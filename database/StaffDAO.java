package database;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO {
    public boolean insertDoctor(Doctor doctor) {

        String sql = "INSERT INTO staff (name, role,specialization, experience, salary) " +
                "VALUES (?, 'DOCTOR',?,?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
            statement.setInt(3, doctor.getExperience());
            statement.setDouble(4, doctor.getSalary());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Doctor inserted: " + doctor.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Doctor failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public boolean insertNurse(Nurse nurse) {

        String sql = "INSERT INTO staff (name, role, specialization , experience, salary) " +
                "VALUES (?, 'NURSE', ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nurse.getName());
            statement.setString(2, nurse.getSpecialization());
            statement.setDouble(3, nurse.getSalary());
            statement.setInt(4, nurse.getExperience());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Nurse inserted: " + nurse.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Patient failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public void viewAllStaff() {
        String sql = "SELECT * FROM staff";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("\n--- ALL STAFF FROM DATABASE ---");
            while (rs.next()) {
                int id = rs.getInt("staff_id");
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");
                double salary = rs.getDouble("salary");
                int experience = rs.getInt("experience");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialization: " + specialization);
                System.out.println("Salary: " + salary);
                System.out.println("Experience: " + experience + " years");
                System.out.println("---");
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void demonstratePolymorphism() {

        String sql = "SELECT * FROM staff";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            System.out.println("\n=== POLYMORPHISM FROM DATABASE ===");

            while (rs.next()) {

                String role = rs.getString("role");
                String name = rs.getString("name");

                if ("DOCTOR".equals(role)) {
                    String specialization = rs.getString("specialization");
                    System.out.println("Doctor " + name + " performs operation related to " + specialization);
                } else if ("NURSE".equals(role)) {
                    String specialization = rs.getString("specialization");
                    System.out.println("Nurse " + name + " takes care of " + specialization + "patients");
                }
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void viewDoctors() {

        String sql = "SELECT * FROM staff WHERE role = 'DOCTOR'";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            System.out.println("\n=== DOCTORS ===");

            while (rs.next()) {
                System.out.println("Doctor: " + rs.getString("name"));
                System.out.println("Experience: " + rs.getInt("experience") + " years");
                System.out.println("Specialization: " + rs.getString("specialization"));
                System.out.println("----------------------");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void viewNurse() {

        String sql = "SELECT * FROM staff WHERE role = 'NURSE'";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            System.out.println("\n=== NURSES ===");

            while (rs.next()) {
                System.out.println("Nurse: " + rs.getString("name"));
                System.out.println("Experience: " + rs.getString("experience"));
                System.out.println("Specialization: " + rs.getString("specialization"));
                System.out.println("----------------------");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE staff SET name = ?, specialization = ?, experience = ?, salary = ? " +
                "WHERE staff_id = ? AND role = 'DOCTOR'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, doctor.getName());
            statement.setDouble(2, doctor.getSalary());
            statement.setString(3, doctor.getSpecialization());
            statement.setInt(4, doctor.getExperience());
            statement.setInt(5, doctor.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Doctor updated: " + doctor.getName());
                return true;
            } else {
                System.out.println("⚠️ No doctor found with ID: " + doctor.getId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Doctor failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public boolean updateNurse(Nurse nurse) {

        String sql = "UPDATE staff SET name = ?, specialization = ?, experience = ?, salary = ? " +
                "WHERE staff_id = ? AND role = 'NURSE'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nurse.getName());
            statement.setDouble(2, nurse.getSalary());
            statement.setString(3, nurse.getSpecialization());
            statement.setInt(4, nurse.getExperience());
            statement.setInt(5, nurse.getId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Nurse updated: " + nurse.getName());
                return true;
            } else {
                System.out.println("⚠️ No nurse found with ID: " + nurse.getId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Nurse failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public Staff getStaffById(int staffId) {

        String sql = "SELECT * FROM staff WHERE staff_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staffId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Staff staff = extractStaffFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (staff != null) {
                    System.out.println("✅ Found staff with ID: " + staffId);
                }

                return staff;
            }

            System.out.println("⚠️ No staff found with ID: " + staffId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }
    private Staff extractStaffFromResultSet(ResultSet rs) throws SQLException {

        int id = rs.getInt("staff_id");
        String name = rs.getString("name");
        String specialization = rs.getString("specialization");
        String role = rs.getString("role");
        int salary = rs.getInt("salary");
        int experience = rs.getInt("experience");
        Staff staff = null;

        try {
            if ("DOCTOR".equals(role)) {

                staff = new Doctor(id, name, specialization,salary ,experience);

            } else if ("NURSE".equals(role)) {


                staff = new Nurse(id, name, specialization,salary,experience);
            }

        } catch (Exception e) {
            System.out.println("❌ Object creation failed!");
            e.printStackTrace();
        }

        return staff;
    }
    public boolean deleteStaff(int staffId) {

        String sql = "DELETE FROM staff WHERE staff_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, staffId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ Staff deleted (ID: " + staffId + ")");
                return true;
            } else {
                System.out.println("⚠️ No staff found with ID: " + staffId);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public void searchByName(String name) {

        String sql = "SELECT * FROM staff WHERE name ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            boolean found = false;

            System.out.println("\n=== SEARCH RESULTS ===");

            while (rs.next()) {
                found = true;

                int id = rs.getInt("staff_id");
                String staffName = rs.getString("name");
                String experience = rs.getString("experience");
                String role = rs.getString("role");

                System.out.println("ID: " + id + " | Name: " + staffName + " | Experience: " + experience + " | Role: " + role);

                if ("DOCTOR".equals(role)) {
                    System.out.println("Specialization: " + rs.getString("specialization"));
                    System.out.println("Salary: " + rs.getDouble("salary"));
                } else {
                    System.out.println("Specialization: " + rs.getString("specialization"));
                    System.out.println("Salary: " + rs.getDouble("salary"));
                }

                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No staff found matching '" + name + "'");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void searchDoctorsByExperienceRange(int minExp, int maxExp) {

        String sql = "SELECT * FROM staff WHERE role = 'DOCTOR' AND experience BETWEEN ? AND ? ORDER BY experience DESC";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minExp);
            statement.setInt(2, maxExp);

            ResultSet rs = statement.executeQuery();

            boolean found = false;

            System.out.println("\n=== DOCTORS EXPERIENCE " + minExp + " - " + maxExp + " YEARS ===");

            while (rs.next()) {
                found = true;

                System.out.println("ID: " + rs.getInt("staff_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Experience: " + rs.getInt("experience") + " years");
                System.out.println("Specialization: " + rs.getString("specialization"));
                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No doctors found in this experience range.");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public void searchDoctorsByMinExperience(int minExp) {

        String sql = "SELECT * FROM staff WHERE role = 'DOCTOR' AND experience >= ? ORDER BY experience DESC";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minExp);

            ResultSet rs = statement.executeQuery();

            boolean found = false;

            System.out.println("\n=== DOCTORS WITH EXPERIENCE >= " + minExp + " YEARS ===");

            while (rs.next()) {
                found = true;

                System.out.println("ID: " + rs.getInt("staff_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Experience: " + rs.getInt("experience") + " years");
                System.out.println("Specialization: " + rs.getString("specialization"));
                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No doctors found.");
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}