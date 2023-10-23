package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Booker Hsu
 */
@Entity
@Table(name = "DTONESERVICEINFO")
public class EPAY_DTONESERVICE_INFO implements Serializable {

//    private static final long serialVersionUID = -1371422545164L;

    private Long serviceId;
    private String serviceName;
    private Integer cpId;
    private Integer price;
    private String glcode;
    private String note;
    private Integer flag;
    private String promotioncode;
    private String ocsstatus;
    private String cmsstatus;
    private int platformtype;
    private String servicematcode; //SERVICEMATCODE
    private String operator_name;
    private int price_id;

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }


    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
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

    public EPAY_DTONESERVICE_INFO() {
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

}
