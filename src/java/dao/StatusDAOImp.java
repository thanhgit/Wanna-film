/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import model.News;
import model.Status;
import modeltable.NewsTable;
import modeltable.StatusTable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author THANH_UIT
 */
public class StatusDAOImp implements StatusDAO{
      @Override
    public boolean update(Status status) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(status);
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
    public boolean add(Status status) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(status);
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
    public boolean delete(Status status) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(status);
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
        Query query=session.createQuery("delete "+StatusTable.TABLE_NAME);
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
    public Status getById(long id) {
        List<Status> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+StatusTable.TABLE_NAME+" where "+StatusTable.ID+" = :"+StatusTable.ID);
        query.setParameter(StatusTable.ID, id);
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
    public Status getByName(String name) {
    List<Status> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+StatusTable.TABLE_NAME+" where "+StatusTable.NAME+" = :"+StatusTable.NAME);
        query.setParameter(StatusTable.NAME, name);
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
    public List<Status> getAll() {
        List<Status> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+StatusTable.TABLE_NAME);
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
        StatusDAO dao=new StatusDAOImp();
        
        //add     
//        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");
        System.out.println(dao.add(new Status(new Date().getTime(),"Đã chiếu")));
        
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
    
