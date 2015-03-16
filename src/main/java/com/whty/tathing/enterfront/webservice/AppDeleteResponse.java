
package com.whty.tathing.enterfront.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AppDeleteResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AppDeleteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rspnMsg" type="{http://www.tathing.com}RspnMsg"/>
 *         &lt;element name="appAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cApdu" type="{http://www.tathing.com}Capdu" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppDeleteResponse", propOrder = {
    "rspnMsg",
    "appAID",
    "appVersion",
    "instAID",
    "cardNO",
    "cApdu"
})
public class AppDeleteResponse {

    @XmlElement(required = true)
    protected RspnMsg rspnMsg;
    @XmlElement(required = true)
    protected String appAID;
    @XmlElement(required = true)
    protected String appVersion;
    @XmlElement(required = true)
    protected String instAID;
    @XmlElement(required = true)
    protected String cardNO;
    @XmlElement(nillable = true)
    protected List<Capdu> cApdu;

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
     * Gets the value of the cApdu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cApdu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCApdu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Capdu }
     * 
     * 
     */
    public List<Capdu> getCApdu() {
        if (cApdu == null) {
            cApdu = new ArrayList<Capdu>();
        }
        return this.cApdu;
    }

}
