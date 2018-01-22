/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harpreet
 */

@Entity
@Table(name = "tbl_Project")
public class Project {
    
    
  @Id
  Integer Project_Id;
  
  String Project_Name;
  
  String Project_Region;
  
        
@OneToMany(mappedBy="project")
private Set<Lead> lead;
  
   String City_Id;
  
   @Temporal(TemporalType.TIMESTAMP)
   Date Project_dateTime; 
  
  
  Integer Project_Status;

    public Integer getProject_Id() {
        return Project_Id;
    }

    public void setProject_Id(Integer Project_Id) {
        this.Project_Id = Project_Id;
    }

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String Project_Name) {
        this.Project_Name = Project_Name;
    }

    public String getProject_Region() {
        return Project_Region;
    }

    public void setProject_Region(String Project_Region) {
        this.Project_Region = Project_Region;
    }

    public String getCity_Id() {
        return City_Id;
    }

    public void setCity_Id(String City_Id) {
        this.City_Id = City_Id;
    }

    public Date getProject_dateTime() {
        return Project_dateTime;
    }

    public void setProject_dateTime(Date Project_dateTime) {
        this.Project_dateTime = Project_dateTime;
    }

    public Integer getProject_Status() {
        return Project_Status;
    }

    public void setProject_Status(Integer Project_Status) {
        this.Project_Status = Project_Status;
    }
    
}
