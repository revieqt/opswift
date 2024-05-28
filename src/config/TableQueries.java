/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author w10
 */
public class TableQueries {
    dbConnector connect = new dbConnector();
    Session sess = Session.getInstance();
    public void addUser(String fname, String lname, String username, String type, String destination){
        int id = 0;
        if(connect.archiveCount("users")==0){
            id = 10001;
        }else{
            id = connect.lastId("u_id", "users");
        }
        
        String code = ""+lname.toLowerCase()+ id;
        try {
            int rowsInserted = 0;
            try {
                rowsInserted = connect.insertData("INSERT INTO users (u_id, u_code ,u_fname, u_lname, u_username,u_password,u_img, u_type, u_status) VALUES ('"+id+"','"+code+"','"+capitalize(fname)+"','"+capitalize(lname)+"','"+username+"','"+passwordHasher.hashPassword(code)+"','"+destination+"','"+type+"', 'Active')");
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
            }
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Staff Added Successfully!\nStaff ID: "+id+"\nStaff Code: "+code+"");
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") added "+fname+" "+lname+" ("+id+") as "+type+"");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Staff!");
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
    }
    
    public void updateUser(int id, String fname, String lname, String username,String type, String status, String destination){
        String code = ((lname.toLowerCase()) + id);
        String insertQuery = "UPDATE users SET u_code = '"+code+"', u_fname = '"+capitalize(fname)+"', u_lname = '"+capitalize(lname)+"', u_username = '"+username+"', u_img = '"+destination+"', u_type = '"+type+"', u_status = '"+status+"' WHERE u_id = '"+id+"'";
        connect.updateData(insertQuery);
        JOptionPane.showMessageDialog(null, "Staff Updated Successfully!\nStaff ID: "+id+"\nStaff Code: "+code+"");
        addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") updated "+fname+" "+lname+" ("+id+") information");
    }
    
    public void addProduct(String code, String name, int quantity, double price,String status){
        int id = 0;
        if(connect.archiveCount("products")==0){
            id = 20001;
        }else{
            id = connect.lastId("p_id", "products");
        }
        
        String insertQuery = "INSERT INTO products (p_id,p_barcode ,p_name, p_qty, p_price,p_status) VALUES ("+id+",'"+code+"','"+name+"','"+quantity+"','"+price+"','"+status+"')";
        try {
            int rowsInserted = connect.insertData(insertQuery);
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Product Added Successfully!\nProduct ID: "+id);
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") added product "+name+" ("+code+")");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Product!");
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
        
        
    }
    
    public void updateProduct(int id, String name, String code, int quantity, double price,String status){
        String insertQuery = "UPDATE products SET p_barcode = '"+code+"', p_name = '"+name+"', p_qty = '"+quantity+"', p_price = '"+price+"', p_status = '"+status+"' WHERE p_id = '"+id+"'";
        connect.updateData(insertQuery);
        addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") updated product '"+name+"' ("+code+") information");
    }
    
    public void addCustomer(String fname, String lname, String bdate, int age, String num, String email, String img){
        int id = 0;
        if(connect.archiveCount("customers")==0){
            id = 30001;
        }else{
            id = connect.lastId("c_id", "customers");
        }
        
        String code = ""+lname.toLowerCase()+ id;
        try {
            int rowsInserted = connect.insertData("INSERT INTO customers (c_id, c_code ,c_fname, c_lname, c_age,c_bdate, c_num,c_email, c_status, c_img) VALUES ('"+id+"','"+code+"','"+capitalize(fname)+"','"+capitalize(lname)+"','"+age+"','"+bdate+"','"+num+"','"+email+"', 'Active', '"+img+"')");
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Customer Added Successfully!\nCustomer ID: "+id+"\nCustomer Code: "+code+"");
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") added customer "+fname+" "+lname+" ("+id+")");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Customer!");
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
    }
    
    public void updateCustomer(int id, String fname, String lname, String bdate, int age, String num, String email, String status, String img){
        String code = ((lname.toLowerCase()) + id);
        String insertQuery = "UPDATE customers SET c_code = '"+code+"', c_fname = '"+capitalize(fname)+"', c_lname = '"+capitalize(lname)+"', c_bdate = '"+bdate+"', c_age = '"+age+"', c_num = '"+num+"', c_email = '"+email+"', c_status = '"+status+"' , c_img = '"+img+"' WHERE c_id = '"+id+"'";
        connect.updateData(insertQuery);
        JOptionPane.showMessageDialog(null, "Customer Updated Successfully!\nCustomer ID: "+id+"\nCustomer Code: "+code+"");
        addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") updated customer "+fname+" "+lname+" ("+id+") information");
    }
    
    public void addDiscount(String code,String name,double amount, String type, int redeem, String rt){
        int id = 0;
        if(connect.archiveCount("discounts")==0){
            id = 40001;
        }else{
            id = connect.lastId("d_id", "discounts");
        }
        
        String insertQuery = "INSERT INTO discounts (d_id, d_code, d_name, d_amount, d_type, d_redeemable, d_redeemabletype, d_status) VALUES ("+id+",'"+code+"','"+name+"','"+amount+"','"+type+"','"+redeem+"','"+rt+"','Active')";
        try {
            int rowsInserted = connect.insertData(insertQuery);
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Promotion Added Successfully!\nPromotion ID: "+id);
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") added discount "+name+" ("+code+")");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add Promotion!");
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
        
        
    }
    public void updateDiscount(int id, String code, String name, double amount, String type, int redeem, String rt, String status){
        String insertQuery = "UPDATE discounts SET d_code = '"+code+"', d_name = '"+name+"', d_amount = '"+amount+"', d_type = '"+type+"', d_redeemable = '"+redeem+"', d_redeemabletype = '"+rt+"', d_status = '"+status+"' WHERE d_id = '"+id+"'";
        connect.updateData(insertQuery);
        addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") updated '"+name+"' ("+code+") information");
    }
    
    public void archive(int archiveId, String table, TableModel model){
        String var;
        
        switch (table) {
            case "users":
                var = "u_";
                break;
            case "products":
                var = "p_";
                break;
            case "customers":
                var = "c_";
                break;
            case "discounts":
                var = "d_";
                break;
            default:
                var = "t_";
                break;
        }
        if(archiveId != -1){
            Object value = model.getValueAt(archiveId, 0);
            String id = value.toString();
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Archive ID "+id +"?");
            if(confirm == JOptionPane.YES_OPTION){
                String insertQuery = "UPDATE "+table+" SET "+var+"status = 'Archived' WHERE "+var+"id = '"+id+"'";
                connect.updateData(insertQuery);
                JOptionPane.showMessageDialog(null, id+" Archived Successfully");
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") archived "+id +" from "+table);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select an ID to Archive!");
        }
    }
    
    public void restore(int restoreId, String table, TableModel model){
        String tbl="";
        String var;
        String qr = "";
        switch (table) {
            case "Staff":
                tbl = "users";
                var = "u_";
                qr = "u_status = 'Active'";
                break;
            case "Products":
                tbl = "products";
                var = "p_";
                qr = "p_status = 'Available'";
                break;
            case "Customers":
                tbl = "customers";                
                var = "c_";
                qr = "c_status = 'Active'";
                break;
            case "Discounts":
                tbl = "discounts";
                var = "d_";
                qr = "d_status = 'Available'";
                break;
            default:
                var = "t_";
                break;
        }
        
        if(restoreId != -1){
            Object value = model.getValueAt(restoreId, 0);
            String id = value.toString();
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Restore ID "+id +"?");
            if(confirm == JOptionPane.YES_OPTION){
                String insertQuery = "UPDATE "+tbl+" SET "+qr+" WHERE "+var+"id = '"+id+"'";
                connect.updateData(insertQuery);
                JOptionPane.showMessageDialog(null, id+" Restored Successfully");
                addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") restored "+id+" from "+table);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select an ID to Restore!");
        }
    }
    
    public void addLogs(String action){
        String insertQuery = "INSERT INTO logs (l_staff, l_action) VALUES ("+sess.getId()+", '"+action+"')";
        try {
            int rowsInserted = connect.insertData(insertQuery);
        } catch (SQLException ex) {
            System.out.println("Error inserting data: " + ex.getMessage());
        }
    }
    
    public static String capitalize(String str){
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
//
//class Users{
//    public int id;
//    public Users(){
//        dbConnector connect = new dbConnector();
//        if(connect.idIsNull("users")){
//            this.id = 1000001;
//        }else{
//            this.id = connect.lastId("u_id", "users");
//        }
//    }
//    
//    public void add(String fname, String lname, String username,String type){
//        dbConnector connect = new dbConnector();
//        String code = ""+lname.toLowerCase()+ String.valueOf(id);
//        String insertQuery = "INSERT INTO users (u_id, u_code ,u_fname, u_lname, u_username, u_password, u_type, u_status) VALUES ('"+id+"','"+(lname.toLowerCase()+ id)+"','"+fname+"','"+lname+"','"+username+"','"+code+"','"+type+"', 'Active')";
//        try {
//            int rowsInserted = connect.insertData(insertQuery);
//            if (rowsInserted > 0) {
//                JOptionPane.showMessageDialog(null, "Staff Added Successfully!\nStaff ID: "+id+"\nStaff Code: "+code+"");
//            } else {
//                JOptionPane.showMessageDialog(null, "Failed to add Staff!");
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error inserting data: " + ex.getMessage());
//        }
//    }
//    
//    public void update(int id, String fname, String lname, String username,String type){
//        dbConnector connector = new dbConnector();
//        String insertQuery = "UPDATE users SET u_fname = '"+fname+"', u_lname = '"+lname+"', u_username = '"+username+"', u_type = '"+type+"' WHERE u_id = '"+id+"'";
//        connector.updateData(insertQuery);
//        JOptionPane.showMessageDialog(null, "Staff Updated Successfully!\nStaff ID: "+id+"\nStaff Code: "+((lname.toLowerCase()) + id)+"");
//    }
//    
//    public void archive(int archiveId, TableModel model){
//        try{
//            if(archiveId != -1){
//                Object value = model.getValueAt(archiveId, 0);
//                String id = value.toString();
//                int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Archive ID "+id +"?");
//                if(confirm == JOptionPane.YES_OPTION){
//                    dbConnector archive = new dbConnector();
//                    archive.archiveData(archiveId, "users", "usersarchive", "u_id");
//                }
//            }else{
//                JOptionPane.showMessageDialog(null, "Please select a staff!");
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//    }
//    
//    public void delete(int selectedId, TableModel model){
//        if(selectedId != -1){
//            Object value = model.getValueAt(selectedId, 0);
//            String id = value.toString();
//            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to Delete ID "+id +"?");
//            if(confirm == JOptionPane.YES_OPTION){
//                dbConnector connect = new dbConnector();
//                int u_id = Integer.parseInt(id);
//                connect.deleteData(u_id, "users", "u_id");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Please select a staff!");
//        }
//    }
//}
