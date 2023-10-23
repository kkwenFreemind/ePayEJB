/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_PROMOTIONCODEDAO;
import com.epay.ejb.bean.EPAY_INVOICE;
import com.epay.ejb.bean.EPAY_IP_TABLES;
import com.epay.ejb.bean.EPAY_PROMOTIONCODE;
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
@Local({EPAY_PROMOTIONCODEDAO.class})
public class EPAY_PROMOTIONCODEDAOBean implements EPAY_PROMOTIONCODEDAO {

    private static Logger log = Logger.getLogger(EPAY_PROMOTIONCODEDAOBean.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EPAY_PROMOTIONCODE getPlatformType(String promotioncode) throws Exception {
        Query query = null;
        try {
            query = em.createQuery("select p from EPAY_PROMOTIONCODE p where p.promotioncode ='" + promotioncode + "'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_PROMOTIONCODE rtresult = new EPAY_PROMOTIONCODE();

        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }

        return rtresult;
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
