
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerOrderItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerOrderItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerProduct" type="{http://ve.com.digitel/materialTypeLookupSAP/}customerProduct"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerOrderItem", propOrder = {
    "customerProduct"
})
public class CustomerOrderItem {

    @XmlElement(required = true)
    protected CustomerProduct customerProduct;

    /**
     * Gets the value of the customerProduct property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProduct }
     *     
     */
    public CustomerProduct getCustomerProduct() {
    	if(customerProduct == null){
    		customerProduct = new CustomerProduct();
    	}
        return customerProduct;
    }

    /**
     * Sets the value of the customerProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerProduct }
     *     
     */
    public void setCustomerProduct(CustomerProduct value) {
        this.customerProduct = value;
    }

}
