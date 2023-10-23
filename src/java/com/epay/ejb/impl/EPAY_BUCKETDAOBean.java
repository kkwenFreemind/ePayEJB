package com.epay.ejb.impl;

import com.epay.ejb.EPAY_BUCKETDAO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

//import com.epay.ejb.EPAY_SERVICE_INFODAO;
import com.epay.ejb.bean.EPAY_BUCKET;
//import com.epay.ejb.bean.EPAY_SERVICE_INFO;
import com.epay.ejb.exception.DataNotFound;

/**
 *
 * @author Booker Hsu
 */
@Stateless
@Local({EPAY_BUCKETDAO.class})
public class EPAY_BUCKETDAOBean implements EPAY_BUCKETDAO {

    private static Logger log = Logger.getLogger(EPAY_BUCKETDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List getAllBucketInfo(String sid) throws Exception {

        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_BUCKET s where s.serviceId = " + sid + "ORDER BY serviceId");
            rtList = (List<EPAY_BUCKET>) query.getResultList();
            System.out.println("RTLIST===>" + rtList);
            System.out.println("SQL===>" + "select s from EPAY_BUCKET s where s.serviceId = " + sid + " ORDER BY serviceId");
            if (rtList == null || rtList.isEmpty()) {

                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            log.info(ex);
        }
        return rtList;
    }

    @Override
    public EPAY_BUCKET getAllBucketInfoByBid(String sid, String bid) throws Exception {

        List<EPAY_BUCKET> rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_BUCKET s where s.serviceId = " + sid + " and s.bucketId = " + bid);
            rtList = (List<EPAY_BUCKET>) query.getResultList();
            System.out.println("RTLIST===>" + rtList);
            System.out.println("SQL===>" + "select s from EPAY_BUCKET s where s.serviceId = " + sid + " ORDER BY serviceid,bucketid");
            if (rtList == null || rtList.isEmpty()) {

                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }

    @Override
    public EPAY_BUCKET getBucketByRID(int rid) throws Exception {

        List<EPAY_BUCKET> rtList = null;
        Query query = null;
        try {
            query = em.createQuery("select s from EPAY_BUCKET s where s.id = " + rid + "ORDER BY serviceid,bucketid");
            log.info("select s from EPAY_BUCKET s where s.id = " + rid + " ORDER BY serviceid,bucketid");
            rtList = (List<EPAY_BUCKET>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }

    @Override
    public boolean insertBucket(EPAY_BUCKET bucket) throws Exception {
        boolean result = false;
        try {
            em.persist(bucket);
            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println(e);
        }
        return result;
    }

    public boolean updateBucket(EPAY_BUCKET bucketinfo) throws Exception {
        boolean result = false;
        try {
            em.merge(bucketinfo);
            result = true;
        } catch (Exception e) {
            System.out.println(e);
            result = false;
        }
        return result;
    }

    @Override
    public List ListAllBucketInfo() throws Exception {

        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_BUCKET s ORDER BY serviceid,bucketid");
            rtList = (List<EPAY_BUCKET>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }
}
