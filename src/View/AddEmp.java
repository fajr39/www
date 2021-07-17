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
import Model.MessageType;
import Model.Model_Tables;
import Model.m_district;
import Model.m_jops;
import Model.m_registerno;
import Model.m_registerplace;
import Model.m_work_city;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author ahmad-soft
 */
public class AddEmp extends javax.swing.JFrame {

    Model.M_Add_employee model;
    Control.C_employee ctrl;
    Timer t;

    /**
     * Creates new form AddEmp
     */
    public AddEmp() {

        initComponents();
//start_date.setLocale(Locale.forLanguageTag("ar-SY"));
        txt_id.setVisible(false);
        btn_Dataconfirmation.setVisible(false);
        init_comboboxes();
        setLocationRelativeTo(null);

        txt_nature_name.setVisible(false);
        N_place.setVisible(false);
        model = new M_Add_employee();
        ctrl = new C_employee();
        fillCombobox();
    }

    public void fillCombobox() {

        Lists_Meun.Array_c_social_status = Lists_Meun.c_social_status.filltable("social_status");
        DefaultComboBoxModel model = (DefaultComboBoxModel) id_social_status.getModel();
        model.removeAllElements();
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

        Lists_Meun.Array_governnorates_1 = Lists_Meun.C_governnorates_1.filltable("state");
        DefaultComboBoxModel model53 = (DefaultComboBoxModel) governnorates_States.getModel();
        model53.removeAllElements();
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
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmb_Directorates.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Direct);

    }

    public void fullDept() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        Lists_Meun.A_Department = Lists_Meun.C_Department.viewDepartment(id_Direct, id_Ministry);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmb_department.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Department);

    }

    public void fullDivi() throws SQLException {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        int id_Div = ((M_Department) cmb_department.getSelectedItem()).getId_department();
        Lists_Meun.A_Division = Lists_Meun.C_Division.viewDepartment(id_Direct, id_Ministry, id_Div);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmb_Divisions.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.A_Division);

    }

    public void Qualification_Type() {
        int id_Direct = ((M_Qualification_Name) cmb_Qualification_Name.getSelectedItem()).getId_Name();
        Lists_Meun.Array_Qual_Type = Lists_Meun.Qual_Type.view_Qualification_Type(id_Direct);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmb_Qualification_Type.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.Array_Qual_Type);

    }

    public void Qualification_division() {
        int id_tyep = ((M_Qualification_Type) cmb_Qualification_Type.getSelectedItem()).getId_type();
        int id_Nam = ((M_Qualification_Name) cmb_Qualification_Name.getSelectedItem()).getId_Name();
        Lists_Meun.Array_Qual_Division = Lists_Meun.Qual_Division.view_Qualification_Division(id_Nam, id_tyep);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cmb_qualification_divisions.getModel();
        model.removeAllElements();
        model.addAll(Lists_Meun.Array_Qual_Division);

    }

    public void view_district_work_city() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        Lists_Meun.Array_district_work_city = Lists_Meun.C_district_work_city.view_district_work_city(id_governorate);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) current_city_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_district_work_city);

    }

    public void view_district_current_city() {
        int id_governorate = ((m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate();
        Lists_Meun.Array_district_work_city = Lists_Meun.C_district_work_city.view_district_work_city(id_governorate);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) current_work_city_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_district_work_city);

    }

    public void view_sub_district_work_city() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        int id_district = ((m_work_city) current_city_district.getSelectedItem()).getId_district();
        Lists_Meun.Array_sub_district_work_city = Lists_Meun.C_sub_district_work_city.view_sub_district_work_city(id_governorate, id_district);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) current_city_sub_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_sub_district_work_city);

    }

    public void view_sub_district_current_city() {
        int id_governorate1 = ((m_work_city) current_work_city_governorate.getSelectedItem()).getId_governorate();
        int id_district1 = ((m_work_city) current_work_city_district.getSelectedItem()).getId_district();
        Lists_Meun.Array_sub_district_work_city = Lists_Meun.C_sub_district_work_city.view_sub_district_work_city(id_governorate1, id_district1);
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) current_work_city_sub_district.getModel();
        model1.removeAllElements();
        model1.addAll(Lists_Meun.Array_sub_district_work_city);

    }

    public void view_work_city_community() {
        int id_governorate = ((m_work_city) current_city_governorate.getSelectedItem()).getId_governorate();
        int id_district = ((m_work_city) current_city_district.getSelectedItem()).getId_district();
        int id_community = ((m_work_city) current_city_sub_district.getSelectedItem()).getId_sub_district();
        Lists_Meun.Array_work_city_community = Lists_Meun.C_work_city_community.viewcommunity_work_city(id_governorate, id_district, id_community);
        DefaultComboBoxModel modle1 = (DefaultComboBoxModel) current_city_community.getModel();
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
        DefaultComboBoxModel modle13 = (DefaultComboBoxModel) cmb_States_district.getModel();
        // modle13.removeAllElements();
        modle13.addAll(Lists_Meun.Array_district);
        //    cmb_States_district.setModel(new DefaultComboBoxModel());
    }

    public void full_registerplace() {
        int id_district = ((m_district) cmb_States_district.getSelectedItem()).getId();
        Lists_Meun.Array_registerplace = Lists_Meun.C_registerplace.view_registerplace(id_district);
        cmb_States_district_registerplace.setModel(new DefaultComboBoxModel(Lists_Meun.Array_registerplace.toArray()));
    }

    public void full_registerno() {
        //  int id_district = ((m_district) cmb_States_district.getSelectedItem()).getId();
        int id_registerplace = ((m_registerplace) cmb_States_district_registerplace.getSelectedItem()).getId();
        //  Lists_Meun.Array_registerno = Lists_Meun.C_registerno.view_registeno(12,643);
        Lists_Meun.Array_registerno = Lists_Meun.C_registerno.view_registeno(id_registerplace);
        cmb_States_district_registerplace_registerno.setModel(new DefaultComboBoxModel(Lists_Meun.Array_registerno.toArray()));
    }

    public void full_jops_description() {
        int id_jops1 = ((m_jops) cmb_Jop_title.getSelectedItem()).getTitle();
        Lists_Meun.Array_jops_description = Lists_Meun.C_jops_description.view_jops_description(id_jops1);
        cmb_Jops_description.setModel(new DefaultComboBoxModel(Lists_Meun.Array_jops_description.toArray()));
    }

    public void init_comboboxes() {
        firstnamep.setText("");
        middlename.setText("");
        lastname.setText("");
        motherfullname.setText("");
        txt_nature_name.setText("");
        idnumber.setText("");
        phonenumber.setText("");
        chk_rhp.setSelected(false);

        nature_name.setSelected(false);
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
//        current_city_sub_district.setModel(new DefaultComboBoxModel(new Integer[0]));
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
        N_nature = new javax.swing.JLabel();
        governnorates_States = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_governnorates_p = new javax.swing.JLabel();
        id_social_status = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_socil_status_p = new javax.swing.JLabel();
        txt_brith_date = new com.toedter.calendar.JDateChooser();
        N_brith_date = new javax.swing.JLabel();
        N_SEX = new javax.swing.JLabel();
        V_female = new RSMaterialComponent.RSRadioButtonMaterial();
        V_male = new RSMaterialComponent.RSRadioButtonMaterial();
        firstnamep = new RSMaterialComponent.RSTextFieldMaterial();
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
        nature_name = new RSMaterialComponent.RSCheckBoxMaterial();
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
        N_brith_date1 = new javax.swing.JLabel();
        start_date = new com.toedter.calendar.JDateChooser();
        txt_id = new javax.swing.JTextField();
        pnl5 = new javax.swing.JPanel();
        btnadd = new RSMaterialComponent.RSButtonMaterialShadow();
        id_jop_change = new RSMaterialComponent.RSComboBoxMaterial<>();
        btn_Dataconfirmation = new RSMaterialComponent.RSButtonMaterialShadow();
        N_job_change_p = new javax.swing.JLabel();
        btn_Exit2 = new RSMaterialComponent.RSButtonMaterialShadow();
        emp_current_work_city = new javax.swing.JPanel();
        current_work_city_governorate = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_job_change_p2 = new javax.swing.JLabel();
        N_work_place_p18 = new javax.swing.JLabel();
        current_work_city_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        current_work_city_sub_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p19 = new javax.swing.JLabel();
        N_work_place_p20 = new javax.swing.JLabel();
        current_work_city_community = new RSMaterialComponent.RSComboBoxMaterial<>();
        emp_current_city = new javax.swing.JPanel();
        current_city_governorate = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_job_change_p1 = new javax.swing.JLabel();
        N_work_place_p15 = new javax.swing.JLabel();
        current_city_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        current_city_sub_district = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p16 = new javax.swing.JLabel();
        N_work_place_p17 = new javax.swing.JLabel();
        current_city_community = new RSMaterialComponent.RSComboBoxMaterial<>();
        emp_directorates = new javax.swing.JPanel();
        N_work_place_p11 = new javax.swing.JLabel();
        N_work_place_p10 = new javax.swing.JLabel();
        N_work_place_p12 = new javax.swing.JLabel();
        N_work_place_p13 = new javax.swing.JLabel();
        cmb_Divisions = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_department = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_Directorates = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_Ministry = new RSMaterialComponent.RSComboBoxMaterial<>();
        emp_qualification = new javax.swing.JPanel();
        N_work_place_p9 = new javax.swing.JLabel();
        cmb_Qualification_Name = new RSMaterialComponent.RSComboBoxMaterial<>();
        cmb_Qualification_Type = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_work_place_p14 = new javax.swing.JLabel();
        N_work_place_p8 = new javax.swing.JLabel();
        cmb_qualification_divisions = new RSMaterialComponent.RSComboBoxMaterial<>();
        btn_Exit4 = new RSMaterialComponent.RSButtonMaterialShadow();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 768));
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
        txt_nature_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nature_nameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nature_nameKeyPressed(evt);
            }
        });
        pnl1.add(txt_nature_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, -1, -1));

        N_place.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place.setForeground(new java.awt.Color(7, 2, 2));
        N_place.setText("الاسم الوهمي");
        pnl1.add(N_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, -1, -1));

        chk_rhp.setForeground(new java.awt.Color(185, 146, 79));
        chk_rhp.setText("+");
        chk_rhp.setColorCheck(new java.awt.Color(185, 146, 79));
        chk_rhp.setColorUnCheck(new java.awt.Color(185, 146, 79));
        chk_rhp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        chk_rhp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chk_rhp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_rhp.setIsEffectRipple(false);
        chk_rhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_rhpActionPerformed(evt);
            }
        });
        chk_rhp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chk_rhpKeyPressed(evt);
            }
        });
        pnl1.add(chk_rhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        N_nature.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_nature.setForeground(new java.awt.Color(7, 2, 2));
        N_nature.setText("الاسم الحقيقي أو الوهمي");
        pnl1.add(N_nature, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 250, -1, -1));

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
        governnorates_States.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                governnorates_StatesKeyPressed(evt);
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
        id_social_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_social_statusKeyPressed(evt);
            }
        });
        pnl1.add(id_social_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        N_socil_status_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_socil_status_p.setForeground(new java.awt.Color(7, 2, 2));
        N_socil_status_p.setText("الحالة الأجتماعية");
        pnl1.add(N_socil_status_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, -1, -1));

        txt_brith_date.setForeground(new java.awt.Color(1, 1, 1));
        txt_brith_date.setDateFormatString("dd-MM-yyyy");
        txt_brith_date.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        pnl1.add(txt_brith_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 250, 40));

        N_brith_date.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_brith_date.setForeground(new java.awt.Color(7, 2, 2));
        N_brith_date.setText("تاريخ الميلاد");
        pnl1.add(N_brith_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        N_SEX.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_SEX.setForeground(new java.awt.Color(7, 2, 2));
        N_SEX.setText("الجنس");
        pnl1.add(N_SEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, -1));

        V_female.setForeground(new java.awt.Color(6, 6, 6));
        V_female.setText("أثنى");
        V_female.setColorCheck(new java.awt.Color(185, 146, 79));
        V_female.setColorUnCheck(new java.awt.Color(185, 146, 79));
        V_female.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        V_female.setIsEffectRipple(false);
        V_female.setNextFocusableComponent(N_governnorates_p3);
        V_female.setRippleColor(new java.awt.Color(185, 146, 79));
        V_female.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                V_femaleKeyPressed(evt);
            }
        });
        pnl1.add(V_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 123, -1));

        V_male.setForeground(new java.awt.Color(6, 6, 6));
        V_male.setText("الذكر");
        V_male.setColorCheck(new java.awt.Color(185, 146, 79));
        V_male.setColorUnCheck(new java.awt.Color(185, 146, 79));
        V_male.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        V_male.setIsEffectRipple(false);
        V_male.setRippleColor(new java.awt.Color(185, 146, 79));
        V_male.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                V_maleKeyPressed(evt);
            }
        });
        pnl1.add(V_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 88, -1));

        firstnamep.setForeground(new java.awt.Color(1, 1, 1));
        firstnamep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstnamep.setColorMaterial(new java.awt.Color(185, 146, 79));
        firstnamep.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        firstnamep.setPlaceholder("");
        firstnamep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnamepActionPerformed(evt);
            }
        });
        firstnamep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstnamepKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnamepKeyPressed(evt);
            }
        });
        pnl1.add(firstnamep, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        N_fname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_fname.setForeground(new java.awt.Color(7, 2, 2));
        N_fname.setText("اسم الموظف");
        pnl1.add(N_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, -1, -1));

        N_mname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_mname.setForeground(new java.awt.Color(7, 2, 2));
        N_mname.setText("اسم الاب");
        pnl1.add(N_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 90, -1, -1));

        middlename.setForeground(new java.awt.Color(1, 1, 1));
        middlename.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        middlename.setColorMaterial(new java.awt.Color(185, 146, 79));
        middlename.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        middlename.setPlaceholder("");
        middlename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                middlenameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                middlenameKeyPressed(evt);
            }
        });
        pnl1.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        lastname.setForeground(new java.awt.Color(1, 1, 1));
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setColorMaterial(new java.awt.Color(185, 146, 79));
        lastname.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lastname.setPlaceholder("");
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameKeyPressed(evt);
            }
        });
        pnl1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, -1, -1));

        N_lname.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_lname.setForeground(new java.awt.Color(7, 2, 2));
        N_lname.setText("الكنية ");
        pnl1.add(N_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 140, -1, -1));

        N_mother_name.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_mother_name.setForeground(new java.awt.Color(7, 2, 2));
        N_mother_name.setText("اسم الأم");
        pnl1.add(N_mother_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 200, -1, -1));

        motherfullname.setForeground(new java.awt.Color(1, 1, 1));
        motherfullname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        motherfullname.setColorMaterial(new java.awt.Color(185, 146, 79));
        motherfullname.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        motherfullname.setPlaceholder("");
        motherfullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                motherfullnameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motherfullnameKeyPressed(evt);
            }
        });
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
        cmb_type_of_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_type_of_docKeyPressed(evt);
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
        idnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idnumberActionPerformed(evt);
            }
        });
        idnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idnumberKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idnumberKeyPressed(evt);
            }
        });
        pnl1.add(idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, -1, -1));

        N_place2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place2.setForeground(new java.awt.Color(7, 2, 2));
        N_place2.setText("رقم البطاقة");
        pnl1.add(N_place2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, -1, -1));

        N_place3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_place3.setForeground(new java.awt.Color(7, 2, 2));
        N_place3.setText("رقم الموبايل");
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phonenumberKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phonenumberKeyPressed(evt);
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
        cmb_blood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_bloodKeyPressed(evt);
            }
        });
        pnl1.add(cmb_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        N_governnorates_p2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_governnorates_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_governnorates_p2.setText("عامل الريزوس");
        pnl1.add(N_governnorates_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, -1, -1));

        nature_name.setForeground(new java.awt.Color(185, 146, 79));
        nature_name.setText("وهمي");
        nature_name.setColorCheck(new java.awt.Color(185, 146, 79));
        nature_name.setColorUnCheck(new java.awt.Color(185, 146, 79));
        nature_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nature_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nature_name.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nature_name.setIsEffectRipple(false);
        nature_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nature_nameActionPerformed(evt);
            }
        });
        nature_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nature_nameKeyPressed(evt);
            }
        });
        pnl1.add(nature_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 250, -1, -1));

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
        cmb_States_district.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_States_districtKeyPressed(evt);
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
        cmb_States_district_registerplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_States_district_registerplaceKeyPressed(evt);
            }
        });
        pnl1.add(cmb_States_district_registerplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        cmb_States_district_registerplace_registerno.setBackground(new java.awt.Color(254, 254, 254));
        cmb_States_district_registerplace_registerno.setForeground(new java.awt.Color(1, 1, 1));
        cmb_States_district_registerplace_registerno.setToolTipText("");
        cmb_States_district_registerplace_registerno.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_States_district_registerplace_registerno.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        cmb_States_district_registerplace_registerno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_States_district_registerplace_registernoActionPerformed(evt);
            }
        });
        cmb_States_district_registerplace_registerno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_States_district_registerplace_registernoKeyPressed(evt);
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
        cmb_Jop_title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_Jop_titleKeyPressed(evt);
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
        cmb_Jops_description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_Jops_descriptionKeyPressed(evt);
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

        N_brith_date1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_brith_date1.setForeground(new java.awt.Color(7, 2, 2));
        N_brith_date1.setText("تاريخ المباشرة");
        pnl1.add(N_brith_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 420, -1, -1));

        start_date.setDateFormatString("dd-MM-yyyy");
        start_date.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        start_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                start_dateKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                start_dateKeyPressed(evt);
            }
        });
        pnl1.add(start_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 250, 40));
        pnl1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 50, -1));

        rSPanelsSlider1.add(pnl1, "card2");

        pnl5.setBackground(new java.awt.Color(254, 254, 254));
        pnl5.setName("pnl2"); // NOI18N
        pnl5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setBackground(new java.awt.Color(185, 146, 79));
        btnadd.setText("إضافة موظف");
        btnadd.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btnadd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnadd.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btnadd.setEffectFocus(true);
        btnadd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        pnl5.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 140, -1));

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
        id_jop_change.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_jop_changeKeyPressed(evt);
            }
        });
        pnl5.add(id_jop_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, -1, -1));

        btn_Dataconfirmation.setBackground(new java.awt.Color(185, 146, 79));
        btn_Dataconfirmation.setText("تأكيد ");
        btn_Dataconfirmation.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Dataconfirmation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Dataconfirmation.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Dataconfirmation.setEffectFocus(true);
        btn_Dataconfirmation.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Dataconfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DataconfirmationActionPerformed(evt);
            }
        });
        pnl5.add(btn_Dataconfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 140, 50));

        N_job_change_p.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p.setText("التغيرات الوظيفية");
        pnl5.add(N_job_change_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 540, -1, -1));

        btn_Exit2.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit2.setText("سابق");
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
        pnl5.add(btn_Exit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 120, -1));

        emp_current_work_city.setBackground(new java.awt.Color(254, 254, 254));
        emp_current_work_city.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "مكان السكن", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        emp_current_work_city.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        emp_current_work_city.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        current_work_city_governorate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_work_city_governorateKeyPressed(evt);
            }
        });
        emp_current_work_city.add(current_work_city_governorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        N_job_change_p2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p2.setText("المحافظة");
        emp_current_work_city.add(N_job_change_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        N_work_place_p18.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p18.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p18.setText("المنطقة");
        emp_current_work_city.add(N_work_place_p18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                current_work_city_districtInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        current_work_city_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_work_city_districtActionPerformed(evt);
            }
        });
        current_work_city_district.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_work_city_districtKeyPressed(evt);
            }
        });
        emp_current_work_city.add(current_work_city_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

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
        current_work_city_sub_district.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_work_city_sub_districtKeyPressed(evt);
            }
        });
        emp_current_work_city.add(current_work_city_sub_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        N_work_place_p19.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p19.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p19.setText("الناحية");
        emp_current_work_city.add(N_work_place_p19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        N_work_place_p20.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p20.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p20.setText("البلدة");
        emp_current_work_city.add(N_work_place_p20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

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
        current_work_city_community.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_work_city_communityKeyPressed(evt);
            }
        });
        emp_current_work_city.add(current_work_city_community, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        pnl5.add(emp_current_work_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 320, 240));

        emp_current_city.setBackground(new java.awt.Color(254, 254, 254));
        emp_current_city.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "مكان العمل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(1, 1, 1))); // NOI18N
        emp_current_city.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        emp_current_city.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        current_city_governorate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_city_governorateKeyPressed(evt);
            }
        });
        emp_current_city.add(current_city_governorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        N_job_change_p1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_job_change_p1.setForeground(new java.awt.Color(7, 2, 2));
        N_job_change_p1.setText("المحافظة");
        emp_current_city.add(N_job_change_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        N_work_place_p15.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p15.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p15.setText("المنطقة");
        emp_current_city.add(N_work_place_p15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                current_city_districtInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        current_city_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_city_districtActionPerformed(evt);
            }
        });
        current_city_district.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_city_districtKeyPressed(evt);
            }
        });
        emp_current_city.add(current_city_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

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
        current_city_sub_district.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_city_sub_districtKeyPressed(evt);
            }
        });
        emp_current_city.add(current_city_sub_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        N_work_place_p16.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p16.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p16.setText("الناحية");
        emp_current_city.add(N_work_place_p16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        N_work_place_p17.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p17.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p17.setText("البلدة");
        emp_current_city.add(N_work_place_p17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

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
        current_city_community.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                current_city_communityKeyPressed(evt);
            }
        });
        emp_current_city.add(current_city_community, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        pnl5.add(emp_current_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 310, 240));

        emp_directorates.setBackground(new java.awt.Color(255, 255, 255));
        emp_directorates.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "مديرية أو دائرة التابع لها", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15))); // NOI18N

        N_work_place_p11.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p11.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p11.setText("الوزارة");

        N_work_place_p10.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p10.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p10.setText("المديرية");

        N_work_place_p12.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p12.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p12.setText("الدائرة");

        N_work_place_p13.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p13.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p13.setText("الشعبة");

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
        cmb_Divisions.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_DivisionsKeyPressed(evt);
            }
        });

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
        cmb_department.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_departmentKeyPressed(evt);
            }
        });

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
        cmb_Directorates.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_DirectoratesKeyPressed(evt);
            }
        });

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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_MinistryInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cmb_Ministry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_MinistryActionPerformed(evt);
            }
        });
        cmb_Ministry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_MinistryKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout emp_directoratesLayout = new javax.swing.GroupLayout(emp_directorates);
        emp_directorates.setLayout(emp_directoratesLayout);
        emp_directoratesLayout.setHorizontalGroup(
            emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emp_directoratesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmb_Ministry, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Directorates, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_department, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Divisions, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(N_work_place_p11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(N_work_place_p10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(N_work_place_p12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(N_work_place_p13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        emp_directoratesLayout.setVerticalGroup(
            emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emp_directoratesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Ministry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N_work_place_p11))
                .addGap(10, 10, 10)
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Directorates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N_work_place_p10))
                .addGap(10, 10, 10)
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N_work_place_p12))
                .addGap(10, 10, 10)
                .addGroup(emp_directoratesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(N_work_place_p13)
                    .addComponent(cmb_Divisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl5.add(emp_directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 480, 240));

        emp_qualification.setBackground(new java.awt.Color(255, 255, 255));
        emp_qualification.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "المؤهل العلمي", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15))); // NOI18N

        N_work_place_p9.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p9.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p9.setText("أسم الشهادة");

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
        cmb_Qualification_Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_Qualification_NameKeyPressed(evt);
            }
        });

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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_Qualification_TypeInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cmb_Qualification_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_Qualification_TypeActionPerformed(evt);
            }
        });
        cmb_Qualification_Type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_Qualification_TypeKeyPressed(evt);
            }
        });

        N_work_place_p14.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p14.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p14.setText("نوع الشهادة");

        N_work_place_p8.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 18)); // NOI18N
        N_work_place_p8.setForeground(new java.awt.Color(7, 2, 2));
        N_work_place_p8.setText("أختصاص الشهادة");

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
        cmb_qualification_divisions.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_qualification_divisionsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout emp_qualificationLayout = new javax.swing.GroupLayout(emp_qualification);
        emp_qualification.setLayout(emp_qualificationLayout);
        emp_qualificationLayout.setHorizontalGroup(
            emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emp_qualificationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmb_Qualification_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Qualification_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_qualification_divisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(N_work_place_p9)
                    .addComponent(N_work_place_p14)
                    .addComponent(N_work_place_p8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        emp_qualificationLayout.setVerticalGroup(
            emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emp_qualificationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Qualification_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(emp_qualificationLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(N_work_place_p9)))
                .addGap(10, 10, 10)
                .addGroup(emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_Qualification_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(emp_qualificationLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(N_work_place_p14)))
                .addGap(10, 10, 10)
                .addGroup(emp_qualificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_qualification_divisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(emp_qualificationLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(N_work_place_p8)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnl5.add(emp_qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, -1, -1));

        btn_Exit4.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit4.setText("خروج");
        btn_Exit4.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit4.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit4.setEffectFocus(true);
        btn_Exit4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Exit4ActionPerformed(evt);
            }
        });
        pnl5.add(btn_Exit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 80, -1));

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
        jLabel5.setText("تم أضافة موظف بنجاح");

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(531, 531, 531)
                .addComponent(jLabel5)
                .addContainerGap(539, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(218, Short.MAX_VALUE))
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
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
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
                .addContainerGap(327, Short.MAX_VALUE))
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
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
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
                .addContainerGap(327, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnl6, "card5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1350, 600));

        jLabel16.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 1, 1));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("وزارة التنمية والشؤون الإنسانية");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 370, 40));

        jLabel15.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 1, 1));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("برنامج أتمتة شؤون الموظفين");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 370, 40));

        jLabel14.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("دائرة الموارد البشرية");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 230, 40));

        jLabel12.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("حكومة الإنقاذ السورية");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 340, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AddEm.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("حكومة الإنقاذ السورية");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 20, 230, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_social_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_social_statusActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_id_social_statusActionPerformed

    private void governnorates_StatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_governnorates_StatesActionPerformed
        cmb_States_district.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_States_district_registerplace.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_States_district_registerplace_registerno.setModel(new DefaultComboBoxModel(new Integer[0]));
        try {

            fill_district();
            cmb_States_district.setEnabled(true);
        } catch (Exception e) {

        }

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

        buttonGroup1.add(V_male);
        buttonGroup1.add(V_female);
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
    View.main main_1 = null;
    private void btn_Exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit4ActionPerformed
        if (main_1 == null) {
            main_1 = new main();
        }

        main_1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_Exit4ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            //  || cmb_Divisions.getSelectedItem() == null
            if (firstnamep.getText().equals("") || middlename.getText().equals("") || lastname.getText().equals("") || motherfullname.getText().equals("")
                    || idnumber.getText().equals("") || phonenumber.getText().equals("")
                    || id_social_status.getSelectedItem() == null || cmb_blood.getSelectedItem() == null || cmb_Jops_description.getSelectedItem() == null
                    || id_jop_change.getSelectedItem() == null || cmb_type_of_doc.getSelectedItem() == null
                    || current_city_community.getSelectedItem() == null || cmb_States_district_registerplace_registerno.getSelectedItem() == null ) {
                View.Message a = new Message(this, true, "الرجاء عم ترك مربع فارغ", MessageType.WARNING, 25);a.setVisible(true);
                rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Left);
                return;
            }

            Model.Model_Tables M_social = (Model_Tables) id_social_status.getSelectedItem();
            Model.m_registerno id_registernop = (m_registerno) cmb_States_district_registerplace_registerno.getSelectedItem();
            Model.Model_Tables id_bloodp = (Model_Tables) cmb_blood.getSelectedItem();
            Model.M_Qualification_Name id_qualificationp_Name = (M_Qualification_Name) cmb_Qualification_Name.getSelectedItem();
            Model.M_Qualification_Type id_qualificationp_Type = (M_Qualification_Type) cmb_Qualification_Type.getSelectedItem();
            Model.M_Qualification_Division id_qualificationp_divisions = (M_Qualification_Division) cmb_qualification_divisions.getSelectedItem();

            if (cmb_qualification_divisions.getSelectedItem() == null) {
                if (cmb_Qualification_Type.getSelectedItem() == null) {
                    model.setQualification_p(Integer.valueOf(id_qualificationp_Name.getId()));
                } else {
                    model.setQualification_p(Integer.valueOf(id_qualificationp_Type.getId()));
                }
            } else {
                model.setQualification_p(Integer.valueOf(id_qualificationp_divisions.getId()));
            }

            Model.Model_Tables id_jop_changep = (Model_Tables) id_jop_change.getSelectedItem();

            Model.M_Divisions id_work_placep_Divisions = (M_Divisions) cmb_Divisions.getSelectedItem();
            Model.M_Department id_work_placep_Department = (M_Department) cmb_department.getSelectedItem();
            Model.M_Directorates id_work_placep_Directorates = (M_Directorates) cmb_Directorates.getSelectedItem();

            if (cmb_Divisions.getSelectedItem() == null) {
                if (cmb_department.getSelectedItem() == null) {
                  model.setWork_place_p(Integer.valueOf(id_work_placep_Directorates.getID()));
                } else {
                    model.setWork_place_p(Integer.valueOf(id_work_placep_Department.getID()));
                }

            } else {
                model.setWork_place_p(Integer.valueOf(id_work_placep_Divisions.getID()));
            }
            Model.Model_Tables id_type_of_docp = (Model_Tables) cmb_type_of_doc.getSelectedItem();
            Model.m_work_city id_work_city_current = (m_work_city) current_city_community.getSelectedItem();
            Model.m_work_city id_work_city_community = (m_work_city) current_work_city_community.getSelectedItem();
            Model.m_jops id_jops1 = (m_jops) cmb_Jops_description.getSelectedItem();

            model.setFname(firstnamep.getText());
            model.setMname(middlename.getText());
            model.setLname(lastname.getText());
            model.setNature(nature_name.isSelected());
            model.setFictitiousnamep(txt_nature_name.getText());
            model.setMother_name(motherfullname.getText());
            model.setBrith_date(txt_brith_date.getDate());
            model.setSex(V_male.isSelected());
            model.setSocil_status_p(Integer.valueOf(M_social.getColumn_Id()));
            model.setIdnumberp(Integer.valueOf(idnumber.getText()));
            model.setId_registernop(Integer.valueOf(id_registernop.getId()));
            model.setPhonenumberp(phonenumber.getText());
            model.setId_bloodp(Integer.valueOf(id_bloodp.getColumn_Id()));
            model.setRhp(chk_rhp.isSelected());

            model.setId_jopsp(Integer.valueOf(id_jops1.getId()));
            model.setJob_change_p(Integer.valueOf(id_jop_changep.getColumn_Id()));

            model.setCurrenctplaceofresidencep(Integer.valueOf(id_work_city_current.getId()));

            model.setType_of_doc_p(Integer.valueOf(id_type_of_docp.getColumn_Id()));
            model.setId_work_city_p(Integer.valueOf(id_work_city_community.getId()));
            model.setStarting_date(start_date.getDate());
            boolean i = ctrl.add(model);
            if (i == true) {
                rSPanelsSlider1.slidPanel(20, pnl3, RSPanelsSlider.direct.Right);
                t = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        init_comboboxes();
                        firstnamep.setText("");
                        middlename.setText("");
                        lastname.setText("");
                        motherfullname.setText("");
                        txt_nature_name.setText("");
                        idnumber.setText("");
                        phonenumber.setText("");
                        txt_brith_date.setDate(null);
                        start_date.setDate(null);
                        rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Right);
                        fillCombobox();
                        t.stop();
                    }

                });
                t.start();
            } else {
                rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Left);
            }

        } catch (Exception e) {
            //      JOptionPane.showMessageDialog(null, "get massage in dd_emp " + e.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddActionPerformed

    private void cmb_Qualification_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_Qualification_NameActionPerformed

        cmb_Qualification_Type.setModel(new DefaultComboBoxModel(new Integer[0]));
        cmb_Qualification_Type.setEnabled(true);
        Qualification_Type();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_NameActionPerformed

    private void cmb_Qualification_NameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_Qualification_NameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_NameItemStateChanged

    private void cmb_DivisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DivisionsActionPerformed

    }//GEN-LAST:event_cmb_DivisionsActionPerformed

    private void cmb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departmentActionPerformed
        cmb_Divisions.setEnabled(true);
        try {
            fullDivi();
        } catch (SQLException ex) {
            Logger.getLogger(AddEmp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cmb_departmentActionPerformed

    private void cmb_qualification_divisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_qualification_divisionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_qualification_divisionsActionPerformed

    private void cmb_MinistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_MinistryActionPerformed
        cmb_Directorates.setModel(new DefaultComboBoxModel(new Integer[0]));
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

        cmb_department.setModel(new DefaultComboBoxModel(new Integer[0]));
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
        if (current_city_sub_district.getSelectedItem() == null) {
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

    private void nature_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nature_nameActionPerformed
        if (nature_name.isSelected()) {
            txt_nature_name.setVisible(true);
            N_place.setVisible(true);
        } else {
            txt_nature_name.setVisible(false);
            N_place.setVisible(false);
        }


    }//GEN-LAST:event_nature_nameActionPerformed

    private void cmb_States_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_States_districtActionPerformed
//        cmb_States_district_registerplace.setModel(new DefaultComboBoxModel(new Integer[0]));
        //   try {

        cmb_States_district_registerplace.setEnabled(true);
        full_registerplace();

        //     } catch (Exception e) {
        //    }
//
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_districtActionPerformed

    private void cmb_States_district_registerplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_States_district_registerplaceActionPerformed

        //  cmb_States_district_registerplace_registerno.setEnabled(true);
        //      cmb_States_district_registerplace_registerno.setModel(new DefaultComboBoxModel(new Integer[0]));
        full_registerno();


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
        int key = evt.getKeyCode();
        if (key == 10) {
            if (phonenumber.getText().equals("")) {
                 View.Message a = new Message(this, true, "الرجاء ادخل رقم الموبايل", MessageType.WARNING, 25);a.setVisible(true);
              
                phonenumber.requestFocus();
            } else {
                governnorates_States.requestFocus();
            }

        }

    }//GEN-LAST:event_phonenumberKeyPressed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed

    }//GEN-LAST:event_phonenumberActionPerformed

    private void idnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idnumberKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (idnumber.getText().equals("")) {
                 View.Message a = new Message(this, true, "الرجاء ادخل رقم البطاقة ", MessageType.WARNING, 25);a.setVisible(true);
               
                idnumber.requestFocus();
            } else {
                V_male.requestFocus();
                V_male.setSelected(true);

            }

        }
    }//GEN-LAST:event_idnumberKeyPressed

    private void firstnamepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnamepKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnamepKeyTyped

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
        if (current_work_city_sub_district.getSelectedItem() == null) {
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
        if (main_1 == null) {
            main_1 = new main();
        }

        main_1.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btn_Exit5ActionPerformed

    private void firstnamepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnamepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnamepActionPerformed

    private void middlenameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middlenameKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }
    }//GEN-LAST:event_middlenameKeyTyped

    private void lastnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameKeyTyped

    private void motherfullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motherfullnameKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_motherfullnameKeyTyped

    private void txt_nature_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nature_nameKeyTyped
        if (Character.isSpaceChar(evt.getKeyChar())) {

            return;
        }
        String c = "" + evt.getKeyChar();
        if (!c.matches("[\\p{InArabic}&&\\PN]")) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nature_nameKeyTyped

    private void idnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idnumberActionPerformed

    private void btn_DataconfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DataconfirmationActionPerformed

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            if (firstnamep.getText().equals("") || middlename.getText().equals("") || lastname.getText().equals("") || motherfullname.getText().equals("")
                    || idnumber.getText().equals("") || phonenumber.getText().equals("")
                    || id_social_status.getSelectedItem() == null || cmb_blood.getSelectedItem() == null || cmb_Jops_description.getSelectedItem() == null
                    || id_jop_change.getSelectedItem() == null || cmb_type_of_doc.getSelectedItem() == null
                    || current_city_community.getSelectedItem() == null || cmb_States_district_registerplace_registerno.getSelectedItem() == null || cmb_department.getSelectedItem() == null) {
           View.Message a = new Message(this, true, "الرجاء عم ترك مربع فارغ", MessageType.WARNING, 25);a.setVisible(true);
               
                rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Left);

                
                return;
            }
            model.setId_emp(Integer.valueOf(txt_id.getText()));
            Model.Model_Tables M_social = (Model_Tables) id_social_status.getSelectedItem();
            Model.m_registerno id_registernop = (m_registerno) cmb_States_district_registerplace_registerno.getSelectedItem();
            Model.Model_Tables id_bloodp = (Model_Tables) cmb_blood.getSelectedItem();
            Model.M_Qualification_Name id_qualificationp_Name = (M_Qualification_Name) cmb_Qualification_Name.getSelectedItem();
            Model.M_Qualification_Type id_qualificationp_Type = (M_Qualification_Type) cmb_Qualification_Type.getSelectedItem();
            Model.M_Qualification_Division id_qualificationp_divisions = (M_Qualification_Division) cmb_qualification_divisions.getSelectedItem();

            if (cmb_qualification_divisions.getSelectedItem() == null) {
                if (cmb_Qualification_Type.getSelectedItem() == null) {
                    model.setQualification_p(Integer.valueOf(id_qualificationp_Name.getId()));
                } else {
                    model.setQualification_p(Integer.valueOf(id_qualificationp_Type.getId()));
                }
            } else {
                model.setQualification_p(Integer.valueOf(id_qualificationp_divisions.getId()));
            }

            Model.Model_Tables id_jop_changep = (Model_Tables) id_jop_change.getSelectedItem();
            Model.M_Divisions id_work_placep_Divisions = (M_Divisions) cmb_Divisions.getSelectedItem();
            if (cmb_Divisions.getSelectedItem() == null) {
                Model.M_Department id_work_placep_Department = (M_Department) cmb_department.getSelectedItem();
                model.setWork_place_p(Integer.valueOf(id_work_placep_Department.getID()));
            } else {
                model.setWork_place_p(Integer.valueOf(id_work_placep_Divisions.getID()));
            }
            Model.Model_Tables id_type_of_docp = (Model_Tables) cmb_type_of_doc.getSelectedItem();
            Model.m_work_city id_work_city_current = (m_work_city) current_city_community.getSelectedItem();
            Model.m_work_city id_work_city_community = (m_work_city) current_work_city_community.getSelectedItem();
            Model.m_jops id_jops1 = (m_jops) cmb_Jops_description.getSelectedItem();
            model.setFname(firstnamep.getText());
            model.setMname(middlename.getText());
            model.setLname(lastname.getText());
            model.setNature(nature_name.isSelected());
            model.setFictitiousnamep(txt_nature_name.getText());
            model.setMother_name(motherfullname.getText());
            model.setBrith_date(txt_brith_date.getDate());
            model.setSex(V_male.isSelected());
            model.setSocil_status_p(Integer.valueOf(M_social.getColumn_Id()));
            model.setIdnumberp(Integer.valueOf(idnumber.getText()));
            model.setId_registernop(Integer.valueOf(id_registernop.getId()));
            model.setPhonenumberp(phonenumber.getText());
            model.setId_bloodp(Integer.valueOf(id_bloodp.getColumn_Id()));
            model.setRhp(chk_rhp.isSelected());

            model.setId_jopsp(Integer.valueOf(id_jops1.getId()));
            model.setJob_change_p(Integer.valueOf(id_jop_changep.getColumn_Id()));

            model.setCurrenctplaceofresidencep(Integer.valueOf(id_work_city_current.getId()));

            model.setType_of_doc_p(Integer.valueOf(id_type_of_docp.getColumn_Id()));
            model.setId_work_city_p(Integer.valueOf(id_work_city_community.getId()));
            model.setStarting_date(start_date.getDate());

            ctrl.update_and_cheker_emp(model);

            this.dispose();
            main.viewmain.setVisible(true);

        } catch (Exception e) {
       //     JOptionPane.showMessageDialog(null, "get message to => emp_update11" + e.getMessage());

        }

    }//GEN-LAST:event_btn_DataconfirmationActionPerformed

    private void firstnamepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnamepKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (firstnamep.getText().equals("")) {
                 View.Message meg = new Message(this, true, "الرجاء ادخل اسم موظف ", MessageType.WARNING, 25);meg.setVisible(true);
           
                firstnamep.requestFocus();

            } else {
                middlename.requestFocus();
            }


    }//GEN-LAST:event_firstnamepKeyPressed
    }
    private void middlenameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middlenameKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (middlename.getText().equals("")) {
                View.Message meg = new Message(this, true, "الرجاء ادخل اسم الاب ", MessageType.WARNING, 25);meg.setVisible(true);
                
                middlename.requestFocus();
            } else {
                lastname.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameKeyPressed

    private void lastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (lastname.getText().equals("")) {
                View.Message meg = new Message(this, true, "الرجاء ادخل اسم الكينة ", MessageType.WARNING, 25);meg.setVisible(true);
               
                lastname.requestFocus();
            } else {
                motherfullname.requestFocus();
            }

        }
    }//GEN-LAST:event_lastnameKeyPressed

    private void motherfullnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motherfullnameKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (motherfullname.getText().equals("")) {
                           View.Message meg = new Message(this, true, "الرجاء ادخل اسم الأم ", MessageType.WARNING, 25);meg.setVisible(true);
                
                motherfullname.requestFocus();
            } else {
                nature_name.requestFocus();
            }

        }
    }//GEN-LAST:event_motherfullnameKeyPressed

    private void nature_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nature_nameKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (nature_name.isSelected()) {
                txt_nature_name.requestFocus();
            } else {
                idnumber.requestFocus();
            }

        }
    }//GEN-LAST:event_nature_nameKeyPressed

    private void txt_nature_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nature_nameKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            idnumber.requestFocus();
        }
    }//GEN-LAST:event_txt_nature_nameKeyPressed

    private void start_dateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_start_dateKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            V_male.requestFocusInWindow();
        }
    }//GEN-LAST:event_start_dateKeyPressed

    private void start_dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_start_dateKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_start_dateKeyTyped

    private void V_maleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V_maleKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            cmb_type_of_doc.requestFocus();
        }
    }//GEN-LAST:event_V_maleKeyPressed

    private void V_femaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V_femaleKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            cmb_type_of_doc.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_V_femaleKeyPressed

    private void cmb_type_of_docKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_type_of_docKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_type_of_doc.getSelectedItem() == null) {
                View.Message meg = new Message(this, true, "الرجاء اختار الوثيقة ", MessageType.WARNING, 25);meg.setVisible(true);
                
                cmb_type_of_doc.requestFocus();
            } else {
                id_social_status.requestFocus();
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_type_of_docKeyPressed

    private void id_social_statusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_social_statusKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (id_social_status.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true, "الرجاء اختار حالة الاجتماعية ", MessageType.WARNING, 25);meg.setVisible(true);
              
                id_social_status.requestFocus();
            } else {
                cmb_blood.requestFocus();
            }

        }
    }//GEN-LAST:event_id_social_statusKeyPressed

    private void chk_rhpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chk_rhpKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            phonenumber.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_chk_rhpKeyPressed

    private void cmb_bloodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_bloodKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_blood.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true, "الرجاء اختار ذمرة دم", MessageType.WARNING, 25);meg.setVisible(true);
               
                cmb_blood.requestFocus();
            } else {
                chk_rhp.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_bloodKeyPressed

    private void chk_rhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_rhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_rhpActionPerformed

    private void governnorates_StatesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_governnorates_StatesKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (governnorates_States.getSelectedItem() == null) {
                View.Message meg = new Message(this, true, "الرجاء اختار المحافظة", MessageType.WARNING, 25);meg.setVisible(true);
               
                governnorates_States.requestFocus();
            } else {
                cmb_States_district.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_governnorates_StatesKeyPressed

    private void cmb_States_districtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_States_districtKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_States_district.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true, "الرجاء اختار الأمانة", MessageType.WARNING, 25);meg.setVisible(true);
               
                cmb_States_district.requestFocus();
            } else {
                cmb_States_district_registerplace.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_districtKeyPressed

    private void cmb_States_district_registerplaceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_States_district_registerplaceKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_States_district_registerplace.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,  "الرجاء اختار مكان القيد", MessageType.WARNING, 25);meg.setVisible(true);
               
                cmb_States_district_registerplace.requestFocus();
            } else {
                cmb_States_district_registerplace_registerno.requestFocus();
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_States_district_registerplaceKeyPressed

    private void cmb_States_district_registerplace_registernoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_States_district_registerplace_registernoKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_States_district_registerplace_registerno.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,  "الرجاء اختار رقم القيد", MessageType.WARNING, 25);meg.setVisible(true);
              
                cmb_States_district_registerplace_registerno.requestFocus();
            } else {
                cmb_Jop_title.requestFocus();
            }
        }
    }//GEN-LAST:event_cmb_States_district_registerplace_registernoKeyPressed

    private void cmb_Jop_titleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_Jop_titleKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_Jop_title.getSelectedItem() == null) {
                     View.Message meg = new Message(this, true,  "الرجاء اختار الصفة الوظيفية", MessageType.WARNING, 25);meg.setVisible(true);
                
                cmb_Jop_title.requestFocus();
            } else {
                cmb_Jops_description.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Jop_titleKeyPressed

    private void cmb_Jops_descriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_Jops_descriptionKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_Jops_description.getSelectedItem() == null) {
                  View.Message meg = new Message(this, true,  "الرجاء اختار المسمى الوظيفية", MessageType.WARNING, 25);meg.setVisible(true);
               
                cmb_Jops_description.requestFocus();
            } else {
                rSPanelsSlider1.slidPanel(20, pnl5, RSPanelsSlider.direct.Right);
                current_city_governorate.requestFocus();
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Jops_descriptionKeyPressed

    private void current_city_governorateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_city_governorateKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_city_governorate.getSelectedItem() == null) {
                View.Message meg = new Message(this, true,  "الرجاء اختار المحافظة (مكان العمل)", MessageType.WARNING, 25);meg.setVisible(true);
               
                current_city_governorate.requestFocus();
            } else {
                current_city_district.requestFocus();
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_governorateKeyPressed

    private void current_city_districtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_city_districtKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_city_district.getSelectedItem() == null) {
                  View.Message meg = new Message(this, true,  "الرجاء اختار المنطقة (مكان العمل)", MessageType.WARNING, 25);meg.setVisible(true);
              
                current_city_district.requestFocus();
            } else {
                current_city_sub_district.requestFocus();
            }

        }
    }//GEN-LAST:event_current_city_districtKeyPressed

    private void current_city_sub_districtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_city_sub_districtKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_city_sub_district.getSelectedItem() == null) {
                View.Message meg = new Message(this, true,  "الرجاء اختار الناحية (مكان العمل)", MessageType.WARNING, 25);meg.setVisible(true);
                
                current_city_sub_district.requestFocus();
            } else {
                current_city_community.requestFocus();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_current_city_sub_districtKeyPressed

    private void current_city_communityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_city_communityKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_city_community.getSelectedItem() == null) {
                   View.Message meg = new Message(this, true,  "الرجاء اختار البلدة (مكان العمل)", MessageType.WARNING, 25);meg.setVisible(true);
              
                current_city_community.requestFocus();
            } else {
                current_work_city_governorate.requestFocus();
            }

        }
// TODO add your handling code here:
    }//GEN-LAST:event_current_city_communityKeyPressed

    private void current_work_city_governorateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_work_city_governorateKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_work_city_governorate.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,  "الرجاء اختار المحافظة (مكان السكن)", MessageType.WARNING, 25);meg.setVisible(true);
       
                current_work_city_governorate.requestFocus();
            } else {
                current_work_city_district.requestFocus();
            }

        }

    }//GEN-LAST:event_current_work_city_governorateKeyPressed

    private void current_work_city_districtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_work_city_districtKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_work_city_district.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,  "الرجاء اختار المنطقة (مكان السكن)", MessageType.WARNING, 25);meg.setVisible(true);
                
                current_work_city_district.requestFocus();
            } else {
                current_work_city_sub_district.requestFocus();
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_current_work_city_districtKeyPressed

    private void current_work_city_sub_districtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_work_city_sub_districtKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_work_city_sub_district.getSelectedItem() == null) {
                    View.Message meg = new Message(this, true,   "الرجاء اختار الناحية (مكان السكن)", MessageType.WARNING, 25);meg.setVisible(true);
                
                current_work_city_sub_district.requestFocus();
            } else {
                current_work_city_community.requestFocus();
            }

        }
    }//GEN-LAST:event_current_work_city_sub_districtKeyPressed

    private void current_work_city_communityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_work_city_communityKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (current_work_city_community.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,    "الرجاء اختار البلدة (مكان السكن)", MessageType.WARNING, 25);meg.setVisible(true);
             
                current_work_city_community.requestFocus();
            } else {
                cmb_Ministry.requestFocus();
            }

        }
    }//GEN-LAST:event_current_work_city_communityKeyPressed

    private void cmb_MinistryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_MinistryKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_Ministry.getSelectedItem() == null) {
                   View.Message meg = new Message(this, true,    "الرجاء اختار الوزارة", MessageType.WARNING, 25);meg.setVisible(true);
       
                cmb_Ministry.requestFocus();
            } else {
                cmb_Directorates.requestFocus();
            }

        }
    }//GEN-LAST:event_cmb_MinistryKeyPressed

    private void cmb_DirectoratesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_DirectoratesKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_Directorates.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,   "الرجاء اختار المديرية", MessageType.WARNING, 25);meg.setVisible(true);
          
                cmb_Directorates.requestFocus();
            } else {
                cmb_department.requestFocus();
            }

        }
    }//GEN-LAST:event_cmb_DirectoratesKeyPressed

    private void cmb_departmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_departmentKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_department.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,   "الرجاء اختار الدائرة", MessageType.WARNING, 25);meg.setVisible(true);
          
                cmb_department.requestFocus();
            } else {
                cmb_Divisions.requestFocus();
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departmentKeyPressed

    private void cmb_DivisionsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_DivisionsKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {

            cmb_Qualification_Name.requestFocus();

        }
    }//GEN-LAST:event_cmb_DivisionsKeyPressed

    private void cmb_Qualification_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_Qualification_NameKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            if (cmb_Qualification_Name.getSelectedItem() == null) {
                View.Message meg = new Message(this, true,    "الرجاء اختار اسم الشهادة", MessageType.WARNING, 25);meg.setVisible(true);
             
                cmb_Qualification_Name.requestFocus();
            } else {
                cmb_Qualification_Type.requestFocus();
            }

        }
    }//GEN-LAST:event_cmb_Qualification_NameKeyPressed

    private void cmb_Qualification_TypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_Qualification_TypeKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {

            cmb_qualification_divisions.requestFocus();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_Qualification_TypeKeyPressed

    private void cmb_qualification_divisionsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_qualification_divisionsKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            id_jop_change.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_qualification_divisionsKeyPressed

    private void id_jop_changeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_jop_changeKeyPressed

        int key = evt.getKeyCode();
        if (key == 10) {
            if (id_jop_change.getSelectedItem() == null) {
                 View.Message meg = new Message(this, true,    "الرجاء اختار تغيرات الوظيفية", MessageType.WARNING, 25);meg.setVisible(true);
            
                id_jop_change.requestFocus();
            } else {
                btnadd.requestFocus();
            }

        }         // TODO add your handling code here:
    }//GEN-LAST:event_id_jop_changeKeyPressed

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
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmp().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N_SEX;
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
    private javax.swing.JLabel N_nature;
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
    public RSMaterialComponent.RSRadioButtonMaterial V_female;
    public RSMaterialComponent.RSRadioButtonMaterial V_male;
    public RSMaterialComponent.RSButtonMaterialShadow btn_Dataconfirmation;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit1;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit2;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit3;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit4;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit5;
    public RSMaterialComponent.RSButtonMaterialShadow btnadd;
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
    private javax.swing.JPanel emp_current_city;
    private javax.swing.JPanel emp_current_work_city;
    private javax.swing.JPanel emp_directorates;
    private javax.swing.JPanel emp_qualification;
    public RSMaterialComponent.RSTextFieldMaterial firstnamep;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> governnorates_States;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> id_jop_change;
    public RSMaterialComponent.RSComboBoxMaterial<Model.Model_Tables> id_social_status;
    public RSMaterialComponent.RSTextFieldMaterial idnumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public RSMaterialComponent.RSTextFieldMaterial lastname;
    public RSMaterialComponent.RSTextFieldMaterial middlename;
    public RSMaterialComponent.RSTextFieldMaterial motherfullname;
    public RSMaterialComponent.RSCheckBoxMaterial nature_name;
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
    public javax.swing.JTextField txt_id;
    public RSMaterialComponent.RSTextFieldMaterial txt_nature_name;
    // End of variables declaration//GEN-END:variables
}
