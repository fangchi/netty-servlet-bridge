
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AppDownloadResultNotifyRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AppDownloadResultNotifyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partnerOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ats" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instRes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppDownloadResultNotifyRequest", propOrder = {
    "partnerOrgCode",
    "appAID",
    "appVersion",
    "cardNO",
    "instAID",
    "ssdAID",
    "ats",
    "instRes"
})
public class AppDownloadResultNotifyRequest {

    @XmlElement(required = true)
    protected String partnerOrgCode;
    @XmlElement(required = true)
    protected String appAID;
    @XmlElement(required = true)
    protected String appVersion;
    @XmlElement(required = true)
    protected String cardNO;
    @XmlElement(required = true)
    protected String instAID;
    @XmlElement(required = true)
    protected String ssdAID;
    @XmlElement(required = true)
    protected String ats;
    @XmlElement(required = true)
    protected String instRes;

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
     * 获取appVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * 设置appVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppVersion(String value) {
        this.appVersion = value;
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
     * 获取instAID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstAID() {
        return instAID;
    }

    /**
     * 设置instAID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstAID(String value) {
        this.instAID = value;
    }

    /**
     * 获取ssdAID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdAID() {
        return ssdAID;
    }

    /**
     * 设置ssdAID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdAID(String value) {
        this.ssdAID = value;
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

    /**
     * 获取instRes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstRes() {
        return instRes;
    }

    /**
     * 设置instRes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstRes(String value) {
        this.instRes = value;
    }

}
