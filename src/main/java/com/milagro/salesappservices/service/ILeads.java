/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.service;

import com.milagro.salesappservices.model.Project;
import java.util.List;

/**
 *
 * @author harpreet
 */
public interface ILeads {
    
    public Object getLeadsCount(String tokenId, Integer projectId);
    
    
    public Object getProjectList(String tokenId);
    
    
    public Object getLeadList(String tokenId, Integer projectId);
    
}
