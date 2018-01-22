/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.controller;

import com.milagro.salesappservices.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author harpreet
 */
@RestController
@RequestMapping("/leads")
public class LeadController {
    
    
    @Autowired
    LeadService leadService;
    
    
    @RequestMapping(value = "/counts", method = RequestMethod.POST)
    public String getcountsLeads(@RequestParam("token_id") String tokenId, @RequestParam("project_id") Integer projectId){
    
        
        return leadService.getLeadsCount(tokenId,projectId).toString();
        
    }
    
    
    
    @RequestMapping(value = "/projectlist", method = RequestMethod.POST)
    public String getProjectList(@RequestParam("token_id") String tokenId){
    
        
        
    
        return leadService.getProjectList(tokenId).toString();
    
    }
    
    
    @RequestMapping(value = "/leadslist",method = RequestMethod.POST)
    public String getLeadList(@RequestParam("token_id") String tokenId, @RequestParam("project_id") Integer projectId){
    
        return leadService.getLeadList(tokenId, projectId).toString();
        
    }
    
    
}
