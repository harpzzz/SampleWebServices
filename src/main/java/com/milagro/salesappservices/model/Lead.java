/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_leads")
public class Lead {

    @Id
    int lead_Id;

    String lead_UName;
    
    String lead_Email;
    
    String lead_Phone;
    
    Integer lead_Country_Id;
    
    
          
    Integer lead_AssignId;
    
    @ManyToOne
    @JoinColumn(name = "lead_Project_Id")        
    Project project;
    
    
    @ManyToOne
    @JoinColumn(name = "lead_Status_Id")            
    Status status;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date lead_datetime;
    
    @Temporal(TemporalType.DATE)
    Date lead_date;

    public int getLead_Id() {
        return lead_Id;
    }

    public void setLead_Id(int lead_Id) {
        this.lead_Id = lead_Id;
    }

    public String getLead_UName() {
        return lead_UName;
    }

    public void setLead_UName(String lead_UName) {
        this.lead_UName = lead_UName;
    }

    public String getLead_Email() {
        return lead_Email;
    }

    public void setLead_Email(String lead_Email) {
        this.lead_Email = lead_Email;
    }

    public String getLead_Phone() {
        return lead_Phone;
    }

    public void setLead_Phone(String lead_Phone) {
        this.lead_Phone = lead_Phone;
    }

    public Integer getLead_Country_Id() {
        return lead_Country_Id;
    }

    public void setLead_Country_Id(Integer lead_Country_Id) {
        this.lead_Country_Id = lead_Country_Id;
    }

    public Date getLead_datetime() {
        return lead_datetime;
    }

    public void setLead_datetime(Date lead_datetime) {
        this.lead_datetime = lead_datetime;
    }

    public Date getLead_date() {
        return lead_date;
    }

    public void setLead_date(Date lead_date) {
        this.lead_date = lead_date;
    }

   
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

   
   
}

