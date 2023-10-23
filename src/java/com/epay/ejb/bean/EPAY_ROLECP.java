/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PG_ROLECP")
public class EPAY_ROLECP implements Serializable{

    private String rolecp_id;
    private EPAY_SYS_ROLES pg_sys_roles;
//    private PG_CONTENT_PROVIDER pg_content_provider;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getRolecp_id() {
        return rolecp_id;
    }

    public void setRolecp_id(String rolecp_id) {
        this.rolecp_id = rolecp_id;
    }

//    @ManyToOne
//    @JoinColumn(name = "cp_code", referencedColumnName = "cp_code")
//    public PG_CONTENT_PROVIDER getPg_content_provider() {
//        return pg_content_provider;
//    }

//    public void setPg_content_provider(PG_CONTENT_PROVIDER pg_content_provider) {
//        this.pg_content_provider = pg_content_provider;
//    }

    
    @ManyToOne
    @JoinColumn(name = "r_id", referencedColumnName = "r_id")
    public EPAY_SYS_ROLES getPg_sys_roles() {
        return pg_sys_roles;
    }

    public void setPg_sys_roles(EPAY_SYS_ROLES pg_sys_roles) {
        this.pg_sys_roles = pg_sys_roles;
    }
}
