package admin;

import static admin.adminMain.checkData;
import config.ImportImages;
import config.TableQueries;
import config.dbConnector;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class admin_staffEdit extends javax.swing.JFrame {
    
    public int id;
    public String current_username;
    
    public admin_staffEdit() {
        setUndecorated(true);
        initComponents();
    }
    ImportImages imp = new ImportImages();
    dbConnector connect = new dbConnector();
    public void accessTable(TableModel model, int rowid){
        id = Integer.parseInt(model.getValueAt(rowid, 0).toString());
        current_username = model.getValueAt(rowid, 4).toString();
        fname.setText(model.getValueAt(rowid, 2).toString());
        lname.setText(model.getValueAt(rowid, 3).toString());
        username.setText(current_username);
        
        try {
            ResultSet rs = connect.getData("SELECT * FROM users WHERE u_id = "+ model.getValueAt(rowid, 0).toString());
            if(rs.next()){
                img.setIcon(imp.ResizeImage(rs.getString("u_img"), null, img));
                imp.oldpath = rs.getString("u_img");
                imp.path = rs.getString("u_img");
                imp.destination = rs.getString("u_img");
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if((model.getValueAt(rowid, 5).toString()).equals("Administrator")){
            type.setSelectedItem("Administrator");
        }else if((model.getValueAt(rowid, 5).toString()).equals("Cashier")){
            type.setSelectedItem("Cashier");
        }else{
            type.setSelectedItem("Accountant");
        }
        
        if((model.getValueAt(rowid, 6).toString()).equals("Active")){
            status.setSelectedItem("Active");
        }else{
            status.setSelectedItem("Inactive");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lname = new enhance.CustomTF();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        username = new enhance.CustomTF();
        status = new javax.swing.JComboBox<>();
        error = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fname = new enhance.CustomTF();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jPanel9 = new enhance.RoundBorder_g()
        ;
        remove = new javax.swing.JButton();
        browse = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Staff");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 120, 40);

        jPanel2.setBackground(new java.awt.Color(80, 114, 123));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Identification Photo");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 20));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 110, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(44, 88, 110));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Last Name*");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lname.setForeground(new java.awt.Color(0, 51, 51));
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lnameMouseReleased(evt);
            }
        });
        lname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lnamePropertyChange(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Username*");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

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
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

        status.setBackground(new java.awt.Color(44, 88, 110));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        status.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statusPropertyChange(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 40));

        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(153, 0, 0));
        error.setText(".");
        jPanel2.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 190, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("First Name*");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

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
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 40));

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
        jLabel3.setText("Edit");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 130, 40));

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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 130, 40));

        type.setBackground(new java.awt.Color(44, 88, 110));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Cashier", "Accountant" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        type.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                typePropertyChange(evt);
            }
        });
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        remove.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        remove.setText("Remove Image");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel9.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 120, 30));

        browse.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel9.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, 30));
        jPanel9.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 240));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 270, 300));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 560, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameMouseReleased

    private void lnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lnamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lnamePropertyChange

    private void usernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameMouseReleased

    private void usernamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usernamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamePropertyChange

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void statusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusPropertyChange
        //        type_display.setText((String)type.getSelectedItem());
    }//GEN-LAST:event_statusPropertyChange

    private void fnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameMouseReleased

    private void fnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fnamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fnamePropertyChange

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        boolean proceed = false;
        
        if(fname.getText().isEmpty()|| lname.getText().isEmpty()|| username.getText().isEmpty()){
            error.setText("*Please fill-out necessary information!");
        }else{
            boolean ok = false;
            boolean imgx = false;
            if(checkData("*","users","u_username",username.getText())){
                if(current_username.equals(username.getText())){
                    ok = true;
                }else{
                    error.setText("*Username already exists!");
                }
            }
            if(img.getIcon()==null){
                error.setText("*Please insert an Image!");
            }else{
                imgx = true;
            }
            if(ok && imgx){
                proceed=true;
            }
            
        }
        
        if(proceed){
            TableQueries user = new TableQueries();
             if(imp.destination.isEmpty()){
                    File existing = new File(imp.oldpath);
                    if(existing.exists()){
                        existing.delete();
                    }
                }else{
                    if(!(imp.oldpath.equals(imp.path))){
                        imp.imageUpdater(imp.oldpath,imp.path);
                    }
                }
            user.updateUser(id, fname.getText(),lname.getText(), username.getText(), (String)type.getSelectedItem(), (String)status.getSelectedItem(), imp.destination);
           
            this.dispose();
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void typePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_typePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_typePropertyChange

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        browse.setEnabled(true);
        img.setIcon(null);
        imp.destination = "";
        imp.path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                imp.selectedFile = fileChooser.getSelectedFile();
                imp.destination = "src/imported_img/" + imp.selectedFile.getName();
                imp.path  = imp.selectedFile.getAbsolutePath();

                if(imp.FileExistenceChecker(imp.path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    imp.destination = "";
                    imp.path="";
                }else{
                    img.setIcon(imp.ResizeImage(imp.path, null, img));
                    browse.setEnabled(false);
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_browseActionPerformed

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
            java.util.logging.Logger.getLogger(admin_staffEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_staffEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_staffEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_staffEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new admin_staffEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton browse;
    private javax.swing.JLabel error;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField lname;
    public javax.swing.JButton remove;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
