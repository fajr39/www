/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.workplace;


import Control.C_Divisions;

import Control.Lists_Meun;
import Model.M_Department;
import Model.M_Directorates;
import Model.M_Divisions;
import Model.M_Ministry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author ahmad-soft
 */
public class divisions extends javax.swing.JFrame {

    /**
     * Creates new form ministry
     */
    public divisions() {
        initComponents();
        fillCombobox();
        txt_id.setVisible(false);

    }
    Model.M_Divisions m = new M_Divisions();
    Control.C_Divisions c = new C_Divisions();

    public void fillCombobox() {
        Lists_Meun.A_Ministry = Lists_Meun.C_Ministry.getAllRows();
        cmb_Ministry.setModel(new DefaultComboBoxModel(Lists_Meun.A_Ministry.toArray()));

    }

    public void full_Direct() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        Lists_Meun.A_Direct = Lists_Meun.C_Direct.viewDirectorate(id_Ministry);
        cmb_Directorates.setModel(new DefaultComboBoxModel(Lists_Meun.A_Direct.toArray()));
    }

    public void full_Department() {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        Lists_Meun.A_Department = Lists_Meun.C_Department.viewDepartment(id_Direct, id_Ministry);
        cmb_department.setModel(new DefaultComboBoxModel(Lists_Meun.A_Department.toArray()));
    }

    public void full_table() throws SQLException {
        int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
        int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
        int id_Div = ((M_Department) cmb_department.getSelectedItem()).getId_department();

        Lists_Meun.A_Division = Lists_Meun.C_Division.viewDepartment(id_Direct, id_Ministry, id_Div);
        DefaultTableModel modle = new DefaultTableModel();
        modle.setColumnIdentifiers(new Object[]{"??????", "??????"});
        Object[] row = new Object[2];
        for (int i = 0; i < Lists_Meun.A_Division.size(); i++) {
            row[0] = Lists_Meun.A_Division.get(i).getDescription();
            row[1] = Lists_Meun.A_Division.get(i).getID();
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
        N_type_of_doc_p1 = new javax.swing.JLabel();
        lbl_divisions = new javax.swing.JLabel();
        cmb_department = new RSMaterialComponent.RSComboBoxMaterial();
        pnl2 = new javax.swing.JPanel();
        btn_previous = new RSMaterialComponent.RSButtonMaterialShadow();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDirect = new rojerusan.RSTableMetro();
        lbl_name = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new RSMaterialComponent.RSTextFieldMaterial();
        btn_add = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_update = new RSMaterialComponent.RSButtonMaterialShadow();
        btn_del = new RSMaterialComponent.RSButtonMaterialShadow();
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
        jLabel2.setText("?????????? ????????????");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(104, 104, 104))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 360, 80));

        cmb_Ministry.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Ministry.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Ministry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "?????????? ?????? ????????????????" }));
        cmb_Ministry.setSelectedIndex(-1);
        cmb_Ministry.setToolTipText("");
        cmb_Ministry.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_Ministry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_Ministry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_MinistryActionPerformed(evt);
            }
        });
        pnl1.add(cmb_Ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        N_type_of_doc_p.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        N_type_of_doc_p.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p.setText("?????????? : ???????? ???????????? ???????????????? ");
        pnl1.add(N_type_of_doc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        btn_Next.setBackground(new java.awt.Color(185, 146, 79));
        btn_Next.setText("????????????");
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
        pnl1.add(btn_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 107, 41));

        lbl_Ministry.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_Ministry.setForeground(new java.awt.Color(7, 2, 2));
        lbl_Ministry.setText("?????? ??????????????");
        pnl1.add(lbl_Ministry, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        btn_Exit1.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit1.setText("????????");
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
        pnl1.add(btn_Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 107, 41));

        N_type_of_doc_p2.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        N_type_of_doc_p2.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p2.setText("?????????? : ???????? ???????????? ?????????????? ");
        pnl1.add(N_type_of_doc_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        lbl_directorates.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_directorates.setForeground(new java.awt.Color(7, 2, 2));
        lbl_directorates.setText("?????? ????????????");
        pnl1.add(lbl_directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        cmb_Directorates.setBackground(new java.awt.Color(254, 254, 254));
        cmb_Directorates.setForeground(new java.awt.Color(1, 1, 1));
        cmb_Directorates.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "?????????? ?????? ????????????????" }));
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
        pnl1.add(cmb_Directorates, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        N_type_of_doc_p1.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        N_type_of_doc_p1.setForeground(new java.awt.Color(7, 2, 2));
        N_type_of_doc_p1.setText("?????????? : ???????? ???????????? ?????????????? ");
        pnl1.add(N_type_of_doc_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        lbl_divisions.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_divisions.setForeground(new java.awt.Color(7, 2, 2));
        lbl_divisions.setText("?????? ??????????");
        pnl1.add(lbl_divisions, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        cmb_department.setBackground(new java.awt.Color(254, 254, 254));
        cmb_department.setForeground(new java.awt.Color(1, 1, 1));
        cmb_department.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "?????????? ?????? ????????????????" }));
        cmb_department.setSelectedIndex(-1);
        cmb_department.setToolTipText("");
        cmb_department.setColorMaterial(new java.awt.Color(185, 146, 79));
        cmb_department.setEnabled(false);
        cmb_department.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmb_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departmentActionPerformed(evt);
            }
        });
        pnl1.add(cmb_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        rSPanelsSlider1.add(pnl1, "card2");

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setName("pnl2"); // NOI18N

        btn_previous.setBackground(new java.awt.Color(185, 146, 79));
        btn_previous.setText("????????");
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("?????????? ????????????");

        tableDirect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "?????????? ???????? ????????????????????", "?????????? ????????"
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

        lbl_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(7, 2, 2));
        lbl_name.setText("?????? ????????");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        txt_name.setForeground(new java.awt.Color(1, 1, 1));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setColorMaterial(new java.awt.Color(185, 146, 79));
        txt_name.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txt_name.setPlaceholder("");

        btn_add.setBackground(new java.awt.Color(185, 146, 79));
        btn_add.setText("??????????");
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

        btn_update.setBackground(new java.awt.Color(185, 146, 79));
        btn_update.setText("??????????");
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

        btn_del.setBackground(new java.awt.Color(185, 146, 79));
        btn_del.setText("??????");
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

        btn_Exit.setBackground(new java.awt.Color(185, 146, 79));
        btn_Exit.setText("????????");
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

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbl_name)
                .addGap(18, 18, 18)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                        .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_name))
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
        try {
            full_table();
        } catch (SQLException ex) {
            Logger.getLogger(divisions.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                JOptionPane.showMessageDialog(null, "???????????? ???? ?????? ???????? ????????");
             //   new rojerusan.RSNotifyAnimated("??????????????", "???????????? ???? ?????? ???????? ????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                return;
            }
            int id_Ministry = ((M_Ministry) cmb_Ministry.getSelectedItem()).getId_Ministry();
            int id_Direct = ((M_Directorates) cmb_Directorates.getSelectedItem()).getId_Directorates();
            int id_Div = ((M_Department) cmb_department.getSelectedItem()).getId_department();

            m.setId_Ministry(id_Ministry);
            m.setId_id_Directorates(id_Direct);
            m.setId_department(id_Div);
            m.setDescription(txt_name.getText());

            boolean i = c.add(m);
            if (i == true) {
                full_table();
                txt_name.requestFocus();
JOptionPane.showMessageDialog(null, "???? ?????????? ???????????? ??????????");
              //  new rojerusan.RSNotifyAnimated("??????????????", "???? ?????????? ???????????? ??????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            } else {
                txt_name.requestFocus();
                full_table();
                JOptionPane.showMessageDialog(null, "???? ?????????? ?????? ?????? ?????? ");
              //  new rojerusan.RSNotifyAnimated("??????????????", "???? ?????????? ?????? ?????? ?????? ", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);

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
                 JOptionPane.showMessageDialog(null,"???????????? ?????????? ??????????  ?????????????? ??????????");
              //  new rojerusan.RSNotifyAnimated("??????????????", "???????????? ?????????? ??????????  ?????????????? ??????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            m.setID(Integer.valueOf(txt_id.getText()));
            m.setDescription(String.valueOf(txt_name.getText()));
            c.update(m);
            full_table();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
              JOptionPane.showMessageDialog(null, "???? ?????????? ???????????? ??????????");
          //  new rojerusan.RSNotifyAnimated("??????????????", "???? ?????????? ???????????? ??????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
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
            JOptionPane.showMessageDialog(null, "???????????? ?????????? ?????????? ???????????? ?????????? ??????????");
                //new rojerusan.RSNotifyAnimated("??????????????", "???????????? ?????????? ?????????? ???????????? ?????????? ??????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return;
            }
            m.setID(Integer.valueOf(txt_id.getText()));
            c.delete(m, "work_place");
            full_table();
            btn_del.setEnabled(false);
            btn_update.setEnabled(false);
             JOptionPane.showMessageDialog(null, "???? ?????? ???????????? ??????????");
          //  new rojerusan.RSNotifyAnimated("??????????????", "???? ?????? ???????????? ??????????", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
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
        full_Department();
        cmb_department.setEnabled(true);
        btn_Next.setEnabled(true);
    }//GEN-LAST:event_cmb_DirectoratesActionPerformed

    private void cmb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departmentActionPerformed

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
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(divisions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new divisions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N_type_of_doc_p;
    private javax.swing.JLabel N_type_of_doc_p1;
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
    private RSMaterialComponent.RSComboBoxMaterial cmb_department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Ministry;
    private javax.swing.JLabel lbl_directorates;
    private javax.swing.JLabel lbl_divisions;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSTableMetro tableDirect;
    private javax.swing.JTextField txt_id;
    private RSMaterialComponent.RSTextFieldMaterial txt_name;
    // End of variables declaration//GEN-END:variables
}
