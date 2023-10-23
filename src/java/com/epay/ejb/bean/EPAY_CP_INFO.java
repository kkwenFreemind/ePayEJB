package com.epay.ejb.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

/**
 *
 * @author Booker Hsu
 */
@Entity
@Table(name = "CPINFO")
public class EPAY_CP_INFO implements Serializable {

//    private static final long serialVersionUID = -2257735145694L;
    private Integer cpId;
    private String cpName;
    private String enkey;
    private String identify;
    private String invoice_url;
    private String payment_url;
    private String ibon_url;
    private String status;
    private List<EPAY_TX_TYPE> txTypes;
    private List<EPAY_SERVICE_INFO> ServiceInfo;
    private String poskey;

    @OneToMany
    @JoinColumn(name = "cpId", referencedColumnName = "CPID", insertable = false, updatable = false)
    public List<EPAY_SERVICE_INFO> getServiceInfo() {
        return ServiceInfo;
    }

    public void setServiceInfo(List<EPAY_SERVICE_INFO> ServiceInfo) {
        this.ServiceInfo = ServiceInfo;
    }
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpId", cascade = CascadeType.ALL)
    public List<EPAY_TX_TYPE> getTxTypes() {
        return txTypes;
    }

    public void setTxTypes(List<EPAY_TX_TYPE> txTypes) {
        this.txTypes = txTypes;
    }
    
    @Id
    @Column(name="CPID")
    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

//    @Column(name="CPNAME")
    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getEnkey() {
        return enkey;
    }

    public void setEnkey(String enkey) {
        this.enkey = enkey;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvoice_url() {
        return invoice_url;
    }

    public void setInvoice_url(String invoice_url) {
        this.invoice_url = invoice_url;
    }

    public String getPayment_url() {
        return payment_url;
    }

    public void setPayment_url(String payment_url) {
        this.payment_url = payment_url;
    }  
    
    public String getIbon_url(){
        return ibon_url;
    }
    
    public void setIbon_url(String ibon_url){
        this.ibon_url = ibon_url;
    }

    public String getPoskey() {
        return poskey;
    }

    public void setPoskey(String poskey) {
        this.poskey = poskey;
    }
    
    
}
