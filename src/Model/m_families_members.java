/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ahmad-soft
 */
public class m_families_members {
    private Integer id_employee_p;
    private boolean is_exist_p;
    private String member_name_p;
    private boolean is_employee_p;
    private Date brith_date_p;
    private String type_relation_p;
    private boolean study_p;
    private Integer id_social_status_p;

    public Integer getId_employee_p() {
        return id_employee_p;
    }

    public void setId_employee_p(Integer id_employee_p) {
        this.id_employee_p = id_employee_p;
    }

    public boolean isIs_exist_p() {
        return is_exist_p;
    }

    public void setIs_exist_p(boolean is_exist_p) {
        this.is_exist_p = is_exist_p;
    }

    public String getMember_name_p() {
        return member_name_p;
    }

    public void setMember_name_p(String member_name_p) {
        this.member_name_p = member_name_p;
    }

    public boolean isIs_employee_p() {
        return is_employee_p;
    }

    public void setIs_employee_p(boolean is_employee_p) {
        this.is_employee_p = is_employee_p;
    }

    public Date getBrith_date_p() {
        return brith_date_p;
    }

    public void setBrith_date_p(Date brith_date_p) {
        this.brith_date_p = brith_date_p;
    }

    public String getType_relation_p() {
        return type_relation_p;
    }

    public void setType_relation_p(String type_relation_p) {
        this.type_relation_p = type_relation_p;
    }

    public boolean isStudy_p() {
        return study_p;
    }

    public void setStudy_p(boolean study_p) {
        this.study_p = study_p;
    }

    public Integer getId_social_status_p() {
        return id_social_status_p;
    }

    public void setId_social_status_p(Integer id_social_status_p) {
        this.id_social_status_p = id_social_status_p;
    }
    
    
}
