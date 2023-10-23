/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;


import com.epay.ejb.EPAY_ROLECPDAO;
import com.epay.ejb.bean.EPAY_ROLECP;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local({EPAY_ROLECPDAO.class})
public class EPAY_ROLECPDAOBean implements EPAY_ROLECPDAO {

    @PersistenceContext
    protected EntityManager em;

    public boolean insertROLECP(EPAY_ROLECP rolecp) throws Exception {
        boolean result = false;
        try {
            em.persist(rolecp);
            result = true;
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean deleteROLECP_ByRId(String r_id) throws Exception {
        boolean rtresult = false;
        try {
            Query query = em.createQuery("delete from EPAY_ROLECP p  where p.pg_sys_roles.r_id='" + r_id + "'");
            if (query.executeUpdate() == 1) {
                rtresult = true;
            } else {
                rtresult = false;
            }
        } catch (Exception ex) {
            rtresult = false;
            throw ex;
        }
        return rtresult;
    }

//    public List getListROLECP(PG_SYS_ROLES sys_role, PG_CONTENT_PROVIDER cp) {
//
//        Query query = null;
//        List rtservice = null;
//
//        try {
//            query = em.createQuery("select p from PG_ROLECP p left join p.pg_sys_roles a left join p.pg_content_provider b where a.r_id = '" + sys_role.getR_id() + "' and  b.cp_code='" + cp.getCp_code() + "'");
//
//        } catch (NoResultException ex) {
//            throw new NoResultException();
//        } catch (Exception ex) {
//        }
//
//        rtservice = query.getResultList();
//
//        return rtservice;
//
//    }
}
