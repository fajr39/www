/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;
import Model.m_families_members;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class c_families_members implements Entity.MainData<Model.m_families_members>{

    @Override
    public boolean add(m_families_members item) {
         Connection con= DatabaseConnection.getinstance().getConnection();
        try {
//            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            
            CallableStatement stmt = con.prepareCall("{?=call add_family_member(?,?,?,?,?,?::type_relation_enum,?,?)}");

            stmt.setInt(2, item.getId_employee_p());
             stmt.setBoolean(3, item.isIs_exist_p());
            stmt.setString(4, item.getMember_name_p());
            stmt.setBoolean(5, item.isIs_employee_p());
             java.sql.Date date = new Date(item.getBrith_date_p().getTime());
            stmt.setDate(6, date);
             stmt.setString(7, item.getType_relation_p());
             stmt.setBoolean(8, item.isStudy_p());
            stmt.setInt(9, item.getId_social_status_p());
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
                 JOptionPane.showMessageDialog(null, "ex error in c_families_members  go -> add " + e.getMessage());
                 
                 con.rollback();
             } catch (SQLException ex) {
                 Logger.getLogger(c_families_members.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return false;
    }

    @Override
    public boolean update(m_families_members item) {
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
    public ArrayList<m_families_members> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
