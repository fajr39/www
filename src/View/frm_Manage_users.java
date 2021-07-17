/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Lists_Meun;
import Control.control_user_admin;
import Control.generalcontrol;
import Model.general_Model;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;
import Model.m_User;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmad-soft
 */
public class frm_Manage_users extends javax.swing.JFrame {

    public String satat;

    public boolean b1 = false;

    /**
     * Creates new form ministry
     */
    public frm_Manage_users() {
        initComponents(); 
        txt_id.setVisible(false);
        fill_users();
    }

    public void fill_users() {

      
        Lists_Meun.array_view_users = Lists_Meun.view_Manage_users.view_users();
        DefaultTableModel modle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modle.setColumnIdentifiers(new Object[]{"رقم", "الاسم موظف", "الاسم الاب", " الكنية", "نوع المستخدم","حالة المستخدم"});
        Object[] row = new Object[6];
        for (int i = 0; i < Lists_Meun.array_view_users.size(); i++) {
            row[0] = Lists_Meun.array_view_users.get(i).getID();
            row[1] = Lists_Meun.array_view_users.get(i).getFirst_name();
            row[2] = Lists_Meun.array_view_users.get(i).getMiddle_name();
            row[3] = Lists_Meun.array_view_users.get(i).getLast_name();
            row[4] = Lists_Meun.array_view_users.get(i).getUser_type();
            row[5] = Lists_Meun.array_view_users.get(i).isState();
            modle.addRow(row);
        }
        tableDirect.setModel(modle);
    }


    Control.generalcontrol control_general = new generalcontrol();
    Model.general_Model model_general = new general_Model();

    Model.m_User model = new m_User();
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        materialShadowCircle1 = new efectos.MaterialShadowCircle();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_password = new RSMaterialComponent.RSPasswordMaterial();
        lbl_name1 = new javax.swing.JLabel();
        chk_password = new RSMaterialComponent.RSCheckBoxMaterial();
        jLabel1 = new javax.swing.JLabel();
        btn_del = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_Exit = new RSMaterialComponent.RSButtonMaterialShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDirect = new rojerusan.RSTableMetro();
        btn_add1 = new RSMaterialComponent.RSButtonMaterialShadow();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_password.setBackground(new java.awt.Color(254, 254, 254));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(202, 77, 77)));
        txt_password.setForeground(new java.awt.Color(1, 1, 1));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_password.setDisabledTextColor(new java.awt.Color(254, 254, 254));
        txt_password.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txt_password.setPhColor(new java.awt.Color(185, 146, 79));
        txt_password.setPlaceholder("");
        txt_password.setSelectionColor(new java.awt.Color(185, 146, 79));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 220, 40));

        lbl_name1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name1.setText("كلمة المرور");
        jPanel2.add(lbl_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, -1, -1));

        chk_password.setForeground(new java.awt.Color(11, 10, 8));
        chk_password.setText("إظهار كلمة المرور");
        chk_password.setColorCheck(new java.awt.Color(185, 146, 79));
        chk_password.setColorUnCheck(new java.awt.Color(185, 146, 79));
        chk_password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        chk_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chk_password.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_password.setIsEffectRipple(false);
        chk_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(chk_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 110, -1));

        jLabel1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 30)); // NOI18N
        jLabel1.setText("إدارة مستخدمين");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

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
        jPanel2.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 90, 50));

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
        jPanel2.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 90, 50));

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
        tableDirect.setRowHeight(25);
        tableDirect.getTableHeader().setResizingAllowed(false);
        tableDirect.getTableHeader().setReorderingAllowed(false);
        tableDirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDirectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDirect);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1150, 270));

        btn_add1.setBackground(new java.awt.Color(185, 146, 79));
        btn_add1.setText("تعديل");
        btn_add1.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_add1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_add1.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_add1.setEffectFocus(true);
        btn_add1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 90, 50));

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 50, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 1170, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tableDirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDirectMouseClicked
        int i = (int) tableDirect.getValueAt(tableDirect.getSelectedRow(), 0);
        txt_id.setText(String.valueOf(i));
        btn_del.setEnabled(true);
    }//GEN-LAST:event_tableDirectMouseClicked

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed

       this.dispose();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        try {
            if (txt_id.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "الرجاء اختار الاسم مستخدم  للحذف عليها");
             //   new rojerusan.RSNotifyAnimated("معلومات", "الرجاء اختار الاسم مستخدم  للحذف عليها", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
//            model_general.setId(Integer.valueOf(txt_id.getText()));
//            control_general.delete(model_general, "permisiones");
 model.setID(Integer.valueOf(txt_id.getText()));
            boolean a = Lists_Meun.view_Manage_users.delete_user(model);
            if (a == true) {
               
                fill_users();
                btn_del.setEnabled(false);
              JOptionPane.showMessageDialog(null, "تم حذف بيانات بنجاح");
             //   new rojerusan.RSNotifyAnimated("معلومات", "تم حذف بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
               
                btn_del.setEnabled(false);
                  JOptionPane.showMessageDialog(null, "لا  يوجد صلاحية");
             //   new rojerusan.RSNotifyAnimated("معلومات", "لا  يوجد صلاحية", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error  go -> btnDelete " + ex.getMessage());
        }

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
//
//        try {
//            if (comb_users.getSelectedItem() == null || cmb_Ministry.getSelectedItem() == null || List_Directorates.getSelectedValue() == null) {
//                new rojerusan.RSNotifyAnimated("معلومات", "الرجاء عم ترك مربع فارغ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
//                return;
//            }
//
//            int[] selected = List_Directorates.getSelectedIndices();
//            for (int i = 0; i < selected.length; i++) {
//                int id_Directorate = ((M_Directorates) List_Directorates.getModel().getElementAt(i)).getID();
//                int id_users1 = ((m_User) comb_users.getSelectedItem()).getID();
//                model.setId_work_place(id_Directorate);
//                model.setID(id_users1);
//                con.add_permisions(model);
//
//            }
//            new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة  صلاحية بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
//            fill_permisiones();
//            Emptied_users();
//            Emptied_Ministry_Directorates();
//            fill_view_users();
////            full_Direct();
//            fill_Ministry();
//       
//            List_Directorates.setEnabled(false);
//            cmb_Ministry.setEnabled(false);
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error in   categories (View) go in btnAdd" + ex.getMessage());
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void chk_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_passwordActionPerformed

        if (chk_password.isSelected()) {
            txt_password.setEchoChar((char) 0);

        } else {
            txt_password.setEchoChar(('*'));
        }
    }//GEN-LAST:event_chk_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Manage_users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_Manage_users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit;
    private RSMaterialComponent.RSButtonMaterialShadow btn_add1;
    private RSMaterialComponent.RSButtonMaterialShadow btn_del;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSCheckBoxMaterial chk_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_name1;
    private efectos.MaterialShadowCircle materialShadowCircle1;
    private rojerusan.RSTableMetro tableDirect;
    private javax.swing.JTextField txt_id;
    private RSMaterialComponent.RSPasswordMaterial txt_password;
    // End of variables declaration//GEN-END:variables

}
