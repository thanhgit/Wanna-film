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
import javax.persistence.Table;
import modeltable.MenuTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name=MenuTable.TABLE_NAME)
@Table(name=MenuTable.TABLE_NAME)
public class Menu implements Serializable{
    @Id
    @Column(name=MenuTable.ID)
    private long menu_id;
    
    @Column(name=MenuTable.NAME)
    private String tag_name;
    
    @Column(name=MenuTable.ORDER)
    private int tag_order;
    
    @Column(name=MenuTable.NUM_CHILD)
    private int num_child;
    
    @Column(name=MenuTable.CHECKED)
    private int checked;
    
    @Column(name=MenuTable.URL)
    private String url;


    public Menu(){
        
    }

    public Menu(long menu_id, String tag_name, int tag_order, int num_child,String url) {
        this.menu_id = menu_id;
        this.tag_name = tag_name;
        this.tag_order = tag_order;
        this.num_child = num_child;
        this.url=url;
    }

    public Menu(String tag_name, int tag_order, int num_child,String url) {
        this.tag_name = tag_name;
        this.tag_order = tag_order;
        this.num_child = num_child;
        this.url=url;
    }

    public Menu(long menu_id, String tag_name,String url) {
        this.menu_id = menu_id;
        this.tag_name = tag_name;
        this.url=url;
    }
    
    

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    
    

    public int getTag_order() {
        return tag_order;
    }

    public void setTag_order(int tag_order) {
        this.tag_order = tag_order;
    }

    public int getNum_child() {
        return num_child;
    }

    public void setNum_child(int num_child) {
        this.num_child = num_child;
    }

   
    
    
}
