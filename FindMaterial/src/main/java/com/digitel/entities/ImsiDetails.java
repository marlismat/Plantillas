package com.digitel.entities;

import java.io.Serializable;
import java.util.List;

public class ImsiDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7427391500460343027L;
	
	private List<ImsiDetail> imsiDetails;

	public List<ImsiDetail> getImsiDetails() {
		return imsiDetails;
	}

	public void setImsiDetails(List<ImsiDetail> imsiDetails) {
		this.imsiDetails = imsiDetails;
	}

	public ImsiDetails(List<ImsiDetail> imsiDetails) {
		super();
		this.imsiDetails = imsiDetails;
	}

	public ImsiDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ImsiDetails [imsiDetails=" + imsiDetails + "]";
	}
	
	

}
