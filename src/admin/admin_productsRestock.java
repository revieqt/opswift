package admin;


import config.TableQueries;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class admin_productsRestock extends javax.swing.JFrame {

    public admin_productsRestock() {
        setUndecorated(true);
        initComponents();
    }
    public int id;
    dbConnector connect = new dbConnector();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        barcode = new enhance.CustomTF();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        qty = new enhance.CustomTF();
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
        date = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
        jLabel9.setText("Barcode");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        barcode.setEditable(false);
        barcode.setForeground(new java.awt.Color(0, 51, 51));
        barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                barcodeMouseReleased(evt);
            }
        });
        barcode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                barcodePropertyChange(evt);
            }
        });
        jPanel2.add(barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Quantity");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        qty.setForeground(new java.awt.Color(0, 51, 51));
        qty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                qtyMouseReleased(evt);
            }
        });
        qty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                qtyPropertyChange(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        jPanel2.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

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
        jLabel10.setText("Name");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        name.setEditable(false);
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
        jLabel3.setText("Order");
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
        jLabel12.setText("Receive on");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, -1));

        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setForeground(new java.awt.Color(0, 51, 51));
        date.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Total:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 40, -1));

        total.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        total.setText("0.00");
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 190, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 290, 380);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Restock Product");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 180, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barcodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcodeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeMouseReleased

    private void barcodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_barcodePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodePropertyChange

    private void qtyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qtyMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMouseReleased

    private void qtyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_qtyPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyPropertyChange

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseReleased

    private void namePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_namePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_namePropertyChange

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        try{
            if(qty.getText().isEmpty() || date.getDate().toString().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill-Up all Fields!");
            }else{
                ResultSet rs = connect.getData("SELECT * FROM products WHERE p_id = "+id);
                if(rs.next()){
                    int supplier = rs.getInt("p_supplier");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dt = dateFormat.format(date.getDate());
                    TableQueries add = new TableQueries();
                    add.addOrder(id, supplier, Integer.parseInt(qty.getText()), Double.parseDouble(total.getText()), dt);
                    this.dispose();
                }
            }
        }catch(SQLException | NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Please Fill-Up all Fields!");
        }
        

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
    }//GEN-LAST:event_formWindowActivated

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        if(!qty.getText().isEmpty()){
            try {
                ResultSet rs = connect.getData("SELECT * FROM products WHERE p_id = "+id);
                if(rs.next()){
                    if(rs.getBoolean("p_ws")){
                        if(rs.getInt("p_wsitem")<= Integer.parseInt(qty.getText())){
                            total.setText(""+(rs.getDouble("p_wsprice")*Integer.parseInt(qty.getText())));
                        }else{
                            total.setText(""+(rs.getDouble("p_mprice")*Integer.parseInt(qty.getText())));
                        }
                        
                    }else{
                        total.setText(""+(rs.getDouble("p_mprice")*Integer.parseInt(qty.getText())));
                    }
                }
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(admin_productsRestock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_qtyKeyTyped

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        if(!qty.getText().isEmpty()){
            try {
                ResultSet rs = connect.getData("SELECT * FROM products WHERE p_id = "+id);
                if(rs.next()){
                    if(rs.getBoolean("p_ws")){
                        if(rs.getInt("p_wsitem")<= Integer.parseInt(qty.getText())){
                            total.setText(""+(rs.getDouble("p_wsprice")*Integer.parseInt(qty.getText())));
                        }else{
                            total.setText(""+(rs.getDouble("p_mprice")*Integer.parseInt(qty.getText())));
                        }
                        
                    }else{
                        total.setText(""+(rs.getDouble("p_mprice")*Integer.parseInt(qty.getText())));
                    }
                }
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(admin_productsRestock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_qtyKeyReleased

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
            java.util.logging.Logger.getLogger(admin_productsRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_productsRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_productsRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_productsRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new admin_productsRestock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField barcode;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel8;
    public javax.swing.JTextField name;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
