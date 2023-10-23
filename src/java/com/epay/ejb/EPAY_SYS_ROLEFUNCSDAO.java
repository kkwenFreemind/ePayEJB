/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

import com.epay.ejb.bean.EPAY_SYS_ROLEFUNCS;
import java.util.List;

/**
 *
 * @author kevinchang
 */
public interface EPAY_SYS_ROLEFUNCSDAO {

    public boolean insert_SYS_ROLE_FUNCTIONS(EPAY_SYS_ROLEFUNCS rolefunc) throws Exception;

    public boolean update_SYS_ROLE_FUNCTIONS(EPAY_SYS_ROLEFUNCS rolefunc) throws Exception;

    public List getAllRoleFuncs();

    public EPAY_SYS_ROLEFUNCS getRoleFuncs_BY_RoleID(int roleid);

}
