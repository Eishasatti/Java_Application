package frontendpages;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class ReceptionistDashBoard extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistInterface
     */
    public ReceptionistDashBoard() {
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

        GenRec = new javax.swing.JButton();
        ManPat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        SchdApp = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GenRec.setBackground(new java.awt.Color(255, 255, 204));
        GenRec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenRec.setText("Generate Receipt");
        GenRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenRecActionPerformed(evt);
            }
        });
        getContentPane().add(GenRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 190, 70));

        ManPat.setBackground(new java.awt.Color(255, 255, 204));
        ManPat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ManPat.setText("Manage Patients");
        ManPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManPatActionPerformed(evt);
            }
        });
        getContentPane().add(ManPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, 70));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SchdApp.setBackground(new java.awt.Color(255, 255, 204));
        SchdApp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SchdApp.setText("Schedule Appointment");
        SchdApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchdAppActionPerformed(evt);
            }
        });
        jPanel1.add(SchdApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 390, 70));

        logoutbtn.setBackground(new java.awt.Color(153, 255, 153));
        logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutbtn.setText("LogOut");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Receptionist DashBoard");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SchdAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchdAppActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ScheduleApp().setVisible(true);
        
    }//GEN-LAST:event_SchdAppActionPerformed

    private void ManPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManPatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ManagePatient().setVisible(true);
    }//GEN-LAST:event_ManPatActionPerformed

    private void GenRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenRecActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new GenerateReceipt().setVisible(true);
    }//GEN-LAST:event_GenRecActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
this.setVisible(false);
// TODO add your handling code here:
new LoginForm().setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenRec;
    private javax.swing.JButton ManPat;
    private javax.swing.JButton SchdApp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutbtn;
    // End of variables declaration//GEN-END:variables
}
