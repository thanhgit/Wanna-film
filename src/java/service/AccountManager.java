/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author THANH_UIT
 */
public interface AccountManager {
    public boolean login(Account account);
    
    public boolean register(Account account);
    
    public boolean delete(Account account);
    
    public boolean update(Account account);
    
    public boolean isExist(Account account);
    
    public boolean loginAdmin(Account account);
    
    public Account getById(long id);
    
    public List<Account> getAll();
}
