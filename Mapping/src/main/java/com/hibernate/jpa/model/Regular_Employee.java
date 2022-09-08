package com.hibernate.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REGULAREMPLOYEE")
public class Regular_Employee extends Employee{

	@Column(name="SALARY") 
	private double salary;
	
	@Column(name="BONUS")
	private int bonus;

	public Regular_Employee() {
		super();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double d) {
		this.salary = d;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
