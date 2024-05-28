package admin;

import static admin.adminMain.checkData;
import config.ImportImages;
import config.TableQueries;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class admin_customersEdit extends javax.swing.JFrame {

    public admin_customersEdit() {
        setUndecorated(true);
        initComponents();
    }
    
    static int id;
    static String cnum;
    static String mail;
    ImportImages imp = new ImportImages();
    public void accessTable(TableModel model, int rowid){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            id = Integer.parseInt(model.getValueAt(rowid, 0).toString());
            fname.setText(model.getValueAt(rowid, 2).toString());
            lname.setText(model.getValueAt(rowid, 3).toString());
            age.setText(model.getValueAt(rowid, 4).toString());
            bdate.setDate(dateFormat.parse(model.getValueAt(rowid, 5).toString()));
            num.setText(model.getValueAt(rowid, 6).toString());
            email.setText(model.getValueAt(rowid, 7).toString());
            
            cnum = num.getText();
            mail= email.getText();
            
            if((model.getValueAt(rowid, 9).toString()).equals("Active")){
                status.setSelectedItem("Active");
            }else{
                status.setSelectedItem("Inactive");
            }
        } catch (ParseException ex) {
            Logger.getLogger(admin_customersEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void calculateAge() {
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(bdate.getDate());
        Calendar currentDate = Calendar.getInstance();

        int years = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int months = currentDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
        int days = currentDate.get(Calendar.DAY_OF_MONTH) - birthDate.get(Calendar.DAY_OF_MONTH);

        if (months < 0 || (months == 0 && days < 0)) {
            years--;
        }

        age.setText(""+years);
    }
    
    
    public static boolean isValidEmail(String email) {
        String regex = ".*@.*\\.com$";
        return email.matches(regex);
    }
    
    public static boolean isValidNumber(String str) {
        String regex = "\\d{11}";
        return str.matches(regex);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new enhance.RoundPanel_w();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bdate = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        num = new enhance.CustomTF();
        status = new javax.swing.JComboBox<>();
        error = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fname = new enhance.CustomTF();
        jPanel3 = new enhance.RoundPanel_lb();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new enhance.RoundBorder_g();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        email = new enhance.CustomTF();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        fname1 = new enhance.CustomTF();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lname = new enhance.CustomTF();
        age = new enhance.CustomTF();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel13 = new enhance.RoundBorder_g()
        ;
        remove = new javax.swing.JButton();
        browse = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(80, 114, 123));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(80, 114, 123));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(44, 88, 110));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Birthdate");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        bdate.setBackground(new java.awt.Color(255, 255, 255));
        bdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel2.add(bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Contact No.");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        num.setForeground(new java.awt.Color(0, 51, 51));
        num.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                numMouseReleased(evt);
            }
        });
        num.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                numPropertyChange(evt);
            }
        });
        jPanel2.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 40));

        status.setBackground(new java.awt.Color(44, 88, 110));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        status.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statusPropertyChange(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 40));

        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(153, 0, 0));
        error.setText(".");
        jPanel2.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 190, 20));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Age");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 20));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 40, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("First Name");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        fname.setForeground(new java.awt.Color(0, 51, 51));
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fnameMouseReleased(evt);
            }
        });
        fname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fnamePropertyChange(evt);
            }
        });
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Edit");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 130, 40));

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
        jLabel7.setText("Back");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 130, 40));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Email");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        email.setForeground(new java.awt.Color(0, 51, 51));
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                emailMouseReleased(evt);
            }
        });
        email.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                emailPropertyChange(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Name");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        fname1.setForeground(new java.awt.Color(0, 51, 51));
        fname1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fname1MouseReleased(evt);
            }
        });
        fname1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fname1PropertyChange(evt);
            }
        });
        jPanel2.add(fname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 40));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Last Name");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lname.setForeground(new java.awt.Color(0, 51, 51));
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lnameMouseReleased(evt);
            }
        });
        lname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lnamePropertyChange(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 40));

        age.setEditable(false);
        age.setForeground(new java.awt.Color(0, 51, 51));
        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ageMouseReleased(evt);
            }
        });
        age.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                agePropertyChange(evt);
            }
        });
        jPanel2.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 70, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Nirmala UI", 2, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Identification Photo");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 20));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 110, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        remove.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        remove.setText("Remove Image");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel13.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 120, 30));

        browse.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel13.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, 30));
        jPanel13.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 240));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 270, 300));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 560, 380);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edit Customer");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 170, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        bdate.getDateEditor().addPropertyChangeListener(e -> calculateAge());
    }//GEN-LAST:event_formWindowActivated

    private void numMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_numMouseReleased

    private void numPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_numPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_numPropertyChange

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void statusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusPropertyChange
        //        type_display.setText((String)type.getSelectedItem());
    }//GEN-LAST:event_statusPropertyChange

    private void fnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameMouseReleased

    private void fnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fnamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fnamePropertyChange

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        boolean proceed = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(fname.getText().isEmpty()|| lname.getText().isEmpty()|| dateFormat.format(bdate.getDate()).isEmpty() || num.getText().isEmpty()|| email.getText().isEmpty()){
            error.setText("*Please fill-out necessary information!");
        }else{
            if(checkData("*","customers","c_num",num.getText())){
                if(cnum.equals(num.getText())){
                    proceed = true;
                }else{
                    error.setText("*Contact Number already Taken!");
                }
            }else if(!isValidNumber(num.getText())){
                error.setText("*Invalid Contact Number!");
            }else if(checkData("*","customers","c_email",email.getText())){
                if(mail.equals(email.getText())){
                    proceed=true;
                }else{
                    error.setText("*Email already Taken!");
                }
            }else if(!isValidEmail(email.getText())){
                error.setText("*Invalid email!");
            }else if(img.getIcon()==null){
                error.setText("*Please insert an Image!");
            }else{
                proceed = true;
            }
        }
        
        if(proceed){
            TableQueries cus = new TableQueries();
            if(imp.destination.isEmpty()){
                    File existing = new File(imp.oldpath);
                    if(existing.exists()){
                        existing.delete();
                    }
                }else{
                    if(!(imp.oldpath.equals(imp.path))){
                        imp.imageUpdater(imp.oldpath,imp.path);
                    }
                }
            cus.updateCustomer(id,fname.getText(),lname.getText(), dateFormat.format(bdate.getDate()), Integer.parseInt(age.getText()), num.getText(), email.getText(), (String)status.getSelectedItem(), imp.destination);
            this.dispose();
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void emailMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_emailMouseReleased

    private void emailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_emailPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_emailPropertyChange

    private void fname1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fname1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1MouseReleased

    private void fname1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fname1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1PropertyChange

    private void lnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameMouseReleased

    private void lnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lnamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lnamePropertyChange

    private void ageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ageMouseReleased

    private void agePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_agePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_agePropertyChange

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        browse.setEnabled(true);
        img.setIcon(null);
        imp.destination = "";
        imp.path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                imp.selectedFile = fileChooser.getSelectedFile();
                imp.destination = "src/imported_img/" + imp.selectedFile.getName();
                imp.path  = imp.selectedFile.getAbsolutePath();

                if(imp.FileExistenceChecker(imp.path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    imp.destination = "";
                    imp.path="";
                }else{
                    img.setIcon(imp.ResizeImage(imp.path, null, img));
                    browse.setEnabled(false);
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_browseActionPerformed

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
            java.util.logging.Logger.getLogger(admin_customersEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_customersEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_customersEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_customersEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_customersEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private com.toedter.calendar.JDateChooser bdate;
    public javax.swing.JButton browse;
    private javax.swing.JTextField email;
    private javax.swing.JLabel error;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname1;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField num;
    public javax.swing.JButton remove;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
