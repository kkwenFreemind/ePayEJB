package com.epay.ejb.impl;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.epay.ejb.EPAY_SERVICE_INFODAO;
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
@Local({EPAY_SERVICE_INFODAO.class})
public class EPAY_SERVICE_INFODAOBean implements EPAY_SERVICE_INFODAO {

    private static Logger log = Logger.getLogger(EPAY_SERVICE_INFODAOBean.class);
    //private static final Logger log = Logger.getLogger("EPAY");

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EPAY_SERVICE_INFO> getAllServiceInfo(Integer cid, String promotioncode, int platformtype) throws Exception {
//        List rtList = null;
        Query query = null;
        List<EPAY_SERVICE_INFO> rtList = new ArrayList<EPAY_SERVICE_INFO>();

        try {
//            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.status in ('" + atype + "','3') and flag = 1");
//            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='L45000' and s.platformtype =" + platformtype);
            String sqltext = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='L45000' and s.platformtype =" + platformtype;
            log.info("====>" + sqltext);
            query = em.createQuery(sqltext);

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
    public List getServiceInfo() throws Exception {
        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_SERVICE_INFO s ");
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    @Override
    public List getAdjustAccServiceInfo(Integer cid, String promotioncode, String xcode, int platformtype) throws Exception {
        List rtList = null;
        Query query = null;

        try {
            String sqlTxt = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.platformtype =" + platformtype + " and flag = 1 and s.promotioncode like '%" + promotioncode + "%' and s.glcode='" + xcode + "'";
            //String sqlTxt = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid +  " and flag = 1 and s.promotioncode like '%" + promotioncode + "%' and s.glcode='" + xcode + "'";
            log.info(sqlTxt);
            query = em.createQuery(sqlTxt);

            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getAdjustAccServiceInfo() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }
    
   @Override
    public List getAdjustAccNokiaServiceInfo(Integer cid, String promotioncode, String xcode, int platformtype) throws Exception {
        List rtList = null;
        Query query = null;

        try {
            //String sqlTxt = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.platformtype =" + platformtype + " and flag = 1 and s.promotioncode like '%" + promotioncode + "%' and s.glcode='" + xcode + "'";
            String sqlTxt = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid +  " and flag = 1 and s.promotioncode like '%" + promotioncode + "%' and s.glcode='" + xcode + "'";
            log.info(sqlTxt);
            query = em.createQuery(sqlTxt);

            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getAdjustAccServiceInfo() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }    

    @Override
    public EPAY_SERVICE_INFO getServiceInfoById_Noflag(Long serviceid, Integer cid) throws Exception {
        List<EPAY_SERVICE_INFO> rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_SERVICE_INFO  s JOIN s.caller where s.serviceId = " + serviceid + " AND s.cpId = " + cid);
            log.info("serviceid , cpid ===>" + serviceid + "," + cid);
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }

    @Override
    public EPAY_SERVICE_INFO getServiceInfoById(Long serviceid, Integer cid) throws Exception {
        List<EPAY_SERVICE_INFO> rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_SERVICE_INFO  s JOIN s.caller where s.serviceId = " + serviceid + " AND s.cpId = " + cid + " and flag = 1");
            log.info("serviceid , cpid ===>" + serviceid + "," + cid);
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }

    @Override
    public boolean insertServiceinfo(EPAY_SERVICE_INFO serviceinfo) throws Exception {
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
    public List getServiceInfoBySid(long sid) throws Exception {
        List rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.serviceId=" + sid + " and flag = 1");
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rtList;
    }

    public boolean updateServiceInfo(EPAY_SERVICE_INFO serviceinfo) throws Exception {
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
    public EPAY_SERVICE_INFO getServiceInfoByCpidAndServiceId(Long serviceid, Integer cid) throws Exception {
        List<EPAY_SERVICE_INFO> rtList = null;
        Query query = null;

        try {
            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.serviceId = " + serviceid + " AND s.cpId = " + cid + " and s.flag = 1");
            log.info("serviceid , cpid ===>" + serviceid + "," + cid);
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoById() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));
    }

    @Override
    public List<EPAY_SERVICE_INFO> getAllServiceInfoByPromotionCode(Integer cpid, String promotioncode, String contractstatuscode, String lifecyclestatus) throws Exception {
        Query query = null;
        List<EPAY_SERVICE_INFO> rtList = new ArrayList<EPAY_SERVICE_INFO>();
        String sqlstat = "select s from EPAY_SERVICE_INFO s,EPAY_VCARDTYPE v where s.cardtype=v.cardtype and v.quantity > 0 and s.cpId = " + cpid + " and promotioncode like '%" + promotioncode + "%' and cmsstatus like '%" + contractstatuscode + "%' and ocsstatus like '%" + lifecyclestatus + "%' and flag = 1";
        log.info("sqlstat==>" + sqlstat);
        try {
            query = em.createQuery(sqlstat);
//            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cpid + " and promotioncode like '%"+promotioncode+"%' and cmsstatus like '%"+contractstatuscode+"%' and ocsstatus like '%"+lifecyclestatus+"%' and flag = 1");
//            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
//            if (rtList == null || rtList.isEmpty()) {
//                throw new DataNotFound("getServiceInfoById() DataNotFound");
//            }
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
    public EPAY_SERVICE_INFO getServiceInfoByPricePlanCode(String priceplancode) throws Exception {
        List<EPAY_SERVICE_INFO> rtList = null;
        Query query = null;

        try {

            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.priceplancode = '" + priceplancode + "'");
            log.info("priceplancode ===>" + priceplancode);
            rtList = (List<EPAY_SERVICE_INFO>) query.getResultList();
            if (rtList == null || rtList.isEmpty()) {
                throw new DataNotFound("getServiceInfoByPricePlanCode() DataNotFound");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return (rtList == null || rtList.isEmpty() ? null : rtList.get(0));

    }

    @Override
    public List<EPAY_SERVICE_INFO> getDTOneServiceInfo(Integer cpid, String promotioncode, int platformtype, String operatorname) throws Exception {
        Query query = null;
        List<EPAY_SERVICE_INFO> rtList = new ArrayList<EPAY_SERVICE_INFO>();

        try {
            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cpid + " and s.operator_name ='" + operatorname + "' and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='DTONE' and s.platformtype =" + platformtype);

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
    public List<EPAY_SERVICE_INFO> getNokiaServiceInfo(Integer cid, String promotioncode, int platformtype) throws Exception {
        Query query = null;
        List<EPAY_SERVICE_INFO> rtList = new ArrayList<EPAY_SERVICE_INFO>();

        try {
//            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.status in ('" + atype + "','3') and flag = 1");
//            query = em.createQuery("select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='L45000' and s.platformtype =" + platformtype);
            String sqltext = "select s from EPAY_SERVICE_INFO s where s.cpId = " + cid + " and s.promotioncode like '%" + promotioncode + "%' and s.flag = 1 and s.glcode ='L45000' ";
            log.info("====>" + sqltext);
            query = em.createQuery(sqltext);

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

}
