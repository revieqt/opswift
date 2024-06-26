package admin;

import config.dbConnector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import config.TableQueries;

public class admin_archive extends javax.swing.JInternalFrame {

    public admin_archive() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        
        Action insertAction = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                admin_staffAdd open = new admin_staffAdd();
                open.setVisible(true);
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "INSERT_pressed");
        this.getRootPane().getActionMap().put("INSERT_pressed", insertAction);
        
    }
    
    
    
    
    public void displayTable(String query, String selectedType){
        String searchQuery = "";

        switch (selectedType) {
            case "Staff":
                searchQuery = "SELECT * FROM users WHERE (u_code LIKE '%" + query + "%' OR u_fname LIKE '%" + query + "%' OR u_lname LIKE '%" + query + "%' OR u_username LIKE '%" + query + "%' OR u_type LIKE '%" + query + "%') AND u_status = 'Archived'";
                break;
            case "Products":
                searchQuery = "SELECT * FROM products WHERE (p_id LIKE '%" + query + "%' OR p_barcode LIKE '%" + query + "%' OR p_name LIKE '%" + query + "%' OR p_qty LIKE '%" + query + "%' OR p_price LIKE '%" + query + "%') AND p_status = 'Archived'";
                break;
            case "Customers":
                searchQuery = "SELECT * FROM customers WHERE (c_id LIKE '%" + query + "%' OR c_code LIKE '%" + query + "%' OR c_fname LIKE '%" + query + "%' OR c_lname LIKE '%" + query + "%' OR c_age LIKE '%" + query + "%' OR c_bdate LIKE '%" + query + "%' OR c_num LIKE '%" + query + "%' OR c_email LIKE '%" + query + "%' OR c_points LIKE '%" + query + "%') AND c_status = 'Archived'";
                break;
            case "Discounts":
                searchQuery = "SELECT * FROM discounts WHERE (d_id LIKE '%" + query + "%' OR d_code LIKE '%" + query + "%' OR d_name LIKE '%" + query + "%' OR d_amount LIKE '%" + query + "%' OR d_type LIKE '%" + query + "%' OR d_redeemable LIKE '%" + query + "%') AND d_status = 'Archived'";
                break;
            case "Suppliers":
                searchQuery = "SELECT * FROM suppliers WHERE (s_id LIKE '%" + query + "%' OR s_name LIKE '%" + query + "%' OR s_address LIKE '%" + query + "%' OR s_contact LIKE '%" + query + "%') AND s_status = 'Archived'";
        }

        try {
            if (!searchQuery.isEmpty()) {
                dbConnector connect = new dbConnector();
                ResultSet rs = connect.getData(searchQuery);
                archive_table.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                System.out.println("No valid search query was constructed.");
            }
        } catch (SQLException ex) {
            System.out.println("Error searching " + selectedType.toLowerCase() + ": " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        archive_table = new javax.swing.JTable();
        searchbar = new javax.swing.JTextField();
        searchbutton = new enhance.RoundBorder_g();
        jLabel9 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel5 = new javax.swing.JLabel();

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

        main_panel.setBackground(new java.awt.Color(246, 244, 235));
        main_panel.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        main_panel.add(jSeparator1);
        jSeparator1.setBounds(30, 60, 750, 10);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Archives");
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
        jLabel3.setBounds(740, 10, 40, 50);

        archive_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        archive_table.setForeground(new java.awt.Color(53, 55, 75));
        archive_table.setGridColor(new java.awt.Color(255, 255, 255));
        archive_table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        archive_table.getTableHeader().setReorderingAllowed(false);
        archive_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archive_tableMouseClicked(evt);
            }
        });
        archive_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                archive_tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                archive_tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                archive_tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(archive_table);

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 750, 420);

        searchbar.setForeground(new java.awt.Color(53, 55, 75));
        searchbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 160, 131), 1, true));
        searchbar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbarMouseClicked(evt);
            }
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchbarKeyTyped(evt);
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
        searchbutton.setBounds(740, 80, 40, 30);

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(52, 73, 85));
        jLabel31.setText("*press ↑ and ↓ to navigate table");
        main_panel.add(jLabel31);
        jLabel31.setBounds(30, 580, 220, 14);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Products", "Customers", "Discounts", "Suppliers" }));
        main_panel.add(type);
        type.setBounds(480, 80, 250, 30);

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
        jLabel7.setText("Permanently Delete");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        main_panel.add(jPanel4);
        jPanel4.setBounds(410, 550, 180, 40);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Restore Data");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        main_panel.add(jPanel3);
        jPanel3.setBounds(600, 550, 180, 40);

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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        displayTable("","Staff");
        type.setSelectedItem("Staff");
        searchbar.setText("");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void archive_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archive_tableMouseClicked
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
    }//GEN-LAST:event_archive_tableMouseClicked

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange
        
    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        displayTable(searchbar.getText(),type.getSelectedItem().toString());
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void archive_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyPressed

    }//GEN-LAST:event_archive_tableKeyPressed

    private void archive_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyTyped

    }//GEN-LAST:event_archive_tableKeyTyped

    private void archive_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyReleased
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
    }//GEN-LAST:event_archive_tableKeyReleased

    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped
//        String query = searchbar.getText();
//        String searchQuery = "SELECT * FROM users WHERE u_code LIKE '%" + query + "%' OR u_fname LIKE '%" + query + "%' OR u_lname LIKE '%" + query + "%' OR u_username LIKE '%" + query +"%' OR u_type LIKE '%" + query +"%' OR u_status LIKE '%" + query +"%'";
//    
//    
//        if (query.matches("\\d+")) {
//            searchQuery = "SELECT * FROM users WHERE u_id = " + query;
//        }
//    
//        try {
//            dbConnector connect = new dbConnector();
//            ResultSet rs = connect.getData(searchQuery);
//            staff_table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch(SQLException ex) {
//            System.out.println("Error searching users: " + ex.getMessage());
//        }
    }//GEN-LAST:event_searchbarKeyTyped

    private void searchbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
        
        
        if(choose != -1){
            Object value = model.getValueAt(choose, 0);
            String id = value.toString();
            String table;
            String var;
            if(type.getSelectedItem().equals("Staff")){
                table = "users";
                var = "u_id";
            }else if(type.getSelectedItem().equals("Products")){
                table = "products";
                var = "p_id";
            }else if(type.getSelectedItem().equals("Customers")){
                table = "customers";
                var = "c_id";
            }else if(type.getSelectedItem().equals("Suppliers")){
                table = "suppliers";
                var = "s_id";
            }else{
                table = "discounts";
                var = "d_id";
            }
            
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to delete ID "+id +"?");
            if(confirm == JOptionPane.YES_OPTION){
                dbConnector connect = new dbConnector();
                connect.deleteData(Integer.parseInt(id), table, var);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select an ID to Delete!");
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
        TableQueries res = new TableQueries();
        res.restore(choose, (String)type.getSelectedItem(),model);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        displayTable("","Staff");
        type.setSelectedItem("Staff");
        searchbar.setText("");
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable archive_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
