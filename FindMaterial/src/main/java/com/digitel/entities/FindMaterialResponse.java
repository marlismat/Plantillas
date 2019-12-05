package com.digitel.entities;

import java.io.Serializable;

public class FindMaterialResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6175901067329609054L;
	private String Type;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public FindMaterialResponse(String type) {
		super();
		Type = type;
	}
	@Override
	public String toString() {
		return "FindMaterialResponse [Type=" + Type + "]";
	}
	public FindMaterialResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
