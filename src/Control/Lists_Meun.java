/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Model_Tables;
import Model.m_User;
import Model.m_jops;
import Model.m_view_employee;
import View.frmLoading;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author ahmad-soft
 */
public class Lists_Meun implements Runnable {
frmLoading frm;
    // -------------   Controls  -----------------
    public static Control.C_Qualification_Type Qual_Type = new C_Qualification_Type();
    public static Control.C_Qualification_Name Qual_Name = new C_Qualification_Name();
    public static Control.C_Qualification_Division Qual_Division = new C_Qualification_Division();
    public static Control.C_Ministry C_Ministry = new C_Ministry();
    public static Control.C_Directorates C_Direct = new C_Directorates();
    public static Control.C_Department C_Department = new C_Department();
    public static Control.C_Divisions C_Division = new C_Divisions();
    public static Control.Funiction_Tables c_social_status = new Funiction_Tables();
    public static Control.Funiction_Tables c_blood = new Funiction_Tables();
    public static Control.Funiction_Tables c_job_change = new Funiction_Tables();
    public static Control.Funiction_Tables c_type_of_doc = new Funiction_Tables();
    public static Control.c_work_city C_governnorates_2 = new c_work_city();
    public static Control.c_work_city C_district_work_city = new c_work_city();
    public static Control.c_work_city C_sub_district_work_city = new c_work_city();
    public static Control.c_work_city C_work_city_community = new c_work_city();
    public static Control.Funiction_Tables C_governnorates_1 = new Funiction_Tables();
    public static Control.c_district C_district = new c_district();
    public static Control.c_registerplace C_registerplace = new c_registerplace();
    public static Control.c_registerno C_registerno = new c_registerno();
    public static Control.c_jops C_jops = new c_jops();
    public static Control.c_jops C_jops_description = new c_jops();
    public static Control.Funiction_Tables Control_user = new Funiction_Tables();
    public static Control.control_user_admin con_views_permisiones = new control_user_admin();
    public static Control.control_user_admin control_view_users = new control_user_admin();
     
    
    public  static  Control.C_employee search_emp = new C_employee();
    public  static  Control.C_employee c_view_emp_all = new C_employee();
    public static      Control.c_jops c_view_name_jops = new c_jops();
    public static      Control.c_jops c_view_jops_description = new c_jops();
    
 
    
    public static  Control.control_user_admin view_Manage_admins = new control_user_admin();
    public static  Control.control_user_admin view_Manage_users = new control_user_admin();
    public static  Control.control_user_admin view_permision_admins = new control_user_admin();

    


    JProgressBar c;
     Integer count = 100/25;
    // -------------   Modles  -----------------
    public static ArrayList<Model.M_Qualification_Type> Array_Qual_Type;
    public static ArrayList<Model.M_Qualification_Name> Array_Qual_Name;
    public static ArrayList<Model.M_Qualification_Division> Array_Qual_Division;
    public static ArrayList<Model.M_Ministry> A_Ministry;
    public static ArrayList<Model.M_Directorates> A_Direct;
    public static ArrayList<Model.M_Department> A_Department;
    public static ArrayList<Model.M_Divisions> A_Division;
    public static ArrayList<Model.Model_Tables> Array_c_social_status;
    public static ArrayList<Model.Model_Tables> Array_blood;
    public static ArrayList<Model.Model_Tables> Array_job_change;
    public static ArrayList<Model.Model_Tables> Array_type_of_doc;
    public static ArrayList<Model.m_work_city> Array_governnorates_2;
    public static ArrayList<Model.m_work_city> Array_district_work_city;
    public static ArrayList<Model.m_work_city> Array_sub_district_work_city;
    public static ArrayList<Model.m_work_city> Array_work_city_community;
    public static ArrayList<Model.Model_Tables> Array_governnorates_1;
    public static ArrayList<Model.m_district> Array_district;
    public static ArrayList<Model.m_registerplace> Array_registerplace;
    public static ArrayList<Model.m_registerno> Array_registerno;
    public static ArrayList<Model.m_jops> Array_jops;
    public static ArrayList<Model.m_jops> Array_jops_description;
    public static ArrayList<Model_Tables> Array_user_admin;
    public static ArrayList<Model.m_User> Array_view_users;
    public static ArrayList<Model.m_User> array_permisiones;
 public static ArrayList<m_view_employee> array_search;
 public static ArrayList<m_jops> array_view_name_jops;
 public static ArrayList<m_jops> Array_view_jops_description;
 public static ArrayList<m_view_employee> view_emp_all;
 
 public static ArrayList<m_User> array_view_admins;
 public static ArrayList<m_User> array_view_users;
 public static ArrayList<m_User> array_view_permisiones_admins;
 
 

    
    
    public void run() {
        
                c.setValue( c.getValue() + count);
                Array_Qual_Name = new C_Qualification_Name().view_Qualification_Name();
                
                c.setValue( c.getValue() + count);
                Array_Qual_Type = new C_Qualification_Type().view_Qualification_Type(0);
                  c.setValue( c.getValue() + count);
                Array_Qual_Division = new C_Qualification_Division().view_Qualification_Division(0, 0);
                  c.setValue( c.getValue() + count);
                A_Ministry = new C_Ministry().getAllRows();
                  c.setValue( c.getValue() + count);
                A_Direct = new C_Directorates().viewDirectorate(0);
                  c.setValue( c.getValue() + count);
                A_Department = new C_Department().viewDepartment(0, 0);
                 c.setValue( c.getValue() + count);
    try {
        A_Division = new C_Divisions().viewDepartment(0, 0, 0);
         c.setValue( c.getValue() + count);
    } catch (SQLException ex) {
        Logger.getLogger(Lists_Meun.class.getName()).log(Level.SEVERE, null, ex);
    }
                
                Array_blood = new Funiction_Tables().filltable("blood");
                  c.setValue( c.getValue() + count);
                Array_job_change = new Funiction_Tables().filltable("job_change");
                  c.setValue( c.getValue() + count);
                Array_c_social_status = new Funiction_Tables().filltable("social_status");
                c.setValue( c.getValue() + count);
                Array_type_of_doc = new Funiction_Tables().filltable("type_of_doc");
                c.setValue( c.getValue() + count);
                Array_governnorates_2 = new c_work_city().view_governorate_work_city();
                c.setValue( c.getValue() + count);
                Array_district_work_city = new c_work_city().view_district_work_city(0);
                 c.setValue( c.getValue() + count);
                Array_sub_district_work_city = new c_work_city().view_sub_district_work_city(0, 0);
                 c.setValue( c.getValue() + count);
                Array_work_city_community = new c_work_city().viewcommunity_work_city(0, 0, 0);
                c.setValue( c.getValue() + count);
                Array_governnorates_1 = new Funiction_Tables().filltable("states");
                 c.setValue( c.getValue() + count);
                Array_district = new c_district().view_district(0);
                  c.setValue( c.getValue() + count);
                Array_registerplace = new c_registerplace().view_registerplace(0);
                  c.setValue( c.getValue() + count);
                Array_registerno = new c_registerno().view_registeno(0);
                 c.setValue( c.getValue() + count);
                Array_jops = new c_jops().view_jops();
                  c.setValue( c.getValue() + count);
                Array_jops_description = new c_jops().view_jops_description(0);
                  c.setValue( c.getValue() + count);
                Array_user_admin = new Funiction_Tables().filltable("user_type");
                c.setValue( c.getValue() + count);
                Array_view_users = new control_user_admin().view_users();
                 c.setValue( c.getValue() + count);
                array_permisiones = new control_user_admin().view_permisiones();
                 c.setValue( c.getValue() + count);
                  m_view_employee model = new m_view_employee();
                array_search =  new C_employee().search_employees_all(model);
            array_view_name_jops  = new c_jops().view_jops();
            Array_view_jops_description =   new c_jops().view_jops_description(0);
            view_emp_all = new C_employee().view_employee_All();
            
            
            array_view_admins = new control_user_admin().view_admins();
            array_view_users = new control_user_admin().view_users();
            array_view_permisiones_admins  = new control_user_admin().view_permisiones_admins();
            frm.setVisible(false);

    }

    public Lists_Meun(JProgressBar pr,frmLoading fr) {
        c = pr;
        this.frm=fr;
    }

}
