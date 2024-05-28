package admin;

import config.ImportImages;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import login.loginForm;
import net.proteanit.sql.DbUtils;

public class admin_profile extends javax.swing.JInternalFrame {

    public admin_profile() {
        
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
        username_disp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        jLabel1.setBounds(50, 190, 140, 140);

        username.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        jPanel1.add(username);
        username.setBounds(210, 240, 280, 30);

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 73, 85));
        jLabel3.setText("Recent Activity");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 310, 310, 40);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(240, 340, 540, 10);

        log.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date and Time", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(log);
        if (log.getColumnModel().getColumnCount() > 0) {
            log.getColumnModel().getColumn(0).setResizable(false);
            log.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(240, 350, 540, 230);

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

        username_disp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username_disp.setText("Username:");
        jPanel6.add(username_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Change Username");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, -1));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Change Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(20, 340, 200, 240);

        name.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name of the User");
        jPanel1.add(name);
        name.setBounds(210, 210, 420, 35);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/headerdash.png"))); // NOI18N
        jPanel1.add(jLabel25);
        jLabel25.setBounds(0, 80, 810, 200);

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
        username.setText(sess.getCode()+" - "+ sess.getType());
        id_disp1.setText("User ID: "+sess.getId());
        name_disp1.setText("Name: "+ sess.getFname()+" "+ sess.getLname());
        code_disp1.setText("Code: "+ sess.getCode());
        type_disp1.setText("Type: "+sess.getType());
        status_disp1.setText("Status: "+ sess.getStatus());
        username_disp.setText("Username: "+sess.getUsername() );
        
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
            DefaultTableModel tblmod = (DefaultTableModel)log.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbDateTime = rs.getString("l_datetime");
                String dbAction = rs.getString("l_action");
                
                String table[] = {dbDateTime, dbAction};
                
                tblmod.addRow(table);
                }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_formInternalFrameActivated
Session sess = Session.getInstance();
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        admin_profileSecurity s = new admin_profileSecurity();
        s.username.setEditable(false);
        s.username.setBackground(Color.LIGHT_GRAY);
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        admin_profileSecurity s = new admin_profileSecurity();
        s.currentpass.setEditable(false);
        s.newpass.setEditable(false);
        s.confirmpass.setEditable(false);
        s.currentpass.setBackground(Color.LIGHT_GRAY);
        s.newpass.setBackground(Color.LIGHT_GRAY);
        s.confirmpass.setBackground(Color.LIGHT_GRAY);
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code_disp1;
    private javax.swing.JLabel date_disp;
    private javax.swing.JLabel id_disp1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel status_disp1;
    private javax.swing.JLabel time_disp;
    private javax.swing.JLabel type_disp1;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username_disp;
    // End of variables declaration//GEN-END:variables
}
