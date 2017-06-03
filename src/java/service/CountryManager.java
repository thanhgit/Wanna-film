/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Country;
import model.Film;

/**
 *
 * @author THANH_UIT
 */
public interface CountryManager {
    public boolean add(Country country);
    
    public boolean delete(Country country);
    
    public boolean update(Country country);
    
    public ArrayList<Country> getAll();
    
    public Country getByName(String name);
    
    public String getNameById(long id);
    
    public List<Film> getFilmSeeMany(String name);
    
    public Country getById(long id);
}
