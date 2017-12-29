/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.service;


import com.milagro.salesappservices.dao.UsersDao;
import com.milagro.salesappservices.model.User;
import java.math.BigDecimal;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harpreet
 */
@Service("UserDao")
public class UserService implements IUsers {

    
    @Autowired 
    UsersDao userDao;

    

    public JsonObject getEmployeeByEmail(String userEmail, String userPassword) {
       
        User user = userDao.getUserbyEmail(userEmail, userPassword);
      
       
  
        
              JsonObjectBuilder json = Json.createObjectBuilder();
        
          if(user != null){
              
              json.add("status", "true");
              json.add("message", "User founded.");
              
              JsonObject jsonObject = Json.createObjectBuilder()
                      
                      .add("userEmail", user.getUser_Email())
                      .add("userName",user.getUser_Name())
                      .add("userId",user.getUser_Id())
                      .add("userDesignation",user.getUser_Designation())
                      .add("userProfile",user.getUser_ProfileImage())
                      .add("userPhone",user.getUser_ProfileImage())
                      .add("userType",user.getUser_Type()).build();
        
            json.add("data",jsonObject);
         }else {
          
              json.add("status", "false");
              json.add("message", "Email and password wrong!");
              
             
          
          }
          
                  
          return json.build();
        
    }
    
   

  

    
}
