package com.epay.ejb;

import java.util.List;

import com.epay.ejb.bean.EPAY_CALLER;

public interface EPAY_CALLERDAO {

    public EPAY_CALLER getCaller(String callId) throws Exception;
    
    

    public List<EPAY_CALLER> getAllCaller() throws Exception;
}
