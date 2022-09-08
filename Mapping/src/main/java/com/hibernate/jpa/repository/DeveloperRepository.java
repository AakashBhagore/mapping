package com.hibernate.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.jpa.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer>{

}
