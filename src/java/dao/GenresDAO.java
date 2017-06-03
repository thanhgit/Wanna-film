/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Genres;

/**
 *
 * @author THANH_UIT
 */
public interface GenresDAO {
    public boolean update(Genres genres);

    public boolean add(Genres genres);
    
    public boolean delete(Genres genres);

    public boolean deleteAll();

    public Genres getById(long id);

    public Genres getByName(String name);
    
    public List<Genres> getAll();
}
