/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DB.DatabaseConnection;
import Model.m_User;
import Model.M_Governorates;

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
public class C_Governorates implements Entity.MainData<Model.M_Governorates>{

    @Override
    public boolean add(M_Governorates item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(M_Governorates item) {
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
    public ArrayList<M_Governorates> getAllRows() {
           ArrayList<Model.M_Governorates>  items=new ArrayList<>();
        try {
        DatabaseConnection a = DatabaseConnection.getinstance("ahmad", "123456");
         Connection con = DatabaseConnection.getinstance().getConnection();
         CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_governorates()}");
            stmt.registerOutParameter(1, Types.OTHER);
         con.setAutoCommit(false);
         stmt.execute();
         con.commit();
         ResultSet res = (ResultSet) stmt.getObject(1);
         while (res.next()) {
             Model.M_Governorates dir = new M_Governorates();
             dir.setID(res.getInt("id"));
             dir.setName(res.getString("name"));
             items.add(dir);
         }
        } catch (SQLException ex) {
            Logger.getLogger(M_Governorates.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return items;
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
