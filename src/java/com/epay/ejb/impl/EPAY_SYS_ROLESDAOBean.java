/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.epay.ejb.EPAY_SYS_ROLESDAO;
import com.epay.ejb.bean.EPAY_SYS_ROLES;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local({EPAY_SYS_ROLESDAO.class})
public class EPAY_SYS_ROLESDAOBean implements EPAY_SYS_ROLESDAO {

    @PersistenceContext
    protected EntityManager em;

    public EPAY_SYS_ROLES findFuncID_BYRoleID(String roleid) {

        Query query = em.createQuery("select p from EPAY_SYS_ROLES p where r_id ='" + roleid + "'");

        return (EPAY_SYS_ROLES) query.getSingleResult();
    }

    public EPAY_SYS_ROLES getRoles_BYRoleID(String roleid) {

        Query query = em.createQuery("select p from EPAY_SYS_ROLES p where r_id ='" + roleid + "'");

        return (EPAY_SYS_ROLES) query.getSingleResult();
    }

    public String getRoleName_id(String id) {
        Query query = null;
        try {
            query = em.createQuery("select p.fr_id from EPAY_SYS_ROLEFUNCS p left join  p.pg_sys_funtions a where a.f_id='f1_1'");

        } catch (NoResultException ex) {
        }

        if (query.getSingleResult() != null) {
            return (String) query.getSingleResult();
        } else {
            return null;
        }
    }

    public List getAllRoles() {
        List rtList = null;
        Query query = null;
        try {
            query = em.createQuery("select p from EPAY_SYS_ROLES p");
            rtList = query.getResultList();
            // query = em.
        } catch (Exception ex) {
        }
        return rtList;
    }

    @Override
    public boolean insert_SYS_ROLES(EPAY_SYS_ROLES role) throws Exception {
        boolean result = false;
        try {
            em.persist(role);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update_SYS_ROLES(EPAY_SYS_ROLES role) throws Exception {
        boolean result = false;
        try {
            em.merge(role);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }
}
