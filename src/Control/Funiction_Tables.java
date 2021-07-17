/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;

import Model.Model_Tables;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmad-soft
 */
public class Funiction_Tables implements Entity.MainData<Model.Model_Tables> {

    @Override
    public boolean add(Model_Tables item) {
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            
            CallableStatement stmt = con.prepareCall("{?=call insert_funiction(?, ?)}");
            stmt.setString(2, item.getColumn_Name());
            stmt.setString(3, item.getTables_Name());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
            int i = (Integer) stmt.getObject(1);
            if (i == -1) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Funiction_Tables.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "error in Funiction_Tables go => add" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Model_Tables item) {
       Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
           
            CallableStatement stmt = con.prepareCall("{?=call update_funiction(?,?,?)}");
            stmt.setInt(2, item.getColumn_Id());
            stmt.setString(3, item.getColumn_Name());
            stmt.setString(4, item.getTables_Name());
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
        } catch (Exception ex) {
           try {
               con.rollback();
           } catch (SQLException ex1) {
               Logger.getLogger(Funiction_Tables.class.getName()).log(Level.SEVERE, null, ex1);
           }
            JOptionPane.showMessageDialog(null, "error in Funiction_Tables In => update" + ex.getMessage());
            return false;
        }
    }

    public boolean Delete(Model.Model_Tables item) {
         Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
           
            CallableStatement stmt = con.prepareCall("{?=call delete_funiction(?,?)}");
            stmt.setInt(2, item.getColumn_Id());
            stmt.setString(3, item.getTables_Name());
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
        } catch (Exception ex) {
             try {
                 con.rollback();
             } catch (SQLException ex1) {
                 Logger.getLogger(Funiction_Tables.class.getName()).log(Level.SEVERE, null, ex1);
             }
            JOptionPane.showMessageDialog(null, "error in Funiction_Tables In => delete" + ex.getMessage());
            return false;
        }

    }

    public ArrayList<Model_Tables> filltable(String tablename) {
        ArrayList<Model.Model_Tables> fill = new ArrayList<Model_Tables>();
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {

            CallableStatement stmt = con.prepareCall("{?=call view_funiction(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.Model_Tables dir = new Model_Tables();
                dir.setColumn_Id(res.getInt("id"));
                dir.setColumn_Name(res.getString("name"));
                fill.add(dir);
            }
            con.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in go ->   fill() " + ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
               Logger.getLogger(Funiction_Tables.class.getName()).log(Level.SEVERE, null, ex1);
           }
     }
        return fill;

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Object getRow(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model_Tables> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
