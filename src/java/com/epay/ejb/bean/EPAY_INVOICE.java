package com.epay.ejb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INVOICE")
public class EPAY_INVOICE implements Serializable {
    
//    private static final long serialVersionUID = -67108864L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="INVOICEID",length = 10, precision = 0, nullable = false, columnDefinition = "發票ID")
    private Integer invoiceid;

    @Column(name="LIBM",length = 15, nullable = false, columnDefinition = "訂單編號")
    private String libm;

    @Column(name="STATUS",length = 1, columnDefinition = "交易結果 成功：Y、失敗：N")
    private String status;

    @Column(name="DISCOUNT_NO",length = 5, nullable = true, columnDefinition = "折讓序號")
    private String discount_no;

    @Column(name="INVOICE_NO",length = 10, nullable = true, columnDefinition = "發票號碼")
    private String invoice_no;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="INVOICE_CREATED_DATE",nullable = true, columnDefinition = "發票日期 發票開立/取消日期,YYYY-MM-DD")
    private Date invoice_created_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="RESPONSE_TIME",nullable = true, columnDefinition = "回覆時間")
    private Date response_time;

    @Column(name="RESPONSE_MSG",length = 50, nullable = true, columnDefinition = "回覆訊息")
    private String response_msg;

    @Column(name="RANDOM_NO",length = 4, precision = 0, nullable = true, columnDefinition = "四碼隨機碼")
    private Integer random_no;

    @Column(name="BUYER_ID",length = 20, nullable = true, columnDefinition = "個人識別碼")
    private String buyer_id;

    @Column(name="TAX_TYPE",length = 1, precision = 0, nullable = true, columnDefinition = "課稅別 1:應稅 2:零稅率 3:免稅")
    private Integer tax_type;

    @Column(name="INVOICETYPE",length = 10, precision = 0, nullable = true, columnDefinition = "繳款狀態 失敗：0 成功：1")
    private Integer invoicetype;

    @Column(name="INVOICETITLE",length = 100, nullable = true, columnDefinition = "發票抬頭")
    private String invoicetitle;

    @Column(name="UNIFORM",length = 10, nullable = true, columnDefinition = "統一編號")
    private String uniform;

    @Column(name="INVOICEADDRESS",length = 200, nullable = true, columnDefinition = "發票地址")
    private String invoiceaddress;

    @Column(name="INVOICECONTACT",length = 100, nullable = true, columnDefinition = "聯絡人")
    private String invoicecontact;

    @Column(name="INVOICECONTACTTEL",length = 30, nullable = true, columnDefinition = "聯絡電話")
    private String invoicecontacttel;

    @Column(name="INVOICECONTACTMOBILEPHONE",length = 20, nullable = true, columnDefinition = "聯絡人手機")
    private String invoicecontactmobilephone;

    @Column(name="INVOICECONTACTEMAIL",length = 100, nullable = true, columnDefinition = "聯絡人email")
    private String invoicecontactemail;

    @Column(name="CPLIBM",length = 15, nullable = true, columnDefinition = "CP交易編號")
    private String cpLibm;
    
    private String donate;

    public String getDonate() {
        return donate;
    }

    public void setDonate(String donate) {
        this.donate = donate;
    }
    

    public EPAY_INVOICE() {
        super();
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getLibm() {
        return libm;
    }

    public void setLibm(String libm) {
        this.libm = libm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiscount_no() {
        return discount_no;
    }

    public void setDiscount_no(String discount_no) {
        this.discount_no = discount_no;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public Date getInvoice_created_date() {
        return invoice_created_date;
    }

    public void setInvoice_created_date(Date invoice_created_date) {
        this.invoice_created_date = invoice_created_date;
    }

    public Date getResponse_time() {
        return response_time;
    }

    public void setResponse_time(Date response_time) {
        this.response_time = response_time;
    }

    public String getResponse_msg() {
        return response_msg;
    }

    public void setResponse_msg(String response_msg) {
        this.response_msg = response_msg;
    }

    public Integer getRandom_no() {
        return random_no;
    }

    public void setRandom_no(Integer random_no) {
        this.random_no = random_no;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getTax_type() {
        return tax_type;
    }

    public void setTax_type(Integer tax_type) {
        this.tax_type = tax_type;
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getInvoicetitle() {
        return invoicetitle;
    }

    public void setInvoicetitle(String invoicetitle) {
        this.invoicetitle = invoicetitle;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getInvoiceaddress() {
        return invoiceaddress;
    }

    public void setInvoiceaddress(String invoiceaddress) {
        this.invoiceaddress = invoiceaddress;
    }

    public String getInvoicecontact() {
        return invoicecontact;
    }

    public void setInvoicecontact(String invoicecontact) {
        this.invoicecontact = invoicecontact;
    }

    public String getInvoicecontacttel() {
        return invoicecontacttel;
    }

    public void setInvoicecontacttel(String invoicecontacttel) {
        this.invoicecontacttel = invoicecontacttel;
    }

    public String getInvoicecontactmobilephone() {
        return invoicecontactmobilephone;
    }

    public void setInvoicecontactmobilephone(String invoicecontactmobilephone) {
        this.invoicecontactmobilephone = invoicecontactmobilephone;
    }

    public String getInvoicecontactemail() {
        return invoicecontactemail;
    }

    public void setInvoicecontactemail(String invoicecontactemail) {
        this.invoicecontactemail = invoicecontactemail;
    }

    public String getCpLibm() {
        return cpLibm;
    }

    public void setCpLibm(String cpLibm) {
        this.cpLibm = cpLibm;
    }

}
