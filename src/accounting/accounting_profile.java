package accounting;

import admin.*;
import config.ImportImages;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import login.loginForm;
import net.proteanit.sql.DbUtils;

public class accounting_profile extends javax.swing.JInternalFrame {

    public accounting_profile() {
        
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    public void userInfo(int adminID){
        
    }
    ImportImages imp = new ImportImages();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Session sess = Session.getInstance();
        jLabel1 = new enhance.CircularImageLabel(sess.getImage());
        username = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        name_disp1 = new javax.swing.JLabel();
        id_disp1 = new javax.swing.JLabel();
        code_disp1 = new javax.swing.JLabel();
        type_disp1 = new javax.swing.JLabel();
        status_disp1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel7 = new enhance.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username_disp = new javax.swing.JLabel();
        pass_disp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel10 = new enhance.RoundBorder_g();
        date_disp = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 200, 140, 140);

        username.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        jPanel1.add(username);
        username.setBounds(210, 250, 170, 30);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 73, 85));
        jLabel3.setText("Activity Log");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 320, 310, 40);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(240, 350, 540, 10);

        log.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(log);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(240, 360, 540, 230);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name_disp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        name_disp1.setText("Name:");
        jPanel6.add(name_disp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        id_disp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        id_disp1.setText("ID:");
        jPanel6.add(id_disp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        code_disp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        code_disp1.setText("Code:");
        jPanel6.add(code_disp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        type_disp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        type_disp1.setText("Type:");
        jPanel6.add(type_disp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        status_disp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        status_disp1.setText("Status:");
        jPanel6.add(status_disp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(52, 73, 85));
        jLabel9.setText("User Information");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 0));

        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("LOGOUT");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 0, 100, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 180, 40));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 73, 85));
        jLabel4.setText("Security");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        username_disp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username_disp.setText("Username:");
        jPanel6.add(username_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        pass_disp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pass_disp.setText("Password:");
        jPanel6.add(pass_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(120, 160, 131));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-edit-15.png"))); // NOI18N
        jLabel8.setText("Edit");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(20, 350, 200, 240);

        name.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name of the User");
        jPanel1.add(name);
        name.setBounds(210, 220, 420, 35);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/headerdash.png"))); // NOI18N
        jPanel1.add(jLabel25);
        jLabel25.setBounds(0, 80, 810, 210);

        jSeparator5.setForeground(new java.awt.Color(120, 160, 131));
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(10, 70, 790, 10);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date_disp.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        date_disp.setForeground(new java.awt.Color(120, 160, 131));
        date_disp.setText("dd/mm/yyyy");
        jPanel10.add(date_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 40));

        time_disp.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        time_disp.setForeground(new java.awt.Color(120, 160, 131));
        time_disp.setText("hh-mm-ss");
        jPanel10.add(time_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 40));

        jPanel1.add(jPanel10);
        jPanel10.setBounds(620, 20, 170, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        Session sess = Session.getInstance();
        name.setText(sess.getFname()+" "+ sess.getLname());
        username.setText(sess.getCode());
        id_disp1.setText("User ID: "+sess.getId());
        name_disp1.setText("Name: "+ sess.getFname()+" "+ sess.getLname());
        code_disp1.setText("Code: "+ sess.getCode());
        type_disp1.setText("Type: "+sess.getType());
        status_disp1.setText("Status: "+ sess.getStatus());
        username_disp.setText("Username: "+sess.getUsername() +" - Administrator");
        pass_disp.setText("Password: "+sess.getPassword());
        
        Date now = new Date();
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(now);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String date = dateFormat.format(now);
        
        date_disp.setText(date);
        time_disp.setText(time);
        
        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData("SELECT * FROM logs WHERE l_staff = "+ sess.getId());
            log.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code_disp1;
    private javax.swing.JLabel date_disp;
    private javax.swing.JLabel id_disp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable log;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name_disp1;
    private javax.swing.JLabel pass_disp;
    private javax.swing.JLabel status_disp1;
    private javax.swing.JLabel time_disp;
    private javax.swing.JLabel type_disp1;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username_disp;
    // End of variables declaration//GEN-END:variables
}
