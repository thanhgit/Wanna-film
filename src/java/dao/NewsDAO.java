/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.News;

/**
 *
 * @author THANH_UIT
 */
public interface NewsDAO {
     public boolean update(News news);

    public boolean add(News nnews);
    
    public boolean delete(News news);

    public boolean deleteAll();

    public News getById(long id);

    public News getByName(String name);
    
    public List<News> getAll();
}
