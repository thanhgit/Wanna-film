/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Menu;

/**
 *
 * @author THANH_UIT
 */
public interface MenuDAO {
        public boolean update(Menu menu);

    public boolean add(Menu menu);
    
    public boolean delete(Menu menu);

    public boolean deleteAll();

    public Menu getById(long id);

    public Menu getByName(String name);
    
    public List<Menu> getAll();
}
