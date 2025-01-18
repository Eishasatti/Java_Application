import java.sql.*;

public class Database_Connection {
    private Connection con;

    // Constructor to establish database connection
    public Database_Connection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, username, and password
            String DB_URL = "jdbc:mysql://localhost:3306/hopitalmanagement";
            String USER = "root";
            String PASSWORD = "";

            // Establish connection
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Unable to load driver class!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error: Unable to connect to the database!");
            ex.printStackTrace();
        }
    }

    // Provide access to the connection
    public Connection getConnection() {
        return con;
    }

    // Close the connection
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: Unable to close the connection!");
            ex.printStackTrace();
        }
    }
}
