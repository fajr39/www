/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author ahmad-soft
 */
public interface MainData<T> {
    public boolean add(T item);

    public boolean update(T item);
    
    public boolean delete(Long id) ;
       
    public Object getRow(Long id);
    
    
    public ArrayList<T> getAllRows();
    
    
    
    public void getOneRow(JTable table);
   
    
    
    
    
}
