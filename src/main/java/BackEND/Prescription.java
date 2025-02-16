package BackEND;

import DatabaseConn.Database_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author EISHA
 */
public class Prescription {
    private String patientId;
    private String doctorId;
    private String appointmentId;
    private String prescriptionId;
    private List<String> medicines; // List of medicines

    // Constructor to initialize values
    public Prescription(String patientId, String doctorId, String appointmentId, String prescriptionId, List<String> medicines) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentId = appointmentId;
        this.prescriptionId = prescriptionId;
        this.medicines = medicines;
    }

    // Method to insert data into the database
    public boolean add() {
        Database_Connection db=new Database_Connection();
        Connection con = db.getConnection(); // Using static method if applicable
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed.");
                return false;
            }

            // Insert into prescription table
            String sql = "INSERT INTO prescription (PresId,PatientId,AppId,DoctorId) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, prescriptionId);
            pstmt.setString(2, patientId);
            pstmt.setString(3, doctorId);
            pstmt.setString(4, appointmentId);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close(); // Close statement to avoid memory leaks

            if (rowsAffected > 0) {
                // Insert medicines into the medicine table (with ENUM type)
                for (String medicine : medicines) {
                    String medicineSql = "INSERT INTO prescription (PresId, Medicines) VALUES (?, ?)";
                    try (PreparedStatement medStmt = con.prepareStatement(medicineSql)) {
                        medStmt.setString(1, prescriptionId);
                        medStmt.setString(2, medicine); // Assuming medicine_name is ENUM type in DB
                        medStmt.executeUpdate();
                    }
                }
                success = true;
                JOptionPane.showMessageDialog(null, "Prescription added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add prescription.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }
}
