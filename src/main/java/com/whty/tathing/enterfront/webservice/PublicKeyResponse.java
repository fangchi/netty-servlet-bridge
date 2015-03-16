
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PublicKeyResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PublicKeyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rspnMsg" type="{http://www.tathing.com}RspnMsg"/>
 *         &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicKeyResponse", propOrder = {
    "rspnMsg",
    "publicKey",
    "algorithm"
})
public class PublicKeyResponse {

    @XmlElement(required = true)
    protected RspnMsg rspnMsg;
    @XmlElement(required = true)
    protected String publicKey;
    @XmlElement(required = true)
    protected String algorithm;

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
     * 获取publicKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 设置publicKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicKey(String value) {
        this.publicKey = value;
    }

    /**
     * 获取algorithm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * 设置algorithm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

}
