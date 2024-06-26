package admin;

import static admin.adminMain.checkData;
import config.TableQueries;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class admin_productsEdit extends javax.swing.JFrame {

    public admin_productsEdit() {
        setUndecorated(true);
        initComponents();
        pop();
    }
    public int currentid;
    public String bc;
     public void pop(){
           supplierid.addItem("");
        try {
            
            ResultSet rs = connect.getData("SELECT * FROM suppliers");
            while(rs.next()){
                supplierid.addItem(rs.getString("s_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(admin_productsEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        wslbl.setVisible(false);
            supplierwholesale.setVisible(false);
            wslbl1.setVisible(false);
            supplierwholesale1.setVisible(false);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        barcode = new enhance.CustomTF();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        qty = new enhance.CustomTF();
        status = new javax.swing.JComboBox<>();
        error = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        name = new enhance.CustomTF();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        price = new enhance.CustomTF();
        jPanel10 = new enhance.RoundBorder_g()
        ;
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        supplierid = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        supplierprice = new enhance.CustomTF();
        suppliername = new javax.swing.JTextField();
        ws = new javax.swing.JRadioButton();
        wslbl = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        supplierwholesale = new enhance.CustomTF();
        wslbl1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        supplierwholesale1 = new enhance.CustomTF();
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
        barcode.setBackground(new java.awt.Color(204, 204, 204));
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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Supplier Information");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 20));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, -1));

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
        jPanel2.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

        status.setBackground(new java.awt.Color(44, 88, 110));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable" }));
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
        name.setBackground(new java.awt.Color(204, 204, 204));
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

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(" Retail Price");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        price.setForeground(new java.awt.Color(0, 51, 51));
        price.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                priceMouseReleased(evt);
            }
        });
        price.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pricePropertyChange(evt);
            }
        });
        jPanel2.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(44, 88, 110));
        jLabel14.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Supplier Name");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, -1));

        supplierid.setBackground(new java.awt.Color(44, 88, 110));
        supplierid.setEnabled(false);
        supplierid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                supplieridItemStateChanged(evt);
            }
        });
        supplierid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplieridMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplieridMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplieridMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supplieridMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplieridMouseReleased(evt);
            }
        });
        supplierid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplieridActionPerformed(evt);
            }
        });
        supplierid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                supplieridPropertyChange(evt);
            }
        });
        jPanel10.add(supplierid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(44, 88, 110));
        jLabel15.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Manufacturing Price");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, -1));

        supplierprice.setForeground(new java.awt.Color(0, 51, 51));
        supplierprice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplierpriceMouseReleased(evt);
            }
        });
        supplierprice.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                supplierpricePropertyChange(evt);
            }
        });
        jPanel10.add(supplierprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 230, 40));

        suppliername.setEditable(false);
        suppliername.setBackground(new java.awt.Color(204, 204, 204));
        suppliername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel10.add(suppliername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 40));

        ws.setBackground(new java.awt.Color(255, 255, 255));
        ws.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        ws.setForeground(new java.awt.Color(0, 51, 51));
        ws.setText("Allow Wholesale Manufacturing Price");
        ws.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wsItemStateChanged(evt);
            }
        });
        ws.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsActionPerformed(evt);
            }
        });
        jPanel10.add(ws, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 183, 190, 30));

        wslbl.setBackground(new java.awt.Color(255, 255, 255));
        wslbl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(44, 88, 110));
        jLabel16.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Wholesale Price");
        wslbl.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        jPanel10.add(wslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        supplierwholesale.setForeground(new java.awt.Color(0, 51, 51));
        supplierwholesale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplierwholesaleMouseReleased(evt);
            }
        });
        supplierwholesale.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                supplierwholesalePropertyChange(evt);
            }
        });
        jPanel10.add(supplierwholesale, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 40));

        wslbl1.setBackground(new java.awt.Color(255, 255, 255));
        wslbl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(44, 88, 110));
        jLabel17.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("per Item(s)");
        wslbl1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jPanel10.add(wslbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 60, -1));

        supplierwholesale1.setForeground(new java.awt.Color(0, 51, 51));
        supplierwholesale1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplierwholesale1MouseReleased(evt);
            }
        });
        supplierwholesale1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                supplierwholesale1PropertyChange(evt);
            }
        });
        jPanel10.add(supplierwholesale1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 90, 40));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 270, 280));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 560, 380);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Product");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 140, 40);

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

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void statusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusPropertyChange
        //        type_display.setText((String)type.getSelectedItem());
    }//GEN-LAST:event_statusPropertyChange

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseReleased

    private void namePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_namePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_namePropertyChange

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

        if(ws.isSelected()){
            if(name.getText().isEmpty()|| barcode.getText().isEmpty()|| qty.getText().isEmpty()||price.getText().isEmpty()||suppliername.getText().isEmpty()||supplierprice.getText().isEmpty()||supplierwholesale.getText().isEmpty()||supplierwholesale1.getText().isEmpty()){
                error.setText("*Please fill-out necessary information!");
            }else{
                TableQueries prod = new TableQueries();
                prod.updateProduct(currentid, Integer.parseInt(qty.getText()), Double.parseDouble(price.getText()),
                        status.getSelectedItem().toString(), Double.parseDouble(supplierprice.getText()),
                        true, Double.parseDouble(supplierwholesale.getText()), Integer.parseInt(supplierwholesale1.getText()));
            }
        }else{
            if(name.getText().isEmpty()|| barcode.getText().isEmpty()|| qty.getText().isEmpty()||price.getText().isEmpty()||suppliername.getText().isEmpty()||supplierprice.getText().isEmpty()){
                error.setText("*Please fill-out necessary information!");
            }else{
                TableQueries prod = new TableQueries();
                prod.updateProduct(currentid, Integer.parseInt(qty.getText()), Double.parseDouble(price.getText()),
                        status.getSelectedItem().toString(), Double.parseDouble(supplierprice.getText()),
                        false, 0, 0);
            }
            }
        

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void priceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_priceMouseReleased

    private void pricePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pricePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_pricePropertyChange

    private void supplieridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplieridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplieridActionPerformed

    private void supplieridPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_supplieridPropertyChange
  
    }//GEN-LAST:event_supplieridPropertyChange

    private void supplierpriceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierpriceMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierpriceMouseReleased

    private void supplierpricePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_supplierpricePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierpricePropertyChange
dbConnector connect = new dbConnector();
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
    }//GEN-LAST:event_formWindowActivated

    private void supplieridMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplieridMouseReleased
      
    }//GEN-LAST:event_supplieridMouseReleased

    private void supplieridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplieridMouseClicked
        
    }//GEN-LAST:event_supplieridMouseClicked

    private void supplieridMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplieridMouseEntered
    
    }//GEN-LAST:event_supplieridMouseEntered

    private void supplieridMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplieridMouseExited
      
    }//GEN-LAST:event_supplieridMouseExited

    private void supplieridMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplieridMousePressed
 
    }//GEN-LAST:event_supplieridMousePressed

    private void supplieridItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_supplieridItemStateChanged
        if(!(supplierid.getSelectedItem() == "")){
            try {
            ResultSet rs = connect.getData("SELECT * FROM suppliers WHERE s_id = '"+supplierid.getSelectedItem()+"'");
            if(rs.next()){
                suppliername.setText(rs.getString("s_name"));
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(admin_productsEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            suppliername.setText("");
        }
    }//GEN-LAST:event_supplieridItemStateChanged

    private void supplierwholesaleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierwholesaleMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierwholesaleMouseReleased

    private void supplierwholesalePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_supplierwholesalePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierwholesalePropertyChange

    private void wsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wsActionPerformed

    private void wsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wsItemStateChanged
        if(ws.isSelected()){
            wslbl.setVisible(true);
            supplierwholesale.setVisible(true);
            wslbl1.setVisible(true);
            supplierwholesale1.setVisible(true);
        }else{
            wslbl.setVisible(false);
            supplierwholesale.setVisible(false);
            wslbl1.setVisible(false);
            supplierwholesale1.setVisible(false);
        }
    }//GEN-LAST:event_wsItemStateChanged

    private void supplierwholesale1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierwholesale1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierwholesale1MouseReleased

    private void supplierwholesale1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_supplierwholesale1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierwholesale1PropertyChange

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
            java.util.logging.Logger.getLogger(admin_productsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_productsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_productsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_productsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new admin_productsEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField barcode;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField name;
    public javax.swing.JTextField price;
    public javax.swing.JTextField qty;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> supplierid;
    public javax.swing.JTextField suppliername;
    public javax.swing.JTextField supplierprice;
    public javax.swing.JTextField supplierwholesale;
    public javax.swing.JTextField supplierwholesale1;
    public javax.swing.JRadioButton ws;
    private javax.swing.JPanel wslbl;
    private javax.swing.JPanel wslbl1;
    // End of variables declaration//GEN-END:variables
}
