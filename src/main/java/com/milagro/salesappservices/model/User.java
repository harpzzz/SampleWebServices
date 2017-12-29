/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_Id;
    
    
    String user_Name;
    
    String user_Phone;
    
    String user_Email;
    
    String user_Password;
    
    String user_Designation;
    
    String user_ProfileImage;
    
    String user_Type;
    
    Integer user_roleId;

   

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_Designation() {
        return user_Designation;
    }

    public void setUser_Designation(String user_Designation) {
        this.user_Designation = user_Designation;
    }

    public String getUser_ProfileImage() {
        return user_ProfileImage;
    }

    public void setUser_ProfileImage(String user_ProfileImage) {
        this.user_ProfileImage = user_ProfileImage;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type = user_Type;
    }

     public Integer getUser_roleId() {
        return user_roleId;
    }

    public void setUser_roleId(Integer user_roleId) {
        this.user_roleId = user_roleId;
    }
    
}
