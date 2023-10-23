/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@SuppressWarnings("serial")
@Entity
@Table(name = "PG_SYS_FUNCTIONS")
public class EPAY_SYS_FUNCTIONS implements Serializable {

    private String f_id;
    private String p_name;
    private String f_name;
    private String f_url;
    private String f_auth;
    //  private Set<PG_SYS_ROLEFUNCS> pg_sys_rolefuncs = new HashSet<PG_SYS_ROLEFUNCS>();
//    private Set<EPAY_SYS_ROLES> pg_sys_roles = new HashSet<EPAY_SYS_ROLES>();


//    @GeneratedValue
    @Id    
    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

//    @Column(nullable = false)
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

//    @Column(nullable = false)
    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

//    @Column(nullable = false)
    public String getF_url() {
        return f_url;
    }

    public void setF_url(String f_url) {
        this.f_url = f_url;
    }

//    @Column(nullable = false)
    public String getF_auth() {
        return f_auth;
    }

    public void setF_auth(String f_auth) {
        this.f_auth = f_auth;
    }
//        @OneToMany(mappedBy = "pg_sys_funtions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @OrderBy(value = "id ASC")
//    public Set<PG_SYS_ROLEFUNCS> getPg_sys_rolefuncs() {
//        return pg_sys_rolefuncs;
//    }
//
//    public void setPg_sys_rolefuncs(Set<PG_SYS_ROLEFUNCS> pg_sys_rolefuncs) {
//        this.pg_sys_rolefuncs = pg_sys_rolefuncs;
//    }
//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(name = "PG_SYS_ROLEFUNCS",
//    joinColumns = {@JoinColumn(name = "f_id", referencedColumnName = "f_id")},
//    inverseJoinColumns = {@JoinColumn(name = "fr_id", referencedColumnName = "r_id")})
//    public Set<EPAY_SYS_ROLES> getPg_sys_roles() {
//        return pg_sys_roles;
//    }
//
//    public void setPg_sys_roles(Set<EPAY_SYS_ROLES> pg_sys_roles) {
//        this.pg_sys_roles = pg_sys_roles;
//    }
//    public void addPG_SYS_ROLEFUNCS(PG_SYS_ROLEFUNCS pg_sys_rolefuncs) {
//        if (!this.pg_sys_rolefuncs.contains(pg_sys_rolefuncs)) {
//            this.pg_sys_rolefuncs.add(pg_sys_rolefuncs);
//            pg_sys_rolefuncs.setPg_sys_funtions(this);
//        }
//    }

//    public void removePG_SYS_ROLEFUNCS(PG_SYS_ROLEFUNCS pg_sys_rolefuncs) {
//        pg_sys_rolefuncs.setPg_sys_funtions(null);
//        this.pg_sys_rolefuncs.remove(pg_sys_rolefuncs);
//    }
}

