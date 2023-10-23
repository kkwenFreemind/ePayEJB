package com.epay.ejb.bean;

import java.io.Serializable;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Booker Hsu
 */
@Entity
@Table(name = "SERVICEINFO")
public class EPAY_SERVICE_INFO implements Serializable {

//    private static final long serialVersionUID = -1371422545164L;

    private Long serviceId;
    private String serviceName;
    private Integer cpId;
    private Integer price;
    private String glcode;
    private String note;
    private Integer dday;
    private Integer flag;
    private String cardtype;
    private String promotioncode;
    private String ocsstatus;
    private String cmsstatus;
    private int platformtype;
    private String priceplancode;
    private String servicematcode; //SERVICEMATCODE
    private String operator_name;
    private String price_id;
    private int check_value;
    private Integer gtype;

    public int getCheck_value() {
        return check_value;
    }

    public void setCheck_value(int check_value) {
        this.check_value = check_value;
    }

    
    
    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getPrice_id() {
        return price_id;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }
   
    
    public String getPriceplancode() {
        return priceplancode;
    }

    public void setPriceplancode(String priceplancode) {
        this.priceplancode = priceplancode;
    }

    public int getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(int platformtype) {
        this.platformtype = platformtype;
    }

    private EPAY_CALLER caller;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public Integer getDday() {
        return dday;
    }

    public void setDday(Integer dday) {
        this.dday = dday;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGlcode() {
        return glcode;
    }

    public void setGlcode(String glcode) {
        this.glcode = glcode;
    }
    private String status;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cpId")
//    private CP_INFO cpInfo;
//    public CP_INFO getCpInfo() {
//        return cpInfo;
//    }
//
//    public void setCpInfo(CP_INFO cpInfo) {
//        this.cpInfo = cpInfo;
//    }
    @Id
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "CALLERID", nullable = false)
    public EPAY_CALLER getCaller() {
        return caller;
    }

    public void setCaller(EPAY_CALLER caller) {
        this.caller = caller;
    }

    public EPAY_SERVICE_INFO() {
        super();
    }

    public String getPromotioncode() {
        return promotioncode;
    }

    public void setPromotioncode(String promotioncode) {
        this.promotioncode = promotioncode;
    }

    public String getOcsstatus() {
        return ocsstatus;
    }

    public void setOcsstatus(String ocsstatus) {
        this.ocsstatus = ocsstatus;
    }

    public String getCmsstatus() {
        return cmsstatus;
    }

    public void setCmsstatus(String cmsstatus) {
        this.cmsstatus = cmsstatus;
    }

    public String getServicematcode() {
        return servicematcode;
    }

    public void setServicematcode(String servicematcode) {
        this.servicematcode = servicematcode;
    }

    public Integer getGtype() {
        return gtype;
    }

    public void setGtype(Integer gtype) {
        this.gtype = gtype;
    }



    
    
}
