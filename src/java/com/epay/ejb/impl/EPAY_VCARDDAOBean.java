/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_VCARDDAO;
import com.epay.ejb.bean.EPAY_VCARD;
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
@Local({EPAY_VCARDDAO.class})
public class EPAY_VCARDDAOBean implements EPAY_VCARDDAO {

    private static Logger log = Logger.getLogger(EPAY_VCARDDAOBean.class);
    @PersistenceUnit
    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insertVCard(EPAY_VCARD bean) throws Exception {

        log.debug("entering. insertTransaction");

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

    @Override
    public EPAY_VCARD getVCPass(String tokenId) throws Exception {
        log.debug("entering. getTransaction");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_VCARD t where t.tokenid = '" + tokenId + "' and t.status= '1'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_VCARD rtresult = new EPAY_VCARD();
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

    @Override
    public boolean updateVCard(EPAY_VCARD bean) throws Exception {
        log.debug("entering. updateVCard");

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
    public EPAY_VCARD queryVCard(int id) throws Exception {
        log.debug("entering. getTransaction");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_VCARD t where t.id =" + id);

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_VCARD rtresult = new EPAY_VCARD();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public List<EPAY_VCARD> queryVCarderByCardType(String cardtype) throws Exception {
        log.debug("entering. queryVCarderByCardType");

        String jpqlStr
                = "select t from EPAY_VCARD t where t.cardtype ='" + cardtype + "' and t.status ='0'";
        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_VCARD> rtnTxList = new ArrayList<EPAY_VCARD>();
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
    public boolean queryVCardByFileName(String filename) throws Exception {
        log.debug("entering. queryVCardByFileName");
        boolean result = true;
        String jpqlStr
                = "select t from EPAY_VCARD t where t.filename ='" + filename + "'";
        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_VCARD> rtnTxList = new ArrayList<EPAY_VCARD>();
        try {
            query = em.createQuery(jpqlStr);
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            result = false;
        }

        return result;
    }

    @Override
    public EPAY_VCARD getVCardByToken(String tokenId, String mdn ,String serviceid) throws Exception {
        log.debug("entering. getVCardByToken");
        Query query = null;
        String sqlstat = "select t from EPAY_VCARD t where t.tokenid = '" + tokenId + "' and serviceid ='"+ serviceid +"' and t.status= '1' and t.mdn = '"+mdn+"' and TIMEDIFF(NOW(),t.orderexpiredate) < 0 ";
        try {
            query = em.createQuery(sqlstat);
        } catch (Exception ex) {
            throw ex;
        }

        EPAY_VCARD rtresult = new EPAY_VCARD();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

}
