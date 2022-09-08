package com.hibernate.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.jpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
