/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.dao;


import com.milagro.salesappservices.model.User;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author harpreet
 */


@Repository("IUserDao")
public class UsersDao implements IUsersDao  {

    
    @Autowired
    SessionFactory sessionFactory;
    
   
    @Override
    public User getUserbyEmail(String email, String password) {
        
        Session session = sessionFactory.openSession();
        
        if (session != null) {
            session.clear(); // internal cache clear
            }
        
        
     //   Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("FROM User u where u.user_Email = ? and  u.user_Password = ?");
        query.setParameter(0, email);
        query.setParameter(1, password);
        
        
        return (User) query.getSingleResult();
        
    }
    
}
