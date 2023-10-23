/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb;

import com.epay.ejb.bean.EPAY_DEALERCARD;
import com.epay.ejb.bean.EPAY_DEALERMDN;

/**
 *
 * @author kevinchang
 */
public interface EPAY_DEALERMDNDAO {

    public EPAY_DEALERMDN geDearlMDNByMDN(String dealerId, String mdn) throws Exception;

}
