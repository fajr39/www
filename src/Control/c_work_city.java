/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.M_Department;
import Model.M_Directorates;
import Model.M_Divisions;
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
public class c_work_city implements Entity.MainData<m_work_city>{

    @Override
    public boolean add(m_work_city item) {
          try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call add_governorate_work_city(?)}");
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
            JOptionPane.showMessageDialog(null, "ex error in  c_work_city go -> add " + e.getMessage());
            return false;
        }
    }
    
       public boolean add_district_work_city(m_work_city item) {
          try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call add_district_work_city(?,?)}");
            
            stmt.setString(3, item.getDescription());
            stmt.setInt(2, item.getId_governorate());
            
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
            JOptionPane.showMessageDialog(null, "ex error in  c_work_city go -> add " + e.getMessage());
            return false;
        }
    }
       
           public boolean add_sub_district_work_city(m_work_city item) {
            try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call add_sub_district_work_city(?,?,?)}");
            stmt.setString(4, item.getDescription());
            stmt.setInt( 3, item.getId_district());
            stmt.setInt( 2, item.getId_governorate());
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
            JOptionPane.showMessageDialog(null, "ex error in  c_work_city go -> add " + e.getMessage());
            return false;
        }
    }
               
           public boolean add_community_work_city(m_work_city item) {
            try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call add_community_work_city(?,?,?,?)}");
            stmt.setString(5, item.getDescription());
            stmt.setInt(4, item.getId_sub_district());
            stmt.setInt( 3, item.getId_district());
            stmt.setInt( 2, item.getId_governorate());
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
            JOptionPane.showMessageDialog(null, "ex error in  c_work_city go -> add " + e.getMessage());
            return false;
        }
    }
   
       
    

    @Override
    public boolean update(m_work_city item) {
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
    public ArrayList<m_work_city> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        public ArrayList<Model.m_work_city> view_governorate_work_city(){
       
        ArrayList<Model.m_work_city>  items=new ArrayList<>();
        try {
//        DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
         Connection con = DatabaseConnection.getinstance().getConnection();
         CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_governorate_work_city}");
            stmt.registerOutParameter(1, Types.OTHER);
           
         con.setAutoCommit(false);
         stmt.execute();
         con.commit();
         ResultSet res = (ResultSet) stmt.getObject(1);
         while (res.next()) {
             Model.m_work_city dir = new m_work_city();
             dir.setId(res.getInt("id"));
             dir.setDescription(res.getString("description"));
             dir.setId_governorate(res.getInt("governorate"));
             items.add(dir);
         }
        } catch (SQLException ex) {
            Logger.getLogger(c_work_city.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return items;
    }
        
          public ArrayList<m_work_city> view_district_work_city(int id) {
        ArrayList<Model.m_work_city> items = new ArrayList<>();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con = DatabaseConnection.getinstance().getConnection();
           
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_district_work_city(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_work_city dir = new m_work_city();
                     dir.setId(res.getInt("id"));
             dir.setDescription(res.getString("description"));
             dir.setId_district(res.getInt("district"));
             
             items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_work_city.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }
             
         public ArrayList<m_work_city> view_sub_district_work_city(int id , int id1) {

        ArrayList<Model.m_work_city> items = new ArrayList<>();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_sub_district_work_city(?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
             
            stmt.setInt(2, id);
             stmt.setInt(3, id1);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            
            while (res.next()) {
                
                Model.m_work_city dir = new m_work_city();
                dir.setId(res.getInt("id"));
                dir.setDescription(res.getString("description"));
                dir.setId_sub_district(res.getInt("sub_district"));
               
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_work_city.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return items;
    }
         
          public ArrayList<m_work_city> viewcommunity_work_city(int id , int id1 , int id2) {

        ArrayList<Model.m_work_city> items = new ArrayList<>();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call viewcommunity_work_city(?,?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
             
            stmt.setInt(2, id);
             stmt.setInt(3, id1);
             stmt.setInt(4, id2);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            
            while (res.next()) {
                
                Model.m_work_city dir = new m_work_city();
                dir.setId(res.getInt("id"));
                dir.setDescription(res.getString("description"));
//                dir.setId_divisions(res.getInt("divisions"));
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_work_city.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return items;
    }
     public ArrayList<M_Divisions> viewDepartment(int id , int id1 , int id2) {

        ArrayList<Model.M_Divisions> items = new ArrayList<>();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_divisions(?,?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
             
            stmt.setInt(2, id);
             stmt.setInt(3, id1);
             stmt.setInt(4, id2);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            
            while (res.next()) {
                
                Model.M_Divisions dir = new M_Divisions();
                dir.setID(res.getInt("id"));
                dir.setDescription(res.getString("description"));
                dir.setId_divisions(res.getInt("divisions"));
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_work_city.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return items;
    }
}
