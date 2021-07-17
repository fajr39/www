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
public class M_Directorates {

    private int ID;
    private String description;
    private int id_Directorates;
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

    public int getId_Directorates() {
        return id_Directorates;
    }

    public void setId_Directorates(int id_Directorates) {
        this.id_Directorates = id_Directorates;
    }

    public int getId_Ministry() {
        return id_Ministry;
    }

    public void setId_Ministry(int id_Ministry) {
        this.id_Ministry = id_Ministry;
    }

}
