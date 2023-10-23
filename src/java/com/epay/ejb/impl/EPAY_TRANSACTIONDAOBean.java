package com.epay.ejb.impl;

import com.epay.ejb.EPAY_TRANSACTIONDAO;
import com.epay.ejb.bean.EPAY_TRANSACTION;
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
 */
@Stateless
@Local({EPAY_TRANSACTIONDAO.class})
public class EPAY_TRANSACTIONDAOBean implements EPAY_TRANSACTIONDAO {

    private static Logger log = Logger.getLogger(EPAY_TRANSACTIONDAOBean.class);
    @PersistenceUnit
    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insertTransaction(EPAY_TRANSACTION bean) throws Exception {
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
    public boolean updateTransaction(EPAY_TRANSACTION bean) throws Exception {
        log.debug("entering. updateTransaction");

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
    public EPAY_TRANSACTION getTransaction(String libm) throws Exception {
        log.debug("entering. getTransaction");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_TRANSACTION t where t.libm ='" + libm + "'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_TRANSACTION rtresult = new EPAY_TRANSACTION();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public EPAY_TRANSACTION getTransactionByCPLibm(String libm) throws Exception {
        log.debug("entering. getTransaction");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_TRANSACTION t where t.cpLibm ='" + libm + "'");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_TRANSACTION rtresult = new EPAY_TRANSACTION();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public EPAY_TRANSACTION getTransactionLibmAndAuthDateNotNull(String libm) throws Exception {
        log.debug("entering. getTransaction");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_TRANSACTION t where t.libm ='" + libm + "' and t.authdate is not null");

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_TRANSACTION rtresult = new EPAY_TRANSACTION();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public void removeTransaction(String libm) throws Exception {
        log.debug("entering. removeTransaction");
        em.joinTransaction();
        log.debug("entering removeTransaction(" + libm + ")");
        EPAY_TRANSACTION transaction = em.find(EPAY_TRANSACTION.class, libm);
        em.remove(transaction);
        em.flush();
        em.clear();
    }

    @Override
    public List<EPAY_TRANSACTION> listTransactionByLibm(String libm) throws Exception {
        log.debug("entering. listTransactionByLibm");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EPAY_TRANSACTION> listTransactionByItemcode(String itemcode) throws Exception {
        log.debug("entering. listTransactionByItemcode");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EPAY_TRANSACTION> listTransactionByPayStatus(String payStatus) throws Exception {
        log.debug("entering. listTransactionByPayStatus");

        String jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.paystatus = '" + payStatus + "' and paymethod = '1' and status = 'Y' ";
        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public int sumTransactionByMoilePhone(String InvoiceContactMobilePhone) throws Exception {
        log.debug("entering. listTransactionByMoilePhone");

        Long total = 0L;

        String jpqlStr = "SELECT sum(e.ordertotal) FROM EPAY_TRANSACTION e WHERE e.InvoiceContactMobilePhone = '" + InvoiceContactMobilePhone + "' and MONTH(TRADEDATE) = MONTH(NOW()) and AUTHDATE IS NOT NULL";
        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        try {
            query = em.createQuery(jpqlStr);
            if (query.getSingleResult() != null) {
                total = (Long) query.getSingleResult();
            } else {
                total = (long) 0;
            }
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (total == null) {
            return 0;
        }
        System.out.println(" #### total = " + total);
        return total.intValue();
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
    public List<EPAY_TRANSACTION> getAllTransaction() throws Exception {

        List<EPAY_TRANSACTION> rltCaller = new ArrayList<EPAY_TRANSACTION>();
        Query query = null;
        try {
            query = em.createQuery("SELECT c FROM EPAY_TRANSACTION c ORDER BY c.libm");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                rltCaller.addAll(query.getResultList());
            }
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception e) {
            throw e;
        }
        return rltCaller;
    }

    @Override
    public List getTx_byMDN(String mdn) throws Exception {
        Query query = null;
        List rtList = null;
        String strSQL = null;
        try {
            strSQL = "select p from EPAY_TRANSACTION p  where p.InvoiceContactMobilePhone = '" + mdn + "' order by p.tradedate desc";
//            System.out.println(" ## SQL = " + strSQL);
            query = em.createQuery(strSQL);
//            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
//                 
//            }

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtList = query.getResultList();
        return rtList;
    }

    @Override
    public List getTx_byMDNAndCDate(String mdn, String cdate) throws Exception {
        Query query = null;
        List rtList = null;
        String strSQL = null;
        try {
            strSQL = "select p from EPAY_TRANSACTION p  where p.InvoiceContactMobilePhone = '" + mdn + "' and p.tradedate >= '" + cdate + "' order by p.tradedate desc";

            System.out.println(" ## SQL = " + strSQL);
            query = em.createQuery(strSQL);
//            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
//                 
//            }

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtList = query.getResultList();
        return rtList;
    }

    @Override
    public List getTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception {
        Query query = null;
        List rtList = null;
        String strSQL = null;
        try {
            strSQL = "select p from EPAY_TRANSACTION p  where p.tradedate between '" + startdatetime + "' and '" + enddatetime + "' order by p.tradedate desc";

            System.out.println(" ## SQL = " + strSQL);
            query = em.createQuery(strSQL);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {

            }

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtList = query.getResultList();
        return rtList;
    }

    @Override
    public List getTx_byMDNStartDateTimeAndEndtDateTime(String mdn, String startdatetime, String enddatetime) throws Exception {
        String jpqlStr;
        if ((mdn == null) || (mdn.equals(""))) {
            jpqlStr
                    = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                    + "' order by tradedate desc";
        } else {
            jpqlStr
                    = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                    + "' and e.InvoiceContactMobilePhone = '" + mdn + "'"
                    + " order by tradedate desc";
        }

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 14"
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByStatus(String startdatetime, String enddatetime, String status) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 14"
                + "  and e.status " + status
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByMdn(String startdatetime, String enddatetime, String mdn) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 14"
                + " and e.InvoiceContactMobilePhone ='" + mdn + "'"
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByMdnByStatus(String startdatetime, String enddatetime, String mdn, String status) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 14"
                + " and e.InvoiceContactMobilePhone ='" + mdn + "'"
                + " and e.status " + status
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getIboneTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 13 and e.apisrcid = 6"
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByStatus(String startdatetime, String enddatetime,String status) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 13 and e.apisrcid = 6"
                + "  and e.status " + status
                + "  order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByMdn(String startdatetime, String enddatetime, String mdn) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 13 and e.apisrcid = 6"
                + " and e.InvoiceContactMobilePhone = '" + mdn + "'"
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByMdnByStatus(String startdatetime, String enddatetime, String mdn, String status) throws Exception {
        String jpqlStr;

        jpqlStr
                = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                + "' and e.paytool = 13 and e.apisrcid = 6"
                + " and e.InvoiceContactMobilePhone = '" + mdn + "'"
                + " and e.status " + status
                + " order by tradedate desc";

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getTx_byMDNStartDateTimeAndEndtDateTimeaAndCPID(String mdn, String startdatetime, String enddatetime) throws Exception {
        String jpqlStr;
        if ((mdn == null) || (mdn.equals(""))) {
            jpqlStr
                    = "SELECT e.* , c.cpname FROM EPAY_TRANSACTION e,EPAY_CPINFO c WHERE e.cpid = c.cpid And e.tradedate between '" + startdatetime + "' and '" + enddatetime
                    + "' order by tradedate desc";
        } else {
            jpqlStr
                    = "SELECT e FROM EPAY_TRANSACTION e WHERE e.tradedate between '" + startdatetime + "' and '" + enddatetime
                    + "' and e.InvoiceContactMobilePhone = '" + mdn + "'"
                    + " order by tradedate desc";
        }

        System.out.println(" #### SQL = " + jpqlStr);
        Query query = null;
        List<EPAY_TRANSACTION> rtnTxList = new ArrayList<EPAY_TRANSACTION>();
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
    public List getTx_byPOSCode(String poscode) throws Exception {
        Query query = null;
        List rtList = null;
        String strSQL = null;
        try {
            strSQL = "select p from EPAY_TRANSACTION p  where p.poscode = '" + poscode + "' order by p.tradedate desc";
//            System.out.println(" ## SQL = " + strSQL);
            query = em.createQuery(strSQL);
//            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
//                 
//            }

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtList = query.getResultList();
        return rtList;
    }

    @Override
    public List<EPAY_TRANSACTION> listTransactionByBatchFile(String batchfile) throws Exception {
        Query query = null;
        List rtList;// = null;
        String strSQL;// = null;
        try {
            strSQL = "select p from EPAY_TRANSACTION p  where p.BATCHFILE = '" + batchfile + "' order by p.tradedate desc";
//            System.out.println(" ## SQL = " + strSQL);
            query = em.createQuery(strSQL);
//            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
//                 
//            }

        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtList = query.getResultList();
        return rtList;
    }

    @Override
    public List<EPAY_TRANSACTION> getDTOneQuotaByMdn(String mdn, String begindate, String enddate) throws Exception {

        String sql = "SELECT p FROM EPAY_TRANSACTION p "
                + " WHERE p.InvoiceContactMobilePhone = '" + mdn + "'"
                + " AND p.tradedate BETWEEN '" + begindate + "' AND '" + enddate + "'"
                + " AND p.paytool=14 and p.status ='00'";

        Query query = null;
        List rtList;// = null;

        try {
            log.info(sql);
            query = em.createQuery(sql);
        } catch (Exception ex) {
            log.info(ex);
        }
        rtList = query.getResultList();
        return rtList;
    }
}
