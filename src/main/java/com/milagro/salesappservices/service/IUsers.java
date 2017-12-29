/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.service;


import com.milagro.salesappservices.model.User;
import java.util.List;
import javax.json.JsonObject;

/**
 *
 * @author harpreet
 */
public interface IUsers {
    
    
   // public List<Employee> getEmployees();
    
    
    public JsonObject getEmployeeByEmail(String email, String Password);
    
   // public Employee setEmployeeById(Employee emp);
    
    
  //  public JsonObject insertEmployee(Employee emp);
}
