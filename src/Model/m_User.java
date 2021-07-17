/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ahmad-soft
 */
public class m_User {

    private int ID;
    private String Name;
    private String first_name;
    private String middle_name;
    private String last_name;
    private int id_user_type;
    private String password;
    private boolean state;
    private String user_name;
    private String name_user_type;
    private Integer id_work_place;
    private boolean is_super;

    public m_User() {
    }

    public m_User(String first_name, String middle_name, String last_name) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
    }

    public String full_name() {
        return first_name + middle_name + last_name;
    }

    @Override
    public String toString() {
        return user_name;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId_user_type() {
        return id_user_type;
    }

    public void setId_user_type(int id_user_type) {
        this.id_user_type = id_user_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getUser_type() {
        return name_user_type;
    }

    public void setUser_type(String user_type) {
        this.name_user_type = user_type;
    }

    public Integer getId_work_place() {
        return id_work_place;
    }

    public void setId_work_place(Integer id_work_place) {
        this.id_work_place = id_work_place;
    }

    public String getName_user_type() {
        return name_user_type;
    }

    public void setName_user_type(String name_user_type) {
        this.name_user_type = name_user_type;
    }

    public boolean isIs_super() {
        return is_super;
    }

    public void setIs_super(boolean is_super) {
        this.is_super = is_super;
    }

   

}
