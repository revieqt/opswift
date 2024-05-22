package admin;

import config.SalesGraph;
import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import config.Session;
import config.TransactionGraph;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import login.loginForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SCC1
 */
public class adminMain extends javax.swing.JFrame {

    /**
     * Creates new form cashier_dashboard
     */
    public adminMain() {
        initComponents();
        setTitle("Administrator Control Panel");
        dashboardPanel();
        Action f1Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel();
                
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1_pressed");
        this.getRootPane().getActionMap().put("F1_pressed", f1Action);
        
        Action f2Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                staffPanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2_pressed");
        this.getRootPane().getActionMap().put("F2_pressed", f2Action);
        
        Action f3Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                productsPanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3_pressed");
        this.getRootPane().getActionMap().put("F3_pressed", f3Action);
       
    }
    
    Color bgcolor = new Color(246,244,235);
    Color sidecolor = new Color(52,73,85);
    Color text1color = new Color(120, 160, 131);
    boolean staff_open = false;
    boolean products_open = false;
    boolean customers_open = false;
    boolean sales_open = false;
    boolean discounts_open = false;
    boolean settings_open = false;
    boolean archives_open = false;
    
 
    
    public static boolean checkData(String a,String b, String c, String d){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT "+a+" FROM "+b+"  WHERE "+c+" = '" +d + "'";
            ResultSet resultSet = connector.getData(query);
            return resultSet.next();
        }catch (SQLException ex) {
            return false;
        }
    }
    
    public static String getData(String a,String b, String c, String d){
        dbConnector connector = new dbConnector();
        String returnString = null;
        try{
            String query = "SELECT "+a+" FROM "+b+"  WHERE "+c+" = '" +d + "'";
            ResultSet resultSet = connector.getData(query);
            if (resultSet.next()) {
                returnString = resultSet.getString(a);
                return returnString;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return returnString;
    }
    
    public void resetMenu(){
        staff_open = false;
        jPanel12.setBackground(sidecolor);
        jLabel11.setForeground(text1color);
        jLabel11.setFont(new Font(jLabel11.getFont().getFontName(), Font.PLAIN, jLabel11.getFont().getSize()));
        
        products_open = false;
        jPanel11.setBackground(sidecolor);
        jLabel16.setForeground(text1color);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.PLAIN, jLabel16.getFont().getSize()));
        
        customers_open = false;
        jPanel14.setBackground(sidecolor);
        jLabel17.setForeground(text1color);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.PLAIN, jLabel17.getFont().getSize()));
        
        sales_open = false;
        jPanel15.setBackground(sidecolor);
        jLabel18.setForeground(text1color);
        jLabel18.setFont(new Font(jLabel18.getFont().getFontName(), Font.PLAIN, jLabel18.getFont().getSize()));
        
        discounts_open = false;
        jPanel16.setBackground(sidecolor);
        jLabel19.setForeground(text1color);
        jLabel19.setFont(new Font(jLabel19.getFont().getFontName(), Font.PLAIN, jLabel19.getFont().getSize()));
        
        settings_open = false;
        jPanel13.setBackground(sidecolor);
        jLabel20.setForeground(text1color);
        jLabel20.setFont(new Font(jLabel20.getFont().getFontName(), Font.PLAIN, jLabel20.getFont().getSize()));
        
        archives_open = false;
        jPanel17.setBackground(sidecolor);
        jLabel21.setForeground(text1color);
        jLabel21.setFont(new Font(jLabel20.getFont().getFontName(), Font.PLAIN, jLabel20.getFont().getSize()));
    }
    
    public void dashboardPanel(){
        resetMenu();
        desktop.setVisible(false);
        transactiongraph.setLayout(new java.awt.BorderLayout());
        transactiongraph.add(TransactionGraph.createGraph());
        salesgraph.setLayout(new java.awt.BorderLayout());
        salesgraph.add(SalesGraph.createGraph());
        
        dbConnector connect = new dbConnector();
        
        numstaff.setText(""+connect.columnCount("users"));
        numprod.setText(""+connect.columnCount("products"));
        numcustomer.setText(""+connect.columnCount("customers"));
//        numsales.setText(""+sales);
//        numdiscounts.setText(""+discounts);
    }
    
    public void staffPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_staff up = new admin_staff();
        desktop.add(up).setVisible(true);;
        
        jPanel12.setBackground(new Color(80, 114, 123));
        jLabel11.setForeground(Color.WHITE);
        jLabel11.setFont(new Font(jLabel11.getFont().getFontName(), Font.BOLD, jLabel11.getFont().getSize()));
        
        staff_open = true;
    }
    
    public void productsPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_products up = new admin_products();
        desktop.add(up).setVisible(true);
        
        jPanel11.setBackground(new Color(80, 114, 123));
        jLabel16.setForeground(Color.WHITE);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.BOLD, jLabel16.getFont().getSize()));
        
        products_open = true;
    }
    
    public void customersPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_customers up = new admin_customers();
        desktop.add(up).setVisible(true);
        
        jPanel14.setBackground(new Color(80, 114, 123));
        jLabel17.setForeground(Color.WHITE);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.BOLD, jLabel17.getFont().getSize()));
        
        customers_open = true;
    }
    
    public void salesPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_sales up = new admin_sales();
        desktop.add(up).setVisible(true);
        
        jPanel15.setBackground(new Color(80, 114, 123));
        jLabel18.setForeground(Color.WHITE);
        jLabel18.setFont(new Font(jLabel18.getFont().getFontName(), Font.BOLD, jLabel18.getFont().getSize()));
        
        sales_open = true;
    }
    
    public void discountsPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_discounts up = new admin_discounts();
        desktop.add(up).setVisible(true);
        
        jPanel16.setBackground(new Color(80, 114, 123));
        jLabel19.setForeground(Color.WHITE);
        jLabel19.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        discounts_open = true;
    }
    
    public void settingsPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_settings up = new admin_settings();
        desktop.add(up).setVisible(true);
        
        jPanel13.setBackground(new Color(80, 114, 123));
        jLabel20.setForeground(Color.WHITE);
        jLabel20.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        settings_open = true;
    }
    
    
    
    public void archivePanel(){
        admin_archive up = new admin_archive();
        resetMenu();
        desktop.setVisible(true);
        desktop.add(up).setVisible(true);
        
        jPanel17.setBackground(new Color(80, 114, 123));
        jLabel21.setForeground(Color.WHITE);
        jLabel21.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        archives_open = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        userLog = new javax.swing.JLabel();
        codeLog = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        searchbutton = new enhance.RoundBorder_g();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundPanel();
        jLabel14 = new javax.swing.JLabel();
        numdiscounts = new javax.swing.JLabel();
        jPanel18 = new enhance.RoundPanel();
        jLabel15 = new javax.swing.JLabel();
        numsales = new javax.swing.JLabel();
        jPanel19 = new enhance.RoundPanel();
        jLabel22 = new javax.swing.JLabel();
        numcustomer = new javax.swing.JLabel();
        jPanel20 = new enhance.RoundPanel();
        jLabel23 = new javax.swing.JLabel();
        numprod = new javax.swing.JLabel();
        jPanel21 = new enhance.RoundPanel();
        jLabel24 = new javax.swing.JLabel();
        numstaff = new javax.swing.JLabel();
        salesgraph = new enhance.RoundBorder_g();
        transactiongraph = new enhance.RoundBorder_g();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 244, 235));
        jPanel1.setLayout(null);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel1.add(desktop);
        desktop.setBounds(170, 0, 810, 610);

        jPanel5.setBackground(new java.awt.Color(52, 73, 85));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(52, 73, 85));
        jPanel11.setToolTipText("[F3] Products");
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_cart_20.png"))); // NOI18N
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(120, 160, 131));
        jLabel16.setText("Products");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/opswift-removebg-preview (3).png"))); // NOI18N
        jLabel4.setToolTipText("[F1] Back to Dashboard");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, -1));

        jPanel12.setBackground(new java.awt.Color(52, 73, 85));
        jPanel12.setToolTipText("[F2] Staff");
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(120, 160, 131));
        jLabel11.setText("Staff");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_user_20.png"))); // NOI18N
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 30));

        jPanel13.setBackground(new java.awt.Color(52, 73, 85));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(120, 160, 131));
        jLabel20.setText("Settings");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_settings_20.png"))); // NOI18N
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel5.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 150, 30));

        jPanel14.setBackground(new java.awt.Color(52, 73, 85));
        jPanel14.setToolTipText("[F4] Customers");
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_user_20.png"))); // NOI18N
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(120, 160, 131));
        jLabel17.setText("Customers");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 150, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Menu");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel15.setBackground(new java.awt.Color(52, 73, 85));
        jPanel15.setToolTipText("[F5] Sales");
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_sales_20.png"))); // NOI18N
        jPanel15.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(120, 160, 131));
        jLabel18.setText("Sales");
        jPanel15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, 30));

        jPanel16.setBackground(new java.awt.Color(52, 73, 85));
        jPanel16.setToolTipText("[F6] Discounts");
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_discount_20.png"))); // NOI18N
        jPanel16.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(120, 160, 131));
        jLabel19.setText("Discounts");
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, 30));

        jPanel2.setBackground(new java.awt.Color(52, 73, 85));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_logout.png"))); // NOI18N
        jLabel2.setToolTipText("Log-out");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 0, 40, 50));

        userLog.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userLog.setForeground(new java.awt.Color(255, 255, 255));
        userLog.setText("John Doe");
        jPanel2.add(userLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 39));

        codeLog.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        codeLog.setForeground(new java.awt.Color(120, 160, 131));
        codeLog.setText("jLabel10");
        jPanel2.add(codeLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 24, 80, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 170, 50));

        jPanel17.setBackground(new java.awt.Color(52, 73, 85));
        jPanel17.setToolTipText("[F6] Discounts");
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-archive-20.png"))); // NOI18N
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(120, 160, 131));
        jLabel21.setText("Archives");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 150, 30));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 170, 610);

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
        jPanel1.add(searchbar);
        searchbar.setBounds(230, 130, 620, 40);

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel1.add(searchbutton);
        searchbutton.setBounds(860, 130, 60, 40);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Discounts");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        numdiscounts.setFont(new java.awt.Font("SansSerif", 0, 60)); // NOI18N
        numdiscounts.setForeground(new java.awt.Color(255, 255, 255));
        numdiscounts.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numdiscounts.setText("0");
        jPanel9.add(numdiscounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel1.add(jPanel9);
        jPanel9.setBounds(650, 190, 130, 170);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sales");
        jPanel18.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 40));

        numsales.setFont(new java.awt.Font("SansSerif", 0, 60)); // NOI18N
        numsales.setForeground(new java.awt.Color(255, 255, 255));
        numsales.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numsales.setText("0");
        jPanel18.add(numsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel1.add(jPanel18);
        jPanel18.setBounds(790, 190, 130, 170);

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Customers");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        numcustomer.setFont(new java.awt.Font("SansSerif", 0, 60)); // NOI18N
        numcustomer.setForeground(new java.awt.Color(255, 255, 255));
        numcustomer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numcustomer.setText("0");
        jPanel19.add(numcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel1.add(jPanel19);
        jPanel19.setBounds(510, 190, 130, 170);

        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Products");
        jPanel20.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        numprod.setFont(new java.awt.Font("SansSerif", 0, 60)); // NOI18N
        numprod.setForeground(new java.awt.Color(255, 255, 255));
        numprod.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numprod.setText("0");
        jPanel20.add(numprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel1.add(jPanel20);
        jPanel20.setBounds(370, 190, 130, 170);

        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Staff");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 40));

        numstaff.setFont(new java.awt.Font("SansSerif", 0, 60)); // NOI18N
        numstaff.setForeground(new java.awt.Color(255, 255, 255));
        numstaff.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numstaff.setText("0");
        jPanel21.add(numstaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel1.add(jPanel21);
        jPanel21.setBounds(230, 190, 130, 170);

        salesgraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout salesgraphLayout = new javax.swing.GroupLayout(salesgraph);
        salesgraph.setLayout(salesgraphLayout);
        salesgraphLayout.setHorizontalGroup(
            salesgraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        salesgraphLayout.setVerticalGroup(
            salesgraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel1.add(salesgraph);
        salesgraph.setBounds(590, 380, 340, 200);

        transactiongraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout transactiongraphLayout = new javax.swing.GroupLayout(transactiongraph);
        transactiongraph.setLayout(transactiongraphLayout);
        transactiongraphLayout.setHorizontalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        transactiongraphLayout.setVerticalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel1.add(transactiongraph);
        transactiongraph.setBounds(230, 380, 340, 200);

        jPanel3.setBackground(new java.awt.Color(246, 244, 235));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-bell-30.png"))); // NOI18N
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(880, 30, 40, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/admindashboard.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(170, 0, 810, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        productsPanel();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loginForm open = new loginForm();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        staffPanel();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        settingsPanel();
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        customersPanel();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        salesPanel();
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        discountsPanel();
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        if(staff_open == false){
            jLabel11.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        if(staff_open == false){
            jLabel11.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        if(products_open == false){
            jLabel16.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        if(products_open == false){
            jLabel16.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        if(customers_open == false){
            jLabel17.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        if(customers_open == false){
            jLabel17.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        if(sales_open == false){
            jLabel18.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        if(sales_open == false){
            jLabel18.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        if(discounts_open == false){
            jLabel19.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        if(discounts_open == false){
            jLabel19.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        if(settings_open == false){
            jLabel20.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        if(settings_open == false){
            jLabel20.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel13MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dashboardPanel();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        userLog.setText(sess.getFname() + " " + sess.getLname());
        codeLog.setText(sess.getCode());
    }//GEN-LAST:event_formWindowActivated

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        staffPanel();
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        productsPanel();
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        archivePanel();
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        if(archives_open == false){
            jLabel21.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        if(archives_open == false){
            jLabel21.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel17MouseExited

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
            java.util.logging.Logger.getLogger(adminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>\
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codeLog;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel numcustomer;
    private javax.swing.JLabel numdiscounts;
    private javax.swing.JLabel numprod;
    private javax.swing.JLabel numsales;
    private javax.swing.JLabel numstaff;
    private javax.swing.JPanel salesgraph;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JPanel transactiongraph;
    private javax.swing.JLabel userLog;
    // End of variables declaration//GEN-END:variables
}
