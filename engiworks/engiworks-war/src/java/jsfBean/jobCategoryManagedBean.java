/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfBean;

import ejb.AdminBeanLocal;
import entity.Tbljobcategory;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Chaitanya
 */
@Named(value = "jobCategoryManagedBean")
@RequestScoped
public class jobCategoryManagedBean {
    @EJB
    private AdminBeanLocal abl;
    
    int jobcatid;
    String jobcatname;

    public AdminBeanLocal getAbl() {
        return abl;
    }

    public void setAbl(AdminBeanLocal abl) {
        this.abl = abl;
    }

    public int getJobcatid() {
        return jobcatid;
    }

    public void setJobcatid(int jobcatid) {
        this.jobcatid = jobcatid;
    }

    public String getJobcatname() {
        return jobcatname;
    }

    public void setJobcatname(String jobcatname) {
        this.jobcatname = jobcatname;
    }
    
    public Collection<Tbljobcategory> getAllJobCategory(){
        return abl.getAllJob();
    }
    
    public void clear(){
        jobcatid=0;
        jobcatname="";
    }
    
    public void insertJobCategory(){
        abl.addJobCategory(jobcatname);
        clear();
    } 
    
    public void removeCategory(int id){
        abl.deleteJobCategory(id);        
    }
    
    public String getJobCategory(int id){
        Tbljobcategory c = abl.getUpdateJobCategory(id);
      jobcatid  =c.getJobCategoryId();
        jobcatname=c.getJobCategoryName();
        return "EditJobCategory.xhtml";
    }
       
        public String postJobCategory(){
            System.out.println("jobid"+jobcatid);
        abl.postUpdateCategory(jobcatid, jobcatname);
        clear();
        return "ViewJobCategory.xhtml";
    }
        
    public jobCategoryManagedBean() {
    }
    
}
