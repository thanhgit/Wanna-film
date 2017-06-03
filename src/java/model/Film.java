/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import modeltable.FilmTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name=FilmTable.TABLE_NAME)
@Table(name=FilmTable.TABLE_NAME)
public class Film implements Serializable{
    @Id
    @Column(name=FilmTable.ID)
    private long film_id;
    
    @Column(name=FilmTable.NAME)
    private String film_name;
    
    @Column(name=FilmTable.DESCRIPTION)
    private String film_description;
    
    @Column(name=FilmTable.IMAGE)
    private String film_image;
    
    @Column(name=FilmTable.VIDEO)
    private String film_video;
    
    @Column(name=FilmTable.YEAR)
    private String film_year;
    
    @Column(name=FilmTable.SEE_MANY)
    private boolean see_many;
    
    @Column(name=FilmTable.IS_SERIES)
    private boolean series;
    
    @Column(name=FilmTable.IS_FEATURE)
    private boolean feature;
    
    @Column(name=FilmTable.IS_RECENTLY)
    private boolean recently;
    
    @Column(name = FilmTable.IS_RATING)
    private boolean rating;
    
    @ManyToOne
    @JoinColumn(name=FilmTable.GENRES_ID)
    private Genres genres;
    
    @ManyToOne
    @JoinColumn(name=FilmTable.COUNTRY_ID)
    private Country country;
    
    @ManyToOne
    @JoinColumn(name=FilmTable.STATUS_ID)
    private Status status;
    
    public Film(){
        
    }

    public Film(long film_id, String film_name, String film_description, String film_image, String film_video, Genres genres, Country country) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.film_description = film_description;
        this.film_image = film_image;
        this.film_video = film_video;
        this.genres = genres;
        this.country = country;
    }

    public Film(String film_name, String film_description, String film_image, String film_video, Genres genres, Country country) {
        this.film_name = film_name;
        this.film_description = film_description;
        this.film_image = film_image;
        this.film_video = film_video;
        this.genres = genres;
        this.country = country;
    }

    public Film(long film_id, String film_name, String film_description, String film_image, String film_video, String film_year, boolean see_many, boolean series, boolean feature, boolean recently, boolean rating, Genres genres, Country country, Status status) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.film_description = film_description;
        this.film_image = film_image;
        this.film_video = film_video;
        this.film_year = film_year;
        this.see_many = see_many;
        this.series = series;
        this.feature = feature;
        this.recently = recently;
        this.rating = rating;
        this.genres = genres;
        this.country = country;
        this.status = status;
    }

    
    public boolean isSee_many() {
        return see_many;
    }

    public void setSee_many(boolean see_many) {
        this.see_many = see_many;
    }

    public boolean isFeature() {
        return feature;
    }

    public void setFeature(boolean feature) {
        this.feature = feature;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public boolean isRecently() {
        return recently;
    }

    public void setRecently(boolean recently) {
        this.recently = recently;
    }
    
    

    public boolean isSeries() {
        return series;
    }

    public void setSeries(boolean series) {
        this.series = series;
    }

    public long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(long film_id) {
        this.film_id = film_id;
    }

    public String getFilm_year() {
        return film_year;
    }

    public void setFilm_year(String film_year) {
        this.film_year = film_year;
    }
    
    

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_description() {
        return film_description;
    }

    public void setFilm_description(String film_description) {
        this.film_description = film_description;
    }

    public String getFilm_image() {
        return film_image;
    }

    public void setFilm_image(String film_image) {
        this.film_image = film_image;
    }

    public String getFilm_video() {
        return film_video;
    }

    public void setFilm_video(String film_video) {
        this.film_video = film_video;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    
}
