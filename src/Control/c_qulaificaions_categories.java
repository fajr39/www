/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;

import Model.m_qulaificaions_categories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author ahmad-soft
 */
public class c_qulaificaions_categories implements Entity.MainData<m_qulaificaions_categories>{

    @Override
    public boolean add(m_qulaificaions_categories item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(m_qulaificaions_categories item) {
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
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      public ArrayList<m_qulaificaions_categories> view_qulaificaions_categories() {

        ArrayList<Model.m_qulaificaions_categories> items = new ArrayList<>();
        try {
            DatabaseConnection a = DatabaseConnection.getinstance("postgres", "mak");
            Connection con = DatabaseConnection.getinstance().getConnection();
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_qulaificaions_categories()}");
            stmt.registerOutParameter(1, Types.OTHER);
            
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_qulaificaions_categories dir = new m_qulaificaions_categories();
                dir.setId(res.getInt("id"));
                dir.setName(res.getString("name"));
                dir.setDescription(res.getString("description"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_qulaificaions_categories.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }

    @Override
    public ArrayList<m_qulaificaions_categories> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
