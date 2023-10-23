package com.epay.ejb;

import com.epay.ejb.bean.EPAY_INVOICE;
import java.util.List;


public interface EPAY_INVOICEDAO {

	public boolean insertInvoice(EPAY_INVOICE bean) throws Exception;

	public boolean updateInvoice(EPAY_INVOICE bean) throws Exception;

	public EPAY_INVOICE getInvoice(Integer invoiceid) throws Exception;

	public void removeInvoice(Integer invoiceid) throws Exception;

	public EPAY_INVOICE getlistInvoiceByInvoicenoLibm(String libm) throws Exception;

	public List<EPAY_INVOICE> getlistInvoiceByInvoiceno(String inviceno)throws Exception;

}
