/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;

import Model.m_jops;
import Model.m_work_city;
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
public class c_jops implements Entity.MainData<m_jops> {

    @Override
    public boolean add(m_jops item) {
   Connection con= DatabaseConnection.getinstance().getConnection();
        try {
           // DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            
            CallableStatement stmt = con.prepareCall("{?=call add_jops_title(?)}");
            stmt.setString(2, item.getDescription());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
             int i=(int)stmt.getObject(1);
             if(i == -1){
              return false;
            }
            return true;
            
        } catch (Exception e) {
       try {
           con.rollback();
       } catch (SQLException ex) {
           Logger.getLogger(c_jops.class.getName()).log(Level.SEVERE, null, ex);
       }
            JOptionPane.showMessageDialog(null, "ex error in  c_jops go -> add " + e.getMessage());
            return false;
        }
    }
    
     public boolean add_jops_description(m_jops item) {
         Connection con= DatabaseConnection.getinstance().getConnection();
         try {
           // DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
           
            CallableStatement stmt = con.prepareCall("{?=call add_jops_description(?,?)}");
            
            stmt.setString(3, item.getDescription());
            stmt.setInt(2, item.getTitle());
            
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
             int i=(int)stmt.getObject(1);
             if(i == -1){
              return false;
            }
            return true;
            
        } catch (Exception e) {
             try {
                 con.rollback();
             } catch (SQLException ex) {
                 Logger.getLogger(c_jops.class.getName()).log(Level.SEVERE, null, ex);
             }
            JOptionPane.showMessageDialog(null, "ex error in  c_jops go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(m_jops item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ArrayList<m_jops> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
        public ArrayList<Model.m_jops> view_jops(){
       
        ArrayList<Model.m_jops>  items=new ArrayList<>();
         Connection con = DatabaseConnection.getinstance().getConnection();
        try {
      //  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
        
         CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_title_jops}");
            stmt.registerOutParameter(1, Types.OTHER);
           
         con.setAutoCommit(false);
         stmt.execute();
         con.commit();
         ResultSet res = (ResultSet) stmt.getObject(1);
         while (res.next()) {
             Model.m_jops dir = new m_jops();
             dir.setId(res.getInt("id"));
             dir.setDescription(res.getString("description"));
             dir.setTitle(res.getInt("title"));
             items.add(dir);
         }
        } catch (SQLException ex) {
            Logger.getLogger(c_work_city.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(c_jops.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
         
        return items;
    }
        
        
        public ArrayList<m_jops> view_jops_description(int id) {
        ArrayList<Model.m_jops> items = new ArrayList<>();
       Connection con = DatabaseConnection.getinstance().getConnection();
        try {
          //  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            
           
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_jops_description(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_jops dir = new m_jops();
                     dir.setId(res.getInt("id"));
             dir.setDescription(res.getString("description"));
             
             
             items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_jops.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(c_jops.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
}
