/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EISHA
 */
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Receptionist {
    String name,email,id,password,shift,role;
    long number;
    public Receptionist(){
        
    }
    public Receptionist(String id,String name,String shift,String email,String role,long phone,String pass){
        this.id=id;
        this.name=name;
        this.email=email;
        this.role=role;
        number=phone;
        password=pass;
        this.shift=shift;
        
        
    }
    public void Add(){
        Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // SQL insert query to add a new receptionist record
    String insertQuery = "INSERT INTO receptionist (ReceptionistId, Name,Shift,Email,Role,Phoneno, Passsword) VALUES (?, ?, ?, ?, ?,?,?)";

    try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
        // Set the values for the PreparedStatement
        stmt.setString(1, id);
        stmt.setString(2, name);
        stmt.setString(3,shift);
        stmt.setString(4, email);
         stmt.setString(5, role);
         stmt.setLong(6,number);
        stmt.setString(7, password);

        // Execute the insert query
        int rowsAffected = stmt.executeUpdate();

        // Check if the insert was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Receptionist added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to add receptionist.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
        
    }
     
   public void Delete(String receptionistId) {
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // SQL delete query to remove a receptionist record by ReceptionistId
    String deleteQuery = "DELETE FROM receptionist WHERE ReceptionistId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
        // Set the ReceptionistId for the DELETE query
        stmt.setString(1, receptionistId);

        // Execute the delete query
        int rowsAffected = stmt.executeUpdate();

        // Check if the delete was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Receptionist deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error: No receptionist found with the given ID.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}

    public void Update() {
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // SQL update query to modify a receptionist record
    String updateQuery = "UPDATE receptionist SET Name = ?, Shift = ?, Email = ?, Role = ?, Phoneno = ?, Passsword = ? WHERE ReceptionistId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
        // Set the new values for the PreparedStatement
        stmt.setString(1, name);  // Update Name
        stmt.setString(2, shift);  // Update Shift
        stmt.setString(3, email);  // Update Email
        stmt.setString(4, role);   // Update Role
        stmt.setLong(5, number);   // Update Phone Number
        stmt.setString(6, password);  // Update Password
        stmt.setString(7, id);     // Identify the record by ReceptionistId

        // Execute the update query
        int rowsAffected = stmt.executeUpdate();

        // Check if the update was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Receptionist updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Unable to update receptionist. Ensure the ReceptionistId is correct.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}

  public void Search(String receptionistId) {
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // SQL query to search for a receptionist by ReceptionistId
    String searchQuery = "SELECT * FROM receptionist WHERE ReceptionistId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
        // Set the ReceptionistId for the search query
        stmt.setString(1, receptionistId);

        // Execute the query
        ResultSet rs = stmt.executeQuery();

        // Create a JTable to display the result
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model
        tableModel.addColumn("ReceptionistId");
        tableModel.addColumn("Name");
        tableModel.addColumn("Shift");
        tableModel.addColumn("Email");
        tableModel.addColumn("Role");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Password");

        // Populate the table model with data from the ResultSet
        if (rs.next()) {
            do {
                tableModel.addRow(new Object[] {
                    rs.getString("ReceptionistId"),
                    rs.getString("Name"),
                    rs.getString("Shift"),
                    rs.getString("Email"),
                    rs.getString("Role"),
                    rs.getLong("Phoneno"),
                    rs.getString("Passsword")
                });
            } while (rs.next());
        } else {
            JOptionPane.showMessageDialog(null, "No receptionist found with the given ID.");
            return; // Exit the method if no data is found
        }

        // Set the model to the JTable
        table.setModel(tableModel);

        // Display the JTable in a JScrollPane for better usability
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(800, 300);

        // Display the table in a new JFrame
        JFrame tableFrame = new JFrame("Receptionist Details");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.add(scrollPane);
        tableFrame.setSize(800, 300);
        tableFrame.setVisible(true);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}

   public void SearchAll() {
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // SQL query to retrieve all records from the receptionist table
    String searchQuery = "SELECT * FROM receptionist";

    try (PreparedStatement stmt = conn.prepareStatement(searchQuery)) {
        // Execute the query
        ResultSet rs = stmt.executeQuery();

        // Create a JTable to display the result
        JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model
        tableModel.addColumn("ReceptionistId");
        tableModel.addColumn("Name");
        tableModel.addColumn("Shift");
        tableModel.addColumn("Email");
        tableModel.addColumn("Role");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Password");

        // Populate the table model with data from the ResultSet
        while (rs.next()) {
            tableModel.addRow(new Object[] {
                rs.getString("ReceptionistId"),
                rs.getString("Name"),
                rs.getString("Shift"),
                rs.getString("Email"),
                rs.getString("Role"),
                rs.getLong("Phoneno"),
                rs.getString("Passsword")
            });
        }

        // Set the model to the JTable
        table.setModel(tableModel);

        // Display the JTable in a JScrollPane for better usability
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(800, 300);

        // Display the table in a new JFrame
        JFrame tableFrame = new JFrame("Receptionist Details");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.add(scrollPane);
        tableFrame.setSize(800, 300);
        tableFrame.setVisible(true);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Close the database connection
        dbConnection.closeConnection();
    }
}

    public void Login(String u_id, String password, String role) {
        Database_Connection dbcon = new Database_Connection();
        try {
            String query = "SELECT * FROM receptionist WHERE ReceptionistId = ? AND Passsword = ? AND Role = ?";
            Connection con = dbcon.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, u_id);
                pstmt.setString(2, password);
                pstmt.setString(3, role);

                boolean receptionistExists = pstmt.executeQuery().next();

                if (receptionistExists) {
                    JOptionPane.showMessageDialog(null, "Receptionist login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new ReceptionistDashBoard().setVisible(true); // Redirect to Receptionist Dashboard
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

