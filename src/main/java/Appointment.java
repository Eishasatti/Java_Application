
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Appointment {

    String app_id, d_id, pat_id, t;
    Date ap_date;

    public Appointment(String app_id, String d_id, String p_id, Date app_date, String app_time) {
        this.app_id = app_id;
        this.d_id = d_id;
        this.pat_id = p_id;
        this.ap_date = app_date;
        this.t = app_time;
        if (t.length() == 5) {
            t = t + ":00";  // Add seconds to the time
        }
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

    public void Delete(String Ap_id) {

        String Appoint_id = Ap_id;
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();
        String deleteQuery = "DELETE FROM appointment WHERE AppId = ?";

        // Check if appointment ID is null or empty
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            // Set the value for the PreparedStatement
            stmt.setString(1, Appoint_id);  // Set the appointment ID

            // Execute the delete query
            int rowsAffected = stmt.executeUpdate();

            // Check if the delete was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Appointment deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Appointment not found or unable to delete.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
    public String getPatientIdByAppointmentId(String appointmentId) {
    String patientId = null;

    // Establish database connection
    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();

    try {
        // SQL query to fetch PatientId for the selected AppointmentId
        String query = "SELECT PatientId FROM appointment WHERE AppId = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, appointmentId); // Set the appointment ID parameter
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Fetch the Patient ID
            patientId = rs.getString("PatientId");
        }
    } catch (SQLException e) {
        // Handle SQL exception
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close the database connection
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    return patientId;
}

      public ArrayList<String> getAppointmentList() {
               ArrayList<String> appointmentIds = new ArrayList<>();
 
    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();
    try {
        String query = "SELECT AppId FROM appointment"; // Replace with your table and column names
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // Get the appointment ID
            String appointmentId = rs.getString("AppId");
            
            // Add the appointment ID to the list
            appointmentIds.add(appointmentId);
        }
    } catch (SQLException e) {
                   // Add proper error handling
                    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    
                   
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
    // Proper error handling with JOptionPane
    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    
}

    }
    return appointmentIds;
}

      public ArrayList<String> getPaidAppointmentList() {
    ArrayList<String> appointmentIds = new ArrayList<>();

    // Establish database connection
    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();

    try {
        // SQL query to select appointment IDs where payment status is 'Paid'
        String query = "SELECT AppId FROM payment WHERE PayStatus = 'Paid'";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        // Loop through the result set and add IDs to the list
        while (rs.next()) {
            String appointmentId = rs.getString("AppId");
            appointmentIds.add(appointmentId);
        }
    } catch (SQLException e) {
        // Handle SQL exception with a message dialog
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close the database connection
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    return appointmentIds;
}

    public void Update() {
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();
        String updateQuery = "UPDATE appointment SET AppDate = ?, AppTime = ?, PatientId = ?, DoctorId = ? WHERE AppId = ?";

        // Ensure the time is in the correct format (hh:mm:ss)
        try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            // Set the values for the PreparedStatement
            // Set new appointment date
            stmt.setDate(1, new java.sql.Date(ap_date.getTime())); // Set appointment date
            stmt.setTime(2, java.sql.Time.valueOf(t));  // Set new appointment time
            stmt.setString(3, pat_id);   // Set new patient ID
            stmt.setString(4, d_id);    // Set new doctor ID
            stmt.setString(5, app_id);     // Set the appointment ID

            // Execute the update query
            int rowsAffected = stmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Appointment updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Appointment not found or unable to update.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }

    public void SearchByAppIdInTable(String appId) {
        // Ensure the AppId is not null or empty

        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();
        String searchQuery = "SELECT AppId, AppDate, AppTime, PatientId, DoctorId FROM appointment WHERE AppId = ?";

        // Define the columns for the JTable
        String[] columnNames = {"AppId", "AppDate", "AppTime", "PatientId", "DoctorId"};

        // Create a model for the JTable with column names and no data initially
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
            // Set the AppId for the query
            stmt.setString(1, appId);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Check if the appointment is found
            if (rs.next()) {
                // Retrieve appointment details
                String appDate = rs.getString("AppDate");
                String appTime = rs.getString("AppTime");
                String patientId = rs.getString("PatientId");
                String doctorId = rs.getString("DoctorId");

                // Add the retrieved data to the JTable model
                Object[] row = {appId, appDate, appTime, patientId, doctorId};
                tableModel.addRow(row);

                // Create and display the JTable with the model
                JTable table = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(table); // Add scroll bar to the table

                // Display the JTable in a JOptionPane or in your GUI (example: in a new JFrame)
                JFrame frame = new JFrame("Appointment Details");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(600, 300);
                frame.add(scrollPane);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No appointment found with the provided ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }

    public void SearchAllAppointments() {
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();
        String searchQuery = "SELECT AppId, AppDate, AppTime, PatientId, DoctorId FROM appointment";

        // Define the columns for the JTable
        String[] columnNames = {"AppId", "AppDate", "AppTime", "PatientId", "DoctorId"};

        // Create a model for the JTable with column names and no data initially
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
            // Execute the query to retrieve all appointments
            ResultSet rs = stmt.executeQuery();

            // Check if there are any results
            while (rs.next()) {
                // Retrieve appointment details for each row
                String appId = rs.getString("AppId");
                String appDate = rs.getString("AppDate");
                String appTime = rs.getString("AppTime");
                String patientId = rs.getString("PatientId");
                String doctorId = rs.getString("DoctorId");

                // Add the retrieved data as a row to the JTable model
                Object[] row = {appId, appDate, appTime, patientId, doctorId};
                tableModel.addRow(row);
            }

            // Create and display the JTable with the model
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table); // Add scroll bar to the table

            // Display the JTable in a JOptionPane or in your GUI (example: in a new JFrame)
            JFrame frame = new JFrame("All Appointment Details");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(scrollPane);
            frame.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
}
