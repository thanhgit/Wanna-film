/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modeltable.NewsTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name = NewsTable.TABLE_NAME)
@Table(name = NewsTable.TABLE_NAME)
public class News implements Serializable{
    @Id
    @Column(name = NewsTable.ID)
    private long news_id;
    
    @Column(name = NewsTable.TITLTE)
    private String news_title;
    
    @Column(name=NewsTable.DESCRIPTION)
    private String news_description;
    
    @Column(name = NewsTable.IMAGE)
    private String news_image;
    
    @Temporal(TemporalType.DATE)
    @Column(name=NewsTable.DATE)
    private Date news_date;
    
    @Column(name=NewsTable.VIEW)
    private int news_view;
    
    @Column(name=NewsTable.AUTHOR)
    private String news_author;

    public News(){
        
    }
    public News(long news_id, String news_title, String news_description, String news_image, Date news_date, int news_view, String news_author) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_image = news_image;
        this.news_date = news_date;
        this.news_view = news_view;
        this.news_author = news_author;
    }

    public News(String news_title, String news_description, String news_image, Date news_date, int news_view, String news_author) {
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_image = news_image;
        this.news_date = news_date;
        this.news_view = news_view;
        this.news_author = news_author;
    }

    public News(String news_title, String news_description, String news_image, Date news_date) {
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_image = news_image;
        this.news_date = news_date;
    }

    public News(long news_id, String news_title, String news_description, String news_image, Date news_date) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_image = news_image;
        this.news_date = news_date;
    }

    
    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public Date getNews_date() {
        return news_date;
    }

    public void setNews_date(Date news_date) {
        this.news_date = news_date;
    }

    public int getNews_view() {
        return news_view;
    }

    public void setNews_view(int news_view) {
        this.news_view = news_view;
    }

    public String getNews_author() {
        return news_author;
    }

    public void setNews_author(String news_author) {
        this.news_author = news_author;
    }
    
    
    
}
