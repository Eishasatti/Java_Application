/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class Managedoctors extends javax.swing.JFrame {

    /**
     * Creates new form Managedoctors
     */
    public Managedoctors() {
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
        searchDoctor = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        addDoctor = new javax.swing.JButton();
        updateDoctor = new javax.swing.JButton();
        deleteDoctor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Manage Doctors");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        searchDoctor.setBackground(new java.awt.Color(255, 255, 204));
        searchDoctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchDoctor.setText("Search Doctor");
        searchDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDoctorActionPerformed(evt);
            }
        });
        getContentPane().add(searchDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 130, 60));

        Back.setBackground(new java.awt.Color(255, 102, 102));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Back.setText("<-");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        addDoctor.setBackground(new java.awt.Color(255, 255, 204));
        addDoctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addDoctor.setText("Add Doctor");
        addDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorActionPerformed(evt);
            }
        });
        getContentPane().add(addDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 130, 60));

        updateDoctor.setBackground(new java.awt.Color(255, 255, 204));
        updateDoctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateDoctor.setText("Update Doctor");
        updateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDoctorActionPerformed(evt);
            }
        });
        getContentPane().add(updateDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 130, 60));

        deleteDoctor.setBackground(new java.awt.Color(255, 255, 204));
        deleteDoctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteDoctor.setText("Delete Doctor");
        deleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorActionPerformed(evt);
            }
        });
        getContentPane().add(deleteDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 130, 60));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDoctorActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ReceptionistInterface().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void addDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDoctorActionPerformed

    private void updateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDoctorActionPerformed

    private void deleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteDoctorActionPerformed

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
            java.util.logging.Logger.getLogger(Managedoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Managedoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Managedoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Managedoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managedoctors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton addDoctor;
    private javax.swing.JButton deleteDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton searchDoctor;
    private javax.swing.JButton updateDoctor;
    // End of variables declaration//GEN-END:variables
}
