/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

import com.epay.ejb.bean.EPAY_IP_TABLES;

/**
 *
 * @author kevinchang
 */
public interface EPAY_IP_TABLESDAO {

    public EPAY_IP_TABLES getIP_TABLES_ByCPID(int cpid) throws Exception;
}
