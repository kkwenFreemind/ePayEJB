/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
@Table(name = "PG_COMMON_USER")
public class EPAY_COMMON_USER implements Serializable {

    private Integer cuser_id;
    private String cuser_code;
    private String cuser_name;
    private String cuser_password;
    private String cuser_mobile_number;
    private String cuser_email;
    private String cuser_status;
    private String ocs_flag;
    private String cuser_ipaddr;
//    private String cuser_role;
    private EPAY_SYS_ROLES pg_sys_roles;
//    private PG_CONTENT_PROVIDER pg_content_provider;
//   private String CUSER_ROLE;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCuser_id() {
        return cuser_id;
    }

    public void setCuser_id(Integer cuser_id) {
        this.cuser_id = cuser_id;
    }

    @Column(nullable = false, length = 45)
    public String getCuser_code() {
        return cuser_code;
    }

    public void setCuser_code(String cuser_code) {
        this.cuser_code = cuser_code;
    }

    @Column(nullable = false)
    public String getCuser_name() {
        return cuser_name;
    }

    public void setCuser_name(String cuser_name) {
        this.cuser_name = cuser_name;
    }

    @Column(nullable = false, unique = true)
    public String getCuser_password() {
        return cuser_password;
    }

    public void setCuser_password(String cuser_password) {
        this.cuser_password = cuser_password;
    }

    @Column(nullable = false)
    public String getCuser_mobile_number() {
        return cuser_mobile_number;
    }

    public void setCuser_mobile_number(String cuser_mobile_number) {
        this.cuser_mobile_number = cuser_mobile_number;
    }

    @Column(nullable = true)
    public String getCuser_email() {
        return cuser_email;
    }

    public void setCuser_email(String cuser_email) {
        this.cuser_email = cuser_email;
    }

    @Column(nullable = true)
    public String getCuser_status() {
        return cuser_status;
    }

    public void setCuser_status(String cuser_status) {
        this.cuser_status = cuser_status;
    }

//    @Column(nullable = true)
//    public String getCUSER_ROLE() {
//        return CUSER_ROLE;
//    }
//
//    public void setCUSER_ROLE(String CUSER_ROLE) {
//        this.CUSER_ROLE = CUSER_ROLE;
//    }
    @ManyToOne
    @JoinColumn(name = "cuser_role", referencedColumnName = "r_id")
    public EPAY_SYS_ROLES getPg_sys_roles() {
        return pg_sys_roles;
    }

    public void setPg_sys_roles(EPAY_SYS_ROLES pg_sys_roles) {
        this.pg_sys_roles = pg_sys_roles;
    }

    
//    @ManyToOne
//    @JoinColumn(name = "cuser_cp_code", referencedColumnName = "cp_code")
//    public PG_CONTENT_PROVIDER getPg_content_provider() {
//        return pg_content_provider;
//    }
//
//    public void setPg_content_provider(PG_CONTENT_PROVIDER pg_content_provider) {
//        this.pg_content_provider = pg_content_provider;
//    }

    public String getOcs_flag() {
        return ocs_flag;
    }

    public void setOcs_flag(String ocs_flag) {
        this.ocs_flag = ocs_flag;
    }

    public String getCuser_ipaddr() {
        return cuser_ipaddr;
    }

    public void setCuser_ipaddr(String cuser_ipaddr) {
        this.cuser_ipaddr = cuser_ipaddr;
    }

    
    
    
}
