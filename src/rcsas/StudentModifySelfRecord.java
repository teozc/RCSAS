/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcsas;

/**
 *
 * @author jerem
 */
public class StudentModifySelfRecord extends javax.swing.JFrame {

    /**
     * Creates new form ModifySelfRecordPage
     */
    public StudentModifySelfRecord() {
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

        ModifySelfRecordLabel = new javax.swing.JLabel();
        ModifyProfileButton = new javax.swing.JButton();
        SubscribeSportsButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        RemoveSportsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ModifySelfRecordLabel.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        ModifySelfRecordLabel.setForeground(new java.awt.Color(0, 0, 0));
        ModifySelfRecordLabel.setText("Modify Self Record Page");
        ModifySelfRecordLabel.setToolTipText("");

        ModifyProfileButton.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ModifyProfileButton.setText("Modify profile");
        ModifyProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyProfileButtonActionPerformed(evt);
            }
        });

        SubscribeSportsButton.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        SubscribeSportsButton.setText("Subscribe to more sports");
        SubscribeSportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubscribeSportsButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        RemoveSportsButton.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        RemoveSportsButton.setText("Remove registered sport schedule");
        RemoveSportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveSportsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ModifyProfileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SubscribeSportsButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 106, Short.MAX_VALUE)
                        .addComponent(ModifySelfRecordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(113, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RemoveSportsButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(ModifySelfRecordLabel)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubscribeSportsButton)
                    .addComponent(ModifyProfileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(RemoveSportsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.setVisible(false);
        StudentPage sp = new StudentPage();
        sp.displayUsername(LoginSession.Username);
        sp.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ModifyProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyProfileButtonActionPerformed
        this.setVisible(false);
        StudentModifyProfile mp = new StudentModifyProfile();
        mp.setVisible(true);
    }//GEN-LAST:event_ModifyProfileButtonActionPerformed

    private void SubscribeSportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubscribeSportsButtonActionPerformed
        this.setVisible(false);
        StudentSubscribeSports sp = new StudentSubscribeSports();
        sp.displaySports();
        sp.setVisible(true);
    }//GEN-LAST:event_SubscribeSportsButtonActionPerformed

    private void RemoveSportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveSportsButtonActionPerformed
        this.setVisible(false);
        StudentRemoveSportSchedule rp = new StudentRemoveSportSchedule();
        rp.displayRegisteredSportSchedules();
        rp.setVisible(true);
    }//GEN-LAST:event_RemoveSportsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentModifySelfRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentModifySelfRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentModifySelfRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentModifySelfRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentModifySelfRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ModifyProfileButton;
    private javax.swing.JLabel ModifySelfRecordLabel;
    private javax.swing.JButton RemoveSportsButton;
    private javax.swing.JButton SubscribeSportsButton;
    // End of variables declaration//GEN-END:variables
}
