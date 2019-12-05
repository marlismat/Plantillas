package com.digitel.entities;

import com.digitel.dao.MaterialBusinessBean;

public class SapResponse {

	private MaterialBusinessBean materialBean;
	private String errorCode = "";
	private String errorMessage = "";
	
	
	public MaterialBusinessBean getMaterialBean() {
		return materialBean;
	}
	public void setMaterialBean(MaterialBusinessBean materialBean) {
		this.materialBean = materialBean;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public SapResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
