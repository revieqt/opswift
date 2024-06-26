package admin;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class admin_orders extends javax.swing.JInternalFrame {

    public admin_orders() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);  
        displayTable();
    }
    
    public void displayTable(){
        dbConnector connect = new dbConnector();
        try {
            ResultSet rs = connect.getData("SELECT o_id AS ID, o_product AS Product, o_supplier AS Supplier, o_qty AS Quantity, o_total AS Total,"
                    + " o_orderedon AS Ordered, o_recieveon AS Recieve, o_status AS Status FROM orders WHERE o_status = 'Pending'");
            products_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(admin_orders.class.getName()).log(Level.SEVERE, null, ex);
        }
        pending.setText(""+connect.pendingCount());
        expected.setText(""+connect.expectedCount());
        recieved.setText(""+connect.recievedCount());
        cancelled.setText(""+connect.cancelledCount());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new enhance.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        recieved = new javax.swing.JLabel();
        jPanel8 = new enhance.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        pending = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        expected = new javax.swing.JLabel();
        jPanel10 = new enhance.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        cancelled = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        searchbutton = new enhance.RoundBorder_g();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel22 = new javax.swing.JLabel();
        status_disp = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        barcode_disp = new javax.swing.JLabel();
        name_disp = new javax.swing.JLabel();
        qty_disp = new javax.swing.JLabel();
        price_disp = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        id_disp = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        recieve_disp = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        stat_disp = new javax.swing.JLabel();

        main_panel.setBackground(new java.awt.Color(246, 244, 235));
        main_panel.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        main_panel.add(jSeparator1);
        jSeparator1.setBounds(30, 60, 750, 10);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Orders");
        main_panel.add(jLabel1);
        jLabel1.setBounds(30, 20, 200, 40);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Orders Received:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        recieved.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        recieved.setForeground(new java.awt.Color(255, 255, 255));
        recieved.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        recieved.setText("0");
        jPanel7.add(recieved, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel7);
        jPanel7.setBounds(600, 70, 180, 60);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Current Orders:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        pending.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        pending.setForeground(new java.awt.Color(255, 255, 255));
        pending.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        pending.setText("0");
        jPanel8.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel8);
        jPanel8.setBounds(30, 70, 180, 60);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Today's Expected Arrivals:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        expected.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        expected.setForeground(new java.awt.Color(255, 255, 255));
        expected.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        expected.setText("0");
        jPanel9.add(expected, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel9);
        jPanel9.setBounds(220, 70, 180, 60);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Orders Cancelled:");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        cancelled.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        cancelled.setForeground(new java.awt.Color(255, 255, 255));
        cancelled.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cancelled.setText("0");
        jPanel10.add(cancelled, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel10);
        jPanel10.setBounds(410, 70, 180, 60);

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
        main_panel.add(searchbar);
        searchbar.setBounds(30, 140, 440, 30);

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        main_panel.add(searchbutton);
        searchbutton.setBounds(480, 140, 40, 30);

        products_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        products_table.setForeground(new java.awt.Color(53, 55, 75));
        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "Name", "Quantity", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        products_table.setGridColor(new java.awt.Color(255, 255, 255));
        products_table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        products_table.getTableHeader().setReorderingAllowed(false);
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        products_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                products_tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                products_tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                products_tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(products_table);

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 180, 490, 410);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons-product-100.png"))); // NOI18N
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, -1));

        status_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(status_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 140, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Supplier:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Quantity:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(52, 73, 85));
        jLabel26.setText("Total:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 70, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(52, 73, 85));
        jLabel27.setText("Recieve On:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Product:");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 70, -1));

        barcode_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        barcode_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(barcode_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 140, -1));

        name_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        name_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(name_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 140, -1));

        qty_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        qty_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(qty_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 140, -1));

        price_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        price_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(price_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 140, -1));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Order Information");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 40));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 10));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(52, 73, 85));
        jLabel30.setText("Order ID:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, -1));

        id_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(id_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(80, 114, 123));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 114, 123));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cancel");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 20));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Received");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 20));

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 110, 40));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(52, 73, 85));
        jLabel31.setText("Ordered On:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 70, -1));

        recieve_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        recieve_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(recieve_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 140, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(52, 73, 85));
        jLabel32.setText("Status:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 70, -1));

        stat_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        stat_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(stat_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, -1));

        main_panel.add(jPanel6);
        jPanel6.setBounds(530, 140, 250, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM products WHERE p_id LIKE '%" + query + "%' OR p_barcode LIKE '%" + query + "%' OR p_name LIKE '%" + query + "%' OR p_qty LIKE '%" + query +"%' OR p_price LIKE '%" + query +"%' OR p_status LIKE '%" + query +"%'";

        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            DefaultTableModel tblmod = (DefaultTableModel)products_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("p_id"));
                String dbCode = rs.getString("p_barcode");
                String dbName = rs.getString("p_name");
                String dbQty = String.valueOf(rs.getString("p_qty"));
                String dbPrice = String.valueOf(rs.getDouble("p_price"));
                String dbStatus = rs.getString("p_status");

                String table[] = {dbId, dbCode, dbName, dbQty, dbPrice, dbStatus};

                tblmod.addRow(table);
            }
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        id_disp.setText(model.getValueAt(choose, 0).toString());
        barcode_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString()));
        qty_disp.setText(model.getValueAt(choose, 3).toString());
        price_disp.setText(model.getValueAt(choose, 4).toString());
        status_disp.setText(model.getValueAt(choose, 5).toString());
        recieve_disp.setText(model.getValueAt(choose, 6).toString());
        stat_disp.setText(model.getValueAt(choose, 7).toString());
    }//GEN-LAST:event_products_tableMouseClicked

    private void products_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyPressed

    }//GEN-LAST:event_products_tableKeyPressed

    private void products_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyReleased
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        if(choose!=-1){
            id_disp.setText(model.getValueAt(choose, 0).toString());
            barcode_disp.setText(model.getValueAt(choose, 1).toString());
            name_disp.setText((model.getValueAt(choose, 2).toString()));
            qty_disp.setText(model.getValueAt(choose, 3).toString());
            price_disp.setText(model.getValueAt(choose, 4).toString());
            status_disp.setText(model.getValueAt(choose, 5).toString());
            recieve_disp.setText(model.getValueAt(choose, 6).toString());
            stat_disp.setText(model.getValueAt(choose, 7).toString());
        }
    }//GEN-LAST:event_products_tableKeyReleased

    private void products_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyTyped

    }//GEN-LAST:event_products_tableKeyTyped

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        if(choose!=-1){
            JOptionPane.showMessageDialog(null, "Order "+model.getValueAt(choose, 0).toString()+" Successfully Recieved!");
            dbConnector connect = new dbConnector();
            connect.updateData("UPDATE orders SET o_status = 'Recieved' WHERE o_id = "+model.getValueAt(choose, 0).toString());
            displayTable();
        }else{
            JOptionPane.showMessageDialog(null, "Please select an order!");
        }
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        if(choose!=-1){
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Cancel Order "+model.getValueAt(choose, 0).toString()+"?");
            if(confirm == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Order "+model.getValueAt(choose, 0).toString()+" Successfully Canceled!");
                dbConnector connect = new dbConnector();
                connect.updateData("UPDATE orders SET o_status = 'Cancelled' WHERE o_id = "+model.getValueAt(choose, 0).toString());
                displayTable();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select an order!");
        }
        
        
    }//GEN-LAST:event_jPanel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcode_disp;
    private javax.swing.JLabel cancelled;
    private javax.swing.JLabel expected;
    private javax.swing.JLabel id_disp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel name_disp;
    private javax.swing.JLabel pending;
    private javax.swing.JLabel price_disp;
    private javax.swing.JTable products_table;
    private javax.swing.JLabel qty_disp;
    private javax.swing.JLabel recieve_disp;
    private javax.swing.JLabel recieved;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JLabel stat_disp;
    private javax.swing.JLabel status_disp;
    // End of variables declaration//GEN-END:variables
}
