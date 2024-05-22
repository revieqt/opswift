package cashier;

import config.Session;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import login.loginForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SCC1
 */
public class cashierMain extends javax.swing.JFrame {

    public cashierMain() {
        initComponents();
        setTitle("Opswift POS");
        cashier_dashboard up = new cashier_dashboard();
        cashier_desktop.add(up).setVisible(true);;
        Timer timer = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDateTime();
            }
        });
        timer.start();
        
    }
    
    Color bgcolor = new Color(246,244,235);
    Color sidecolor = new Color(52,73,85);
    Color text1color = new Color(120, 160, 131);
    boolean search_open = false;
    boolean void_open = false;
    boolean customers_open = false;
    boolean sales_open = false;
    boolean settings_open = false;
    
    public void setDateTime(){
        Date now = new Date();
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(now);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String date = dateFormat.format(now);
        
        date_disp.setText(date);
        time_disp.setText(time);
    }
    
    public void setDash(){
        cashier_dashboard up = new cashier_dashboard();
        cashier_desktop.add(up).setVisible(true);;
    }
    
    public void resetMenu(){
        search_open = false;
        searchButton.setBackground(sidecolor);
        jLabel11.setForeground(text1color);
        jLabel11.setFont(new Font(jLabel11.getFont().getFontName(), Font.PLAIN, jLabel11.getFont().getSize()));
        
        void_open = false;
        voidButton.setBackground(sidecolor);
        jLabel16.setForeground(text1color);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.PLAIN, jLabel16.getFont().getSize()));
        
        customers_open = false;
        customerButton.setBackground(sidecolor);
        jLabel17.setForeground(text1color);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.PLAIN, jLabel17.getFont().getSize()));
        
        sales_open = false;
        salesButton.setBackground(sidecolor);
        jLabel18.setForeground(text1color);
        jLabel18.setFont(new Font(jLabel18.getFont().getFontName(), Font.PLAIN, jLabel18.getFont().getSize()));
        
        settings_open = false;
        jPanel13.setBackground(sidecolor);
        jLabel20.setForeground(text1color);
        jLabel20.setFont(new Font(jLabel20.getFont().getFontName(), Font.PLAIN, jLabel20.getFont().getSize()));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        voidButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchButton = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customerButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();
        salesButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        userLog = new javax.swing.JLabel();
        codeLog = new javax.swing.JLabel();
        date_disp = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundBorder_g();
        cashier_desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(52, 73, 85));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voidButton.setBackground(new java.awt.Color(52, 73, 85));
        voidButton.setToolTipText("[F3] Products");
        voidButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voidButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voidButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voidButtonMouseExited(evt);
            }
        });
        voidButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons-void-20.png"))); // NOI18N
        voidButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(120, 160, 131));
        jLabel16.setText("Void Transaction");
        voidButton.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        jPanel5.add(voidButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/opswift-removebg-preview (3).png"))); // NOI18N
        jLabel4.setToolTipText("[F1] Back to Dashboard");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        searchButton.setBackground(new java.awt.Color(52, 73, 85));
        searchButton.setToolTipText("[F2] Staff");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButtonMouseExited(evt);
            }
        });
        searchButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(120, 160, 131));
        jLabel11.setText("Search Product");
        searchButton.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchButton.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel5.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        jPanel13.setBackground(new java.awt.Color(52, 73, 85));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(120, 160, 131));
        jLabel20.setText("Settings");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_settings_20.png"))); // NOI18N
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel5.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 150, 30));

        customerButton.setBackground(new java.awt.Color(52, 73, 85));
        customerButton.setToolTipText("[F4] Customers");
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });
        customerButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_user_20.png"))); // NOI18N
        customerButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(120, 160, 131));
        jLabel17.setText("Customer Loyalty");
        customerButton.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        jPanel5.add(customerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 30));

        time_disp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        time_disp.setForeground(new java.awt.Color(255, 255, 255));
        time_disp.setText("hh-mm-ss");
        jPanel5.add(time_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, -1));

        salesButton.setBackground(new java.awt.Color(52, 73, 85));
        salesButton.setToolTipText("[F5] Sales");
        salesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesButtonMouseExited(evt);
            }
        });
        salesButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_sales_20.png"))); // NOI18N
        salesButton.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(120, 160, 131));
        jLabel18.setText("Sales");
        salesButton.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(salesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 30));

        jPanel2.setBackground(new java.awt.Color(52, 73, 85));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_logout.png"))); // NOI18N
        jLabel2.setToolTipText("Log-out");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 0, 40, 50));

        userLog.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userLog.setForeground(new java.awt.Color(255, 255, 255));
        userLog.setText("John Doe");
        userLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userLogMouseEntered(evt);
            }
        });
        jPanel2.add(userLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 39));

        codeLog.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        codeLog.setForeground(new java.awt.Color(120, 160, 131));
        codeLog.setText("jLabel10");
        jPanel2.add(codeLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 24, 80, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 170, 50));

        date_disp.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        date_disp.setForeground(new java.awt.Color(255, 255, 255));
        date_disp.setText("dd/mm/yyyy");
        jPanel5.add(date_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, -1));

        jPanel3.setBackground(new java.awt.Color(52, 73, 85));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 60));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 170, 610);

        javax.swing.GroupLayout cashier_desktopLayout = new javax.swing.GroupLayout(cashier_desktop);
        cashier_desktop.setLayout(cashier_desktopLayout);
        cashier_desktopLayout.setHorizontalGroup(
            cashier_desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        cashier_desktopLayout.setVerticalGroup(
            cashier_desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel1.add(cashier_desktop);
        cashier_desktop.setBounds(170, 0, 810, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voidButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseClicked
        resetMenu();
        voidButton.setBackground(new Color(80, 114, 123));
        jLabel16.setForeground(Color.WHITE);
        jLabel16.setFont(new Font(jLabel20.getFont().getFontName(), Font.BOLD, jLabel20.getFont().getSize()));
        
        void_open = true;
        
        cashierMain redo = new cashierMain();
        redo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voidButtonMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loginForm open = new loginForm();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        resetMenu();
        searchButton.setBackground(new Color(80, 114, 123));
        jLabel11.setForeground(Color.WHITE);
        jLabel11.setFont(new Font(jLabel20.getFont().getFontName(), Font.BOLD, jLabel20.getFont().getSize()));
        
        search_open = true;
        cashier_products up = new cashier_products();
        cashier_desktop.add(up).setVisible(true);; 
    }//GEN-LAST:event_searchButtonMouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        resetMenu();
        jPanel13.setBackground(new Color(80, 114, 123));
        jLabel20.setForeground(Color.WHITE);
        jLabel20.setFont(new Font(jLabel20.getFont().getFontName(), Font.BOLD, jLabel20.getFont().getSize()));
        
        settings_open = true;
    }//GEN-LAST:event_jPanel13MouseClicked

    private void customerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseClicked
        resetMenu();
        customerButton.setBackground(new Color(80, 114, 123));
        jLabel17.setForeground(Color.WHITE);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.BOLD, jLabel17.getFont().getSize()));
        
        customers_open = true;
    }//GEN-LAST:event_customerButtonMouseClicked

    private void salesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseClicked
        resetMenu();
        
        salesButton.setBackground(new Color(80, 114, 123));
        jLabel18.setForeground(Color.WHITE);
        jLabel18.setFont(new Font(jLabel18.getFont().getFontName(), Font.BOLD, jLabel18.getFont().getSize()));
        
        sales_open = true;
    }//GEN-LAST:event_salesButtonMouseClicked

    private void searchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseEntered
        if(search_open == false){
            jLabel11.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_searchButtonMouseEntered

    private void searchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseExited
        if(search_open == false){
            jLabel11.setForeground(text1color);
        }
    }//GEN-LAST:event_searchButtonMouseExited

    private void voidButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseEntered
        if(void_open == false){
            jLabel16.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_voidButtonMouseEntered

    private void voidButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseExited
        if(void_open == false){
            jLabel16.setForeground(text1color);
        }
    }//GEN-LAST:event_voidButtonMouseExited

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        if(customers_open == false){
            jLabel17.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_customerButtonMouseEntered

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        if(customers_open == false){
            jLabel17.setForeground(text1color);
        }
    }//GEN-LAST:event_customerButtonMouseExited

    private void salesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseEntered
        if(sales_open == false){
            jLabel18.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_salesButtonMouseEntered

    private void salesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseExited
        if(sales_open == false){
            jLabel18.setForeground(text1color);
        }
    }//GEN-LAST:event_salesButtonMouseExited

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        if(settings_open == false){
            jLabel20.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        if(settings_open == false){
            jLabel20.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel13MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

    }//GEN-LAST:event_jLabel4MouseClicked

    private void userLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userLogMouseEntered

    private void userLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogMouseClicked
        cashier_profile up = new cashier_profile();
        cashier_desktop.add(up).setVisible(true);;
    }//GEN-LAST:event_userLogMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        userLog.setText(sess.getFname() + " " + sess.getLname());
        codeLog.setText(sess.getCode());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>\
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane cashier_desktop;
    private javax.swing.JLabel codeLog;
    private javax.swing.JPanel customerButton;
    private javax.swing.JLabel date_disp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel salesButton;
    private javax.swing.JPanel searchButton;
    private javax.swing.JLabel time_disp;
    private javax.swing.JLabel userLog;
    private javax.swing.JPanel voidButton;
    // End of variables declaration//GEN-END:variables
}
