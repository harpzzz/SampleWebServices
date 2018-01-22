/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.dao;

import com.milagro.salesappservices.model.Project;
import java.util.List;

/**
 *
 * @author harpreet
 */
public interface ILeadDao {
    
    public Object leadstatus(Integer projectId);
    
    public List<Project> getProjectList();
    
    public Object getLeadsList(String tokenId, Integer projectId);
    
}
