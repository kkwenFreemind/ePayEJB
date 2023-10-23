package com.epay.ejb.impl;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.epay.ejb.EPAY_DTONESERVICE_INFODAO;
import com.epay.ejb.bean.EPAY_DTONESERVICE_INFO;
import com.epay.ejb.bean.EPAY_SERVICE_INFO;
//import com.epay.ejb.bean.EPAY_TRANSACTION;
import com.epay.ejb.exception.DataNotFound;
import java.util.ArrayList;
import javax.persistence.NoResultException;

/**
 *
 * @author Booker Hsu
 */
@Stateless
@Local({EPAY_DTONESERVICE_INFODAO.class})
public class EPAY_DTONESERVICE_INFODAOBean implements EPAY_DTONESERVICE_INFODAO {

    private static Logger log = Logger.getLogger(EPAY_DTONESERVICE_INFODAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EPAY_DTONESERVICE_INFO> getDTOneServiceInfo(Integer cpid, String promotioncode, int platformtype, String operatorname) throws Exception {
        Query query = null;
        List<EPAY_DTONESERVICE_INFO> rtList = new ArrayList<EPAY_DTONESERVICE_INFO>();

        try {
            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO s where s.cpId = " + cpid + " and s.operator_name ='" + operatorname + "' and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='家鄉儲' and s.platformtype =" + platformtype);

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            rtList.addAll(query.getResultList());
        }
        return rtList;
    }

    @Override
    public EPAY_DTONESERVICE_INFO getDtonServiceInfoById(Long serviceid, Integer cid) throws Exception {
        List<EPAY_DTONESERVICE_INFO> rtList = null;
        Query query = null;

        try {
            log.info("serviceid , cpid ===>" + serviceid + "," + cid);
            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO  s where s.serviceId = " + serviceid + " AND s.cpId = " + cid + " and flag = 1");

            rtList = (List<EPAY_DTONESERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getDtonServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }
    
    @Override
    public EPAY_DTONESERVICE_INFO getDtonServiceInfoByIdOnly(Long serviceid, Integer cid) throws Exception {
        List<EPAY_DTONESERVICE_INFO> rtList = null;
        Query query = null;

        try {
            log.info("serviceid , cpid ===>" + serviceid + "," + cid);
            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO  s where s.serviceId = " + serviceid + " AND s.cpId = " + cid);

            rtList = (List<EPAY_DTONESERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getDtonServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }    

    @Override
    public boolean insertDTOneServiceinfo(EPAY_DTONESERVICE_INFO serviceinfo) throws Exception {
        boolean result = false;
        try {
            em.persist(serviceinfo);
            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List getDTOneServiceInfo() throws Exception {
        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO s ");
            rtList = (List<EPAY_DTONESERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getDTOneServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public List getDTOneServiceInfoBySid(long sid) throws Exception {
        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO s where s.serviceId=" + sid + " and flag = 1");
            rtList = (List<EPAY_DTONESERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getDTOneServiceInfoBySid() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public boolean updateDTOneServiceInfo(EPAY_DTONESERVICE_INFO serviceinfo) throws Exception {
        boolean result = false;

        try {
            em.merge(serviceinfo);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }

    @Override
    public List getDTOneServiceInfoBySidOnly(long sid) throws Exception {
        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_DTONESERVICE_INFO s where s.serviceId=" + sid );
            rtList = (List<EPAY_DTONESERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getDTOneServiceInfoBySid() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

}
