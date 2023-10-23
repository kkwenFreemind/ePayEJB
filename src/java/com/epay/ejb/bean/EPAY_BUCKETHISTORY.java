/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

/**
 *
 * @author kevinchang
 */
@Entity
@Table(name = "BUCKETHISTORY")
public class EPAY_BUCKETHISTORY implements Serializable {

//    private static final long serialVersionUID = -1637546522433L;

    private int id;
    private String libm;
    private String mdn;
    
    private Date tradedate;
    
    private String bucketid;
    private long amount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibm() {
        return libm;
    }

    public void setLibm(String libm) {
        this.libm = libm;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public String getBucketid() {
        return bucketid;
    }

    public void setBucketid(String bucketid) {
        this.bucketid = bucketid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
