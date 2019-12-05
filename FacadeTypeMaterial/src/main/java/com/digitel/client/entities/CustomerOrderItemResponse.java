
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerOrderItemResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerOrderItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerProduct" type="{http://ve.com.digitel/materialTypeLookupSAP/}customerProduct"/>
 *         &lt;element name="functionalMessage" type="{http://ve.com.digitel/materialTypeLookupSAP/}functionalMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerOrderItemResponse", propOrder = {
    "id",
    "customerProduct",
    "functionalMessage"
})
public class CustomerOrderItemResponse {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected CustomerProduct customerProduct;
    @XmlElement(required = true)
    protected FunctionalMessage functionalMessage;

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

    /**
     * Gets the value of the functionalMessage property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalMessage }
     *     
     */
    public FunctionalMessage getFunctionalMessage() {
        return functionalMessage;
    }

    /**
     * Sets the value of the functionalMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalMessage }
     *     
     */
    public void setFunctionalMessage(FunctionalMessage value) {
        this.functionalMessage = value;
    }

}
