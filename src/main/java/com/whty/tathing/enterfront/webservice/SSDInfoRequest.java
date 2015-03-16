
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SSDInfoRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SSDInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partnerOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ats" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SSDInfoRequest", propOrder = {
    "partnerOrgCode",
    "appAID",
    "cardNO",
    "ats"
})
public class SSDInfoRequest {

    @XmlElement(required = true)
    protected String partnerOrgCode;
    @XmlElement(required = true)
    protected String appAID;
    @XmlElement(required = true)
    protected String cardNO;
    @XmlElement(required = true)
    protected String ats;

    /**
     * 获取partnerOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerOrgCode() {
        return partnerOrgCode;
    }

    /**
     * 设置partnerOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerOrgCode(String value) {
        this.partnerOrgCode = value;
    }

    /**
     * 获取appAID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppAID() {
        return appAID;
    }

    /**
     * 设置appAID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppAID(String value) {
        this.appAID = value;
    }

    /**
     * 获取cardNO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNO() {
        return cardNO;
    }

    /**
     * 设置cardNO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNO(String value) {
        this.cardNO = value;
    }

    /**
     * 获取ats属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAts() {
        return ats;
    }

    /**
     * 设置ats属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAts(String value) {
        this.ats = value;
    }

}
