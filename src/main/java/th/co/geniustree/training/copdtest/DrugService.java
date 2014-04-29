/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
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
public class DrugService {

    private final EntityManager em;
    private final UserTransaction tx;

    public DrugService(EntityManager em, UserTransaction tx) {
        this.em = em;
        this.tx = tx;
    }
    
    public void remove(Drug drug){
        try {
            tx.begin();
            em.remove(drug);
        } catch (NotSupportedException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void insert(Drug drug){
        try {
            tx.begin();
            em.persist(drug);
        } catch (NotSupportedException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(Drug drug){
        try {
            tx.begin();
            em.merge(drug);
        } catch (NotSupportedException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Drug> findAll() {
        List<Drug> drugList = new ArrayList<>();
        try {
            tx.begin();
            drugList = em.createQuery("select d from Drug d").getResultList();
        } catch (NotSupportedException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DrugService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return drugList;
    }
}
