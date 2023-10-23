/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kevinchang
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SYS_SERVER")
public class EPAY_SYS_SERVER implements Serializable {
    
    @Id
    private String sys_code;
    private String sys_name;
    private String sys_desc;
    
    public String getSys_code() {
        return sys_code;
    }

    public void setSys_code(String sys_code) {
        this.sys_code = sys_code;
    }

    public String getSys_name() {
        return sys_name;
    }

    public void setSys_name(String sys_name) {
        this.sys_name = sys_name;
    }

    public String getSys_desc() {
        return sys_desc;
    }

    public void setSys_desc(String sys_desc) {
        this.sys_desc = sys_desc;
    }


    
    
}
