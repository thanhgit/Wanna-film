/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import dao.AccountDAOImp;
import java.util.Date;
import java.util.List;
import model.Account;
import org.springframework.stereotype.Service;;

/**
 *
 * @author THANH_UIT
 */
@Service(value="accountManager")
public class AccountService implements AccountManager{
    AccountDAO dao=new AccountDAOImp();
    
  @Override
    public boolean login(Account account) {
        if(account==null){
            return false;
        }
        
        try{
            if(account.getUser_name().trim().equals("") || account.getPassword().trim().equals("")){
                return false;
            }else{
                Account acc=dao.getByName(account.getUser_name())!=null?dao.getByName(account.getUser_name()):null;
                if(acc==null)
                    return false;
                
                if(acc != null && acc.getUser_name().equals(account.getUser_name()) && acc.getPassword().equals(account.getPassword())){
                    return true;
                }
            }
        }catch(Exception ex){
             if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
             
             return false;
        }
        
        return false;
    }

    @Override
    public boolean register(Account account) {
        try{
            if(account.getUser_name().trim().equals("") || account.getPassword().trim().equals("")){
                return false;
            }else{
                Account acc=dao.getByName(account.getUser_name())!=null?dao.getByName(account.getUser_name()):null;
                
                if(acc!=null){
                    return false;
                }else{
                    return dao.add(account);
                }
            }
        }catch(Exception ex){
             if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
             
             return false;
        }
    }
       @Override
    public boolean delete(Account account) {
        long id=account.getAccount_id()!=0?account.getAccount_id():dao.getByName(account.getUser_name())!=null?dao.getByName(account.getUser_name()).getAccount_id():0;
        if(id!=0){
            return dao.delete(account);
        }else{
            return false;
        }
    }
    
//    public static void main(String[] args){
//        AccountManager acc=new AccountService();
//        //register
////        System.out.println(acc.register(new Account(new Date().getTime(),"phucthanh", "123", "thanh@gmail.com", "134")));
//
//        //login
////        System.out.println(acc.login(new Account(new Date().getTime(),"hoang hao", "123", "thanh@gmail.com", "134")));
//    }

    @Override
    public boolean update(Account account) {
        long id=dao.getByName(account.getUser_name())!=null?dao.getByName(account.getUser_name()).getAccount_id():0;
        if(id!=0){
            return dao.update(account);
        }else{
            return false;
        }   
    }

    @Override
    public boolean isExist(Account account) {
        return dao.getByName(account.getUser_name())!=null?true:false;
    }

    @Override
    public boolean loginAdmin(Account account) {
        try{
            if(login(account)){
                if(!dao.getByName(account.getUser_name()).getAuthority().equals(Account.AUTHORITY_USER)){
                    return true;
                }
            }
        }catch(Exception ex){
             if( java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0){
            System.out.println("Error getAll of CountryDAOImp "+ex.fillInStackTrace().toString());
            }
             
             return false;
        }
        
        return false;
    }

    @Override
    public List<Account> getAll() {
        return dao.getAll();
    }

    @Override
    public Account getById(long id) {
        return dao.getById(id);
    }

}
