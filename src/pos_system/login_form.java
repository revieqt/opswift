package pos_system;

import cashier.*;
import admin.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class login_form extends javax.swing.JFrame {

    /**
     * Creates new form login_form
     */
    public login_form() {
        initComponents();
    }
    Color bodycolor = new Color(99, 122, 159);
    Color entercolor = new Color(255, 243, 207);
    
    String account = "Cashier";
    String user = "oha";
    String pass = "1234";
            

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        identification = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        proceed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 215, 221));
        jPanel1.setLayout(null);

        identification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                identificationKeyPressed(evt);
            }
        });
        jPanel1.add(identification);
        identification.setBounds(30, 220, 220, 30);
        jPanel1.add(username);
        username.setBounds(30, 170, 220, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_system/opswiftsmol-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 60, 200, 80);

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(99, 122, 159));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("identification number");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 200, 100, 14);

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(99, 122, 159));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("by Joshua Opsima");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 360, 280, 14);

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(99, 122, 159));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Opswift Point of Sales System");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 350, 280, 14);

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(99, 122, 159));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("username");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 150, 50, 14);

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(99, 122, 159));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click here to Create new user");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 310, 160, 30);

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(99, 122, 159));
        jLabel3.setText("or Scan Identification Card");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 260, 140, 30);

        proceed.setBackground(new java.awt.Color(234, 223, 180));
        proceed.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        proceed.setText("LOGIN");
        proceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedMouseClicked(evt);
            }
        });
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        proceed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                proceedKeyPressed(evt);
            }
        });
        jPanel1.add(proceed);
        proceed.setBounds(170, 260, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setForeground(entercolor);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setForeground(bodycolor);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setForeground(entercolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setForeground(bodycolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void proceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedMouseClicked
        switch(account){
            case "Admin":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            admin_dashboard open = new admin_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
            case "Cashier":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            cashier_dashboard open = new cashier_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
        }
        
    }//GEN-LAST:event_proceedMouseClicked

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed

    }//GEN-LAST:event_proceedActionPerformed

    private void proceedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proceedKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                switch(account){
            case "Admin":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            admin_dashboard open = new admin_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
            case "Cashier":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            cashier_dashboard open = new cashier_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
        }
    }
    }//GEN-LAST:event_proceedKeyPressed

    private void identificationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identificationKeyPressed
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                switch(account){
            case "Admin":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            admin_dashboard open = new admin_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
            case "Cashier":
                if(user.equals(username.getText())&&pass.equals(identification.getText())){
            cashier_dashboard open = new cashier_dashboard();
            open.setVisible(true);
            this.dispose();
        }
            break;
        }
    }
    }//GEN-LAST:event_identificationKeyPressed

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
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField identification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton proceed;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
