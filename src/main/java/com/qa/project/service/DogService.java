package com.qa.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.project.entities.Dog;
import com.qa.project.repo.DogRepo;

@Service
public class DogService {

	private DogRepo repo;
	
	public DogService(DogRepo repo) {
		this.repo = repo;
	}
	
	//CRUD functionality methods, communicating with repo
	
	//Create
	
	public Dog addDog(Dog newDog) {
		return this.repo.saveAndFlush(newDog);
	}
	
	//Read all
	
	public List<Dog> getAllDogs() {
		return this.repo.findAll();
	}
	
	//Read by id
	
	public Dog getId(Long id) {
		Dog doggoFound = this.repo.findById(id).orElseThrow();
		return doggoFound;
	} //future functionality of throwing custom exceptions to be added
	
	//Update
	
	public Dog updateDog(Long id, Dog newDog) {
		Optional<Dog> findExisting = this.repo.findById(id);
		Dog existingDog = findExisting.get();
		
		existingDog.setName(newDog.getName());
		existingDog.setBreed(newDog.getBreed());
		existingDog.setAge(newDog.getAge());
		existingDog.setWeight(newDog.getWeight());
		
		return this.repo.saveAndFlush(existingDog);
	}
	
	//Delete
	
	public boolean removeDog(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);  //check if still exists after deletion attempt
		return !exists;
	}
	
}
