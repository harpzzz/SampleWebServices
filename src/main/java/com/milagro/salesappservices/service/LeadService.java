/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.service;

import com.milagro.salesappservices.dao.LeadDao;
import com.milagro.salesappservices.jsonModel.JsonLeadsCounts;
import com.milagro.salesappservices.model.Project;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
    public Object getLeadsCount(String tokenId, Integer projectId) {
        
          JsonObjectBuilder json = Json.createObjectBuilder();
          
                

          
          JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        

        ArrayList<JsonLeadsCounts> al = leadDao.leadstatus(projectId);
        
        int totalCount = 0;
        
        
        
        
        
        for(JsonLeadsCounts  jlc: al){
                
             JsonObject jsonType = Json.createObjectBuilder()
                      .add("LeadType", jlc.getLeadName())
                      .add("Leadcount", jlc.getLeadCount())
                     .add("LeadColor", jlc.getLeadColor()).build();
            
                    jsonArrayBuilder.add(jsonType);
                    
                    totalCount += jlc.getLeadCount();
            
        }
        
        
        
        
        
        
        
        /*  Long totalCount = 0L;
        
          Iterator it = hm.entrySet().iterator();
            while (it.hasNext()) {
        
                
                 Map.Entry pair = (Map.Entry)it.next();
                 
                 
                 String s = (String) pair.getKey();
                 Long l =  Long.parseLong(pair.getValue().toString());
                 
                 totalCount += l ; 
                 
              JsonObject jsonType = Json.createObjectBuilder()
                      .add("LeadType", s)
                      .add("count",l).build();
            
                    jsonArrayBuilder.add(jsonType);
        
        
            }
*/
            
        JsonArray jsA = jsonArrayBuilder.build();
            
        
            json.add("status",true);
            json.add("message","List found!");
            json.add("totalCount",totalCount);
            json.add("listTypeCount",jsA);
            json.add("To", "");
            json.add("From", "");
          
        JsonObject js = json.build();
        


        return js;
        
        
        
        
    }

    @Override
    public Object getProjectList(String tokenId) {
        
        
        List<Project> projects = leadDao.getProjectList();
        
        
       JsonObjectBuilder job = Json.createObjectBuilder();
       
       JsonArrayBuilder jab = Json.createArrayBuilder();
       
       job.add("status", true);
       job.add("message", "Project list find!");
       
       
       JsonObjectBuilder jsonAll = Json.createObjectBuilder();
       
       jsonAll.add("pProjectId", 0);
       jsonAll.add("pProjectName", "All");
       jsonAll.add("pProjectRegion", "");
       jab.add(jsonAll.build());
       
       
       for(Project p: projects){
       
           JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
           
           
           jsonBuilder.add("pProjectId",p.getProject_Id());
           jsonBuilder.add("pProjectName",p.getProject_Name());
           jsonBuilder.add("pProjectRegion",p.getProject_Region());
           
           jsonBuilder.add("pCityId",0);
           
       
           jab.add(jsonBuilder.build());
           
       
       }
       
       
       job.add("projectList", jab);
       
       
       return job.build();



        
    }

    @Override
    public Object getLeadList(String tokenId, Integer projectId) {
    
          List<HashMap<String, String>> hmapl = leadDao.getLeadsList(tokenId,projectId);
          
          JsonObjectBuilder job = Json.createObjectBuilder();
          
          
          JsonArrayBuilder jab = Json.createArrayBuilder();
          
          
          job.add("status", true);
          job.add("message", "List of leads!");

          for(HashMap<String,String> hm: hmapl){
          
               JsonObjectBuilder jsonObject = Json.createObjectBuilder();
         
              
              for( Map.Entry<String, String> es: hm.entrySet()){
              
                  jsonObject.add(es.getKey(), es.getValue());
                  
                  
              }
              
              
              jab.add(jsonObject.build());
              
              
              
          }
          
       
          job.add("data",jab.build());
          
          
          
        return job.build();
          
       
    }

    
   

    
    
    
    
    
}
