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
public class M_Department {

    private int ID;
    private String description;
    private int id_department;
    private int id_id_Directorates;
    private int id_Ministry;
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    @Override
    public String toString() {
        return description;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public int getId_id_Directorates() {
        return id_id_Directorates;
    }

    public void setId_id_Directorates(int id_id_Directorates) {
        this.id_id_Directorates = id_id_Directorates;
    }

    public int getId_Ministry() {
        return id_Ministry;
    }

    public void setId_Ministry(int id_Ministry) {
        this.id_Ministry = id_Ministry;
    }
    
    }
