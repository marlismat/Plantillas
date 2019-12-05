package com.digitel.entities;

import java.io.Serializable;

public class Sap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2243296145300603790L;
	
	private String InputSap;

	public Sap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sap(String inputSap) {
		super();
		InputSap = inputSap;
	}

	public String getInputSap() {
		return InputSap;
	}

	public void setInputSap(String inputSap) {
		InputSap = inputSap;
	}

	@Override
	public String toString() {
		return "Sap [InputSap=" + InputSap + "]";
	}
	
	
	
	
	
	

}
