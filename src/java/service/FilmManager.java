/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Film;

/**
 *
 * @author THANH_UIT
 */
public interface FilmManager {
    public boolean add(Film film);
    
    public boolean delete(Film film);
    
    public boolean update(Film film);
    
    public ArrayList<Film> getAll();
    
    public ArrayList<Film> getSeriesFilm();
    
    public ArrayList<Film> getMovieFilm();
    
    
    public List<Film> getFilmSeeMany(boolean isSeries);
    
    public List<Film> getFilmSeeMany();
    
    public List<Film> getFilmFetured();
    
    public List<Film> getFilmRating();
    
    public List<Film> getFilmRecently();
    
    public List<Film> getFilmByKey(String key);
    
    public Film getById(long id);
    
    public Film getByName(String name);
}
