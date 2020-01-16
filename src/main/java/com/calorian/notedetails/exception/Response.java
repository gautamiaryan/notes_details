package com.calorian.notedetails.exception;

import java.io.Serializable;

public class Response implements Serializable {
	
	private int status;
	private String response;
	private Object object;
	public Response(int status, String response) {
		super();
		this.status = status;
		this.response = response;
	}
	public Response(int status, String response, Object object) {
		super();
		this.status = status;
		this.response = response;
		this.object = object;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	
	
	
	
	
	

}