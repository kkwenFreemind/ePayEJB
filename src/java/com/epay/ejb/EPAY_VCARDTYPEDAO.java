/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;


import com.epay.ejb.bean.EPAY_VCARDTYPE;
import java.util.List;

/**
 *
 * @author kevinchang
 */
public interface EPAY_VCARDTYPEDAO {

    public boolean insertVCardType(EPAY_VCARDTYPE bean) throws Exception;
    public List<EPAY_VCARDTYPE> listAllCardTypeInfo() throws Exception;
    public EPAY_VCARDTYPE queryCardTypeByCardType(String cardtype) throws Exception;
    public boolean updateVCardType(EPAY_VCARDTYPE bean) throws Exception;
    
}
