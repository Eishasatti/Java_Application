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

