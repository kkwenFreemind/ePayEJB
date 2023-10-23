/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

//import com.cpecfweb.ejb.bean.PG_CONTENT_PROVIDER;

import com.epay.ejb.bean.EPAY_ROLECP;


/**
 *
 * @author RyanChen
 */
public interface EPAY_ROLECPDAO {

    public boolean insertROLECP(EPAY_ROLECP rolecp) throws Exception;

    public boolean deleteROLECP_ByRId(String r_id) throws Exception;

//    public List getListROLECP(PG_SYS_ROLES sys_role, PG_CONTENT_PROVIDER cp);
}
