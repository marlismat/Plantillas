package com.digitel.client;

import com.digitel.client.entities.MaterialTypeLookupOnSapResponse;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("HOLA Mundo");

	LookupMaterial cliente = new LookupMaterial();
	cliente.setWsdl("http://cfglobd05:8701/materialTypeLookupSap/materialTypeLookupSAP?wsdl");
MaterialTypeLookupOnSapResponse response = LookupMaterial.findMaterial("8958021304090730140F","FEATC");

response.getMaterialTypeLookupSapResponse().getCustomerOrder().getId();
System.out.println(response.getMaterialTypeLookupSapResponse().getCustomerOrder().getId());

System.out.println("terminó");
	}

}
