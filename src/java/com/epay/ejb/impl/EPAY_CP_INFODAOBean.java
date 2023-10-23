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
import com.epay.ejb.EPAY_CP_INFODAO;
import com.epay.ejb.bean.EPAY_CP_INFO;
import com.epay.ejb.exception.DataNotFound;
import static com.epay.ejb.impl.EPAY_TRANSACTIONDAOBean.getSingleResult;

/**
 *
 */
@Stateless
@Local({EPAY_CP_INFODAO.class})
public class EPAY_CP_INFODAOBean implements EPAY_CP_INFODAO {

    private static Logger log = Logger.getLogger(EPAY_CP_INFODAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public EPAY_CP_INFO getCpInfoTxType(Integer cpid) throws Exception {
        EPAY_CP_INFO rtCpInfo = null;
        Query query = null;

        try {

            query = em.createQuery("SELECT c FROM EPAY_CP_INFO c LEFT JOIN c.txTypes t WHERE c.cpId = " + cpid + " AND c.status = '1' AND t.status = '1'");
            if (query.getSingleResult() == null) {
                throw new DataNotFound("getCpInfoTxType() DataNotFound");
            }
            rtCpInfo = new EPAY_CP_INFO();
            rtCpInfo = (EPAY_CP_INFO) query.getSingleResult();
            if (rtCpInfo == null) {
                throw new DataNotFound("getCpInfoTxType() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtCpInfo;
    }

    @Override
    public List<EPAY_CP_INFO> getAllCpInfo() throws Exception {

        List<EPAY_CP_INFO> rtCpInfo = new ArrayList<EPAY_CP_INFO>();
        Query query = null;
        try {
            query = em.createQuery("SELECT c FROM EPAY_CP_INFO c LEFT JOIN c.txTypes t WHERE c.status = '1' AND t.status = '1'");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                rtCpInfo.addAll(query.getResultList());
            }
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception e) {
            throw e;
        }
        return rtCpInfo;
    }

    @Override
    public EPAY_CP_INFO getCpInfo(Integer cpid) throws Exception {
//        EPAY_CP_INFO rtCpInfo = null;
        Query query = null;

        try {
            query = em.createQuery("SELECT c FROM EPAY_CP_INFO c  WHERE c.cpId = " + cpid + " AND c.status = '1' ");
        } catch (Exception ex) {
            throw ex;
        }

        EPAY_CP_INFO rtresult = new EPAY_CP_INFO();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
//        try {
//
//            query = em.createQuery("SELECT c FROM EPAY_CP_INFO c  WHERE c.cpId = " + cpid + " AND c.status = '1' ");
//            if (query.getSingleResult() == null) {
//                throw new DataNotFound("getCpInfo DataNotFound");
//            }
//
//            rtCpInfo = new EPAY_CP_INFO();
//            rtCpInfo = (EPAY_CP_INFO) query.getSingleResult();
//            if (rtCpInfo == null) {
//                throw new DataNotFound("getCpInfo DataNotFound");
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return rtCpInfo;
    }

}
