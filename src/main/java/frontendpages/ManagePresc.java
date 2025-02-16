package frontendpages;

import BackEND.Appointment;
import BackEND.Doctor;
import BackEND.Patient;
import BackEND.Prescription;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author EISHA
 */
public class ManagePresc extends javax.swing.JFrame {
String[] medicines = {"Paracetamol", "Ibuprofen", "Aspirin", "Amoxicillin", "Ciprofloxacin"};
   public ArrayList<String> selectedItems;
   String patient_id,doct_id,presc_id,appoi_id;

    /**
     * Creates new form ManagePresc
     */
    public ManagePresc() {
        initComponents();
//       

          med_list.setListData(medicines);
        
           loadAppointmentIds();
            loadDoctor();
              loadPatient();
          getInput();
          
         
    }
 public void getInput(){
   selectedItems = new ArrayList<>(med_list.getSelectedValuesList());

    med_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
    // Add listener for list selection changes
    med_list.addListSelectionListener((ListSelectionEvent e) -> {
        if (!e.getValueIsAdjusting()) { // Avoid handling intermediate changes
            selectedItems = new ArrayList<>(med_list.getSelectedValuesList());
             System.out.println("Selected Items: " + selectedItems);// Get all selected items
        }
    });

    // Get other fields
    patient_id = pat_id.getSelectedItem().toString().split(" - ")[0];
    doct_id=doc_id.getSelectedItem().toString().split(" - ")[0]; // Get the ID part before " - "

    appoi_id = app_id.getSelectedItem().toString();
    presc_id = pres_id.getText();
}
   public void loadAppointmentIds() {
        try {
            Appointment appointment = new Appointment();
            ArrayList<String> appointmentIds = appointment.getAppointmentList();

            // Clear existing items in the JComboBox
            app_id.removeAllItems();

            // Populate the JComboBox with appointment IDs
            for (String appointmentId : appointmentIds) {
                app_id.addItem(appointmentId);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error loading appointment IDs: " + e.getMessage());
        }
    }
    public void loadDoctor() {
        try {
            Doctor doct = new Doctor();
            ArrayList<ArrayList<String>> doctorDetails = doct.getDoctorList();

            // Clear existing items in the JComboBox
            doc_id.removeAllItems();

            // Populate the JComboBox with doctor ID and name in the same row
            for (ArrayList<String> doctor : doctorDetails) {
                String doctorId = doctor.get(0); // Get the ID
                String doctorName = doctor.get(1); // Get the Name

                // Combine ID and Name in a single string
                String displayText = doctorId + " - " + doctorName;

                // Add the combined string to the JComboBox
                doc_id.addItem(displayText);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error loading doctors: " + e.getMessage());
        }
    }

   public boolean Validations() {
    // Check if patient_id is empty or null
    if (patient_id == null || patient_id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Patient ID is required.");
        return false;
    }

    // Check if doctor_id is empty or null
    if (doct_id == null || doct_id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Doctor ID is required.");
        return false;
    }

    // Check if appointment_id is empty or null
    if (appoi_id == null || appoi_id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Appointment ID is required.");
        return false;
    }

    // Check if prescription_id is empty or null
    if (presc_id == null || presc_id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Prescription ID is required.");
        return false;
    }

    // Check if at least one medicine is selected
    if (selectedItems.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select at least one medicine.");
        return false;
    }

    return true; // If all validations pass
}

      public void loadPatient() {
        try {
            Patient pat = new Patient();
            ArrayList<ArrayList<String>> patientDetails = pat.getPatientList();

            // Clear existing items in the JComboBox
            pat_id.removeAllItems();

            // Populate the JComboBox with patient ID and name in the same row
            for (ArrayList<String> patient : patientDetails) {
                String patientId = patient.get(0); // Get the ID
                String patientName = patient.get(1); // Get the Name

                // Combine ID and Name in a single string
                String displayText = patientId + " - " + patientName;

                // Add the combined string to the JComboBox
                pat_id.addItem(displayText);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error loading patients: " + e.getMessage());
        }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pres_id = new javax.swing.JTextField();
        search_pres = new javax.swing.JButton();
        addPres = new javax.swing.JButton();
        del_pres = new javax.swing.JButton();
        update_pres = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        med_list = new javax.swing.JList<>();
        app_id = new javax.swing.JComboBox<>();
        doc_id = new javax.swing.JComboBox<>();
        pat_id = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Manage Prescription");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Patient ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 89, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Appointment ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 89, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Prescription ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 167, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Medicine list:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 167, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Doctor id:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 251, -1, -1));
        getContentPane().add(pres_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 193, 130, 40));

        search_pres.setBackground(new java.awt.Color(255, 255, 204));
        search_pres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search_pres.setText("SEARCH");
        getContentPane().add(search_pres, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 391, 130, 43));

        addPres.setBackground(new java.awt.Color(255, 255, 204));
        addPres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addPres.setText("ADD");
        addPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPresActionPerformed(evt);
            }
        });
        getContentPane().add(addPres, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 330, 130, 43));

        del_pres.setBackground(new java.awt.Color(255, 255, 204));
        del_pres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        del_pres.setText("DELETE");
        getContentPane().add(del_pres, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 330, 130, 43));

        update_pres.setBackground(new java.awt.Color(255, 255, 204));
        update_pres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update_pres.setText("UPDATE");
        getContentPane().add(update_pres, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 391, 130, 43));

        med_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(med_list);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 130, 40));

        app_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(app_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 130, 40));

        doc_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(doc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 130, 40));

        pat_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(pat_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPresActionPerformed
        // TODO add your handling code here:
        getInput();
    
        if(Validations()){
            Prescription pres=new Prescription(patient_id,doct_id,appoi_id,presc_id,selectedItems);
            pres.add();
        }
    }//GEN-LAST:event_addPresActionPerformed

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
            java.util.logging.Logger.getLogger(ManagePresc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePresc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePresc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePresc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePresc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPres;
    private javax.swing.JComboBox<String> app_id;
    private javax.swing.JButton del_pres;
    private javax.swing.JComboBox<String> doc_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> med_list;
    private javax.swing.JComboBox<String> pat_id;
    private javax.swing.JTextField pres_id;
    private javax.swing.JButton search_pres;
    private javax.swing.JButton update_pres;
    // End of variables declaration//GEN-END:variables
}
