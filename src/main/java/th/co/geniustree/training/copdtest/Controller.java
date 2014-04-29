/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest;

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
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
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
    private FollowUpTest foo;
    private List<FollowUpTest> fooList;
    private DrugService drugService;
    private Drug drug;
    private List<Drug> drugList;

    @PostConstruct
    public void controller() {
        this.fooList = em.createQuery("select f from FollowUpTest f").getResultList();
    }

    //--------------------------------------------------------------------
    //--------------------------------------------------------------------
    public List<FollowUpTest> findAllFollowUp() {
        setFooList(getFollowUpService().findAll());
        return getFooList();
    }

    public void onCreateFollowUp() {
        foo = new FollowUpTest();
    }

    public void onInsertFollowUp() {
        getFollowUpService().insert(foo);
        fooList.add(foo);
    }

    public void onUpdateFollowUp() {
        getFollowUpService().update(foo);
    }

    public void onRemoveFollowUp() {
        getFollowUpService().remove(foo);
        fooList.remove(foo);
    }

    public void onSelectFollowUp() {
        String pid = requestParam("pid");
        System.out.println(pid);
        int indexOf = this.getFooList().indexOf(new FollowUpTest(pid));
        foo = this.getFooList().get(indexOf);
    }

    public List<Drug> findAllDrug() {
        setDrugList(getDrugService().findAll());
        return getDrugList();
    }

    public void onCreateDrug() {
        drug = new Drug();
    }

    public void onInsertDrug() {
        getDrugService().insert(drug);
        drugList.add(drug);
    }

    public void onUpdateDrug() {
        getDrugService().update(drug);
    }

    public void onRemoveDrug() {
        getDrugService().remove(drug);
        drugList.remove(drug);
    }

    public void onSelectDrug() {
        String drugId = requestParam("drugId");
        System.out.println(drugId);
        int indexOf = this.getDrugList().indexOf(new Drug(drugId));
        drug = this.getDrugList().get(indexOf);
    }

    //--------------------------------------------------------------------
    //--------------------------------------------------------------------
    public String requestParam(String paramName) {
        return FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(paramName);
    }

    public FollowUpTest getFoo() {
        if (foo == null) {
            foo = new FollowUpTest();
        }
        return foo;
    }

    public void setFoo(FollowUpTest foo) {
        this.foo = foo;
    }

    public List<FollowUpTest> getFooList() {
        if (fooList == null) {
            fooList = new ArrayList<>();
        }
        return fooList;
    }

    public void setFooList(List<FollowUpTest> fooList) {
        this.fooList = fooList;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public List<Drug> getDrugList() {
        if (drugList == null) {
            drugList = new ArrayList<>();
        }
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
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

    public DrugService getDrugService() {
        if (drugService == null) {
            drugService = new DrugService(em, tx);
        }
        return drugService;
    }

    public void setDrugService(DrugService drugService) {
        this.drugService = drugService;
    }

}
