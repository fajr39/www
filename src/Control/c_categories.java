/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;
import Model.M_Department;
import Model.Model_Tables;
import Model.m_categories;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ahmad-soft
 */
public class c_categories implements Entity.MainData<m_categories> {

    @Override
    public boolean add(m_categories item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, 
    }

    public boolean add_new(m_categories item) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(m_categories item) {
           try{
              DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con= DatabaseConnection.getinstance().getConnection();
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
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update1 in content " +ex.getMessage());
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
    public ArrayList<m_categories> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList<m_categories> filltable(String tablename) {
        ArrayList<Model.m_categories> fill = new ArrayList<m_categories>();
        try {

            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt = con.prepareCall("{?=call view_funiction(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setString(2, tablename);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_categories dir = new m_categories();
                dir.setId(res.getInt("id"));
                dir.setName_column1(res.getString("name"));
                dir.setName_column2(res.getString("salary"));
                dir.setName_column3(res.getString("currency::enum_currency"));
                fill.add(dir);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in go ->   fill() " + ex.getMessage());

        }
        return fill;

    }

   

}
