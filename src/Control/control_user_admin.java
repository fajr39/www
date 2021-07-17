/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;
import Model.Model_Tables;
import Model.m_User;
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
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author ahmad-soft
 */
public class control_user_admin implements Entity.MainData<m_User> {

    @Override
    public boolean add(m_User item) {
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try { 
            CallableStatement stmt = con.prepareCall("{?=call add_user(?,?,?,?,?,?)}");
            stmt.setString(2, item.getFirst_name());
            stmt.setString(3, item.getMiddle_name());
            stmt.setString(4, item.getLast_name());
            stmt.setString(5, item.getUser_name());
            stmt.setInt(6, item.getId_user_type());
            stmt.setString(7, item.getPassword());
            stmt.registerOutParameter(1, Types.BOOLEAN);
            con.setAutoCommit(false);
            stmt.execute();
            
            boolean i = (boolean) stmt.getObject(1);
            con.commit();
            if (i) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erorr in control_user_admin go =>  add" + e.getMessage());
           try {
               con.rollback();
           } catch (SQLException ex) {
               Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex);
           }
            return false;
        }
    }

    public boolean add_admin(m_User item){
//          DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
         
            CallableStatement stmt = con.prepareCall("{?=call add_admin(?,?,?,?,?)}");
            stmt.setString(2, item.getFirst_name());
            stmt.setString(3, item.getMiddle_name());
            stmt.setString(4, item.getLast_name());
            stmt.setString(5, item.getUser_name());
            stmt.setString(6, item.getPassword());
            stmt.registerOutParameter(1, Types.BOOLEAN);
            con.setAutoCommit(false);
            stmt.execute();
            
            boolean i = (boolean) stmt.getObject(1);
            con.commit();
            if (i) {
                return true;
            } else {
                return false;
            }
            

        } catch (SQLException e) {
           //   JOptionPane.showMessageDialog(null, e.getMessage());
            new rojerusan.RSNotifyAnimated("معلومات", "1- يجب أن تكون 8 محارف  \n2- يجب ان تحوي أحرف كبيرة \n3- يجب ان تحوي أحرف صغيرة \n4- يجب ان تحوي أرقام \n5- يجب ان تحوي على رموز", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
              try {
                  con.rollback();
              } catch (SQLException ex) {
                  Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex);
              }
//               
////               System.out.println("error" +e.getMessage());
           
            return false;
        }
    }
    
      public boolean add_permisions(m_User item) {
//           DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con= DatabaseConnection.getinstance().getConnection();
      try {
          
            CallableStatement stmt = con.prepareCall("{?=call add_permision(?,?)}");
            stmt.setInt(3, item.getID());
            stmt.setInt( 2, item.getId_work_place());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
           
            ResultSet rs;
             int i=(int)stmt.getObject(1);
              con.commit();
             if(i == -1){
              return false;
            }
            return true;
            
        } catch (Exception e) {
            new rojerusan.RSNotifyAnimated("معلومات", "يوجد قيم ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
               try {
                   con.rollback();
               } catch (SQLException ex) {
                   Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex);
               }
            return false;
        }
    }
        public boolean add_permisions_admins(m_User item) {
//           DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con= DatabaseConnection.getinstance().getConnection();
      try {
          
            CallableStatement stmt = con.prepareCall("{?=call add_permision_admins(?,?)}");
            stmt.setInt(3, item.getID());
            stmt.setInt( 2, item.getId_work_place());
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
           
            ResultSet rs;
             int i=(int)stmt.getObject(1);
              con.commit();
             if(i == -1){
              return false;
            }
            return true;
            
        } catch (Exception e) {
            new rojerusan.RSNotifyAnimated("معلومات", "يوجد قيم ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
               try {
                   con.rollback();
               } catch (SQLException ex) {
                   Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex);
               }
            return false;
        }
    }

    @Override
    public boolean update(m_User item) {
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
    public ArrayList<m_User> getAllRows() {

        return null;

    } 
    
        public String get_info_type(String user_type) {
        Connection con = DatabaseConnection.getinstance().getConnection();
            try {

            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call get_info(?)}");
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.setString(2, user_type);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            String res = (String) stmt.getObject(1);
            return res;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "go in control => get_info_type" + ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return null;
    }
    public ArrayList<m_User> view_user_type() {
        ArrayList<Model.m_User> items = new ArrayList<>();
       //DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_user_type()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();  
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_User dir = new m_User();
                dir.setID(res.getInt("id"));
                dir.setName(res.getString("name"));
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
     
    public static m_User view_info_user() {
            Model.m_User user = new Model.m_User();
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call get_user_info()}");
            stmt.registerOutParameter(1, Types.OTHER);
           
            con.setAutoCommit(false);
            stmt.execute();
            
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                 
                user.setFirst_name(res.getString("first_name"));
                user.setMiddle_name(res.getString("middle_name"));
                user.setLast_name(res.getString("last_name"));
                user.setPassword(res.getString("password"));
                user.setUser_name(res.getString("user_name"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }

        return user;
    }
//     public static m_User view_info_admin() {
//            Model.m_User user = new Model.m_User();
//            Connection con = DatabaseConnection.getinstance().getConnection();
//        try {
//            
//            CallableStatement stmt;
//            stmt = con.prepareCall("{?=call get_admin_info()}");
//            stmt.registerOutParameter(1, Types.OTHER);
//            
//            con.setAutoCommit(false);
//            stmt.execute();
//            
//            ResultSet res = (ResultSet) stmt.getObject(1);
//            con.commit();
//            while (res.next()) {
//                 
//                user.setFirst_name(res.getString("first_name"));
//                user.setMiddle_name(res.getString("middle_name"));
//                user.setLast_name(res.getString("last_name"));
//                user.setIs_super(res.getBoolean("id_super_admin"));
//                user.setPassword(res.getString("password"));
//                user.setUser_name(res.getString("user_name"));
//               
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
//            try {
//                con.rollback();
//            } catch (SQLException ex1) {
//                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            
//        }
//
//        return user;
//    }
     
     
      public static m_User view_super_admin() {
            Model.m_User user = new Model.m_User();
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call get_super_admin_info(?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            if(user.getUser_name() == null){
                stmt.setNull(2, Types.NULL);
            }else{
                stmt.setString(2, user.getUser_name());
            }
            con.setAutoCommit(false);
            stmt.execute();
            
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                 
                user.setFirst_name(res.getString("first_name"));
                user.setMiddle_name(res.getString("middle_name"));
                user.setLast_name(res.getString("last_name"));
                user.setPassword(res.getString("password"));
                user.setUser_name(res.getString("user_name"));
                
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }

        return user;
    }
     
     public ArrayList<Model_Tables> view_work_place_admis() {
        ArrayList<Model.Model_Tables> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_work_place_admis()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                items.add(new Model_Tables(res.getInt("id"),res.getString("description"),"sdfsfs"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return items;
        
     }
     public ArrayList<m_User> view_users() {
        ArrayList<Model.m_User> items = new ArrayList<>();
     //  DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_users()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_User dir = new m_User();
                dir.setID(res.getInt("id"));
                  dir.setFirst_name(res.getString("first_name"));
                  dir.setMiddle_name(res.getString("middle_name"));
                  dir.setLast_name(res.getString("last_name"));
                dir.setUser_name(res.getString("user_name"));
                dir.setUser_type(res.getString("name"));
                dir.setState(res.getBoolean("state"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
     
     
      public ArrayList<m_User> view_admins() {
        ArrayList<Model.m_User> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_admins()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_User dir = new m_User();
                dir.setID(res.getInt("id"));
                  dir.setFirst_name(res.getString("first_name"));
                  dir.setMiddle_name(res.getString("middle_name"));
                  dir.setLast_name(res.getString("last_name"));
                dir.setUser_name(res.getString("user_name"));
                 dir.setState(res.getBoolean("state"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
     
            public boolean  delete_user( m_User item){
                 Connection con= DatabaseConnection.getinstance().getConnection();
                try{
//                 
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
         
            CallableStatement stmt = con.prepareCall("{?=call del_user(?)}");
            stmt.setInt(2, item.getID());
           stmt.registerOutParameter(1, Types.BOOLEAN);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
             boolean res = (boolean) stmt.getObject(1);
             if(res == true){
                return true; 
             }else{
                 return false;
             }
             
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, " Erorr in go -> go delete in content " +ex.getMessage());
            
                     try {
                         con.rollback();
                     } catch (SQLException ex1) {
                         Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
                     }
            return false;
        }
    }
             public boolean  delete_admin( m_User item){
                 Connection con= DatabaseConnection.getinstance().getConnection();
                try{
//                 
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
         
            CallableStatement stmt = con.prepareCall("{?=call del_admin(?)}");
            stmt.setInt(2, item.getID());
           stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
             Integer res = (Integer) stmt.getObject(1);
             if(res ==-1){
                return true; 
             }else{
                 return false;
             }
             
             
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, " Erorr in go -> go delete in content " +ex.getMessage());
            
                     try {
                         con.rollback();
                     } catch (SQLException ex1) {
                         Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
                     }
            return false;
        }
    }
      public ArrayList<m_User> view_permisiones() {
        ArrayList<Model.m_User> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_permisions()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_User dir = new m_User();
                dir.setID(res.getInt("id"));
                dir.setFirst_name(res.getString("first_name"));
                dir.setMiddle_name(res.getString("middle_name"));
                dir.setLast_name(res.getString("last_name"));
                dir.setName(res.getString("description"));
              
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
     
        public ArrayList<m_User> view_permisiones_admins() {
        ArrayList<Model.m_User> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
            Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_admin_permisions()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_User dir = new m_User();
                dir.setID(res.getInt("id"));
                dir.setFirst_name(res.getString("first_name"));
                dir.setMiddle_name(res.getString("middle_name"));
                dir.setLast_name(res.getString("last_name"));
                dir.setName(res.getString("description"));
                
                items.add(dir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(m_User.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(control_user_admin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return items;
    }
    

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
