/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_BUNDELDATEDAO;
//import com.epay.ejb.EPAY_CALLERDAO;
import com.epay.ejb.bean.EPAY_BUNDLEDATE;
//import com.epay.ejb.bean.EPAY_CALLER;
import com.epay.ejb.exception.DataNotFound;
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
@Local({EPAY_BUNDELDATEDAO.class})
public class EPAY_BUNDLEDATEDAOBean {

    private static Logger log = Logger.getLogger(EPAY_BUNDLEDATEDAOBean.class);
    @PersistenceContext
    private EntityManager em;

    public EPAY_BUNDLEDATE getBundleDate(String hours) throws Exception {

        EPAY_BUNDLEDATE rtbundledate = null;
        Query query = null;

        try {

            query = em.createQuery("SELECT DATE_ADD(NOW( ),INTERVAL" + hours + "HOUR");
            if (query.getSingleResult() == null) {
                throw new DataNotFound("getCaller() DataNotFound");
            }
            rtbundledate = new EPAY_BUNDLEDATE();
            rtbundledate = (EPAY_BUNDLEDATE) query.getSingleResult();
            if (rtbundledate == null) {
                throw new DataNotFound("rtbundledate() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtbundledate;

    }

}
