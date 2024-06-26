package admin;

import config.TableQueries;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import print.TablePrinter;

public class admin_suppliers extends javax.swing.JInternalFrame {

    public admin_suppliers() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);  
        
        displayTable("Lowest to Highest", "All Status");
        
    }
    
    
    
    
    public void displayTable(String id, String status) {
    try {
        TableModel model = products_table.getModel();
        dbConnector connector = new dbConnector();
        String query = constructQuery(id, status);
        ResultSet rs = connector.getData(query);
        DefaultTableModel tblmod = (DefaultTableModel)products_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("s_id"));
                String dbName = rs.getString("s_name");
                String dbAddress = rs.getString("s_address");
                String dbContact = rs.getString("s_contact");
                String dbStatus = rs.getString("s_status");
                
                String table[] = {dbId, dbName, dbAddress, dbContact, dbStatus};
                
                tblmod.addRow(table);
                }

    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

private String constructQuery(String id, String status) {
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM suppliers");

    if (status.equals("All Status")) {
        queryBuilder.append(" WHERE s_status != 'Archived'");
    } else {
        queryBuilder.append(" WHERE s_status = '").append(status).append("'");
    }

    if (id.equals("Lowest to Highest")) {
        queryBuilder.append(" ORDER BY s_id ASC");
    } else if (id.equals("Highest to Lowest")) {
        queryBuilder.append(" ORDER BY s_id DESC");
    }

    return queryBuilder.toString();
}
    
    public void delete(){
        int rowid = products_table.getSelectedRow();
        TableModel model = products_table.getModel();
        TableQueries prod = new TableQueries();
        prod.archive(rowid,"suppliers", model);
        displayTable("Lowest to Highest", "All Status");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        barcode_disp = new javax.swing.JLabel();
        name_disp = new javax.swing.JLabel();
        qty_disp = new javax.swing.JLabel();
        price_disp = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        id_disp = new javax.swing.JLabel();
        jPanel7 = new enhance.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        sortID = new javax.swing.JComboBox<>();
        sortStatus = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        searchbar = new javax.swing.JTextField();
        searchbutton = new enhance.RoundBorder_g();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        main_panel.setBackground(new java.awt.Color(246, 244, 235));
        main_panel.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        main_panel.add(jSeparator1);
        jSeparator1.setBounds(30, 60, 750, 10);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Suppliers");
        main_panel.add(jLabel1);
        jLabel1.setBounds(30, 20, 200, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_refresh.png"))); // NOI18N
        jLabel3.setToolTipText("Refresh");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        main_panel.add(jLabel3);
        jLabel3.setBounds(700, 10, 40, 50);

        products_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        products_table.setForeground(new java.awt.Color(53, 55, 75));
        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Contact", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        if (products_table.getColumnModel().getColumnCount() > 0) {
            products_table.getColumnModel().getColumn(0).setResizable(false);
            products_table.getColumnModel().getColumn(1).setResizable(false);
            products_table.getColumnModel().getColumn(2).setResizable(false);
            products_table.getColumnModel().getColumn(3).setResizable(false);
            products_table.getColumnModel().getColumn(4).setResizable(false);
        }

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 490, 470);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons-product-100.png"))); // NOI18N
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Address:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Contact:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(52, 73, 85));
        jLabel26.setText("Status:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Name:");
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
        jLabel21.setText("Supplier Information");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 40));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 10));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_delete.png"))); // NOI18N
        jLabel44.setToolTipText("Delete");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(52, 73, 85));
        jLabel30.setText("Supplier ID:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, -1));

        id_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel6.add(id_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, -1));

        main_panel.add(jPanel6);
        jPanel6.setBounds(530, 80, 250, 320);

        jPanel7.setBackground(new java.awt.Color(246, 244, 235));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Sort by ID:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        sortID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lowest to Highest", "Highest to Lowest" }));
        jPanel7.add(sortID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 32));

        sortStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "Available", "Unavailable" }));
        jPanel7.add(sortStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, 32));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel20.setText("Status:");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jButton5.setText("FILTER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 100, 30));

        main_panel.add(jPanel7);
        jPanel7.setBounds(530, 460, 250, 130);

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
        searchbar.setBounds(30, 80, 440, 30);

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        main_panel.add(searchbutton);
        searchbutton.setBounds(480, 80, 40, 30);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_add.png"))); // NOI18N
        jLabel28.setToolTipText("[INSERT] Add Staff");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        main_panel.add(jLabel28);
        jLabel28.setBounds(740, 10, 40, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-print-35.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        main_panel.add(jLabel2);
        jLabel2.setBounds(650, 10, 40, 50);

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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        displayTable("Lowest to Highest", "All Status");
        sortID.setSelectedIndex(0);
        sortStatus.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        id_disp.setText(model.getValueAt(choose, 0).toString());
        barcode_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString()));
        qty_disp.setText(model.getValueAt(choose, 3).toString());
        price_disp.setText(model.getValueAt(choose, 4).toString());
    }//GEN-LAST:event_products_tableMouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        delete();
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        displayTable((String)sortID.getSelectedItem(), (String)sortStatus.getSelectedItem());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange
        
    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM suppliers WHERE s_id LIKE '%" + query + "%' OR  s_name LIKE '%" + query + "%' OR s_address LIKE '%" + query +"%' OR s_contact LIKE '%" + query +"%' OR s_status LIKE '%" + query +"%'";
    
        try {
            TableModel model = products_table.getModel();
            dbConnector connector = new dbConnector();
            ResultSet rs = connector.getData(searchQuery);
            DefaultTableModel tblmod = (DefaultTableModel)products_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("s_id"));
                String dbName = rs.getString("s_name");
                String dbAddress = rs.getString("s_address");
                String dbContact = rs.getString("s_contact");
                String dbStatus = rs.getString("s_status");

                String table[] = {dbId, dbName, dbAddress, dbContact, dbStatus};

                tblmod.addRow(table);
                }
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        admin_supplierAdd add = new admin_supplierAdd();
        add.setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void products_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyPressed

    }//GEN-LAST:event_products_tableKeyPressed

    private void products_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyTyped

    }//GEN-LAST:event_products_tableKeyTyped

    private void products_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_products_tableKeyReleased
        int choose = products_table.getSelectedRow();
        TableModel model = products_table.getModel();

        id_disp.setText(model.getValueAt(choose, 0).toString());
        barcode_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString()));
        qty_disp.setText(model.getValueAt(choose, 3).toString());
        price_disp.setText(model.getValueAt(choose, 4).toString());
    }//GEN-LAST:event_products_tableKeyReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TablePrinter print = new TablePrinter(products_table, "Suppliers");
        print.print();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcode_disp;
    private javax.swing.JLabel id_disp;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel name_disp;
    private javax.swing.JLabel price_disp;
    private javax.swing.JTable products_table;
    private javax.swing.JLabel qty_disp;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JComboBox<String> sortID;
    private javax.swing.JComboBox<String> sortStatus;
    // End of variables declaration//GEN-END:variables
}
