
package com.digitel.client.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerOrderRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerOrderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerOrderType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerOrderItem" type="{http://ve.com.digitel/materialTypeLookupSAP/}customerOrderItemRequest" maxOccurs="unbounded"/>
 *         &lt;element name="partyInteractionRole" type="{http://ve.com.digitel/materialTypeLookupSAP/}partyInteractionRole"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrderRequest", propOrder = {
    "id",
    "customerOrderType",
    "customerOrderItem",
    "partyInteractionRole"
})
public class CustomerOrderRequest {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String customerOrderType;
    @XmlElement(required = true)
    protected List<CustomerOrderItemRequest> customerOrderItem;
    @XmlElement(required = true)
    protected PartyInteractionRole partyInteractionRole;

    public void setCustomerOrderItem(List<CustomerOrderItemRequest> customerOrderItem) {
		this.customerOrderItem = customerOrderItem;
	}

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
     * {@link CustomerOrderItemRequest }
     * 
     * 
     */
    public List<CustomerOrderItemRequest> getCustomerOrderItem() {
        if (customerOrderItem == null) {
            customerOrderItem = new ArrayList<CustomerOrderItemRequest>();
        }
        return this.customerOrderItem;
    }

    /**
     * Gets the value of the partyInteractionRole property.
     * 
     * @return
     *     possible object is
     *     {@link PartyInteractionRole }
     *     
     */
    public PartyInteractionRole getPartyInteractionRole() {
        return partyInteractionRole;
    }

    /**
     * Sets the value of the partyInteractionRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyInteractionRole }
     *     
     */
    public void setPartyInteractionRole(PartyInteractionRole value) {
        this.partyInteractionRole = value;
    }

}
