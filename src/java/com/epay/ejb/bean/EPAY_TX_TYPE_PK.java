package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EPAY_TX_TYPE_PK implements Serializable {
    
//    private static final long serialVersionUID = -2514213714L;
    private Integer cpId;
    private String txTypeId;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EPAY_TX_TYPE_PK other = (EPAY_TX_TYPE_PK) obj;
        if ((this.cpId == null)
                ? (other.cpId != null) : !this.cpId.equals(other.cpId)) {
            return false;
        }
        if ((this.txTypeId == null)
                ? (other.txTypeId != null) : !this.txTypeId.equals(other.txTypeId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 141;
        hash = 173 * hash + (this.cpId != null ? this.cpId.hashCode() : 0);
        hash = 173 * hash + (this.txTypeId != null ? this.txTypeId.hashCode() : 0);
        return hash;
    }
}