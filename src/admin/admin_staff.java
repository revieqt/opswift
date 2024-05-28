package admin;

import config.ImportImages;
import config.TableQueries;
import config.dbConnector;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.connectcode.Code128Auto;
import net.proteanit.sql.DbUtils;
import print.TablePrinter;

public class admin_staff extends javax.swing.JInternalFrame {

    public admin_staff() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayTable("Lowest to Highest", "All Types", "All Status");
        
        Action insertAction = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                admin_staffAdd open = new admin_staffAdd();
                open.setVisible(true);
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "INSERT_pressed");
        this.getRootPane().getActionMap().put("INSERT_pressed", insertAction);
        
        Action updateAction = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0), "HOME_pressed");
        this.getRootPane().getActionMap().put("HOME_pressed", updateAction);
    }
    
    ImportImages imp = new ImportImages();
    
    dbConnector connect = new dbConnector();
    public void displayTable(String id, String type, String status) {
        try {
            String query = constructQuery(id, type, status);
            ResultSet rs = connect.getData(query);
            DefaultTableModel tblmod = (DefaultTableModel)staff_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("u_id"));
                String dbCode = rs.getString("u_code");
                String dbFname = rs.getString("u_fname");
                String dbLname = rs.getString("u_lname");
                String dbUsername = rs.getString("u_username");
                String dbType = rs.getString("u_type");
                String dbStatus = rs.getString("u_status");
                
                String table[] = {dbId, dbCode, dbFname, dbLname, dbUsername, dbType, dbStatus};
                
                tblmod.addRow(table);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private String constructQuery(String id, String type, String status) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM users");

        boolean hasCondition = false;

        if (!type.equals("All Types")) {
            queryBuilder.append(" WHERE u_type = '").append(type).append("'");
            hasCondition = true;
        }

        if (status.equals("All Status")) {
            if (hasCondition) {
                queryBuilder.append(" AND u_status != 'Archived'");
            } else {
                queryBuilder.append(" WHERE u_status != 'Archived'");
                hasCondition = true;
            }
        } else {
            if (hasCondition) {
                queryBuilder.append(" AND u_status = '").append(status).append("'");
            } else {
                queryBuilder.append(" WHERE u_status = '").append(status).append("'");
                hasCondition = true;
            }
        }

        if (id.equals("Lowest to Highest")) {
            queryBuilder.append(" ORDER BY u_id ASC");
        } else if (id.equals("Highest to Lowest")) {
            queryBuilder.append(" ORDER BY u_id DESC");
        }

        return queryBuilder.toString();
    }
    
    public void update(){
        int rowid = staff_table.getSelectedRow();
        TableModel model = staff_table.getModel();
        
        if(rowid != -1){
            admin_staffEdit open = new admin_staffEdit();
            open.setVisible(true);
            open.accessTable(model, rowid);
            open.browse.setEnabled(false);
            open.remove.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a staff!");
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staff_table = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        id_disp = new javax.swing.JLabel();
        status_disp = new javax.swing.JLabel();
        username_disp = new javax.swing.JLabel();
        name_disp = new javax.swing.JLabel();
        code_disp = new javax.swing.JLabel();
        type_disp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        jPanel7 = new enhance.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        sortID = new javax.swing.JComboBox<>();
        sortType = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        sortStatus = new javax.swing.JComboBox<>();
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
        jLabel1.setText("Staff");
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

        staff_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        staff_table.setForeground(new java.awt.Color(53, 55, 75));
        staff_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "First Name", "Last Name", "Username", "Type", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        staff_table.setGridColor(new java.awt.Color(255, 255, 255));
        staff_table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        staff_table.getTableHeader().setReorderingAllowed(false);
        staff_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staff_tableMouseClicked(evt);
            }
        });
        staff_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                staff_tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staff_tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                staff_tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(staff_table);
        if (staff_table.getColumnModel().getColumnCount() > 0) {
            staff_table.getColumnModel().getColumn(0).setResizable(false);
            staff_table.getColumnModel().getColumn(1).setResizable(false);
            staff_table.getColumnModel().getColumn(2).setResizable(false);
            staff_table.getColumnModel().getColumn(3).setResizable(false);
            staff_table.getColumnModel().getColumn(4).setResizable(false);
            staff_table.getColumnModel().getColumn(5).setResizable(false);
            staff_table.getColumnModel().getColumn(6).setResizable(false);
        }

        main_panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 490, 470);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Staff Information");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(52, 73, 85));
        jLabel30.setText("Staff ID:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Staff Code:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Staff Name:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Username:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 70, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(52, 73, 85));
        jLabel27.setText("Type:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 70, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(52, 73, 85));
        jLabel46.setText("Status:");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 70, -1));

        id_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(id_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 140, -1));

        status_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(status_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 140, -1));

        username_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        username_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(username_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, -1));

        name_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        name_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(name_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, -1));

        code_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        code_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(code_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, -1));

        type_disp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type_disp.setForeground(new java.awt.Color(80, 114, 123));
        jPanel1.add(type_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 140, -1));

        jButton1.setText("Print Identification Card");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, -1));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 150));

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_userbig.png"))); // NOI18N
        jPanel6.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, -1));

        main_panel.add(jPanel6);
        jPanel6.setBounds(530, 80, 250, 330);

        jPanel7.setBackground(new java.awt.Color(246, 244, 235));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Sort by ID:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        sortID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lowest to Highest", "Highest to Lowest" }));
        jPanel7.add(sortID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 32));

        sortType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Types", "Administrator", "Cashier", "Accountant" }));
        jPanel7.add(sortType, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, 32));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel20.setText("Type:");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jButton5.setText("FILTER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, 30));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel23.setText("Status:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        sortStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "Active", "Inactive", "Pending" }));
        jPanel7.add(sortStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, 32));

        main_panel.add(jPanel7);
        jPanel7.setBounds(530, 420, 250, 170);

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
        displayTable("Lowest to Highest", "All Types", "All Status");
        sortID.setSelectedIndex(0);
        sortType.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void staff_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staff_tableMouseClicked
        int choose = staff_table.getSelectedRow();
        TableModel model = staff_table.getModel();
        
        try {
            ResultSet rs = connect.getData("SELECT * FROM users WHERE u_id = "+ model.getValueAt(choose, 0).toString());
            if(rs.next()){
                img.setIcon(imp.ResizeImage(rs.getString("u_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        id_disp.setText(model.getValueAt(choose, 0).toString());
        code_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString())+" "+(model.getValueAt(choose, 3).toString()));
        username_disp.setText(model.getValueAt(choose, 4).toString());
        type_disp.setText(model.getValueAt(choose, 5).toString());
        status_disp.setText(model.getValueAt(choose, 6).toString());
    }//GEN-LAST:event_staff_tableMouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        int rowid = staff_table.getSelectedRow();
        TableModel model = staff_table.getModel();
        TableQueries user = new TableQueries();
        user.archive(rowid,"users", model);
        displayTable("Lowest to Highest", "All Types", "All Status");
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        update();
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        displayTable((String)sortID.getSelectedItem(), (String)sortType.getSelectedItem(), (String)sortStatus.getSelectedItem());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange
        
    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM users WHERE (u_code LIKE '%" + query + "%' OR u_fname LIKE '%" + query + "%' OR u_lname LIKE '%" + query + "%' OR u_username LIKE '%" + query + "%' OR u_type LIKE '%" + query + "%' OR u_status LIKE '%" + query + "%') AND u_status <> 'Archived'";

        if (query.matches("\\d+")) {
            searchQuery = "SELECT * FROM users WHERE u_id = " + query + " AND u_status <> 'Archived'";
        }

        try {
            ResultSet rs = connect.getData(searchQuery);
            DefaultTableModel tblmod = (DefaultTableModel)staff_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("u_id"));
                String dbCode = rs.getString("u_code");
                String dbFname = rs.getString("u_fname");
                String dbLname = rs.getString("u_lname");
                String dbUsername = rs.getString("u_username");
                String dbType = rs.getString("u_type");
                String dbStatus = rs.getString("u_status");
                
                String table[] = {dbId, dbCode, dbFname, dbLname, dbUsername, dbType, dbStatus};
                tblmod.addRow(table);
            }
        } catch (SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        admin_staffAdd open = new admin_staffAdd();
        open.browse.setEnabled(true);
        open.remove.setEnabled(false);
        open.setVisible(true);
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void staff_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_staff_tableKeyPressed

    }//GEN-LAST:event_staff_tableKeyPressed

    private void staff_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_staff_tableKeyTyped

    }//GEN-LAST:event_staff_tableKeyTyped

    private void staff_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_staff_tableKeyReleased
        int choose = staff_table.getSelectedRow();
        TableModel model = staff_table.getModel();
        
        if(choose!=-1){
        try {
            ResultSet rs = connect.getData("SELECT * FROM users WHERE u_id = "+ model.getValueAt(choose, 0).toString());
            if(rs.next()){
                img.setIcon(imp.ResizeImage(rs.getString("u_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        id_disp.setText(model.getValueAt(choose, 0).toString());
        code_disp.setText(model.getValueAt(choose, 1).toString());
        name_disp.setText((model.getValueAt(choose, 2).toString())+" "+(model.getValueAt(choose, 3).toString()));
        username_disp.setText(model.getValueAt(choose, 4).toString());
        type_disp.setText(model.getValueAt(choose, 5).toString());
        status_disp.setText(model.getValueAt(choose, 6).toString());
        }
    }//GEN-LAST:event_staff_tableKeyReleased

    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped

    }//GEN-LAST:event_searchbarKeyTyped

    private void searchbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseClicked

    }//GEN-LAST:event_searchbarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowid = staff_table.getSelectedRow();
        TableModel model = staff_table.getModel();
        
        if(rowid != -1){
            admin_IDPrinting open = new admin_IDPrinting();
            
            try {
            ResultSet rs = connect.getData("SELECT * FROM users WHERE u_id = "+ model.getValueAt(rowid, 0).toString());
            if(rs.next()){
                open.img.setIcon(imp.ResizeImage(rs.getString("u_img"), null, img));
            }else{
                System.out.println("No image found!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            open.lname.setText("<html><body>"+model.getValueAt(rowid, 3).toString()+ ", "+ model.getValueAt(rowid, 2).toString()+"</body></html>");
            open.type.setText(model.getValueAt(rowid, 5).toString());
            Code128Auto code128 = new Code128Auto();
            String barcode=code128.encode(model.getValueAt(rowid, 1).toString());
            open.barcode.setText(barcode);
            open.barcode.setFont(new Font("CCode128_S3_Trial", Font.PLAIN, 16));
            open.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a staff!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TablePrinter print = new TablePrinter(staff_table, "Staff");
        print.print();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code_disp;
    private javax.swing.JLabel id_disp;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
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
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JComboBox<String> sortID;
    private javax.swing.JComboBox<String> sortStatus;
    private javax.swing.JComboBox<String> sortType;
    private javax.swing.JTable staff_table;
    private javax.swing.JLabel status_disp;
    private javax.swing.JLabel type_disp;
    private javax.swing.JLabel username_disp;
    // End of variables declaration//GEN-END:variables
}
