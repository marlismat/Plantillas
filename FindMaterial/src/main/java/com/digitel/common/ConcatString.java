package com.digitel.common;

import java.io.Serializable;

public class ConcatString implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1711467030958089628L; //Auto generar 

	public static String generateSms (String... smsToCancat ) {
		
		StringBuilder smsConcatenado = new StringBuilder(); 
		
		for (String sms : smsToCancat) {
			
			if (sms == null) sms = " ";
			
			smsConcatenado.append(sms);
			
		}
		
		return smsConcatenado.toString();
	}
	
}
