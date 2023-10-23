/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_BUCKETHISTORYDAO;
//import com.epay.ejb.EPAY_INVOICEDAO;
import com.epay.ejb.bean.EPAY_BUCKETHISTORY;
//import com.epay.ejb.bean.EPAY_INVOICE;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author kevinchang
 */
@Stateless
@Local({EPAY_BUCKETHISTORYDAO.class})
public class EPAY_BUCKETHISTORYDAOBean implements EPAY_BUCKETHISTORYDAO{

    private static Logger log = Logger.getLogger(EPAY_BUCKETHISTORYDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insertbuckethistory(EPAY_BUCKETHISTORY bean) throws Exception {
        log.debug("entering. insertbuckethistory");
        boolean result = false;
        try {
            em.persist(bean);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }

}
