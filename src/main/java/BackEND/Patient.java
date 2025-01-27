package BackEND;


import frontendpages.ManagePatient;
import DatabaseConn.Database_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class Patient {
    String id,gender,name;
    long ph_no,emg_no;
    int age;
    ManagePatient manage_pat=new ManagePatient();
    public Patient(){
        
    }
    public void Insert(String pat_id,String pat_gen,Long pat_ph_no,String pat_name,int pat_age,long pat_emg){
        id=pat_id;
        gender=pat_gen;
        name=pat_name;
        ph_no=pat_ph_no;
        age=pat_age;
        emg_no=pat_emg;
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();  // Get the connection

        // SQL insert query
        String insertQuery = "INSERT INTO patient (PatientId, Gender, Phoneno,Name,Age,EmgContact) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            // Set the values into the prepared statement
            stmt.setString(1, id);
            stmt.setString(2, gender);
            stmt.setLong(3, ph_no); // Assuming `age_pat` is the correct variable
            stmt.setString(4, name);  // Assuming `phoneno` is the correct variable
            stmt.setInt(5, age); // Assuming `emg_cont` is the correct variable
            stmt.setLong(6,emg_no );       // Assuming `id` is the correct variable

            // Execute the update (insert query)
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Patient added successfully.");
              
                manage_pat.clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add patient.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to insert patient data!");
            ex.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
    public void SearchById(String pat_1_id){
        String patient_s_id=pat_1_id;
         Database_Connection dbConnection = new Database_Connection();
            Connection conn = dbConnection.getConnection(); // Get the connection

            // SQL select query to search for a patient by PatientId
            String searchQuery = "SELECT * FROM patient WHERE PatientId = ?";

            try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
                // Set the PatientId for the record to search
                stmt.setString(1,patient_s_id );

                // Execute the search query
                ResultSet rs = stmt.executeQuery();

                // Create a JTable to display the result
                JTable table = new JTable();
                DefaultTableModel tableModel = new DefaultTableModel();

                // Add columns to the table model
                tableModel.addColumn("PatientId");
                tableModel.addColumn("Name");
                tableModel.addColumn("Gender");
                tableModel.addColumn("Age");
                tableModel.addColumn("Phone No");
                tableModel.addColumn("Emergency Contact");

                // Populate the table model with data from the ResultSet
                if (rs.next()) {
                    do {
                        tableModel.addRow(new Object[]{
                            rs.getString("PatientId"),
                            rs.getString("Name"),
                            rs.getString("Gender"),
                            rs.getString("Age"),
                            rs.getString("Phoneno"),
                            rs.getString("EmgContact")
                        });
                    } while (rs.next());
                } else {
                    JOptionPane.showMessageDialog(null, "No patient found with that PatientId.");
                    return; // Exit the method if no data is found
                }

                // Set the model to the JTable
                table.setModel(tableModel);

                // Display the JTable in a JScrollPane for better usability
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setSize(800, 300);

                // Display the table in a new JFrame
                JFrame tableFrame = new JFrame("Patient Details");
                tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tableFrame.add(scrollPane);
                tableFrame.setSize(800, 300);
                tableFrame.setVisible(true);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: Unable to search for patient.");
                ex.printStackTrace();
            } finally {
                // Close the database connection
                dbConnection.closeConnection();
            }
    }
    public void SearchAllPatients(){
         Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection(); // Get the connection

        // SQL select query to retrieve all patient records
        String searchQuery = "SELECT * FROM patient";

        try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
            // Execute the search query
            ResultSet rs = stmt.executeQuery();

            // Create a JTable to display the result
            JTable table = new JTable();
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model
            tableModel.addColumn("PatientId");
            tableModel.addColumn("Name");
            tableModel.addColumn("Gender");
            tableModel.addColumn("Age");
            tableModel.addColumn("Phone No");
            tableModel.addColumn("Emergency Contact");

            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("PatientId"),
                    rs.getString("Name"),
                    rs.getString("Gender"),
                    rs.getString("Age"),
                    rs.getString("Phoneno"),
                    rs.getString("EmgContact")
                });
            }

            // Check if there are no records in the table
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No patients found in the database.");
                return; // Exit the method if no data is found
            }

            // Set the model to the JTable
            table.setModel(tableModel);

            // Display the JTable in a JScrollPane for better usability
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setSize(800, 300);

            // Display the table in a new JFrame
            JFrame tableFrame = new JFrame("Patient Details");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.add(scrollPane);
            tableFrame.setSize(800, 300);
            tableFrame.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to retrieve patient data.");
            ex.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }

    }
  /*
    public void SearchfromDb(String pat_id){
        id=pat_id;
         Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();  // Get the connection

        // SQL select query to search for a patient by PatientId
        String searchQuery = "SELECT * FROM patient WHERE PatientId = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
            // Set the PatientId for the record to search
            stmt.setString(1, id);  // Assuming `id` is the correct PatientId to search
            
            // Execute the search query
            ResultSet rs = stmt.executeQuery();

            // Check if a record is found
            if (rs.next()) {
                // Retrieve data from the result set and populate fields (example)
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                String age = rs.getString("Age");
                String phoneNo = rs.getString("Phoneno");
                String emgContact = rs.getString("EmgContact");

                // Display or use the data (e.g., in your form fields)
                JOptionPane.showMessageDialog(null, "Patient found: " + name + ", " + gender + ", " + age);
//                
//                // Optionally, you can populate form fields with the retrieved data
//                // For example: 
//                // pat_name.setText(name);
//                // pat_gender.setText(gender);
//                // pat_age.setText(age);
//                // pat_phone.setText(phoneNo);
//                // pat_emerg_no.setText(emgContact);
                
            } else {
                JOptionPane.showMessageDialog(null, "No patient found with that PatientId.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to search for patient.");
            ex.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
   */
  public ArrayList<ArrayList<String>> getPatientList() {
    ArrayList<ArrayList<String>> patientDetails = new ArrayList<>();

    Database_Connection DBcon = new Database_Connection();
    Connection con = DBcon.getConnection();
    try {
        String query = "SELECT PatientId, Name FROM patient"; // Replace with your table and column name
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // Create an inner list for each patient
            ArrayList<String> patient = new ArrayList<>();
            String patientId = rs.getString("PatientId");
            String patientName = rs.getString("Name");

            // Add ID first, then Name
            patient.add(patientId);
            patient.add(patientName);

            // Add the inner list to the main list
            patientDetails.add(patient);
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
    return patientDetails;
}

    public void DeletefromDb(String pat_id){
        id=pat_id;
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();  // Get the connection

        // SQL delete query
        String deleteQuery = "DELETE FROM patient WHERE PatientId = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            // Set the PatientId for the record to be deleted
            stmt.setString(1, id);  // Assuming `id` is the correct PatientId to identify which record to delete

            // Execute the delete query
            int rowsAffected = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Patient deleted successfully.");
                manage_pat.clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete patient.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to delete patient data!");
            ex.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
        
    
    public void UpdateInDb(String pat_id,String pat_gen,Long pat_ph_no,String pat_name,int pat_age,long pat_emg){
         id=pat_id;
        gender=pat_gen;
        name=pat_name;
        ph_no=pat_ph_no;
        age=pat_age;
        emg_no=pat_emg;
         Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();  // Get the connection

        // SQL update query
        String updateQuery = "UPDATE patient SET Gender = ?, Phoneno = ?, Name = ?, Age = ?, EmgContact = ? "
                + "WHERE PatientId = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            // Set the values into the prepared statement
            stmt.setString(1, gender);
            stmt.setLong(2, ph_no); 
            stmt.setString(3, name); 
            stmt.setInt(4, age); 
            stmt.setLong(5, emg_no);      
            stmt.setString(6, id);        

            // Execute the update query
            int rowsAffected = stmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Patient updated successfully.");
                manage_pat.clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update patient.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to update patient data!");
            ex.printStackTrace();
        } finally {
            // Close the database connection
            dbConnection.closeConnection();
        }
    }
    }

