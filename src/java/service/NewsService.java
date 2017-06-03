/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NewsDAO;
import dao.NewsDAOImp;
import java.util.ArrayList;
import model.News;

/**
 *
 * @author THANH_UIT
 */
public class NewsService implements NewsManager{
     NewsDAO dao=new NewsDAOImp();
    @Override
    public boolean add(News news) {
        long id=dao.getByName(news.getNews_title())!=null?dao.getByName(news.getNews_title()).getNews_id():0;
        if(id!=0){
            return dao.add(news);
        }else{
            return false;
        }      
    }   

    @Override
    public boolean delete(News news) {
       long id=dao.getByName(news.getNews_title())!=null?dao.getByName(news.getNews_title()).getNews_id():0;
        if(id!=0){
            return dao.delete(news);
        }else{
            return false;
        }          }

    @Override
    public boolean update(News news) {
      long id=dao.getByName(news.getNews_title())!=null?dao.getByName(news.getNews_title()).getNews_id():0;
        if(id!=0){
            return dao.update(news);
        }else{
            return false;
        }          }

    @Override
    public ArrayList<News> getAll() {
        ArrayList<News> news=(ArrayList<News>) dao.getAll();
        return news;
    }

    @Override
    public ArrayList<News> getRecentNews() {
        ArrayList<News> result=(ArrayList<News>) util.Util.reverse(dao.getAll());
        return result;
    }

    @Override
    public ArrayList<News> getRecentNews(int length) {
        ArrayList<News> result=getRecentNews();
        return (ArrayList<News>) util.Util.getNewsAsArrayByLength(result, 0, length);
    }

    @Override
    public News getById(long id) {
        return dao.getById(id);
    }
}
