/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.M_Qualification_Division;
import Model.M_Qualification_Type;

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
public class C_Qualification_Division implements Entity.MainData<Model.M_Qualification_Division>{

    @Override
    public boolean add(M_Qualification_Division item) {   
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call add_divisions_qualification(?,?,?)}");
           
            stmt.setString(4, item.getDescription());
            stmt.setInt(3, item.getId_type());
             stmt.setInt(2, item.getId_Name());
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
            JOptionPane.showMessageDialog(null, "ex error in  C_Qualification_Division go -> add " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(M_Qualification_Division item) {      try{
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con= DatabaseConnection.getinstance().getConnection();
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
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " +ex.getMessage());
            return false;
        }
    }
    
   public boolean  delete(M_Qualification_Division item , String tablename){
                 try{
                 
//              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con= DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{call delete_funiction(?,?)}");
            stmt.setInt(1, item.getId());
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
    public ArrayList<M_Qualification_Division> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<Model.M_Qualification_Division> view_Qualification_Division(int id_name, int id_type) {

        ArrayList<Model.M_Qualification_Division> items = new ArrayList<>();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_divisions_of_qualification(?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id_name);
            stmt.setInt(3, id_type);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.M_Qualification_Division dir = new M_Qualification_Division();
                dir.setId(res.getInt("id"));
//                dir.setId_Division(res.getInt("divsion"));
                dir.setDescription(res.getString("description"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(M_Qualification_Division.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }
    

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
