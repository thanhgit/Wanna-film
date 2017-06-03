/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import model.Account;
import model.Country;
import model.Menu;
import modeltable.AccountTable;
import modeltable.CountryTable;
import modeltable.MenuTable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

/**
 *
 * @author THANH_UIT
 */

public class MenuDAOImp implements MenuDAO{
      @Override
    public boolean update(Menu menu) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(menu);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error update of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean add(Menu menu) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(menu);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }   
        
        return true;
    }

    @Override
    public boolean delete(Menu menu) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(menu);
        transaction.commit();
        }catch(Exception ex){
           
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error delete of CountryDAOImp "+ex.fillInStackTrace().toString());
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
        Query query=session.createQuery("delete "+MenuTable.TABLE_NAME);
        query.executeUpdate();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of CountryDAOImp "+ex.fillInStackTrace().toString());
            }

            return false;
        }   
        
    
        return true;
    }

    @Override
    public Menu getById(long id) {
        List<Menu> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+MenuTable.TABLE_NAME+" where "+MenuTable.ID+" = :"+MenuTable.ID);
        query.setParameter(MenuTable.ID, id);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getById of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public Menu getByName(String name) {
    List<Menu> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+MenuTable.TABLE_NAME+" where "+MenuTable.NAME+" = :"+MenuTable.NAME);
        query.setParameter(MenuTable.NAME, name);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getByUserName of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }    
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+MenuTable.TABLE_NAME);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
      }

    public static void main(String[]args){
        MenuDAO dao=new MenuDAOImp();
        
        //add     
//        System.out.println(dao.add(new Menu(new Date().getTime(), "Top")));
        
        //update
//        long id=dao.getByName("Top")!=null?dao.getByName("Top").getMenu_id():-1;
//        System.out.println(dao.update(new Menu(id, "Best")));
        
        //getAll
//        System.out.println("size: "+dao.getAll().size());
        
        for(Menu menu:dao.getAll()){
            System.out.println(menu.getTag_name());
        }
                
        //delete
//        System.out.println(dao.delete(dao.getByName("Best")));
        
        //deleteAll
//        System.out.println(dao.deleteAll());
    }

}
