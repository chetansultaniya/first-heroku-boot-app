package com.internship2.demo1.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {

	private Integer status;
	private String message;
	private String detail;
	
	public Response() {
	}

	public Response(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(Integer status, String message, String detail) {
		this.status = status;
		this.message = message;
		this.detail = detail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
