package admin;

import config.ImportImages;
import config.TableQueries;
import config.dbConnector;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.connectcode.Code128Auto;
import net.proteanit.sql.DbUtils;
import print.TablePrinter;

public class admin_customers extends javax.swing.JInternalFrame {

    public admin_customers() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayTable("Lowest to Highest", "All Status");
    }
    dbConnector connect = new dbConnector();
    ImportImages imp = new ImportImages();
    public void displayTable(String id, String status) {
    try {
        TableModel model = customer_table.getModel();
        dbConnector connector = new dbConnector();
        String query = constructQuery(id, status);
        ResultSet rs = connector.getData(query);
        DefaultTableModel tblmod = (DefaultTableModel)customer_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("c_id"));
                String dbCode = rs.getString("c_code");
                String dbFname = rs.getString("c_fname");
                String dbLname = rs.getString("c_lname");
                String dbAge = String.valueOf(rs.getInt("c_age"));
                String dbDate = rs.getString("c_bdate");
                String dbNum = rs.getString("c_num");
                String dbEmail = rs.getString("c_email");
                String dbPoints = String.valueOf(rs.getDouble("c_points"));
                String dbStatus = rs.getString("c_status");
                
                String table[] = {dbId, dbCode, dbFname, dbLname, dbAge, dbDate, dbNum, dbEmail, dbPoints, dbStatus};
                
                tblmod.addRow(table);
            }
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

private String constructQuery(String id, String status) {
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM customers");

    if (status.equals("All Status")) {
        queryBuilder.append(" WHERE c_status != 'Archived'");
    } else {
        queryBuilder.append(" WHERE c_status = '").append(status).append("' AND c_status != 'Archived'");
    }

    if (id.equals("Lowest to Highest")) {
        queryBuilder.append(" ORDER BY c_id ASC");
    } else if (id.equals("Highest to Lowest")) {
        queryBuilder.append(" ORDER BY c_id DESC");
    }

    return queryBuilder.toString();
}
    
    public void delete(){
        int rowid = customer_table.getSelectedRow();
        TableModel model = customer_table.getModel();
        TableQueries cus = new TableQueries();
        cus.archive(rowid,"customers", model);
        displayTable("Lowest to Highest", "All Status");
    }
    
    public void update(){
        int rowid = customer_table.getSelectedRow();
        TableModel model = customer_table.getModel();
        
        if(rowid != -1){
            admin_customersEdit open = new admin_customersEdit();
            open.setVisible(true);
            open.browse.setEnabled(true);
            open.remove.setEnabled(false);
            open.accessTable(model, rowid);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a customer!");
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
        customer_table = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        id_disp = new javax.swing.JLabel();
        code_disp = new javax.swing.JLabel();
        name_disp = new javax.swing.JLabel();
        age_disp = new javax.swing.JLabel();
        bdate_disp = new javax.swing.JLabel();
        num_disp = new javax.swing.JLabel();
        email_disp = new javax.swing.JLabel();
        points_disp = new javax.swing.JLabel();
        status_disp = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
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
        jLabel1.setText("Customers");
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

        customer_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        customer_table.setForeground(new java.awt.Color(53, 55, 75));
        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "First Name", "Last Name", "Age", "Birthdate", "Contact No.", "Email", "Points", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customer_table.setGridColor(new java.awt.Color(255, 255, 255));
        customer_table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        customer_table.getTableHeader().setReorderingAllowed(false);
        customer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tableMouseClicked(evt);
            }
        });
        customer_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customer_tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customer_tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customer_tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(customer_table);
        if (customer_table.getColumnModel().getColumnCount() > 0) {
            customer_table.getColumnModel().getColumn(0).setResizable(false);
            customer_table.getColumnModel().getColumn(1).setResizable(false);
            customer_table.getColumnModel().getColumn(2).setResizable(false);
            customer_table.getColumnModel().getColumn(3).setResizable(false);
            customer_table.getColumnModel().getColumn(4).setResizable(false);
            customer_table.getColumnModel().getColumn(5).setResizable(false);
            customer_table.getColumnModel().getColumn(6).setResizable(false);
            customer_table.getColumnModel().getColumn(7).setResizable(false);
            customer_table.getColumnModel().getColumn(8).setResizable(false);
            customer_table.getColumnModel().getColumn(9).setResizable(false);
        }

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 490, 470);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Customer Information");
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

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_edit.png"))); // NOI18N
        jLabel45.setToolTipText("Edit");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
        });
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jButton1.setText("Print Identification Card");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 210, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(id_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 10));

        code_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        code_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(code_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 70, 10));

        name_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        name_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(name_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 70, 10));

        age_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(age_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 70, 10));

        bdate_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bdate_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(bdate_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 10));

        num_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        num_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(num_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, 10));

        email_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        email_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(email_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 70, 10));

        points_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        points_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(points_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 70, 10));

        status_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status_disp.setForeground(new java.awt.Color(52, 73, 85));
        jPanel1.add(status_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 70, 10));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(52, 73, 85));
        jLabel34.setText("Points:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 70, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(52, 73, 85));
        jLabel27.setText("Status:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 70, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(52, 73, 85));
        jLabel33.setText("Email:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 70, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(52, 73, 85));
        jLabel32.setText("Contact #:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(52, 73, 85));
        jLabel26.setText("Birthdate:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Age:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 70, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Name:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Code:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(52, 73, 85));
        jLabel30.setText("Customer ID:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, 180));

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-user-100.png"))); // NOI18N
        jPanel6.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        main_panel.add(jPanel6);
        jPanel6.setBounds(530, 80, 250, 370);

        jPanel7.setBackground(new java.awt.Color(246, 244, 235));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Sort by ID:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        sortID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lowest to Highest", "Highest to Lowest" }));
        jPanel7.add(sortID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 32));

        sortStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "Pending", "Active", "Inactive" }));
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

    private void customer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tableMouseClicked
        int choose = customer_table.getSelectedRow();
        TableModel model = customer_table.getModel();

        id_disp.setText(model.getValueAt(choose, 0).toString());
        code_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString())+ " "+ (model.getValueAt(choose, 3).toString()));
        age_disp.setText(model.getValueAt(choose, 4).toString());
        bdate_disp.setText(model.getValueAt(choose, 5).toString());
        num_disp.setText(model.getValueAt(choose, 6).toString());
        email_disp.setText((model.getValueAt(choose, 7).toString()));
        points_disp.setText(model.getValueAt(choose, 8).toString());
        status_disp.setText(model.getValueAt(choose, 9).toString());
        try {
            ResultSet rs = connect.getData("SELECT * FROM customers WHERE c_id = "+ model.getValueAt(choose, 0).toString());
            if(rs.next()){
                img.setIcon(imp.ResizeImage(rs.getString("c_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_customer_tableMouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        delete();
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        update();
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseEntered

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
        String searchQuery = "SELECT * FROM customers WHERE c_id LIKE '%" + query + "%' OR c_code LIKE '%" + query + "%' OR c_fname LIKE '%" + query + "%' OR c_lname LIKE '%" + query + "%' OR c_age LIKE '%" + query +"%' OR c_bdate LIKE '%" + query +"%' OR c_num LIKE '%" + query + "%' OR c_email LIKE '%" + query + "%' OR c_points LIKE '%" + query + "%' OR c_status LIKE '%" + query +"%'";
    
        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            DefaultTableModel tblmod = (DefaultTableModel)customer_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("c_id"));
                String dbCode = rs.getString("c_code");
                String dbFname = rs.getString("c_fname");
                String dbLname = rs.getString("c_lname");
                String dbAge = String.valueOf(rs.getInt("c_age"));
                String dbDate = rs.getString("c_bdate");
                String dbNum = rs.getString("c_num");
                String dbEmail = rs.getString("c_email");
                String dbPoints = String.valueOf(rs.getDouble("c_points"));
                String dbStatus = rs.getString("c_status");
                
                String table[] = {dbId, dbCode, dbFname, dbLname, dbAge, dbDate, dbNum, dbEmail, dbPoints, dbStatus};
                
                tblmod.addRow(table);
            }
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        admin_customersAdd open = new admin_customersAdd();
        open.browse.setEnabled(true);
        open.remove.setEnabled(false);
        open.setVisible(true);
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void customer_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_tableKeyPressed

    }//GEN-LAST:event_customer_tableKeyPressed

    private void customer_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_tableKeyTyped

    }//GEN-LAST:event_customer_tableKeyTyped

    private void customer_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_tableKeyReleased
        int choose = customer_table.getSelectedRow();
        TableModel model = customer_table.getModel();
        
        if(choose!=-1){
            id_disp.setText(model.getValueAt(choose, 0).toString());
            code_disp.setText(model.getValueAt(choose, 1).toString());
            name_disp.setText((model.getValueAt(choose, 2).toString())+ " "+ (model.getValueAt(choose, 3).toString()));
            age_disp.setText(model.getValueAt(choose, 4).toString());
            bdate_disp.setText(model.getValueAt(choose, 5).toString());
            num_disp.setText(model.getValueAt(choose, 6).toString());
            email_disp.setText((model.getValueAt(choose, 7).toString()));
            points_disp.setText(model.getValueAt(choose, 8).toString());
            status_disp.setText(model.getValueAt(choose, 9).toString());
            try {
            ResultSet rs = connect.getData("SELECT * FROM customers WHERE c_id = "+ model.getValueAt(choose, 0).toString());
            if(rs.next()){
                img.setIcon(imp.ResizeImage(rs.getString("c_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
    }//GEN-LAST:event_customer_tableKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowid = customer_table.getSelectedRow();
        TableModel model = customer_table.getModel();

        if(rowid != -1){
            admin_IDPrinting open = new admin_IDPrinting();
            try {
            ResultSet rs = connect.getData("SELECT * FROM customers WHERE c_id = "+ model.getValueAt(rowid, 0).toString());
            if(rs.next()){
                open.img.setIcon(imp.ResizeImage(rs.getString("c_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            open.lname.setText("<html><body>"+model.getValueAt(rowid, 3).toString()+ ", "+ model.getValueAt(rowid, 2).toString()+"</body></html>");
            open.type.setText("Customer");
            Code128Auto code128 = new Code128Auto();
            String barcode=code128.encode(model.getValueAt(rowid, 1).toString());
            open.barcode.setText(barcode);
            open.barcode.setFont(new Font("CCode128_S3_Trial", Font.PLAIN, 16));
            open.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a customer!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TablePrinter print = new TablePrinter(customer_table, "Customer Loyalty Program");
        print.print();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age_disp;
    private javax.swing.JLabel bdate_disp;
    private javax.swing.JLabel code_disp;
    private javax.swing.JTable customer_table;
    private javax.swing.JLabel email_disp;
    private javax.swing.JLabel id_disp;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel name_disp;
    private javax.swing.JLabel num_disp;
    private javax.swing.JLabel points_disp;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JComboBox<String> sortID;
    private javax.swing.JComboBox<String> sortStatus;
    private javax.swing.JLabel status_disp;
    // End of variables declaration//GEN-END:variables
}
