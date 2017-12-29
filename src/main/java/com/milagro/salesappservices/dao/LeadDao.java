/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author harpreet
 */
@Repository("ILeadDao")
public class LeadDao implements ILeadDao {

    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Object leadstatus() {
        
        Session session = sessionFactory.openSession();
        
        
        session.clear();
        
        Query query  = session.createQuery("Select s.LeadStatus_Type,count(l.status) FROM Status s "
                + "                         LEFT JOIN Lead l ON l.status = s.LeadStatus_id "
                + "                         GROUP BY s.LeadStatus_Type");
        

        
        List ls = query.getResultList();
        
       return ls;
    }
    
}
