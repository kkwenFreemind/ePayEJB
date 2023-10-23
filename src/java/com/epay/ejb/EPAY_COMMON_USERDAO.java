/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;


import com.epay.ejb.bean.EPAY_COMMON_USER;
import com.epay.ejb.bean.EPAY_SERVICE_INFO;
import java.util.List;

/**
 *
 * @author kevinchang
 */
public interface EPAY_COMMON_USERDAO {

    public EPAY_COMMON_USER getAccount_byUserCode(String id) throws Exception;

    public boolean insertAccount(EPAY_COMMON_USER user) throws Exception;
    
    public String getAccountName_byUserCode(String id) throws Exception;

    public List getAllUser() throws Exception;

    public List getUser_ByUserCode(String user_code) throws Exception;

    public List getUser_ByUserName(String user_name) throws Exception;

    public List getUser_ByUserMobile(String user_mobile) throws Exception;

    public List getUser_ByUserRole(String user_role) throws Exception;

    public List getUser_ByUserNameAndUserMobile(String user_name, String user_mobile) throws Exception;

    public List getUser_ByUserNameAndUserRole(String user_name, String user_role) throws Exception;

    public List getUser_ByUserMobileAndUserRole(String user_mobile, String user_role) throws Exception;

    public List getUser_ByUserNameAndUserMobileAndUserRole(String user_name, String user_mobile, String user_role) throws Exception;

    public boolean deleteUser_ByUserId(String userid) throws Exception;

    public boolean updateUser(EPAY_COMMON_USER user) throws Exception;
}
