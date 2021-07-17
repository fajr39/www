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
public class m_work_city {

    private int id;
    private int id_governorate;
    private int id_district;
    private int id_sub_district;
    private int id_community;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_governorate() {
        return id_governorate;
    }

    public void setId_governorate(int id_governorate) {
        this.id_governorate = id_governorate;
    }

    public int getId_district() {
        return id_district;
    }

    public void setId_district(int id_district) {
        this.id_district = id_district;
    }

    public int getId_sub_district() {
        return id_sub_district;
    }

    public void setId_sub_district(int id_sub_district) {
        this.id_sub_district = id_sub_district;
    }

    public int getId_community() {
        return id_community;
    }

    public void setId_community(int id_community) {
        this.id_community = id_community;
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

}
