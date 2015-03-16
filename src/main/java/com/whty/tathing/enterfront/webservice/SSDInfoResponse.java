
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SSDInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SSDInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rspnMsg" type="{http://www.tathing.com}RspnMsg"/>
 *         &lt;element name="ssdAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdEncKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdEncKeyChkVal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdMacKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdMacKeyChkVal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdDekKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdDekKeyChkVal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encKeyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encKeyVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="macKeyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="macKeyVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dekKeyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dekKeyVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dapKeyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dapKeyVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tokenKeyID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tokenKeyVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SSDInfoResponse", propOrder = {
    "rspnMsg",
    "ssdAID",
    "ssdEncKey",
    "ssdEncKeyChkVal",
    "ssdMacKey",
    "ssdMacKeyChkVal",
    "ssdDekKey",
    "ssdDekKeyChkVal",
    "encKeyID",
    "encKeyVer",
    "macKeyID",
    "macKeyVer",
    "dekKeyID",
    "dekKeyVer",
    "dapKeyID",
    "dapKeyVer",
    "tokenKeyID",
    "tokenKeyVer"
})
public class SSDInfoResponse {

    @XmlElement(required = true)
    protected RspnMsg rspnMsg;
    @XmlElement(required = true)
    protected String ssdAID;
    @XmlElement(required = true)
    protected String ssdEncKey;
    @XmlElement(required = true)
    protected String ssdEncKeyChkVal;
    @XmlElement(required = true)
    protected String ssdMacKey;
    @XmlElement(required = true)
    protected String ssdMacKeyChkVal;
    @XmlElement(required = true)
    protected String ssdDekKey;
    @XmlElement(required = true)
    protected String ssdDekKeyChkVal;
    @XmlElement(required = true)
    protected String encKeyID;
    @XmlElement(required = true)
    protected String encKeyVer;
    @XmlElement(required = true)
    protected String macKeyID;
    @XmlElement(required = true)
    protected String macKeyVer;
    @XmlElement(required = true)
    protected String dekKeyID;
    @XmlElement(required = true)
    protected String dekKeyVer;
    @XmlElement(required = true)
    protected String dapKeyID;
    @XmlElement(required = true)
    protected String dapKeyVer;
    @XmlElement(required = true)
    protected String tokenKeyID;
    @XmlElement(required = true)
    protected String tokenKeyVer;

    /**
     * 获取rspnMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RspnMsg }
     *     
     */
    public RspnMsg getRspnMsg() {
        return rspnMsg;
    }

    /**
     * 设置rspnMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RspnMsg }
     *     
     */
    public void setRspnMsg(RspnMsg value) {
        this.rspnMsg = value;
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
     * 获取ssdEncKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdEncKey() {
        return ssdEncKey;
    }

    /**
     * 设置ssdEncKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdEncKey(String value) {
        this.ssdEncKey = value;
    }

    /**
     * 获取ssdEncKeyChkVal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdEncKeyChkVal() {
        return ssdEncKeyChkVal;
    }

    /**
     * 设置ssdEncKeyChkVal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdEncKeyChkVal(String value) {
        this.ssdEncKeyChkVal = value;
    }

    /**
     * 获取ssdMacKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdMacKey() {
        return ssdMacKey;
    }

    /**
     * 设置ssdMacKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdMacKey(String value) {
        this.ssdMacKey = value;
    }

    /**
     * 获取ssdMacKeyChkVal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdMacKeyChkVal() {
        return ssdMacKeyChkVal;
    }

    /**
     * 设置ssdMacKeyChkVal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdMacKeyChkVal(String value) {
        this.ssdMacKeyChkVal = value;
    }

    /**
     * 获取ssdDekKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdDekKey() {
        return ssdDekKey;
    }

    /**
     * 设置ssdDekKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdDekKey(String value) {
        this.ssdDekKey = value;
    }

    /**
     * 获取ssdDekKeyChkVal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdDekKeyChkVal() {
        return ssdDekKeyChkVal;
    }

    /**
     * 设置ssdDekKeyChkVal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdDekKeyChkVal(String value) {
        this.ssdDekKeyChkVal = value;
    }

    /**
     * 获取encKeyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncKeyID() {
        return encKeyID;
    }

    /**
     * 设置encKeyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncKeyID(String value) {
        this.encKeyID = value;
    }

    /**
     * 获取encKeyVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncKeyVer() {
        return encKeyVer;
    }

    /**
     * 设置encKeyVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncKeyVer(String value) {
        this.encKeyVer = value;
    }

    /**
     * 获取macKeyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacKeyID() {
        return macKeyID;
    }

    /**
     * 设置macKeyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacKeyID(String value) {
        this.macKeyID = value;
    }

    /**
     * 获取macKeyVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacKeyVer() {
        return macKeyVer;
    }

    /**
     * 设置macKeyVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacKeyVer(String value) {
        this.macKeyVer = value;
    }

    /**
     * 获取dekKeyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDekKeyID() {
        return dekKeyID;
    }

    /**
     * 设置dekKeyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDekKeyID(String value) {
        this.dekKeyID = value;
    }

    /**
     * 获取dekKeyVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDekKeyVer() {
        return dekKeyVer;
    }

    /**
     * 设置dekKeyVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDekKeyVer(String value) {
        this.dekKeyVer = value;
    }

    /**
     * 获取dapKeyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDapKeyID() {
        return dapKeyID;
    }

    /**
     * 设置dapKeyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDapKeyID(String value) {
        this.dapKeyID = value;
    }

    /**
     * 获取dapKeyVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDapKeyVer() {
        return dapKeyVer;
    }

    /**
     * 设置dapKeyVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDapKeyVer(String value) {
        this.dapKeyVer = value;
    }

    /**
     * 获取tokenKeyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenKeyID() {
        return tokenKeyID;
    }

    /**
     * 设置tokenKeyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenKeyID(String value) {
        this.tokenKeyID = value;
    }

    /**
     * 获取tokenKeyVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenKeyVer() {
        return tokenKeyVer;
    }

    /**
     * 设置tokenKeyVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenKeyVer(String value) {
        this.tokenKeyVer = value;
    }

}
