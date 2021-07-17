/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.MessageType;
import View.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.CallableStatement;
import rojerusan.RSNotifyAnimated;
import javax.swing.JDialog;


/**
 *
 * @author ahmad-soft
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private static Connection conn;
    private  String pass;
    private  String user;
    

    private DatabaseConnection(String user , String pass) throws Exception {
//Hr  localhost
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/aboakifdatabase", user, pass);
        //   new rojerusan.RSNotifyAnimated("معلومات", "تم تسجيل الدخول بنجاح" , 4, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);

        } catch (SQLException ex) {
            
            
             View.Message meg = new Message(new javax.swing.JFrame(), true, "خطا في اسم المستخدم أو كلمة المرور أو فشل الاتصال", MessageType.ERROR,20);meg.setVisible(true);
     // JOptionPane.showMessageDialog(null, ex.getMessage());
   //      JOptionPane.showMessageDialog(null, "خطا في اسم المستخدم أو كلمة المرور أو فشل الاتصال");
   
   
            //new rojerusan.RSNotifyAnimated("معلومات", "خطا في اسم المستخدم أو كلمة المرور" , 4, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        } catch (ClassNotFoundException ex) {
               View.Message meg = new Message(new javax.swing.JFrame(), true, "خطا في اسم المستخدم أو كلمة المرور أو فشل الاتصال", MessageType.ERROR , 20);meg.setVisible(true);
            // JOptionPane.showMessageDialog(null, ex.getMessage());
//JOptionPane.showMessageDialog(null, "خطا في اسم المستخدم أو كلمة المرور أو فشل الاتصال");
       // new rojerusan.RSNotifyAnimated("معلومات", "خطا في اسم المستخدم أو كلمة المرور" , 4, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }

    }

    /**
     *
     * @return
     */
    public static DatabaseConnection getinstance(String user , String pass) {

        try {

            if (conn == null) {
                instance = new DatabaseConnection(user,pass);
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        } finally {
            
            return instance;
            
        }
    }

    public static DatabaseConnection getinstance() {
        return instance;
       
    }
     
    public Connection getConnection(){
        return conn;
    }
    
    public void ErrorLogin(){
    JOptionPane.showMessageDialog(null, "الرجاء أدخل الاسم المستخدم أو كلمة المرور");
    }
    


    

    
}
