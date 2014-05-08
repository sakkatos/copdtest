/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest.control;

import th.co.geniustree.training.copdtest.model.FollowUpTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Nook
 */
@ManagedBean
@SessionScoped
public class Controller implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    private UserTransaction tx;
    private FollowUpService followUpService;
    private FollowUpTest followUp;
    private List<FollowUpTest> followUpList;
 
    @PostConstruct
    public void controller() {
        this.followUpList = em.createQuery("select f from FollowUpTest f").getResultList();
    }
    
    public void initFollowUp(){
        this.followUpList = em.createQuery("select f from FollowUpTest f").getResultList();
    }


    //--------------------------------------------------------------------
    //--------------------------------------------------------------------
    public List<FollowUpTest> findAllFollowUp() {
        setFollowUpList(getFollowUpService().findAll());
        return getFollowUpList();
    }

    public void onCreateFollowUp() {
        followUp = new FollowUpTest();
    }

    public void onInsertFollowUp() {
        getFollowUpService().insert(followUp);
        followUpList.add(followUp);
    }

    public void onUpdateFollowUp() {
        getFollowUpService().update(followUp);
    }

    public void onRemoveFollowUp() {
        getFollowUpService().remove(followUp);
        followUpList.remove(followUp);
    }

    public void onSelectFollowUp() {
        String pid = requestParam("followUpId");
        System.out.println(pid);
        int indexOf = this.getFollowUpList().indexOf(new FollowUpTest(pid));
        followUp = this.getFollowUpList().get(indexOf);
    }

    //--------------------------------------------------------------------
    //--------------------------------------------------------------------
    public String requestParam(String paramName) {
        return FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(paramName);
    }

    public FollowUpTest getFollowUp() {
        if (followUp == null) {
            followUp = new FollowUpTest();
        }
        return followUp;
    }

    public void setFollowUp(FollowUpTest followUp) {
        this.followUp = followUp;
    }

    public List<FollowUpTest> getFollowUpList() {
        if (followUpList == null) {
            followUpList = new ArrayList<>();
        }
        return followUpList;
    }

    public void setFollowUpList(List<FollowUpTest> followUpList) {
        this.followUpList = followUpList;
    }


    public FollowUpService getFollowUpService() {
        if (followUpService == null) {
            followUpService = new FollowUpService(em, tx);
        }
        return followUpService;
    }

    public void setFollowUpService(FollowUpService followUpService) {
        this.followUpService = followUpService;
    }

}
