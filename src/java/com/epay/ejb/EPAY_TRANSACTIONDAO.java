package com.epay.ejb;

import java.util.List;

import com.epay.ejb.bean.EPAY_TRANSACTION;

public interface EPAY_TRANSACTIONDAO {

    public boolean insertTransaction(EPAY_TRANSACTION bean) throws Exception;

    public boolean updateTransaction(EPAY_TRANSACTION bean) throws Exception;

    public EPAY_TRANSACTION getTransaction(String libm) throws Exception;

    public EPAY_TRANSACTION getTransactionByCPLibm(String libm) throws Exception;

    public EPAY_TRANSACTION getTransactionLibmAndAuthDateNotNull(String libm) throws Exception;

    public void removeTransaction(String libm) throws Exception;

    public List<EPAY_TRANSACTION> listTransactionByLibm(String libm) throws Exception;

    public List<EPAY_TRANSACTION> listTransactionByItemcode(String itemcode) throws Exception;

    public List<EPAY_TRANSACTION> listTransactionByPayStatus(String payStatus) throws Exception;

    public int sumTransactionByMoilePhone(String InvoiceContactMobilePhone) throws Exception;

    public List<EPAY_TRANSACTION> getAllTransaction() throws Exception;

    public List getTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception;

    public List getTx_byMDNStartDateTimeAndEndtDateTime(String mdn, String startdatetime, String enddatetime) throws Exception;

    public List getIboneTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception;
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByStatus(String startdatetime, String enddatetime,String status) throws Exception;
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByMdn(String startdatetime, String enddatetime,String mdn) throws Exception;
    public List getIboneTx_byStartDateTimeAndEndtDateTimeByMdnByStatus(String startdatetime, String enddatetime,String mdn,String status) throws Exception;

    public List getCountryCodeTx_byStartDateTimeAndEndtDateTime(String startdatetime, String enddatetime) throws Exception;
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByStatus(String startdatetime, String enddatetime,String status) throws Exception;
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByMdn(String startdatetime, String enddatetime,String mdn) throws Exception;
    public List getCountryCodeTx_byStartDateTimeAndEndtDateTimeByMdnByStatus(String startdatetime, String enddatetime,String mdn,String status) throws Exception;

    public List getTx_byMDNStartDateTimeAndEndtDateTimeaAndCPID(String mdn, String startdatetime, String enddatetime) throws Exception;

    public List getTx_byMDN(String mdn) throws Exception;

    public List getTx_byMDNAndCDate(String mdn, String cdate) throws Exception;

    public List getTx_byPOSCode(String poscode) throws Exception;

    public List<EPAY_TRANSACTION> listTransactionByBatchFile(String batchfile) throws Exception;

    public List<EPAY_TRANSACTION> getDTOneQuotaByMdn(String mdn,String begindate,String enddate) throws Exception;
}
