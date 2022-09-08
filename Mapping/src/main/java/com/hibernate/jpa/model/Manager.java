package com.hibernate.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
 
@Entity
@Table(name="MANAGER") 
public class Manager{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int managerId;
	
	@Column(name="MANAGERNAME")
	private String managerName;
	
	@OneToMany(mappedBy = "manager",fetch =FetchType.EAGER ,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Developer> developer;	
	
	@OneToMany(mappedBy="managers",fetch =FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Lead> lead;

	public Manager() {
		super();
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<Lead> getLead() {
		return lead;
	}

	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}

	public List<Developer> getDeveloper() {
		return developer;
	}

	public void setDeveloper(List<Developer> developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", developer=" + developer
				+ ", lead=" + lead + "]";
	}
	
}
