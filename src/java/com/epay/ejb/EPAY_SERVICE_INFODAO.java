package com.epay.ejb;

import com.epay.ejb.bean.EPAY_SERVICE_INFO;
import java.util.List;

public interface EPAY_SERVICE_INFODAO {

    public EPAY_SERVICE_INFO getServiceInfoByCpidAndServiceId(Long serviceid,Integer cid) throws Exception;
    public EPAY_SERVICE_INFO getServiceInfoById(Long serviceid, Integer cid) throws Exception;
    public EPAY_SERVICE_INFO getServiceInfoById_Noflag(Long serviceid, Integer cid) throws Exception;

    public List<EPAY_SERVICE_INFO> getDTOneServiceInfo(Integer cpid, String promotioncode, int platformtype, String operatorname) throws Exception;
    public List<EPAY_SERVICE_INFO> getAllServiceInfo(Integer cpid, String promotioncode, int platformtype) throws Exception;
    public List<EPAY_SERVICE_INFO> getNokiaServiceInfo(Integer cpid, String promotioncode, int platformtype) throws Exception;

    public List<EPAY_SERVICE_INFO> getAllServiceInfoByPromotionCode(Integer cpid, String promotioncode,String contractstatuscode,String lifecyclestatus ) throws Exception;

    public List getAdjustAccServiceInfo(Integer cpid, String atype, String xcode,int platformtype) throws Exception;
    public List getAdjustAccNokiaServiceInfo(Integer cpid, String atype, String xcode,int platformtype) throws Exception;

    public boolean insertServiceinfo(EPAY_SERVICE_INFO serviceinfo) throws Exception;

    public List getServiceInfo() throws Exception;

    public List getServiceInfoBySid(long sid) throws Exception;

    public boolean updateServiceInfo(EPAY_SERVICE_INFO serviceinfo) throws Exception;
    
    public EPAY_SERVICE_INFO getServiceInfoByPricePlanCode(String priceplancode) throws Exception;
}
