/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epay.ejb;

import com.epay.ejb.bean.EPAY_BUNDLEDATE;

/**
 *
 * @author kevinchang
 */
public interface EPAY_BUNDELDATEDAO {
    
    public EPAY_BUNDLEDATE getBundleDate(String  hours) throws Exception;
}
