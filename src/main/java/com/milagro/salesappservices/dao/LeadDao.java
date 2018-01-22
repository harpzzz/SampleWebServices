/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.salesappservices.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.milagro.salesappservices.jsonModel.JsonLeadsCounts;
import com.milagro.salesappservices.model.Project;
import org.hibernate.Cache;


/**
 *
 * @author harpreet
 */
@Repository("ILeadDao")
public class LeadDao implements ILeadDao {

    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public ArrayList<JsonLeadsCounts> leadstatus(Integer projectId) {
        
        Session session = sessionFactory.openSession();
        
        
        Query query  = session.createQuery("Select s.LeadStatus_Color, s.LeadStatus_Type, count(l.status) FROM Status s"
                + "                         LEFT JOIN Lead l ON l.status = s.LeadStatus_id"
                + "                         GROUP BY s.LeadStatus_id");
        
   //     session.clear();
         if(projectId != 0) {
            query  = session.createQuery("Select s.LeadStatus_Color, s.LeadStatus_Type, count(l.status) FROM Status s "
                + "                         LEFT JOIN Lead l ON l.status = s.LeadStatus_id AND l.project.Project_Id = ?"
                + "                         GROUP BY s.LeadStatus_id ");
            
            query.setParameter(0, projectId);
            
        }
        
        
       
        
       
        Iterator it = query.getResultList().iterator();
        
       
        
        ArrayList<JsonLeadsCounts> al = new ArrayList<>(); 
        
      while(it.hasNext()){
          
          
          JsonLeadsCounts jsonCounts = new JsonLeadsCounts();
          
          
           Object[] tuple = (Object[]) it.next();
             
           String leadColor = (String) tuple[0];
           
           String leadType = (String) tuple[1];
           
           Long c = (Long) Long.parseLong(tuple[2].toString());
           
            jsonCounts.setLeadColor(leadColor);
            jsonCounts.setLeadCount((int) (long) c);
            jsonCounts.setLeadName(leadType);


             al.add(jsonCounts);
            
      }  
      
      
      return al;
      
    }

    @Override
    public List<Project> getProjectList() {
        
        Session session = sessionFactory.openSession();
        
     //   session.clear();
        
        
        Query query = session.createQuery("Select p.Project_Id, p.Project_Name, p.Project_Region From Project p WHERE p.Project_Status = ?");
         query.setParameter(0, 1);
        
       
        
        List<Project> ls = new ArrayList<>();
        
        
        Iterator iterate = query.list().iterator();
        
        
        while(iterate.hasNext()){
        
            Project project = new Project();
            
            Object[] obj = (Object[]) iterate.next();
            
            project.setProject_Id(Integer.parseInt(obj[0].toString()));
            
            project.setProject_Name(obj[1].toString());
        
            project.setProject_Region(obj[2].toString());
            
            
            
            ls.add(project);
            
            
            
        }
        
        
        return ls;
        
        
    }

    @Override
    public List<HashMap<String, String>> getLeadsList(String tokenId, Integer projectId) {
        
       Session session = sessionFactory.openSession();
  
            session.clear();

       
      Query query = session.createQuery("Select l.lead_Id, l.lead_UName, l.lead_date, l.lead_Email, l.lead_Phone, p.Project_Name, p.Project_Region, lstatus.LeadStatus_Type, "
              + "user.user_Name, (Select COUNT(leadAssign_Id) FROM LeadCallLog WHERE leadAssign_Id = l.lead_AssignId), "
              + "(Select MAX(leadCall_DateTime) From LeadCallLog WHERE leadAssign_Id = l.lead_AssignId) FROM Lead l " 
               + "Inner join Project p ON p.Project_Id = l.project "
               + "Inner join Status lstatus ON l.status = lstatus.LeadStatus_id "
               + "left join LeadAssign assign ON assign.leadAssign_Id = l.lead_AssignId "
               + "left join User user ON user.user_Id = assign.user_Id ");
         //      + "left join LeadCallLog log ON  log.leadAssign_Id = assign.leadAssign_Id "
         //     + "HAVING assign.leadAssign_Id ");
       
/*    
        l.status = s.LeadStatus_id
/*       Select l.lead_Id, l.lead_UName, l.lead_date, l.lead_Email, l.lead_Phone, p.Project_Name, p.Project_Region , lstatus.LeadStatus_Type ,user.user_Name FROM tbl_leads as l 
			Inner join tbl_Project as p ON l.lead_Project_Id = p.Project_Id
            Inner join tbl_LeadStatus as lstatus ON l.lead_Status_Id = lstatus.LeadStatus_id
            left join tbl_leadAssign as assign ON assign.leadAssign_Id = l.lead_AssignId
            left join tbl_Users as user ON user.user_Id = assign.user_Id;
  */     

         Iterator iterate = query.list().iterator();

        
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        
        while(iterate.hasNext()){
            
            HashMap<String, String> hm = new HashMap<>();

            
            Object obj[] = (Object[]) iterate.next();
                
                hm.put("lead_Id", obj[0].toString());
                hm.put("lead_Name", obj[1].toString());
                hm.put("lead_date", obj[2].toString());
                hm.put("lead_email", obj[3].toString());
                hm.put("lead_phone", obj[4].toString());
                hm.put("lead_projectName", obj[5].toString());
                hm.put("lead_projectRegion", obj[6].toString());
                hm.put("lead_status", obj[7].toString());
                hm.put("lead_assignto", obj[8].toString());
                hm.put("lead_call_count", obj[9].toString());
                hm.put("lead_last_callDateTime", obj[10].toString());
           
            
                list.add(hm);
        }
        
       return list;
       
        
    }

  

    
}
