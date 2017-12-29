/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.dao;

import com.milagro.salesappservices.model.User;
import java.util.List;

/**
 *
 * @author harpreet
 */
public interface IUsersDao {
    
 // public List<Employee> getEmployees();
  
  public User getUserbyEmail(String email, String password);
  
 // public Employee setEmpolyeebyId(Employee emp);
  
 // public boolean insertEmployee(Employee emp);
  
}
