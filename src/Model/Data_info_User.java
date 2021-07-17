/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ahmad-soft
 */
public class Data_info_User {
    private static int Id_user;
    private static String User_type;

    public static int getId_user() {
        return Id_user;
    }

    public static void setId_user(int aId_user) {
        Id_user = aId_user;
    }

    public static String getUser_type() {
        return User_type;
    }

    public static void setUser_type(String aUser_type) {
        User_type = aUser_type;
    }
    
}
