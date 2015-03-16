
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PublicKeyRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PublicKeyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partnerOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicKeyRequest", propOrder = {
    "partnerOrgCode",
    "keyType"
})
public class PublicKeyRequest {

    @XmlElement(required = true)
    protected String partnerOrgCode;
    @XmlElement(required = true)
    protected String keyType;

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
     * 获取keyType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * 设置keyType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyType(String value) {
        this.keyType = value;
    }

}
