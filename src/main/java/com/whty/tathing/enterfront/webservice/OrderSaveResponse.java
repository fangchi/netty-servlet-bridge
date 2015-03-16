
package com.whty.tathing.enterfront.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OrderSaveResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OrderSaveResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rspnMsg" type="{http://www.tathing.com}RspnMsg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderSaveResponse", propOrder = {
    "rspnMsg"
})
public class OrderSaveResponse {

    @XmlElement(required = true)
    protected RspnMsg rspnMsg;

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

}
