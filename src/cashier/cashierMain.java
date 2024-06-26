package cashier;

import admin.admin_profile;
import admin.admin_staff;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import login.loginForm;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SCC1
 */
public class cashierMain extends javax.swing.JFrame {
    public ArrayList<Product> prod = new ArrayList<>();
    public boolean scanCustomer = false;
    dbConnector connect = new dbConnector();
    public cashierMain() {
        setUndecorated(true);
        initComponents();
        setTitle("Opswift POS");
        Timer timer = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDateTime();
            }
        });
        timer.start();
        
    }
    
    Color bgcolor = new Color(246,244,235);
    Color sidecolor = new Color(52,73,85);
    Color text1color = new Color(120, 160, 131);
    boolean void_open = false;
    boolean customers_open = false;
    
    public void setDateTime(){
        Date now = new Date();
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(now);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String date = dateFormat.format(now);
        
        date_disp.setText(date);
        time_disp.setText(time);
    }
    
    
    public void resetMenu(){
        void_open = false;
        voidButton.setBackground(sidecolor);
        jLabel16.setForeground(text1color);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.PLAIN, jLabel16.getFont().getSize()));
        
        customers_open = false;
        customerButton.setBackground(sidecolor);
        jLabel17.setForeground(text1color);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.PLAIN, jLabel17.getFont().getSize()));
    }
    
       
    public class Product{
        private String code;
        private String name;
        private double price;
        private int quantity;
        private double discount;
        private double total;
        public String discountType;
        public boolean hasDiscount = false;

        public Product(String code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
            this.quantity = 1;
        }
        
        public void setQuantity(int qty){
            this.quantity = qty;
        }
        
        public void setDiscount(double disc, boolean percent){
            this.discount = disc;
            
            if(percent){
                this.discountType = "Percent";
            }else{
                this.discountType = "Fixed Amount";
            }
            hasDiscount = true;
            
        }
        
        public String getCode(){
            return this.code;
        }
        
        public String getName(){
            return this.name;
        }
        
        public double getPrice(){
            return this.price;
        }
        
        public int getQuantity(){
            return this.quantity;
        }
        
        public double getDiscount(){
            return this.discount;
        }
        
        public boolean hasDiscount(){
            return this.hasDiscount;
        }
        
        public double getTotal(){
            double ttal = 0;
            if(hasDiscount){
                if(discountType.equals("Percent")){
                        ttal = this.price * this.quantity - ((this.price * this.quantity) * (this.discount/100.0));
                    }else{
                        ttal = (this.price * this.quantity) - this.discount;
                    }
            }else{
                ttal = this.price * this.quantity;
            }
            return ttal;
        }
}
    
    
    public void scanProduct(String barcode){
        dbConnector connect = new dbConnector();
        
        int e_barcodeindex = 0;
        String name = null;
        String price = null;
        try{
            String query = "SELECT * FROM products  WHERE p_barcode = '" + barcode + "'";
            ResultSet resultSet = connect.getData(query);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int nextRow = model.getRowCount();

            boolean barcodeExists = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String bar = (String) model.getValueAt(i, 0);
                if (barcode.equals(bar)) {
                    barcodeExists = true;
                    e_barcodeindex = i;
                    break;
                }
            }
            
            
            if(resultSet.next()){
                if(barcodeExists){
                    
                    prod.get(e_barcodeindex).setQuantity((prod.get(e_barcodeindex).getQuantity()) + 1);
                    model.setValueAt(prod.get(e_barcodeindex).getQuantity(), e_barcodeindex, 3);
                    model.setValueAt(prod.get(e_barcodeindex).getTotal(), e_barcodeindex, 4);
                    displayInfo(e_barcodeindex);
                    table.setRowSelectionInterval(e_barcodeindex, e_barcodeindex);
                }else{
                    prod.add(new Product(resultSet.getString("p_barcode"), resultSet.getString("p_name"), resultSet.getDouble("p_price")));
                    model.addRow(new Object[]{prod.get(nextRow).getCode(), prod.get(nextRow).getName(), prod.get(nextRow).getPrice(), prod.get(nextRow).getQuantity(), prod.get(nextRow).getTotal()});
                    displayInfo(nextRow);
                    table.setRowSelectionInterval(nextRow, nextRow);
                }
            }else{
                System.out.println("Product not found!");
                
            }
            
            displayTotal(model);
            searchbar.setText("");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    
    
    public void updateQty() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String qtyString = JOptionPane.showInputDialog(null, "Enter quantity:");
            try {
                int qty = Integer.parseInt(qtyString);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                prod.get(selectedRow).setQuantity(qty);

                model.setValueAt(qty, selectedRow, 3);
                model.setValueAt(String.format("%.2f",prod.get(selectedRow).getTotal()), selectedRow, 4);
                displayInfo(selectedRow);
                displayTotal(model);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid quantity input!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
}
    
    public void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);
            prod.remove(selectedRow);
            displayTotal(model);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
        }
    }
    public void addDiscount() {
    int selectedRow = table.getSelectedRow();
   
    if (selectedRow != -1) {
        String discount = JOptionPane.showInputDialog(null, "Enter Discount Code:");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            ResultSet rs = connect.getData("SELECT * FROM discounts WHERE d_code = '"+discount+"'");
            if(rs.next()){
                if(rs.getString("d_redeemabletype").equals("Redeem on Product")){
                    if(rs.getString("d_status").equals("Active")){
                        connect.updateData("UPDATE discounts SET d_redeemable = d_redeemable - 1 WHERE d_code = '"+discount+"'");
                        JOptionPane.showMessageDialog(null, "Discount redeemed successfully!");
                        if(rs.getString("d_type").equals("Percent")){
                            prod.get(selectedRow).setDiscount(rs.getDouble("d_amount"), true);
                        }else{
                            prod.get(selectedRow).setDiscount(rs.getDouble("d_amount"), false);
                        }
                        model.setValueAt(prod.get(selectedRow).getTotal(), selectedRow, 4);
                        displayInfo(selectedRow);
                        displayTotal(model);
                    }else{
                        JOptionPane.showMessageDialog(null, "Discount currently unavailable!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Discount not covered!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Discount Code!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to apply discount!");
    }
}
    public void displayInfo(int index){
        pname_disp.setText("<html><body><center>"+prod.get(index).getName()+"</center></body></html>");
        code_disp.setText(prod.get(index).getCode());
        price_disp.setText(String.format("%.2f", prod.get(index).getPrice()));
        qty_disp.setText(String.format("%d", prod.get(index).getQuantity()));
        total_disp.setText(String.format("%.2f", prod.get(index).getTotal()));
        if(prod.get(index).hasDiscount){
            if(prod.get(index).discountType.equals("Percent")){
                discount_disp.setText((prod.get(index).price * prod.get(index).quantity)+" - "+ ((prod.get(index).price * prod.get(index).quantity) * (prod.get(index).discount/100.0)) +" ("+ prod.get(index).discount+ "%)");
            }else{
                discount_disp.setText((prod.get(index).price*prod.get(index).quantity)+" - "+ String.valueOf(prod.get(index).discount));
            }
            
        }else{
            discount_disp.setText("---");
        }
    }
    
    public void displayTotal(DefaultTableModel model){
    double sum = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, 4);
        if (value instanceof Double) {
            sum += (Double) value;
        } else if (value instanceof String) {
            try {
                sum += Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                e.printStackTrace(); 
            }
        }
    }
    grandtotal_disp.setText(String.format("%.2f", sum));
}
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        voidButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        time_disp = new javax.swing.JLabel();
        jPanel2 = new enhance.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        userLog = new javax.swing.JLabel();
        codeLog = new javax.swing.JLabel();
        date_disp = new javax.swing.JLabel();
        jPanel3 = new enhance.RoundBorder_g();
        searchbar = new javax.swing.JTextField();
        searchbutton = new enhance.RoundBorder_g();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel6 = new enhance.RoundBorder_g();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        code_disp = new javax.swing.JLabel();
        price_disp = new javax.swing.JLabel();
        qty_disp = new javax.swing.JLabel();
        total_disp = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pname_disp = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        discount_disp = new javax.swing.JLabel();
        jPanel9 = new enhance.RoundPanel();
        jPanel4 = new enhance.RoundBorder_w();
        grandtotal_disp = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();
        jPanel7 = new enhance.RoundBorder_g();
        guest = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ccode = new javax.swing.JLabel();

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

        voidButton.setBackground(new java.awt.Color(52, 73, 85));
        voidButton.setToolTipText("[F3] Products");
        voidButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voidButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voidButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voidButtonMouseExited(evt);
            }
        });
        voidButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons-void-20.png"))); // NOI18N
        voidButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(120, 160, 131));
        jLabel16.setText("Void Transaction");
        voidButton.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        jPanel5.add(voidButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/opswift-removebg-preview (3).png"))); // NOI18N
        jLabel4.setToolTipText("[F1] Back to Dashboard");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        customerButton.setBackground(new java.awt.Color(52, 73, 85));
        customerButton.setToolTipText("[F4] Customers");
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });
        customerButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_user_20.png"))); // NOI18N
        customerButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(120, 160, 131));
        jLabel17.setText("Customer Loyalty");
        customerButton.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        jPanel5.add(customerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, 30));

        time_disp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        time_disp.setForeground(new java.awt.Color(255, 255, 255));
        time_disp.setText("hh-mm-ss");
        jPanel5.add(time_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, -1));

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
        userLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userLogMouseEntered(evt);
            }
        });
        jPanel2.add(userLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 39));

        codeLog.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        codeLog.setForeground(new java.awt.Color(120, 160, 131));
        codeLog.setText("jLabel10");
        jPanel2.add(codeLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 24, 80, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 170, 50));

        date_disp.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        date_disp.setForeground(new java.awt.Color(255, 255, 255));
        date_disp.setText("dd/mm/yyyy");
        jPanel5.add(date_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, -1));

        jPanel3.setBackground(new java.awt.Color(52, 73, 85));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 60));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 170, 610);

        searchbar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
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
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchbarKeyPressed(evt);
            }
        });
        jPanel1.add(searchbar);
        searchbar.setBounds(190, 30, 430, 40);

        searchbutton.setBackground(new java.awt.Color(255, 255, 255));
        searchbutton.setToolTipText("Search");
        searchbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbuttonMouseClicked(evt);
            }
        });
        searchbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_search.png"))); // NOI18N
        searchbutton.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 20, 40));

        jPanel1.add(searchbutton);
        searchbutton.setBounds(630, 30, 60, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(120, 160, 131));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 80, 500, 510);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(52, 73, 85));
        jLabel24.setText("Price:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(52, 73, 85));
        jLabel25.setText("Quantity:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(52, 73, 85));
        jLabel26.setText("Total:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(52, 73, 85));
        jLabel29.setText("Code:");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, -1));

        code_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        code_disp.setForeground(new java.awt.Color(80, 114, 123));
        code_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(code_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 150, 30));

        price_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        price_disp.setForeground(new java.awt.Color(80, 114, 123));
        price_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(price_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 150, 30));

        qty_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        qty_disp.setForeground(new java.awt.Color(80, 114, 123));
        qty_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(qty_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 150, 30));

        total_disp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        total_disp.setForeground(new java.awt.Color(80, 114, 123));
        total_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(total_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 150, 30));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(52, 73, 85));
        jLabel21.setText("Product Info");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        pname_disp.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        pname_disp.setForeground(new java.awt.Color(80, 114, 123));
        pname_disp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(pname_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 150));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 10));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-quantity-30.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_delete.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons8-discount-30.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(52, 73, 85));
        jLabel27.setText("Discount:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 70, -1));

        discount_disp.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        discount_disp.setForeground(new java.awt.Color(80, 114, 123));
        discount_disp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(discount_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 150, 30));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(710, 80, 250, 350);

        jPanel9.setBackground(new java.awt.Color(246, 244, 235));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(80, 114, 123));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grandtotal_disp.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        grandtotal_disp.setForeground(new java.awt.Color(255, 255, 255));
        grandtotal_disp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        grandtotal_disp.setText("00.00");
        jPanel4.add(grandtotal_disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 212, 50));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Transaction Total:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 110, 30));

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 70));

        jPanel1.add(jPanel9);
        jPanel9.setBounds(710, 440, 250, 90);

        checkout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        checkout.setForeground(new java.awt.Color(0, 102, 102));
        checkout.setText("CHECKOUT");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        jPanel1.add(checkout);
        checkout.setBounds(710, 540, 250, 50);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        guest.setForeground(new java.awt.Color(80, 114, 123));
        guest.setText("Guest!");
        jPanel7.add(guest, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(80, 114, 123));
        jLabel18.setText("Welcome,");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(710, 30, 250, 40);

        ccode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ccode.setForeground(new java.awt.Color(246, 244, 235));
        ccode.setText("0");
        jPanel1.add(ccode);
        ccode.setBounds(900, 10, 8, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voidButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseClicked
        resetMenu();
        voidButton.setBackground(new Color(80, 114, 123));
        jLabel16.setForeground(Color.WHITE);
        jLabel16.setFont(new Font(jLabel16.getFont().getFontName(), Font.BOLD, jLabel16.getFont().getSize()));
        
        void_open = true;
        
        String code = JOptionPane.showInputDialog(null, "Enter Administrator Code:");
        try{
            ResultSet rs = connect.getData("SELECT * FROM users WHERE u_code = '"+code+"'");
            if(rs.next()){
                if(rs.getString("u_status").equals("Active")){
                    cashierMain redo = new cashierMain();
                    redo.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Administrator Inactive!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Administrator Code!");
            }
            resetMenu();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_voidButtonMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loginForm open = new loginForm();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void customerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseClicked
        resetMenu();
        customerButton.setBackground(new Color(80, 114, 123));
        jLabel17.setForeground(Color.WHITE);
        jLabel17.setFont(new Font(jLabel17.getFont().getFontName(), Font.BOLD, jLabel17.getFont().getSize()));
        
        customers_open = true;
        String code = JOptionPane.showInputDialog(null, "By entering customer code,\n"
                + "1 point will be added to the customer\nEnter Customer Code:");
        try{
            ResultSet rs = connect.getData("SELECT * FROM customers WHERE c_code = '"+code+"'");
            if(rs.next()){
                if(rs.getString("c_status").equals("Active")){
                    connect.updateData("UPDATE customers SET c_points = c_points + 1 WHERE c_code = '"+code+"'");
                    guest.setText(rs.getString("c_fname")+"!");
                    ccode.setText(""+rs.getInt("c_id"));
                }else{
                    JOptionPane.showMessageDialog(null, "Customer Inactive! Please contact system administrator!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Customer Code!");
            }
            resetMenu();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_customerButtonMouseClicked

    private void voidButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseEntered
        if(void_open == false){
            jLabel16.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_voidButtonMouseEntered

    private void voidButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voidButtonMouseExited
        if(void_open == false){
            jLabel16.setForeground(text1color);
        }
    }//GEN-LAST:event_voidButtonMouseExited

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        if(customers_open == false){
            jLabel17.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_customerButtonMouseEntered

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        if(customers_open == false){
            jLabel17.setForeground(text1color);
        }
    }//GEN-LAST:event_customerButtonMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        desktop.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void userLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userLogMouseEntered

    private void userLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogMouseClicked
        desktop.setVisible(true);
        admin_profile up = new admin_profile();
        desktop.add(up).setVisible(true);;
       
    }//GEN-LAST:event_userLogMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        desktop.setVisible(false);
        Session sess = Session.getInstance();
        userLog.setText(sess.getFname() + " " + sess.getLname());
        codeLog.setText(sess.getCode());
    }//GEN-LAST:event_formWindowActivated

    private void searchbarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarMouseReleased

    private void searchbarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchbarPropertyChange

    }//GEN-LAST:event_searchbarPropertyChange

    private void searchbarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            scanProduct(searchbar.getText());
        }
    }//GEN-LAST:event_searchbarKeyPressed

    private void searchbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbuttonMouseClicked
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM products WHERE p_id LIKE '%" + query + "%' OR p_barcode LIKE '%" + query + "%' OR p_name LIKE '%" + query + "%' OR p_qty LIKE '%" + query +"%' OR p_price LIKE '%" + query +"%' OR p_status LIKE '%" + query +"%'";

        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbuttonMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
        displayInfo(selectedRow);
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        updateQty();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        deleteItem();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        addDiscount();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if(model.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "Transaction is empty!");
        }else{
            cashier_checkout checkout = new cashier_checkout(model, grandtotal_disp.getText(), Integer.parseInt(ccode.getText()));
            checkout.setVisible(true);
        }
    }//GEN-LAST:event_checkoutActionPerformed

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
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashierMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>\
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashierMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ccode;
    private javax.swing.JButton checkout;
    private javax.swing.JLabel codeLog;
    private javax.swing.JLabel code_disp;
    private javax.swing.JPanel customerButton;
    private javax.swing.JLabel date_disp;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel discount_disp;
    private javax.swing.JLabel grandtotal_disp;
    private javax.swing.JLabel guest;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel pname_disp;
    private javax.swing.JLabel price_disp;
    private javax.swing.JLabel qty_disp;
    private javax.swing.JTextField searchbar;
    private javax.swing.JPanel searchbutton;
    private javax.swing.JTable table;
    private javax.swing.JLabel time_disp;
    private javax.swing.JLabel total_disp;
    private javax.swing.JLabel userLog;
    private javax.swing.JPanel voidButton;
    // End of variables declaration//GEN-END:variables
}
