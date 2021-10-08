package com.qa.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.project.entities.Dog;

public interface DogRepo extends JpaRepository<Dog, Long>{

	//communicates with the database
	
}