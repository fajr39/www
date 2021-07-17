/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.control_user_admin;
import View.frm_create_user;
import View.qualification.qualification_Name;
import View.qualification.qualification_divisions;
import View.qualification.qualification_type;
import View.sity.district;
import View.sity.registerno;
import View.sity.registerplace;
import View.workplace.department;
import View.workplace.directorate;
import View.workplace.divisions;
import View.workplace.ministry;
import form.Panel1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.MenuItem;
import workcity.district_work_city;
import workcity.sub_district_work_city;
import workcity.work_city_community;
import workcity.work_city_governorate;
import javax.swing.Timer;

/**
 *
 * @author RavenPC
 */
public class super_admin extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    boolean test_admin;
    Timer t;

    public super_admin() {
        initComponents();
        clock();

        panel_qualification.setVisible(false);
        panel_workplac.setVisible(false);
        panel_address.setVisible(false);
        panel_Constraint.setVisible(false);
        btn_blood.setVisible(false);
        btn_social_status.setVisible(false);
        btn_job_change.setVisible(false);
        btn_type_of_doc.setVisible(false);
        btn_jop_title.setVisible(false);
        btn_jops_desc.setVisible(false);

        btn_search.setVisible(false);
        btn_Health_status.setVisible(false);
        btn_diseases__chronic.setVisible(false);
        btn_link_chronic_disease_emp.setVisible(false);

     //   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

    }

    public super_admin(String fll_name) {
        initComponents();
        lbl_full_name.setText(fll_name);
        clock();

        panel_qualification.setVisible(false);
        panel_workplac.setVisible(false);
        panel_address.setVisible(false);
        panel_Constraint.setVisible(false);
        btn_blood.setVisible(false);
        btn_social_status.setVisible(false);
        btn_job_change.setVisible(false);
        btn_type_of_doc.setVisible(false);
        btn_jop_title.setVisible(false);
        btn_jops_desc.setVisible(false);

        btn_search.setVisible(false);
        btn_Health_status.setVisible(false);
        btn_diseases__chronic.setVisible(false);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

    }

    public  void clock() {

        Thread clock = new Thread() {
            public  void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MARCH);
                        int year = cal.get(Calendar.YEAR);

                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);

                        lbl_time.setText("الوقت " + hour + ":" + minute + ":" + second + "   التاريخ " + year + "/" + month + "/" + day);

                        sleep(1000);
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(super_admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        clock.start();
    }

    View.frm_permisiones_admin permision_admin = null;
    View.frm_Manage_admins Manag_admnis = null;
    View.frm_create_user add_users = null;
    View.frm_permisiones_users permision_user = null;
    View.frm_Manage_users Manag_users = null;

    public void execute() {

        ImageIcon iconStaff = new ImageIcon(getClass().getResource("/menu/maz.png"));
        ImageIcon iconSetting = new ImageIcon(getClass().getResource("/menu/setting.png"));
        ImageIcon iconDatabase = new ImageIcon(getClass().getResource("/menu/database.png"));
        ImageIcon iconMessage = new ImageIcon(getClass().getResource("/menu/message.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/menu/subMenu.png"));
        ImageIcon iconNext = new ImageIcon(getClass().getResource("/menu/next.png"));
        ImageIcon terms = new ImageIcon(getClass().getResource("/menu/maz.png"));
        ImageIcon phto_user = new ImageIcon(getClass().getResource("/menu/add_user.png"));
        ImageIcon add_admin = new ImageIcon(getClass().getResource("/menu/add_user.png"));
        ImageIcon Usermanagement = new ImageIcon(getClass().getResource("/menu/Usermanagement.png"));
        ImageIcon mangment_all = new ImageIcon(getClass().getResource("/menu/maz.png"));

        //  create submenu staff
        MenuItem menuStaff1 = new MenuItem(iconSubMenu, "مجموعة الاولى", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                View.NewJFrame1 a = new NewJFrame1();
//                a.setVisible(true);
                jPanel2.setVisible(true);
                jPanel1.setVisible(false);
                group_lists2.setVisible(false);
                panel_qualification.setVisible(true);
                panel_workplac.setVisible(true);
                panel_address.setVisible(true);
                panel_Constraint.setVisible(true);

                btn_blood.setVisible(true);
                btn_social_status.setVisible(true);
                btn_job_change.setVisible(true);
                btn_type_of_doc.setVisible(true);
                btn_jop_title.setVisible(true);
                btn_jops_desc.setVisible(true);

            }
        });
        MenuItem menuStaff2 = new MenuItem(iconSubMenu, "مجموعة تانية", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                group_lists2.setVisible(true);
                jPanel2.setVisible(false);
                jPanel1.setVisible(false);
                btn_diseases__chronic.setVisible(true);
                btn_link_chronic_disease_emp.setVisible(true);

            }
        });
        MenuItem menuStaff3 = new MenuItem(iconSubMenu, " مجموعة ثالثة", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.setVisible(false);
                jPanel1.setVisible(true);
                group_lists2.setVisible(false);
                btn_search.setVisible(true);
            }

        });
        //  create submenu setting message

        MenuItem message1 = new MenuItem(iconNext, "Message 001", null);
        MenuItem message2 = new MenuItem(iconNext, "Message 002", null);
        MenuItem message3 = new MenuItem(iconNext, "Message 003", null);

        //  create submenu setting 
        MenuItem menuSetting1 = new MenuItem(iconSubMenu, "Setting 001", null);
        MenuItem menuSettingMessage = new MenuItem(iconMessage, "Setting 002 Message", null, message1, message2, message3);
        MenuItem menuSetting3 = new MenuItem(iconSubMenu, "Setting 003", null);
        MenuItem menuSetting4 = new MenuItem(iconSubMenu, "Setting 004", null);
        // كل شي بخص المستخدمين
        MenuItem menuStaff21 = new MenuItem(phto_user, "إضافة المستخدم", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                View.frm_create_user v = new frm_create_user();
                v.setVisible(true);
            }
        });

        MenuItem add_admi = new MenuItem(phto_user, "إضافة المدير", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                View.frm_create_Admin a = new frm_create_Admin();

                a.setVisible(true);

            }
        });

        MenuItem terms_of_admin = new MenuItem(phto_user, " صلاحيات المدير", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (permision_admin == null) {
                    permision_admin = new frm_permisiones_admin();
                }

                permision_admin.setVisible(true);
            }
        });

        MenuItem Managing_Directors = new MenuItem(phto_user, "إدارة مدارء", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_admins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (Manag_admnis == null) {
                    Manag_admnis = new frm_Manage_admins();
                }

                Manag_admnis.setVisible(true);
            }
        });

        MenuItem add_user = new MenuItem(phto_user, "إضافة مستخدم", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_create_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (add_users == null) {
                    add_users = new frm_create_user();
                }

                add_users.setVisible(true);

            }
        });

        MenuItem terms_of_user = new MenuItem(phto_user, " صلاحيات مستخدمين", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_permisiones_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (permision_user == null) {
                    permision_user = new frm_permisiones_users();
                }

                permision_user.setVisible(true);
            }
        });

        MenuItem Managing_users = new MenuItem(Usermanagement, "إدارة المستخدمين", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (Manag_users == null) {
                    Manag_users = new frm_Manage_users();
                }
                Manag_users.setVisible(true);
            }
        });
        MenuItem mangment_a = new MenuItem(mangment_all, "إدارة الصلاحيات", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        MenuItem menuStaff = new MenuItem(iconStaff, "القوائم", null, menuStaff1, menuStaff2, menuStaff3);
        MenuItem menuSetting = new MenuItem(iconSetting, "System Setting", null, menuSetting1, menuSettingMessage, menuSetting3, menuSetting4);
        MenuItem menuDatabase = new MenuItem(iconDatabase, "System Database", null);
        menuSetting.setVisible(false);
        menuDatabase.setVisible(false);
        MenuItem terms1 = new MenuItem(terms, "الإعدادت", null, add_admi, menuStaff21, mangment_a);
        MenuItem setting_admin = new MenuItem(terms, "قوائم المدير", null, add_admi, terms_of_admin, Managing_Directors);
        MenuItem setting_user = new MenuItem(terms, "قوائم المستخدم", null, add_user, terms_of_user, Managing_users);
        Control.control_user_admin info = new control_user_admin();
        String user_type = info.get_info_type(Login.name_user);
        switch (user_type) {
            case "super_admins":
             menuStaff.setVisible(false);
               setting_user.setVisible(false);
               setting_admin.setVisible(true);
               lbl_full_name.setVisible(false);
                break;
            case "admin":
               setting_user.setVisible(true);
               setting_admin.setVisible(false);
             lbl_full_name.setVisible(false);
                break;
            default:
        }
        terms1.setVisible(false);

        addMenu(menuStaff, menuSetting, menuDatabase, terms1, setting_admin, setting_user);

    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        btn_jops_desc4 = new rojeru_san.extras.FlatButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_search = new rojeru_san.extras.FlatButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_full_name = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_jops_desc = new rojeru_san.extras.FlatButton();
        btn_jop_title = new rojeru_san.extras.FlatButton();
        btn_type_of_doc = new rojeru_san.extras.FlatButton();
        btn_blood = new rojeru_san.extras.FlatButton();
        btn_social_status = new rojeru_san.extras.FlatButton();
        btn_job_change = new rojeru_san.extras.FlatButton();
        panel_Constraint = new javax.swing.JPanel();
        btn_work_community = new rojeru_san.extras.FlatButton();
        btn_work_sub_district = new rojeru_san.extras.FlatButton();
        btn_work_gover = new rojeru_san.extras.FlatButton();
        btn_work_district = new rojeru_san.extras.FlatButton();
        panel_address = new javax.swing.JPanel();
        btn_registerno = new rojeru_san.extras.FlatButton();
        btn_registerplace = new rojeru_san.extras.FlatButton();
        btn_states = new rojeru_san.extras.FlatButton();
        btn_district = new rojeru_san.extras.FlatButton();
        panel_workplac = new javax.swing.JPanel();
        btn_work_divisions = new rojeru_san.extras.FlatButton();
        btn_work_department = new rojeru_san.extras.FlatButton();
        btn_work_ministry = new rojeru_san.extras.FlatButton();
        btn_work_directorate = new rojeru_san.extras.FlatButton();
        panel_qualification = new javax.swing.JPanel();
        btn_qual_divisions = new rojeru_san.extras.FlatButton();
        btn_qual_Name = new rojeru_san.extras.FlatButton();
        btn_qual_type = new rojeru_san.extras.FlatButton();
        group_lists2 = new javax.swing.JPanel();
        btn_link_chronic_disease_emp = new rojeru_san.extras.FlatButton();
        btn_families_memers = new rojeru_san.extras.FlatButton();
        btn_diseases__chronic = new rojeru_san.extras.FlatButton();
        btn_Health_status = new rojeru_san.extras.FlatButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelHeader.setBackground(new java.awt.Color(4, 94, 95));
        panelHeader.setPreferredSize(new java.awt.Dimension(561, 75));

        btn_jops_desc4.setBackground(new java.awt.Color(4, 94, 95));
        btn_jops_desc4.setText("X");
        btn_jops_desc4.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 20)); // NOI18N
        btn_jops_desc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jops_desc4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(254, 254, 254));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("وزارة التنمية والشؤون الإنسانية");

        jLabel15.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("برنامج أتمتة شؤون الموظفين");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(208, 208, 208)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(btn_jops_desc4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(btn_jops_desc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(115, 120, 230));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(4, 94, 95));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(4, 94, 95));
        panelBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(4, 94, 95));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_search.setBackground(new java.awt.Color(185, 146, 79));
        btn_search.setText("البحث");
        btn_search.setBorderPainted(false);
        btn_search.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, 160, 40));

        jPanel3.setBackground(new java.awt.Color(4, 94, 95));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 146, 79), 3), "عدد موظفين موجودين", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(254, 254, 254));
        jPanel3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 35)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("25");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 180, 110));

        jPanel4.setBackground(new java.awt.Color(4, 94, 95));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 146, 79), 3), "عدد موظفين قيد العمل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(185, 146, 79));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("50");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 180, -1));

        jPanel5.setBackground(new java.awt.Color(4, 94, 95));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 146, 79), 3), "عدد موظفين المستقلين", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(254, 254, 254));
        jPanel5.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 180, -1));

        lbl_full_name.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        lbl_full_name.setForeground(new java.awt.Color(254, 254, 254));
        lbl_full_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_full_name.setText("00:5:5");
        jPanel1.add(lbl_full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 390, 40));

        lbl_time.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(254, 254, 254));
        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_time.setText("00:5:5");
        jPanel1.add(lbl_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 390, 40));

        panelBody.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 630));

        jPanel2.setBackground(new java.awt.Color(4, 94, 95));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_jops_desc.setBackground(new java.awt.Color(185, 146, 79));
        btn_jops_desc.setText("المسمى الوظيفي");
        btn_jops_desc.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_jops_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jops_descActionPerformed(evt);
            }
        });
        jPanel2.add(btn_jops_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 160, 40));

        btn_jop_title.setBackground(new java.awt.Color(185, 146, 79));
        btn_jop_title.setText("الصفة الوظيفية");
        btn_jop_title.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_jop_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jop_titleActionPerformed(evt);
            }
        });
        jPanel2.add(btn_jop_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 160, 40));

        btn_type_of_doc.setBackground(new java.awt.Color(185, 146, 79));
        btn_type_of_doc.setText("الوثائق الشخصية");
        btn_type_of_doc.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_type_of_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_type_of_docActionPerformed(evt);
            }
        });
        jPanel2.add(btn_type_of_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, 160, 40));

        btn_blood.setBackground(new java.awt.Color(185, 146, 79));
        btn_blood.setText("زمرة الدم");
        btn_blood.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_blood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bloodActionPerformed(evt);
            }
        });
        jPanel2.add(btn_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 160, 40));

        btn_social_status.setBackground(new java.awt.Color(185, 146, 79));
        btn_social_status.setText("الحالة الاجتماعية");
        btn_social_status.setBorderPainted(false);
        btn_social_status.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_social_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_social_statusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_social_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 160, 40));

        btn_job_change.setBackground(new java.awt.Color(185, 146, 79));
        btn_job_change.setText("التغيرات الوظيفية");
        btn_job_change.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_job_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_job_changeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_job_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 160, 40));

        panel_Constraint.setBackground(new java.awt.Color(4, 94, 95));
        panel_Constraint.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 2), "مكان العمل والسكن", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        panel_Constraint.setForeground(new java.awt.Color(254, 254, 254));
        panel_Constraint.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        panel_Constraint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_work_community.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_community.setText("البلدة");
        btn_work_community.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_communityActionPerformed(evt);
            }
        });
        panel_Constraint.add(btn_work_community, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 40));

        btn_work_sub_district.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_sub_district.setText("الناحية");
        btn_work_sub_district.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_sub_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_sub_districtActionPerformed(evt);
            }
        });
        panel_Constraint.add(btn_work_sub_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 40));

        btn_work_gover.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_gover.setText("المحافظة");
        btn_work_gover.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_gover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_goverActionPerformed(evt);
            }
        });
        panel_Constraint.add(btn_work_gover, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 40));

        btn_work_district.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_district.setText("المنطقة");
        btn_work_district.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_districtActionPerformed(evt);
            }
        });
        panel_Constraint.add(btn_work_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 40));

        jPanel2.add(panel_Constraint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 220, 240));

        panel_address.setBackground(new java.awt.Color(4, 94, 95));
        panel_address.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 2), "العنوان الأصلي", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        panel_address.setForeground(new java.awt.Color(254, 254, 254));
        panel_address.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        panel_address.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_registerno.setBackground(new java.awt.Color(185, 146, 79));
        btn_registerno.setText("رقم القيد");
        btn_registerno.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_registerno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registernoActionPerformed(evt);
            }
        });
        panel_address.add(btn_registerno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 40));

        btn_registerplace.setBackground(new java.awt.Color(185, 146, 79));
        btn_registerplace.setText("مكان القيد");
        btn_registerplace.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_registerplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerplaceActionPerformed(evt);
            }
        });
        panel_address.add(btn_registerplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 40));

        btn_states.setBackground(new java.awt.Color(185, 146, 79));
        btn_states.setText("المحافظة");
        btn_states.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_states.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statesActionPerformed(evt);
            }
        });
        panel_address.add(btn_states, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 40));

        btn_district.setBackground(new java.awt.Color(185, 146, 79));
        btn_district.setText("الأمانة");
        btn_district.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_districtActionPerformed(evt);
            }
        });
        panel_address.add(btn_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 40));

        jPanel2.add(panel_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 220, 240));

        panel_workplac.setBackground(new java.awt.Color(4, 94, 95));
        panel_workplac.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 2), "الجهة", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        panel_workplac.setForeground(new java.awt.Color(254, 254, 254));
        panel_workplac.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        panel_workplac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_work_divisions.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_divisions.setText("الشعبة");
        btn_work_divisions.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_divisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_divisionsActionPerformed(evt);
            }
        });
        panel_workplac.add(btn_work_divisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 40));

        btn_work_department.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_department.setText("الدائرة");
        btn_work_department.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_departmentActionPerformed(evt);
            }
        });
        panel_workplac.add(btn_work_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 40));

        btn_work_ministry.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_ministry.setText("الوزارة");
        btn_work_ministry.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_ministry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_ministryActionPerformed(evt);
            }
        });
        panel_workplac.add(btn_work_ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 40));

        btn_work_directorate.setBackground(new java.awt.Color(185, 146, 79));
        btn_work_directorate.setText("المديرية");
        btn_work_directorate.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_work_directorate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_work_directorateActionPerformed(evt);
            }
        });
        panel_workplac.add(btn_work_directorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 40));

        jPanel2.add(panel_workplac, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 220, 240));

        panel_qualification.setBackground(new java.awt.Color(4, 94, 95));
        panel_qualification.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 2), "مؤهلات علمية", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DIN Next LT Arabic", 1, 15), new java.awt.Color(254, 254, 254))); // NOI18N
        panel_qualification.setForeground(new java.awt.Color(254, 254, 254));
        panel_qualification.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        panel_qualification.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_qual_divisions.setBackground(new java.awt.Color(185, 146, 79));
        btn_qual_divisions.setText("أختصاص الشهادة");
        btn_qual_divisions.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_qual_divisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qual_divisionsActionPerformed(evt);
            }
        });
        panel_qualification.add(btn_qual_divisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 180, 40));

        btn_qual_Name.setBackground(new java.awt.Color(185, 146, 79));
        btn_qual_Name.setText("أسم الشهادة");
        btn_qual_Name.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_qual_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qual_NameActionPerformed(evt);
            }
        });
        panel_qualification.add(btn_qual_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 40));

        btn_qual_type.setBackground(new java.awt.Color(185, 146, 79));
        btn_qual_type.setText("نوع الشهادة");
        btn_qual_type.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_qual_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qual_typeActionPerformed(evt);
            }
        });
        panel_qualification.add(btn_qual_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, 40));

        jPanel2.add(panel_qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, 220, 240));

        panelBody.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 630));

        group_lists2.setBackground(new java.awt.Color(4, 94, 95));
        group_lists2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_link_chronic_disease_emp.setBackground(new java.awt.Color(185, 146, 79));
        btn_link_chronic_disease_emp.setText("واجهة اضافة حالة الصحية للأفراد موظف");
        btn_link_chronic_disease_emp.setBorderPainted(false);
        btn_link_chronic_disease_emp.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_link_chronic_disease_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_link_chronic_disease_empActionPerformed(evt);
            }
        });
        group_lists2.add(btn_link_chronic_disease_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 270, 40));

        btn_families_memers.setBackground(new java.awt.Color(185, 146, 79));
        btn_families_memers.setText("بيانات عائلة الموظف");
        btn_families_memers.setBorderPainted(false);
        btn_families_memers.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_families_memers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_families_memersActionPerformed(evt);
            }
        });
        group_lists2.add(btn_families_memers, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 160, 40));

        btn_diseases__chronic.setBackground(new java.awt.Color(185, 146, 79));
        btn_diseases__chronic.setText("الأمراض مزمن");
        btn_diseases__chronic.setBorderPainted(false);
        btn_diseases__chronic.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_diseases__chronic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diseases__chronicActionPerformed(evt);
            }
        });
        group_lists2.add(btn_diseases__chronic, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 160, 40));

        btn_Health_status.setBackground(new java.awt.Color(185, 146, 79));
        btn_Health_status.setText("الحالة الصحية");
        btn_Health_status.setBorderPainted(false);
        btn_Health_status.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 16)); // NOI18N
        btn_Health_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Health_statusActionPerformed(evt);
            }
        });
        group_lists2.add(btn_Health_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 160, 40));

        panelBody.add(group_lists2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 630));

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1362, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    View.Frame_Tables social_status = null;
    private void btn_social_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_social_statusActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (social_status == null) {
            social_status = new Frame_Tables("أسم حالة", "social_status", "حالة الاجتماعية");
        }

        social_status.setVisible(true);
    }//GEN-LAST:event_btn_social_statusActionPerformed
    View.Frame_Tables blood = null;
    private void btn_bloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bloodActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (blood == null) {
            blood = new Frame_Tables("أسم زمرة", "blood", "زمرة دم");
        }

        blood.setVisible(true);
    }//GEN-LAST:event_btn_bloodActionPerformed
    View.Frame_Tables job_change = null;
    private void btn_job_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_job_changeActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (job_change == null) {
            job_change = new Frame_Tables("اسم تغير وظيفية", "job_change", "التغيرات الوظيفية");
        }

        job_change.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_job_changeActionPerformed
    View.Frame_Tables type_of_doc = null;
    private void btn_type_of_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_type_of_docActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (type_of_doc == null) {
            type_of_doc = new Frame_Tables("اسم مستند", "type_of_doc", "المستندات الشخصية");
        }

        type_of_doc.setVisible(true);
    }//GEN-LAST:event_btn_type_of_docActionPerformed
    View.jops_title jop_title = null;
    private void btn_jop_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jop_titleActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jops_title.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jops_title.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jops_title.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jops_title.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (jop_title == null) {
            jop_title = new jops_title();
        }

        jop_title.setVisible(true);
    }//GEN-LAST:event_btn_jop_titleActionPerformed
    View.jops_description jops_desc = null;
    private void btn_jops_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jops_descActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jops_description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jops_description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jops_description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jops_description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (jops_desc == null) {
            jops_desc = new jops_description();

        }
        jops_desc.setVisible(true);
    }//GEN-LAST:event_btn_jops_descActionPerformed
    View.qualification.qualification_divisions qual_divisions = null;
    private void btn_qual_divisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qual_divisionsActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qualification_divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qualification_divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qualification_divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qualification_divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (qual_divisions == null) {
            qual_divisions = new qualification_divisions();

        }
        qual_divisions.setVisible(true);
    }//GEN-LAST:event_btn_qual_divisionsActionPerformed
    qualification_Name qual_Name = null;
    private void btn_qual_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qual_NameActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qualification_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qualification_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qualification_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qualification_Name.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (qual_Name == null) {
            qual_Name = new qualification_Name();
        }
        qual_Name.setVisible(true);
    }//GEN-LAST:event_btn_qual_NameActionPerformed
    View.qualification.qualification_type qual_type = null;
    private void btn_qual_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qual_typeActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qualification_type.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qualification_type.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qualification_type.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qualification_type.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (qual_type == null) {
            qual_type = new qualification_type();
        }
        qual_type.setVisible(true);
    }//GEN-LAST:event_btn_qual_typeActionPerformed

    private void btn_jops_desc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jops_desc4ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_jops_desc4ActionPerformed
    View.workplace.department work_department = null;
    private void btn_work_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_departmentActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_department == null) {
            work_department = new View.workplace.department();
        }
        work_department.setVisible(true);
    }//GEN-LAST:event_btn_work_departmentActionPerformed
    View.workplace.ministry work_ministry = null;
    private void btn_work_ministryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_ministryActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ministry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ministry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ministry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ministry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_ministry == null) {
            work_ministry = new View.workplace.ministry();
        }
        work_ministry.setVisible(true);

    }//GEN-LAST:event_btn_work_ministryActionPerformed
    View.workplace.directorate work_directorate = null;
    private void btn_work_directorateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_directorateActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(directorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(directorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(directorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(directorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_directorate == null) {
            work_directorate = new View.workplace.directorate();
        }
        work_directorate.setVisible(true);

    }//GEN-LAST:event_btn_work_directorateActionPerformed
    View.workplace.divisions work_divisions = null;
    private void btn_work_divisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_divisionsActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_divisions == null) {
            work_divisions = new View.workplace.divisions();
        }
        work_divisions.setVisible(true);
    }//GEN-LAST:event_btn_work_divisionsActionPerformed
    View.sity.registerno s_registerno = null;
    private void btn_registernoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registernoActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registerno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (s_registerno == null) {
            s_registerno = new View.sity.registerno();
        }
        s_registerno.setVisible(true);
    }//GEN-LAST:event_btn_registernoActionPerformed
    View.sity.registerplace s_registerplace = null;
    private void btn_registerplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerplaceActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registerplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (s_registerplace == null) {
            s_registerplace = new registerplace();
        }
        s_registerplace.setVisible(true);
    }//GEN-LAST:event_btn_registerplaceActionPerformed
    View.Frame_Tables states = null;
    private void btn_statesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statesActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (states == null) {
            states = new Frame_Tables("اسم محافظة", "state", "محافظات");
        }
        states.setVisible(true);
    }//GEN-LAST:event_btn_statesActionPerformed
    View.sity.district s_district = null;
    private void btn_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_districtActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(district.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(district.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(district.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(district.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (s_district == null) {
            s_district = new View.sity.district();
        }
        s_district.setVisible(true);

    }//GEN-LAST:event_btn_districtActionPerformed
    workcity.work_city_community work_community = null;
    private void btn_work_communityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_communityActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(work_city_community.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(work_city_community.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(work_city_community.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(work_city_community.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_community == null) {
            work_community = new work_city_community();

        }
        work_community.setVisible(true);
    }//GEN-LAST:event_btn_work_communityActionPerformed
    workcity.sub_district_work_city work_sub_district = null;
    private void btn_work_sub_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_sub_districtActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sub_district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sub_district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sub_district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sub_district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_sub_district == null) {
            work_sub_district = new sub_district_work_city();

        }
        work_sub_district.setVisible(true);
    }//GEN-LAST:event_btn_work_sub_districtActionPerformed
    workcity.work_city_governorate work_gover = null;
    private void btn_work_goverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_goverActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(work_city_governorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(work_city_governorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(work_city_governorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(work_city_governorate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_gover == null) {
            work_gover = new workcity.work_city_governorate();
        }
        work_gover.setVisible(true);

    }//GEN-LAST:event_btn_work_goverActionPerformed
    workcity.district_work_city work_district = null;
    private void btn_work_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_work_districtActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(district_work_city.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        if (work_district == null) {
            work_district = new district_work_city();
        }
        work_district.setVisible(true);
    }//GEN-LAST:event_btn_work_districtActionPerformed
    View.Frame_Tables diseases_chronic = null;
    private void btn_diseases__chronicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diseases__chronicActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        if (diseases_chronic == null) {
            diseases_chronic = new Frame_Tables("اسم مرض", "chronic_disease", "الامراض ");
        }
        diseases_chronic.setVisible(true);
    }//GEN-LAST:event_btn_diseases__chronicActionPerformed
    View.Frame_Tables Health_status = null;
    private void btn_Health_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Health_statusActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        if (Health_status == null) {
            Health_status = new Frame_Tables("اسم الإعاقة الجسدية", "physical_handicap", "الاعاقة جسدية");
        }
        Health_status.setVisible(true);
    }//GEN-LAST:event_btn_Health_statusActionPerformed
    View.frmGeneralsearch frm_search = null;

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
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
        if (frm_search == null) {
            frm_search = new frmGeneralsearch();
        }

        frm_search.setVisible(true);
    }//GEN-LAST:event_btn_searchActionPerformed
    View.families_members familiesmembers = null;
    private void btn_families_memersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_families_memersActionPerformed
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
        if (familiesmembers == null) {
            familiesmembers = new families_members(this, true);
        }

        familiesmembers.setVisible(true);
    }//GEN-LAST:event_btn_families_memersActionPerformed
link_chronic_disease_emp lcde = null;
    private void btn_link_chronic_disease_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_link_chronic_disease_empActionPerformed
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
        
        
        if(lcde == null){
            lcde = new link_chronic_disease_emp(this, true);
            
        }
        lcde.setVisible(true);
    }//GEN-LAST:event_btn_link_chronic_disease_empActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(super_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(super_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(super_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(super_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new super_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.extras.FlatButton btn_Health_status;
    private rojeru_san.extras.FlatButton btn_blood;
    private rojeru_san.extras.FlatButton btn_diseases__chronic;
    private rojeru_san.extras.FlatButton btn_district;
    private rojeru_san.extras.FlatButton btn_families_memers;
    private rojeru_san.extras.FlatButton btn_job_change;
    private rojeru_san.extras.FlatButton btn_jop_title;
    private rojeru_san.extras.FlatButton btn_jops_desc;
    private rojeru_san.extras.FlatButton btn_jops_desc4;
    private rojeru_san.extras.FlatButton btn_link_chronic_disease_emp;
    private rojeru_san.extras.FlatButton btn_qual_Name;
    private rojeru_san.extras.FlatButton btn_qual_divisions;
    private rojeru_san.extras.FlatButton btn_qual_type;
    private rojeru_san.extras.FlatButton btn_registerno;
    private rojeru_san.extras.FlatButton btn_registerplace;
    private rojeru_san.extras.FlatButton btn_search;
    private rojeru_san.extras.FlatButton btn_social_status;
    private rojeru_san.extras.FlatButton btn_states;
    private rojeru_san.extras.FlatButton btn_type_of_doc;
    private rojeru_san.extras.FlatButton btn_work_community;
    private rojeru_san.extras.FlatButton btn_work_department;
    private rojeru_san.extras.FlatButton btn_work_directorate;
    private rojeru_san.extras.FlatButton btn_work_district;
    private rojeru_san.extras.FlatButton btn_work_divisions;
    private rojeru_san.extras.FlatButton btn_work_gover;
    private rojeru_san.extras.FlatButton btn_work_ministry;
    private rojeru_san.extras.FlatButton btn_work_sub_district;
    private javax.swing.JPanel group_lists2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_full_name;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panel_Constraint;
    private javax.swing.JPanel panel_address;
    private javax.swing.JPanel panel_qualification;
    private javax.swing.JPanel panel_workplac;
    // End of variables declaration//GEN-END:variables
}
