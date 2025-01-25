import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Appointment {
    String app_id, d_id, pat_id, t;
    Date ap_date;

    public Appointment(String app_id, String d_id, String p_id, Date app_date, String app_time) {
        this.app_id = app_id;
        this.d_id = d_id;
        this.pat_id = p_id;
        this.ap_date = app_date;
        this.t = app_time;
    }

    public Appointment() {
    }

    public void Add() {
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();
        String insertQuery = "INSERT INTO appointment (AppId, AppDate, AppTime, PatientId, DoctorId) VALUES (?, ?, ?, ?, ?)";

        // Ensure the time is in the correct format (hh:mm:ss)
        if (t == null || t.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Appointment time cannot be null or empty.");
        return;  // Exit the method if the time is invalid
    }

    // If the time only has "hh:mm", add ":00" to make it a valid time format
    if (t.length() == 5) {
        t = t + ":00";  // Add seconds to the time
    }
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            // Set the values for the PreparedStatement
            stmt.setString(1, app_id);  // Set appointment ID

            // Convert java.util.Date to java.sql.Date
            stmt.setDate(2, new java.sql.Date(ap_date.getTime())); // Set appointment date

            // Set appointment time
            stmt.setTime(3, java.sql.Time.valueOf(t));  // Ensure t is in hh:mm:ss format

            stmt.setString(4, pat_id);   // Set patient ID
            stmt.setString(5, d_id);     // Set doctor ID

            // Execute the insert query
            int rowsAffected = stmt.executeUpdate();

            // Check if the insert was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Appointment added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Unable to add appointment.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
}
