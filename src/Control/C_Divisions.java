/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.M_Department;

import Model.M_Divisions;
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
public class C_Divisions implements Entity.MainData<Model.M_Divisions>{

    @Override
    public boolean add(M_Divisions item) {
           Connection con= DatabaseConnection.getinstance().getConnection();
        try {
        //    DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
         
            CallableStatement stmt = con.prepareCall("{?=call add_divisions(?,?,?,?)}");
            stmt.setString(5, item.getDescription());
            stmt.setInt( 4, item.getId_department());
            stmt.setInt( 3, item.getId_id_Directorates());
            stmt.setInt( 2, item.getId_Ministry());
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
                   Logger.getLogger(C_Divisions.class.getName()).log(Level.SEVERE, null, ex);
               }
            JOptionPane.showMessageDialog(null, "ex error in  C_Department go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(M_Divisions item) {
    Connection con= DatabaseConnection.getinstance().getConnection();
        try{
            //  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            
            CallableStatement stmt = con.prepareCall("{call update_work_place(?,?)}");
            stmt.setInt(1, item.getID());
            stmt.setString(2, item.getDescription());
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
        try {
            con.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(C_Divisions.class.getName()).log(Level.SEVERE, null, ex1);
        }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " +ex.getMessage());
            return false;
        }
    }
    
    
      
           public boolean  delete( M_Divisions item , String tablename){
                 Connection con= DatabaseConnection.getinstance().getConnection();
               try{
                 
            //  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
            CallableStatement stmt = con.prepareCall("{call delete_funiction(?,?)}");
            stmt.setInt(1, item.getID());
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
                         Logger.getLogger(C_Divisions.class.getName()).log(Level.SEVERE, null, ex1);
                     }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go delete in content " +ex.getMessage());
            return false;
        }
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
    public ArrayList<M_Divisions> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<M_Divisions> viewDepartment(int id , int id1 , int id2) throws SQLException {

        ArrayList<Model.M_Divisions> items = new ArrayList<>();
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {
         //   DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
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
            con.rollback();
            Logger.getLogger(M_Divisions.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return items;
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
