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
@Table(name="DEVELOPER")
public class Developer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int developerId;
	
	@Column(name="DEVELOPERNAME")
	private String developerName;
	
	@Column(name="SALARY")
	private double salary;

	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="manager_id")
	@JsonIgnore
	private Manager manager;

// Enable this if you want to store the data from child to parent manager
	public Developer(int developerId, String developerName, double salary, Manager manager) {
		super();
		this.developerId = developerId;
		this.developerName = developerName;
		this.salary = salary;
		this.manager = manager;
	}
	public Developer(String developerName, double salary,Manager manager) {
		super();
		this.developerName = developerName;
		this.salary = salary;
		this.manager=manager;
    }
	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Developer() {
		super();
	}
	
	
}
