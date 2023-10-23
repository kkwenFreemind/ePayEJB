/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

import com.epay.ejb.bean.EPAY_SCT_CARD;
import com.epay.ejb.bean.EPAY_VCARD;

import java.util.List;


/**
 *
 * @author kevinchang
 */
public interface EPAY_SCTCARDDAO {
    
    public EPAY_SCT_CARD getSctCardInfoByIccid(String iccid) throws Exception;
    public List getSctCardInfoByAPN(String apn) throws Exception;
    public List getSctCardInfo() throws Exception;
    public boolean insertSctCardInfo(EPAY_SCT_CARD sctcardinfo) throws Exception;
    public EPAY_SCT_CARD getSctCardInfoById(int id) throws Exception;
    public boolean updateSCTCard(EPAY_SCT_CARD bean) throws Exception;

    
}
