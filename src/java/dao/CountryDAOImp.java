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
import modeltable.AccountTable;
import modeltable.CountryTable;
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

public class CountryDAOImp implements CountryDAO{

   @Override
    public boolean update(Country country) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(country);
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
    public boolean add(Country country) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(country);
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
    public boolean delete(Country country) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(country);
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
        Query query=session.createQuery("delete "+CountryTable.TABLE_NAME);
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
    public Country getById(long id) {
        List<Country> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+CountryTable.TABLE_NAME+" where "+CountryTable.ID+" = :"+CountryTable.ID);
        query.setParameter(CountryTable.ID, id);
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
    public Country getByName(String name) {
    List<Country> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+CountryTable.TABLE_NAME+" where "+CountryTable.NAME+" = :"+CountryTable.NAME);
        query.setParameter(CountryTable.NAME, name);
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
    public List<Country> getAll() {
        List<Country> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+CountryTable.TABLE_NAME);
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
        CountryDAO dao=new CountryDAOImp();
        
        //add     
        System.out.println(dao.add(new Country(new Date().getTime(), "Đức")));
        
        //update
//        long id=dao.getByUserName("Đức")!=null?dao.getByName("Đức").getCountry_id():-1;
//        System.out.println(dao.update(new Country(id, "Ý")));
        
        //getAll
//        System.out.println("size: "+dao.getAll().size());
        
        //delete
//        System.out.println(dao.delete(dao.getByName("Ý")));
        
        //deleteAll
//        System.out.println(dao.deleteAll());
    }
      
}
