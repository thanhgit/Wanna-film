/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FilmDAO;
import dao.FilmDAOImp;
import java.util.ArrayList;
import java.util.List;
import model.Film;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANH_UIT
 */

@Service(value="FilmService")
public class FilmService implements FilmManager{
    FilmDAO dao=new FilmDAOImp();
    @Override
    public boolean add(Film film) {
        long id=dao.getByName(film.getFilm_name())!=null?dao.getByName(film.getFilm_name()).getFilm_id():0;
        if(id!=0){
            return dao.add(film);
        }else{
            return false;
        }      
    }   

    @Override
    public boolean delete(Film film) {
        long id=dao.getByName(film.getFilm_name())!=null?dao.getByName(film.getFilm_name()).getFilm_id():0;
        if(id!=0){
            return dao.delete(film);
        }else{
            return false;
        }          }

    @Override
    public boolean update(Film film) {
        long id=dao.getByName(film.getFilm_name())!=null?dao.getByName(film.getFilm_name()).getFilm_id():0;
        if(id!=0){
            return dao.update(film);
        }else{
            return false;
        }          }

    @Override
    public ArrayList<Film> getAll() {
        ArrayList<Film> films=(ArrayList<Film>) dao.getAll();
        return films;
    }
    

    @Override
    public ArrayList<Film> getSeriesFilm() {
        List<Film> films=dao.getAll()!=null?dao.getAll():null;
        ArrayList<Film> result=new ArrayList<>();
        for(Film film:films){
            if(film.isSeries()){
                result.add(film);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<Film> getMovieFilm() {
        List<Film> films=dao.getAll()!=null?dao.getAll():null;
        ArrayList<Film> result=new ArrayList<>();
        for(Film film:films){
            if(!film.isSeries()){
                result.add(film);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args){
        FilmManager dao=new FilmService();
        System.out.println("size: "+dao.getAll().size());
    }

    @Override
    public List<Film> getFilmSeeMany(boolean isSeries) {
        List<Film> films=null;
        List<Film> result=new ArrayList<>();
        if(isSeries){
            films=getSeriesFilm();
        }else{
            films=getMovieFilm();
        }
        
        for(Film film:films){
            if(film.isSeries()==isSeries){
                result.add(film);
            }
        }
        
        return result;
    }

    @Override
    public List<Film> getFilmSeeMany() {
         List<Film> films=dao.getAll();
        List<Film> result=new ArrayList<>();
        
        for(Film film:films){
            if(film.isSee_many()){
                result.add(film);
            }
        }
        
        return result;
    }

    @Override
    public List<Film> getFilmFetured() {
        List<Film> films=dao.getAll();
        ArrayList<Film> result=new ArrayList<>();
        for(Film film:films){
            if(film.isFeature()){
                result.add(film);
            }
        }
        
        return result;
    }

    @Override
    public List<Film> getFilmRating() {
     List<Film> films=dao.getAll();
        ArrayList<Film> result=new ArrayList<>();
        for(Film film:films){
            if(film.isRating()){
                result.add(film);
            }
        }
        
        return result; 
    }
    
 @Override
    public List<Film> getFilmRecently() {
     List<Film> films=dao.getAll();
        ArrayList<Film> result=new ArrayList<>();
        for(Film film:films){
            if(film.isRecently()){
                result.add(film);
            }
        }
        
        return result; 
    }

    @Override
    public List<Film> getFilmByKey(String key) {
        List<Film> films=dao.getAll();
        List<Film> result=new ArrayList<>();
        key=util.Util.removeAccent(key).toLowerCase().trim();
        for(Film film:films){
            String title=util.Util.removeAccent(film.getFilm_name()).toLowerCase().trim();
            if(title.contains(key)){
                result.add(film);
            }
        }
        
        return result;
    }

    @Override
    public Film getById(long id) {
        return dao.getById(id);
    }

    @Override
    public Film getByName(String name) {
        return dao.getByName(name);
    }
    
 
        
}
