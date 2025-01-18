import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Authentication {
    private String u_name;
    private String u_email;
    private long number;
    private String u_pass;
    private String role;

    public Authentication() {
        u_name = " ";
        u_email = " ";
        number = 0;
        u_pass = " ";
    }

  public void login(String u_n, String pass, String role) {
    u_name = u_n;
    u_pass = pass;
    this.role = role;

    Database_Connection dbcon = new Database_Connection();
    try {
        // Query to check if user exists
        String query = "SELECT * FROM register WHERE Name = ? AND Password = ? AND Role = ?";
        Connection con = dbcon.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            // Set query parameters
            pstmt.setString(1, u_name);
            pstmt.setString(2, u_pass);
            pstmt.setString(3, role);

            // Execute query and check results
            boolean userExists = pstmt.executeQuery().next();

            if (userExists) {
                JOptionPane.showMessageDialog(null, "Login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Redirect based on the role
                switch (role.toLowerCase()) {
                    case "doctor":
                        
                        new DoctorInterface().setVisible(true); // Open Doctor Interface
                        break;

                    case "admin":
                       
                        new AdminInterface().setVisible(true); // Open Admin Interface
                        break;

                    case "receptionist":
                        
                        new ReceptionistInterface().setVisible(true); // Open Receptionist Interface
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid role.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials or role. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: Unable to validate login", "Failed", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        dbcon.closeConnection();
    }
}

    public void register(String u_nam, String eml, String role1, long number1, String pass) {
        u_name = u_nam;
        u_email = eml;
        role = role1;
        number = number1;
        u_pass = pass;

        Database_Connection dbConnection = new Database_Connection();
        try {
            // Insert data into the database
            String query = "INSERT INTO register (Name, email, Role, Phoneno, Password) VALUES (?, ?, ?, ?, ?)";
            Connection con = dbConnection.getConnection();

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                // Set values for the query
                pstmt.setString(1, u_name);
                pstmt.setString(2, u_email);
                pstmt.setString(3, role);
                pstmt.setLong(4, number);
                pstmt.setString(5, u_pass);

                // Execute the query
                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "User registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Unable to insert record", "Failed", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
}
