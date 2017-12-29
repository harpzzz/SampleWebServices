/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.service;

import com.milagro.salesappservices.dao.LeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harpreet
 */
@Service("LeadDao")
public class LeadService implements ILeads {

    
    @Autowired 
    LeadDao leadDao;
    
    
    @Override
    public Object getLeadsCount() {
        
        
        return leadDao.leadstatus();
    }

    
}
