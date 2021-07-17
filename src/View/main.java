/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.control_user_admin;
import Model.m_User;
import View.qualification.qualification_Name;
import View.qualification.qualification_divisions;
import View.qualification.qualification_type;
import View.sity.registerno;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ahmad-soft
 */
public class main extends javax.swing.JFrame {

    
    Model.m_User a = new m_User();
    Control.control_user_admin c = new control_user_admin();
    
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
      lbl_user_fullname1.setText(Login.fill_name_user);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Main.png")));
        btnadd.requestFocus();
        user_button();
        btn_frm_families_members.setVisible(false);
        btn_frmlink_chronic_disease_emp.setVisible(false);
        clock();

    }

    public void user_button() {

        Control.control_user_admin info = new control_user_admin();
        String user_type = info.get_info_type(Login.name_user);
        switch (user_type) {
            case "data_entry":
                btn_frmlink_chronic_disease_emp.setVisible(false);
                btn_view.setVisible(false);
                btnadd.setVisible(true);
                btn_frm_families_members.setVisible(false);
                break;
            case "data_checker":
                btn_view_emp.setVisible(false);
                btn_frmlink_chronic_disease_emp.setVisible(false);
             btn_frm_families_members.setVisible(false);
                btnadd.setVisible(false);
                break;
            default:
        }

    }


    public main(String full_name) {
        initComponents();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Main.png")));
        btnadd.requestFocus();
        lbl_user_fullname1.setText(full_name);
        btn_frm_families_members.setVisible(false);
        user_button();
        btn_frmlink_chronic_disease_emp.setVisible(false);
        clock();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tiemanddate = new javax.swing.JLabel();
        btnadd = new RSMaterialComponent.RSButtonMaterialShadow();
        btnExit = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_view_emp = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_frm_families_members = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_frmlink_chronic_disease_emp = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_view = new RSMaterialComponent.RSButtonMaterialShadow();
        jLabel3 = new javax.swing.JLabel();
        lbl_user_fullname1 = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_user_name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tiemanddate.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 25)); // NOI18N
        lbl_tiemanddate.setText("2");
        getContentPane().add(lbl_tiemanddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, 560, 50));

        btnadd.setBackground(new java.awt.Color(185, 146, 79));
        btnadd.setText("اضافة موظف");
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
        btnadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaddKeyPressed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 430, 180, 50));

        btnExit.setBackground(new java.awt.Color(185, 146, 79));
        btnExit.setText("خروج");
        btnExit.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btnExit.setEffectFocus(true);
        btnExit.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 130, 50));

        btn_view_emp.setBackground(new java.awt.Color(185, 146, 79));
        btn_view_emp.setText("عرض  جميع الموظفين");
        btn_view_emp.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_view_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_view_emp.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_view_emp.setEffectFocus(true);
        btn_view_emp.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_view_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_empActionPerformed(evt);
            }
        });
        getContentPane().add(btn_view_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 210, 50));

        btn_frm_families_members.setBackground(new java.awt.Color(185, 146, 79));
        btn_frm_families_members.setText("اضافة أفراد  الموظف");
        btn_frm_families_members.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_frm_families_members.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_frm_families_members.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_frm_families_members.setEffectFocus(true);
        btn_frm_families_members.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_frm_families_members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_frm_families_membersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_frm_families_members, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 490, 210, 50));

        btn_frmlink_chronic_disease_emp.setBackground(new java.awt.Color(185, 146, 79));
        btn_frmlink_chronic_disease_emp.setText("واجهة اضافة حالة الصحية للأفراد موظف");
        btn_frmlink_chronic_disease_emp.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_frmlink_chronic_disease_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_frmlink_chronic_disease_emp.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_frmlink_chronic_disease_emp.setEffectFocus(true);
        btn_frmlink_chronic_disease_emp.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_frmlink_chronic_disease_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_frmlink_chronic_disease_empActionPerformed(evt);
            }
        });
        getContentPane().add(btn_frmlink_chronic_disease_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 400, 50));

        btn_view.setBackground(new java.awt.Color(185, 146, 79));
        btn_view.setText("عرض الموظفين");
        btn_view.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_view.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_view.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_view.setEffectFocus(true);
        btn_view.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        getContentPane().add(btn_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 430, 180, -1));

        jLabel3.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 25)); // NOI18N
        jLabel3.setText("اسم المستخدم");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 640, 160, -1));

        lbl_user_fullname1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 25)); // NOI18N
        lbl_user_fullname1.setText("1");
        getContentPane().add(lbl_user_fullname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 450, 30));
        getContentPane().add(lbl_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 120, 30));
        getContentPane().add(lbl_user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 120, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1460, 700));
        jLabel1.getAccessibleContext().setAccessibleParent(jLabel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
View.AddEmp add_emp = null;
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

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
        if (add_emp == null) {
            add_emp = new AddEmp();
        }

        add_emp.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnaddActionPerformed
    View.view_Employees_Confirm view_emp = null;
    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed

        if (view_emp == null) {
            view_emp = new view_Employees_Confirm();
        }

        view_emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_frmlink_chronic_disease_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_frmlink_chronic_disease_empActionPerformed
        View.link_chronic_disease_emp as = new link_chronic_disease_emp(this, true);
        as.setVisible(true);
    }//GEN-LAST:event_btn_frmlink_chronic_disease_empActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

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

                        lbl_tiemanddate.setText("الوقت " + hour + ":" + minute + ":" + second +   "                              التاريخ " + year + "/" + month + "/" + day);

                        sleep(1000);
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(super_admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        clock.start();
    }
    private void btn_frm_families_membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_frm_families_membersActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(families_members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(families_members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(families_members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(families_members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        View.families_members a = new families_members(this, true);
        a.setVisible(true);
    }//GEN-LAST:event_btn_frm_families_membersActionPerformed

    private void btnaddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaddKeyPressed

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
        if (add_emp == null) {
            add_emp = new AddEmp();
        }

        add_emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnaddKeyPressed

    private void btn_view_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_empActionPerformed
  
        View.view_Employees_all View_emp = new view_Employees_all(this, true);
        View_emp.setVisible(true);
    }//GEN-LAST:event_btn_view_empActionPerformed

    /**
     * @param args the command line arguments
     */
    static main viewmain = new main();

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewmain.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialShadow btnExit;
    private RSMaterialComponent.RSButtonMaterialShadow btn_frm_families_members;
    private RSMaterialComponent.RSButtonMaterialShadow btn_frmlink_chronic_disease_emp;
    public RSMaterialComponent.RSButtonMaterialShadow btn_view;
    private RSMaterialComponent.RSButtonMaterialShadow btn_view_emp;
    private RSMaterialComponent.RSButtonMaterialShadow btnadd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_tiemanddate;
    private javax.swing.JLabel lbl_user_fullname1;
    private javax.swing.JLabel lbl_user_name;
    // End of variables declaration//GEN-END:variables
}
