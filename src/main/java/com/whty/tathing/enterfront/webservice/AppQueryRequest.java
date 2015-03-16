
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AppQueryRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AppQueryRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appInstalledTag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppQueryRequest", propOrder = {
    "seID",
    "appInstalledTag"
})
public class AppQueryRequest {

    @XmlElement(required = true)
    protected String seID;
    @XmlElement(required = true)
    protected String appInstalledTag;

    /**
     * 获取seID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeID() {
        return seID;
    }

    /**
     * 设置seID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeID(String value) {
        this.seID = value;
    }

    /**
     * 获取appInstalledTag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppInstalledTag() {
        return appInstalledTag;
    }

    /**
     * 设置appInstalledTag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppInstalledTag(String value) {
        this.appInstalledTag = value;
    }

}
