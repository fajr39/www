/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Control.control_user_admin;
import Model.MessageType;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;
import Model.m_User;

/**
 *
 * @author ahmad-soft
 */
public class frm_create_Admin extends javax.swing.JFrame {
 Model.m_User model; 
    /**
     * Creates new form ministry
     */
    public frm_create_Admin() {
        initComponents();
model = new m_User();
 
      

    }




   
    Control.control_user_admin con = new control_user_admin();
public void claer_All(){
  txt_first_name.setText("");
  txt_middle_name.setText("");
  txt_last_name.setText("");
  txt_user_name.setText("");
  txt_password.setText("");

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
        materialShadowCircle1 = new efectos.MaterialShadowCircle();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_first_name = new RSMaterialComponent.RSTextFieldMaterial();
        lbl_name = new javax.swing.JLabel();
        btn_add = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_Exit = new RSMaterialComponent.RSButtonMaterialShadow();
        txt_middle_name = new RSMaterialComponent.RSTextFieldMaterial();
        lbl_name2 = new javax.swing.JLabel();
        txt_last_name = new RSMaterialComponent.RSTextFieldMaterial();
        lbl_name3 = new javax.swing.JLabel();
        lbl_name4 = new javax.swing.JLabel();
        txt_user_name = new RSMaterialComponent.RSTextFieldMaterial();
        txt_password = new RSMaterialComponent.RSPasswordMaterial();
        chk_password1 = new RSMaterialComponent.RSCheckBoxMaterial();
        lbl_name5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel1.setFont(new java.awt.Font("DIN Next LT Arabic", 1, 30)); // NOI18N
        jLabel1.setText("واجهة اضافة المدير");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        txt_first_name.setBackground(new java.awt.Color(254, 254, 254));
        txt_first_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, null, java.awt.Color.black, java.awt.Color.black));
        txt_first_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_first_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_first_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_first_name.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_first_name.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_first_name.setPlaceholder("");
        txt_first_name.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_first_name.setSelectionColor(new java.awt.Color(142, 137, 137));
        jPanel2.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 220, -1));

        lbl_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setText("اسم ");
        jPanel2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

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
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 90, 40));

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
        jPanel2.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 90, 40));

        txt_middle_name.setBackground(new java.awt.Color(254, 254, 254));
        txt_middle_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, null, java.awt.Color.black, java.awt.Color.black));
        txt_middle_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_middle_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_middle_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_middle_name.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_middle_name.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_middle_name.setPlaceholder("");
        txt_middle_name.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_middle_name.setSelectionColor(new java.awt.Color(142, 137, 137));
        jPanel2.add(txt_middle_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 220, -1));

        lbl_name2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name2.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name2.setText("اسم الاب");
        jPanel2.add(lbl_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        txt_last_name.setBackground(new java.awt.Color(254, 254, 254));
        txt_last_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, null, java.awt.Color.black, java.awt.Color.black));
        txt_last_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_last_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_last_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_last_name.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_last_name.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_last_name.setPlaceholder("");
        txt_last_name.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_last_name.setSelectionColor(new java.awt.Color(142, 137, 137));
        jPanel2.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 220, -1));

        lbl_name3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name3.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name3.setText("الكنية");
        jPanel2.add(lbl_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        lbl_name4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name4.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name4.setText("اسم مستخدم");
        jPanel2.add(lbl_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        txt_user_name.setBackground(new java.awt.Color(254, 254, 254));
        txt_user_name.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(217, 50, 50)));
        txt_user_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_user_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_user_name.setDisabledTextColor(new java.awt.Color(0, 1, 1));
        txt_user_name.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_user_name.setPlaceholder("");
        txt_user_name.setSelectedTextColor(new java.awt.Color(254, 254, 254));
        txt_user_name.setSelectionColor(new java.awt.Color(142, 137, 137));
        jPanel2.add(txt_user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, -1));

        txt_password.setBackground(new java.awt.Color(254, 254, 254));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(217, 50, 50)));
        txt_password.setForeground(new java.awt.Color(1, 1, 1));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_password.setDisabledTextColor(new java.awt.Color(254, 254, 254));
        txt_password.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_password.setPhColor(new java.awt.Color(185, 146, 79));
        txt_password.setPlaceholder("");
        txt_password.setSelectionColor(new java.awt.Color(185, 146, 79));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 40));

        chk_password1.setForeground(new java.awt.Color(11, 10, 8));
        chk_password1.setText("إظهار كلمة المرور");
        chk_password1.setColorCheck(new java.awt.Color(185, 146, 79));
        chk_password1.setColorUnCheck(new java.awt.Color(185, 146, 79));
        chk_password1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        chk_password1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chk_password1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_password1.setIsEffectRipple(false);
        chk_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_password1ActionPerformed(evt);
            }
        });
        jPanel2.add(chk_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, -1));

        lbl_name5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name5.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name5.setText("كلمة المرور");
        jPanel2.add(lbl_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 380, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        
        try {
            if (txt_first_name.getText().equals("")|| txt_middle_name.getText().equals("") || txt_last_name.getText().equals("")
                   || txt_user_name.getText().equals("") || txt_password.getText().equals("")  )  {
                
                 View.Message meg = new Message(this, true, "الرجاء عم ترك مربع فارغ", MessageType.WARNING, 25);meg.setVisible(true);
               
             
                return;
            } 
            model.setFirst_name(txt_first_name.getText());
            model.setMiddle_name(txt_middle_name.getText());
            model.setLast_name(txt_last_name.getText());
            model.setPassword(txt_password.getText());
            model.setUser_name(txt_user_name.getText());
   
            
            
            boolean i = con.add_admin(model);
            if (i == true) {
                txt_first_name.requestFocus();
                claer_All();
                  View.Message meg = new Message(this, true, "تم اضافة المدير بنجاح", MessageType.WARNING, 25);meg.setVisible(true);
                    
                
               // new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة المدير بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                

            }


        } catch (Exception ex) {
           
            JOptionPane.showMessageDialog(null, "Error in   frm_create_Admin (View) go in btnAdd" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed

        this.dispose();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void chk_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_password1ActionPerformed
        
          if(chk_password1.isSelected()){
            txt_password.setEchoChar((char)0);
            
        }else{
            txt_password.setEchoChar(('*'));
        }
    }//GEN-LAST:event_chk_password1ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_create_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_create_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit;
    private RSMaterialComponent.RSButtonMaterialShadow btn_add;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSCheckBoxMaterial chk_password1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JLabel lbl_name3;
    private javax.swing.JLabel lbl_name4;
    private javax.swing.JLabel lbl_name5;
    private efectos.MaterialShadowCircle materialShadowCircle1;
    private RSMaterialComponent.RSTextFieldMaterial txt_first_name;
    private RSMaterialComponent.RSTextFieldMaterial txt_last_name;
    private RSMaterialComponent.RSTextFieldMaterial txt_middle_name;
    private RSMaterialComponent.RSPasswordMaterial txt_password;
    private RSMaterialComponent.RSTextFieldMaterial txt_user_name;
    // End of variables declaration//GEN-END:variables

   
}