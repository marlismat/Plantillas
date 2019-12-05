
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
 *         &lt;element name="MaterialTypeLookupSapRequest" type="{http://ve.com.digitel/materialTypeLookupSAP/}MaterialTypeLookupSapRequest"/>
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
    "materialTypeLookupSapRequest"
})
@XmlRootElement(name = "materialTypeLookupOnSap")
public class MaterialTypeLookupOnSap {

    @XmlElement(name = "MaterialTypeLookupSapRequest", required = true)
    protected MaterialTypeLookupSapRequest materialTypeLookupSapRequest;

    /**
     * Gets the value of the materialTypeLookupSapRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialTypeLookupSapRequest }
     *     
     */
    public MaterialTypeLookupSapRequest getMaterialTypeLookupSapRequest() {
        return materialTypeLookupSapRequest;
    }

    /**
     * Sets the value of the materialTypeLookupSapRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialTypeLookupSapRequest }
     *     
     */
    public void setMaterialTypeLookupSapRequest(MaterialTypeLookupSapRequest value) {
        this.materialTypeLookupSapRequest = value;
    }

}
