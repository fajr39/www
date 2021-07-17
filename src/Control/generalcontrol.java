/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;

import Model.general_Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ahmad-soft
 */
public class generalcontrol implements Entity.MainData<Model.general_Model>{

    @Override
    public boolean add(general_Model item) {
       Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            
            CallableStatement stmt = con.prepareCall("{?=call insert_funiction2vlaue(?,?,?,?,?)}");
            stmt.setString(6, item.getValue2());
            stmt.setString(5, item.getValue1());
            stmt.setString(4, item.getName_column2());
            stmt.setString(3, item.getName_column1());
            stmt.setString(2, item.getTalbe_name());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
            int i = (int) stmt.getObject(1);
            if (i == -1) {
                return false;
            }
            return true;

        } catch (Exception e) {
           try {
               con.rollback();
           } catch (SQLException ex) {
               Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex);
           }
            JOptionPane.showMessageDialog(null, "ex error in  generalcontrol go -> add " + e.getMessage());
            return false;
        }
    }
    public boolean add3(general_Model item) {
           Connection con = DatabaseConnection.getinstance().getConnection(); 
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
        
            CallableStatement stmt = con.prepareCall("{?=call insert_funiction3vlaue(?,?,?,?,?,?,?)}");
            stmt.setString(8, item.getValue3());
            stmt.setString(7, item.getValue2());
            stmt.setString(6, item.getValue1());
            stmt.setString(5, item.getName_column3());
            stmt.setString(4, item.getName_column2());
            stmt.setString(3, item.getName_column1());
            stmt.setString(2, item.getTalbe_name());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
            int i = (int) stmt.getObject(1);
            if (i == -1) {
                return false;
            }
            return true;

        } catch (Exception e) {
               try {
                   con.rollback();
               } catch (SQLException ex) {
                   Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex);
               }
            JOptionPane.showMessageDialog(null, "ex error in  generalcontrol go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(general_Model item) {
            Connection con= DatabaseConnection.getinstance().getConnection();
        try{
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
      
            CallableStatement stmt = con.prepareCall("{call update_funiction2value(?,?,?,?,?,?)}");
            stmt.setString(6, item.getValue2());
            stmt.setString(5, item.getValue1());
            stmt.setString(4, item.getName_column2());
            stmt.setString(3, item.getName_column1());
            stmt.setString(2, item.getTalbe_name());
            stmt.setString(1, item.getId()+"");
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex1);
                }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " +ex.getMessage());
            return false;
        }
    }
 //   String sql = "{?=call  create_user(?,?,?,CAST(? AS userkind),?,?,?,?)}";
     public boolean update1(general_Model item) {
             Connection con= DatabaseConnection.getinstance().getConnection();
         try{
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
      
            CallableStatement stmt = con.prepareCall("{call update_funiction3value(?,?,?,?,?,?,?,?)}");
             stmt.setString(8, item.getValue3().toString());
            stmt.setString(7, item.getValue2());
            stmt.setString(6, item.getValue1());
            stmt.setString(5, item.getName_column3());
            stmt.setString(4, item.getName_column2());
            stmt.setString(3, item.getName_column1());
            stmt.setString(2, item.getTalbe_name());
            stmt.setString(1, item.getId()+"");
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
                 try {
                     con.rollback();
                 } catch (SQLException ex1) {
                     Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex1);
                 }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update1 in content " +ex.getMessage());
            return false;
        }
    }
     
     
       public boolean update2(general_Model item) {
      Connection con= DatabaseConnection.getinstance().getConnection();
           try{
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
           
            CallableStatement stmt = con.prepareCall("{call update_funiction(?,?,?,?)}");
            stmt.setString(4, item.getValue1());
            stmt.setString(3, item.getName_column1());
            stmt.setString(2, item.getTalbe_name());
            stmt.setInt(1, item.getId());
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
          try {
              con.rollback();
          } catch (SQLException ex1) {
              Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex1);
          }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update3 in content " +ex.getMessage());
            return false;
        }
    }
     
       public boolean  delete(general_Model item , String tablename){
                Connection con= DatabaseConnection.getinstance().getConnection();
           try{
                 
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
          
            CallableStatement stmt = con.prepareCall("{call delete_funiction(?,?)}");
            stmt.setInt(1, item.getId());
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
                    try {
                        con.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex1);
                    }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go delete in content " +ex.getMessage());
            return false;
        }
    }
       
       
       public ArrayList<general_Model> filltable(String tablename , String column1 , String column2, String column3) {
        ArrayList<Model.general_Model> fill = new ArrayList<general_Model>();
                Connection con = DatabaseConnection.getinstance().getConnection();
        try {

//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
   
            CallableStatement stmt = con.prepareCall("{?=call view_funiction(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.general_Model dir = new general_Model();
                dir.setId(res.getInt("id"));
                dir.setName_column1(res.getString(column1));
                dir.setName_column2(res.getString(column2));
                dir.setName_column3(res.getString(column3));
                fill.add(dir);
            }
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(generalcontrol.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "Error in go ->   fill() " + ex.getMessage());

        }
        return fill;

    }


    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getRow(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<general_Model> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
     
    
  
    
}
