package com.epay.ejb;

import java.util.List;

import com.epay.ejb.bean.EPAY_INVOICE_ITEM;

public interface EPAY_INVOICE_ITEMDAO {

	public boolean insertInvoice_Item(EPAY_INVOICE_ITEM bean) throws Exception;

	public boolean updateInvoice_Item(EPAY_INVOICE_ITEM bean) throws Exception;

	public EPAY_INVOICE_ITEM getInvoice_Item(Integer invoiceid) throws Exception;

	public void removeInvoice_Item(Integer invoiceid) throws Exception;

	public List<EPAY_INVOICE_ITEM> listInvoiceItemByInvoiceidNo(Integer invoiceid, String no) throws Exception;


}
