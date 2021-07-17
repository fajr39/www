/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ahmad-soft
 */
 public class getall extends AbstractTableModel {


    
    ArrayList<Model.Model_Tables> fill;
    String[] columnNames = new String[]{"اسم", "رقم"};

    public getall(ArrayList<Model.Model_Tables> fill) {
        this.fill = fill;
    }

    @Override
    public int getRowCount() {
//        if(fill.size()==0)
//            return 0;
        return fill.size();

    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return fill.get(row).getColumn_Name();
            case 1:
                return fill.get(row).getColumn_Id();
            default:
                return "غير موجود عمود";
        }
    }
    
  

}
