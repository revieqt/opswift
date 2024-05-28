package admin;

import config.SalesGraph;
import print.TablePrinter;
import config.TransactionGraph;
import config.dbConnector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class admin_sales extends javax.swing.JInternalFrame {

    public admin_sales() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayTable();
        
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
    
    
    public void displayTable() {
        try {
            dbConnector connector = new dbConnector();
            transactiongraph.setLayout(new java.awt.BorderLayout());
            transactiongraph.add(TransactionGraph.createGraph());
            salesgraph.setLayout(new java.awt.BorderLayout());
            salesgraph.add(SalesGraph.createGraph());
            totaltrans.setText(""+ connector.transactionCount(false));
            dailytrans.setText(""+ connector.transactionCount(true));  
            totalsales.setText(""+ connector.salesCount(false));
            dailysales.setText(""+ connector.salesCount(true));
            String query = constructQuery();
            ResultSet rs = connector.getData(query);
            DefaultTableModel tblmod = (DefaultTableModel)transtable.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbId = String.valueOf(rs.getInt("t_id"));
                String dbStaff = String.valueOf(rs.getInt("t_staff"));
                String dbCustomer = String.valueOf(rs.getInt("t_customer"));
                String dbTotal = String.valueOf(rs.getInt("t_total"));
                String dbDateTime = rs.getString("t_datetime");
                
                String table[] = {dbId, dbStaff, dbCustomer, dbTotal, dbDateTime};
                
                tblmod.addRow(table);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private String constructQuery() {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM transactions");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        boolean hasDate = datechoosen.getDate() != null;
        boolean hasSearchTerm = searchbar.getText() != null && !searchbar.getText().trim().isEmpty();

        if (hasDate || hasSearchTerm) {
            queryBuilder.append(" WHERE ");
        }

        if (hasDate) {
            String selectedDate = sdf.format(datechoosen.getDate());
            queryBuilder.append("DATE(t_datetime) = '").append(selectedDate).append("'");
        }

        if (hasDate && hasSearchTerm) {
            queryBuilder.append(" AND ");
        }

        if (hasSearchTerm) {
            String searchTerm = searchbar.getText().trim();
            queryBuilder.append("(t_id LIKE '%").append(searchTerm).append("%' ")
                        .append("OR transaction_description LIKE '%").append(searchTerm).append("%')");
        }

        return queryBuilder.toString();
    }
    

    public void update(){
        int rowid = transtable.getSelectedRow();
        TableModel model = transtable.getModel();
        
        if(rowid != -1){
            admin_staffEdit open = new admin_staffEdit();
            open.setVisible(true);
            open.accessTable(model, rowid);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a staff!");
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new enhance.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        dailysales = new javax.swing.JLabel();
        transactiongraph = new enhance.RoundBorder_g();
        salesgraph = new enhance.RoundBorder_g();
        jPanel4 = new enhance.RoundBorder_g();
        jScrollPane1 = new javax.swing.JScrollPane();
        transtable = new javax.swing.JTable();
        jPanel1 = new enhance.RoundBorder_g();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        datechoosen = new com.toedter.calendar.JDateChooser();
        searchbutton = new enhance.RoundBorder_g();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new enhance.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        totaltrans = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        dailytrans = new javax.swing.JLabel();
        jPanel10 = new enhance.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        totalsales = new javax.swing.JLabel();

        main_panel.setBackground(new java.awt.Color(246, 244, 235));
        main_panel.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(80, 114, 123));
        main_panel.add(jSeparator1);
        jSeparator1.setBounds(30, 60, 750, 10);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Sales");
        main_panel.add(jLabel1);
        jLabel1.setBounds(30, 20, 200, 40);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Today's Sales");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        dailysales.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        dailysales.setForeground(new java.awt.Color(255, 255, 255));
        dailysales.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dailysales.setText("0");
        jPanel7.add(dailysales, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel7);
        jPanel7.setBounds(600, 70, 180, 60);

        transactiongraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout transactiongraphLayout = new javax.swing.GroupLayout(transactiongraph);
        transactiongraph.setLayout(transactiongraphLayout);
        transactiongraphLayout.setHorizontalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        transactiongraphLayout.setVerticalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        main_panel.add(transactiongraph);
        transactiongraph.setBounds(30, 140, 370, 190);

        salesgraph.setBackground(new java.awt.Color(255, 255, 255));
        salesgraph.setToolTipText("Search");
        salesgraph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesgraphMouseClicked(evt);
            }
        });
        salesgraph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        main_panel.add(salesgraph);
        salesgraph.setBounds(410, 140, 370, 190);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transtable.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        transtable.setForeground(new java.awt.Color(53, 55, 75));
        transtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction #", "Staff", "Customer", "Total", "Date and Time"
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
        transtable.setGridColor(new java.awt.Color(255, 255, 255));
        transtable.setSelectionBackground(new java.awt.Color(120, 160, 131));
        transtable.getTableHeader().setReorderingAllowed(false);
        transtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transtableMouseClicked(evt);
            }
        });
        transtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transtableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                transtableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                transtableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(transtable);
        if (transtable.getColumnModel().getColumnCount() > 0) {
            transtable.getColumnModel().getColumn(0).setResizable(false);
            transtable.getColumnModel().getColumn(1).setResizable(false);
            transtable.getColumnModel().getColumn(2).setResizable(false);
            transtable.getColumnModel().getColumn(3).setResizable(false);
            transtable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 140));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Print Table");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 150, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Transaction");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 150, 40));

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
        jPanel4.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        datechoosen.setBackground(new java.awt.Color(255, 255, 255));
        datechoosen.setForeground(new java.awt.Color(0, 51, 51));
        datechoosen.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(datechoosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 290, 30));

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel4.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 40, -1));

        main_panel.add(jPanel4);
        jPanel4.setBounds(30, 340, 750, 250);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Number of Transactions:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        totaltrans.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        totaltrans.setForeground(new java.awt.Color(255, 255, 255));
        totaltrans.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totaltrans.setText("0");
        jPanel8.add(totaltrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel8);
        jPanel8.setBounds(30, 70, 180, 60);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Today's Transactions:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        dailytrans.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        dailytrans.setForeground(new java.awt.Color(255, 255, 255));
        dailytrans.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dailytrans.setText("0");
        jPanel9.add(dailytrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel9);
        jPanel9.setBounds(220, 70, 180, 60);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Amount of Sales:");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        totalsales.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        totalsales.setForeground(new java.awt.Color(255, 255, 255));
        totalsales.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalsales.setText("0");
        jPanel10.add(totalsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        main_panel.add(jPanel10);
        jPanel10.setBounds(410, 70, 180, 60);

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

    private void transtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transtableMouseClicked

    }//GEN-LAST:event_transtableMouseClicked

    private void transtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyPressed

    }//GEN-LAST:event_transtableKeyPressed

    private void transtableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyTyped

    }//GEN-LAST:event_transtableKeyTyped

    private void transtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyReleased

    }//GEN-LAST:event_transtableKeyReleased

    private void salesgraphMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesgraphMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_salesgraphMouseClicked

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        displayTable();
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        int rowid = transtable.getSelectedRow();
        TableModel model = transtable.getModel();
        
        if(rowid != -1){
            dbConnector connect = new dbConnector();
            try {
                ResultSet rs = connect.getData("SELECT " +
                    "t.t_id, " +
                    "t.t_total, " +
                    "t.t_datetime, " +
                    "t.t_staff, " +
                    "t.t_customer, " +
                    "u.u_fname AS staff_fname, " +
                    "u.u_lname AS staff_lname, " +
                    "u.u_type AS staff_type, " +
                    "c.c_fname AS customer_fname, " +
                    "c.c_lname AS customer_lname " +
                    "FROM transactions t " +
                    "JOIN users u ON t.t_staff = u.u_id " +
                    "JOIN customers c ON t.t_customer = c.c_id WHERE t.t_id = "+model.getValueAt(rowid, 0));
                if(rs.next()){
                    admin_salesView open = new admin_salesView();
                    open.id = Integer.parseInt(model.getValueAt(rowid, 0).toString());
                    open.trans.setText("Transaction No: "+ model.getValueAt(rowid, 0));
                    open.customer.setText("Customer: "+ rs.getString("customer_fname")+ " "+ rs.getString("customer_lname"));
                    open.staff.setText("Staff: "+ rs.getString("staff_fname")+ " "+ rs.getString("staff_lname") + " ("+ rs.getString("staff_type")+ ")");
                    open.total.setText("Total: "+ rs.getString("t.t_total"));
                    open.date.setText("Date and Time: "+ rs.getString("t.t_datetime"));
                    open.setVisible(true);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Please select a Transaction!");
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TablePrinter print = new TablePrinter(transtable, "Transaction History");
        print.print();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dailysales;
    private javax.swing.JLabel dailytrans;
    private com.toedter.calendar.JDateChooser datechoosen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel salesgraph;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JLabel totalsales;
    private javax.swing.JLabel totaltrans;
    private javax.swing.JPanel transactiongraph;
    private javax.swing.JTable transtable;
    // End of variables declaration//GEN-END:variables
}
