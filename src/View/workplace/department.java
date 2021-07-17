/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.workplace;

import Control.C_Department;
import Control.Lists_Meun;
import Model.M_Department;
import Model.M_Directorates;
import Model.M_Ministry;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author ahmad-soft
 */
public class department extends javax.swing.JFrame {

    /**
     * Creates new form ministry
     */
    public department() {
        initComponents();
        fillCombobox();
        txt_id.setVisible(false);
    }
    Model.M_Department m = new M_Department();
    Control.C_Department c = new C_Department();

    public void fillCombobox() {
        Lists_Meun.A_Ministry = Lists_Meun.C_Ministry.getAllRows();
        cmb_Ministry.setModel(new DefaultComboBoxModel(Lists_Meun.A_Ministry.toArray()));

    }

    public void full_Direct() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        Lists_Meun.A_Direct = Lists_Meun.C_Direct.viewDirectorate(id_Ministry);
        cmb_Directorates.setModel(new DefaultComboBoxModel(Lists_Meun.A_Direct.toArray()));
    }

    public void full_table() {
  
        Lists_Meun.A_Department = Lists_Meun.C_Department.viewDepartment(1, 2);
        
        DefaultTableModel modle = new DefaultTableModel();
        modle.setColumnIdentifiers(new Object[]{"اسم", "رقم"});
        Object[] row = new Object[2];
        for (int i = 0; i < Lists_Meun.A_Department.size(); i++) {
            row[0] = Lists_Meun.A_Department.get(i).getDescription();
            row[1] = Lists_Meun.A_Department.get(i).getID();
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
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnl1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmb_Ministry = new RSMaterialComponent.RSComboBoxMaterial();
        N_type_of_doc_p = new javax.swing.JLabel();
        btn_Next = new RSMaterialComponent.RSButtonMaterialShadow();
        lbl_Ministry = new javax.swing.JLabel();
        btn_Exit1 = new RSMaterialComponent.RSButtonMaterialShadow();
        N_type_of_doc_p2 = new javax.swing.JLabel();
        lbl_directorates = new javax.swing.JLabel();
        cmb_Directorates = new RSMaterialComponent.RSComboBoxMaterial();
        pnl2 = new javax.swing.JPanel();
        btn_previous = new RSMaterialComponent.RSButtonMaterialShadow();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDirect = new rojerusan.RSTableMetro();
        lbl_name = new javax.swing.JLabel();
        txt_name = new RSMaterialComponent.RSTextFieldMaterial();
        btn_add = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_update = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_del = new RSMaterialComponent.RSButtonMaterialShadow();
        txt_id = new javax.swing.JTextField();
        btn_Exit = new RSMaterialComponent.RSButtonMaterialShadow();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));

        pnl1.setBackground(new java.awt.Color(254, 254, 254));
        pnl1.setName("pnl1"); // NOI18N
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel2.setText("واجهة الدائرة");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(104, 104, 104))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 360, 80));

        cmb_Ministry.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Ministry.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Ministry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "أختار نوع المستخدم" }));
        cmb_Ministry.setSelectedIndex(-1);
        cmb_Ministry.setToolTipText("");
        cmb_Ministry.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Ministry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Ministry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_MinistryActionPerformed(evt);
            }
        });
        pnl1.add(cmb_Ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        N_type_of_doc_p.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        N_type_of_doc_p.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p.setText("ثاني : رجاء اختيار المديرية ");
        pnl1.add(N_type_of_doc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        btn_Next.setBackground(new java.awt.Color(185, 146, 79));
        btn_Next.setText("التالي");
        btn_Next.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Next.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Next.setEffectFocus(true);
        btn_Next.setEnabled(false);
        btn_Next.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NextActionPerformed(evt);
            }
        });
        pnl1.add(btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 107, 41));

        lbl_Ministry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_Ministry.setForeground(new java.awt.Color(7, 2, 2));
        lbl_Ministry.setText("اسم الوزارة");
        pnl1.add(lbl_Ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        btn_Exit1.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit1.setText("خروج");
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
        pnl1.add(btn_Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 107, 41));

        N_type_of_doc_p2.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        N_type_of_doc_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p2.setText("أولاً : رجاء اختيار الوزارة ");
        pnl1.add(N_type_of_doc_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        lbl_directorates.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_directorates.setForeground(new java.awt.Color(7, 2, 2));
        lbl_directorates.setText("اسم مديرية");
        pnl1.add(lbl_directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        cmb_Directorates.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Directorates.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Directorates.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "أختار نوع المستخدم" }));
        cmb_Directorates.setSelectedIndex(-1);
        cmb_Directorates.setToolTipText("");
        cmb_Directorates.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Directorates.setEnabled(false);
        cmb_Directorates.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Directorates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_DirectoratesActionPerformed(evt);
            }
        });
        pnl1.add(cmb_Directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        rSPanelsSlider1.add(pnl1, "card2");

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setName("pnl2"); // NOI18N
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_previous.setBackground(new java.awt.Color(185, 146, 79));
        btn_previous.setText("سابق");
        btn_previous.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_previous.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_previous.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_previous.setEffectFocus(true);
        btn_previous.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });
        pnl2.add(btn_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 357, 67, 41));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("واجهة الدائرة");
        pnl2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

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
        tableDirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDirectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDirect);

        pnl2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 60, 380, 239));

        lbl_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name.setText("اسم دائرة");
        pnl2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        txt_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txt_name.setPlaceholder("");
        pnl2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 220, -1));

        btn_add.setBackground(new java.awt.Color(185, 146, 79));
        btn_add.setText("اضافة");
        btn_add.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_add.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_add.setEffectFocus(true);
        btn_add.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pnl2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 357, 65, 41));

        btn_update.setBackground(new java.awt.Color(185, 146, 79));
        btn_update.setText("تعديل");
        btn_update.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_update.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_update.setEffectFocus(true);
        btn_update.setEnabled(false);
        btn_update.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        pnl2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 357, 67, 41));

        btn_del.setBackground(new java.awt.Color(185, 146, 79));
        btn_del.setText("حذف");
        btn_del.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_del.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_del.setEffectFocus(true);
        btn_del.setEnabled(false);
        btn_del.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        pnl2.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 357, 67, 41));

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        pnl2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 17, 2, -1));

        btn_Exit.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit.setText("خروج");
        btn_Exit.setBackgroundHover(new java.awt.Color(117, 101, 75));
        btn_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Exit.setEffectButton(RSMaterialComponent.RSButtonMaterialShadow.EFFECTBUTTON.RAISED);
        btn_Exit.setEffectFocus(true);
        btn_Exit.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        pnl2.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 357, 67, 41));

        rSPanelsSlider1.add(pnl2, "card3");

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 20, 360, 410));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 380, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_MinistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_MinistryActionPerformed
        full_Direct();
        cmb_Directorates.setEnabled(true);
    }//GEN-LAST:event_cmb_MinistryActionPerformed

    private void btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NextActionPerformed
        full_table();

        rSPanelsSlider1.slidPanel(20, pnl2, RSPanelsSlider.direct.Right);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NextActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        rSPanelsSlider1.slidPanel(20, pnl1, RSPanelsSlider.direct.Left);
    }//GEN-LAST:event_btn_previousActionPerformed

    private void tableDirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDirectMouseClicked
      int i = (int) tableDirect.getValueAt(tableDirect.getSelectedRow(), 1);
        String s = (String) tableDirect.getValueAt(tableDirect.getSelectedRow(), 0);
        txt_id.setText(String.valueOf(i));
        txt_name.setText(s);
        btn_del.setEnabled(true);
        btn_update.setEnabled(true);
    }//GEN-LAST:event_tableDirectMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
    try {
            if (txt_name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "الرجاء عم ترك مربع فارغ");
              //  new rojerusan.RSNotifyAnimated("معلومات", "الرجاء عم ترك مربع فارغ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                return;
            }
            int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
            int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
            
            m.setId_Ministry(id_Ministry);
            m.setId_id_Directorates(id_Direct);
            m.setDescription(txt_name.getText());

            boolean i = c.add(m);
            if (i == true) {
                full_table();
                txt_name.requestFocus();
  JOptionPane.showMessageDialog(null, "تم اضافة بيانات بنجاح");
            //    new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                txt_name.requestFocus();
                full_table();
                JOptionPane.showMessageDialog(null, "تم اضافة اسم قبل مرة ");
                //new rojerusan.RSNotifyAnimated("معلومات", "تم اضافة اسم قبل مرة ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);

            }
            txt_name.setText("");
            txt_name.requestFocus();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in  view_directorate (View) go in btnAdd" + ex.getMessage());
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       try {
//            if(btnUpdate.isEnabled()){
            if (txt_name.getText() != null && txt_id.getText().equals("")) {
                   JOptionPane.showMessageDialog(null, "الرجاء اختار الاسم  للتعديل عليها");
           //     new rojerusan.RSNotifyAnimated("معلومات", "الرجاء اختار الاسم  للتعديل عليها", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            m.setID(Integer.valueOf(txt_id.getText()));
            m.setDescription(String.valueOf(txt_name.getText()));
            c.update(m);
            full_table();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
              JOptionPane.showMessageDialog(null, "تم تعديل بيانات بنجاح");
        //    new rojerusan.RSNotifyAnimated("معلومات", "تم تعديل بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            txt_name.setText("");
            txt_id.setText("");

//            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error  go -> btnUpdateMouseClicked in vDirectorate" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
  try {
            // if(btnDelete.isEnabled()){
            if (txt_name.getText() != null && txt_id.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "الرجاء اختار الاسم دائرة للحذف عليها");
               // new rojerusan.RSNotifyAnimated("معلومات", "الرجاء اختار الاسم دائرة للحذف عليها", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            m.setID(Integer.valueOf(txt_id.getText()));
            c.delete(m, "work_place");
            full_table();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
            JOptionPane.showMessageDialog(null, "تم حذف بيانات بنجاح");
        //    new rojerusan.RSNotifyAnimated("معلومات", "تم حذف بيانات بنجاح", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            txt_name.setText("");
            txt_id.setText("");
        } //   }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error  go -> btnDeleteMouseClicked in M_Ministry" + ex.getMessage());
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed

        this.dispose();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Exit1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_Exit1ActionPerformed

    private void cmb_DirectoratesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DirectoratesActionPerformed
       btn_Next.setEnabled(true);
    }//GEN-LAST:event_cmb_DirectoratesActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

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
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new department().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N_type_of_doc_p;
    private javax.swing.JLabel N_type_of_doc_p2;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Exit1;
    private RSMaterialComponent.RSButtonMaterialShadow btn_Next;
    private RSMaterialComponent.RSButtonMaterialShadow btn_add;
    private RSMaterialComponent.RSButtonMaterialShadow btn_del;
    private RSMaterialComponent.RSButtonMaterialShadow btn_previous;
    private RSMaterialComponent.RSButtonMaterialShadow btn_update;
    private RSMaterialComponent.RSComboBoxMaterial cmb_Directorates;
    private RSMaterialComponent.RSComboBoxMaterial cmb_Ministry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Ministry;
    private javax.swing.JLabel lbl_directorates;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSTableMetro tableDirect;
    private javax.swing.JTextField txt_id;
    private RSMaterialComponent.RSTextFieldMaterial txt_name;
    // End of variables declaration//GEN-END:variables
}
