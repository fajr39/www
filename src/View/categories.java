/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.qualification.*;
import View.workplace.*;

import Control.C_Qualification_Name;
import Control.Funiction_Tables;
import Control.Lists_Meun;
import Model.M_Ministry;
import Model.Model_Tables;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;

import Control.c_categories;
import Control.generalcontrol;

import Model.general_Model;
import Model.getall;
import Model.m_categories;

/**
 *
 * @author ahmad-soft
 */
public class categories extends javax.swing.JFrame {

    /**
     * Creates new form ministry
     */
    public categories() {
        initComponents();
        loadcombobox();
      fill();
         txt_id.setVisible(false);
    }

    Model.general_Model m = new general_Model();
    Control.generalcontrol c = new generalcontrol();
    
    
    
    Model.m_categories model = new m_categories();
    Control.c_categories con = new c_categories();
    

//    Control.Funiction_Tables Conter_tables;
//    public void fullcombobox(){
//        ArrayList<Model_Tables> a = Conter_tables.filltable("states");
//        V_socil_status_p.setModel(new DefaultComboBoxModel(Lists_Meun.A_social.toArray()));
//        
//        
//        
//        Conter_tables = new Funiction_Tables();
//        ArrayList<Model_Tables> a = Conter_tables.filltable(nameTable);
//        Model.getall n = new getall(a);
//        tableDirect.setModel(n);
//    }
    public void fill() {
      //  Control.Lists_Meun.Array_Qual_Name= c.view_Qualification_Name();
      
       
       Control.c_categories v = new c_categories();
       Model.m_categories b = new m_categories();
       ArrayList<m_categories> c = new ArrayList<>();
       
       c = v.filltable("categories");
        DefaultTableModel modle = new DefaultTableModel();
        modle.setColumnIdentifiers(new Object[]{"نوع العملة", "راتب المقطوع","الفئة","رقم"});
        Object[] row = new Object[4];
        for (int i = 0; i < c.size(); i++) {
            row[3]= c.get(i).getId();
            row[0]=  c.get(i).getName_column3();
            row[1] = c.get(i).getName_column2();
            row[2] = c.get(i).getName_column1();
            
            
            modle.addRow(row);
        }
        tableDirect.setModel(modle);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new RSMaterialComponent.RSTextFieldMaterial();
        lbl_name = new javax.swing.JLabel();
        btn_del = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_add = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_update = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_Exit = new RSMaterialComponent.RSButtonMaterialShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDirect = new rojerusan.RSTableMetro();
        txt_id = new javax.swing.JTextField();
        lbl_name1 = new javax.swing.JLabel();
        txt_salary = new RSMaterialComponent.RSTextFieldMaterial();
        cmb_tyep_salary = new RSMaterialComponent.RSComboBoxMaterial<>();
        N_type_of_doc_p1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("واجهة الفئات");

        txt_name.setBackground(new java.awt.Color(254, 254, 254));
        txt_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_name.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txt_name.setPlaceholder("");
        txt_name.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_name.setSelectionColor(new java.awt.Color(142, 137, 137));

        lbl_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name.setText("اسم الفئة");

        btn_del.setBackground(new java.awt.Color(185, 146, 79));
        btn_del.setText("حذف");
        btn_del.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_del.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_del.setEffectFocus(true);
        btn_del.setEnabled(false);
        btn_del.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(185, 146, 79));
        btn_add.setText("اضافة");
        btn_add.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_add.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_add.setEffectFocus(true);
        btn_add.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(185, 146, 79));
        btn_update.setText("تعديل");
        btn_update.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_update.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_update.setEffectFocus(true);
        btn_update.setEnabled(false);
        btn_update.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_Exit.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit.setText("خروج");
        btn_Exit.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit.setEffectFocus(true);
        btn_Exit.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        tableDirect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "الاسم حالة الإجتماعية", "الرقم حالة"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDirect.setColorBackgoundHead(new java.awt.Color(185, 146, 79));
        tableDirect.setColorFilasBackgound2(new java.awt.Color(71, 60, 42));
        tableDirect.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tableDirect.setColorFilasForeground2(new java.awt.Color(253, 251, 251));
        tableDirect.setColorSelBackgound(new java.awt.Color(185, 146, 79));
        tableDirect.setFont(new java.awt.Font("Arial CE", 1, 15)); // NOI18N
        tableDirect.setFuenteFilas(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableDirect.setFuenteFilasSelect(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableDirect.setFuenteHead(new java.awt.Font("Arial", 1, 15)); // NOI18N
        tableDirect.setRowHeight(20);
        tableDirect.getTableHeader().setResizingAllowed(false);
        tableDirect.getTableHeader().setReorderingAllowed(false);
        tableDirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDirectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDirect);

        lbl_name1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name1.setText("الراتب المقطوع");

        txt_salary.setBackground(new java.awt.Color(254, 254, 254));
        txt_salary.setForeground(new java.awt.Color(1, 1, 1));
        txt_salary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_salary.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_salary.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_salary.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txt_salary.setPlaceholder("");
        txt_salary.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_salary.setSelectionColor(new java.awt.Color(142, 137, 137));

        cmb_tyep_salary.setBackground(new java.awt.Color(254, 254, 254));
        cmb_tyep_salary.setForeground(new java.awt.Color(1, 1, 1));
        cmb_tyep_salary.setToolTipText("");
        cmb_tyep_salary.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_tyep_salary.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_tyep_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tyep_salaryActionPerformed(evt);
            }
        });

        N_type_of_doc_p1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        N_type_of_doc_p1.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p1.setText("نوع العملة");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lbl_name))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmb_tyep_salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbl_name1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(N_type_of_doc_p1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_name))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_name1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_tyep_salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(N_type_of_doc_p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 840, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed

        try {
            if (txt_name.getText() != null && txt_id.getText().equals("")) {
                new rojerusan.RSNotifyAnimated("معلومات", "الرجاء اختار الاسم  للحذف عليها", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            m.setId(Integer.valueOf(txt_id.getText()));  
            c.delete(m, "categories");
           fill();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
            new rojerusan.RSNotifyAnimated("معلومات", "تم حذف بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            txt_name.setText("");
            txt_id.setText("");
            txt_salary.setText("");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error  go -> btnDeleteMouseClicked in M_Ministry" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        try {
            if (txt_name.getText().equals("")) {
                new rojerusan.RSNotifyAnimated("معلومات", "الرجاء عم ترك مربع فارغ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                return;
            }

            m.setTalbe_name("categories");
            m.setName_column1("name");
            m.setName_column2("salary");
            m.setName_column3("currency::enum_currency");
            m.setValue1(txt_name.getText());
            m.setValue2(String.valueOf(txt_salary.getText()));
            m.setValue3(cmb_tyep_salary.getSelectedItem().toString());
            boolean i = c.add3(m);
            if (i == true) {
            fill();
                txt_name.requestFocus();
              fill();
                new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                txt_name.requestFocus();
           fill();
                new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة اسم قبل مرة ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);

            }
            txt_name.setText("");
            txt_name.requestFocus();
            txt_salary.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in   categories (View) go in btnAdd" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {

            if (txt_name.getText() != null && txt_id.getText().equals("")) {
                new rojerusan.RSNotifyAnimated("معلومات", "الرجاء اختار الاسم  للتعديل عليها", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            model.setId(Integer.valueOf(txt_id.getText()));
            model.setTalbe_name("categories");
            model.setName_column1("name");
            model.setName_column2("salary");
            model.setName_column3("currency::enum_currency");
            model.setValue1(txt_name.getText());
            model.setValue2(String.valueOf(txt_salary.getText()));
            model.setValue3(cmb_tyep_salary.getSelectedItem().toString());


          con.update(model);
           fill();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
            new rojerusan.RSNotifyAnimated("معلومات", "تم تعديل بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            txt_name.setText("");
            txt_salary.setText("");
            txt_id.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error  go -> btnUpdateMouseClicked in vDirectorate" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void tableDirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDirectMouseClicked
        int i = (int) tableDirect.getValueAt(tableDirect.getSelectedRow(), 3);
        String s = (String) tableDirect.getValueAt(tableDirect.getSelectedRow(), 2);
        String s1 = (String) tableDirect.getValueAt(tableDirect.getSelectedRow(), 1);
        
        txt_id.setText(String.valueOf(i));
        txt_name.setText(s);
        txt_salary.setText(String.valueOf(s1));
        btn_del.setEnabled(true);
        btn_update.setEnabled(true);
    }//GEN-LAST:event_tableDirectMouseClicked

    private void cmb_tyep_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tyep_salaryActionPerformed
        // TODO add your handling code here:
//        btn_Next.setEnabled(true);
    }//GEN-LAST:event_cmb_tyep_salaryActionPerformed

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
            java.util.logging.Logger.getLogger(categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N_type_of_doc_p1;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit;
    private RSMaterialComponent.RSButtonMaterialShadow btn_add;
    private RSMaterialComponent.RSButtonMaterialShadow btn_del;
    private RSMaterialComponent.RSButtonMaterialShadow btn_update;
    private RSMaterialComponent.RSComboBoxMaterial<Model.enum_currency> cmb_tyep_salary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_name1;
    private rojerusan.RSTableMetro tableDirect;
    private javax.swing.JTextField txt_id;
    private RSMaterialComponent.RSTextFieldMaterial txt_name;
    private RSMaterialComponent.RSTextFieldMaterial txt_salary;
    // End of variables declaration//GEN-END:variables

    private void loadcombobox() {
        cmb_tyep_salary.setModel(new DefaultComboBoxModel<>(Model.enum_currency.values()));
    }
}