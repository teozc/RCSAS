/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcsas;

import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public class LoginPage extends javax.swing.JFrame {
    public static int isLogin = 0;
    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
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

        LoginLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UsernameText = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        HomePageButton = new javax.swing.JButton();
        PasswordText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 450));

        LoginLabel.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(0, 0, 0));
        LoginLabel.setText("Login Page");

        UsernameLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        UsernameLabel.setText("Username:");

        PasswordLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(0, 0, 0));
        PasswordLabel.setText("Password:");

        UsernameText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        UsernameText.setForeground(new java.awt.Color(0, 0, 0));
        UsernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTextActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        HomePageButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        HomePageButton.setText("Home");
        HomePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageButtonActionPerformed(evt);
            }
        });

        PasswordText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(HomePageButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 220, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LoginButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PasswordLabel)
                                    .addComponent(UsernameLabel))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UsernameText)
                                    .addComponent(PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(255, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(LoginLabel)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLabel)
                    .addComponent(UsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel)
                    .addComponent(PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(LoginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(HomePageButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomePageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageButtonActionPerformed
        this.setVisible(false);
        HomePage hp = new HomePage();
        hp.setVisible(true);
    }//GEN-LAST:event_HomePageButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        LoginSession ls = new LoginSession();
        if (UsernameText.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Empty username entered!", "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            ls.username = UsernameText.getText();
        }
        if (PasswordText.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Empty password entered!", "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            ls.password = PasswordText.getText();
        }
        int result = ls.validation();
        switch (result) {
            case -1:
                JOptionPane.showMessageDialog(this, "Error opening file!", "Error Message", JOptionPane.ERROR_MESSAGE);
                break;
            case 0:
                JOptionPane.showMessageDialog(this, "Invalid combination of username and password!", "Error Message", JOptionPane.ERROR_MESSAGE);
                UsernameText.setText("");
                PasswordText.setText("");
                break;
            case 1:
                this.setVisible(false);
                AdminPage ap = new AdminPage();
                ap.setVisible(true);
                break;
            case 2:
                this.setVisible(false);
                StudentPage sp = new StudentPage();
                sp.setVisible(true);
                LoginPage.isLogin = 1;
                sp.displayUsername(ls.username);
                break;
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void UsernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomePageButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameText;
    // End of variables declaration//GEN-END:variables
}