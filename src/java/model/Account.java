/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import modeltable.AccountTable;

/**
 *
 * @author THANH_UIT
 */
@Entity(name = AccountTable.TABLE_NAME)
@Table(name=AccountTable.TABLE_NAME)
public class Account implements Serializable{
    public static final String AUTHORITY_USER="user";
    @Id
    @Column(name=AccountTable.ID,unique = true,nullable = false)
    private long account_id=0L;
    
    @Column(name=AccountTable.USER_NAME)
    private String user_name;
    
    @Column(name=AccountTable.PASSWORD)
    private String password;
    
    @Column(name=AccountTable.EMAIL)
    private String email;
    
    @Column(name=AccountTable.PHONE)
    private String phone;
    
    @Column(name=AccountTable.AUTHORITY)
    private String authority;
    
    // constructor
    public Account(){
        
    }

    public Account(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
    
    
    public Account(long account_id){
        this.account_id=account_id;
    }

    public Account(long account_id, String user_name, String password, String email, String phone) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.authority=AUTHORITY_USER;
    }

    public Account(String user_name, String password, String email, String phone) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.authority=AUTHORITY_USER;
    }

    // accessors
    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        if(!this.authority.equals("root")){
          this.authority = authority;
        }
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
