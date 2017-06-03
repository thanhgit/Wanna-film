/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Account;

/**
 *
 * @author THANH_UIT
 */
public interface AccountDAO {
    public boolean update(Account account);

    public boolean add(Account account);
    
    public boolean delete(Account account);

    public boolean deleteAll();

    public Account getById(long id);

    public Account getByName(String name);
    
    public List<Account> getAll();
}
