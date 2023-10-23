package com.epay.ejb.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

/**
 *
 * @author Booker Hsu
 */
@Entity
@Table(name = "CALLER")
public class EPAY_CALLER implements Serializable {

//    private static final long serialVersionUID = -74174738132L;
    private String callerid;
    private String callerName;
    private String pgEnkey;
    private String pgIdentify;
    private List<EPAY_CP_INFO> cpInfo;
    
    @OneToMany
    @JoinColumn(name = "callerid", referencedColumnName = "CALLERID", insertable = false, updatable = false)
    public List<EPAY_CP_INFO> getCpInfo() {
        return cpInfo;
    }

    public void setCpInfo(List<EPAY_CP_INFO> cpInfo) {
        this.cpInfo = cpInfo;
    }
    
    @Id
    @Column(name="CALLERID")
    public String getCallerid() {
        return callerid;
    }

    public void setCallerid(String callerid) {
        this.callerid = callerid;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    @Column(name="PG_ENKEY")
    public String getPgEnkey() {
        return pgEnkey;
    }

    public void setPgEnkey(String pgEnkey) {
        this.pgEnkey = pgEnkey;
    }

    @Column(name="PG_IDENTIFY")
    public String getPgIdentify() {
        return pgIdentify;
    }

    public void setPgIdentify(String pgIdentify) {
        this.pgIdentify = pgIdentify;
    }
}
