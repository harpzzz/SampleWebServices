/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_LeadStatus")
public class Status {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int LeadStatus_id;
    
    String LeadStatus_Type;
    
    String LeadStatus_Color;
    
        @OneToMany(mappedBy="status")
	private Set<Lead> lead;

    public int getLeadStatus_id() {
        return LeadStatus_id    ;
    }

    public void setLeadStatus_id(int LeadStatus_id) {
        this.LeadStatus_id = LeadStatus_id;
    }

    public String getLeadStatus_Type() {
        return LeadStatus_Type;
    }

    public void setLeadStatus_Type(String LeadStatus_Type) {
        this.LeadStatus_Type = LeadStatus_Type;
    }

    public String getLeadStatus_Color() {
        return LeadStatus_Color;
    }

    public void setLeadStatus_Color(String LeadStatus_Color) {
        this.LeadStatus_Color = LeadStatus_Color;
    }
    
    
    
    
    
}
