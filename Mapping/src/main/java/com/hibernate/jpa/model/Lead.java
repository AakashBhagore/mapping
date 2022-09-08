package com.hibernate.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="LEAD")
public class Lead{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LEADID")
	private int leadId; 
	
	@Column(name="LEADLEAD")
	private String leadName;

	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="manager_id")
	@JsonIgnore
	private Manager managers;
	
	public Lead(String leadName,Manager manager) {
		super();
		this.leadName = leadName;
		this.managers = manager;
	}

	public Lead() {
		super();
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	
	
}
