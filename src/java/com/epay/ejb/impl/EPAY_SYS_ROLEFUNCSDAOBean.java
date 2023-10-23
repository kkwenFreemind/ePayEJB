/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_SYS_ROLEFUNCSDAO;
import com.epay.ejb.bean.EPAY_SYS_ROLEFUNCS;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author kevinchang
 */
@Stateless
@Local({EPAY_SYS_ROLEFUNCSDAO.class})
public class EPAY_SYS_ROLEFUNCSDAOBean implements EPAY_SYS_ROLEFUNCSDAO {

    private static Logger log = Logger.getLogger(EPAY_SYS_ROLEFUNCSDAOBean.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean insert_SYS_ROLE_FUNCTIONS(EPAY_SYS_ROLEFUNCS rolefunc) {
        boolean result = false;
        try {
            em.persist(rolefunc);
            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println(e);
        }
        return result;
    }

    @Override
    public boolean update_SYS_ROLE_FUNCTIONS(EPAY_SYS_ROLEFUNCS rolefunc) {
        boolean result = false;
        try {
            em.merge(rolefunc);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List getAllRoleFuncs() {
        List rtList = null;
        Query query;// = null;
        try {
            query = em.createQuery("select p from EPAY_SYS_ROLEFUNCS p");
            rtList = query.getResultList();
            // query = em.
        } catch (Exception ex) {
        }
        return rtList;    }

    @Override
    public EPAY_SYS_ROLEFUNCS getRoleFuncs_BY_RoleID(int roleid) {
        Query query = em.createQuery("select p from EPAY_SYS_ROLEFUNCS p where id =" + roleid + " order by fr_id");

        return (EPAY_SYS_ROLEFUNCS) query.getSingleResult();
    }
}
