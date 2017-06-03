/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MenuDAO;
import dao.MenuDAOImp;
import java.util.ArrayList;
import model.Menu;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANH_UIT
 */

@Service(value = "MenuService")
public class MenuService implements MenuManager{
    MenuDAO dao=new MenuDAOImp();
    @Override
    public boolean add(Menu menu) {
        long id=dao.getByName(menu.getTag_name())!=null?dao.getByName(menu.getTag_name()).getMenu_id():0;
        if(id!=0){
            return dao.add(menu);
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Menu menu) {
long id=dao.getByName(menu.getTag_name())!=null?dao.getByName(menu.getTag_name()).getMenu_id():0;
        if(id!=0){
            return dao.delete(menu);
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Menu menu) {
long id=dao.getByName(menu.getTag_name())!=null?dao.getByName(menu.getTag_name()).getMenu_id():0;
        if(id!=0){
            return dao.update(menu);
        }else{
            return false;
        }    }

    @Override
    public ArrayList<Menu> getAll() {
        ArrayList<Menu> menus=(ArrayList<Menu>) dao.getAll();
        return menus;
    }

    @Override
    public Menu getById(long id) {
        return dao.getById(id);
    }
    
}
