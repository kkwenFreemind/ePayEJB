package com.epay.ejb.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE_ITEM")
public class EPAY_INVOICE_ITEM implements Serializable {
    
//    private static final long serialVersionUID = -7017905470722L;

    @Id
    @Column(length = 10, precision = 0, nullable = false, columnDefinition = "發票ID")
    private Integer invoiceid;
    @Column(length = 4, nullable = false, columnDefinition = "編號")
    private Integer item_no;
    @Column(length = 100, columnDefinition = "商品細項品名")
    private String product_name;
    @Column(length = 4, precision = 0, columnDefinition = "數量")
    private Integer quantity;
    @Column(length = 10, precision = 0, columnDefinition = "價格")
    private Integer price;
    @Column(length = 10, precision = 0, columnDefinition = "不含稅價")
    private Integer not_include_tax;
    @Column(length = 10, precision = 0, columnDefinition = "含稅價")
    private Integer tax;
    @Column(length = 10, precision = 0, columnDefinition = "小記")
    private Integer subtotal;
	
        public EPAY_INVOICE_ITEM() {
		super();
	}

    /**
     * @return the invoiceid
     */
    public Integer getInvoiceid() {
        return invoiceid;
    }

    /**
     * @param invoiceid the invoiceid to set
     */
    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

   

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return the not_include_tax
     */
    public Integer getNot_include_tax() {
        return not_include_tax;
    }

    /**
     * @param not_include_tax the not_include_tax to set
     */
    public void setNot_include_tax(Integer not_include_tax) {
        this.not_include_tax = not_include_tax;
    }

    /**
     * @return the tax
     */
    public Integer getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Integer tax) {
        this.tax = tax;
    }

    /**
     * @return the subtotal
     */
    public Integer getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the item_no
     */
    public Integer getItem_no() {
        return item_no;
    }

    /**
     * @param item_no the item_no to set
     */
    public void setItem_no(Integer item_no) {
        this.item_no = item_no;
    }

}
