package com.epay.ejb.impl;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.epay.ejb.EPAY_CALLERDAO;
import com.epay.ejb.bean.EPAY_CALLER;
import com.epay.ejb.exception.DataNotFound;

/**
 *
 */
@Stateless
@Local({EPAY_CALLERDAO.class})
public class EPAY_CALLERDAOBean implements EPAY_CALLERDAO {

    private static Logger log = Logger.getLogger(EPAY_CP_INFODAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EPAY_CALLER getCaller(String callId) throws Exception {
        EPAY_CALLER rtCaller = null;
        Query query = null;

        try {

            query = em.createQuery("SELECT c FROM EPAY_CALLER c WHERE c.callerid = '" + callId + "'");
            if (query.getSingleResult() == null) {
                throw new DataNotFound("getCaller() DataNotFound");
            }
            rtCaller = new EPAY_CALLER();
            rtCaller = (EPAY_CALLER) query.getSingleResult();
            if (rtCaller == null) {
                throw new DataNotFound("getCaller() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtCaller;
    }

    @Override
    public List<EPAY_CALLER> getAllCaller() throws Exception {

        List<EPAY_CALLER> rltCaller = new ArrayList<EPAY_CALLER>();
        Query query = null;
        try {
            query = em.createQuery("SELECT c FROM EPAY_CALLER c ORDER BY c.callid");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                rltCaller.addAll(query.getResultList());
            }
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception e) {
            throw e;
        }
        return rltCaller;
    }

}
