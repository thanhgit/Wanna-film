/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Country;

/**
 *
 * @author THANH_UIT
 */
public interface CountryDAO {
        public boolean update(Country country);

    public boolean add(Country country);
    
    public boolean delete(Country country);

    public boolean deleteAll();

    public Country getById(long id);

    public Country getByName(String name);
    
    public List<Country> getAll();
}
