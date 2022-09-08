package com.hibernate.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.jpa.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer>{

}
