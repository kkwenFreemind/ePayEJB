package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;

/**
 *
 * @author Booker Hsu
 */
@Entity
@Table(name = "TXTYPE")
@IdClass(com.epay.ejb.bean.EPAY_TX_TYPE_PK.class)
public class EPAY_TX_TYPE implements Serializable {
//    private static final long serialVersionUID = -2451426613714L;

    @Id
    private Integer cpId;
    @Id
    private String txTypeId;
    private String txTypeName;
    private String status;
    private String feeType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cpId", insertable = false, updatable = false)
    private EPAY_CP_INFO cpInfo;

    public EPAY_CP_INFO getCpInfo() {
        return cpInfo;
    }

    public void setCpInfo(EPAY_CP_INFO cpInfo) {
        this.cpInfo = cpInfo;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getTxTypeId() {
        return txTypeId;
    }

    public void setTxTypeId(String txTypeId) {
        this.txTypeId = txTypeId;
    }

    public String getTxTypeName() {
        return txTypeName;
    }

    public void setTxTypeName(String txTypeName) {
        this.txTypeName = txTypeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

}
