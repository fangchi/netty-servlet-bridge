
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OrderSaveRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OrderSaveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ditchNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobileSupplier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operateType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="splittingCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tradeTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tradeSerialNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orderTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderSaveRequest", propOrder = {
    "code",
    "seId",
    "uid",
    "appId",
    "appName",
    "cardNo",
    "ditchNo",
    "mobileSupplier",
    "partner",
    "operateType",
    "splittingCode",
    "orderAmount",
    "tradeTime",
    "tradeSerialNo",
    "orderTime"
})
public class OrderSaveRequest {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String seId;
    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    protected String appId;
    @XmlElement(required = true)
    protected String appName;
    @XmlElement(required = true)
    protected String cardNo;
    @XmlElement(required = true)
    protected String ditchNo;
    @XmlElement(required = true)
    protected String mobileSupplier;
    @XmlElement(required = true)
    protected String partner;
    @XmlElement(required = true)
    protected String operateType;
    @XmlElement(required = true)
    protected String splittingCode;
    @XmlElement(required = true)
    protected String orderAmount;
    @XmlElement(required = true)
    protected String tradeTime;
    @XmlElement(required = true)
    protected String tradeSerialNo;
    @XmlElement(required = true)
    protected String orderTime;

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * 获取seId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeId() {
        return seId;
    }

    /**
     * 设置seId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeId(String value) {
        this.seId = value;
    }

    /**
     * 获取uid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * 获取appId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * 获取appName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置appName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * 获取cardNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置cardNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNo(String value) {
        this.cardNo = value;
    }

    /**
     * 获取ditchNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDitchNo() {
        return ditchNo;
    }

    /**
     * 设置ditchNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDitchNo(String value) {
        this.ditchNo = value;
    }

    /**
     * 获取mobileSupplier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileSupplier() {
        return mobileSupplier;
    }

    /**
     * 设置mobileSupplier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileSupplier(String value) {
        this.mobileSupplier = value;
    }

    /**
     * 获取partner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartner() {
        return partner;
    }

    /**
     * 设置partner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartner(String value) {
        this.partner = value;
    }

    /**
     * 获取operateType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * 设置operateType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateType(String value) {
        this.operateType = value;
    }

    /**
     * 获取splittingCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplittingCode() {
        return splittingCode;
    }

    /**
     * 设置splittingCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplittingCode(String value) {
        this.splittingCode = value;
    }

    /**
     * 获取orderAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置orderAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderAmount(String value) {
        this.orderAmount = value;
    }

    /**
     * 获取tradeTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置tradeTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeTime(String value) {
        this.tradeTime = value;
    }

    /**
     * 获取tradeSerialNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeSerialNo() {
        return tradeSerialNo;
    }

    /**
     * 设置tradeSerialNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeSerialNo(String value) {
        this.tradeSerialNo = value;
    }

    /**
     * 获取orderTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * 设置orderTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderTime(String value) {
        this.orderTime = value;
    }

}
