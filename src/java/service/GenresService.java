/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GenresDAO;
import dao.GenresDAOImp;
import java.util.ArrayList;
import java.util.List;
import model.Film;
import model.Genres;

/**
 *
 * @author THANH_UIT
 */
public class GenresService implements GenresManager{
    GenresDAO dao=new GenresDAOImp();
    @Override
    public boolean add(Genres genres) {
        long id=dao.getByName(genres.getGenres_name())!=null?dao.getByName(genres.getGenres_name()).getGenres_id():0;
        if(id!=0){
            return dao.add(genres);
        }else{
            return false;
        }          
    }

    @Override
    public boolean delete(Genres genres) {
        long id=dao.getByName(genres.getGenres_name())!=null?dao.getByName(genres.getGenres_name()).getGenres_id():0;
        if(id!=0){
            return dao.delete(genres);
        }else{
            return false;
        }    
    }

    @Override
    public boolean update(Genres genres) {
        long id=dao.getByName(genres.getGenres_name())!=null?dao.getByName(genres.getGenres_name()).getGenres_id():0;
        if(id!=0){
            return dao.update(genres);
        }else{
            return false;
        }    
    }

    @Override
    public ArrayList<Genres> getAll() {
        ArrayList<Genres> genreses=(ArrayList<Genres>) dao.getAll();
        return genreses;
    }

    @Override
    public Genres getByName(String name) {
        return dao.getByName(name)!=null?dao.getByName(name):null;
    }

    @Override
    public List<Film> getFilmSeeMany(String name) {
       List<Film> films=dao.getByName(name).getFilms()!=null?dao.getByName(name).getFilms():null;
       List<Film> result=new ArrayList<>();
       for(Film film:films){
           if(film.isSee_many()){
               result.add(film);
           }
       }
       
       return result;
    }
    
    public static void main(String[]args){
        GenresManager service=new GenresService();
        System.out.println(service.getFilmSeeMany("Phim hài hước").size());
    }

    @Override
    public String getNameById(long id) {
        return dao.getById(id).getGenres_name();
    }

    @Override
    public Genres getById(long id) {
        return dao.getById(id);
    }
    
}
