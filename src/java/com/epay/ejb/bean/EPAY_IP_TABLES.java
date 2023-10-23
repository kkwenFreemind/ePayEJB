/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kevinchang
 */
@Entity
@Table(name = "IP_TABLES")
public class EPAY_IP_TABLES {

//    private static final long serialVersionUID = -1637246522433L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cp_id;
    private String ipaddr1;
    private String ipaddr2;
    private String ipaddr3;
    private String ipaddr4;
    private String ipaddr5;
    private String ipaddr6;
    @Temporal(TemporalType.TIMESTAMP)
    private Date act_date;
    private Integer bwflag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public String getIpaddr1() {
        return ipaddr1;
    }

    public void setIpaddr1(String ipaddr1) {
        this.ipaddr1 = ipaddr1;
    }

    public String getIpaddr2() {
        return ipaddr2;
    }

    public void setIpaddr2(String ipaddr2) {
        this.ipaddr2 = ipaddr2;
    }

    public String getIpaddr3() {
        return ipaddr3;
    }

    public void setIpaddr3(String ipaddr3) {
        this.ipaddr3 = ipaddr3;
    }

    public String getIpaddr4() {
        return ipaddr4;
    }

    public void setIpaddr4(String ipaddr4) {
        this.ipaddr4 = ipaddr4;
    }

    public String getIpaddr5() {
        return ipaddr5;
    }

    public void setIpaddr5(String ipaddr5) {
        this.ipaddr5 = ipaddr5;
    }

    public String getIpaddr6() {
        return ipaddr6;
    }

    public void setIpaddr6(String ipaddr6) {
        this.ipaddr6 = ipaddr6;
    }

    public Date getAct_date() {
        return act_date;
    }

    public void setAct_date(Date act_date) {
        this.act_date = act_date;
    }

    public Integer getBwflag() {
        return bwflag;
    }

    public void setBwflag(Integer bwflag) {
        this.bwflag = bwflag;
    }
    
    
}
