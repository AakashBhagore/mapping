package com.hibernate.jpa.dto;

import java.util.List;

import com.hibernate.jpa.model.Developer;
import com.hibernate.jpa.model.Lead;

public class ManagerDto {
	
	private String managerName;
	private List<Developer> developerList;
	private List<Lead> leadList;
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public List<Developer> getDeveloperList() {
		return developerList;
	}
	public void setDeveloperList(List<Developer> developerList) {
		this.developerList = developerList;
	}
	public List<Lead> getLeadList() {
		return leadList;
	}
	public void setLeadList(List<Lead> leadList) {
		this.leadList = leadList;
	}
	
	
	

}
