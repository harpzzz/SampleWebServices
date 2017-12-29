/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.controller;


import com.milagro.salesappservices.service.UserService;
import java.util.List;
import javax.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author harpreet
 */
@RestController
public class WebController {
    
    
    @Autowired
    UserService userService;
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String logincheck(@RequestParam("userEmail") String userEmail, 
                                               @RequestParam("userPassword") String userPassword){
    
    
        
        JsonObject abc = userService.getEmployeeByEmail(userEmail,userPassword);
        
        System.out.println(abc.toString());
        
        return userService.getEmployeeByEmail(userEmail,userPassword).toString();
        
    }
    
    
    
    
  /*  @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public @ResponseBody List<Employee> getEmployees(){
    
        return employeeService.getEmployees();
    }
    
    
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Employee getByEmployeeId(@PathVariable int id){
    
    
        return employeeService.getEmployeeById(id);
    } 
    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Employee setByEmployeeId(@RequestParam("eName") String eName, @RequestParam("eMobile") String eMobile){
    
        return null;
    }
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody Object insertEmployee(@RequestParam("eName") String eName, 
                                               @RequestParam("eMobile") String eMobile,
                                               @RequestParam("eAddress") String eAddress){
    
        
        Employee emp = new Employee();
        
        emp.seteName(eName);
        emp.seteMobile(eMobile);
        emp.seteAddress(eAddress);
        
    
        
        
        
        return employeeService.insertEmployee(emp)
                ;
        
    }
        */    
}
