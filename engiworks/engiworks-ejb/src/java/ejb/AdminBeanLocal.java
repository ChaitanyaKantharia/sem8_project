/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblachievement;
import entity.Tblcity;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbljobcategory;
import entity.Tbljobsubcategory;
import entity.Tbljobverificationrequest;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tblstate;
import entity.Tbluser;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Chaitanya
 */
@Local
public interface AdminBeanLocal {
        //Achievement
        Collection<Tblachievement> getAllAchievement();       
     //City   
        void addCity(Tblcity c);
        Collection<Tblcity> getAllCity();
        void deleteCity(int c);
        
    //Comment   
        Collection<Tblcomment> getAllComment();
        
    //Complaint   
        Collection<Tblcomplaint>getAllComplaint();
        
    //JobCategory
        public void addJobCategory(String jcn);
        Collection<Tbljobcategory> getAllJob();
        public void postUpdateCategory(int jcid,String jcn);
        public Tbljobcategory getUpdateJobCategory(int jcid);
        public void deleteJobCategory(int jcid);
        
    //JobSubCategory
        void addJobSubCategory(Tbljobsubcategory jc);
        Tbljobsubcategory getUpdateSubCategory(int cid);
        void postUpdateJobSubCategory(Tbljobsubcategory jc); 
        void deleteSubJobCategory(int jscid);
    
    //JobVerification
        Collection<Tbljobverificationrequest> getAllRequest();
     
    //Requirement
        Collection<Tblrequirement> getAllRequirement();
        
    //RequirementBid
            Collection<Tblrequirementbid> getAllBid();


    //Review
            Collection<Tblreview> getAllReview();

        
    //State
        void addState(Tblstate s);
        Collection<Tblstate> getAllState();
        void deleteState(int c);
        
        
    //UserSearch
        Collection<Tbluser> searchUser(String uname, String city, String type);
}
