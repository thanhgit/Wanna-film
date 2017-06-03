/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StatusDAO;
import dao.StatusDAOImp;
import java.util.List;
import model.Film;
import model.Status;

/**
 *
 * @author THANH_UIT
 */
public class StatusService implements StatusManager{
    StatusDAO dao=new StatusDAOImp();
    @Override
    public List<Film> getFilm_Showing() {
        return dao.getByName(Status.SHOWING).getFilms();
    }

    @Override
    public List<Film> getFilm_Screened() {
        return dao.getByName(Status.SCREEN).getFilms();        
    }

    @Override
    public List<Film> getFilm_ComingSoon() {
        return dao.getByName(Status.COMING_SOON).getFilms();        
    }

    public static void main(String[]args){
        StatusManager service=new StatusService();
        
        for(Film film:service.getFilm_Showing()){
            System.out.println(film.getFilm_name());
        }
    }

    @Override
    public Status getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Status> getAll() {
        return dao.getAll();
    }
}
