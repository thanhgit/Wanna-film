/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CountryDAO;
import dao.CountryDAOImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Country;
import model.Film;

/**
 *
 * @author THANH_UIT
 */
public class CountryService implements CountryManager{
    CountryDAO dao=new CountryDAOImp();
    @Override
    public boolean add(Country country) {
        long id=country.getCountry_id()!=0?country.getCountry_id():dao.getByName(country.getCountry_name())!=null?dao.getByName(country.getCountry_name()).getCountry_id():0;
        if(id!=0){
            return dao.add(country);
        }else{
            return false;
        }     
    }
 
    @Override
    public boolean delete(Country country) {
        long id=country.getCountry_id()!=0?country.getCountry_id():dao.getByName(country.getCountry_name())!=null?dao.getByName(country.getCountry_name()).getCountry_id():0;
        if(id!=0){
            return dao.delete(country);
        }else{
            return false;
        }      }

    @Override
    public boolean update(Country country) {
    long id=dao.getByName(country.getCountry_name())!=null?dao.getByName(country.getCountry_name()).getCountry_id():0;
        if(id!=0){
            return dao.update(country);
        }else{
            return false;
        }      
    }

    @Override
    public ArrayList<Country> getAll() {
        ArrayList<Country> countries=(ArrayList<Country>) dao.getAll();
        return countries;
    }

    @Override
    public Country getByName(String name) {
        return dao.getByName(name)!=null?dao.getByName(name):null;
    }

    @Override
    public List<Film> getFilmSeeMany(String name) {
       List<Film> films=dao.getByName(name).getFilms()!=null?dao.getByName(name).getFilms():null;
       List<Film> result=new ArrayList<>();
       for(Film film:films){
           if(film.isSee_many()){
               result.add(film);
           }
       }
       
       return result;       
    }
    
    public static void main(String[]args){
        CountryManager service=new CountryService();
        System.out.println(service.add(new Country(new Date().getTime(), "Hà Lan")));
    }

    @Override
    public String getNameById(long id) {
        return dao.getById(id).getCountry_name();
    }

    @Override
    public Country getById(long id) {
        return dao.getById(id);
    }
}
