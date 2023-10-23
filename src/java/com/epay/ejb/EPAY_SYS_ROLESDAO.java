/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;


import com.epay.ejb.bean.EPAY_SYS_ROLES;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface EPAY_SYS_ROLESDAO {

    public EPAY_SYS_ROLES findFuncID_BYRoleID(String roleid);

    public EPAY_SYS_ROLES getRoles_BYRoleID(String roleid);

    public String getRoleName_id(String id);

    public List getAllRoles();
    
    public boolean insert_SYS_ROLES(EPAY_SYS_ROLES role) throws Exception;

    public boolean update_SYS_ROLES(EPAY_SYS_ROLES role) throws Exception;    
}
