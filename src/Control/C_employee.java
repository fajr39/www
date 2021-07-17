/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DB.DatabaseConnection;
import Model.M_Add_employee;
import Model.MessageType;
import Model.m_User;
import Model.m_view_employee;
import View.Message;
import java.awt.image.RescaleOp;
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
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author ahmad-soft
 */
public class C_employee implements Entity.MainData<Model.M_Add_employee> {

    public boolean add(M_Add_employee item) {
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {
            //test*********
//            DatabaseConnection a = DatabaseConnection.getinstance("a1", "a1");

            CallableStatement stmt = con.prepareCall("{?=call add_employee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            stmt.setString(2, item.getFname());
            stmt.setString(3, item.getLname());
            stmt.setString(4, item.getMname());
            stmt.setBoolean(5, item.isNature());
            stmt.setString(6, item.getFictitiousnamep());
            stmt.setString(7, item.getMother_name());
            java.sql.Date date = new Date(item.getBrith_date().getTime());
            stmt.setDate(8, date);
            stmt.setBoolean(9, item.isSex());
            stmt.setInt(10, item.getSocil_status_p());
            stmt.setInt(11, item.getIdnumberp());
            stmt.setInt(12, item.getId_registernop());
            System.out.println(item.getId_registernop());
            stmt.setString(13, item.getPhonenumberp());
            stmt.setInt(14, item.getId_bloodp());
            stmt.setBoolean(15, item.isRhp());
            stmt.setInt(16, item.getQualification_p());
            stmt.setInt(17, item.getId_jopsp());
            stmt.setInt(18, item.getJob_change_p());
            stmt.setInt(19, item.getWork_place_p());
            stmt.setInt(20, item.getCurrenctplaceofresidencep());
            stmt.setInt(21, item.getType_of_doc_p());
            stmt.setInt(22, item.getId_work_city_p());
            java.sql.Date start_date = new Date(item.getStarting_date().getTime());
            stmt.setDate(23, start_date);
            stmt.registerOutParameter(1, Types.INTEGER);
            con.setAutoCommit(false);
            stmt.execute();
            con.commit();
            ResultSet rs;
            int i = (int) stmt.getObject(1);
            if (i == -1) {
            View.Message meg = new Message(new javax.swing.JFrame(), true, "تم إضافة موظف مسبقا", MessageType.INFORMATION , 20);meg.setVisible(true);
                
             //   new rojerusan.RSNotifyAnimated("معلومات", "تم إضافة موظف مسبقا", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return false;
            }
           // new rojerusan.RSNotifyAnimated("معلومات", "تم إضافة موظف جديد", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
          
           return true;

        } catch (Exception e) {
       View.Message meg = new Message(new javax.swing.JFrame(), true, "خارج نطاق السماحيات", MessageType.WARNING , 20);meg.setVisible(true);
           

            try {
              con.rollback();
           } catch (SQLException ex) {
           //     new rojerusan.RSNotifyAnimated("معلومات", "خارج نطاق السماحيات" , 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);

           }
            return false;
        }
    }


    public ArrayList<M_Add_employee> view_namesand_idemployees() {
        ArrayList<Model.M_Add_employee> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {

            CallableStatement stmt;
            stmt = con.prepareCall("{?=call get_employee_id_and_name()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.M_Add_employee dir = new M_Add_employee();
                dir.setId_emp(res.getInt("id"));
                dir.setFname(res.getString("first_name"));
                dir.setMname(res.getString("middle_name"));
                dir.setLname(res.getString("last_name"));
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
// منشان عرض كل موظيفن بس غير اسم دالةview_employees_uncertain_checker 

    public ArrayList<m_view_employee> view_employee_All() {
        ArrayList<Model.m_view_employee> items = new ArrayList<>();
//       DatabaseConnection a = DatabaseConnection.getinstance("aboakifadmin", "makMAK12!@");
        Connection con = DatabaseConnection.getinstance().getConnection();
        try {
//view_employees

            CallableStatement stmt;
            stmt = con.prepareCall("{?=call view_employees_uncertain_checker()}");
            stmt.registerOutParameter(1, Types.OTHER);
            con.setAutoCommit(false);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            con.commit();
            while (res.next()) {
                Model.m_view_employee dir = new m_view_employee();
                dir.setId_emp(res.getInt("id"));
                dir.setFname(res.getString("first_name"));
                dir.setMname(res.getString("middle_name"));
                dir.setLname(res.getString("last_name"));
                dir.setNature_of_name(res.getBoolean("nature_of_name"));
                dir.setFictitiousname(res.getString("fictitiousname"));
                dir.setMother_fullname(res.getString("mother_fullname"));
                dir.setBrith_date(res.getDate("brith_date"));
                dir.setSex(res.getBoolean("sex"));
                dir.setSocial_status_name(res.getString("social_status"));
                dir.setState_of_data_name(res.getString("state_of_data"));
                dir.setId_number(res.getInt("id_number"));
                dir.setPhonenumer(res.getInt("phonenumer"));
                dir.setRh(res.getBoolean("rh"));
                dir.setWork_place_divisions(res.getString("work_place_divisions"));
                dir.setWork_place_department(res.getString("work_place_department"));
                dir.setWork_place_directorates(res.getString("work_place_directorates"));
                dir.setWork_place_ministry(res.getString("work_place_ministry"));
                dir.setQualification_divisions(res.getString("qualification_divisions"));
                dir.setQualification_type(res.getString("qualification_type"));
                dir.setQualification_name(res.getString("qualification_name"));
                dir.setCurrent_city_governorate(res.getString("current_city_governorate"));
                dir.setCurrent_city_district(res.getString("current_city_district"));
                dir.setCurrent_city_sub_district(res.getString("current_city_sub_district"));
                dir.setCurrent_city_community(res.getString("current_city_community"));
                
                dir.setCurrent_work_city_governorate(res.getString("current_work_city_governorate"));
                dir.setCurrent_work_city_district(res.getString("current_work_city_district"));
                dir.setCurrent_work_city_sub_district(res.getString("current_work_city_sub_district"));
                dir.setCurrent_work_city_community(res.getString("current_work_city_community"));
                dir.setType_of_doc_name(res.getString("doc"));
                dir.setJop_title(res.getString("jop_title"));
                dir.setJops_description(res.getString("jop_description"));
                dir.setBlood_name(res.getString("blood_name"));
                dir.setStates(res.getString("state_name"));
                dir.setDistrict(res.getString("district_name"));
                dir.setRegisterplace(res.getString("registerplace_name"));
                dir.setRegisterno(res.getString("registerno_name"));
                dir.setJop_change(res.getString("job_change_name"));
                dir.setStart_date(res.getDate("starting_date"));
                dir.setData_entry(res.getString("user_entry"));
                dir.setDate_entrytime(res.getDate("date_entrytime"));
                dir.setUser_checker(res.getString("user_checker"));
                dir.setDate_check(res.getDate("date_check"));

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

    public ArrayList<Model.m_view_employee> search_employees_all(m_view_employee item) {
//        DatabaseConnection a = DatabaseConnection.getinstance("postgres", "123456");
        Connection con = DatabaseConnection.getinstance().getConnection();
        ArrayList<Model.m_view_employee> items = new ArrayList<>();
        try {
            CallableStatement stmt;
            stmt = con.prepareCall("{?=call search_employees(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            if (item.getTxt_id_emp() != null) {
                stmt.setNull(2, Types.NULL);
            } else {
                stmt.setString(2, item.getTxt_id_emp());
            }
            if (item.getFname() != null) {
                stmt.setNull(3, Types.NULL);

            } else {
                stmt.setString(3, item.getFname());
            }
            if (item.getMname() != null) {
                stmt.setNull(4, Types.NULL);
            } else {
                stmt.setString(4, item.getMname());
            }
            if (item.getLname() != null) {
                stmt.setNull(5, Types.NULL);
            } else {
                stmt.setString(5, item.getLname());
                System.out.println(item.getLname());
            }

            if (item.isNature_of_name()) {
                stmt.setNull(6, Types.NULL);
            } else {

                stmt.setNull(6, Types.NULL);

            }
            if (item.getFictitiousname() != null) {
                stmt.setNull(7, Types.NULL);
            } else {
                stmt.setString(7, item.getFictitiousname());
            }
            if (item.getMother_fullname() != null) {
                stmt.setNull(8, Types.NULL);
            } else {
                stmt.setString(8, item.getMother_fullname());
            }
            if (item.getBrith_date() == null) {
                stmt.setNull(9, Types.NULL);
            } else {
                java.util.Date date1 = new Date(item.getBrith_date().getTime());
                stmt.setString(9, date1.toString());
            }
            if (item.isSex()) {
                stmt.setNull(10, 0);
            } else {
                stmt.setNull(10, 0);
            }
            if (item.getSocial_status_name() == null) {
                stmt.setNull(11, Types.NULL);

            } else {

                stmt.setString(11, item.getSocial_status_name());
            }

            if (item.getState_of_data_name() == null) {
                stmt.setNull(12, 0);
            } else {
                stmt.setNull(12, 0);

            }

            if (item.getTxt_id_number() == null) {
                stmt.setNull(13, Types.NULL);
            } else {
                stmt.setString(13, item.getTxt_id_number());
            }
            if (item.getTxt_phonenumer() == null) {
                stmt.setNull(14, Types.NULL);
            } else {
                stmt.setString(14, item.getTxt_phonenumer());
            }

            if (item.isRh()) {
                stmt.setNull(15, 0);
            } else {
                stmt.setNull(15, 0);
                //      stmt.setString(15, item.getTxt_rh());

            }
            if (item.getWork_place_divisions() == null) {
                stmt.setNull(16, Types.NULL);
            } else {
                stmt.setString(16, item.getWork_place_divisions());
            }

            if (item.getWork_place_ministry() == null) {
                stmt.setNull(17, Types.NULL);
            } else {
                stmt.setString(17, item.getWork_place_ministry());
            }
            if (item.getWork_place_directorates() == null) {
                stmt.setNull(18, Types.NULL);
            } else {
                stmt.setString(18, item.getWork_place_directorates());
            }
            if (item.getWork_place_department() == null) {
                stmt.setNull(19, Types.NULL);
            } else {
                stmt.setString(19, item.getWork_place_department());
            }
            if (item.getQualification_divisions() == null) {
                stmt.setNull(20, Types.NULL);
            } else {
                stmt.setString(20, item.getQualification_divisions());
            }
            if (item.getQualification_type() == null) {
                stmt.setNull(21, Types.NULL);
            } else {
                stmt.setString(21, item.getQualification_type());
            }

            if (item.getQualification_name() == null) {
                stmt.setNull(22, Types.NULL);
            } else {
                stmt.setString(22, item.getQualification_name());
            }
            if (item.getCurrent_city_community() == null) {
                stmt.setNull(23, Types.NULL);
            } else {
                stmt.setString(23, item.getCurrent_city_community());
            }
            if (item.getCurrent_city_sub_district() == null) {
                stmt.setNull(24, Types.NULL);
            } else {
                stmt.setString(24, item.getCurrent_city_sub_district());
            }
            if (item.getCurrent_city_district() == null) {
                stmt.setNull(25, Types.NULL);
            } else {
                stmt.setString(25, item.getCurrent_city_district());
            }
            if (item.getCurrent_city_governorate() == null) {
                stmt.setNull(26, Types.NULL);
            } else {
                stmt.setString(26, item.getCurrent_city_governorate());
            }
            if (item.getCurrent_work_city_community() == null) {
                stmt.setNull(27, Types.NULL);
            } else {
                stmt.setString(27, item.getCurrent_work_city_community());
            }
            if (item.getCurrent_work_city_sub_district() == null) {
                stmt.setNull(28, Types.NULL);
            } else {
                stmt.setString(28, item.getCurrent_work_city_sub_district());
            }
            if (item.getCurrent_work_city_district() == null) {
                stmt.setNull(29, Types.NULL);
            } else {
                stmt.setString(29, item.getCurrent_work_city_district());
            }
            if (item.getCurrent_work_city_governorate() == null) {
                stmt.setNull(30, Types.NULL);
            } else {
                stmt.setString(30, item.getCurrent_work_city_governorate());
            }
            if (item.getType_of_doc_name() == null) {
                stmt.setNull(31, Types.NULL);
            } else {
                stmt.setString(31, item.getType_of_doc_name());
            }

            if (item.getJops_description() == null) {
                stmt.setNull(32, Types.NULL);
            } else {
                stmt.setString(32, item.getJops_description());
            }
            if (item.getJop_title() == null) {
                stmt.setNull(33, Types.NULL);
            } else {
                stmt.setString(33, item.getJop_title());
            }

            if (item.getBlood_name() == null) {
                stmt.setNull(34, Types.NULL);
            } else {
                stmt.setString(34, item.getBlood_name());
            }
            if (item.getStates() == null) {
                stmt.setNull(35, Types.NULL);
            } else {
                stmt.setString(35, item.getStates());
            }

            if (item.getDistrict() == null) {
                stmt.setNull(36, Types.NULL);
            } else {
                stmt.setString(36, item.getDistrict());
            }
            if (item.getRegisterplace() == null) {
                stmt.setNull(37, Types.NULL);
            } else {
                stmt.setString(37, item.getRegisterplace());
            }
            if (item.getRegisterno() == null) {
                stmt.setNull(38, Types.NULL);
            } else {
                stmt.setString(38, item.getRegisterno());
            }
            if (item.getJop_change() == null) {
                stmt.setNull(39, Types.NULL);
            } else {
                stmt.setString(39, item.getJop_change());
            }

            if (item.getStart_date() == null) {
                stmt.setNull(40, Types.NULL);
            } else {
                stmt.setString(40, item.getStart_date().toString());
            }
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_view_employee dir = new m_view_employee();
                dir.setId_emp(res.getInt("id"));
                dir.setFname(res.getString("first_name"));
                dir.setMname(res.getString("middle_name"));
                dir.setLname(res.getString("last_name"));
                dir.setNature_of_name(res.getBoolean("nature_of_name"));
                dir.setFictitiousname(res.getString("fictitiousname"));
                dir.setMother_fullname(res.getString("mother_fullname"));
                dir.setBrith_date(res.getDate("brith_date"));
                dir.setSex(res.getBoolean("sex"));
                dir.setSocial_status_name(res.getString("social_status"));
                dir.setState_of_data_name(res.getString("state_of_data"));
                dir.setId_number(res.getInt("id_number"));
                dir.setPhonenumer(res.getInt("phonenumer"));
                dir.setRh(res.getBoolean("rh"));
                dir.setWork_place_divisions(res.getString("work_place_divisions"));
                dir.setWork_place_department(res.getString("work_place_department"));
                dir.setWork_place_directorates(res.getString("work_place_directorates"));
                dir.setWork_place_ministry(res.getString("work_place_ministry"));
                dir.setQualification_divisions(res.getString("qualification_divisions"));
                dir.setQualification_type(res.getString("qualification_type"));
                dir.setQualification_name(res.getString("qualification_name"));
                dir.setCurrent_city_governorate(res.getString("current_city_governorate"));
                dir.setCurrent_city_district(res.getString("current_city_district"));
                dir.setCurrent_city_sub_district(res.getString("current_city_sub_district"));
                dir.setCurrent_city_community(res.getString("current_city_community"));
                dir.setCurrent_work_city_governorate(res.getString("current_work_city_governorate"));
                dir.setCurrent_work_city_district(res.getString("current_work_city_district"));
                dir.setCurrent_work_city_sub_district(res.getString("current_work_city_sub_district"));
                dir.setCurrent_work_city_community(res.getString("current_work_city_community"));
                dir.setType_of_doc_name(res.getString("doc"));
                dir.setJop_title(res.getString("jop_title"));
                dir.setJops_description(res.getString("jop_description"));
                dir.setBlood_name(res.getString("blood_name"));
                dir.setStates(res.getString("state_name"));
                dir.setDistrict(res.getString("district_name"));
                dir.setRegisterplace(res.getString("registerplace_name"));
                dir.setRegisterno(res.getString("registerno_name"));
                dir.setJop_change(res.getString("job_change_name"));
                dir.setStart_date(res.getDate("starting_date"));
                dir.setData_entry(res.getString("user_entry"));
                dir.setDate_entrytime(res.getDate("date_entrytime"));
                dir.setUser_checker(res.getString("user_checker"));
                dir.setDate_check(res.getDate("date_check"));
                items.add(dir);
            }
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sss" + e.getMessage());
            try {

                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(C_employee.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        return items;

    }

    @Override
    public boolean update(M_Add_employee item) {

        return false;

    }

    public ArrayList<Model.m_view_employee> update_and_cheker_emp(M_Add_employee item) {
        Connection con = DatabaseConnection.getinstance().getConnection();
        ArrayList<Model.m_view_employee> items = new ArrayList<>();
        try {

            CallableStatement stmt = con.prepareCall("{?=call view_employees_checker(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            stmt.registerOutParameter(1, Types.OTHER);
            stmt.setInt(2, item.getId_emp());
            stmt.setString(3, item.getFname());
            stmt.setString(4, item.getMname());
            stmt.setString(5, item.getLname());
            stmt.setBoolean(6, item.isNature());
            stmt.setString(7, item.getFictitiousnamep());
            stmt.setString(8, item.getMother_name());
            java.sql.Date date = new Date(item.getBrith_date().getTime());
            stmt.setDate(9, date);
            stmt.setBoolean(10, item.isSex());
            stmt.setInt(11, item.getSocil_status_p());
            stmt.setInt(12, item.getIdnumberp());
            stmt.setInt(13, item.getId_registernop());
            stmt.setString(14, item.getPhonenumberp());
            stmt.setInt(15, item.getId_bloodp());
            stmt.setBoolean(16, item.isRhp());
            stmt.setInt(17, item.getQualification_p());
            stmt.setInt(18, item.getId_jopsp());
            stmt.setInt(19, item.getJob_change_p());
            stmt.setInt(20, item.getWork_place_p());
            stmt.setInt(21, item.getCurrenctplaceofresidencep());
            stmt.setInt(22, item.getType_of_doc_p());
            stmt.setInt(23, item.getId_work_city_p());
            java.sql.Date start_date = new Date(item.getStarting_date().getTime());
            stmt.setDate(24, start_date);
            con.setAutoCommit(false);
            stmt.execute();

            ResultSet res = (ResultSet) stmt.getObject(1);
            while (res.next()) {
                Model.m_view_employee dir = new m_view_employee();
                dir.setId_emp(res.getInt("id"));
                dir.setFname(res.getString("first_name"));
                dir.setMname(res.getString("middle_name"));
                dir.setLname(res.getString("last_name"));
                dir.setNature_of_name(res.getBoolean("nature_of_name"));
                dir.setFictitiousname(res.getString("fictitiousname"));
                dir.setMother_fullname(res.getString("mother_fullname"));
                dir.setBrith_date(res.getDate("brith_date"));
                dir.setSex(res.getBoolean("sex"));
                dir.setSocial_status_name(res.getString("social_status"));
                dir.setState_of_data_name(res.getString("state_of_data"));
                dir.setId_number(res.getInt("id_number"));
                dir.setPhonenumer(res.getInt("phonenumer"));
                dir.setRh(res.getBoolean("rh"));
                dir.setWork_place_divisions(res.getString("work_place_divisions"));
                dir.setWork_place_department(res.getString("work_place_department"));
                dir.setWork_place_directorates(res.getString("work_place_directorates"));
                dir.setWork_place_ministry(res.getString("work_place_ministry"));
                dir.setQualification_divisions(res.getString("qualification_divisions"));
                dir.setQualification_type(res.getString("qualification_type"));
                dir.setQualification_name(res.getString("qualification_name"));
                dir.setCurrent_city_governorate(res.getString("current_city_governorate"));
                dir.setCurrent_city_district(res.getString("current_city_district"));
                dir.setCurrent_city_sub_district(res.getString("current_city_sub_district"));
                dir.setCurrent_city_community(res.getString("current_city_community"));
                dir.setCurrent_work_city_governorate(res.getString("current_work_city_governorate"));
                dir.setCurrent_work_city_district(res.getString("current_work_city_district"));
                dir.setCurrent_work_city_sub_district(res.getString("current_work_city_sub_district"));
                dir.setCurrent_work_city_community(res.getString("current_work_city_community"));
                dir.setType_of_doc_name(res.getString("doc"));
                dir.setJop_title(res.getString("jop_title"));
                dir.setJops_description(res.getString("jop_description"));
                dir.setBlood_name(res.getString("blood_name"));
                dir.setStates(res.getString("state_name"));
                dir.setDistrict(res.getString("district_name"));
                dir.setRegisterplace(res.getString("registerplace_name"));
                dir.setRegisterno(res.getString("registerno_name"));
                dir.setJop_change(res.getString("job_change_name"));
                dir.setStart_date(res.getDate("starting_date"));
                dir.setData_entry(res.getString("user_entry"));
                dir.setDate_entrytime(res.getDate("date_entrytime"));
                dir.setUser_checker(res.getString("user_checker"));
                dir.setDate_check(res.getDate("date_check"));
                items.add(dir);
            }
            con.commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erorr in go -> go update employee " + ex.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, " Erorr in go -> go update employee" + ex1.getMessage());
            }

        }
        return items;
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
    public ArrayList<M_Add_employee> getAllRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
