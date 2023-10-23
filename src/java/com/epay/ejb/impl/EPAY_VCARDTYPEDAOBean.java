/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_VCARDTYPEDAO;
import com.epay.ejb.bean.EPAY_VCARDTYPE;
import static com.epay.ejb.impl.EPAY_VCARDDAOBean.getSingleResult;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author kevinchang
 */
@Stateless
@Local({EPAY_VCARDTYPEDAO.class})
public class EPAY_VCARDTYPEDAOBean implements EPAY_VCARDTYPEDAO {

    private static Logger log = Logger.getLogger(EPAY_VCARDTYPEDAOBean.class);
    @PersistenceUnit
    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EPAY_VCARDTYPE> listAllCardTypeInfo() throws Exception {
        log.debug("entering. queryVCarderByCardType");

        String jpqlStr
                = "select t from EPAY_VCARDTYPE t ";
        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_VCARDTYPE> rtnTxList = new ArrayList<EPAY_VCARDTYPE>();
        try {
            query = em.createQuery(jpqlStr);
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            rtnTxList.addAll(query.getResultList());
        }
        return rtnTxList;
    }

    @Override
    public EPAY_VCARDTYPE queryCardTypeByCardType(String cardtype) throws Exception {
        log.debug("entering. queryCardTypeByCardType");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_VCARDTYPE t where t.cardtype ='" + cardtype + "'");

        } catch (Exception ex) {
            log.info(ex);
        }

        EPAY_VCARDTYPE rtresult = new EPAY_VCARDTYPE();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            log.info(ex);
        }
        return rtresult;
    }

    @Override
    public boolean updateVCardType(EPAY_VCARDTYPE bean) throws Exception {
        log.debug("entering. updateVCardType");

        boolean result = false;

        try {
            em.merge(bean);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }

    @Override
    public boolean insertVCardType(EPAY_VCARDTYPE bean) throws Exception {

        log.debug("entering. insertVCardType");

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
