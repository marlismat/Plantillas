
package com.digitel.client.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerOrderResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerOrderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerOrderType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerOrderItem" type="{http://ve.com.digitel/materialTypeLookupSAP/}customerOrderItemResponse" maxOccurs="unbounded"/>
 *         &lt;element name="functionalMessage" type="{http://ve.com.digitel/materialTypeLookupSAP/}functionalMessage"/>
 *         &lt;element name="errorMessage" type="{http://ve.com.digitel/materialTypeLookupSAP/}errorMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrderResponse", propOrder = {
    "id",
    "customerOrderType",
    "customerOrderItem",
    "functionalMessage",
    "errorMessage"
})

public class CustomerOrderResponse {

    public void setCustomerOrderItem(List<CustomerOrderItemResponse> customerOrderItem) {
		this.customerOrderItem = customerOrderItem;
	}

	@XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String customerOrderType;
    @XmlElement(required = true)
    protected List<CustomerOrderItemResponse> customerOrderItem;
    @XmlElement(required = true)
    protected FunctionalMessage functionalMessage;
    @XmlElement(required = true)
    protected ErrorMessage errorMessage;

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
     * Gets the value of the customerOrderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerOrderType() {
        return customerOrderType;
    }

    /**
     * Sets the value of the customerOrderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerOrderType(String value) {
        this.customerOrderType = value;
    }

    /**
     * Gets the value of the customerOrderItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerOrderItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerOrderItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerOrderItemResponse }
     * 
     * 
     */
    public List<CustomerOrderItemResponse> getCustomerOrderItem() {
        if (customerOrderItem == null) {
            customerOrderItem = new ArrayList<CustomerOrderItemResponse>();
        }
        return this.customerOrderItem;
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

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessage }
     *     
     */
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessage }
     *     
     */
    public void setErrorMessage(ErrorMessage value) {
        this.errorMessage = value;
    }

}
