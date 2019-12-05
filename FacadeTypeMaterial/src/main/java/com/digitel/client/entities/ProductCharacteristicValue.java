
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productCharacteristicValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productCharacteristicValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productSpecCharacteristicValue" type="{http://ve.com.digitel/materialTypeLookupSAP/}productSpecCharacteristicValue"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productCharacteristicValue", propOrder = {
    "value",
    "productSpecCharacteristicValue"
})
public class ProductCharacteristicValue {

    @XmlElement(required = true)
    protected String value;
    @XmlElement(required = true)
    protected ProductSpecCharacteristicValue productSpecCharacteristicValue;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the productSpecCharacteristicValue property.
     * 
     * @return
     *     possible object is
     *     {@link ProductSpecCharacteristicValue }
     *     
     */
    public ProductSpecCharacteristicValue getProductSpecCharacteristicValue() {
    	if(productSpecCharacteristicValue == null){
    		productSpecCharacteristicValue = new ProductSpecCharacteristicValue();
    	} 
        return productSpecCharacteristicValue;
    }

    /**
     * Sets the value of the productSpecCharacteristicValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductSpecCharacteristicValue }
     *     
     */
    public void setProductSpecCharacteristicValue(ProductSpecCharacteristicValue value) {
        this.productSpecCharacteristicValue = value;
    }

}
