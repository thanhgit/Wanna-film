/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Film;

/**
 *
 * @author THANH_UIT
 */
public interface FilmDAO {
 public boolean update(Film film);

    public boolean add(Film film);
    
    public boolean delete(Film film);

    public boolean deleteAll();

    public Film getById(long id);

    public Film getByName(String name);
    
    public List<Film> getAll();
}
