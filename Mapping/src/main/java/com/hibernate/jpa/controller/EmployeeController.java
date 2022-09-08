/**
 * 
 */
package com.hibernate.jpa.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.jpa.dto.Response;
import com.hibernate.jpa.model.Contact_Employee;
import com.hibernate.jpa.model.Developer;
import com.hibernate.jpa.model.Employee;
import com.hibernate.jpa.model.Lead;
import com.hibernate.jpa.model.Manager;
import com.hibernate.jpa.model.Regular_Employee;
import com.hibernate.jpa.repository.DeveloperRepository;
import com.hibernate.jpa.repository.EmployeeRepository;
import com.hibernate.jpa.repository.ManagerRepository;
import com.hibernate.jpa.service.CommanService;

/**
 * @author System - 35
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Autowired private ManagerRepository managerRepository;
	
	@Autowired private DeveloperRepository developerRepository;
	
	@Autowired private CommanService commanService;
	
	@GetMapping("/saveData")
	public String  saveData() {
		Employee emp = new Employee();
		emp.setEmployeeName("Aakash");
		
		Regular_Employee regularEmployee = new Regular_Employee();
		regularEmployee.setSalary(25000.00);
		regularEmployee.setBonus(1000);
		
		Contact_Employee contactEmployee = new Contact_Employee();
		contactEmployee.setPay_per_hour(250);
		contactEmployee.setContact_duration("1Month");
		
        employeeRepository.save(emp);
		employeeRepository.save(regularEmployee);
		employeeRepository.save(contactEmployee);
		return "success";
	}
	
	@PostMapping("/manager")// from child to parent data saving
	public Response saveManager() {
		Response response = new Response();
		Lead lead = new Lead();
		lead.setLeadName("Lokesh ingle");
		List<Lead> leadList = new ArrayList<>();
		leadList.add(lead);
		Manager manager = new Manager();
		manager.setManagerName("vikar sing");
		manager.setLead(leadList);
		managerRepository.save(manager);
		List<Developer> developerList = Arrays.asList(new Developer(0,"rakesh",10000.00,manager),new Developer(0,"harsh",15000,manager));
		boolean flag = developerRepository.saveAll(developerList) != null;
		if(flag==true) {
			response.setStatus("success");
			response.setStatusCode(1);
		}
		return response;
	}
	
	@PostMapping("/save")// from parent to child entities
	public Response saveManagerData() {
		Response response = new Response();
		try {
			Manager manager = new Manager();
			manager.setManagerName("Vikram Rathod");

			List<Developer> developer = Arrays.asList(new Developer("Steve jobs", 100000.00,manager),new Developer("mark zuckerberg",7508.00D,manager));
			List<Lead> leadList =Arrays.asList(new Lead("Mark zuckerberg",manager), new Lead("Mark zuckerberg",manager));
			manager.setDeveloper(developer);
			manager.setLead(leadList);
			boolean result = managerRepository.save(manager)!=null;
			if(result==true) {
				response.setStatus("success");
				response.setStatusCode(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Result:- "+response.toString());
		return response;
	}
	
	@DeleteMapping("/remove")
	public String removeData() {
		managerRepository.deleteAll();
		return "sucess";
	}
	
	@PostMapping("/fetch")
	public Response fetchData() {
		Response response = commanService.fetchAll();
		 response.setStatus("success"); 
		 response.setStatusCode(1);
		return response;
	}
}
