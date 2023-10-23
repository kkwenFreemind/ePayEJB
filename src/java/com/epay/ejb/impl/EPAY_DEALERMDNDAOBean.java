/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_DEALERMDNDAO;
import com.epay.ejb.bean.EPAY_DEALERCARD;
import com.epay.ejb.bean.EPAY_DEALERMDN;
import com.epay.ejb.exception.DataNotFound;
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
@Local({EPAY_DEALERMDNDAO.class})
public class EPAY_DEALERMDNDAOBean implements EPAY_DEALERMDNDAO {

    private static Logger log = Logger.getLogger(EPAY_DEALERCARDDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EPAY_DEALERMDN geDearlMDNByMDN(String dealerId, String mdn) throws Exception {
//        EPAY_DEALERMDN rtCpInfo = null;
        Query query = null;
        try {
            query = em.createQuery("SELECT c FROM EPAY_DEALERMDN c  WHERE c.dealerId = '" + dealerId + "' AND c.mdn = '" + mdn + "'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_DEALERMDN rtresult = new EPAY_DEALERMDN();

        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }

        return rtresult;
//        List<EPAY_DEALERMDN> rtList = null;
//        Query query = null;
//        try {
//            query = em.createQuery("SELECT c FROM EPAY_DEALERMDN c  WHERE c.dealerId = '" + dealerId + "' AND c.mdn = '" + mdn + "'");
//            log.info("SELECT c FROM EPAY_DEALERMDN c  WHERE c.dealerId = '" + dealerId + "' AND c.mdn = '" + mdn + "'");
//            rtList = (List<EPAY_DEALERMDN>) query.getResultList();
//            if (rtList == null || rtList.isEmpty()) {
//                throw new DataNotFound("geDearlCardByCardId() DataNotFound");
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));        
//        Query query = null;
//
//        try {
//
//            log.info("SELECT c FROM EPAY_DEALERMDN c  WHERE c.dealerId = '" + dealerId + "' AND c.mdn = '" + mdn + "'");
//            query = em.createQuery("SELECT c FROM EPAY_DEALERMDN c  WHERE c.dealerId = '" + dealerId + "' AND c.mdn = '" + mdn + "'");
//            if (query.getSingleResult() == null) {
//                throw new DataNotFound("geDearlMDNByMDN() DataNotFound");
//            }
//            rtCpInfo = new EPAY_DEALERMDN();
//            rtCpInfo = (EPAY_DEALERMDN) query.getSingleResult();
//            if (rtCpInfo == null) {
//                throw new DataNotFound("geDearlMDNByMDN() DataNotFound");
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return rtCpInfo;
    }

    public static <T> T getSingleResult(Query query) {
        query.setMaxResults(1);
        List<?> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }
}
