package com.hibernate.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTACTEMPLOYEE")
public class Contact_Employee extends Employee{

	@Column(name="PAY_PER_HOUR") 
	private float pay_per_hour;
	
	@Column(name="CONTACT_DURATION")
	private String contact_duration;

	public float getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContact_duration() {
		return contact_duration;
	}

	public void setContact_duration(String contact_duration) {
		this.contact_duration = contact_duration;
	}

	public Contact_Employee() {
		super();
	}
	
	
	
}
