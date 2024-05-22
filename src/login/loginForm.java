/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import accounting.accounting_dashboard;
import admin.adminMain;
import cashier.cashierMain;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author w10
 */
public class loginForm extends javax.swing.JFrame {

    /**
     * Creates new form loginForm
     */
    public loginForm() {
        setUndecorated(true);
        initComponents();
        this.setTitle("Opswift POS");
        splash();
    }

    static String status;
    static String type;
    static boolean showPass = false;
    static int seconds;
    
    public void splash(){
        username.setVisible(false);
        pass.setVisible(false);
        barcodefield.setVisible(false);
        idlogin.setVisible(false);
        Timer timer = new Timer(5000, (ActionEvent e) -> {
            splash.setVisible(false);
            username.setVisible(true);
            pass.setVisible(true);
            barcodefield.setVisible(true);
            idlogin.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    public void loginButton(){
        dbConnector connect = new dbConnector();
        if(connect.columnCount("users")==0){
            errormsg.setText("There are no accounts saved! Create New.");
        }else{
            if(loginAcc(username.getText(),pass.getText())){
                JOptionPane.showMessageDialog(null, "Login Success!");
                if(type.equals("Administrator")){
                    adminMain open = new adminMain();
                    open.setVisible(true);
                }else if(type.equals("Cashier")){
                    cashierMain open = new cashierMain();
                    open.setVisible(true);
                }else{
                    accounting_dashboard open = new accounting_dashboard();
                    open.setVisible(true);
                }
                this.dispose();
            }else{
                errorMessages(false);
            }
        }
    }
    //CODE FOR BARCODE LOG IN
    public void barcodeTimer(){
        seconds = 15;
        errormsg.setText("");
        username.setEditable(false);
        username.setBackground(new Color(222,225,229));
        pass.setEnabled(false);
        Timer count = new Timer(1000, (ActionEvent e) -> {
            idlogin.setText("You have "+ (seconds) + " seconds to scan Identification Card");
            barcodefield.requestFocusInWindow();
            if(seconds<=5){
                idlogin.setForeground(new Color(255, 97, 126));
            }else{
                idlogin.setForeground(new Color(80, 114, 123));
            }
            seconds--;
        });
        count.setRepeats(true);
        
        Timer timer = new Timer(16000, (ActionEvent e) -> {
            idlogin.setText("Press F1 or Click Here to log-in using Identification Card");
            idlogin.setForeground(new Color(153,153,153));
            username.requestFocusInWindow();
            username.setEditable(true);
            username.setBackground(Color.WHITE);
            pass.setEnabled(true);
            count.stop();
        });
        timer.setRepeats(false);
        
        
        count.start();
        timer.start();
    }
    
    public void barcodeLogIn(String bar){
        dbConnector connect = new dbConnector();
        if(connect.columnCount("users")==0){
            errormsg.setText("There are no accounts saved! Create New.");
        }else{
            String scan = bar;
        if(scan != null){
            if(scanBarcode(scan)){
                JOptionPane.showMessageDialog(null, "Login Success!");
                if(type.equals("Administrator")){
                    adminMain open = new adminMain();
                    open.setVisible(true);
                }else if(type.equals("Cashier")){
                    cashierMain open = new cashierMain();
                    open.setVisible(true);
                }else{
                    accounting_dashboard open = new accounting_dashboard();
                    open.setVisible(true);
                }
                this.dispose();
            }else{
                errorMessages(true);
            }
        }
        }
        
    }
    
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        try{
            ResultSet resultSet = connector.getData("SELECT * FROM users  WHERE u_username = '" + username + "' AND u_password = '" + password + "'");
            if(resultSet.next()){
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                setSession(resultSet);
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            return false;
        }
    }
    
    //CODE TO SEARCH ACCOUNT FROM THE DATABASE USING BARCODE
    public static boolean scanBarcode(String bar){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM users  WHERE u_code = '" + bar + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                setSession(resultSet);
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            return false;
        }
    }
    
    public static void setSession(ResultSet resultSet) throws SQLException{
        Session sess = Session.getInstance();
        sess.setId(resultSet.getString("u_id"));
        sess.setCode(resultSet.getString("u_code"));
        sess.setFname(resultSet.getString("u_fname"));
        sess.setLname(resultSet.getString("u_lname"));
        sess.setUsername(resultSet.getString("u_username"));
        sess.setPassword(resultSet.getString("u_password"));
        sess.setType(resultSet.getString("u_type"));
        sess.setStatus(resultSet.getString("u_status"));
    }
    
    public void errorMessages(boolean isBarcode){
        if(isBarcode){
            errormsg.setText("Account not found. Please try again.");
        }else{
            if(username.getText().isEmpty() && pass.getText().isEmpty()){
                errormsg.setText("Both username and password are required.");
            }else{
                if(username.getText().isEmpty()){
                    errormsg.setText("Username cannot be empty.");
                }else if(pass.getText().isEmpty()){
                    errormsg.setText("Password cannot be empty.");
                }else{
                    errormsg.setText("Account not found. Please try again.");
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        viewpass = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pass = new enhance.CustomPF();
        username = new enhance.CustomTF();
        idlogin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        errormsg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barcodefield = new javax.swing.JTextField();
        splash = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(730, 501));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-");
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(650, 0, 20, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("x");
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(680, 0, 20, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-eyed-20.png"))); // NOI18N
        viewpass.setToolTipText("Show Password");
        viewpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewpassMouseClicked(evt);
            }
        });
        jPanel2.add(viewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(44, 88, 110));
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(53, 55, 75));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Password");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, 20));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(44, 88, 110));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(53, 55, 75));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Username");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 70, 20));

        pass.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        pass.setForeground(new java.awt.Color(53, 55, 75));
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 260, 40));

        username.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        username.setForeground(new java.awt.Color(53, 55, 75));
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
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, 40));

        idlogin.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        idlogin.setForeground(new java.awt.Color(153, 153, 153));
        idlogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idlogin.setText("Press F1 or Click Here to log-in using Identification Card");
        idlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idloginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idloginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                idloginMouseExited(evt);
            }
        });
        jPanel2.add(idlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 410, 320, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 70)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(120, 160, 131));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-welcome-50.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("LOG-IN");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 160, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Log-in to your account to continue");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 260, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Welcome Back");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, -1));

        errormsg.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        errormsg.setForeground(new java.awt.Color(255, 153, 153));
        jPanel2.add(errormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(390, 30, 340, 440);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logindashboard.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 500);

        barcodefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barcodefieldKeyPressed(evt);
            }
        });
        jPanel1.add(barcodefield);
        barcodefield.setBounds(530, 480, 180, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/opswift (3).gif"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout splashLayout = new javax.swing.GroupLayout(splash);
        splash.setLayout(splashLayout);
        splashLayout.setHorizontalGroup(
            splashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
            .addGroup(splashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(splashLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        splashLayout.setVerticalGroup(
            splashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(splashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(splashLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(splash);
        splash.setBounds(0, 0, 710, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usernamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamePropertyChange

    private void usernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameMouseReleased

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Action f1Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                barcodeTimer();
                
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1_pressed");
        this.getRootPane().getActionMap().put("F1_pressed", f1Action);
        
        Timer timer = new Timer(5000, (ActionEvent e) -> {
            splash.setVisible(false);
            username.setVisible(true);
            pass.setVisible(true);
            barcodefield.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_formWindowActivated

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        loginButton();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void idloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idloginMouseClicked
        barcodeTimer();
    }//GEN-LAST:event_idloginMouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered

    }//GEN-LAST:event_jPanel3MouseEntered

    private void idloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idloginMouseEntered
        idlogin.setForeground(new Color(80, 114, 123));
    }//GEN-LAST:event_idloginMouseEntered

    private void idloginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idloginMouseExited
        idlogin.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_idloginMouseExited

    private void viewpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewpassMouseClicked
        if(showPass){
            viewpass.setIcon(new ImageIcon("src/media/icons8-eyed-20.png"));
            pass.setEchoChar('*');
            viewpass.setToolTipText("Show Password");
        }else{
            viewpass.setIcon(new ImageIcon("src/media/icons8-eye-20.png"));
            pass.setEchoChar((char) 0);
            viewpass.setToolTipText("Hide Password");
        }
        
        showPass = !showPass;
    }//GEN-LAST:event_viewpassMouseClicked

    private void barcodefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodefieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            barcodeLogIn(barcodefield.getText());
        }
    }//GEN-LAST:event_barcodefieldKeyPressed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton();
        }
    }//GEN-LAST:event_usernameKeyPressed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton();
        }
    }//GEN-LAST:event_passKeyPressed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcodefield;
    private javax.swing.JLabel errormsg;
    private javax.swing.JLabel idlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPanel splash;
    private javax.swing.JTextField username;
    private javax.swing.JLabel viewpass;
    // End of variables declaration//GEN-END:variables
}
