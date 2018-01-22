/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_leadAssign")
public class LeadAssign {
    
    
    @Id
    int leadAssign_Id;
    
    
    @NotNull
    int user_Id;
    
    @NotNull
    int leadAssign_Active;

    public int getLeadAssign_Id() {
        return leadAssign_Id;
    }

    public void setLeadAssign_Id(int leadAssign_Id) {
        this.leadAssign_Id = leadAssign_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public int getLeadAssign_Active() {
        return leadAssign_Active;
    }

    public void setLeadAssign_Active(int leadAssign_Active) {
        this.leadAssign_Active = leadAssign_Active;
    }

 
    
    
    
    
    
}
