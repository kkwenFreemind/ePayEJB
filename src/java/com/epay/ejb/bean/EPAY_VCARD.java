/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kevinchang
 */
@Entity
@Table(name = "VCARD")
public class EPAY_VCARD implements Serializable {

//    private static final long serialVersionUID = -1637246522433L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cardtype;
    private String vcno;
    private String vcpass;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderexpiredate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date submitdate;
    private String channel;
    private String mdn;
    private String uuid;
    private String status;
    private String filename;
    private String memo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    private String tokenid;
    private String serviceid;

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public Date getOrderexpiredate() {
        return orderexpiredate;
    }

    public void setOrderexpiredate(Date orderexpiredate) {
        this.orderexpiredate = orderexpiredate;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVcno() {
        return vcno;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public void setVcno(String vcno) {
        this.vcno = vcno;
    }

    public String getVcpass() {
        return vcpass;
    }

    public void setVcpass(String vcpass) {
        this.vcpass = vcpass;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getMdn() {
        return mdn;
    }

    public void setMdn(String mdn) {
        this.mdn = mdn;
    }

}
