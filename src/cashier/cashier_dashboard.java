/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier;

import config.dbConnector;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SCC1
 */
public class cashier_dashboard extends javax.swing.JInternalFrame {
    
    public ArrayList<Product> prod = new ArrayList<>();
    /**
     * Creates new form cashier_dashboard
     */
    public cashier_dashboard() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    
    public class Product{
        private String code;
        private String name;
        private double price;
        private int quantity;
        private double discount;
        private double beforeDiscount;
        private double discountedPrice;
        private double total;
        public boolean hasDiscount = false;

        public Product(String code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
            this.quantity = 1;
        }
        
        public void setQuantity(int qty){
            this.quantity = qty;
            this.beforeDiscount = this.price * this.quantity;
            this.discountedPrice = this.total - (this.total * 100.0);
        }
        
        public void setDiscount(double disc){
            this.discount = disc;
            this.beforeDiscount = this.price * this.quantity;
            hasDiscount = true;
        }
        
        public String getCode(){
            return this.code;
        }
        
        public String getName(){
            return this.name;
        }
        
        public double getPrice(){
            return this.price;
        }
        
        public int getQuantity(){
            return this.quantity;
        }
        
        public double getDiscount(){
            return this.discount;
        }
        
        public double getbeforeDiscount(){
            return this.beforeDiscount;
        }
        
        public double getdiscountedPrice(){
            this.discountedPrice = this.beforeDiscount - (this.beforeDiscount* (this.discount / 100.0));
            return this.discountedPrice;
        }
        
        public boolean hasDiscount(){
            return this.hasDiscount;
        }
        
        public double getTotal(){
            double ttal = 0;
            if(hasDiscount){
                if(this.quantity > 1){
                    ttal = this.beforeDiscount - (this.beforeDiscount * (this.discount/100.0));
                }else{
                    ttal = this.price * this.quantity;
                }
            }else{
                ttal = this.price * this.quantity;
            }
            return ttal;
        }
}
    
    
    public void scanProduct(String barcode){
        dbConnector connect = new dbConnector();
        
        int e_barcodeindex = 0;
        String name = null;
        String price = null;
        try{
            String query = "SELECT * FROM products  WHERE p_barcode = '" + barcode + "'";
            ResultSet resultSet = connect.getData(query);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int nextRow = model.getRowCount();

            boolean barcodeExists = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String bar = (String) model.getValueAt(i, 0);
                if (barcode.equals(bar)) {
                    barcodeExists = true;
                    e_barcodeindex = i;
                    break;
                }
            }
            
            
            if(resultSet.next()){
                if(barcodeExists){
                    
                    prod.get(e_barcodeindex).setQuantity((prod.get(e_barcodeindex).getQuantity()) + 1);
                    model.setValueAt(prod.get(e_barcodeindex).getQuantity(), e_barcodeindex, 3);
                    model.setValueAt(prod.get(e_barcodeindex).getTotal(), e_barcodeindex, 4);
                    displayInfo(e_barcodeindex);
                    table.setRowSelectionInterval(e_barcodeindex, e_barcodeindex);
                }else{
                    prod.add(new Product(resultSet.getString("p_barcode"), resultSet.getString("p_name"), resultSet.getDouble("p_price")));
                    model.addRow(new Object[]{prod.get(nextRow).getCode(), prod.get(nextRow).getName(), prod.get(nextRow).getPrice(), prod.get(nextRow).getQuantity(), prod.get(nextRow).getTotal()});
                    displayInfo(nextRow);
                    table.setRowSelectionInterval(nextRow, nextRow);
                }
            }else{
                System.out.println("Product not found!");
                
            }
            
            displayTotal(model);
            searchbar.setText("");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    
    
    public void updateQty() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String qtyString = JOptionPane.showInputDialog(null, "Enter quantity:");
            try {
                int qty = Integer.parseInt(qtyString);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                prod.get(selectedRow).setQuantity(qty);

                model.setValueAt(qty, selectedRow, 3);
                model.setValueAt(String.format("%.2f",prod.get(selectedRow).getTotal()), selectedRow, 4);
                displayInfo(selectedRow);
                displayTotal(model);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid quantity input!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
}
    
    public void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);
            prod.remove(selectedRow);
            displayTotal(model);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
        }
    }
    
    public void addDiscount() {
    int selectedRow = table.getSelectedRow();
   
    if (selectedRow != -1) {
        String discount = JOptionPane.showInputDialog(null, "Enter Discount Percentage:");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        prod.get(selectedRow).setDiscount(Double.parseDouble(discount));
        model.setValueAt(prod.get(selectedRow).getTotal(), selectedRow, 4);
        displayInfo(selectedRow);
        displayTotal(model);
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to apply discount!");
    }
}
    public void displayInfo(int index){
        pname_disp.setText("<html><body><center>"+prod.get(index).getName()+"</center></body></html>");
        code_disp.setText(prod.get(index).getCode());
        price_disp.setText(String.format("%.2f", prod.get(index).getPrice()));
        qty_disp.setText(String.format("%d", prod.get(index).getQuantity()));
        total_disp.setText(String.format("%.2f", prod.get(index).getTotal()));
        if(prod.get(index).hasDiscount){
            discount_disp.setText(String.format("%.2f - %.2f (%.0f)", prod.get(index).getbeforeDiscount(), prod.get(index).getdiscountedPrice(), prod.get(index).getDiscount()));
        }else{
            discount_disp.setText("---");
        }
    }
    
    public void displayTotal(DefaultTableModel model){
    double sum = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, 4);
        if (value instanceof Double) {
            sum += (Double) value;
        } else if (value instanceof String) {
            try {
                sum += Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                e.printStackTrace(); 
            }
        }
    }
    grandtotal_disp.setText(String.format("%.2f", sum));
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        code_disp = new javax.swing.JLabel();
        price_disp = new javax.swing.JLabel();
        qty_disp = new javax.swing.JLabel();
        total_disp = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pname_disp = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        discount_disp = new javax.swing.JLabel();
        searchbutton = new enhance.RoundBorder_g();
        jLabel10 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel9 = new enhance.RoundPanel();
        jPanel4 = new enhance.RoundBorder_w();
        grandtotal_disp = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Price:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Quantity:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(52, 73, 85));
        jLabel26.setText("Total:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Code:");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, -1));

        code_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        code_disp.setForeground(new java.awt.Color(80, 114, 123));
        code_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(code_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 150, 30));

        price_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        price_disp.setForeground(new java.awt.Color(80, 114, 123));
        price_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(price_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 150, 30));

        qty_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        qty_disp.setForeground(new java.awt.Color(80, 114, 123));
        qty_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(qty_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 150, 30));

        total_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        total_disp.setForeground(new java.awt.Color(80, 114, 123));
        total_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(total_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 150, 30));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Product Info");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        pname_disp.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        pname_disp.setForeground(new java.awt.Color(80, 114, 123));
        pname_disp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(pname_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 150));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 10));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-quantity-30.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_delete.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-discount-30.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(52, 73, 85));
        jLabel27.setText("Discount:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 70, -1));

        discount_disp.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        discount_disp.setForeground(new java.awt.Color(80, 114, 123));
        discount_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(discount_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 150, 30));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(530, 80, 250, 350);

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 40));

        jPanel1.add(searchbutton);
        searchbutton.setBounds(450, 30, 60, 40);

        searchbar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchbar.setForeground(new java.awt.Color(53, 55, 75));
        searchbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 160, 131), 1, true));
        searchbar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchbarMouseReleased(evt);
            }
        });
        searchbar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchbarPropertyChange(evt);
            }
        });
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchbarKeyPressed(evt);
            }
        });
        jPanel1.add(searchbar);
        searchbar.setBounds(30, 30, 410, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 480, 500);

        jPanel9.setBackground(new java.awt.Color(246, 244, 235));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(80, 114, 123));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grandtotal_disp.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        grandtotal_disp.setForeground(new java.awt.Color(255, 255, 255));
        grandtotal_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        grandtotal_disp.setText("00.00");
        jPanel4.add(grandtotal_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 212, 50));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Transaction Total:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 110, 30));

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 70));

        jPanel1.add(jPanel9);
        jPanel9.setBounds(530, 440, 250, 90);

        checkout.setText("CHECKOUT");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        jPanel1.add(checkout);
        checkout.setBounds(530, 540, 250, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        updateQty();

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        deleteItem();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        addDiscount();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM products WHERE p_id LIKE '%" + query + "%' OR p_barcode LIKE '%" + query + "%' OR p_name LIKE '%" + query + "%' OR p_qty LIKE '%" + query +"%' OR p_price LIKE '%" + query +"%' OR p_status LIKE '%" + query +"%'";

        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            scanProduct(searchbar.getText());
        }
    }//GEN-LAST:event_searchbarKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
        displayInfo(selectedRow);
    }//GEN-LAST:event_tableMouseClicked

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if(model.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "Transaction is empty!");
        }else{
            cashier_checkout checkout = new cashier_checkout(model, grandtotal_disp.getText());
            checkout.setVisible(true);
        }
    }//GEN-LAST:event_checkoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkout;
    private javax.swing.JLabel code_disp;
    private javax.swing.JLabel discount_disp;
    private javax.swing.JLabel grandtotal_disp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel pname_disp;
    private javax.swing.JLabel price_disp;
    private javax.swing.JLabel qty_disp;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JTable table;
    private javax.swing.JLabel total_disp;
    // End of variables declaration//GEN-END:variables
}
