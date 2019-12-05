
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MaterialTypeLookupSapRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaterialTypeLookupSapRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerOrder" type="{http://ve.com.digitel/materialTypeLookupSAP/}CustomerOrderRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaterialTypeLookupSapRequest", propOrder = {
    "customerOrder"
})
public class MaterialTypeLookupSapRequest {

    @XmlElement(name = "CustomerOrder", required = true)
    protected CustomerOrderRequest customerOrder;

    /**
     * Gets the value of the customerOrder property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrderRequest }
     *     
     */
    public CustomerOrderRequest getCustomerOrder() {
        return customerOrder;
    }

    /**
     * Sets the value of the customerOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrderRequest }
     *     
     */
    public void setCustomerOrder(CustomerOrderRequest value) {
        this.customerOrder = value;
    }

}
