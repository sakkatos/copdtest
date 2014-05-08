/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest.control;

import th.co.geniustree.training.copdtest.model.FollowUpTest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
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
public class FollowUpService {

    private final EntityManager em;
    private final UserTransaction tx;

    public FollowUpService(EntityManager em, UserTransaction tx) {
        this.em = em;
        this.tx = tx;
    }
    
    public void remove(FollowUpTest foo){
        try {
            tx.begin();
            em.remove(foo);
        } catch (NotSupportedException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void insert(FollowUpTest foo){
        try {
            tx.begin();
            em.persist(foo);
        } catch (NotSupportedException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(FollowUpTest foo) {
        try {
            tx.begin();
            em.merge(foo);
        } catch (NotSupportedException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<FollowUpTest> findAll() {
        List<FollowUpTest> fooList = new ArrayList<>();
        try {
            tx.begin();
            fooList = em.createQuery("select f from FollowUpTest f").getResultList();
        } catch (NotSupportedException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                tx.commit();
            } catch (RollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(FollowUpService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fooList;
    }

}
