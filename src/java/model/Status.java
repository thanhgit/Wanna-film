/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import modeltable.StatusTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name = StatusTable.TABLE_NAME)
@Table(name = StatusTable.TABLE_NAME)
public class Status {
    
    public static final String COMING_SOON="Sắp chiếu";
    public static final String SHOWING="Đang chiếu";
    public static final String SCREEN="Đã chiếu";
    
    @Id
    @Column(name = StatusTable.ID)
    private long status_id;
    
    @Column(name = StatusTable.NAME)
    private String status_name;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name=StatusTable.ID)
    List<Film> films=new ArrayList<Film>();
    
    public Status(){
        
    }

    public Status(long status_id, String status_name) {
        this.status_id = status_id;
        this.status_name = status_name;
    }

    public Status(String status_name) {
        this.status_name = status_name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
    
    

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
    
    
}
