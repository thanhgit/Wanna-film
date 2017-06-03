/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import modeltable.GenresTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name=GenresTable.TABLE_NAME)
@Table(name=GenresTable.TABLE_NAME)
public class Genres implements Serializable{
    @Id
    @Column(name=GenresTable.ID)
    private long genres_id;
    
    @Column(name=GenresTable.NAME)
    private String genres_name;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name=GenresTable.ID)
    List<Film> films=new ArrayList<Film>();
    
    public Genres(){
        
    }

    public Genres(long genres_id){
        this.genres_id=genres_id;
    }
    public Genres(long genres_id, String genres_name) {
        this.genres_id = genres_id;
        this.genres_name = genres_name;
    }



    public long getGenres_id() {
        return genres_id;
    }

    public void setGenres_id(long genres_id) {
        this.genres_id = genres_id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public String getGenres_name() {
        return genres_name;
    }

    public void setGenres_name(String genres_name) {
        this.genres_name = genres_name;
    }
    
    
    
    
}
