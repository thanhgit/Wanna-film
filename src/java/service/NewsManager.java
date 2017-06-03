/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Film;
import model.News;

/**
 *
 * @author THANH_UIT
 */
public interface NewsManager {
    public boolean add(News news);
    
    public boolean delete(News news);
    
    public boolean update(News news);
    
    public ArrayList<News> getAll();
    
    public ArrayList<News> getRecentNews();
    
    public ArrayList<News> getRecentNews(int length);
    
    public News getById(long id);

}
