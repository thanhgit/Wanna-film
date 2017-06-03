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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import modeltable.CountryTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name = CountryTable.TABLE_NAME)
@Table(name=CountryTable.TABLE_NAME)
public class Country implements Serializable{
    @Id
    @Column(name=CountryTable.ID,unique = true,nullable = false)
    private long country_id=0L;
    
    @Column(name=CountryTable.NAME)
    private String country_name;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name=CountryTable.ID)
    private List<Film> films=new ArrayList<>();
    
    // constructors
    public Country(){
        
    }
    
    public Country(long country_id){
        this.country_id=country_id;
    }

    public Country(long country_id, String country_name) {
        this.country_id = country_id;
        this.country_name = country_name;
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }
    
    
}
