/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

import com.epay.ejb.EPAY_SCTCARDDAO;
import com.epay.ejb.bean.EPAY_SCT_CARD;
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
@Local({EPAY_SCTCARDDAO.class})
public class EPAY_SCTCARDDAOBean implements EPAY_SCTCARDDAO {

    private static Logger log = Logger.getLogger(EPAY_SCTCARDDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EPAY_SCT_CARD getSctCardInfoByIccid(String iccid) throws Exception {

        Query query = null;
        log.info("getSctCardInfoByIccid , iccid ===>" + iccid);

        try {
            String sqlstr = "select s from EPAY_SCT_CARD s where '" +iccid +"' between s.iccid_start AND s.iccid_end";
            log.info(sqlstr);
            query = em.createQuery(sqlstr);

        } catch (Exception ex) {
            log.info(ex);
        }

        EPAY_SCT_CARD rtresult = new EPAY_SCT_CARD();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            log.info(ex);
        }
        return rtresult;
    }

    @Override
    public boolean insertSctCardInfo(EPAY_SCT_CARD sctcardinfo) throws Exception {
        boolean result = false;
        try {
            em.persist(sctcardinfo);
            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println(e);
        }
        return result;
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
    public List getSctCardInfoByAPN(String apn) throws Exception {
        List rtList = null;
        Query query = null;

        try {
            String sqlTxt = "select s from EPAY_SCT_CARD s where s.apn = '" + apn + "'";
            log.info(sqlTxt);
            query = em.createQuery(sqlTxt);

            rtList = (List<EPAY_SCT_CARD>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getSctCardInfoByAPN() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public List getSctCardInfo() throws Exception {
        List rtList = null;
        Query query = null;

        try {
            String sqlTxt = "select s from EPAY_SCT_CARD s";
            log.info(sqlTxt);
            query = em.createQuery(sqlTxt);

            rtList = (List<EPAY_SCT_CARD>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getSctCardInfoByAPN() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public EPAY_SCT_CARD getSctCardInfoById(int id) throws Exception {
        Query query = null;
        log.info("getSctCardInfoByIccid , id ===>" + id);

        try {
            String sqlstr = "select s from EPAY_SCT_CARD s where  s.id ="+id;
            query = em.createQuery(sqlstr);

        } catch (Exception ex) {
            log.info(ex);
        }

        EPAY_SCT_CARD rtresult = new EPAY_SCT_CARD();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            log.info(ex);
        }
        return rtresult;
    }

    @Override
    public boolean updateSCTCard(EPAY_SCT_CARD bean) throws Exception {
        log.debug("entering. updateSCTCard");

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



}
