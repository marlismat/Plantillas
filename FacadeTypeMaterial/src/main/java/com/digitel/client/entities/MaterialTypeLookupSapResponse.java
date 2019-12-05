
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for materialTypeLookupSapResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="materialTypeLookupSapResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerOrder" type="{http://ve.com.digitel/materialTypeLookupSAP/}CustomerOrderResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materialTypeLookupSapResponse", propOrder = {
    "customerOrder"
})
public class MaterialTypeLookupSapResponse {

    @XmlElement(name = "CustomerOrder", required = true)
    protected CustomerOrderResponse customerOrder;

    /**
     * Gets the value of the customerOrder property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrderResponse }
     *     
     */
    public CustomerOrderResponse getCustomerOrder() {
    	if(customerOrder == null){
    		customerOrder = new CustomerOrderResponse();
    	}
        return customerOrder;
    }

    /**
     * Sets the value of the customerOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrderResponse }
     *     
     */
    public void setCustomerOrder(CustomerOrderResponse value) {
        this.customerOrder = value;
    }

}
