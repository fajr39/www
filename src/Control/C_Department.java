/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;
import Model.M_Department;
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
public class C_Department implements Entity.MainData<M_Department> {

    @Override
    public boolean add(M_Department item) {
       // DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {

            CallableStatement stmt = con.prepareCall("{?=call add_department(?,?,?)}");
            stmt.setString(4, item.getDescription());
            stmt.setInt(3, item.getId_id_Directorates());
            stmt.setInt(2, item.getId_Ministry());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();

            ResultSet rs;
            int i = (int) stmt.getObject(1);
            con.commit();
            if (i == -1) {
                return false;
            }
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ex error in  C_Department go -> add " + e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(C_Department.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    @Override
    public boolean update(M_Department item) {
         /// DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
         
            CallableStatement stmt = con.prepareCall("{call update_work_place(?,?)}");
            stmt.setInt(1, item.getID());
            stmt.setString(2, item.getDescription());
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update in content " + ex.getMessage());
              try {
                  con.rollback();
              } catch (SQLException ex1) {
                  Logger.getLogger(C_Department.class.getName()).log(Level.SEVERE, null, ex1);
              }
            return false;
        }
    }

    public boolean delete(M_Department item, String tablename) {
    //    DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {

            CallableStatement stmt = con.prepareCall("{call delete_funiction(?,?)}");
            stmt.setInt(1, item.getID());
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erorr in go -> go delete in content " + ex.getMessage());

            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(C_Department.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
    public ArrayList<M_Department> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<M_Department> viewDepartment(int id, int id1) {
//  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con = DatabaseConnection.getinstance().getConnection();
        ArrayList<Model.M_Department> items = new ArrayList<>();
        try {
          
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_department(?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id);
            stmt.setInt(3, id1);
            con.setAutoCommit(false);
            stmt.execute();
          
            ResultSet res = (ResultSet) stmt.getObject(1);
  con.commit();
            while (res.next()) {

                Model.M_Department dir = new M_Department();
                dir.setID(res.getInt("id"));
                dir.setDescription(res.getString("description"));
                dir.setId_department(res.getInt("department"));
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(M_Department.class.getName()).log(Level.SEVERE, null, ex);
      try {
          con.rollback();
      } catch (SQLException ex1) {
          Logger.getLogger(C_Department.class.getName()).log(Level.SEVERE, null, ex1);
      }
        }

        return items;
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
