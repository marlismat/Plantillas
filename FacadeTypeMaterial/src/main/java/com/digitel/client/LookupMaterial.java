package com.digitel.client;

import java.util.ArrayList;
import java.util.List;

import com.digitel.client.entities.*;

public class LookupMaterial {
	private static String wsdl; 
	

	public String getWsdl() {
		return wsdl;
	}


	public void setWsdl(String wsdl) {
		LookupMaterial.wsdl = wsdl;
	}


	public static MaterialTypeLookupOnSapResponse findMaterial(String serial, String canal) {
		// TODO Auto-generated method stub
		System.out.println(serial);
		
		SoapClient.setObj(null);	
		    
		MaterialTypeLookupOnSap Request = new MaterialTypeLookupOnSap();
		
		ProductSpecCharacteristicValue productSpecCharacteristicValue =new ProductSpecCharacteristicValue();
		productSpecCharacteristicValue.setValue(serial);
		
		ProductCharacteristicValue productCharacteristicValue =new ProductCharacteristicValue();
		productCharacteristicValue.setValue("SERIAL");
		productCharacteristicValue.setProductSpecCharacteristicValue(productSpecCharacteristicValue);
		
		
		List<ProductCharacteristicValue> list =  new ArrayList<ProductCharacteristicValue>();; 
		list.add(productCharacteristicValue);
		
		CustomerProduct customerProduct = new CustomerProduct();
		customerProduct.setProductCharacteristicValue(list);
		
		CustomerOrderItemRequest customerOrderItem = new CustomerOrderItemRequest();
		customerOrderItem.setCustomerProduct(customerProduct);
		
		
		List<CustomerOrderItemRequest>listCustomerOrderItem = new ArrayList<CustomerOrderItemRequest>();;
		listCustomerOrderItem.add(customerOrderItem);
		
		
		
		CustomerOrderRequest customerOrder = new CustomerOrderRequest();
		customerOrder.setCustomerOrderItem(listCustomerOrderItem);
		
		Party party = new Party();
		party.setName(canal);
		PartyRole partyRole = new PartyRole();
		partyRole.setName("CHANNEL");
		
		partyRole.setParty(party);
		PartyInteractionRole partyInteractionRole = new PartyInteractionRole();
		partyInteractionRole.setPartyRole(partyRole);
		customerOrder.setPartyInteractionRole(partyInteractionRole );
		
		MaterialTypeLookupSapRequest materialTypeLookupSapRequest = new MaterialTypeLookupSapRequest();
		
		materialTypeLookupSapRequest.setCustomerOrder(customerOrder);
		Request.setMaterialTypeLookupSapRequest(materialTypeLookupSapRequest);
		MaterialTypeLookupOnSapResponse objr = null;
		
//		String wsdl = ConfigAdapter.mapConfAuthenticator.get("wsdl");
		String wsdle = wsdl;// "http://cfglobd05:8701/materialTypeLookupSap/materialTypeLookupSAP?wsdl";
		Object obj = new Object();
		try {
			obj = SoapClient.execute(
					wsdle, //"http://cfglobd05:8701/materialTypeLookupSap/materialTypeLookupSAP?wsdl",					
					Request,
					"mat:materialTypeLookupOnSap",
					MaterialTypeLookupOnSap.class,
					MaterialTypeLookupOnSapResponse.class,
					"",
					"xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mat=\"http://ve.com.digitel/materialTypeLookupSAP/\"", 
					obj,
					"materialTypeLookupOnSapResponse"
					,"xmlns:ns2=\"http://ve.com.digitel/materialTypeLookupSAP/\""
				);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 objr = (MaterialTypeLookupOnSapResponse) obj;
		 obj.toString();		
//		System.out.println( objr.getMaterialTypeLookupSapResponse().getCustomerOrder().toString());
		return objr;
	}
	

	
	

}
