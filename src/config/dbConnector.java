/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author w10
 */
public class dbConnector {
    private Connection connect;
    
     public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/opswiftpos", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
     
     //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
        
        public int insertData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        int rowsAffected = stmt.executeUpdate(sql);
        return rowsAffected;
    }
        
        public int lastId(String column, String table){
        try{
            String sql = "SELECT MAX("+column+") AS last_id FROM "+table+"";
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int lastId = 0;
            if (rs.next()) {
                return lastId = rs.getInt("last_id")+1;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
        
        public void updateData(String sql){
            int result;
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                int rowsUpdated = pst.executeUpdate();
                if(!(rowsUpdated>0)){
                    System.out.println("Data Update Failed!");
                }
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
            }
        }

    public void deleteData(int id, String table, String var){
        Session sess = Session.getInstance();
        TableQueries qr = new TableQueries();
        try{
            PreparedStatement pst = connect.prepareStatement("DELETE FROM "+table+" WHERE "+var+" = ?");
            pst.setInt(1,id);
            int rowsDeleted=pst.executeUpdate();
            if(rowsDeleted >0){
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
                qr.addLogs(sess.getFname()+ " "+ sess.getLname()+ " ("+sess.getId()+") deleted "+id+" from "+table);
            }else{
                System.out.println("Deletion Failed");
            }
            pst.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deleted Unsuccessfully. \nThis data is currently associated with existing transactions.");
        }
    }
    
    
    public int archiveCount(String table) {
        int column = 0;
        String var;
        
        if(table.equals("users")){
            var = "u_";
        }else if(table.equals("products")){
            var = "p_";
        }else if(table.equals("customers")){
            var = "c_";
        }else if(table.equals("discounts")){
            var = "d_";
        }else if(table.equals("orders")){
            var = "o_";
        }else if(table.equals("suppliers")){
            var = "s_";
        }else{
            var = "t_";
        }
        
        try {
            String query = "SELECT COUNT(*) FROM " + table + " WHERE "+var+"status != 'Archived'";
            ResultSet rs = getData(query);
            if (rs.next()) {
                column = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return column;
    }
    
    public int transactionCount(boolean day){
        int column = 0;
        try {
            String query = "SELECT COUNT(*) FROM transactions";
            if(day){
                query = query + " WHERE DATE(t_datetime) = CURDATE()";
            }
            ResultSet rs = getData(query);
            if (rs.next()) {
                column = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return column;
    }
    
    public double salesCount(boolean day){
        double amount = 0;
        try {
            String query = "SELECT SUM(t_total) AS total_amount FROM transactions";
            if(day){
                query = query + " WHERE DATE(t_datetime) = CURDATE()";
            }
            ResultSet rs = getData(query);
            if (rs.next()) {
                amount = rs.getDouble("total_amount");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
        return amount;
    }
    
    public int columnCount(String table, String var){
        int num = 0;
        try {
            ResultSet rs = getData("SELECT COUNT(*) FROM "+table+"");
            if (rs.next()) {
                String check = rs.getString(var);
                if(check.equals("")){
                    num = 0;
                }else{
                    num = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }
    
    public int pendingCount(){
        int num = 0;
        try {
            ResultSet rs = getData("SELECT COUNT(*) FROM orders WHERE o_status = 'Pending'");
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }
    
    public int cancelledCount(){
        int num = 0;
        try {
            ResultSet rs = getData("SELECT COUNT(*) FROM orders WHERE o_status = 'Cancelled'");
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }
    
    public int recievedCount(){
        int num = 0;
        try {
            ResultSet rs = getData("SELECT COUNT(*) FROM orders WHERE o_status = 'Recieved'");
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }
    
    public int expectedCount(){
        int num = 0;
        try {
            String query = "SELECT COUNT(*) FROM orders WHERE o_recieveon = '" + LocalDate.now() + "'";
            ResultSet rs = getData(query);
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return num;
    }
}
