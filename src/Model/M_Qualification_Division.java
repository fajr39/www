/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ahmad-soft
 */
public class M_Qualification_Division {
    
    private int id;
    private int id_Division;
    private String description;
    
     private int id_Name;
     private int id_type;
     
    private String table_name;
    private String column_name;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Division() {
        return id_Division;
    }

    public void setId_Division(int id_Division) {
        this.id_Division = id_Division;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
  @Override
    public String toString(){
        return description;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getId_Name() {
        return id_Name;
    }

    public void setId_Name(int id_Name) {
        this.id_Name = id_Name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }
    
    
}
