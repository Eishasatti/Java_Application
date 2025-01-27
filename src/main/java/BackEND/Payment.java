package BackEND;


import DatabaseConn.Database_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class Payment {
    String payid,appid,card_Name;
    String pay_stat="paid";
    long cardNo;
    int cvv;
    public Payment(){
        
    }
    public Payment(String payid,String appid,String cardHName,long cardno,int cvv){
        this.payid=payid;
        this.appid=appid;
        card_Name=cardHName;
       
        cardNo=cardno;
        this.cvv=cvv;
        
}
public void AddPaymentToDB() {

    // Create a connection to the database
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    // Define the SQL query for inserting payment details
    String query = "INSERT INTO payment (PaymentId, AppId, CardNo,CVV, CardHolderName ,PaymentStatus) " +
                   "VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the values from user inputs
        stmt.setString(1, payid);        // Payment ID
        stmt.setString(2, appid);       // Appointment ID
        stmt.setLong(3,cardNo);   // Card Holder Name
        stmt.setInt(4,cvv);   // Payment Status
        stmt.setString(5, card_Name );        // Card Number
        stmt.setString(6, pay_stat );            // CVV

        // Execute the query and check if the insertion was successful
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Payment information added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add payment information.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        dbConnection.closeConnection();
    }
}

}
