/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epay.ejb;

import com.epay.ejb.bean.EPAY_VCARD;
import java.util.List;


/**
 *
 * @author kevinchang
 */
public interface EPAY_VCARDDAO {
    

    public boolean insertVCard(EPAY_VCARD bean) throws Exception;
    public EPAY_VCARD getVCPass(String tokenId) throws Exception;
    public boolean updateVCard(EPAY_VCARD bean) throws Exception;
    public EPAY_VCARD queryVCard(int id) throws Exception;
    public List<EPAY_VCARD> queryVCarderByCardType(String cardtype) throws Exception;
    public boolean queryVCardByFileName(String filename) throws Exception;
    public EPAY_VCARD getVCardByToken( String tokenId, String mdn,String serviceid) throws Exception;
}
