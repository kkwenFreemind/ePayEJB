package com.epay.ejb;

import java.util.List;

import com.epay.ejb.bean.EPAY_CP_INFO;

public interface EPAY_CP_INFODAO {

    public EPAY_CP_INFO getCpInfoTxType(Integer cpid) throws Exception;
    public EPAY_CP_INFO getCpInfo(Integer cpid) throws Exception;
    
    public List<EPAY_CP_INFO> getAllCpInfo() throws Exception;
}
