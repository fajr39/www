/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Date;
import Control.C_employee;
import Control.Lists_Meun;
import Model.m_view_employee;
import RSMaterialComponent.RSTableMetro;
import java.awt.ComponentOrientation;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.oxbow.swingbits.table.filter.TableRowFilterSupport;

/**
 *
 * @author ahmad-soft
 */
public class view_Employees_Confirm extends javax.swing.JFrame {

    /**
     * Creates new form view_employees
     */
    public view_Employees_Confirm() {

        initComponents();
       
        view_emp();
        table_emp = (RSTableMetro) TableRowFilterSupport.forTable(table_emp).searchable(true).useTableRenderers(true).apply();
    }
    int jtable_width = 150;

    public void haded() {
        int column_count = table_emp.getColumnCount();
        for (int i = 0; i < column_count; i++) {
            TableColumn col = table_emp.getColumnModel().getColumn(i);
            col.setPreferredWidth(jtable_width);
        }

    }

    public void view_emp() {
        Lists_Meun.view_emp_all = Lists_Meun.c_view_emp_all.view_employee_All();

        DefaultTableModel modle = new DefaultTableModel();

//        modle.setColumnIdentifiers(new Object[]{"تاريخ مباشرة", "اسم مدخل البيانات", "تاريخ مدخل", " اسم مدقيق البيانات", "تاريخ مدقيق", "تغيرات الوظيفية", "رقم القيد", "مكان القيد", "الأمانة", "المحافظة ", "زمرة دم", " الصفة وظيفية", "المسمى وظيفية", "الوثائق الشخصية", " المحافظة (مكان العمل)", "المنطقة2", "الناحية3", "البلدة4", "المحافظة", "المنطقة",
//            "الناحية", "البلدة", "نوع شهادة", "الاسم شهادة", "أختصاص الشهادة", "الوزارة", "المديرية", "الدائرة", "الشعبة", "عامل الريزوس",
//            "رقم موبايل", "رقم بطاقة", "حالة البيانات", "الحالة الأجتماعية", "الجنس", "تاريخ ", "الاسم الأم", "الاسم وهمي", "الاسم حقيقي أو وهمي",
//            "الكنية", "الاسم الاب ", "الاسم موظف", "رقم موظف"});

//  row[42] = Lists_Meun.view_emp_all.get(i).getId_emp();
//         //   row[0] = Lists_Meun.view_emp_all.get(i).getDate_check();  0
//         //   row[1] = Lists_Meun.view_emp_all.get(i).getUser_checker(); 1
//            row[2] = Lists_Meun.view_emp_all.get(i).getDate_entrytime();
//            row[3] = Lists_Meun.view_emp_all.get(i).getData_entry();
//            row[4] = Lists_Meun.view_emp_all.get(i).getStart_date();//لسا
//            row[5] = Lists_Meun.view_emp_all.get(i).getJop_change();//لسا
//            row[6] = Lists_Meun.view_emp_all.get(i).getRegisterno();
//            row[7] = Lists_Meun.view_emp_all.get(i).getRegisterplace();
//            row[8] = Lists_Meun.view_emp_all.get(i).getDistrict();
//            row[9] = Lists_Meun.view_emp_all.get(i).getStates();
//            row[10] = Lists_Meun.view_emp_all.get(i).getBlood_name();
//            row[11] = Lists_Meun.view_emp_all.get(i).getJop_title();
//            row[12] = Lists_Meun.view_emp_all.get(i).getJops_description();
//            row[13] = Lists_Meun.view_emp_all.get(i).getType_of_doc_name();
//            row[14] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_governorate();// المحافظة  مكان السكن
//            row[15] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_district();// منطقة  مكان السكن
//            row[16] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_sub_district();// ناحية  مكان السكن
//            row[17] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_community();// البلدة  مكان السكن
//            row[18] = Lists_Meun.view_emp_all.get(i).getCurrent_city_governorate(); // المحافظة  مكان العمل
//            row[19] = Lists_Meun.view_emp_all.get(i).getCurrent_city_district();// منطقة  مكان العمل
//            row[20] = Lists_Meun.view_emp_all.get(i).getCurrent_city_sub_district();// ناحية  مكان العمل
//            row[21] = Lists_Meun.view_emp_all.get(i).getCurrent_city_community();// البلدة  مكان العمل  
//            row[22] = Lists_Meun.view_emp_all.get(i).getQualification_name();
//            row[23] = Lists_Meun.view_emp_all.get(i).getQualification_type();
//            row[24] = Lists_Meun.view_emp_all.get(i).getQualification_divisions();
//            row[25] = Lists_Meun.view_emp_all.get(i).getWork_place_ministry();
//            row[26] = Lists_Meun.view_emp_all.get(i).getWork_place_directorates();
//            row[27] = Lists_Meun.view_emp_all.get(i).getWork_place_department();
//            row[28] = Lists_Meun.view_emp_all.get(i).getWork_place_divisions();
//            row[29] = Lists_Meun.view_emp_all.get(i).isRh();
//            row[30] = Lists_Meun.view_emp_all.get(i).getPhonenumer();
//            row[31] = Lists_Meun.view_emp_all.get(i).getId_number();
//           //  row[32] = Lists_Meun.view_emp_all.get(i).getState_of_data_name();//32
//            row[33] = Lists_Meun.view_emp_all.get(i).getSocial_status_name();
//            row[34] = Lists_Meun.view_emp_all.get(i).isSex();
//            row[35] = Lists_Meun.view_emp_all.get(i).getBrith_date();
//            row[36] = Lists_Meun.view_emp_all.get(i).getMother_fullname();
//            row[37] = Lists_Meun.view_emp_all.get(i).getFictitiousname();
//            row[38] = Lists_Meun.view_emp_all.get(i).isNature_of_name();
//            row[39] = Lists_Meun.view_emp_all.get(i).getLname();
//            row[40] = Lists_Meun.view_emp_all.get(i).getMname();
    //            row[41] = Lists_Meun.view_emp_all.get(i).getFname();

        modle.setColumnIdentifiers(new Object[]{"تاريخ المباشرة", "اسم مدخل البيانات", "تاريخ المدخل", "التغيرات الوظيفية", "رقم القيد", "مكان القيد", "الأمانة", "المحافظة ", "زمرة دم", " الصفة وظيفية", "المسمى وظيفية", "الوثائق الشخصية", 
            " المحافظة (مكان العمل)", "المنطقة(مكان العمل)", "الناحية(مكان العمل)", "البلدة(مكان العمل)", "المحافظة", "المنطقة",
            "الناحية", "البلدة", "اسم الشهادة", "نوع الشهادة", "أختصاص الشهادة", "الوزارة", "المديرية", "الدائرة", "الشعبة", "عامل الريزوس",
            "رقم الموبايل", "رقم البطاقة", "الحالة الأجتماعية", "الجنس", "التاريخ ", "اسم الأم", "الاسم الوهمي", "الاسم الحقيقي أو الوهمي",
            "الكنية", "اسم الاب ", "اسم الموظف", "رقم الموظف"});
        Object[] row = new Object[40];
        for (int i = 0; i < Lists_Meun.view_emp_all.size(); i++) {

            row[39] = Lists_Meun.view_emp_all.get(i).getId_emp();
         //   row[0] = Lists_Meun.view_emp_all.get(i).getDate_check();  0
         //   row[1] = Lists_Meun.view_emp_all.get(i).getUser_checker(); 1
            row[0] = Lists_Meun.view_emp_all.get(i).getDate_entrytime();
            row[1] = Lists_Meun.view_emp_all.get(i).getData_entry();
            row[2] = Lists_Meun.view_emp_all.get(i).getStart_date();//لسا
            row[3] = Lists_Meun.view_emp_all.get(i).getJop_change();//لسا
            row[4] = Lists_Meun.view_emp_all.get(i).getRegisterno();
            row[5] = Lists_Meun.view_emp_all.get(i).getRegisterplace();
            row[6] = Lists_Meun.view_emp_all.get(i).getDistrict();
            row[7] = Lists_Meun.view_emp_all.get(i).getStates();
            row[8] = Lists_Meun.view_emp_all.get(i).getBlood_name();
            row[9] = Lists_Meun.view_emp_all.get(i).getJop_title();
            row[10] = Lists_Meun.view_emp_all.get(i).getJops_description();
            row[11] = Lists_Meun.view_emp_all.get(i).getType_of_doc_name();
            row[12] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_governorate();// المحافظة  مكان السكن
            row[13] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_district();// منطقة  مكان السكن
            row[14] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_sub_district();// ناحية  مكان السكن
            row[15] = Lists_Meun.view_emp_all.get(i).getCurrent_work_city_community();// البلدة  مكان السكن
            row[16] = Lists_Meun.view_emp_all.get(i).getCurrent_city_governorate(); // المحافظة  مكان العمل
            row[17] = Lists_Meun.view_emp_all.get(i).getCurrent_city_district();// منطقة  مكان العمل
            row[18] = Lists_Meun.view_emp_all.get(i).getCurrent_city_sub_district();// ناحية  مكان العمل
            row[19] = Lists_Meun.view_emp_all.get(i).getCurrent_city_community();// البلدة  مكان العمل  
            row[20] = Lists_Meun.view_emp_all.get(i).getQualification_name();
            row[21] = Lists_Meun.view_emp_all.get(i).getQualification_type();
            row[22] = Lists_Meun.view_emp_all.get(i).getQualification_divisions();
            row[23] = Lists_Meun.view_emp_all.get(i).getWork_place_ministry();
            row[24] = Lists_Meun.view_emp_all.get(i).getWork_place_directorates();
            row[25] = Lists_Meun.view_emp_all.get(i).getWork_place_department();
            row[26] = Lists_Meun.view_emp_all.get(i).getWork_place_divisions();
            row[27] = Lists_Meun.view_emp_all.get(i).isRh();
            row[28] = Lists_Meun.view_emp_all.get(i).getPhonenumer();
            row[29] = Lists_Meun.view_emp_all.get(i).getId_number();
           //  row[32] = Lists_Meun.view_emp_all.get(i).getState_of_data_name();//32
            row[30] = Lists_Meun.view_emp_all.get(i).getSocial_status_name();
            row[31] = Lists_Meun.view_emp_all.get(i).isSex();
            row[32] = Lists_Meun.view_emp_all.get(i).getBrith_date();
            row[33] = Lists_Meun.view_emp_all.get(i).getMother_fullname();
            row[34] = Lists_Meun.view_emp_all.get(i).getFictitiousname();
            row[35] = Lists_Meun.view_emp_all.get(i).isNature_of_name();
            row[36] = Lists_Meun.view_emp_all.get(i).getLname();
            row[37] = Lists_Meun.view_emp_all.get(i).getMname();
            row[38] = Lists_Meun.view_emp_all.get(i).getFname();

//            
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
        jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table_emp.setModel(modle);
        haded();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_table = new javax.swing.JPopupMenu();
        menu_update = new javax.swing.JMenuItem();
        menu_delete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_emp = new RSMaterialComponent.RSTableMetro();
        btn_jops_desc4 = new rojeru_san.extras.FlatButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnadd = new RSMaterialComponent.RSButtonMaterialShadow();

        menu_update.setText("تأكيد الموظف");
        menu_table.add(menu_update);

        menu_delete.setText("حذف الموظف");
        menu_table.add(menu_delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(16, 141, 143));

        table_emp.setBackground(new java.awt.Color(254, 254, 254));
        table_emp.setForeground(new java.awt.Color(221, 168, 8));
        table_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "null", "Title 3", "Title 4"
            }
        ));
        table_emp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table_emp.setBackgoundHead(new java.awt.Color(16, 141, 143));
        table_emp.setBackgoundHover(new java.awt.Color(185, 146, 79));
        table_emp.setColorBorderHead(new java.awt.Color(254, 254, 254));
        table_emp.setColorPrimaryText(new java.awt.Color(1, 1, 1));
        table_emp.setColorSecondary(new java.awt.Color(254, 254, 254));
        table_emp.setColorSecundaryText(new java.awt.Color(1, 1, 1));
        table_emp.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        table_emp.setFontHead(new java.awt.Font("DIN Next LT Arabic", 1, 15)); // NOI18N
        table_emp.setFontRowHover(new java.awt.Font("Arial", 1, 13)); // NOI18N
        table_emp.setFontRowSelect(new java.awt.Font("Arial", 1, 13)); // NOI18N
        table_emp.setForegroundHead(new java.awt.Color(254, 254, 254));
        table_emp.setSelectionBackground(new java.awt.Color(185, 146, 79));
        table_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_empMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_empMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_emp);
        if (table_emp.getColumnModel().getColumnCount() > 0) {
            table_emp.getColumnModel().getColumn(1).setPreferredWidth(3);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1410, 580));

        btn_jops_desc4.setBackground(new java.awt.Color(255, 255, 255));
        btn_jops_desc4.setText("X");
        btn_jops_desc4.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        btn_jops_desc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jops_desc4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_jops_desc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("وزارة التنمية والشؤون الإنسانية");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("برنامج أتمتة شؤون الموظفين");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        btnadd.setBackground(new java.awt.Color(185, 146, 79));
        btnadd.setText(" رجوع ");
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
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1473, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  View.AddEmp view_emp = null;

    Control.C_employee a = new C_employee();
    ArrayList<m_view_employee> c = new ArrayList<>();

    private void table_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_empMouseClicked
//        int  id_emp = (int)table_emp.getValueAt(table_emp.getSelectedRow(), 37);
////Model.m_view_employee a = new m_view_employee();
//txt_id.setText(String.valueOf(id_emp));

        if (view_emp == null) {
            view_emp = new AddEmp();
        }
        Integer emp_id = (Integer) table_emp.getValueAt(table_emp.getSelectedRow(), 39);
        Date start_date = (Date) table_emp.getValueAt(table_emp.getSelectedRow(), 2);
        String name_jop_change = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 3);
        String fname = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 38);
        String mname = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 37);
        String lname = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 36);
        boolean nature__name = (boolean) table_emp.getValueAt(table_emp.getSelectedRow(), 35);
        String txt_nature_name = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 34);
        String mother_name = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 33);
        Date brith_date = (Date) table_emp.getValueAt(table_emp.getSelectedRow(), 32);
        boolean sex_emp = (boolean) table_emp.getValueAt(table_emp.getSelectedRow(), 31);
        String txt_social_status = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 30);
        Integer Id_number = (Integer) table_emp.getValueAt(table_emp.getSelectedRow(), 29);
        Integer phone_number = (Integer) table_emp.getValueAt(table_emp.getSelectedRow(), 28);
        boolean rh_checke = (boolean) table_emp.getValueAt(table_emp.getSelectedRow(), 27);
        
        
        String name_department = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 25);
        String name_Divisions = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 26);
        String name_directorates = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 24);
        String name_Ministry = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 23);
        String name_Qualification_divisions = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 22);
        String name_Qualification_type = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 21);
        String name_Qualification_name = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 20);//aaaa

        String name_city_community = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 19);// البلدة  مكان العمل
        String name_city_sub_district = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 18);// الناحية  مكان العمل
        String name_city_district = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 17);// منطقة  مكان العمل
        String name_city_governorate = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 16); // المحافظة  مكان العمل

        String txt_work_city_community = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 15);// البلدة  مكان السكن
        String txt_work_city_sub_district = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 14);// الناحية  مكان السكن
        String txt_work_city_district = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 13);// المنطقة  مكان السكن
        String name_work_city_governorate = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 12); // المحافظة  مكان السكن

        String txt_type_of_doc = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 11);
           String txt_Jops_description = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 10);
        String txt_Jop_title = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 9);
        String txt_blood = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 8);
        String txt_States = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 7);
        String txt_States_district = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 6);
        String txt_States_district_registerplace = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 5);
        String txt_States_district_registerplace_registerno = (String) table_emp.getValueAt(table_emp.getSelectedRow(), 4);

//        a.setFname(fname);
        view_emp.firstnamep.setText(fname);
        view_emp.middlename.setText(mname);
        view_emp.lastname.setText(lname);
        view_emp.motherfullname.setText(mother_name);
        view_emp.nature_name.setSelected(nature__name);
        view_emp.txt_nature_name.setText(txt_nature_name);
        view_emp.txt_brith_date.setDate(brith_date);
        if (sex_emp) {
            view_emp.V_male.setSelected(true);
        } else {
            view_emp.V_female.setSelected(true);
        }
        for (int i = 0; i < view_emp.id_social_status.getItemCount(); i++) {
            if (((Model.Model_Tables) view_emp.id_social_status.getItemAt(i)).getColumn_Name().equals(txt_social_status)) {
                view_emp.id_social_status.setSelectedIndex(i);
            }
        }

        view_emp.idnumber.setText(String.valueOf(Id_number));
        view_emp.phonenumber.setText(String.valueOf(phone_number));
        view_emp.chk_rhp.setSelected(rh_checke);

        for (int i = 0; i < view_emp.cmb_Ministry.getItemCount(); i++) {
            if (((Model.M_Ministry) view_emp.cmb_Ministry.getItemAt(i)).getDescription().equals(name_Ministry)) {
                view_emp.cmb_Ministry.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_Directorates.getItemCount(); i++) {
            if (((Model.M_Directorates) view_emp.cmb_Directorates.getItemAt(i)).getDescription().equals(name_directorates)) {
                view_emp.cmb_Directorates.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_department.getItemCount(); i++) {
            if (((Model.M_Department) view_emp.cmb_department.getItemAt(i)).getDescription().equals(name_department)) {
                view_emp.cmb_department.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_Divisions.getItemCount(); i++) {
            if (((Model.M_Divisions) view_emp.cmb_Divisions.getItemAt(i)).getDescription().equals(name_Divisions)) {
                view_emp.cmb_Divisions.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < view_emp.cmb_Qualification_Name.getItemCount(); i++) {
            if (((Model.M_Qualification_Name) view_emp.cmb_Qualification_Name.getItemAt(i)).getDescription().equals(name_Qualification_name)) {
                view_emp.cmb_Qualification_Name.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_Qualification_Type.getItemCount(); i++) {
            if (((Model.M_Qualification_Type) view_emp.cmb_Qualification_Type.getItemAt(i)).getDescription().equals(name_Qualification_type)) {
                view_emp.cmb_Qualification_Type.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_qualification_divisions.getItemCount(); i++) {
            if (((Model.M_Qualification_Division) view_emp.cmb_qualification_divisions.getItemAt(i)).getDescription().equals(name_Qualification_divisions)) {
                view_emp.cmb_qualification_divisions.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_type_of_doc.getItemCount(); i++) {
            if (((Model.Model_Tables) view_emp.cmb_type_of_doc.getItemAt(i)).getColumn_Name().equals(txt_type_of_doc)) {
                view_emp.cmb_type_of_doc.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_Jop_title.getItemCount(); i++) {
            if (((Model.m_jops) view_emp.cmb_Jop_title.getItemAt(i)).getDescription().equals(txt_Jop_title)) {
                view_emp.cmb_Jop_title.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_Jops_description.getItemCount(); i++) {
            if (((Model.m_jops) view_emp.cmb_Jops_description.getItemAt(i)).getDescription().equals(txt_Jops_description)) {
                view_emp.cmb_Jops_description.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_blood.getItemCount(); i++) {
            if (((Model.Model_Tables) view_emp.cmb_blood.getItemAt(i)).getColumn_Name().equals(txt_blood)) {
                view_emp.cmb_blood.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.governnorates_States.getItemCount(); i++) {
            if (((Model.Model_Tables) view_emp.governnorates_States.getItemAt(i)).getColumn_Name().equals(txt_States)) {
                view_emp.governnorates_States.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_States_district.getItemCount(); i++) {
            if (((Model.m_district) view_emp.cmb_States_district.getItemAt(i)).getName().equals(txt_States_district)) {
                view_emp.cmb_States_district.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_States_district_registerplace.getItemCount(); i++) {
            if (((Model.m_registerplace) view_emp.cmb_States_district_registerplace.getItemAt(i)).getName().equals(txt_States_district_registerplace)) {
                view_emp.cmb_States_district_registerplace.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.cmb_States_district_registerplace_registerno.getItemCount(); i++) {
            if (((Model.m_registerno) view_emp.cmb_States_district_registerplace_registerno.getItemAt(i)).getName().equals(txt_States_district_registerplace_registerno)) {
                view_emp.cmb_States_district_registerplace_registerno.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_work_city_governorate.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_work_city_governorate.getItemAt(i)).getDescription().equals(name_work_city_governorate)) {
                view_emp.current_work_city_governorate.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_work_city_district.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_work_city_district.getItemAt(i)).getDescription().equals(txt_work_city_district)) {
                view_emp.current_work_city_district.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_work_city_sub_district.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_work_city_sub_district.getItemAt(i)).getDescription().equals(txt_work_city_sub_district)) {
                view_emp.current_work_city_sub_district.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_work_city_community.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_work_city_community.getItemAt(i)).getDescription().equals(txt_work_city_community)) {
                view_emp.current_work_city_community.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_city_governorate.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_city_governorate.getItemAt(i)).getDescription().equals(name_city_governorate)) {
                view_emp.current_city_governorate.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_city_district.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_city_district.getItemAt(i)).getDescription().equals(name_city_district)) {
                view_emp.current_city_district.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_city_sub_district.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_city_sub_district.getItemAt(i)).getDescription().equals(name_city_sub_district)) {
                view_emp.current_city_sub_district.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_city_community.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_city_community.getItemAt(i)).getDescription().equals(name_city_community)) {
                view_emp.current_city_community.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.current_city_community.getItemCount(); i++) {
            if (((Model.m_work_city) view_emp.current_city_community.getItemAt(i)).getDescription().equals(name_city_community)) {
                view_emp.current_city_community.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < view_emp.id_jop_change.getItemCount(); i++) {
            if (((Model.Model_Tables) view_emp.id_jop_change.getItemAt(i)).getColumn_Name().equals(name_jop_change)) {
                view_emp.id_jop_change.setSelectedIndex(i);
            }
        }
        view_emp.start_date.setDate(start_date);
        view_emp.txt_id.setVisible(false);
        view_emp.txt_id.setText(String.valueOf(emp_id));

        view_emp.btn_Dataconfirmation.setVisible(true);
        view_emp.btnadd.setVisible(false);

        this.dispose();
        view_emp.setVisible(true);

    }//GEN-LAST:event_table_empMouseClicked

    private void btn_jops_desc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jops_desc4ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_jops_desc4ActionPerformed

    private void table_empMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_empMouseReleased

    }//GEN-LAST:event_table_empMouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased
    View.main main = null;
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        if (main == null) {
            main = new main();
        }
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnaddActionPerformed

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
            java.util.logging.Logger.getLogger(view_Employees_Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_Employees_Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_Employees_Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_Employees_Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_Employees_Confirm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.extras.FlatButton btn_jops_desc4;
    private RSMaterialComponent.RSButtonMaterialShadow btnadd;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menu_delete;
    private javax.swing.JPopupMenu menu_table;
    private javax.swing.JMenuItem menu_update;
    public RSMaterialComponent.RSTableMetro table_emp;
    // End of variables declaration//GEN-END:variables
}
