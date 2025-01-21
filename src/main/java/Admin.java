/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EISHA
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Admin {

    String a_id, a_name, a_gender, a_email, a_role, a_password;
    long a_num;

    public Admin() {

    }

    public Admin(String id, String name, String gender, long phone, String role, String email, String password) {
        a_id = id;
        a_name = name;
        a_gender = gender;
        a_email = email;
        a_role = role;
        a_password = password;
        a_num = phone;
    }

    public void Add() {

        Database_Connection dbConnection = new Database_Connection();
        Connection con = dbConnection.getConnection();

        // Insert query
        String insertQuery = "INSERT INTO admin (AdminId, Name, Gender, Phoneno, Role,Email, Password) VALUES (?, ?, ?, ?, ?,?, ?)";

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

            // Set values dynamically
            preparedStatement.setString(1, a_id);
            preparedStatement.setString(2, a_name);
            preparedStatement.setString(3, a_gender);
            preparedStatement.setLong(4, a_num); // Assuming phone is a numeric type in your database
            preparedStatement.setString(5, a_role);
            preparedStatement.setString(6, a_email);
            preparedStatement.setString(7, a_password);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if insertion was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Admin record added successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add admin record. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while adding admin record: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }

    public void Upadte() {
        Database_Connection dbConnection = new Database_Connection();
        Connection con = dbConnection.getConnection();

        // Update query
        String updateQuery = "UPDATE admin SET Name = ?, Gender = ?, Phoneno = ?, Role = ?, Email = ?, Password = ? WHERE AdminId = ?";

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

            // Set values dynamically
            preparedStatement.setString(1, a_id);
            preparedStatement.setString(2, a_name);
            preparedStatement.setString(3, a_gender);
            preparedStatement.setLong(4, a_num); 
            preparedStatement.setString(5, a_role);
            preparedStatement.setString(6, a_email);
            preparedStatement.setString(7, a_password);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if update was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Admin record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update admin record. Please check the AdminId.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while updating admin record: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }

    public void Delete() {
         // Establish database connection
            Database_Connection dbConnection = new Database_Connection();
            Connection con = dbConnection.getConnection();

            // Delete query
            String deleteQuery = "DELETE FROM admin WHERE AdminId = ?";

            try {
                // Prepare the statement
                PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);

                // Set the AdminId value
                preparedStatement.setString(1, a_id);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check if the deletion was successful
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Admin record deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete the admin record. Please check the AdminId.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error occurred while deleting the admin record: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // Close the database connection
                dbConnection.closeConnection();
            }

    }
//    public void Search(){
//         Database_Connection dbConnection = new Database_Connection();
//    Connection con = dbConnection.getConnection();
//
//    // Search query
//    String searchQuery = "SELECT * FROM admin WHERE AdminId = ?";
//     try {
//        // Prepare the statement
//        PreparedStatement preparedStatement = con.prepareStatement(searchQuery);
//
//        // Set the AdminId value
//        preparedStatement.setString(1, a_id);
//
//        // Execute the query
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        // Check if a record was found
//        if (resultSet.next()) {
//            // Retrieve the admin data from the result set and display in the form
//            String adminId = resultSet.getString("AdminId");
//            String username = resultSet.getString("Name");
//            String phonenoad= resultSet.getString("Phoneno");
//            
//            String password= resultSet.getString("Password");
//            
//            String email_admin=resultSet.getString("Email")
//;
//            
//            // Set the form fields with the retrieved values
//            a_id.setText(adminId);
//            a_name.setText(username);
//            a_num.setText(phonenoad);
//           add_email.setText(email_admin);
//           admin_pass.setText(password);
//            
//        } else {
//            JOptionPane.showMessageDialog(null, "No admin found with the given AdminId.");
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Error occurred while searching for the admin record: " + e.getMessage());
//        e.printStackTrace();
//    } finally {
//        // Close the database connection
//        dbConnection.closeConnection();
//    }
//        
//    }
//    

    public void Login(String u_id, String password, String role) {
        Database_Connection dbcon = new Database_Connection();
        try {
            String query = "SELECT * FROM admin WHERE admin_id = ? AND password = ? AND role = ?";
            Connection con = dbcon.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, u_id);
                pstmt.setString(2, password);
                pstmt.setString(3, role);

                boolean adminExists = pstmt.executeQuery().next();

                if (adminExists) {
                    JOptionPane.showMessageDialog(null, "Admin login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new AdminInterface().setVisible(true); // Redirect to Admin Dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Admin credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to validate Admin login", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            dbcon.closeConnection();
        }
    }
}
