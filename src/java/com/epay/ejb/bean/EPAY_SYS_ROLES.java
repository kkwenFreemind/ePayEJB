/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PG_SYS_ROLES")
public class EPAY_SYS_ROLES implements Serializable {

    private String r_id;
    private String r_name;
    private String r_func_id;
//    private Set<EPAY_ROLECP> pg_rolecp = new HashSet<EPAY_ROLECP>();
    // private Set<PG_COMMON_USER> pg_common_user = new HashSet<PG_COMMON_USER>();
    //  private Set<PG_SYS_ROLEFUNCS> pg_sys_rolefuncs = new HashSet<PG_SYS_ROLEFUNCS>();
//private Set<PG_SYS_FUNCTIONS> pg_sys_functions = new HashSet<PG_SYS_FUNCTIONS>();

    @Id
    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_func_id() {
        return r_func_id;
    }

    public void setR_func_id(String r_func_id) {
        this.r_func_id = r_func_id;
    }
//
//    @OneToMany(mappedBy = "pg_sys_roles", fetch = FetchType.EAGER)
//    public Set<EPAY_ROLECP> getPg_rolecp() {
//        return pg_rolecp;
//    }
//
//    public void setPg_rolecp(Set<EPAY_ROLECP> pg_rolecp) {
//        this.pg_rolecp = pg_rolecp;
//    }
//    @OneToMany(mappedBy = "pg_sys_roles")
//    public Set<PG_COMMON_USER> getPg_common_user() {
//        return pg_common_user;
//    }
//
//    public void setPg_common_user(Set<PG_COMMON_USER> pg_common_user) {
//        this.pg_common_user = pg_common_user;
//    }
//
//    public void addPG_COMMON_USER(PG_COMMON_USER pg_common_user) {
//        if (!this.pg_common_user.contains(pg_common_user)) {
//            this.pg_common_user.add(pg_common_user);
//            pg_common_user.setPg_sys_roles(this);
//        }
//    }
//
//    public void removePG_COMMON_USER(PG_COMMON_USER pg_common_user) {
//        pg_common_user.setPg_sys_roles(null);
//        this.pg_common_user.remove(pg_common_user);
//    }
//    @OneToMany(mappedBy = "pg_sys_roles")
//    public Set<PG_SYS_ROLEFUNCS> getPg_sys_rolefuncs() {
//        return pg_sys_rolefuncs;
//    }
//
//    public void setPg_sys_rolefuncs(Set<PG_SYS_ROLEFUNCS> pg_sys_rolefuncs) {
//        this.pg_sys_rolefuncs = pg_sys_rolefuncs;
//    }
//    @ManyToMany(mappedBy = "pg_sys_roles")
//    public Set<PG_SYS_FUNCTIONS> getPg_sys_functions() {
//        return pg_sys_functions;
//    }
//
//    public void setPg_sys_functions(Set<PG_SYS_FUNCTIONS> pg_sys_functions) {
//        this.pg_sys_functions = pg_sys_functions;
//    }
//    public void addPG_SYS_ROLEFUNCS(PG_SYS_ROLEFUNCS pg_sys_rolefuncs) {
//        if (!this.pg_sys_rolefuncs.contains(pg_sys_rolefuncs)) {
//            this.pg_sys_rolefuncs.add(pg_sys_rolefuncs);
//            pg_sys_rolefuncs.setPg_sys_roles(this);
//        }
//    }
//    public void removePG_SYS_ROLEFUNCS(PG_SYS_ROLEFUNCS pg_sys_rolefuncs) {
//        pg_sys_rolefuncs.setPg_sys_roles(null);
//        this.pg_sys_rolefuncs.remove(pg_sys_rolefuncs);
//    }
}
