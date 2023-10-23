/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

import com.epay.ejb.bean.EPAY_SYS_FUNCTIONS;
import java.util.List;

public interface EPAY_SYS_FUNCTIONSDAO {

    public List ListParentName_ByRole(String funid);

    public List ListFunction_ByRole(String funid);

    public boolean insert_SYS_FUNCTIONS(EPAY_SYS_FUNCTIONS func) throws Exception;

    public boolean update_SYS_FUNCTIONS(EPAY_SYS_FUNCTIONS func) throws Exception;

    public List getFuncInfo() throws Exception;

    public EPAY_SYS_FUNCTIONS getFunc_byUserCode(String id) throws Exception;
}
