/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.M_Ministry;
import Model.M_Qualification_Name;

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
public class C_Qualification_Name implements  Entity.MainData<Model.M_Qualification_Name>{
    
  

   
    

    @Override
    public boolean add(M_Qualification_Name item) {
              Connection con= DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
            CallableStatement stmt = con.prepareCall("{?=call add_name_qualification(?)}");
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
                      Logger.getLogger(C_Qualification_Name.class.getName()).log(Level.SEVERE, null, ex);
                  }
            JOptionPane.showMessageDialog(null, "ex error in  M_Qualification_Name go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(M_Qualification_Name item ) {
       Connection con= DatabaseConnection.getinstance().getConnection();
        try{
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
            CallableStatement stmt = con.prepareCall("{call update_funiction(?,?,?,?)}");
            
            stmt.setString(4, item.getDescription());
            stmt.setString(3, item.getColumn_name());
            stmt.setString(2, item.getTable_name());
            stmt.setInt(1, item.getId());
            
           // stmt.setString(2, item.getDescription());
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        }
        catch(Exception ex){
           try {
               con.rollback();
           } catch (SQLException ex1) {
               Logger.getLogger(C_Qualification_Name.class.getName()).log(Level.SEVERE, null, ex1);
           }
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " +ex.getMessage());
            return false;
        }
    }
    
       public boolean  delete(M_Qualification_Name item , String tablename){
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
                        Logger.getLogger(C_Qualification_Name.class.getName()).log(Level.SEVERE, null, ex1);
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
    public ArrayList<M_Qualification_Name> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<M_Qualification_Name> view_Qualification_Name() {

        ArrayList<Model.M_Qualification_Name> items = new ArrayList<>();
       Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
           
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_name_of_qualification()}");
            stmt.registerOutParameter(1, Types.OTHER);
            
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.M_Qualification_Name dir = new M_Qualification_Name();
                dir.setId(res.getInt("id"));
                dir.setId_Name(res.getInt("name"));
                dir.setDescription(res.getString("description"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(C_Qualification_Name.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(M_Qualification_Name.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }
    
}
