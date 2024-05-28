package admin;

import static admin.adminMain.checkData;
import config.Session;
import config.TableQueries;
import config.dbConnector;
import config.passwordHasher;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class admin_profileSecurity extends javax.swing.JFrame {

    public admin_profileSecurity() {
        setUndecorated(true);
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        username = new enhance.CustomTF();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        viewpass = new javax.swing.JLabel();
        currentpass = new enhance.CustomPF();
        viewpass1 = new javax.swing.JLabel();
        newpass = new enhance.CustomPF();
        viewpass2 = new javax.swing.JLabel();
        confirmpass = new enhance.CustomPF();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(80, 114, 123));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(44, 88, 110));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Current Password");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("New Password");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, -1));

        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(153, 0, 0));
        error.setText(".");
        jPanel2.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 190, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Username");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        username.setForeground(new java.awt.Color(0, 51, 51));
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usernameMouseReleased(evt);
            }
        });
        username.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                usernamePropertyChange(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 130, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Back");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 130, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Confirm Password");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, -1));

        viewpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-eyed-20.png"))); // NOI18N
        viewpass.setToolTipText("Show Password");
        viewpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewpassMouseClicked(evt);
            }
        });
        jPanel2.add(viewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        currentpass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        currentpass.setForeground(new java.awt.Color(53, 55, 75));
        currentpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                currentpassKeyPressed(evt);
            }
        });
        jPanel2.add(currentpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 40));

        viewpass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-eyed-20.png"))); // NOI18N
        viewpass1.setToolTipText("Show Password");
        viewpass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewpass1MouseClicked(evt);
            }
        });
        jPanel2.add(viewpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        newpass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        newpass.setForeground(new java.awt.Color(53, 55, 75));
        newpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newpassKeyPressed(evt);
            }
        });
        jPanel2.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

        viewpass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-eyed-20.png"))); // NOI18N
        viewpass2.setToolTipText("Show Password");
        viewpass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewpass2MouseClicked(evt);
            }
        });
        jPanel2.add(viewpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        confirmpass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(53, 55, 75));
        confirmpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmpassKeyPressed(evt);
            }
        });
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 290, 380);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Secure your Account");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 230, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameMouseReleased

    private void usernamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usernamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamePropertyChange
dbConnector connect = new dbConnector();
Session sess = Session.getInstance();
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if(username.getText().isEmpty()&& currentpass.getText().isEmpty()&& newpass.getText().isEmpty()&&confirmpass.getText().isEmpty()){
            error.setText("*Please fill-out necessary information!");
        }else{
            if(!username.getText().isEmpty()){
                connect.updateData("UPDATE u_username = '"+username.getText()+"' WHERE u_id = "+sess.getId());
            }else{
                try {
                    String rehashedPass = passwordHasher.hashPassword(currentpass.getText());
                    String hashedPass = sess.getPassword();
                    if(hashedPass.equals(rehashedPass)){
                        
                        if(newpass.getText().length()<8){
                            error.setText("*Password must have atleast 8 characters");
                        }else if(!newpass.getText().equals(confirmpass.getText())){
                            error.setText("*New password does not match. Try Again");
                        }else{
                            connect.updateData(passwordHasher.hashPassword(confirmpass.getText()));
                        }
                    }else{
                        error.setText("*Invalid Current Password. Try Again");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println(ex);
                }
                
            }
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void currentpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentpassKeyPressed

    }//GEN-LAST:event_currentpassKeyPressed
    static boolean showPass = false;
    private void viewpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewpassMouseClicked
        if(showPass){
            viewpass.setIcon(new ImageIcon("src/media/icons8-eyed-20.png"));
            currentpass.setEchoChar('*');
            viewpass.setToolTipText("Show Password");
        }else{
            viewpass.setIcon(new ImageIcon("src/media/icons8-eye-20.png"));
            currentpass.setEchoChar((char) 0);
            viewpass.setToolTipText("Hide Password");
        }

        showPass = !showPass;
    }//GEN-LAST:event_viewpassMouseClicked
    static boolean showPass1 = false;
    private void viewpass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewpass1MouseClicked
        if(showPass1){
            viewpass.setIcon(new ImageIcon("src/media/icons8-eyed-20.png"));
            newpass.setEchoChar('*');
            viewpass.setToolTipText("Show Password");
        }else{
            viewpass.setIcon(new ImageIcon("src/media/icons8-eye-20.png"));
            newpass.setEchoChar((char) 0);
            viewpass.setToolTipText("Hide Password");
        }

        showPass1 = !showPass1;
    }//GEN-LAST:event_viewpass1MouseClicked
    static boolean showPass2 = false;
    private void newpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpassKeyPressed
        
    }//GEN-LAST:event_newpassKeyPressed

    private void viewpass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewpass2MouseClicked
        if(showPass2){
            viewpass.setIcon(new ImageIcon("src/media/icons8-eyed-20.png"));
            confirmpass.setEchoChar('*');
            viewpass.setToolTipText("Show Password");
        }else{
            viewpass.setIcon(new ImageIcon("src/media/icons8-eye-20.png"));
            confirmpass.setEchoChar((char) 0);
            viewpass.setToolTipText("Hide Password");
        }

        showPass2 = !showPass2;
    }//GEN-LAST:event_viewpass2MouseClicked

    private void confirmpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmpassKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassKeyPressed

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
            java.util.logging.Logger.getLogger(admin_profileSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_profileSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_profileSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_profileSecurity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_profileSecurity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPasswordField confirmpass;
    public javax.swing.JPasswordField currentpass;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JPasswordField newpass;
    public javax.swing.JTextField username;
    private javax.swing.JLabel viewpass;
    private javax.swing.JLabel viewpass1;
    private javax.swing.JLabel viewpass2;
    // End of variables declaration//GEN-END:variables
}
