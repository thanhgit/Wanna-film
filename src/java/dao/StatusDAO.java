/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Status;

/**
 *
 * @author THANH_UIT
 */
public interface StatusDAO {
    public boolean update(Status status);

    public boolean add(Status status);
    
    public boolean delete(Status status);

    public boolean deleteAll();

    public Status getById(long id);

    public Status getByName(String name);
    
    public List<Status> getAll();
}
