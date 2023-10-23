/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.epay.ejb.EPAY_SYS_FUNCTIONSDAO;
import com.epay.ejb.bean.EPAY_COMMON_USER;
import com.epay.ejb.bean.EPAY_SERVICE_INFO;
import com.epay.ejb.bean.EPAY_SYS_FUNCTIONS;
import com.epay.ejb.exception.DataNotFound;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local({EPAY_SYS_FUNCTIONSDAO.class})
public class EPAY_SYS_FUNCTIONSDAOBean implements EPAY_SYS_FUNCTIONSDAO {

    @PersistenceContext
    protected EntityManager em;

    public List ListParentName_ByRole(String role_id) {
        //    Query query = em.createQuery("select distinct p.p_name from PG_SYS_FUNCTIONS p  where p.f_id in  (select b.f_id from PG_SYS_ROLEFUNCS a left join a.pg_sys_funtions b where a.fr_id='" + role_id + "')");
        Query query = em.createQuery("select distinct p.p_name from EPAY_SYS_FUNCTIONS p  where p.f_id in  (select a.f_id from EPAY_SYS_ROLEFUNCS a where a.fr_id='" + role_id + "') order by p.f_id ");
// System.out.println("@@query:"+query);
        List list = query.getResultList();
        //  System.out.println("@@list1:"+list.get(0));
        return list;
    }

    public List ListFunction_ByRole(String role_id) {
//        Query query = em.createQuery(
//                "select p from PG_SYS_FUNCTIONS p  where p.f_id in  (select b.f_id from PG_SYS_ROLEFUNCS a left join a.pg_sys_funtions b where a.fr_id='" + role_id + 
        Query query = em.createQuery(
                "select p from EPAY_SYS_FUNCTIONS p  where p.f_id in  (select a.f_id from EPAY_SYS_ROLEFUNCS a  where a.fr_id='" + role_id + "') order by p.f_id desc");
        List list = query.getResultList();
        return list;
    }

    @Override
    public boolean insert_SYS_FUNCTIONS(EPAY_SYS_FUNCTIONS func) throws Exception {
        boolean result = false;
        try {
            em.persist(func);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update_SYS_FUNCTIONS(EPAY_SYS_FUNCTIONS func) throws Exception {
        boolean result = false;
        try {
            em.merge(func);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }

    @Override
    public List getFuncInfo() throws Exception {
        List rtList = null;
        Query query = null;

        try {
            query = em.createQuery("select s from EPAY_SYS_FUNCTIONS s ");
            rtList = (List<EPAY_SYS_FUNCTIONS>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public EPAY_SYS_FUNCTIONS getFunc_byUserCode(String id) throws Exception {
        Query query = null;
        try {
            query = em.createQuery("select p from EPAY_SYS_FUNCTIONS p  where p.f_id='" + id + "'");

        } catch (NoResultException ex) {
//            throw ex;
        } catch (Exception ex) {
            throw ex;
        }

        EPAY_SYS_FUNCTIONS rtresult = null;
        boolean getresult = false;
        try {
            if (query.getSingleResult() != null) {
                getresult = true;
            } else {
                getresult = false;
            }
        } catch (NoResultException ex) {
//            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        if (getresult) {
            rtresult = new EPAY_SYS_FUNCTIONS();
            rtresult = (EPAY_SYS_FUNCTIONS) query.getSingleResult();
        } else {
            rtresult = null;
        }
        return rtresult;
    }

}
