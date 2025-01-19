
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class ManageDoctor extends javax.swing.JFrame {
          String name,gender,spec,doctorID,ph_number,pass,conf_pass,role;
          int exp,room_no;
          long number;
          
    /**
     * Creates new form ManageDoctor
     */
    public ManageDoctor() {
        initComponents();
    }
public void getValues(){
    
    name=doc_name.getText();
    gender=doc_gen.getText();
    spec=doc_spec.getText();
    doctorID=doc_id.getText();
    ph_number=doc_phone.getText();
    number=Long.parseLong(ph_number);
    role=doc_role.getText();
      pass = new String(doc_pass.getPassword());
      conf_pass=new String(doc_conf_pass.getPassword());
     try {
           exp = Integer.parseInt(doc_exp.getText());
     } catch (NumberFormatException e)
     {
    // Handle the error, e.g., show a message to the user
             JOptionPane.showMessageDialog(null, "Enter Exp in numbers.");
        }
 try {
           room_no=Integer.parseInt(doc_room_no.getText());
     } catch (NumberFormatException e)
     {
    // Handle the error, e.g., show a message to the user
             JOptionPane.showMessageDialog(null, "Enter Valid Room no (in numbers).");
        }
    
}
public boolean ValidateInputs() {
    // Validate Name, Gender, Specialty, Doctor ID (non-empty strings)
    if (name == null || name.trim().isEmpty() || 
        gender == null || gender.trim().isEmpty() || 
        spec == null || spec.trim().isEmpty() || 
        doctorID == null || doctorID.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields (Name, Gender, Specialty, Doctor ID) are required.");
        return false;
    }
 if (role.isEmpty() || !(role.equalsIgnoreCase("doctor")) )
    {
        JOptionPane.showMessageDialog(null, "Role must be either 'doctor'.");
        return false;
    }
    // Validate Phone Number (non-empty and numeric)
    if (ph_number == null || ph_number.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Phone number cannot be empty.");
        return false;
    }
    try {
        number = Long.parseLong(ph_number);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Phone number must be a valid number.");
        return false;
    }

    // Validate Password (non-empty)
    if (pass == null || pass.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password cannot be empty.");
        return false;
    }

    // Validate Confirm Password (non-empty and matches password)
    if (conf_pass == null || conf_pass.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Confirm password cannot be empty.");
        return false;
    }
    if (!pass.equals(conf_pass)) {
        JOptionPane.showMessageDialog(null, "Passwords do not match.");
        return false;
    }

    // Validate Experience (numeric and valid)
    if (exp <= 0) {
        JOptionPane.showMessageDialog(null, "Experience must be a positive number.");
        return false;
    }

    // Validate Room Number (numeric and valid)
    if (room_no <= 0) {
        JOptionPane.showMessageDialog(null, "Room number must be a positive number.");
        return false;
    }

    // All validations passed
    return true;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        doc_spec = new javax.swing.JTextField();
        doc_name = new javax.swing.JTextField();
        doc_exp = new javax.swing.JTextField();
        doc_gen = new javax.swing.JTextField();
        doc_role = new javax.swing.JTextField();
        doc_phone = new javax.swing.JTextField();
        doc_id = new javax.swing.JTextField();
        doc_room_no = new javax.swing.JTextField();
        Addbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        doc_pass = new javax.swing.JPasswordField();
        doc_conf_pass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Manage Doctor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 27, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Doctor Id:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 221, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("DoctorRoomNo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 221, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 221, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Confirm Password:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 221, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Role:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 221, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Phone #:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 117, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Specialization:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 117, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Gender:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 117, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Name:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 117, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Experience:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 117, -1, -1));
        getContentPane().add(doc_spec, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 143, 120, 35));
        getContentPane().add(doc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 143, 120, 35));
        getContentPane().add(doc_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 143, 120, 35));
        getContentPane().add(doc_gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 143, 120, 35));
        getContentPane().add(doc_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 247, 120, 35));
        getContentPane().add(doc_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 143, 120, 35));
        getContentPane().add(doc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 247, 120, 35));
        getContentPane().add(doc_room_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 247, 120, 35));

        Addbtn.setBackground(new java.awt.Color(255, 255, 204));
        Addbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Addbtn.setText("ADD");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 316, 100, 40));

        delbtn.setBackground(new java.awt.Color(255, 255, 204));
        delbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delbtn.setText("DELETE");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        getContentPane().add(delbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 316, 100, 40));

        updatebtn.setBackground(new java.awt.Color(255, 255, 204));
        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        getContentPane().add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 316, 100, 40));

        searchbtn.setBackground(new java.awt.Color(255, 255, 204));
        searchbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchbtn.setText("SEARCH");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 316, 100, 40));

        backbtn.setBackground(new java.awt.Color(255, 51, 51));
        backbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backbtn.setText("<-");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        getContentPane().add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 6, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(doc_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(doc_conf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doc_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doc_conf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminInterface().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
        getValues();
        if(ValidateInputs()){
            
             Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();
    
    String query = "INSERT INTO doctor (DoctorId, Name, Experience,DocRoomNo,Gender,Phoneno,Specialization,Role,Password) " +
                   "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the values from user inputs
        stmt.setString(1, doctorID);
        stmt.setString(2,name );
        stmt.setInt(3, exp);
        stmt.setInt(4, room_no );
        stmt.setString(5, gender);
        stmt.setLong(6, number);
        stmt.setString(7, spec);
        stmt.setString(8,role);
        stmt.setString(9,pass);

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
            
        }
    }//GEN-LAST:event_AddbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
         getValues(); // Retrieve values from the form
    
    if (ValidateInputs()) {
        
        // Create Database connection
        Database_Connection dbConnection = new Database_Connection();
        Connection conn = dbConnection.getConnection();

        String query = "UPDATE doctor SET Name = ?, Experience = ?, DocRoomNo = ?, Gender = ?, Phoneno = ?, Specialization = ?, Role = ?, Password = ? " +
                       "WHERE DoctorId = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set the values from user inputs
            stmt.setString(1, name);
            stmt.setInt(2, exp);
            stmt.setInt(3, room_no);
            stmt.setString(4, gender);
            stmt.setLong(5, number);
            stmt.setString(6, spec);
            stmt.setString(7, role);
            stmt.setString(8, pass);
            stmt.setString(9, doctorID);  // Use DoctorId to identify the record to update

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
    }//GEN-LAST:event_updatebtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        // TODO add your handling code here:
        String doctor_ID = doc_id.getText(); // Or another method to get doctorID

    // Validate if doctorID is not empty
    if (doctor_ID.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Doctor ID cannot be empty.");
        return;
    }

    // Create Database connection
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    String query = "DELETE FROM doctor WHERE DoctorId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the doctorID for the DELETE operation
        stmt.setString(1, doctor_ID);

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
    }//GEN-LAST:event_delbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
         String doctor_id_1 = doc_id.getText(); // Or another method to get doctorID

    // Validate if doctorID is not empty
    if (doctor_id_1.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Doctor ID cannot be empty.");
        return;
    }

    // Create Database connection
    Database_Connection dbConnection = new Database_Connection();
    Connection conn = dbConnection.getConnection();

    String query = "SELECT * FROM doctor WHERE DoctorId = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        // Set the doctorID for the SELECT operation
        stmt.setString(1, doctor_id_1);

        // Execute the query and get the result
        ResultSet rs = stmt.executeQuery();

        // Check if a record was found
        if (rs.next()) {
            // Display the doctor information (example: you can set it to labels or fields)
            String name1 = rs.getString("Name");
            int experience = rs.getInt("Experience");
            int roomNo = rs.getInt("DocRoomNo");
            String gender1 = rs.getString("Gender");
            long phoneNo = rs.getLong("Phoneno");
            String specialization = rs.getString("Specialization");
            String role1 = rs.getString("Role");
            String password = rs.getString("Password");

            // Display doctor info (for example, on a label or text fields)
            JOptionPane.showMessageDialog(null, 
                "Doctor Information:\n" +
                "Name: " + name1 + "\n" +
                "Experience: " + experience + " years\n" +
                "Room No: " + roomNo + "\n" +
                "Gender: " + gender1 + "\n" +
                "Phone: " + phoneNo + "\n" +
                "Specialization: " + specialization + "\n" +
                "Role: " + role1 + "\n" +
                "Password: " + password
            );
        } else {
            JOptionPane.showMessageDialog(null, "Doctor with the given ID not found.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_searchbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JPasswordField doc_conf_pass;
    private javax.swing.JTextField doc_exp;
    private javax.swing.JTextField doc_gen;
    private javax.swing.JTextField doc_id;
    private javax.swing.JTextField doc_name;
    private javax.swing.JPasswordField doc_pass;
    private javax.swing.JTextField doc_phone;
    private javax.swing.JTextField doc_role;
    private javax.swing.JTextField doc_room_no;
    private javax.swing.JTextField doc_spec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
