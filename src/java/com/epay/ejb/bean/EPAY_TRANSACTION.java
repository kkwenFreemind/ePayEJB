package com.epay.ejb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.GeneratedValue;

@Entity
@Table(name = "TRANSACTION")
public class EPAY_TRANSACTION implements Serializable {

//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//    private static final long serialVersionUID = -1637146516433L;
    @Id
    @Column(length = 15, nullable = false, columnDefinition = "訂單編號")
    private String libm;

    @Column(length = 8, nullable = true, columnDefinition = "商品代碼")
    private String itemcode;

    @Column(length = 200, nullable = true, columnDefinition = "商品細項品名")
    private String itemproductname;

    @Column(length = 6, precision = 0, nullable = true, columnDefinition = "商品單價")
    private Integer itemunitprice;

    @Column(length = 4, precision = 0, nullable = true, columnDefinition = "商品數量")
    private Integer itemquantity;

    @Column(length = 4, precision = 0, nullable = true, columnDefinition = "手續費")
    private Integer fee;

    @Column(length = 4, precision = 0, nullable = true, columnDefinition = "折讓金額")
    private Integer discount;

    @Column(length = 8, precision = 0, nullable = true, columnDefinition = "訂單總金額")
    private Integer ordertotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "交易日期")
    private Date tradedate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "付款時間")
    private Date paytime;

    @Column(length = 1, precision = 0, nullable = true, columnDefinition = "付款方式 信用卡:0 ATM:1")
    private Integer paymethod;

    @Column(length = 1, precision = 0, nullable = true, columnDefinition = "繳款狀態 失敗:0 成功:1")
    private Integer paystatus;

    @Column(length = 8, precision = 0, nullable = true, columnDefinition = "實際繳款金額")
    private Integer payamount;

    @Column(length = 2, columnDefinition = "信用卡授權狀態")
    private String status;

    @Column(length = 5, columnDefinition = "錯誤代碼")
    private String errcode;

    @Column(length = 100, columnDefinition = "失敗原因")
    private String errdesc;

    @Column(length = 1, columnDefinition = "分期手續費計價方式 E:手續費外加,I:手續費內含")
    private String installtype;

    @Column(length = 2, precision = 0, columnDefinition = "信用卡分期期數")
    private Integer install;

    @Column(length = 8, precision = 0, columnDefinition = "首期金額")
    private Integer firstamt;

    @Column(length = 8, precision = 0, columnDefinition = "每期金額")
    private Integer eachamt;

    @Column(length = 8, precision = 0, columnDefinition = "分期交易手續費")
    private Integer installfee;

    @Column(length = 200, columnDefinition = "商店的自訂資料")
    private String privatedata;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "信用卡授權日期")
    private Date authdate;

    @Column(columnDefinition = "合約編號")
    private Integer ct_id;

    @Column(length = 10, columnDefinition = "業務工號")
    private String sales_id;

    @Column(length = 30, columnDefinition = "業務姓名")
    private String sales_name;

    @Column(length = 20)
    private String departmentid;

    @Column(length = 20)
    private String departmentname;

    @Column(length = 10)
    private String serviceId;

    @Column(nullable = false, columnDefinition = "CP訂單編號")
    private String cpLibm;

    @Column(nullable = false, columnDefinition = "CPID")
    private Integer cpId;
    private String cpName;

    @Column(nullable = false, columnDefinition = "FEETYPE")
    private String feeType;

    private String InvoiceContactMobilePhone;

    @Column(nullable = false, columnDefinition = "CONTRACTID")
    private String ContractID;

    private String poscode;
    private String possaleid;
    private int platformtype;
    private String bankid;
    private String atmaccount;

    private String storeid;
    private String storename;
    private String apisrcid;
    private String paytool;
    private String payname;
    private String loginmdn;
    private String BATCHFILE;
    private String countrycodemdn;
    private String operatiorname;
    private String priceid;
    private String countrycodenote;
    private String dtoneid;
    private String dtone_electricitybill;
    private String dtone_code;
    private String dtone_date;
    private Double dtone_prices;

    public String getDtone_code() {
        return dtone_code;
    }

    public void setDtone_code(String dtone_code) {
        this.dtone_code = dtone_code;
    }

    public String getDtone_date() {
        return dtone_date;
    }

    public void setDtone_date(String dtone_date) {
        this.dtone_date = dtone_date;
    }

    public String getDtone_electricitybill() {
        return dtone_electricitybill;
    }

    public void setDtone_electricitybill(String dtone_electricitybill) {
        this.dtone_electricitybill = dtone_electricitybill;
    }

    public String getDtoneid() {
        return dtoneid;
    }

    public void setDtoneid(String dtoneid) {
        this.dtoneid = dtoneid;
    }

    public String getCountrycodemdn() {
        return countrycodemdn;
    }

    public void setCountrycodemdn(String countrycodemdn) {
        this.countrycodemdn = countrycodemdn;
    }

    public String getOperatiorname() {
        return operatiorname;
    }

    public void setOperatiorname(String operatiorname) {
        this.operatiorname = operatiorname;
    }

    public String getPriceid() {
        return priceid;
    }

    public void setPriceid(String priceid) {
        this.priceid = priceid;
    }

    public String getCountrycodenote() {
        return countrycodenote;
    }

    public void setCountrycodenote(String countrycodenote) {
        this.countrycodenote = countrycodenote;
    }

    public String getBATCHFILE() {
        return BATCHFILE;
    }

    public void setBATCHFILE(String BATCHFILE) {
        this.BATCHFILE = BATCHFILE;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getAtmaccount() {
        return atmaccount;
    }

    public void setAtmaccount(String atmaccount) {
        this.atmaccount = atmaccount;
    }

    public int getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(int platformtype) {
        this.platformtype = platformtype;
    }

    public String getPoscode() {
        return poscode;
    }

    public void setPoscode(String poscode) {
        this.poscode = poscode;
    }

    public String getPossaleid() {
        return possaleid;
    }

    public void setPossaleid(String possaleid) {
        this.possaleid = possaleid;
    }

    public EPAY_TRANSACTION() {
        super();
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getCpLibm() {
        return cpLibm;
    }

    public void setCpLibm(String cpLibm) {
        this.cpLibm = cpLibm;
    }

    /**
     * @return the libm
     */
    public String getLibm() {
        return libm;
    }

    /**
     * @param libm the libm to set
     */
    public void setLibm(String libm) {
        this.libm = libm;
    }

    /**
     * @return the itemcode
     */
    public String getItemcode() {
        return itemcode;
    }

    /**
     * @param itemcode the itemcode to set
     */
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    /**
     * @return the itemproductname
     */
    public String getItemproductname() {
        return itemproductname;
    }

    /**
     * @param itemproductname the itemproductname to set
     */
    public void setItemproductname(String itemproductname) {
        this.itemproductname = itemproductname;
    }

    /**
     * @return the itemunitprice
     */
    public Integer getItemunitprice() {
        return itemunitprice;
    }

    /**
     * @param itemunitprice the itemunitprice to set
     */
    public void setItemunitprice(Integer itemunitprice) {
        this.itemunitprice = itemunitprice;
    }

    /**
     * @return the itemquantity
     */
    public Integer getItemquantity() {
        return itemquantity;
    }

    /**
     * @param itemquantity the itemquantity to set
     */
    public void setItemquantity(Integer itemquantity) {
        this.itemquantity = itemquantity;
    }

    /**
     * @return the fee
     */
    public Integer getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    /**
     * @return the discount
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return the ordertotal
     */
    public Integer getOrdertotal() {
        return ordertotal;
    }

    /**
     * @param ordertotal the ordertotal to set
     */
    public void setOrdertotal(Integer ordertotal) {
        this.ordertotal = ordertotal;
    }

    /**
     * @return the tradedate
     */
    public Date getTradedate() {
        return tradedate;
    }

    /**
     * @param tradedate the tradedate to set
     */
    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    /**
     * @return the paytime
     */
    public Date getPaytime() {
        return paytime;
    }

    /**
     * @param paytime the paytime to set
     */
    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    /**
     * @return the paymethod
     */
    public Integer getPaymethod() {
        return paymethod;
    }

    /**
     * @param paymethod the paymethod to set
     */
    public void setPaymethod(Integer paymethod) {
        this.paymethod = paymethod;
    }

    /**
     * @return the paystatus
     */
    public Integer getPaystatus() {
        return paystatus;
    }

    /**
     * @param paystatus the paystatus to set
     */
    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    /**
     * @return the payamount
     */
    public Integer getPayamount() {
        return payamount;
    }

    /**
     * @param payamount the payamount to set
     */
    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the errorcode
     */
    public String getErrcode() {
        return errcode;
    }

    /**
     * @param errcode the errcode to set
     */
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    /**
     * @return the errdesc
     */
    public String getErrdesc() {
        return errdesc;
    }

    /**
     * @param errdesc the errdesc to set
     */
    public void setErrdesc(String errdesc) {
        this.errdesc = errdesc;
    }

    /**
     * @return the installtype
     */
    public String getInstalltype() {
        return installtype;
    }

    /**
     * @param installtype the installtype to set
     */
    public void setInstalltype(String installtype) {
        this.installtype = installtype;
    }

    /**
     * @return the install
     */
    public Integer getInstall() {
        return install;
    }

    /**
     * @param install the install to set
     */
    public void setInstall(Integer install) {
        this.install = install;
    }

    /**
     * @return the firstamt
     */
    public Integer getFirstamt() {
        return firstamt;
    }

    /**
     * @param firstamt the firstamt to set
     */
    public void setFirstamt(Integer firstamt) {
        this.firstamt = firstamt;
    }

    /**
     * @return the eachamt
     */
    public Integer getEachamt() {
        return eachamt;
    }

    /**
     * @param eachamt the eachamt to set
     */
    public void setEachamt(Integer eachamt) {
        this.eachamt = eachamt;
    }

    /**
     * @return the installfee
     */
    public Integer getInstallfee() {
        return installfee;
    }

    /**
     * @param installfee the installfee to set
     */
    public void setInstallfee(Integer installfee) {
        this.installfee = installfee;
    }

    /**
     * @return the privatedata
     */
    public String getPrivatedata() {
        return privatedata;
    }

    /**
     * @param privatedata the privatedata to set
     */
    public void setPrivatedata(String privatedata) {
        this.privatedata = privatedata;
    }

    /**
     * @return the authdate
     */
    public Date getAuthdate() {
        return authdate;
    }

    /**
     * @param authdate the authdate to set
     */
    public void setAuthdate(Date authdate) {
        this.authdate = authdate;
    }

    /**
     * @return the ct_id
     */
    public Integer getCt_id() {
        return ct_id;
    }

    /**
     * @param ct_id the ct_id to set
     */
    public void setCt_id(Integer ct_id) {
        this.ct_id = ct_id;
    }

    /**
     * @return the sales_id
     */
    public String getSales_id() {
        return sales_id;
    }

    /**
     * @param sales_id the sales_id to set
     */
    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
    }

    /**
     * @return the sales_name
     */
    public String getSales_name() {
        return sales_name;
    }

    /**
     * @param sales_name the sales_name to set
     */
    public void setSales_name(String sales_name) {
        this.sales_name = sales_name;
    }

    /**
     * @return the departmentid
     */
    public String getDepartmentid() {
        return departmentid;
    }

    /**
     * @return the departmentname
     */
    public String getDepartmentname() {
        return departmentname;
    }

    /**
     * @param departmentid the departmentid to set
     */
    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * @param departmentname the departmentname to set
     */
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getInvoiceContactMobilePhone() {
        return InvoiceContactMobilePhone;
    }

    public void setInvoiceContactMobilePhone(String InvoiceContactMobilePhone) {
        this.InvoiceContactMobilePhone = InvoiceContactMobilePhone;
    }

    public String getContractID() {
        return ContractID;
    }

    public void setContractID(String ContractID) {
        this.ContractID = ContractID;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getApisrcid() {
        return apisrcid;
    }

    public void setApisrcid(String apisrcid) {
        this.apisrcid = apisrcid;
    }

    public String getPaytool() {
        return paytool;
    }

    public void setPaytool(String paytool) {
        this.paytool = paytool;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getLoginmdn() {
        return loginmdn;
    }

    public void setLoginmdn(String loginmdn) {
        this.loginmdn = loginmdn;
    }

    public Double getDtone_prices() {
        return dtone_prices;
    }

    public void setDtone_prices(Double dtone_prices) {
        this.dtone_prices = dtone_prices;
    }


    
    
}
