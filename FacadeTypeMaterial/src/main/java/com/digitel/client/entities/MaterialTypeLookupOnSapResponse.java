
package com.digitel.client.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="materialTypeLookupSapResponse" type="{http://ve.com.digitel/materialTypeLookupSAP/}materialTypeLookupSapResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "materialTypeLookupSapResponse"
})
@XmlRootElement(name = "materialTypeLookupOnSapResponse")
public class MaterialTypeLookupOnSapResponse {

    @XmlElement(required = true)
    protected MaterialTypeLookupSapResponse materialTypeLookupSapResponse;

    /**
     * Gets the value of the materialTypeLookupSapResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialTypeLookupSapResponse }
     *     
     */
    public MaterialTypeLookupSapResponse getMaterialTypeLookupSapResponse() {
        return materialTypeLookupSapResponse;
    }

    /**
     * Sets the value of the materialTypeLookupSapResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialTypeLookupSapResponse }
     *     
     */
    public void setMaterialTypeLookupSapResponse(MaterialTypeLookupSapResponse value) {
        this.materialTypeLookupSapResponse = value;
    }

}
