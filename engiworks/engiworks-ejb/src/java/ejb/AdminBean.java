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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Chaitanya
 */
@Stateless
public class AdminBean implements AdminBeanLocal {
    @PersistenceContext(unitName = "engiworks-ejbPU")
    EntityManager em;
    //---------------------------------------------------------------------------------- Achievement 

    @Override
    public Collection<Tblachievement> getAllAchievement() {
        return em.createNamedQuery("Tblachievement.findAll").getResultList();
    }

    
    //---------------------------------------------------------------------------------- CITY 
    @Override
    public void addCity(Tblcity c) {
        Tblcity obja = new Tblcity();
        Tblstate s = c.getStateId();
        Tblstate s1 = em.find(Tblstate.class, s.getStateId());
        Collection<Tblcity> t = s1.getTblcityCollection();
        obja.setCityName(c.getCityName());
        obja.setStateId(s1);
        t.add(obja);
        em.merge(s1);
        em.persist(obja);  
    }

    @Override
    public Collection<Tblcity> getAllCity() {
        return em.createNamedQuery("Tblcity.findAll").getResultList();
    }

    @Override
    public void deleteCity(int c) {
    try{
        Tblcity city = em.find(Tblcity.class, c);
        em.remove(city);
       }
    catch(Exception ex){ex.getMessage();}
    }
//-------------------------------------------------------------------------------------- Comment 
    @Override
    public Collection<Tblcomment> getAllComment() {
        return em.createNamedQuery("Tblcomment.findAll").getResultList();
    }
//-------------------------------------------------------------------------------------- Compaint 

    @Override
    public Collection<Tblcomplaint> getAllComplaint() {
        return em.createNamedQuery("Tblcomplaint.findAll").getResultList();
    }
//------------------------------ Complaint block Is Left-------------

   
 //------------------------------------------------------------------------------------ JobCategory 
//    @Override
//    public void addJobCategory(Tbljobcategory jc) {
//        Tbljobcategory objjc = new Tbljobcategory();
//        objjc.setJobCategoryName(jc.getJobCategoryName());
//        em.persist(objjc);
//    }

    @Override
    public void addJobCategory(String jcn) {
        Tbljobcategory cat = new Tbljobcategory();
        cat.setJobCategoryName(jcn);
        em.persist(cat);  
    }
    
    @Override
    public Collection<Tbljobcategory> getAllJob() {
        return em.createNamedQuery("Tbljobcategory.findAll").getResultList();
    }

    @Override
    public Tbljobcategory getUpdateJobCategory(int jcid) {
        Tbljobcategory c = em.find(Tbljobcategory.class, jcid);
        return c;   
    }
    
    @Override
    public void postUpdateCategory(int jcid, String jcn) {
        Tbljobcategory c = em.find(Tbljobcategory.class, jcid);
        c.setJobCategoryId(jcid);
        c.setJobCategoryName(jcn);
        em.merge(c);    
    }

    @Override
    public void deleteJobCategory(int jcid) {
        try{
               Tbljobcategory jc = em.find(Tbljobcategory.class, jcid);
                em.remove(jc);
        }
        catch(Exception ex){ex.getMessage();}
    }
//-------------------------------------------------------------------------------------- JobSubCategory 
    @Override
    public void addJobSubCategory(Tbljobsubcategory jc) {
        Tbljobsubcategory objjsc = new Tbljobsubcategory();
        Tbljobcategory j = jc.getJobCategoryId();
        Tbljobcategory j1 = em.find(Tbljobcategory.class,j.getJobCategoryId());
        Collection<Tbljobsubcategory> t = j1.getTbljobsubcategoryCollection();
        objjsc.setJobCategoryId(j1);
        objjsc.setJobSubCategoryName(jc.getJobSubCategoryName());
        t.add(objjsc);
        em.merge(j1);
        em.persist(jc);
    }

    @Override
    public Tbljobsubcategory getUpdateSubCategory(int cid) {
        return em.find(Tbljobsubcategory.class, cid);
    }

    @Override
    public void postUpdateJobSubCategory(Tbljobsubcategory jc) {
        Tbljobsubcategory jsc = em.find(Tbljobsubcategory.class,jc.getJobSubCategoryId());
        Tbljobcategory j = jc.getJobCategoryId();
        Tbljobcategory j1 = em.find(Tbljobcategory.class,j.getJobCategoryId());
        Collection<Tbljobsubcategory> t = j1.getTbljobsubcategoryCollection();
        jsc.setJobCategoryId(j1);
        jsc.setJobSubCategoryName(jc.getJobSubCategoryName());
        t.add(jsc);
        em.merge(j1);
        em.merge(jsc);
    }

    @Override
    public void deleteSubJobCategory(int jscid) {
         try{
               Tbljobsubcategory jc = em.find(Tbljobsubcategory.class, jscid);
        em.remove(jc);
        }
        catch(Exception ex){ex.getMessage();}
    }
    
//----------------------------------------------------------------------------------- JobVerificaton
    @Override
    public Collection<Tbljobverificationrequest> getAllRequest() {
        return em.createNamedQuery("Tbljobverificationrequest.findAll").getResultList();
    }
   //-------------   block Job Verification is Left  --------------

   
    


//----------------------------------------------------------------------------------- Requirement 
    @Override
    public Collection<Tblrequirement> getAllRequirement() {
        return em.createNamedQuery("Tblrequirement.findAll").getResultList();
    }
    
//----------------------------------------------------------------------------------- RequirementBid
       @Override
    public Collection<Tblrequirementbid> getAllBid() {
        return em.createNamedQuery("Tblrequirementbid.findAll").getResultList();
    }
    
//----------------------------------------------------------------------------------- Review   
   @Override
    public Collection<Tblreview> getAllReview() {
        return em.createNamedQuery("Tblreview.findAll").getResultList();
    }
    
//----------------------------------------------------------------------------------- State    
    @Override
    public void addState(Tblstate s) {
        Tblstate objs = new Tblstate();
        objs.setStateName(s.getStateName());
        em.persist(objs);   
    }

    @Override
    public Collection<Tblstate> getAllState() {
        return em.createNamedQuery("Tblstate.findAll").getResultList();
    } 
    @Override
    public void deleteState(int c) {
          Tblstate state = em.find(Tblstate.class, c);
        em.remove(state);
    }   

    
    
    //---------------------------------- userSearch
    @Override
    public Collection<Tbluser> searchUser(String uname, String city, String type) {
        String q1 = "Select u.* from Tbluser u ";
        String q2 = " u.userName like '%"+uname+"%' ";
        String q3 = " inner join Tblcity c on u.cityId = c.cityId where c.cityId in(select cityId from Tblcity where cityName like '%"+city+"%') ";
        String q4 = " u.type like '%"+type+"%' ";
        String finalQ=null;
        if(!uname.equals("") && !city.equals("") && !type.equals(""))
        {
            finalQ = q1 + q3 + " and " + q2 + " and " + q4;
        }
        else if(!uname.equals("") && city.equals("") && type.equals(""))
        {
            finalQ = q1 + " where " + q2;
        }
        else if(!uname.equals("") && !city.equals("") && type.equals(""))
        {
            finalQ =  q1 + q3 + " and " + q2;
        }
        else if(!uname.equals("") && city.equals("") && !type.equals(""))
        {
            finalQ = q1 + " where " + q2 + " and " + q4;
        }
        else if(uname.equals("") && !city.equals("") && !type.equals(""))
        {
            finalQ = q1 + q3 + " and " + q4;
        }
        else if(uname.equals("") && !city.equals("") && type.equals(""))
        {
            finalQ = q1 + q3;
        }
        else if(uname.equals("") && city.equals("") && !type.equals(""))
        {
            finalQ = q1 + " where " + q4;
        }
        else
        {
            finalQ = q1;
        }
        Collection<Tbluser> users = em.createNativeQuery(finalQ,Tbluser.class).getResultList();
        return users;

    }

}


    