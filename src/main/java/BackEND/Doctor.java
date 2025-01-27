package BackEND;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EISHA
 */
import frontendpages.DoctorInterface;
import DatabaseConn.Database_Connection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Doctor {

    String doctor_id, d_name, d_gender, d_spec, d_role, d_pass;
    int d_exp, d_room;
    long d_num;

    public Doctor() {

    }

   

public Doctor(String doc_id,String doc_name,int doc_exp,int doc_room,String doc_gender,long doc_number,String doc_spec,String 
            doc_role,String doc_pass){
        doctor_id=doc_id;
        d_name=doc_name;
        d_gender=doc_gender;
        d_spec=doc_spec;
        d_exp=doc_exp;
        d_room=doc_room;
        d_num=doc_number;
        d_role=doc_role;
        d_pass=doc_pass;
        

}
public ArrayList<ArrayList<String>> getDoctorList() {
    ArrayList<ArrayList<String>> doctorDetails = new ArrayList<>();

    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();
    try {
        String query = "SELECT DoctorId, Name FROM doctor"; // Replace with your table and column name
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // Create an inner list for each doctor
            ArrayList<String> doctor = new ArrayList<>();
            String doctorId = rs.getString("DoctorId");
            String doctorName = rs.getString("Name");

            // Add ID first, then Name
            doctor.add(doctorId);
            doctor.add(doctorName);

            // Add the inner list to the main list
            doctorDetails.add(doctor);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Add proper error handling
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Add proper error handling
        }
    }
    return doctorDetails;
}

    public void AddToDB(){
        
         Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();
    
    String query = "INSERT INTO doctor (DoctorId, Name, Experience,DocRoomNo,Gender,Phoneno,Specialization,Role,Password) " +
                   "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the values from user inputs
        stmt.setString(1, doctor_id);
        stmt.setString(2,d_name );
        stmt.setInt(3, d_exp);
        stmt.setInt(4, d_room );
        stmt.setString(5, d_gender);
        stmt.setLong(6, d_num);
        stmt.setString(7, d_spec);
        stmt.setString(8,d_role);
        stmt.setString(9,d_pass);

        // Execute the query and check if the insertion was successful
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Doctor information added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add doctor information.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    finally{
        dbConnection.closeConnection();
    }
            
    }
    

    public void UpdateDb(){
         Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();

        String query = "UPDATE doctor SET Name = ?, Experience = ?, DocRoomNo = ?, Gender = ?, Phoneno = ?, Specialization = ?, Role = ?, Password = ? " +
                       "WHERE DoctorId = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set the values from user inputs
        stmt.setString(1, doctor_id);
        stmt.setString(2,d_name );
        stmt.setInt(3, d_exp);
        stmt.setInt(4, d_room );
        stmt.setString(5, d_gender);
        stmt.setLong(6, d_num);
        stmt.setString(7, d_spec);
        stmt.setString(8,d_role);
        stmt.setString(9,d_pass); 
            // Execute the update and check if it was successful
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Doctor information updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update doctor information. Doctor ID might be incorrect.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }
    
    public void Delete(String ddid){
        String did_id=ddid;
         Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();
 String query = "DELETE FROM doctor WHERE DoctorId = ?";

  try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the doctorID for the DELETE operation
        stmt.setString(1, did_id);

        // Execute the delete query and check if the deletion was successful
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Doctor information deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete doctor information. Doctor ID may not exist.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }
    
public void Search(String dod) {
    String dod_id = dod;
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    String query = "SELECT * FROM doctor WHERE DoctorId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the DoctorId for the SELECT operation
        stmt.setString(1, dod_id);

        // Execute the query and get the result
        ResultSet rs = stmt.executeQuery();

        // Create a JTable to display the result
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model
        tableModel.addColumn("DoctorId");
        tableModel.addColumn("Name");
        tableModel.addColumn("Experience");
        tableModel.addColumn("Room No");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Specialization");
        tableModel.addColumn("Role");
        tableModel.addColumn("Password");

        // Populate the table model with data from the ResultSet
        if (rs.next()) {
            do {
                tableModel.addRow(new Object[]{
                    dod_id,
                    rs.getString("Name"),
                    rs.getInt("Experience"),
                    rs.getInt("DocRoomNo"),
                    rs.getString("Gender"),
                    rs.getLong("Phoneno"),
                    rs.getString("Specialization"),
                    rs.getString("Role"),
                    rs.getString("Password")
                });
            } while (rs.next());
        } else {
            JOptionPane.showMessageDialog(null, "Doctor with the given ID not found.");
            return; // Exit the method if no data is found
        }

        // Set the model to the JTable
        table.setModel(tableModel);

        // Display the JTable in a JScrollPane for better usability
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a new JFrame to display the table
        JFrame tableFrame = new JFrame("Doctor Details");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.add(scrollPane);
        tableFrame.setSize(800, 300);
        tableFrame.setLocationRelativeTo(null); // Center the frame
        tableFrame.setVisible(true);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}
public void SearchAllDoctors() {
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    String query = "SELECT * FROM doctor";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Execute the query and get the result
        ResultSet rs = stmt.executeQuery();

        // Create a JTable to display the result
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model
        tableModel.addColumn("DoctorId");
        tableModel.addColumn("Name");
        tableModel.addColumn("Experience");
        tableModel.addColumn("Room No");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Specialization");
        tableModel.addColumn("Role");
        tableModel.addColumn("Password");

        // Populate the table model with data from the ResultSet
        while (rs.next()) {
            tableModel.addRow(new Object[]{
                rs.getString("DoctorId"),
                rs.getString("Name"),
                rs.getInt("Experience"),
                rs.getInt("DocRoomNo"),
                rs.getString("Gender"),
                rs.getLong("Phoneno"),
                rs.getString("Specialization"),
                rs.getString("Role"),
                rs.getString("Password")
            });
        }

        // Set the model to the JTable
        table.setModel(tableModel);

        // Display the JTable in a JScrollPane for better usability
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a new JFrame to display the table
        JFrame tableFrame = new JFrame("All Doctor Details");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.add(scrollPane);
        tableFrame.setSize(800, 300);
        tableFrame.setLocationRelativeTo(null); // Center the frame
        tableFrame.setVisible(true);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}
public String getDoctorRoomNumber(String appointmentId, String patientId) {
    String docRoomNo = null;

    // Establish database connection
    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();

    try {
        // SQL query to fetch Doctor Room Number
        String query = "SELECT d.DocRoomNo " +
                       "FROM appointment a " +
                       "JOIN doctor d ON a.DoctorId = d.DoctorId " +
                       "WHERE a.AppId = ? AND a.PatientId = ?";

        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, appointmentId); // Set the Appointment ID
        pstmt.setString(2, patientId);    // Set the Patient ID
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Fetch the Doctor Room Number
            docRoomNo = rs.getString("DocRoomNo");
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

    return docRoomNo;
}

    public void Login(String u_id, String password, String role) {
        doctor_id=u_id;
        d_pass=password;
        d_role=role;
        Database_Connection dbcon = new Database_Connection();
        try {
            String query = "SELECT * FROM doctor WHERE DoctorId = ? AND Password = ? AND Role = ?";
            Connection con = dbcon.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, doctor_id);
                pstmt.setString(2, d_pass);
                pstmt.setString(3, d_role);

                boolean doctorExists = pstmt.executeQuery().next();

                if (doctorExists) {
                    JOptionPane.showMessageDialog(null, "Doctor login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new DoctorInterface().setVisible(true); // Redirect to Doctor Dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Doctor credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to validate Doctor login", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            dbcon.closeConnection();
        }
    }

}
