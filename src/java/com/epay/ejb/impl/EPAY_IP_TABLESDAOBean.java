/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_IP_TABLESDAO;
import com.epay.ejb.bean.EPAY_IP_TABLES;
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
@Local({EPAY_IP_TABLESDAO.class})
public class EPAY_IP_TABLESDAOBean implements EPAY_IP_TABLESDAO {

    private static Logger log = Logger.getLogger(EPAY_IP_TABLESDAOBean.class);
    
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EPAY_IP_TABLES getIP_TABLES_ByCPID(int cpid) throws Exception {
        Query query = null;
        try {
            query = em.createQuery("select p from EPAY_IP_TABLES p where p.cp_id =" + cpid);

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_IP_TABLES rtresult = null;
        boolean getresult = false;
        try {
            if (query.getSingleResult() != null) {
                getresult = true;
            } else {
                getresult = false;
            }
        } catch (Exception ex) {
            throw ex;
        }
        if (getresult) {
            rtresult = new EPAY_IP_TABLES();
            rtresult = (EPAY_IP_TABLES) query.getSingleResult();
        } else {
            rtresult = null;
        }
        return rtresult;
    }
    

}
