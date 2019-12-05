
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerOrderItemRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerOrderItemRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "customerOrderItemRequest", propOrder = {
    "id",
    "customerProduct"
})
public class CustomerOrderItemRequest {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected CustomerProduct customerProduct;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the customerProduct property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProduct }
     *     
     */
    public CustomerProduct getCustomerProduct() {
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
