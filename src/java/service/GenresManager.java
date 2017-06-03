/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Film;
import model.Genres;

/**
 *
 * @author THANH_UIT
 */
public interface GenresManager {
    public boolean add(Genres genres);
    
    public boolean delete(Genres genres);
    
    public boolean update(Genres genres);
    
    public ArrayList<Genres> getAll();
    
    public String getNameById(long id);
    
    public Genres getByName(String name);
    
    public List<Film> getFilmSeeMany(String name);
    
    public Genres getById(long id);
}
