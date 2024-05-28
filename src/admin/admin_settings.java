package admin;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class admin_settings extends javax.swing.JInternalFrame {
    
    public admin_settings() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new enhance.RoundBorder_g();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fname = new enhance.CustomTF();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        fname1 = new enhance.CustomTF();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        fname2 = new enhance.CustomTF();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        fname3 = new enhance.CustomTF();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        fname4 = new enhance.CustomTF();
        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel4 = new enhance.RoundPanel_lb();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Company Information");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 40));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 130, 120));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Company Name");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 20));

        fname.setForeground(new java.awt.Color(0, 51, 51));
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fnameMouseReleased(evt);
            }
        });
        fname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fnamePropertyChange(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Company Name");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 20));

        fname1.setForeground(new java.awt.Color(0, 51, 51));
        fname1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fname1MouseReleased(evt);
            }
        });
        fname1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fname1PropertyChange(evt);
            }
        });
        jPanel1.add(fname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 220, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Company Name");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 80, 20));

        fname2.setForeground(new java.awt.Color(0, 51, 51));
        fname2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fname2MouseReleased(evt);
            }
        });
        fname2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fname2PropertyChange(evt);
            }
        });
        jPanel1.add(fname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 220, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Company Name");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 80, 20));

        fname3.setForeground(new java.awt.Color(0, 51, 51));
        fname3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fname3MouseReleased(evt);
            }
        });
        fname3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fname3PropertyChange(evt);
            }
        });
        jPanel1.add(fname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 220, 40));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Company Name");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 80, 20));

        fname4.setForeground(new java.awt.Color(0, 51, 51));
        fname4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fname4MouseReleased(evt);
            }
        });
        fname4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fname4PropertyChange(evt);
            }
        });
        jPanel1.add(fname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 220, 40));

        main_panel.setBackground(new java.awt.Color(246, 244, 235));
        main_panel.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        main_panel.add(jSeparator1);
        jSeparator1.setBounds(30, 60, 750, 10);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Settings");
        main_panel.add(jLabel1);
        jLabel1.setBounds(30, 20, 200, 40);

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(52, 73, 85));
        jLabel22.setText("About the System");
        main_panel.add(jLabel22);
        jLabel22.setBounds(40, 440, 200, 21);

        jRadioButton1.setBackground(new java.awt.Color(246, 244, 235));
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setText("Dark");
        main_panel.add(jRadioButton1);
        jRadioButton1.setBounds(80, 400, 170, 23);

        jRadioButton3.setBackground(new java.awt.Color(246, 244, 235));
        jRadioButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton3.setText("Electric");
        main_panel.add(jRadioButton3);
        jRadioButton3.setBounds(80, 380, 170, 20);

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(52, 73, 85));
        jLabel23.setText("System Preferences");
        main_panel.add(jLabel23);
        jLabel23.setBounds(40, 260, 160, 21);

        jRadioButton4.setBackground(new java.awt.Color(246, 244, 235));
        jRadioButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton4.setText("Display Organization Information");
        jRadioButton4.setToolTipText("");
        main_panel.add(jRadioButton4);
        jRadioButton4.setBounds(60, 290, 210, 23);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 51));
        jLabel32.setText("Themes:");
        main_panel.add(jLabel32);
        jLabel32.setBounds(60, 340, 73, 15);

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Organization Information");
        main_panel.add(jLabel24);
        jLabel24.setBounds(40, 80, 200, 21);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("(Recommended: PNG File Type, Transparent Background)");
        main_panel.add(jLabel33);
        jLabel33.setBounds(180, 130, 290, 20);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 51));
        jLabel34.setText("Name: Opswift Point of Sales System");
        main_panel.add(jLabel34);
        jLabel34.setBounds(60, 470, 240, 15);

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 51));
        jLabel35.setText("Version: V. 1.0");
        main_panel.add(jLabel35);
        jLabel35.setBounds(60, 490, 240, 15);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 51));
        jLabel36.setText("Language: Java, SQL");
        main_panel.add(jLabel36);
        jLabel36.setBounds(60, 510, 240, 15);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 51));
        jLabel38.setText("Developer: Joshua Opsima");
        main_panel.add(jLabel38);
        jLabel38.setBounds(60, 530, 240, 15);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        main_panel.add(jTextField1);
        jTextField1.setBounds(180, 150, 210, 30);
        main_panel.add(jSeparator2);
        jSeparator2.setBounds(40, 100, 460, 10);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        main_panel.add(jTextField2);
        jTextField2.setBounds(180, 180, 300, 30);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 51));
        jLabel41.setText("Address:");
        main_panel.add(jLabel41);
        jLabel41.setBounds(60, 180, 120, 30);

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 51));
        jLabel42.setText("TIN Number:");
        main_panel.add(jLabel42);
        jLabel42.setBounds(60, 210, 120, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        main_panel.add(jTextField3);
        jTextField3.setBounds(180, 210, 210, 30);
        main_panel.add(jSeparator3);
        jSeparator3.setBounds(40, 460, 450, 20);
        main_panel.add(jSeparator5);
        jSeparator5.setBounds(40, 280, 450, 20);

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 51, 51));
        jLabel43.setText("Organization Name:");
        main_panel.add(jLabel43);
        jLabel43.setBounds(60, 150, 120, 30);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 51));
        jLabel37.setText("Organization Logo:");
        main_panel.add(jLabel37);
        jLabel37.setBounds(60, 110, 120, 20);

        jButton3.setText("Add Image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        main_panel.add(jButton3);
        jButton3.setBounds(180, 110, 210, 23);

        jRadioButton5.setBackground(new java.awt.Color(246, 244, 235));
        jRadioButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton5.setText("Verdant (Default)");
        jRadioButton5.setToolTipText("");
        main_panel.add(jRadioButton5);
        jRadioButton5.setBounds(80, 360, 170, 23);

        jRadioButton6.setBackground(new java.awt.Color(246, 244, 235));
        jRadioButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Disable Animations (PC Friendly)");
        jRadioButton6.setToolTipText("");
        main_panel.add(jRadioButton6);
        jRadioButton6.setBounds(60, 310, 220, 23);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameMouseReleased

    private void fnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fnamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fnamePropertyChange

    private void fname1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fname1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1MouseReleased

    private void fname1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fname1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1PropertyChange

    private void fname2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fname2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fname2MouseReleased

    private void fname2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fname2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fname2PropertyChange

    private void fname3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fname3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fname3MouseReleased

    private void fname3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fname3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fname3PropertyChange

    private void fname4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fname4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fname4MouseReleased

    private void fname4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fname4PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fname4PropertyChange

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname1;
    private javax.swing.JTextField fname2;
    private javax.swing.JTextField fname3;
    private javax.swing.JTextField fname4;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel main_panel;
    // End of variables declaration//GEN-END:variables
}
