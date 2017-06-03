/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.Menu;

/**
 *
 * @author THANH_UIT
 */
public interface MenuManager {
    public boolean add(Menu menu);
    
    public boolean delete(Menu menu);
    
    public boolean update(Menu menu);
    
    public ArrayList<Menu> getAll();
    
    public Menu getById(long id);
}
