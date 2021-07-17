/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import rojerusan.RSPanelsSlider;
import Control.C_employee;
import Control.Lists_Meun;
import Model.M_Add_employee;
import Model.M_Department;
import Model.M_Directorates;
import Model.M_Divisions;
import Model.M_Ministry;
import Model.M_Qualification_Division;
import Model.M_Qualification_Name;
import Model.M_Qualification_Type;
import Model.Model_Tables;
import Model.m_district;
import Model.m_jops;
import Model.m_registerno;
import Model.m_registerplace;
import Model.m_view_employee;
import Model.m_work_city;
import java.awt.ComponentOrientation;
import static java.awt.SystemColor.text;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author ahmad-soft
 */
public class frmGeneralsearch extends javax.swing.JFrame {

    Model.m_view_employee model;
    Control.C_employee ctrl;
     View.view_Employees_Confirm frm_view;
    /**
     * Creates new form AddEmp
     */

 boolean sexing;
    public frmGeneralsearch() {
        initComponents();
        init_comboboxes();
        setLocationRelativeTo(null);
        model = new m_view_employee();
        ctrl = new C_employee();
        fillCombobox();
        txt_nature_name.setVisible(false);
        N_place.setVisible(false);
        frm_view  = new view_Employees_Confirm();

    }
     int jtable_width = 150;
    public  void haded() {
        int column_count = frm_view.table_emp.getColumnCount();
        for(int i =0 ; i < column_count ; i++){      
           TableColumn col = frm_view.table_emp.getColumnModel().getColumn(i);
           col.setPreferredWidth(jtable_width);       
        }
    }


    public void fillCombobox() {

        Lists_Meun.Array_c_social_status = Lists_Meun.c_social_status.filltable("social_status");
        DefaultComboBoxModel model = (DefaultComboBoxModel) id_social_status.getModel();
        model.addAll(Lists_Meun.Array_c_social_status);

        Lists_Meun.Array_blood = Lists_Meun.c_blood.filltable("blood");
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cmb_blood.getModel();
        model1.addAll(Lists_Meun.Array_blood);

        Lists_Meun.Array_job_change = Lists_Meun.c_job_change.filltable("job_change");
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) id_jop_change.getModel();
        model2.addAll(Lists_Meun.Array_job_change);

        Lists_Meun.Array_type_of_doc = Lists_Meun.c_type_of_doc.filltable("type_of_doc");
        DefaultComboBoxModel model6 = (DefaultComboBoxModel) cmb_type_of_doc.getModel();
        model6.addAll(Lists_Meun.Array_type_of_doc);

        Lists_Meun.Array_governnorates_2 = Lists_Meun.C_governnorates_2.view_governorate_work_city();
        DefaultComboBoxModel model3 = (DefaultComboBoxModel) current_city_governorate.getModel();
        model3.addAll(Lists_Meun.Array_governnorates_2);
        
        
         Lists_Meun.Array_governnorates_2 = Lists_Meun.C_governnorates_2.view_governorate_work_city();
        DefaultComboBoxModel model33 = (DefaultComboBoxModel) current_work_city_governorate.getModel();
        model33.removeAllElements();
        model33.addAll(Lists_Meun.Array_governnorates_2);

        Lists_Meun.A_Ministry = Lists_Meun.C_Ministry.getAllRows();
        DefaultComboBoxModel model4 = (DefaultComboBoxModel) cmb_Ministry.getModel();
        model4.addAll(Lists_Meun.A_Ministry);

        Lists_Meun.Array_governnorates_1 = Lists_Meun.C_governnorates_1.filltable("states");
        DefaultComboBoxModel model53 = (DefaultComboBoxModel) governnorates_States.getModel();
        model53.addAll(Lists_Meun.Array_governnorates_1);

        Lists_Meun.Array_jops = Lists_Meun.C_jops.view_jops();
        DefaultComboBoxModel model100 = (DefaultComboBoxModel) cmb_Jop_title.getModel();
        model100.removeAllElements();
        model100.addAll(Lists_Meun.Array_jops);

        Lists_Meun.Array_Qual_Name = Lists_Meun.Qual_Name.view_Qualification_Name();
        DefaultComboBoxModel model42 = (DefaultComboBoxModel) cmb_Qualification_Name.getModel();
        model42.addAll(Lists_Meun.Array_Qual_Name);
    }

    public void full_Direct() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        Lists_Meun.A_Direct = Lists_Meun.C_Direct.viewDirectorate(id_Ministry);
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmb_Directorates.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Direct);

    }

    public void fullDept() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        Lists_Meun.A_Department = Lists_Meun.C_Department.viewDepartment(id_Direct, id_Ministry);
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmb_department.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Department);

    }

    public void fullDivi() throws SQLException {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        int id_Div = ((M_Department) cmb_department.getSelectedItem()).getId_department();
        Lists_Meun.A_Division = Lists_Meun.C_Division.viewDepartment(id_Direct, id_Ministry, id_Div);
          DefaultComboBoxModel model = (DefaultComboBoxModel)cmb_Divisions.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Division);

    }

    public void Qualification_Type() {
        int id_Direct = ((M_Qualification_Name) cmb_Qualification_Name.getSelectedItem()).getId_Name();
        Lists_Meun.Array_Qual_Type = Lists_Meun.Qual_Type.view_Qualification_Type(id_Direct);
           DefaultComboBoxModel model = (DefaultComboBoxModel)cmb_Qualification_Type.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.Array_Qual_Type);

    }

    public void Qualification_division() {
        int id_tyep = ((M_Qualification_Type) cmb_Qualification_Type.getSelectedItem()).getId_type();
        int id_Nam = ((M_Qualification_Name) cmb_Qualification_Name.getSelectedItem()).getId_Name();
        Lists_Meun.Array_Qual_Division = Lists_Meun.Qual_Division.view_Qualification_Division(id_Nam, id_tyep);
            DefaultComboBoxModel model = (DefaultComboBoxModel)cmb_qualification_divisions.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.Array_Qual_Division);

        
    }

    public void view_district_work_city() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        Lists_Meun.Array_district_work_city = Lists_Meun.C_district_work_city.view_district_work_city(id_governorate);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel)current_city_district .getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_district_work_city);

    }
    
     public void view_district_current_city() {
        int id_governorate = ((m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate();
        Lists_Meun.Array_district_work_city = Lists_Meun.C_district_work_city.view_district_work_city(id_governorate);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel)current_work_city_district .getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_district_work_city);

    }

    public void view_sub_district_work_city() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        int id_district = ((m_work_city) current_city_district.getSelectedItem()).getId_district();
        Lists_Meun.Array_sub_district_work_city = Lists_Meun.C_sub_district_work_city.view_sub_district_work_city(id_governorate, id_district);
        DefaultComboBoxModel  model1 = (DefaultComboBoxModel)current_city_sub_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_sub_district_work_city);
  
    }
    public void view_sub_district_current_city() {
        int id_governorate1 = ((m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate();
        int id_district1 = ((m_work_city) current_work_city_district.getSelectedItem()).getId_district();
        Lists_Meun.Array_sub_district_work_city = Lists_Meun.C_sub_district_work_city.view_sub_district_work_city(id_governorate1, id_district1);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel)current_work_city_sub_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_sub_district_work_city);
       
    }

    public void view_work_city_community() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        int id_district = ((m_work_city) current_city_district.getSelectedItem()).getId_district();
        int id_community = ((m_work_city) current_city_sub_district.getSelectedItem()).getId_sub_district();
        Lists_Meun.Array_work_city_community = Lists_Meun.C_work_city_community.viewcommunity_work_city(id_governorate, id_district, id_community);
        DefaultComboBoxModel modle1 = (DefaultComboBoxModel)current_city_community.getModel();
        modle1.removeAllElements();
        modle1.addAll(Lists_Meun.Array_work_city_community);

    }
    
    
      public void view_current_city_community() {
        int id_governorate = ((m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate();
        int id_district = ((m_work_city) current_work_city_district.getSelectedItem()).getId_district();
        int id_community = ((m_work_city) current_work_city_sub_district.getSelectedItem()).getId_sub_district();
        Lists_Meun.Array_work_city_community = Lists_Meun.C_work_city_community.viewcommunity_work_city(id_governorate, id_district, id_community);
        current_work_city_community.setModel(new DefaultComboBoxModel(Lists_Meun.Array_work_city_community.toArray()));
    }

    public void fill_district() {
        int id_state = ((Model_Tables) governnorates_States.getSelectedItem()).getColumn_Id();
        Lists_Meun.Array_district = Lists_Meun.C_district.view_district(id_state);
        cmb_States_district.setModel(new DefaultComboBoxModel(Lists_Meun.Array_district.toArray()));
    }

    public void full_registerplace() {
        int id_district = ((m_district) cmb_States_district.getSelectedItem()).getId();
        Lists_Meun.Array_registerplace = Lists_Meun.C_registerplace.view_registerplace(id_district);
        cmb_States_district_registerplace.setModel(new DefaultComboBoxModel(Lists_Meun.Array_registerplace.toArray()));
    }

    public void full_registerno() {
        int id_district = ((m_district) cmb_States_district.getSelectedItem()).getId();
        int id_registerplace = ((m_registerplace) cmb_States_district_registerplace.getSelectedItem()).getId();
        Lists_Meun.Array_registerno = Lists_Meun.C_registerno.view_registeno(id_registerplace);
        cmb_States_district_registerplace_registerno.setModel(new DefaultComboBoxModel(Lists_Meun.Array_registerno.toArray()));
    }

    public void full_jops_description() {
        int id_jops1 = ((m_jops) cmb_Jop_title.getSelectedItem()).getTitle();
        Lists_Meun.Array_jops_description = Lists_Meun.C_jops_description.view_jops_description(id_jops1);
        cmb_Jops_description.setModel(new DefaultComboBoxModel(Lists_Meun.Array_jops_description.toArray()));
    }

    public void init_comboboxes() {
        cmb_States_district_registerplace_registerno.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_States_district_registerplace.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_States_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        governnorates_States.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Jop_title.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Jops_description.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_type_of_doc.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_blood.setModel(new DefaultComboBoxModel(new Integer[0]));
        id_social_status.setModel(new DefaultComboBoxModel(new Integer[0]));
        id_jop_change.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_city_community.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_city_sub_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_city_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_city_governorate.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Ministry.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Qualification_Name.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Directorates.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_department.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Divisions.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Qualification_Type.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_qualification_divisions.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_work_city_governorate.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_work_city_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_work_city_sub_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        current_work_city_community.setModel(new DefaultComboBoxModel(new Integer[0]));
    
    }
    
    
   
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnl1 = new javax.swing.JPanel();
        btn_Exit1 = new RSMaterialComponent.RSButtonMaterialShadow();
        txt_nature_name = new RSMaterialComponent.RSTextFieldMaterial();
        N_place = new javax.swing.JLabel();
        chk_rhp = new RSMaterialComponent.RSCheckBoxMaterial();
        governnorates_States = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p = new javax.swing.JLabel();
        id_social_status = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_socil_status_p = new javax.swing.JLabel();
        txt_brith_date = new com.toedter.calendar.JDateChooser();
        N_brith_date = new javax.swing.JLabel();
        txt_id = new RSMaterialComponent.RSTextFieldMaterial();
        N_fname = new javax.swing.JLabel();
        N_mname = new javax.swing.JLabel();
        middlename = new RSMaterialComponent.RSTextFieldMaterial();
        lastname = new RSMaterialComponent.RSTextFieldMaterial();
        N_lname = new javax.swing.JLabel();
        N_mother_name = new javax.swing.JLabel();
        motherfullname = new RSMaterialComponent.RSTextFieldMaterial();
        cmb_type_of_doc = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_type_of_doc_p = new javax.swing.JLabel();
        idnumber = new RSMaterialComponent.RSTextFieldMaterial();
        N_place2 = new javax.swing.JLabel();
        N_place3 = new javax.swing.JLabel();
        phonenumber = new RSMaterialComponent.RSTextFieldMaterial();
        N_governnorates_p1 = new javax.swing.JLabel();
        cmb_blood = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p2 = new javax.swing.JLabel();
        cmb_States_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p3 = new javax.swing.JLabel();
        N_governnorates_p4 = new javax.swing.JLabel();
        cmb_States_district_registerplace = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_States_district_registerplace_registerno = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p5 = new javax.swing.JLabel();
        cmb_Jop_title = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p6 = new javax.swing.JLabel();
        N_governnorates_p7 = new javax.swing.JLabel();
        cmb_Jops_description = new RSMaterialComponent.RSComboBoxMaterial<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Exit5 = new RSMaterialComponent.RSButtonMaterialShadow();
        firstnamep = new RSMaterialComponent.RSTextFieldMaterial();
        start_date = new com.toedter.calendar.JDateChooser();
        N_brith_date1 = new javax.swing.JLabel();
        pnl5 = new javax.swing.JPanel();
        cmb_qualification_divisions = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p8 = new javax.swing.JLabel();
        N_work_place_p9 = new javax.swing.JLabel();
        cmb_Qualification_Name = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p10 = new javax.swing.JLabel();
        cmb_Directorates = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_department = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p11 = new javax.swing.JLabel();
        cmb_Ministry = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_Divisions = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p13 = new javax.swing.JLabel();
        N_work_place_p14 = new javax.swing.JLabel();
        cmb_Qualification_Type = new RSMaterialComponent.RSComboBoxMaterial<>();
        btn_Exit6 = new RSMaterialComponent.RSButtonMaterialShadow();
        id_jop_change = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_job_change_p = new javax.swing.JLabel();
        btn_Exit2 = new RSMaterialComponent.RSButtonMaterialShadow();
        work_city1 = new javax.swing.JPanel();
        current_work_city_governorate = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_job_change_p2 = new javax.swing.JLabel();
        N_work_place_p18 = new javax.swing.JLabel();
        current_work_city_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        current_work_city_sub_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p19 = new javax.swing.JLabel();
        N_work_place_p20 = new javax.swing.JLabel();
        current_work_city_community = new RSMaterialComponent.RSComboBoxMaterial<>();
        btn_search = new RSMaterialComponent.RSButtonMaterialShadow();
        work_city = new javax.swing.JPanel();
        current_city_governorate = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_job_change_p1 = new javax.swing.JLabel();
        N_work_place_p15 = new javax.swing.JLabel();
        current_city_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        current_city_sub_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p16 = new javax.swing.JLabel();
        N_work_place_p17 = new javax.swing.JLabel();
        current_city_community = new RSMaterialComponent.RSComboBoxMaterial<>();
        btn_Exit7 = new RSMaterialComponent.RSButtonMaterialShadow();
        pnl2 = new javax.swing.JPanel();
        btn_Exit3 = new RSMaterialComponent.RSButtonMaterialShadow();
        pnl3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnl6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelsSlider1.setPreferredSize(new java.awt.Dimension(1090, 446));

        pnl1.setBackground(new java.awt.Color(255, 255, 255));
        pnl1.setForeground(new java.awt.Color(183, 121, 121));
        pnl1.setName("pnl1"); // NOI18N
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Exit1.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit1.setText("التالي");
        btn_Exit1.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit1.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit1.setEffectFocus(true);
        btn_Exit1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit1ActionPerformed(evt);
            }
        });
        pnl1.add(btn_Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 120, -1));

        txt_nature_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_nature_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nature_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_nature_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nature_name.setPlaceholder("");
        pnl1.add(txt_nature_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, -1, -1));

        N_place.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place.setForeground(new java.awt.Color(7, 2, 2));
        N_place.setText("الاسم وهمي");
        pnl1.add(N_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, -1, -1));

        chk_rhp.setForeground(new java.awt.Color(185, 146, 79));
        chk_rhp.setText("+");
        chk_rhp.setColorCheck(new java.awt.Color(185, 146, 79));
        chk_rhp.setColorUnCheck(new java.awt.Color(185, 146, 79));
        chk_rhp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        chk_rhp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chk_rhp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_rhp.setIsEffectRipple(false);
        pnl1.add(chk_rhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        governnorates_States.setBackground(new java.awt.Color(254, 254, 254));
        governnorates_States.setForeground(new java.awt.Color(1, 1, 1));
        governnorates_States.setToolTipText("");
        governnorates_States.setColorMaterial(new java.awt.Color(185, 146, 79));
        governnorates_States.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        governnorates_States.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                governnorates_StatesActionPerformed(evt);
            }
        });
        pnl1.add(governnorates_States, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        N_governnorates_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p.setText("المحافظة");
        pnl1.add(N_governnorates_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        id_social_status.setBackground(new java.awt.Color(254, 254, 254));
        id_social_status.setForeground(new java.awt.Color(10, 10, 10));
        id_social_status.setToolTipText("");
        id_social_status.setColorMaterial(new java.awt.Color(185, 146, 79));
        id_social_status.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        id_social_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_social_statusActionPerformed(evt);
            }
        });
        pnl1.add(id_social_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        N_socil_status_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_socil_status_p.setForeground(new java.awt.Color(7, 2, 2));
        N_socil_status_p.setText("الحالة الأجتماعية");
        pnl1.add(N_socil_status_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, -1, -1));
        pnl1.add(txt_brith_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 250, -1));

        N_brith_date.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_brith_date.setForeground(new java.awt.Color(7, 2, 2));
        N_brith_date.setText("تاريخ ");
        pnl1.add(N_brith_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, -1));

        txt_id.setForeground(new java.awt.Color(1, 1, 1));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_id.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_id.setPlaceholder("");
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idKeyTyped(evt);
            }
        });
        pnl1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

        N_fname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_fname.setForeground(new java.awt.Color(7, 2, 2));
        N_fname.setText("الاسم موظف");
        pnl1.add(N_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, -1, -1));

        N_mname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_mname.setForeground(new java.awt.Color(7, 2, 2));
        N_mname.setText("الاسم الاب");
        pnl1.add(N_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 90, -1, -1));

        middlename.setForeground(new java.awt.Color(1, 1, 1));
        middlename.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        middlename.setColorMaterial(new java.awt.Color(185, 146, 79));
        middlename.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        middlename.setPlaceholder("");
        pnl1.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        lastname.setForeground(new java.awt.Color(1, 1, 1));
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setColorMaterial(new java.awt.Color(185, 146, 79));
        lastname.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lastname.setPlaceholder("");
        pnl1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, -1, -1));

        N_lname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_lname.setForeground(new java.awt.Color(7, 2, 2));
        N_lname.setText("الكنية ");
        pnl1.add(N_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 140, -1, -1));

        N_mother_name.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_mother_name.setForeground(new java.awt.Color(7, 2, 2));
        N_mother_name.setText("الاسم الأم");
        pnl1.add(N_mother_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 200, -1, -1));

        motherfullname.setForeground(new java.awt.Color(1, 1, 1));
        motherfullname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        motherfullname.setColorMaterial(new java.awt.Color(185, 146, 79));
        motherfullname.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        motherfullname.setPlaceholder("");
        pnl1.add(motherfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, -1, -1));

        cmb_type_of_doc.setBackground(new java.awt.Color(254, 254, 254));
        cmb_type_of_doc.setForeground(new java.awt.Color(1, 1, 1));
        cmb_type_of_doc.setToolTipText("");
        cmb_type_of_doc.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_type_of_doc.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_type_of_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_type_of_docActionPerformed(evt);
            }
        });
        pnl1.add(cmb_type_of_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        N_type_of_doc_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_type_of_doc_p.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p.setText("الوثائق الشخصية");
        pnl1.add(N_type_of_doc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        idnumber.setForeground(new java.awt.Color(1, 1, 1));
        idnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idnumber.setColorMaterial(new java.awt.Color(185, 146, 79));
        idnumber.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        idnumber.setPlaceholder("");
        idnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idnumberKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idnumberKeyTyped(evt);
            }
        });
        pnl1.add(idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, -1, -1));

        N_place2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place2.setForeground(new java.awt.Color(7, 2, 2));
        N_place2.setText("رقم بطاقة");
        pnl1.add(N_place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 370, -1, -1));

        N_place3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place3.setForeground(new java.awt.Color(7, 2, 2));
        N_place3.setText("رقم موبايل");
        pnl1.add(N_place3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, -1, -1));

        phonenumber.setForeground(new java.awt.Color(1, 1, 1));
        phonenumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phonenumber.setColorMaterial(new java.awt.Color(185, 146, 79));
        phonenumber.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        phonenumber.setPlaceholder("");
        phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumberActionPerformed(evt);
            }
        });
        phonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phonenumberKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phonenumberKeyTyped(evt);
            }
        });
        pnl1.add(phonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        N_governnorates_p1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p1.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p1.setText("زمرة دم");
        pnl1.add(N_governnorates_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        cmb_blood.setBackground(new java.awt.Color(254, 254, 254));
        cmb_blood.setForeground(new java.awt.Color(1, 1, 1));
        cmb_blood.setToolTipText("");
        cmb_blood.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_blood.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_blood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_bloodActionPerformed(evt);
            }
        });
        pnl1.add(cmb_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        N_governnorates_p2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p2.setText("عامل الريزوس");
        pnl1.add(N_governnorates_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, -1, -1));

        cmb_States_district.setBackground(new java.awt.Color(254, 254, 254));
        cmb_States_district.setForeground(new java.awt.Color(1, 1, 1));
        cmb_States_district.setToolTipText("");
        cmb_States_district.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_States_district.setEnabled(false);
        cmb_States_district.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_States_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_States_districtActionPerformed(evt);
            }
        });
        pnl1.add(cmb_States_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        N_governnorates_p3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p3.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p3.setText("الأمانة");
        pnl1.add(N_governnorates_p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        N_governnorates_p4.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p4.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p4.setText("مكان القيد");
        pnl1.add(N_governnorates_p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        cmb_States_district_registerplace.setBackground(new java.awt.Color(254, 254, 254));
        cmb_States_district_registerplace.setForeground(new java.awt.Color(1, 1, 1));
        cmb_States_district_registerplace.setToolTipText("");
        cmb_States_district_registerplace.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_States_district_registerplace.setEnabled(false);
        cmb_States_district_registerplace.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_States_district_registerplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_States_district_registerplaceActionPerformed(evt);
            }
        });
        pnl1.add(cmb_States_district_registerplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        cmb_States_district_registerplace_registerno.setBackground(new java.awt.Color(254, 254, 254));
        cmb_States_district_registerplace_registerno.setForeground(new java.awt.Color(1, 1, 1));
        cmb_States_district_registerplace_registerno.setToolTipText("");
        cmb_States_district_registerplace_registerno.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_States_district_registerplace_registerno.setEnabled(false);
        cmb_States_district_registerplace_registerno.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_States_district_registerplace_registerno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_States_district_registerplace_registernoActionPerformed(evt);
            }
        });
        pnl1.add(cmb_States_district_registerplace_registerno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        N_governnorates_p5.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p5.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p5.setText("رقم القيد");
        pnl1.add(N_governnorates_p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        cmb_Jop_title.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Jop_title.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Jop_title.setToolTipText("");
        cmb_Jop_title.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Jop_title.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_Jop_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Jop_titleActionPerformed(evt);
            }
        });
        pnl1.add(cmb_Jop_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        N_governnorates_p6.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p6.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p6.setText("الصفة الوظيفية");
        pnl1.add(N_governnorates_p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        N_governnorates_p7.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p7.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p7.setText("المسمى الوظيفية");
        pnl1.add(N_governnorates_p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        cmb_Jops_description.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Jops_description.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Jops_description.setToolTipText("");
        cmb_Jops_description.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Jops_description.setEnabled(false);
        cmb_Jops_description.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_Jops_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Jops_descriptionActionPerformed(evt);
            }
        });
        pnl1.add(cmb_Jops_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        pnl1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 130, 20));

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        pnl1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 130, 20));

        btn_Exit5.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit5.setText("خروج");
        btn_Exit5.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit5.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit5.setEffectFocus(true);
        btn_Exit5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit5ActionPerformed(evt);
            }
        });
        pnl1.add(btn_Exit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 110, -1));

        firstnamep.setForeground(new java.awt.Color(1, 1, 1));
        firstnamep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstnamep.setColorMaterial(new java.awt.Color(185, 146, 79));
        firstnamep.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        firstnamep.setPlaceholder("");
        firstnamep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstnamepKeyTyped(evt);
            }
        });
        pnl1.add(firstnamep, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        start_date.setDateFormatString("dd-MM-yyyy");
        start_date.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 13)); // NOI18N
        pnl1.add(start_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 250, -1));

        N_brith_date1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_brith_date1.setForeground(new java.awt.Color(7, 2, 2));
        N_brith_date1.setText("تاريخ المباشرة");
        pnl1.add(N_brith_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 420, -1, -1));

        rSPanelsSlider1.add(pnl1, "card2");

        pnl5.setBackground(new java.awt.Color(254, 254, 254));
        pnl5.setName("pnl2"); // NOI18N
        pnl5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_qualification_divisions.setBackground(new java.awt.Color(254, 254, 254));
        cmb_qualification_divisions.setForeground(new java.awt.Color(1, 1, 1));
        cmb_qualification_divisions.setToolTipText("");
        cmb_qualification_divisions.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_qualification_divisions.setEnabled(false);
        cmb_qualification_divisions.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_qualification_divisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_qualification_divisionsActionPerformed(evt);
            }
        });
        pnl5.add(cmb_qualification_divisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        N_work_place_p8.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p8.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p8.setText("أختصاص الشهادة");
        pnl5.add(N_work_place_p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        N_work_place_p9.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p9.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p9.setText("أسم الشهادة");
        pnl5.add(N_work_place_p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        cmb_Qualification_Name.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Qualification_Name.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Qualification_Name.setToolTipText("");
        cmb_Qualification_Name.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Qualification_Name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Qualification_Name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Qualification_NameItemStateChanged(evt);
            }
        });
        cmb_Qualification_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Qualification_NameActionPerformed(evt);
            }
        });
        pnl5.add(cmb_Qualification_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        N_work_place_p10.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p10.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p10.setText("المديرية");
        pnl5.add(N_work_place_p10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 330, -1, -1));

        cmb_Directorates.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Directorates.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Directorates.setToolTipText("");
        cmb_Directorates.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Directorates.setEnabled(false);
        cmb_Directorates.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Directorates.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_DirectoratesItemStateChanged(evt);
            }
        });
        cmb_Directorates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_DirectoratesActionPerformed(evt);
            }
        });
        pnl5.add(cmb_Directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 330, -1, -1));

        cmb_department.setBackground(new java.awt.Color(254, 254, 254));
        cmb_department.setForeground(new java.awt.Color(1, 1, 1));
        cmb_department.setToolTipText("");
        cmb_department.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_department.setEnabled(false);
        cmb_department.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departmentActionPerformed(evt);
            }
        });
        pnl5.add(cmb_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, -1, -1));

        N_work_place_p11.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p11.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p11.setText("الوزارة");
        pnl5.add(N_work_place_p11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 280, -1, -1));

        cmb_Ministry.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Ministry.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Ministry.setToolTipText("");
        cmb_Ministry.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Ministry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Ministry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_MinistryItemStateChanged(evt);
            }
        });
        cmb_Ministry.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_MinistryInputMethodTextChanged(evt);
            }
        });
        cmb_Ministry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_MinistryActionPerformed(evt);
            }
        });
        pnl5.add(cmb_Ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 270, -1, -1));

        N_work_place_p12.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p12.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p12.setText("الدائرة");
        pnl5.add(N_work_place_p12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 380, -1, -1));

        jLabel9.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("بيانات الوظيفة");
        pnl5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        cmb_Divisions.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Divisions.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Divisions.setToolTipText("");
        cmb_Divisions.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Divisions.setEnabled(false);
        cmb_Divisions.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Divisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_DivisionsActionPerformed(evt);
            }
        });
        pnl5.add(cmb_Divisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, -1, -1));

        N_work_place_p13.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p13.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p13.setText("الشعبة");
        pnl5.add(N_work_place_p13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 430, -1, -1));

        N_work_place_p14.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p14.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p14.setText("نوع الشهادة");
        pnl5.add(N_work_place_p14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        cmb_Qualification_Type.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Qualification_Type.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Qualification_Type.setToolTipText("");
        cmb_Qualification_Type.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Qualification_Type.setEnabled(false);
        cmb_Qualification_Type.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Qualification_Type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_Qualification_TypeItemStateChanged(evt);
            }
        });
        cmb_Qualification_Type.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_Qualification_TypeInputMethodTextChanged(evt);
            }
        });
        cmb_Qualification_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Qualification_TypeActionPerformed(evt);
            }
        });
        pnl5.add(cmb_Qualification_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        btn_Exit6.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit6.setText("إضافة موظف");
        btn_Exit6.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit6.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit6.setEffectFocus(true);
        btn_Exit6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit6ActionPerformed(evt);
            }
        });
        pnl5.add(btn_Exit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 120, -1));

        id_jop_change.setBackground(new java.awt.Color(254, 254, 254));
        id_jop_change.setForeground(new java.awt.Color(1, 1, 1));
        id_jop_change.setToolTipText("");
        id_jop_change.setColorMaterial(new java.awt.Color(185, 146, 79));
        id_jop_change.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        id_jop_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_jop_changeActionPerformed(evt);
            }
        });
        pnl5.add(id_jop_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        N_job_change_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p.setText("تغيرات الوظيفية");
        pnl5.add(N_job_change_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        btn_Exit2.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit2.setText("خطوة سابقة");
        btn_Exit2.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit2.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit2.setEffectFocus(true);
        btn_Exit2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit2ActionPerformed(evt);
            }
        });
        pnl5.add(btn_Exit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 120, -1));

        work_city1.setBackground(new java.awt.Color(254, 254, 254));
        work_city1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "مكان السكن", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        work_city1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        work_city1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        current_work_city_governorate.setBackground(new java.awt.Color(254, 254, 254));
        current_work_city_governorate.setForeground(new java.awt.Color(1, 1, 1));
        current_work_city_governorate.setToolTipText("");
        current_work_city_governorate.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_work_city_governorate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_work_city_governorate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_work_city_governorateActionPerformed(evt);
            }
        });
        work_city1.add(current_work_city_governorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        N_job_change_p2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p2.setText("المحافظة");
        work_city1.add(N_job_change_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        N_work_place_p18.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p18.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p18.setText("المنطقة");
        work_city1.add(N_work_place_p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        current_work_city_district.setBackground(new java.awt.Color(254, 254, 254));
        current_work_city_district.setForeground(new java.awt.Color(1, 1, 1));
        current_work_city_district.setToolTipText("");
        current_work_city_district.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_work_city_district.setEnabled(false);
        current_work_city_district.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_work_city_district.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                current_work_city_districtItemStateChanged(evt);
            }
        });
        current_work_city_district.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                current_work_city_districtComponentHidden(evt);
            }
        });
        current_work_city_district.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                current_work_city_districtInputMethodTextChanged(evt);
            }
        });
        current_work_city_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_work_city_districtActionPerformed(evt);
            }
        });
        work_city1.add(current_work_city_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        current_work_city_sub_district.setBackground(new java.awt.Color(254, 254, 254));
        current_work_city_sub_district.setForeground(new java.awt.Color(1, 1, 1));
        current_work_city_sub_district.setToolTipText("");
        current_work_city_sub_district.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_work_city_sub_district.setEnabled(false);
        current_work_city_sub_district.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_work_city_sub_district.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                current_work_city_sub_districtItemStateChanged(evt);
            }
        });
        current_work_city_sub_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_work_city_sub_districtActionPerformed(evt);
            }
        });
        work_city1.add(current_work_city_sub_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        N_work_place_p19.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p19.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p19.setText("الناحية");
        work_city1.add(N_work_place_p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        N_work_place_p20.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p20.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p20.setText("البلدة");
        work_city1.add(N_work_place_p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        current_work_city_community.setBackground(new java.awt.Color(254, 254, 254));
        current_work_city_community.setForeground(new java.awt.Color(1, 1, 1));
        current_work_city_community.setToolTipText("");
        current_work_city_community.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_work_city_community.setEnabled(false);
        current_work_city_community.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_work_city_community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_work_city_communityActionPerformed(evt);
            }
        });
        work_city1.add(current_work_city_community, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        pnl5.add(work_city1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 320, 240));

        btn_search.setBackground(new java.awt.Color(185, 146, 79));
        btn_search.setText("البحث");
        btn_search.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_search.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_search.setEffectFocus(true);
        btn_search.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        pnl5.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, -1));

        work_city.setBackground(new java.awt.Color(254, 254, 254));
        work_city.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "مكان العمل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        work_city.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        work_city.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        current_city_governorate.setBackground(new java.awt.Color(254, 254, 254));
        current_city_governorate.setForeground(new java.awt.Color(1, 1, 1));
        current_city_governorate.setToolTipText("");
        current_city_governorate.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_city_governorate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_city_governorate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_city_governorateActionPerformed(evt);
            }
        });
        work_city.add(current_city_governorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        N_job_change_p1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p1.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p1.setText("المحافظة");
        work_city.add(N_job_change_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        N_work_place_p15.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p15.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p15.setText("المنطقة");
        work_city.add(N_work_place_p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        current_city_district.setBackground(new java.awt.Color(254, 254, 254));
        current_city_district.setForeground(new java.awt.Color(1, 1, 1));
        current_city_district.setToolTipText("");
        current_city_district.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_city_district.setEnabled(false);
        current_city_district.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_city_district.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                current_city_districtItemStateChanged(evt);
            }
        });
        current_city_district.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                current_city_districtInputMethodTextChanged(evt);
            }
        });
        current_city_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_city_districtActionPerformed(evt);
            }
        });
        work_city.add(current_city_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        current_city_sub_district.setBackground(new java.awt.Color(254, 254, 254));
        current_city_sub_district.setForeground(new java.awt.Color(1, 1, 1));
        current_city_sub_district.setToolTipText("");
        current_city_sub_district.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_city_sub_district.setEnabled(false);
        current_city_sub_district.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_city_sub_district.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                current_city_sub_districtItemStateChanged(evt);
            }
        });
        current_city_sub_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_city_sub_districtActionPerformed(evt);
            }
        });
        work_city.add(current_city_sub_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        N_work_place_p16.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p16.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p16.setText("الناحية");
        work_city.add(N_work_place_p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        N_work_place_p17.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p17.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p17.setText("البلدة");
        work_city.add(N_work_place_p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        current_city_community.setBackground(new java.awt.Color(254, 254, 254));
        current_city_community.setForeground(new java.awt.Color(1, 1, 1));
        current_city_community.setToolTipText("");
        current_city_community.setColorMaterial(new java.awt.Color(185, 146, 79));
        current_city_community.setEnabled(false);
        current_city_community.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        current_city_community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_city_communityActionPerformed(evt);
            }
        });
        work_city.add(current_city_community, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        pnl5.add(work_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 310, 240));

        btn_Exit7.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit7.setText("خروج");
        btn_Exit7.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit7.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit7.setEffectFocus(true);
        btn_Exit7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit7ActionPerformed(evt);
            }
        });
        pnl5.add(btn_Exit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 80, -1));

        rSPanelsSlider1.add(pnl5, "card7");

        pnl2.setBackground(new java.awt.Color(254, 254, 254));
        pnl2.setName("pnl2"); // NOI18N
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Exit3.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit3.setText("إضافة موظف");
        btn_Exit3.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit3.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit3.setEffectFocus(true);
        btn_Exit3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit3ActionPerformed(evt);
            }
        });
        pnl2.add(btn_Exit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 120, -1));

        rSPanelsSlider1.add(pnl2, "card3");

        pnl3.setBackground(new java.awt.Color(255, 255, 255));
        pnl3.setName("pnl3"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/success (2).png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("تم الإضافة موظف بنجاح");

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(jLabel5)
                .addContainerGap(393, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnl3, "card4");

        pnl4.setBackground(new java.awt.Color(255, 255, 255));
        pnl4.setName("pnl4"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/error (2).png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("تم الإضافة موظف مسبقاً");

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnl4, "card5");

        pnl6.setBackground(new java.awt.Color(255, 255, 255));
        pnl6.setName("pnl4"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/error (2).png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("تم الإضافة موظفqqqqqqqqqqq مسبقاً");

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnl6, "card5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1350, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AddEm.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_social_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_social_statusActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_id_social_statusActionPerformed

    private void governnorates_StatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_governnorates_StatesActionPerformed
        cmb_States_district.setEnabled(true);
        fill_district();
        // TODO add your handling code here:
    }//GEN-LAST:event_governnorates_StatesActionPerformed

    private void cmb_type_of_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_type_of_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_type_of_docActionPerformed

    private void id_jop_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_jop_changeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_jop_changeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

       
    }//GEN-LAST:event_formWindowOpened

    private void btn_Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit1ActionPerformed

        rSPanelsSlider1.slidPanel(20, pnl5, RSPanelsSlider.direct.Right);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Exit1ActionPerformed

    private void btn_Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit2ActionPerformed
        rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Left);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Exit2ActionPerformed

    private void btn_Exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit3ActionPerformed

    }//GEN-LAST:event_btn_Exit3ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
     
        m_view_employee model = new m_view_employee();
      

      if(idnumber.getSelectedText() !=null){
          model.setId_number(Integer.valueOf(idnumber.getText()));
      }
      if(phonenumber.getSelectedText() != null){
           model.setPhonenumer(Integer.valueOf(phonenumber.getText()));
      }
      if(txt_id.getText() != null){
          model.setTxt_id_emp(txt_id.getText());
      }
      if(firstnamep.getText() != null){
           model.setFname(firstnamep.getText());
      }
      if(middlename.getText()!= null){
          model.setMname(middlename.getText());
      }
     if(lastname.getText() !=null){
         model.setLname(lastname.getText());
     }
     
      
      
      model.setFictitiousname(txt_nature_name.getText());
      model.setMother_fullname(motherfullname.getText());
      model.setBrith_date(txt_brith_date.getDate());
      
      
       if (id_social_status.getSelectedIndex() != -1) {
          model.setSocial_status_name(((Model_Tables) id_social_status.getSelectedItem()).getColumn_Id()+""); 
        }
       if (cmb_Divisions.getSelectedIndex() != -1) {
            model.setWork_place_divisions(((M_Divisions) cmb_Divisions.getSelectedItem()).getId_divisions()+"");
        }
   if (cmb_Ministry.getSelectedIndex() != -1) {
           model.setWork_place_ministry(((Model.M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry()+ "");
        }
   
    if (cmb_Directorates.getSelectedIndex() != -1) {
           model.setWork_place_directorates(((Model.M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates()+"");
        }
        if (cmb_department.getSelectedIndex() != -1) {
            model.setWork_place_department(((Model.M_Department) cmb_department.getSelectedItem()).getId_department()+"");
        }
        
        
        if (cmb_qualification_divisions.getSelectedIndex() != -1) {
            model.setQualification_divisions(((Model.M_Qualification_Division) cmb_qualification_divisions.getSelectedItem()).getId_Division()+ "");
        }

        if (cmb_Qualification_Type.getSelectedIndex() != -1) {
            model.setQualification_type(((Model.M_Qualification_Type) cmb_Qualification_Type.getSelectedItem()).getId_type()+"");
        }
        if (cmb_Qualification_Name.getSelectedIndex() != -1) {
            model.setQualification_name(((Model.M_Qualification_Name) cmb_Qualification_Name.getSelectedItem()).getId_Name()+"");
        }
        
        
           
        if (current_city_community.getSelectedIndex() != -1) {
            model.setCurrent_city_community(((Model.m_work_city) current_city_community.getSelectedItem()).getId()+"");
        }
        if (current_city_sub_district.getSelectedIndex() != -1) {
        model.setCurrent_city_sub_district(((Model.m_work_city) current_city_sub_district.getSelectedItem()).getId_sub_district()+"");
        }
        if (current_city_district.getSelectedIndex() != -1) {
          model.setCurrent_city_district(((Model.m_work_city) current_city_district.getSelectedItem()).getId_district()+"");
        }
        if (current_city_district.getSelectedIndex() != -1) {
            model.setCurrent_city_governorate( ((Model.m_work_city) current_city_governorate.getSelectedItem()).getId_governorate()+"");
        }
        
        
       if (current_work_city_community.getSelectedIndex() != -1) {
        model.setCurrent_work_city_community(((Model.m_work_city) current_work_city_community.getSelectedItem()).getId_community()+"");
        }
        if (current_work_city_sub_district.getSelectedIndex() != -1) {
           model.setCurrent_work_city_sub_district( ((Model.m_work_city) current_work_city_sub_district.getSelectedItem()).getId_sub_district()+"");
        }
        if (current_work_city_district.getSelectedIndex() != -1) {
            model.setCurrent_work_city_district(((Model.m_work_city) current_work_city_district.getSelectedItem()).getId_district()+ "");
        }
        if (current_work_city_governorate.getSelectedIndex() != -1) {
             model.setCurrent_work_city_governorate(((Model.m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate()+"");
        }
        
        
        
        if (cmb_type_of_doc.getSelectedIndex() != -1) {
         model.setType_of_doc_name(((Model.Model_Tables) cmb_type_of_doc.getSelectedItem()).getColumn_Id()+"");
        }
        if (cmb_Jop_title.getSelectedIndex() != -1) {
             model.setJop_title( ((Model.m_jops) cmb_Jop_title.getSelectedItem()).getTitle()+"");
        }
        if (cmb_Jops_description.getSelectedIndex() != -1) {
           model.setJops_description( ((Model.m_jops) cmb_Jops_description.getSelectedItem()).getId()+"");
        }
        if (cmb_blood.getSelectedIndex() != -1) {
         model.setBlood_name(((Model.Model_Tables) cmb_blood.getSelectedItem()).getColumn_Id()+"");
        }
        
        
             if (governnorates_States.getSelectedItem() != null) {
           model.setStates(((Model.Model_Tables) governnorates_States.getSelectedItem()).getColumn_Id()+"");
        }
        if (cmb_States_district.getSelectedItem() != null) {
            model.setDistrict(((Model.m_district) cmb_States_district.getSelectedItem()).getId()+ "");
        }
        if (cmb_States_district_registerplace.getSelectedItem() != null) {
            model.setRegisterplace(((Model.m_registerplace) cmb_States_district_registerplace.getSelectedItem()).getId()+"");
        }
        if (cmb_States_district_registerplace_registerno.getSelectedItem() != null) {
            model.setRegisterno(((Model.m_registerno) cmb_States_district_registerplace_registerno.getSelectedItem()).getId()+"");
        }
        if (id_jop_change.getSelectedItem() != null) {
            model.setJop_change(((Model.Model_Tables) id_jop_change.getSelectedItem()).getColumn_Id()+"");
        }
     
   
    
      model.setStart_date(start_date.getDate());
      

      
      

        Lists_Meun.array_search  =  Lists_Meun.search_emp.search_employees_all(model);
        
        DefaultTableModel modle = new DefaultTableModel();

        modle.setColumnIdentifiers(new Object[]{"رقم القيد", "مكان القيد", "الأمانة", "المحافظة ", "زمرة دم", " الصفة وظيفية", "المسمى وظيفية", "الوثائق الشخصية", " المحافظة (مكان العمل)", "المنطقة2", "الناحية3", "البلدة4", "المحافظة", "المنطقة",
            "الناحية", "البلدة", "نوع شهادة", "الاسم شهادة", "أختصاص الشهادة", "الوزارة", "المديرية", "الدائرة", "الشعبة", "عامل الريزوس",
            "رقم موبايل", "رقم بطاقة", "حالة البيانات", "الحالة الأجتماعية", "الجنس", "تاريخ ", "الاسم الأم", "الاسم وهمي", "الاسم حقيقي أو وهمي",
            "الكنية", "الاسم الاب ", "الاسم موظف","تغيرات الوظيفية","تاريخ مباشرة","اسم مدخل البيانات","تاريخ مدخل"," اسم مدقيق البيانات","تاريخ مدقيق","رقم موظف"});

        Object[] row = new Object[43];
        for (int i = 0; i < Lists_Meun.array_search .size(); i++) {
                row[42] = Lists_Meun.array_search .get(i).getId_emp();
             row[41] = Lists_Meun.array_search .get(i).getDate_check();
             row[40] = Lists_Meun.array_search .get(i).getUser_checker();
             row[39] = Lists_Meun.array_search .get(i).getDate_entrytime();
             row[38] = Lists_Meun.array_search .get(i).getData_entry();
             row[37] = Lists_Meun.array_search .get(i).getStart_date();//لسا
             row[36] = Lists_Meun.array_search .get(i).getJop_change();//لسا
            row[0] = Lists_Meun.array_search .get(i).getRegisterno();
            row[1] = Lists_Meun.array_search .get(i).getRegisterplace();
            row[2] = Lists_Meun.array_search .get(i).getDistrict();
            row[3] = Lists_Meun.array_search .get(i).getStates();
            row[4] = Lists_Meun.array_search .get(i).getBlood_name();
            row[5] = Lists_Meun.array_search .get(i).getJop_title();
            row[6] = Lists_Meun.array_search .get(i).getJops_description();
            row[7] = Lists_Meun.array_search .get(i).getType_of_doc_name();
            row[8] = Lists_Meun.array_search .get(i).getCurrent_work_city_governorate();// المحافظة  مكان السكن
            row[9] = Lists_Meun.array_search .get(i).getCurrent_work_city_district();// منطقة  مكان السكن
            row[10] = Lists_Meun.array_search .get(i).getCurrent_work_city_sub_district();// ناحية  مكان السكن
            row[11] = Lists_Meun.array_search .get(i).getCurrent_work_city_community();// البلدة  مكان السكن
            row[12] = Lists_Meun.array_search .get(i).getCurrent_city_governorate(); // المحافظة  مكان العمل
             row[13] = Lists_Meun.array_search .get(i).getCurrent_city_district();// منطقة  مكان العمل
            row[14] = Lists_Meun.array_search .get(i).getCurrent_city_sub_district();// ناحية  مكان العمل
            row[15] = Lists_Meun.array_search .get(i).getCurrent_city_community();// البلدة  مكان العمل  
            row[16] = Lists_Meun.array_search .get(i).getQualification_name();
            row[17] = Lists_Meun.array_search .get(i).getQualification_type();
            row[18] = Lists_Meun.array_search .get(i).getQualification_divisions();
            row[19] = Lists_Meun.array_search .get(i).getWork_place_ministry();
            row[20] = Lists_Meun.array_search .get(i).getWork_place_directorates();
            row[21] = Lists_Meun.array_search .get(i).getWork_place_department();
            row[22] = Lists_Meun.array_search .get(i).getWork_place_divisions();
            row[23] = Lists_Meun.array_search .get(i).isRh();
            row[24] = Lists_Meun.array_search .get(i).getPhonenumer();
            row[25] = Lists_Meun.array_search .get(i).getId_number();
            row[26] = Lists_Meun.array_search .get(i).getState_of_data_name();//لسا    
            row[27] = Lists_Meun.array_search .get(i).getSocial_status_name();
            row[28] = Lists_Meun.array_search .get(i).isSex();
            row[29] = Lists_Meun.array_search .get(i).getBrith_date();
            row[30] = Lists_Meun.array_search .get(i).getMother_fullname();
            row[31] = Lists_Meun.array_search .get(i).getFictitiousname();
            row[32] = Lists_Meun.array_search .get(i).isNature_of_name();
            row[33] = Lists_Meun.array_search .get(i).getLname();
            row[34] = Lists_Meun.array_search .get(i).getMname();
            row[35] = Lists_Meun.array_search .get(i).getFname();
            modle.addRow(row);  
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

        }

        frm_view.table_emp.setModel(modle);
      
   haded();

      frm_view.setVisible(true);
      
      
      
      
      
      
      
      
        
        
        
       
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_Exit6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit6ActionPerformed

    }//GEN-LAST:event_btn_Exit6ActionPerformed

    private void cmb_Qualification_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Qualification_NameActionPerformed
        cmb_Qualification_Type.setEnabled(true);
        Qualification_Type();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_NameActionPerformed

    private void cmb_Qualification_NameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Qualification_NameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_NameItemStateChanged

    private void cmb_DivisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DivisionsActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_DivisionsActionPerformed

    private void cmb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departmentActionPerformed
        cmb_Divisions.setEnabled(true);
        try {
            fullDivi();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(frmGeneralsearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_departmentActionPerformed

    private void cmb_qualification_divisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_qualification_divisionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_qualification_divisionsActionPerformed

    private void cmb_MinistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_MinistryActionPerformed
        cmb_Directorates.setEnabled(true);
        full_Direct();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_MinistryActionPerformed

    private void cmb_MinistryInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmb_MinistryInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_MinistryInputMethodTextChanged

    private void cmb_MinistryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_MinistryItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_MinistryItemStateChanged

    private void cmb_DirectoratesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DirectoratesActionPerformed
        cmb_department.setEnabled(true);
        fullDept();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_DirectoratesActionPerformed

    private void cmb_DirectoratesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_DirectoratesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_DirectoratesItemStateChanged

    private void current_city_governorateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_city_governorateActionPerformed
current_city_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        view_district_work_city();
        current_city_district.setEnabled(true);
          
    }//GEN-LAST:event_current_city_governorateActionPerformed

    private void cmb_Qualification_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Qualification_TypeActionPerformed
        cmb_qualification_divisions.setEnabled(true);
        Qualification_division();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_TypeActionPerformed

    private void cmb_Qualification_TypeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmb_Qualification_TypeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_TypeInputMethodTextChanged

    private void cmb_Qualification_TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Qualification_TypeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_TypeItemStateChanged

    private void cmb_bloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_bloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_bloodActionPerformed

    private void current_city_districtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_current_city_districtItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_districtItemStateChanged

    private void current_city_districtInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_current_city_districtInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_districtInputMethodTextChanged

    private void current_city_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_city_districtActionPerformed
        current_city_sub_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        view_sub_district_work_city();
        current_city_sub_district.setEnabled(true);
        if(current_city_sub_district.getSelectedItem() == null){
           current_city_community.removeAllItems();
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_districtActionPerformed

    private void current_city_sub_districtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_current_city_sub_districtItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_sub_districtItemStateChanged

    private void current_city_sub_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_city_sub_districtActionPerformed
current_city_community.setModel(new DefaultComboBoxModel(new Integer[0]));

        current_city_community.setEnabled(true);
        view_work_city_community();
        
        
    
        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_sub_districtActionPerformed

    private void current_city_communityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_city_communityActionPerformed
       

        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_communityActionPerformed

    private void cmb_States_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_States_districtActionPerformed
        cmb_States_district_registerplace.setEnabled(true);
        full_registerplace();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_districtActionPerformed

    private void cmb_States_district_registerplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_States_district_registerplaceActionPerformed
        cmb_States_district_registerplace_registerno.setEnabled(true);
        full_registerno();
// TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_district_registerplaceActionPerformed

    private void cmb_States_district_registerplace_registernoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_States_district_registerplace_registernoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_district_registerplace_registernoActionPerformed

    private void cmb_Jop_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Jop_titleActionPerformed
        cmb_Jops_description.setEnabled(true);
        full_jops_description();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Jop_titleActionPerformed

    private void cmb_Jops_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Jops_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Jops_descriptionActionPerformed

    private void idnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnumberKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_idnumberKeyTyped

    private void phonenumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonenumberKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_phonenumberKeyTyped

    private void phonenumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonenumberKeyPressed
        try {
            int i = Integer.valueOf(phonenumber.getText());
            jLabel2.setText("");
        } catch (NumberFormatException e) {

            jLabel2.setText("الرجاء أدخل رقم فقط");
        }
    }//GEN-LAST:event_phonenumberKeyPressed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumberActionPerformed

    private void idnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnumberKeyPressed
        try {
            int i = Integer.valueOf(idnumber.getText());
            jLabel21.setText("");
        } catch (NumberFormatException e) {

            jLabel21.setText("الرجاء أدخل رقم فقط");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_idnumberKeyPressed

    private void txt_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idKeyTyped

    private void current_work_city_governorateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_work_city_governorateActionPerformed
current_work_city_district.setModel(new DefaultComboBoxModel(new Integer[0]));
view_district_current_city();
current_work_city_district.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_governorateActionPerformed

    private void current_work_city_districtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_current_work_city_districtItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_districtItemStateChanged

    private void current_work_city_districtInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_current_work_city_districtInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_districtInputMethodTextChanged

    private void current_work_city_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_work_city_districtActionPerformed
 current_work_city_sub_district.setModel(new DefaultComboBoxModel(new Integer[0]));
view_sub_district_current_city();
current_work_city_sub_district.setEnabled(true);
if(current_work_city_sub_district.getSelectedItem() == null){
           current_work_city_community.removeAllItems();
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_districtActionPerformed

    private void current_work_city_sub_districtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_current_work_city_sub_districtItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_sub_districtItemStateChanged

    private void current_work_city_sub_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_work_city_sub_districtActionPerformed
current_work_city_community.setModel(new DefaultComboBoxModel(new Integer[0]));
        view_current_city_community();
current_work_city_community.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_sub_districtActionPerformed

    private void current_work_city_communityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_work_city_communityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_communityActionPerformed

    private void current_work_city_districtComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_current_work_city_districtComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_districtComponentHidden

    private void btn_Exit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit5ActionPerformed
      this.dispose();
    }//GEN-LAST:event_btn_Exit5ActionPerformed

    private void btn_Exit7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit7ActionPerformed

  this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Exit7ActionPerformed

    private void firstnamepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnamepKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnamepKeyTyped

    /**
     * 4
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmGeneralsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGeneralsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGeneralsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGeneralsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGeneralsearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N_brith_date;
    private javax.swing.JLabel N_brith_date1;
    private javax.swing.JLabel N_fname;
    private javax.swing.JLabel N_governnorates_p;
    private javax.swing.JLabel N_governnorates_p1;
    private javax.swing.JLabel N_governnorates_p2;
    private javax.swing.JLabel N_governnorates_p3;
    private javax.swing.JLabel N_governnorates_p4;
    private javax.swing.JLabel N_governnorates_p5;
    private javax.swing.JLabel N_governnorates_p6;
    private javax.swing.JLabel N_governnorates_p7;
    private javax.swing.JLabel N_job_change_p;
    private javax.swing.JLabel N_job_change_p1;
    private javax.swing.JLabel N_job_change_p2;
    private javax.swing.JLabel N_lname;
    private javax.swing.JLabel N_mname;
    private javax.swing.JLabel N_mother_name;
    private javax.swing.JLabel N_place;
    private javax.swing.JLabel N_place2;
    private javax.swing.JLabel N_place3;
    private javax.swing.JLabel N_socil_status_p;
    private javax.swing.JLabel N_type_of_doc_p;
    private javax.swing.JLabel N_work_place_p10;
    private javax.swing.JLabel N_work_place_p11;
    private javax.swing.JLabel N_work_place_p12;
    private javax.swing.JLabel N_work_place_p13;
    private javax.swing.JLabel N_work_place_p14;
    private javax.swing.JLabel N_work_place_p15;
    private javax.swing.JLabel N_work_place_p16;
    private javax.swing.JLabel N_work_place_p17;
    private javax.swing.JLabel N_work_place_p18;
    private javax.swing.JLabel N_work_place_p19;
    private javax.swing.JLabel N_work_place_p20;
    private javax.swing.JLabel N_work_place_p8;
    private javax.swing.JLabel N_work_place_p9;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit1;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit2;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit3;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit5;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit6;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit7;
    private RSMaterialComponent.RSButtonMaterialShadow btn_search;
    public javax.swing.ButtonGroup buttonGroup1;
    public RSMaterialComponent.RSCheckBoxMaterial chk_rhp;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Directorates> cmb_Directorates;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Divisions> cmb_Divisions;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_jops> cmb_Jop_title;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_jops> cmb_Jops_description;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Ministry> cmb_Ministry;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Qualification_Name> cmb_Qualification_Name;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Qualification_Type> cmb_Qualification_Type;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_district> cmb_States_district;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_registerplace> cmb_States_district_registerplace;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_registerno> cmb_States_district_registerplace_registerno;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> cmb_blood;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Department> cmb_department;
    public RSMaterialComponent.RSComboBoxMaterial<Model.M_Qualification_Division> cmb_qualification_divisions;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> cmb_type_of_doc;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_city_community;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_city_district;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_city_governorate;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_city_sub_district;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_work_city_community;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_work_city_district;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_work_city_governorate;
    public RSMaterialComponent.RSComboBoxMaterial<Model.m_work_city> current_work_city_sub_district;
    public RSMaterialComponent.RSTextFieldMaterial firstnamep;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> governnorates_States;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> id_jop_change;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> id_social_status;
    public RSMaterialComponent.RSTextFieldMaterial idnumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public RSMaterialComponent.RSTextFieldMaterial lastname;
    public RSMaterialComponent.RSTextFieldMaterial middlename;
    public RSMaterialComponent.RSTextFieldMaterial motherfullname;
    public RSMaterialComponent.RSTextFieldMaterial phonenumber;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnl6;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    public com.toedter.calendar.JDateChooser start_date;
    public com.toedter.calendar.JDateChooser txt_brith_date;
    public RSMaterialComponent.RSTextFieldMaterial txt_id;
    public RSMaterialComponent.RSTextFieldMaterial txt_nature_name;
    private javax.swing.JPanel work_city;
    private javax.swing.JPanel work_city1;
    // End of variables declaration//GEN-END:variables
}
