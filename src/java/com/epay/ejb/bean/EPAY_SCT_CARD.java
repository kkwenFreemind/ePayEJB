/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kevinchang
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCTCARD")
public class EPAY_SCT_CARD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sct_name;
    private String iccid_start;
    private String iccid_end;
    private String support_name;
    private String apn;
    private String memo;
    private String amount;
    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIccid_start() {
        return iccid_start;
    }

    public void setIccid_start(String iccid_start) {
        this.iccid_start = iccid_start;
    }

    public String getIccid_end() {
        return iccid_end;
    }

    public void setIccid_end(String iccid_end) {
        this.iccid_end = iccid_end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSct_name() {
        return sct_name;
    }

    public void setSct_name(String sct_name) {
        this.sct_name = sct_name;
    }

    public String getSupport_name() {
        return support_name;
    }

    public void setSupport_name(String support_name) {
        this.support_name = support_name;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
