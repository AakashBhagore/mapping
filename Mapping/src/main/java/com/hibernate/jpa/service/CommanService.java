package com.hibernate.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.jpa.dto.Response;
import com.hibernate.jpa.model.Manager;
import com.hibernate.jpa.repository.DeveloperRepository;
import com.hibernate.jpa.repository.LeadRepository;
import com.hibernate.jpa.repository.ManagerRepository;

@Service
public class CommanService {

	@Autowired private ManagerRepository managerRepository;
	@Autowired private LeadRepository leadRepository;
	@Autowired private DeveloperRepository developerRepository;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public Response fetchAll() {
		Response response = new Response();
		List<Manager> managerDto = managerRepository.findAll();
		 //System.out.println("managerDto:- "+managerDto.toString());
		 boolean flag = managerDto!=null;
		 if(flag) {
			 response.setManagers(managerDto);
		 }
		return response;
	}
}
