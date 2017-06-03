/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Film;
import model.Status;

/**
 *
 * @author THANH_UIT
 */
public interface StatusManager {
    public List<Film> getFilm_Showing();
    
    public List<Film> getFilm_Screened();
    
    public List<Film> getFilm_ComingSoon();
    
    public Status getById(long id);
    
    public List<Status> getAll();
    
}
