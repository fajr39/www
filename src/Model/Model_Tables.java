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
public class Model_Tables {

    private Integer Column_Id;
    private String Column_Name;
    private String Tables_Name;

    public Model_Tables(String Column_Name, String Tables_Name) {
        this.Column_Name = Column_Name;
        this.Tables_Name = Tables_Name;
    }

    public Model_Tables(Integer Column_Id, String Column_Name, String Tables_Name) {
        this.Column_Name = Column_Name;
        this.Tables_Name = Tables_Name;
        this.Column_Id = Column_Id;
    }

    public Model_Tables(Integer Column_Id, String Tables_Name) {
        this.Column_Id = Column_Id;
        this.Tables_Name = Tables_Name;

    }

    public Model_Tables(String Tables_Name) {

        this.Tables_Name = Tables_Name;

    }

    public Model_Tables() {
      
    }


    public String getTables_Name() {
        return Tables_Name;
    }

    public void setTables_Name(String Tables_Name) {
        this.Tables_Name = Tables_Name;
    }

    public Integer getColumn_Id() {
        return Column_Id;
    }

    public void setColumn_Id(Integer Column_Id) {
        this.Column_Id = Column_Id;
    }

    public String getColumn_Name() {
        return Column_Name;
    }

    public void setColumn_Name(String Column_Name) {
        this.Column_Name = Column_Name;
    }
    @Override
    public String toString() {
        return Column_Name;
    }

}
