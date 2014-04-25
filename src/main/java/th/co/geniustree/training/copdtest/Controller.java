/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.training.copdtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nook
 */

@ManagedBean
@SessionScoped
public class Controller implements Serializable{
    @PersistenceContext
    private EntityManager em;
    
    private FollowUpTest foo;
    private List<FollowUpTest> fooList;
    
    @PostConstruct
    public void controller (){
         this.fooList = em.createQuery("select f from FollowUpTest f").getResultList();
    }

    public void onCreate(){
        foo = new FollowUpTest();
    }
    
    
    public void onSave(){
        fooList.add(getFoo());
        
    }
    
    
    public FollowUpTest getFoo() {
        if (foo==null){
            foo = new FollowUpTest();
        }
        return foo;
    }

    public void setFoo(FollowUpTest foo) {
        this.foo = foo;
    }

    public List<FollowUpTest> getFooList() {
        if (fooList==null){
            fooList = new ArrayList<>();
        }
        return fooList;
    }

    public void setFooList(List<FollowUpTest> fooList) {
        this.fooList = fooList;
    }
    
    
}
