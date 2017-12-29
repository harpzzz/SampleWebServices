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
    
    
    @RequestMapping(value = "/counts", method = RequestMethod.GET)
    public Object getcountsLeads(){
    
    
        return leadService.getLeadsCount();
        
    }
    
    
}
