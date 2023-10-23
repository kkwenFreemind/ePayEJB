package com.epay.ejb.impl;

import com.epay.ejb.EPAY_INVOICEDAO;
import com.epay.ejb.bean.EPAY_INVOICE;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 */
@Stateless
@Local({EPAY_INVOICEDAO.class})
public class EPAY_INVOICEDAOBean implements EPAY_INVOICEDAO {

    private static Logger log = Logger.getLogger(EPAY_INVOICEDAOBean.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insertInvoice(EPAY_INVOICE bean) throws Exception {
        log.debug("entering. insertInvoice");

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
    public boolean updateInvoice(EPAY_INVOICE bean) throws Exception {
        log.debug("entering. updateInvoice");

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
    public EPAY_INVOICE getInvoice(Integer invoiceid) throws Exception {
        log.debug("entering. getInvoice");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_INVOICE t where t.invoiceid =" + invoiceid);

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_INVOICE rtresult = new EPAY_INVOICE();
        boolean getresult = false;
        try {
            getresult = query.getSingleResult() != null;
        } catch (Exception ex) {
            throw ex;
        }
        if (getresult) {
            rtresult = (EPAY_INVOICE) query.getSingleResult();
        } else {
            rtresult = null;
        }
        return rtresult;
    }

    @Override
    public void removeInvoice(Integer invoiceid) throws Exception {
        log.debug("entering. removeInvoice");
        em.joinTransaction();
        log.debug("entering removeInvoice(" + invoiceid + ")");
        EPAY_INVOICE invoice = em.find(EPAY_INVOICE.class, invoiceid);
        em.remove(invoice);
        em.flush();
        em.clear();
    }

    @Override
    public EPAY_INVOICE getlistInvoiceByInvoicenoLibm(String libm) throws Exception {
//        log.info("entering. getlistInvoiceByInvoiceidLibm");
        Query query = null;
        EPAY_INVOICE rtresult = null;

        try {
//            query = em.createQuery("select p from EPAY_INVOICE p where p.invoice_no='" + invoiceno + "' and p.libm='" + libm + "'");
            String tmpstr = "select p from EPAY_INVOICE p where p.libm='" + libm + "'";
            query = em.createQuery(tmpstr);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                rtresult = new EPAY_INVOICE();
                rtresult = (EPAY_INVOICE) query.getResultList().get(0);
            }
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public List<EPAY_INVOICE> getlistInvoiceByInvoiceno(String inviceno) throws Exception {
        log.debug("entering. listInvoiceByItemcode");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static <T> T getSingleResult(Query query) {
        query.setMaxResults(1);
        List<?> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

}
