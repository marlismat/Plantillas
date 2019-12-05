package com.digitel.common;

import java.io.Serializable;

public class Response implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6710584691339653501L;
	/**
	 * 
	 */

	private Object responseInfo;
	private String responseCode;
	private String responseMsg;

	/**
	 * @param responseInfo
	 * @param responseCode
	 * @param responseMsg
	 */
	public Response(Object responseInfo, String responseCode, String responseMsg) {
		super();
		this.responseInfo = responseInfo;
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the responseInfo
	 */
	public Object getResponseInfo() {
		return responseInfo;
	}

	/**
	 * @param responseInfo
	 *            the responseInfo to set
	 */
	public void setResponseInfo(Object responseInfo) {
		this.responseInfo = responseInfo;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg
	 *            the responseMsg to set
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public static String getNameMethod() {
		return new Exception().getStackTrace()[1].getMethodName();
	}

}
