
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Capdu complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Capdu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apdu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="compsta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Capdu", propOrder = {
    "apdu",
    "compsta"
})
public class Capdu {

    @XmlElement(required = true)
    protected String apdu;
    @XmlElement(required = true)
    protected String compsta;

    /**
     * 获取apdu属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApdu() {
        return apdu;
    }

    /**
     * 设置apdu属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApdu(String value) {
        this.apdu = value;
    }

    /**
     * 获取compsta属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompsta() {
        return compsta;
    }

    /**
     * 设置compsta属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompsta(String value) {
        this.compsta = value;
    }

}
