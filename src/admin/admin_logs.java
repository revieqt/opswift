package admin;

import config.dbConnector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import config.TableQueries;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import print.TablePrinter;

public class admin_logs extends javax.swing.JInternalFrame {

    public admin_logs() {
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
    
public void displayTable() {
        try {
            dbConnector connector = new dbConnector();
            String query = constructQuery();
            ResultSet rs = connector.getData(query);
            DefaultTableModel tblmod = (DefaultTableModel)archive_table.getModel();
            tblmod.setRowCount(0);
            while(rs.next()){
                String dbDateTime = rs.getString("l_datetime");
                String dbAction = rs.getString("l_action");
                
                String table[] = {dbDateTime, dbAction};
                
                tblmod.addRow(table);
                }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private String constructQuery() {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM logs");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        boolean hasDate = datechoosen.getDate() != null;
        boolean hasSearchTerm = searchbar.getText() != null && !searchbar.getText().trim().isEmpty();

        if (hasDate || hasSearchTerm) {
            queryBuilder.append(" WHERE ");
        }

        if (hasDate) {
            String selectedDate = sdf.format(datechoosen.getDate());
            queryBuilder.append("DATE(l_datetime) = '").append(selectedDate).append("'");
        }

        if (hasDate && hasSearchTerm) {
            queryBuilder.append(" AND ");
        }

        if (hasSearchTerm) {
            String searchTerm = searchbar.getText().trim();
            queryBuilder.append("(l_staff LIKE '%").append(searchTerm).append("%' ")
                        .append("OR l_action LIKE '%").append(searchTerm).append("%')");
        }

        return queryBuilder.toString();
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
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel5 = new javax.swing.JLabel();
        datechoosen = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

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
        jLabel1.setText("Activity Logs");
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
        archive_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date and Time", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (archive_table.getColumnModel().getColumnCount() > 0) {
            archive_table.getColumnModel().getColumn(0).setResizable(false);
            archive_table.getColumnModel().getColumn(1).setResizable(false);
        }

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
        jLabel5.setText("Print Table");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        main_panel.add(jPanel3);
        jPanel3.setBounds(600, 550, 180, 40);

        datechoosen.setBackground(new java.awt.Color(255, 255, 255));
        datechoosen.setForeground(new java.awt.Color(0, 51, 51));
        datechoosen.setDateFormatString("yyyy-MM-dd");
        main_panel.add(datechoosen);
        datechoosen.setBounds(480, 80, 250, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-print-35.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        main_panel.add(jLabel2);
        jLabel2.setBounds(690, 10, 40, 50);

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
        displayTable();
        searchbar.setText("");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

    }//GEN-LAST:event_jPanel3MouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        displayTable();
    }//GEN-LAST:event_formInternalFrameActivated

    private void archive_tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyTyped

    }//GEN-LAST:event_archive_tableKeyTyped

    private void archive_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyReleased
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
    }//GEN-LAST:event_archive_tableKeyReleased

    private void archive_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_archive_tableKeyPressed

    }//GEN-LAST:event_archive_tableKeyPressed

    private void archive_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archive_tableMouseClicked
        int choose = archive_table.getSelectedRow();
        TableModel model = archive_table.getModel();
    }//GEN-LAST:event_archive_tableMouseClicked

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        displayTable();
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped

    }//GEN-LAST:event_searchbarKeyTyped

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TablePrinter print = new TablePrinter(archive_table, "Activity Logs");
        print.print();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable archive_table;
    private com.toedter.calendar.JDateChooser datechoosen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    // End of variables declaration//GEN-END:variables
}
