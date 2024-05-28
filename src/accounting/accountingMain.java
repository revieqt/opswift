package accounting;

import admin.admin_logs;
import admin.admin_salesView;
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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import login.loginForm;
import raven.glasspanepopup.GlassPanePopup;


public class accountingMain extends javax.swing.JFrame {

    public accountingMain() {
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
    
    public void setDateTime(){
        Date now = new Date();
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(now);
        
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
        
        customers_open = false;
        jPanel14.setBackground(sidecolor);
        jLabel17.setForeground(text1color);
        jLabel17.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        discounts_open = false;
        jPanel16.setBackground(sidecolor);
        jLabel19.setForeground(text1color);
        jLabel19.setFont(new Font("SansSerif", Font.PLAIN, 12));
    }
    
    public void dashboardPanel(){
        resetMenu();
        desktop.setVisible(false);
        transactiongraph.setLayout(new java.awt.BorderLayout());
        transactiongraph.add(TransactionGraph.createGraph());
        salesgraph.setLayout(new java.awt.BorderLayout());
        salesgraph.add(SalesGraph.createGraph());
        jPanel4.setVisible(true);
    }
    
    public void staffPanel(){
        resetMenu();
        desktop.setVisible(true);
        accounting_staff up = new accounting_staff();
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
        accounting_products up = new accounting_products();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel11.setBackground(new Color(80, 114, 123));
        jLabel16.setForeground(Color.WHITE);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.BOLD, jLabel16.getFont().getSize()));
        
        products_open = true;
    }
    
    public void customersPanel(){
        resetMenu();
        desktop.setVisible(true);
        accounting_customers up = new accounting_customers();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel14.setBackground(new Color(80, 114, 123));
        jLabel17.setForeground(Color.WHITE);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.BOLD, jLabel17.getFont().getSize()));
        
        customers_open = true;
    }
    
    public void discountsPanel(){
        resetMenu();
        desktop.setVisible(true);
        accounting_discounts up = new accounting_discounts();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
        jPanel16.setBackground(new Color(80, 114, 123));
        jLabel19.setForeground(Color.WHITE);
        jLabel19.setFont(new Font(jLabel19.getFont().getFontName(), Font.BOLD, jLabel19.getFont().getSize()));
        
        discounts_open = true;
    }
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
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        userLog = new javax.swing.JLabel();
        codeLog = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        date_disp = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new enhance.RoundBorder_g();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new enhance.RoundPanel();
        jLabel13 = new javax.swing.JLabel();
        totaltrans = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        dailytrans = new javax.swing.JLabel();
        jPanel10 = new enhance.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        totalsales = new javax.swing.JLabel();
        jPanel17 = new enhance.RoundPanel();
        jLabel21 = new javax.swing.JLabel();
        dailysales = new javax.swing.JLabel();
        transactiongraph = new enhance.RoundBorder_g();
        salesgraph = new enhance.RoundBorder_g();
        jPanel18 = new enhance.RoundBorder_g();
        jScrollPane1 = new javax.swing.JScrollPane();
        transtable = new javax.swing.JTable();
        jPanel3 = new enhance.RoundBorder_g();
        jLabel22 = new javax.swing.JLabel();
        jPanel19 = new enhance.RoundPanel_lb();
        jLabel23 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        datechoosen = new com.toedter.calendar.JDateChooser();
        searchbutton = new enhance.RoundBorder_g();
        jLabel10 = new javax.swing.JLabel();

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
        jLabel5.setText("View");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

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

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 170, 610);

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
        jSeparator1.setBounds(190, 70, 780, 10);

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

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Number of Transactions:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        totaltrans.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        totaltrans.setForeground(new java.awt.Color(255, 255, 255));
        totaltrans.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totaltrans.setText("0");
        jPanel8.add(totaltrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        jPanel1.add(jPanel8);
        jPanel8.setBounds(200, 80, 180, 60);

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

        jPanel1.add(jPanel9);
        jPanel9.setBounds(390, 80, 180, 60);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Amount of Sales:");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        totalsales.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        totalsales.setForeground(new java.awt.Color(255, 255, 255));
        totalsales.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalsales.setText("0");
        jPanel10.add(totalsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        jPanel1.add(jPanel10);
        jPanel10.setBounds(580, 80, 180, 60);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Today's Sales");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 10));

        dailysales.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        dailysales.setForeground(new java.awt.Color(255, 255, 255));
        dailysales.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dailysales.setText("0");
        jPanel17.add(dailysales, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 24, 170, 30));

        jPanel1.add(jPanel17);
        jPanel17.setBounds(770, 80, 180, 60);

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

        jPanel1.add(transactiongraph);
        transactiongraph.setBounds(200, 150, 370, 190);

        salesgraph.setBackground(new java.awt.Color(255, 255, 255));
        salesgraph.setToolTipText("Search");
        salesgraph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesgraphMouseClicked(evt);
            }
        });
        salesgraph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(salesgraph);
        salesgraph.setBounds(580, 150, 370, 190);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transtable.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        transtable.setForeground(new java.awt.Color(53, 55, 75));
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

        jPanel18.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 140));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Print Table");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        jPanel18.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 150, 40));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("View Transaction");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 40));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 150, 40));

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
        jPanel18.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        datechoosen.setBackground(new java.awt.Color(255, 255, 255));
        datechoosen.setForeground(new java.awt.Color(0, 51, 51));
        datechoosen.setDateFormatString("yyyy-MM-dd");
        jPanel18.add(datechoosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 290, 30));

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

        jPanel18.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 40, -1));

        jPanel1.add(jPanel18);
        jPanel18.setBounds(200, 350, 750, 250);

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
    }//GEN-LAST:event_formWindowActivated

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        accounting_profile prof = new accounting_profile();
        desktop.setVisible(true);
        desktop.add(prof).setVisible(true);
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        desktop.setVisible(true);
        admin_logs up = new admin_logs();
        desktop.add(up).setVisible(true);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void salesgraphMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesgraphMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_salesgraphMouseClicked

    private void transtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transtableMouseClicked

    }//GEN-LAST:event_transtableMouseClicked

    private void transtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyPressed

    }//GEN-LAST:event_transtableKeyPressed

    private void transtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyReleased

    }//GEN-LAST:event_transtableKeyReleased

    private void transtableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transtableKeyTyped

    }//GEN-LAST:event_transtableKeyTyped

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
//        TablePrinter print = new TablePrinter(transtable);
//        print.printTable();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
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
    }//GEN-LAST:event_jPanel19MouseClicked

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
//        displayTable();
    }//GEN-LAST:event_searchbuttonMouseClicked

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
            java.util.logging.Logger.getLogger(accountingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accountingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accountingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accountingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>\
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accountingMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codeLog;
    private javax.swing.JLabel dailysales;
    private javax.swing.JLabel dailytrans;
    private javax.swing.JLabel date_disp;
    private com.toedter.calendar.JDateChooser datechoosen;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel salesgraph;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JLabel time_disp;
    private javax.swing.JLabel totalsales;
    private javax.swing.JLabel totaltrans;
    private javax.swing.JPanel transactiongraph;
    private javax.swing.JTable transtable;
    private javax.swing.JLabel userLog;
    // End of variables declaration//GEN-END:variables
}
