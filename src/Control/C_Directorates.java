/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.M_Directorates;
import Model.M_Ministry;

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
    public class C_Directorates implements Entity.MainData<Model.M_Directorates> {

    @Override
    public boolean add(M_Directorates item) {
    Connection con= DatabaseConnection.getinstance().getConnection();
        try {
       //     DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            
            CallableStatement stmt = con.prepareCall("{?=call add_directoraty(?,?)}");
            stmt.setString(3, item.getDescription());
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
            Logger.getLogger(C_Directorates.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "ex error in  C_Ministry go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(M_Directorates item) {
     Connection con= DatabaseConnection.getinstance().getConnection();
        try{
           //   DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
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
             Logger.getLogger(C_Directorates.class.getName()).log(Level.SEVERE, null, ex1);
         }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " +ex.getMessage());
            return false;
        }
    }
    
        public boolean  delete(M_Directorates item , String tablename){
                 try{
                 
              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{call delete_funiction(?,?)}");
            stmt.setInt(1, item.getID());
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
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
    public ArrayList<M_Directorates> getAllRows() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<M_Directorates> viewDirectorate(int id) {
        ArrayList<Model.M_Directorates> items = new ArrayList<>();
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            
           
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_directorates(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.M_Directorates dir = new M_Directorates();
                dir.setID(res.getInt("id"));
                dir.setDescription(res.getString("description"));
                dir.setId_Directorates(res.getInt("directorates"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(M_Directorates.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(C_Directorates.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
