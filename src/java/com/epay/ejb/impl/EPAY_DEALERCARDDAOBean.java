/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_CP_INFODAO;
import com.epay.ejb.EPAY_DEALERCARDDAO;
import com.epay.ejb.bean.EPAY_BUCKET;
import com.epay.ejb.bean.EPAY_DEALERCARD;
import com.epay.ejb.bean.EPAY_PROMOTIONCODE;
import com.epay.ejb.exception.DataNotFound;
import static com.epay.ejb.impl.EPAY_PROMOTIONCODEDAOBean.getSingleResult;
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
@Local({EPAY_DEALERCARDDAO.class})
public class EPAY_DEALERCARDDAOBean implements EPAY_DEALERCARDDAO {

    private static Logger log = Logger.getLogger(EPAY_DEALERCARDDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EPAY_DEALERCARD geDearlCardByCardId(String dealerId, String cardId) throws Exception {

        Query query = null;
        try {
            query = em.createQuery("SELECT c FROM EPAY_DEALERCARD c  WHERE c.dealerId = '" + dealerId + "' AND c.cardId = '"+cardId+"'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_DEALERCARD rtresult = new EPAY_DEALERCARD();

        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }

        return rtresult;
//
//        List<EPAY_DEALERCARD> rtList = null;
//        Query query = null;
//        try {
//            query = em.createQuery("SELECT c FROM EPAY_DEALERCARD c  WHERE c.dealerId = '" + dealerId + "' AND c.cardId = '"+cardId+"'");
//            log.info("SELECT c FROM EPAY_DEALERCARD c  WHERE c.dealerId = '" + dealerId + "' AND c.cardId = '"+cardId+"'");
//            rtList = (List<EPAY_DEALERCARD>) query.getResultList();
//            if (rtList == null || rtList.isEmpty()) {
//                throw new DataNotFound("geDearlCardByCardId() DataNotFound");
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));

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
