
package com.whty.tathing.enterfront.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreatSSDRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreatSSDRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partnerOrgCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cardNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ats" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssdAID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rApdu" type="{http://www.tathing.com}Rapdu" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatSSDRequest", propOrder = {
    "partnerOrgCode",
    "cardNO",
    "ats",
    "ssdAID",
    "rApdu"
})
public class CreatSSDRequest {

    @XmlElement(required = true)
    protected String partnerOrgCode;
    @XmlElement(required = true)
    protected String cardNO;
    @XmlElement(required = true)
    protected String ats;
    @XmlElement(required = true)
    protected String ssdAID;
    @XmlElement(nillable = true)
    protected List<Rapdu> rApdu;

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
     * Gets the value of the rApdu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rApdu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRApdu().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rapdu }
     * 
     * 
     */
    public List<Rapdu> getRApdu() {
        if (rApdu == null) {
            rApdu = new ArrayList<Rapdu>();
        }
        return this.rApdu;
    }

}
