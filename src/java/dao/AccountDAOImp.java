/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import model.Account;
import modeltable.AccountTable;
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


public class AccountDAOImp implements AccountDAO{

    @Override
    public boolean update(Account account) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(account);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error update of AccountDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean add(Account account) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(account);
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of AccountDAOImp "+ex.fillInStackTrace().toString());
            }
            
            return false;
        }   
        
        return true;
    }

    @Override
    public boolean delete(Account account) {
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(account);
        transaction.commit();
        }catch(Exception ex){
           
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error delete of AccountDAOImp "+ex.fillInStackTrace().toString());
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
        Query query=session.createQuery("delete "+AccountTable.TABLE_NAME);
        query.executeUpdate();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error add of AccountDAOImp "+ex.fillInStackTrace().toString());
            }

            return false;
        }   
        
    
        return true;
    }

    @Override
    public Account getById(long id) {
        List<Account> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+AccountTable.TABLE_NAME+" where "+AccountTable.ID+" = :"+AccountTable.ID);
        query.setParameter(AccountTable.ID, id);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getById of AccountDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public Account getByName(String username) {
    List<Account> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+AccountTable.TABLE_NAME+" where "+AccountTable.USER_NAME+" = :"+AccountTable.USER_NAME);
        query.setParameter(AccountTable.USER_NAME, username);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getByUserName of AccountDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }    
    }

    @Override
    public List<Account> getAll() {
        List<Account> list=null;
        try{
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from "+AccountTable.TABLE_NAME);
        list=query.list();
        transaction.commit();
        }catch(Exception ex){
            if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of AccountDAOImp "+ex.fillInStackTrace().toString());
            }
        } 
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
      }

    public static void main(String[]args){
        AccountDAO dao=new AccountDAOImp();
        
        //add     
        System.out.println(dao.add(new Account(new Date().getTime(), "thanhuit", "123", "13520796@gm.uit.edu.vn", "0985375546")));
        
        //update
//        long id=dao.getByUserName("thanh")!=null?dao.getByName("thanh").getAccount_id():-1;
//        System.out.println(dao.update(new Account(id, "van hao", "123", "13520796@gm.uit.edu.vn", "0985375546")));
        
        //getAll
//        System.out.println("size: "+dao.getAll().size());
        
        //delete
//        System.out.println(dao.delete(dao.getByName("van hao")));
        
        //deleteAll
//        System.out.println(dao.deleteAll());
    }
}
