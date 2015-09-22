package org.foodie.server.infor;

import java.io.Serializable;

/**
 * 
 * @author Danyang Li
 *
 */
public class Infor implements Serializable{
	private static final long serialVersionUID = 1L;
	private String statusInfo;
	private Integer statusCode = StatusCode.NORMAL;
	public Infor() {
		
	}
	
	public Infor (final String errorInfo, final Integer statusCode) {
		this.statusInfo = errorInfo;
		this.statusCode = statusCode;
	}
	
	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String errorInfo) {
		this.statusInfo = errorInfo;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
