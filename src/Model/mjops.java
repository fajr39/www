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
public class mjops {
    private Integer id;
    private Integer title;
    private Integer jop_description;
    private String name;


    
    @Override
    public String toString(){
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getJop_description() {
        return jop_description;
    }

    public void setJop_description(Integer jop_description) {
        this.jop_description = jop_description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
