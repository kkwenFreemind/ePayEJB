package com.epay.ejb;

import com.epay.ejb.bean.EPAY_DTONESERVICE_INFO;

import java.util.List;

public interface EPAY_DTONESERVICE_INFODAO {

    public List<EPAY_DTONESERVICE_INFO> getDTOneServiceInfo(Integer cpid, String promotioncode, int platformtype, String operatorname) throws Exception;

    public EPAY_DTONESERVICE_INFO getDtonServiceInfoById(Long serviceid, Integer cid) throws Exception;
    
    public EPAY_DTONESERVICE_INFO getDtonServiceInfoByIdOnly(Long serviceid, Integer cid) throws Exception;

    public boolean insertDTOneServiceinfo(EPAY_DTONESERVICE_INFO serviceinfo) throws Exception;

    public List getDTOneServiceInfo() throws Exception;
    
    public List getDTOneServiceInfoBySid(long sid) throws Exception;
    
    public List getDTOneServiceInfoBySidOnly(long sid) throws Exception;
    
    public boolean updateDTOneServiceInfo(EPAY_DTONESERVICE_INFO serviceinfo) throws Exception;
    

}
