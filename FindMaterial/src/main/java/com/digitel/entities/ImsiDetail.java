package com.digitel.entities;

import java.io.Serializable;

public class ImsiDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6058430412708430123L;
	
	
	
	private String msisdn;
	private String iccid;
	private String imsi;
	private String type;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
 
	
	public ImsiDetail(String msisdn, String iccid, String imsi, String type) {
		super();
		this.msisdn = msisdn;
		this.iccid = iccid;
		this.imsi = imsi;
		this.type = type;
	}
	
	public ImsiDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ImsiDetail [msisdn=" + msisdn + ", iccid=" + iccid + ", imsi=" + imsi + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
