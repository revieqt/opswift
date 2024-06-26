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
import enhance.notif;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import login.loginForm;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;


public class adminMain extends javax.swing.JFrame {

    public adminMain() {
        setUndecorated(true);
        initComponents();
        GlassPanePopup.install(this);
        setTitle("Administrator Control Panel");
        dashboardPanel();
        
        Timer timer = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDateTime();
            }
        });
        timer.start();
        
        
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
        
        Action f4Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                customersPanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "F4_pressed");
        this.getRootPane().getActionMap().put("F4_pressed", f4Action);
        
        Action f5Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                discountsPanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5_pressed");
        this.getRootPane().getActionMap().put("F5_pressed", f5Action);
       
        Action f6Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                salesPanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "F6_pressed");
        this.getRootPane().getActionMap().put("F6_pressed", f6Action);
        
        Action f7Action = new AbstractAction() {
        @Override
            public void actionPerformed(ActionEvent e) {
                archivePanel();
            }
        };
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "F7_pressed");
        this.getRootPane().getActionMap().put("F7_pressed", f7Action);
    }
    
    Color bgcolor = new Color(246,244,235);
    Color sidecolor = new Color(52,73,85);
    Color text1color = new Color(120, 160, 131);
    boolean staff_open = false;
    boolean products_open = false;
    boolean orders_open = false;
    boolean suppliers_open = false;
    boolean customers_open = false;
    boolean sales_open = false;
    boolean discounts_open = false;
    boolean settings_open = false;
    boolean archives_open = false;
    
    public void setDateTime(){
        Date now = new Date();
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String date = dateFormat.format(now);
        
        date_disp.setText(date);
        time_disp.setText(time);
    }
    
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
        jLabel11.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        products_open = false;
        jPanel11.setBackground(sidecolor);
        jLabel16.setForeground(text1color);
        jLabel16.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        orders_open = false;
        jPanel22.setBackground(sidecolor);
        jLabel30.setForeground(text1color);
        jLabel30.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        suppliers_open = false;
        jPanel18.setBackground(sidecolor);
        jLabel28.setForeground(text1color);
        jLabel28.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        customers_open = false;
        jPanel14.setBackground(sidecolor);
        jLabel17.setForeground(text1color);
        jLabel17.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        sales_open = false;
        jPanel15.setBackground(sidecolor);
        jLabel18.setForeground(text1color);
        jLabel18.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        discounts_open = false;
        jPanel16.setBackground(sidecolor);
        jLabel19.setForeground(text1color);
        jLabel19.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        archives_open = false;
        jPanel17.setBackground(sidecolor);
        jLabel21.setForeground(text1color);
        jLabel21.setFont(new Font("SansSerif", Font.PLAIN, 12));
    }
    
    public void dashboardPanel(){
        resetMenu();
        desktop.setVisible(false);
        transactiongraph.setLayout(new java.awt.BorderLayout());
        transactiongraph.add(TransactionGraph.createGraph());
        salesgraph.setLayout(new java.awt.BorderLayout());
        salesgraph.add(SalesGraph.createGraph());
        jPanel4.setVisible(true);
        dbConnector connect = new dbConnector();
        
        numstaff.setText(""+connect.archiveCount("users"));
        numprod.setText(""+connect.archiveCount("products"));
        numcustomer.setText(""+connect.archiveCount("customers"));
        numdiscounts.setText(""+connect.archiveCount("discounts"));
    }
    
    public void staffPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_staff up = new admin_staff();
        desktop.add(up).setVisible(true);;
        jPanel4.setVisible(false);
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
        jPanel4.setVisible(false);
        jPanel11.setBackground(new Color(80, 114, 123));
        jLabel16.setForeground(Color.WHITE);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.BOLD, jLabel16.getFont().getSize()));
        
        products_open = true;
    }
    
    public void ordersPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_orders up = new admin_orders();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel22.setBackground(new Color(80, 114, 123));
        jLabel30.setForeground(Color.WHITE);
        jLabel30.setFont(new Font(jLabel30.getFont().getFontName(), Font.BOLD, jLabel30.getFont().getSize()));
        
        orders_open = true;
    }
    
    public void suppliersPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_suppliers up = new admin_suppliers();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel18.setBackground(new Color(80, 114, 123));
        jLabel28.setForeground(Color.WHITE);
        jLabel28.setFont(new Font(jLabel28.getFont().getFontName(), Font.BOLD, jLabel28.getFont().getSize()));
        
        suppliers_open = true;
    }
    
    public void customersPanel(){
        resetMenu();
        desktop.setVisible(true);
        admin_customers up = new admin_customers();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
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
        jPanel4.setVisible(false);
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
        jPanel4.setVisible(false);
        jPanel16.setBackground(new Color(80, 114, 123));
        jLabel19.setForeground(Color.WHITE);
        jLabel19.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        discounts_open = true;
    }
    
    
    public void archivePanel(){
        admin_archive up = new admin_archive();
        resetMenu();
        desktop.setVisible(true);
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel17.setBackground(new Color(80, 114, 123));
        jLabel21.setForeground(Color.WHITE);
        jLabel21.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        archives_open = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        salesgraph = new enhance.RoundBorder_g();
        transactiongraph = new enhance.RoundBorder_g();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundBorder_w();
        jLabel14 = new javax.swing.JLabel();
        numdiscounts = new javax.swing.JLabel();
        jPanel21 = new enhance.RoundBorder_w();
        jLabel24 = new javax.swing.JLabel();
        numstaff = new javax.swing.JLabel();
        jPanel20 = new enhance.RoundBorder_w();
        jLabel23 = new javax.swing.JLabel();
        numprod = new javax.swing.JLabel();
        jPanel19 = new enhance.RoundBorder_w();
        jLabel22 = new javax.swing.JLabel();
        numcustomer = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundBorder_g();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        date_disp = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new enhance.RoundBorder_g();
        jLabel15 = new javax.swing.JLabel();

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

        salesgraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout salesgraphLayout = new javax.swing.GroupLayout(salesgraph);
        salesgraph.setLayout(salesgraphLayout);
        salesgraphLayout.setHorizontalGroup(
            salesgraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        salesgraphLayout.setVerticalGroup(
            salesgraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel1.add(salesgraph);
        salesgraph.setBounds(580, 360, 370, 230);

        transactiongraph.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout transactiongraphLayout = new javax.swing.GroupLayout(transactiongraph);
        transactiongraph.setLayout(transactiongraphLayout);
        transactiongraphLayout.setHorizontalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        transactiongraphLayout.setVerticalGroup(
            transactiongraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel1.add(transactiongraph);
        transactiongraph.setBounds(200, 360, 370, 230);

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

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 150, 30));

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

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

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

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(120, 160, 131));
        jLabel5.setText("Inventory");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));

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

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 30));

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

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, 30));

        jPanel2.setBackground(new java.awt.Color(52, 73, 85));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
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

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 150, 30));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(120, 160, 131));
        jLabel26.setText("Menu");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 86, -1, 30));

        jPanel18.setBackground(new java.awt.Color(52, 73, 85));
        jPanel18.setToolTipText("[F3] Products");
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-supplier-20.png"))); // NOI18N
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(120, 160, 131));
        jLabel28.setText("Suppliers");
        jPanel18.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 150, 30));

        jPanel22.setBackground(new java.awt.Color(52, 73, 85));
        jPanel22.setToolTipText("[F3] Products");
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
        });
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-box-20.png"))); // NOI18N
        jPanel22.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(120, 160, 131));
        jLabel30.setText("Orders");
        jPanel22.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel5.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 30));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 170, 610);

        jPanel9.setBackground(new java.awt.Color(80, 114, 123));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Discounts");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        numdiscounts.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        numdiscounts.setForeground(new java.awt.Color(255, 255, 255));
        numdiscounts.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numdiscounts.setText("0");
        jPanel9.add(numdiscounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        jPanel1.add(jPanel9);
        jPanel9.setBounds(760, 250, 170, 120);

        jPanel21.setBackground(new java.awt.Color(80, 114, 123));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(80, 114, 123));
        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Staff");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 40));

        numstaff.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        numstaff.setForeground(new java.awt.Color(255, 255, 255));
        numstaff.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numstaff.setText("0");
        jPanel21.add(numstaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        jPanel1.add(jPanel21);
        jPanel21.setBounds(220, 250, 170, 120);

        jPanel20.setBackground(new java.awt.Color(80, 114, 123));
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

        numprod.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        numprod.setForeground(new java.awt.Color(255, 255, 255));
        numprod.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numprod.setText("0");
        jPanel20.add(numprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        jPanel1.add(jPanel20);
        jPanel20.setBounds(400, 250, 170, 120);

        jPanel19.setBackground(new java.awt.Color(80, 114, 123));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Customers");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        numcustomer.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        numcustomer.setForeground(new java.awt.Color(255, 255, 255));
        numcustomer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        numcustomer.setText("0");
        jPanel19.add(numcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        jPanel1.add(jPanel19);
        jPanel19.setBounds(580, 250, 170, 120);

        jPanel6.setBackground(new java.awt.Color(120, 160, 131));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Hello,");
        jPanel6.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 390, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Welcome to Opswift Point of Sales System");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 350, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/headerdash.png"))); // NOI18N
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(170, 80, 810, 210);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-bell-30.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(690, 20, 40, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date_disp.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        date_disp.setForeground(new java.awt.Color(120, 160, 131));
        date_disp.setText("dd/mm/yyyy");
        jPanel4.add(date_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 40));

        time_disp.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        time_disp.setForeground(new java.awt.Color(120, 160, 131));
        time_disp.setText("hh-mm-ss");
        jPanel4.add(time_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 40));

        jPanel1.add(jPanel4);
        jPanel4.setBounds(790, 20, 170, 40);

        jSeparator1.setForeground(new java.awt.Color(120, 160, 131));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(180, 70, 790, 10);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-logs-folder-30.png"))); // NOI18N
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(740, 20, 40, 40);

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

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dashboardPanel();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        userLog.setText(sess.getFname() + " " + sess.getLname());
        codeLog.setText(sess.getCode());
        header.setText("Hello, "+ sess.getFname()+ "!");
    }//GEN-LAST:event_formWindowActivated

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

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        admin_profile prof = new admin_profile();
        desktop.setVisible(true);
        desktop.add(prof).setVisible(true);
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        desktop.setVisible(true);
        admin_logs up = new admin_logs();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        GlassPanePopup.showPopup(new notif(),new DefaultOption(){
            @Override
                public float opacity(){
                    return 0;
                }
        });
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        customersPanel();
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        discountsPanel();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        suppliersPanel();
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        if(suppliers_open == false){
            jLabel28.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        if(suppliers_open == false){
            jLabel28.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        ordersPanel();
    }//GEN-LAST:event_jPanel22MouseClicked

    private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
        if(orders_open == false){
            jLabel30.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jPanel22MouseEntered

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        if(orders_open == false){
            jLabel30.setForeground(text1color);
        }
    }//GEN-LAST:event_jPanel22MouseExited

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
    private javax.swing.JLabel date_disp;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel header;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numcustomer;
    private javax.swing.JLabel numdiscounts;
    private javax.swing.JLabel numprod;
    private javax.swing.JLabel numstaff;
    private javax.swing.JPanel salesgraph;
    private javax.swing.JLabel time_disp;
    private javax.swing.JPanel transactiongraph;
    private javax.swing.JLabel userLog;
    // End of variables declaration//GEN-END:variables
}
