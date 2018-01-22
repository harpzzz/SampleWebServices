/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_leadsCallLog")
public class LeadCallLog {
    
    @Id
    int leadCallLog_Id;
    
    int leadAssign_Id;
    
    String leadCall_Comments;
    
    
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    Date leadCall_DateTime;

    public int getLeadCallLog_Id() {
        return leadCallLog_Id;
    }

    public void setLeadCallLog_Id(int leadCallLog_Id) {
        this.leadCallLog_Id = leadCallLog_Id;
    }

    public int getLeadAssign_Id() {
        return leadAssign_Id;
    }

    public void setLeadAssign_Id(int leadAssign_Id) {
        this.leadAssign_Id = leadAssign_Id;
    }

    public String getLeadCall_Comments() {
        return leadCall_Comments;
    }

    public void setLeadCall_Comments(String leadCall_Comments) {
        this.leadCall_Comments = leadCall_Comments;
    }

 
    public Date getLeadCall_DateTime() {
        return leadCall_DateTime;
    }

    public void setLeadCall_DateTime(Date leadCall_DateTime) {
        this.leadCall_DateTime = leadCall_DateTime;
    }


    
}
