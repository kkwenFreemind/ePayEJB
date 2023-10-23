/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.bean.EPAY_SYS_SERVER;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevinchang
 */
public class EPAY_SYS_SERVERDAOBean {

    @PersistenceContext
    protected EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public EPAY_SYS_SERVER getSystem() {
         Query query = em.createQuery("select p from EPAY_SYS_SERVER p");
         return (EPAY_SYS_SERVER) query.getSingleResult();
    }
}
