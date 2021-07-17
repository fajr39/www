/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;

import Model.m_district;
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
public class c_district  implements Entity.MainData<m_district>{

    @Override
    public boolean add(m_district item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(m_district item) {
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
    public ArrayList<m_district> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public ArrayList<m_district> view_district(int id) {
        ArrayList<Model.m_district> items = new ArrayList<>();
       //  DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
           Connection con = DatabaseConnection.getinstance().getConnection();
        try {
           
          
           
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_district(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, id);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_district dir = new m_district();
                dir.setId(res.getInt("id"));
                dir.setName(res.getString("name"));
                
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_district.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(c_district.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
}
