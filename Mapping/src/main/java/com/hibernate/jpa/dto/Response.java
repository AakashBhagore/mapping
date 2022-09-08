package com.hibernate.jpa.dto;

import java.util.List;

import com.hibernate.jpa.model.Manager;

public class Response {

	private List<Manager> managers;
	private String status;
	private int statusCode;
	

	public List<Manager> getManagers() {
		return managers;
	}
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", statusCode=" + statusCode + "]";
	}
	
	
}
