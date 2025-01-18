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
public class Receptionist {
    public void Login(String u_id, String password, String role) {
        Database_Connection dbcon = new Database_Connection();
        try {
            String query = "SELECT * FROM receptionist WHERE receptionist_id = ? AND password = ? AND role = ?";
            Connection con = dbcon.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, u_id);
                pstmt.setString(2, password);
                pstmt.setString(3, role);

                boolean receptionistExists = pstmt.executeQuery().next();

                if (receptionistExists) {
                    JOptionPane.showMessageDialog(null, "Receptionist login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new ReceptionistInterface().setVisible(true); // Redirect to Receptionist Dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Receptionist credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to validate Receptionist login", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            dbcon.closeConnection();
        }
    }
}

