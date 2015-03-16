
package com.whty.tathing.enterfront.webservice;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>AppPushRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AppPushRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partnerOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="scope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ramSpace" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nvmSpace" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="appPermission" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appSecurityLevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chkOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appRegisterTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="icoUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iogoUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apkUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppPushRequest", propOrder = {
    "appAID",
    "appVersion",
    "partnerOrgCode",
    "appName",
    "appType",
    "appDesc",
    "scope",
    "validate",
    "ramSpace",
    "nvmSpace",
    "appPermission",
    "appSecurityLevel",
    "chkOrgCode",
    "appRegisterTime",
    "icoUrl",
    "iogoUrl",
    "apkUrl"
})
public class AppPushRequest {

    @XmlElement(required = true)
    protected String appAID;
    @XmlElement(required = true)
    protected String appVersion;
    @XmlElement(required = true)
    protected String partnerOrgCode;
    @XmlElement(required = true)
    protected String appName;
    @XmlElement(required = true)
    protected String appType;
    @XmlElement(required = true)
    protected String appDesc;
    @XmlElement(required = true)
    protected String scope;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date validate;
    protected int ramSpace;
    protected int nvmSpace;
    @XmlElement(required = true)
    protected String appPermission;
    @XmlElement(required = true)
    protected String appSecurityLevel;
    @XmlElement(required = true)
    protected String chkOrgCode;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date appRegisterTime;
    @XmlElement(required = true)
    protected String icoUrl;
    @XmlElement(required = true)
    protected String iogoUrl;
    @XmlElement(required = true)
    protected String apkUrl;

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
     * 获取appType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppType() {
        return appType;
    }

    /**
     * 设置appType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppType(String value) {
        this.appType = value;
    }

    /**
     * 获取appDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 设置appDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppDesc(String value) {
        this.appDesc = value;
    }

    /**
     * 获取scope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置scope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * 获取validate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getValidate() {
        return validate;
    }

    /**
     * 设置validate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidate(Date value) {
        this.validate = value;
    }

    /**
     * 获取ramSpace属性的值。
     * 
     */
    public int getRamSpace() {
        return ramSpace;
    }

    /**
     * 设置ramSpace属性的值。
     * 
     */
    public void setRamSpace(int value) {
        this.ramSpace = value;
    }

    /**
     * 获取nvmSpace属性的值。
     * 
     */
    public int getNvmSpace() {
        return nvmSpace;
    }

    /**
     * 设置nvmSpace属性的值。
     * 
     */
    public void setNvmSpace(int value) {
        this.nvmSpace = value;
    }

    /**
     * 获取appPermission属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppPermission() {
        return appPermission;
    }

    /**
     * 设置appPermission属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppPermission(String value) {
        this.appPermission = value;
    }

    /**
     * 获取appSecurityLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppSecurityLevel() {
        return appSecurityLevel;
    }

    /**
     * 设置appSecurityLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppSecurityLevel(String value) {
        this.appSecurityLevel = value;
    }

    /**
     * 获取chkOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChkOrgCode() {
        return chkOrgCode;
    }

    /**
     * 设置chkOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChkOrgCode(String value) {
        this.chkOrgCode = value;
    }

    /**
     * 获取appRegisterTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getAppRegisterTime() {
        return appRegisterTime;
    }

    /**
     * 设置appRegisterTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppRegisterTime(Date value) {
        this.appRegisterTime = value;
    }

    /**
     * 获取icoUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcoUrl() {
        return icoUrl;
    }

    /**
     * 设置icoUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcoUrl(String value) {
        this.icoUrl = value;
    }

    /**
     * 获取iogoUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIogoUrl() {
        return iogoUrl;
    }

    /**
     * 设置iogoUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIogoUrl(String value) {
        this.iogoUrl = value;
    }

    /**
     * 获取apkUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApkUrl() {
        return apkUrl;
    }

    /**
     * 设置apkUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApkUrl(String value) {
        this.apkUrl = value;
    }

}
