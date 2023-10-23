package com.epay.ejb.impl;

import com.epay.ejb.EPAY_INVOICE_ITEMDAO;
import com.epay.ejb.bean.EPAY_INVOICE_ITEM;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 */
@Stateless
@Local({EPAY_INVOICE_ITEMDAO.class})
public class EPAY_INVOICE_ITEMDAOBean implements EPAY_INVOICE_ITEMDAO {
    
    private static Logger log = Logger.getLogger(EPAY_INVOICE_ITEMDAOBean.class);

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public boolean insertInvoice_Item(EPAY_INVOICE_ITEM bean) throws Exception {
        log.debug("entering. insertInvoice_Item");

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
    public boolean updateInvoice_Item(EPAY_INVOICE_ITEM bean) throws Exception {
        log.debug("entering. updateInvoice_Item");

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
    public EPAY_INVOICE_ITEM getInvoice_Item(Integer invoiceid) throws Exception {
         log.debug("entering. getInvoice_Item");
        Query query = null;
        try {
            query = em.createQuery("select t from EPAY_INVOICE_ITEM t where t.invoiceid =" + invoiceid);

        } catch (Exception ex) {
            throw ex;
        }

        EPAY_INVOICE_ITEM rtresult = new EPAY_INVOICE_ITEM();
        try {
            rtresult = getSingleResult(query);
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public void removeInvoice_Item(Integer invoiceid) throws Exception {
        log.debug("entering. removeInvoice_Item");
        em.joinTransaction();
        log.debug("entering removeInvoice_Item(" + invoiceid + ")");
        EPAY_INVOICE_ITEM invoice_item = em.find(EPAY_INVOICE_ITEM.class, invoiceid);
        em.remove(invoice_item);
        em.flush();
        em.clear();
    }

    @Override
    public List<EPAY_INVOICE_ITEM> listInvoiceItemByInvoiceidNo(Integer invoiceid, String no) throws Exception {
        log.debug("entering. listInvoice_ItemByLibm");
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
