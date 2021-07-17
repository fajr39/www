/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import sun.jvm.hotspot.utilities.IntArray;

/**
 *
 * @author ahmad-soft
 */
public class M_Add_employee {
      private Integer id_emp;
    private String fname;
    private String mname;
    private String lname;
    private boolean nature;
    private String fictitiousnamep;
    private String mother_name;
    private Date brith_date;
    private boolean sex;
    private Integer socil_status_p;
    private Integer idnumberp;
    private Integer id_registernop;
    private String phonenumberp;
    private Integer id_bloodp;
    private boolean rhp;
    private Integer qualification_p;
    private Integer id_jopsp;
    private Integer job_change_p;
    private Integer work_place_p;
    private Integer currenctplaceofresidencep;
    private Integer type_of_doc_p;
    private Integer id_work_city_p;
    private Date starting_date;
    
    
  @Override
   public String toString() {
      if(fname==null || mname==null|| lname==null){
          return  ""+id_emp;
      }else{
           return " "+fname+" "+ mname +" "+ lname;
      }
         
      
    }
    
  
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public Date getBrith_date() {

        return brith_date;
    }

    public void setBrith_date(Date brith_date) {
        this.brith_date = brith_date;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public Integer getWork_place_p() {
        return work_place_p;
    }

    public void setWork_place_p(Integer work_place_p) {
        this.work_place_p = work_place_p;
    }

    public Integer getQualification_p() {
        return qualification_p;
    }

    public void setQualification_p(Integer qualification_p) {
        this.qualification_p = qualification_p;
    }

    public Integer getSocil_status_p() {
        return socil_status_p;
    }

    public void setSocil_status_p(Integer socil_status_p) {
        this.socil_status_p = socil_status_p;
    }

    public Integer getJob_change_p() {
        return job_change_p;
    }

    public void setJob_change_p(Integer job_change_p) {
        this.job_change_p = job_change_p;
    }

    public Integer getType_of_doc_p() {
        return type_of_doc_p;
    }

    public void setType_of_doc_p(Integer type_of_doc_p) {
        this.type_of_doc_p = type_of_doc_p;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getFictitiousnamep() {
        return fictitiousnamep;
    }

    public void setFictitiousnamep(String fictitiousnamep) {
        this.fictitiousnamep = fictitiousnamep;
    }

    public Integer getIdnumberp() {
        return idnumberp;
    }

    public void setIdnumberp(Integer idnumberp) {
        this.idnumberp = idnumberp;
    }

    public Integer getId_registernop() {
        return id_registernop;
    }

    public void setId_registernop(Integer id_registernop) {
        this.id_registernop = id_registernop;
    }

    public String getPhonenumberp() {
        return phonenumberp;
    }

    public void setPhonenumberp(String phonenumberp) {
        this.phonenumberp = phonenumberp;
    }

    public Integer getId_bloodp() {
        return id_bloodp;
    }

    public void setId_bloodp(Integer id_bloodp) {
        this.id_bloodp = id_bloodp;
    }

    public Integer getId_jopsp() {
        return id_jopsp;
    }

    public void setId_jopsp(Integer id_jopsp) {
        this.id_jopsp = id_jopsp;
    }

    public Integer getCurrenctplaceofresidencep() {
        return currenctplaceofresidencep;
    }

    public void setCurrenctplaceofresidencep(Integer currenctplaceofresidencep) {
        this.currenctplaceofresidencep = currenctplaceofresidencep;
    }

    public boolean isRhp() {
        return rhp;
    }

    public void setRhp(boolean rhp) {
        this.rhp = rhp;
    }

    public Integer getId_work_city_p() {
        return id_work_city_p;
    }

    public void setId_work_city_p(Integer id_work_city_p) {
        this.id_work_city_p = id_work_city_p;
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

}
