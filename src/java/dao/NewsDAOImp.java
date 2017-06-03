/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Film;
import model.News;
import modeltable.FilmTable;
import modeltable.NewsTable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author THANH_UIT
 */
public class NewsDAOImp implements NewsDAO{

     @Override
    public boolean update(News news) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(news);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error update of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean add(News news) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(news);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }   
        
        return true;
    }

    @Override
    public boolean delete(News news) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(news);
        transaction.commit();
        }catch(Exception ex){
           
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error delete of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }   
   
        return true;
    }

    @Override
    public boolean deleteAll() {
    try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("delete "+NewsTable.TABLE_NAME);
        query.executeUpdate();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of FilmDAOImp "+ex.fillInStackTrace().toString());
            }

            return false;
        }   
        
    
        return true;
    }

    @Override
    public News getById(long id) {
        List<News> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+NewsTable.TABLE_NAME+" where "+NewsTable.ID+" = :"+NewsTable.ID);
        query.setParameter(NewsTable.ID, id);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getById of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public News getByName(String name) {
    List<News> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+NewsTable.TABLE_NAME+" where "+NewsTable.TITLTE+" = :"+NewsTable.TITLTE);
        query.setParameter(NewsTable.TITLTE, name);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getByUserName of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }    
    }

    @Override
    public List<News> getAll() {
        List<News> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+NewsTable.TABLE_NAME);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of FilmDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        
        return list;
      }

    public static void main(String[]args) throws ParseException{
        NewsDAO dao=new NewsDAOImp();
        
        //add     
//        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");
        System.out.println(dao.add(new News(new Date().getTime(),"Sau tất cả", "phim ca nhạc","1.jpg",new Date())));
        
        //update
//        long id=dao.getByUserName("hoa ha")!=null?dao.getByName("hoa ha").getFilm_id():-1;
//        System.out.println(dao.update(new Film(id,"hoa da", "phim hay", "null", "null", new Genres(1, "Phim hài hước"), new Country(1, "Nhật Bản"))));
        
        //getAll
//        System.out.println("size: "+(dao.getAll()!=null?dao.getAll().size():0));
        
        //delete
//        System.out.println(dao.delete(dao.getByName("hoa da")));
        
        //deleteAll
//        System.out.println(dao.deleteAll());
    }
}
    