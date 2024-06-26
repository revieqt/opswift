package admin;

import static admin.adminMain.checkData;
import config.TableQueries;

public class admin_supplierAdd extends javax.swing.JFrame {

    public admin_supplierAdd() {
        setUndecorated(true);
        initComponents();
    }
    
    
    public static boolean isValidNumber(String str) {
        String regex = "\\d{11}";
        return str.matches(regex);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        num = new enhance.CustomTF();
        error = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        name = new enhance.CustomTF();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        address = new enhance.CustomTF();
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
        jLabel9.setText("Contact No.");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, -1));

        num.setForeground(new java.awt.Color(0, 51, 51));
        num.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                numMouseReleased(evt);
            }
        });
        num.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                numPropertyChange(evt);
            }
        });
        jPanel2.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

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
        jLabel10.setText("Name");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        name.setForeground(new java.awt.Color(0, 51, 51));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nameMouseReleased(evt);
            }
        });
        name.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                namePropertyChange(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 40));

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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Address");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, -1));

        address.setForeground(new java.awt.Color(0, 51, 51));
        address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addressMouseReleased(evt);
            }
        });
        address.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                addressPropertyChange(evt);
            }
        });
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 40));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 290, 380);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Supplier");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 260, 40);

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

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseReleased

    private void namePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_namePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_namePropertyChange

    private void numMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_numMouseReleased

    private void numPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_numPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_numPropertyChange

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if(name.getText().isEmpty()||address.getText().isEmpty()|| num.getText().isEmpty()){
            error.setText("*Please fill-out necessary information!");
        }else if(!isValidNumber(num.getText())){
            error.setText("*Invalid Contact Number!");
        }else{
            if(checkData("*","suppliers","s_contact",num.getText())){
                error.setText("*Contact Number already Taken!");
            }else{
                TableQueries sup = new TableQueries();
                sup.addSupplier(name.getText(), address.getText(), num.getText());
                this.dispose();
            }
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void addressMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_addressMouseReleased

    private void addressPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_addressPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_addressPropertyChange

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
            java.util.logging.Logger.getLogger(admin_supplierAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_supplierAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_supplierAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_supplierAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new admin_supplierAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField name;
    private javax.swing.JTextField num;
    // End of variables declaration//GEN-END:variables
}
