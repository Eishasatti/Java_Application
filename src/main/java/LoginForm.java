/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EISHA
 */
import javax.swing.JOptionPane;
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        
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
        password = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        login_user_id = new javax.swing.JTextField();
        login_password = new javax.swing.JPasswordField();
        login_role = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 23, -1, -1));

        password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 204));
        password.setText("Password");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 154, -1, -1));

        user_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 204));
        user_name.setText("ID");
        getContentPane().add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 113, -1, -1));

        role.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        role.setForeground(new java.awt.Color(255, 255, 204));
        role.setText("Role");
        getContentPane().add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, -1, -1));
        getContentPane().add(login_user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 140, 30));

        login_password.setToolTipText("");
        login_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(login_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, 30));
        getContentPane().add(login_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, 30));

        login.setBackground(new java.awt.Color(255, 255, 204));
        login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 140, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\EISHA\\Desktop\\and-healthcare\\and-healthcare\\back1.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_passwordActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
      String id = login_user_id.getText(); // Get the text from the input

         String password = new String(login_password.getPassword());
         String role = login_role.getText().trim();
         Boolean isValid=true;
         
         if (id.isEmpty() || role.isEmpty() || password.isEmpty()) {
               isValid = false;
                 JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
}
         if (!role.equalsIgnoreCase("doctor") && 
               !role.equalsIgnoreCase("admin") && 
              !role.equalsIgnoreCase("receptionist")) {
             isValid=false;
              JOptionPane.showMessageDialog(null, 
        "Invalid role. Please enter 'doctor', 'admin', or 'receptionist'.", 
        "Validation Error", 
        JOptionPane.ERROR_MESSAGE);
}
         else{
            if (role.equalsIgnoreCase("doctor")) {
        Doctor doct1 = new Doctor();
        doct1.Login(id, password, role);
    } else if (role.equalsIgnoreCase("admin")) {
        Admin admin1 = new Admin();
        admin1.Login(id, password, role);
    } else {
        Receptionist recp1 = new Receptionist();
        recp1.Login(id, password, role);
    }
         }
     
    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField login_password;
    private javax.swing.JTextField login_role;
    private javax.swing.JTextField login_user_id;
    private javax.swing.JLabel password;
    private javax.swing.JLabel role;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
