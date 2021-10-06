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
	
	//CRUD functionality
	
	//Create
	
	public Dog addDog(Dog doggo) {
		return this.repo.saveAndFlush(doggo);
	}
	
	//Read all
	
	public List<Dog> getAllDogs() {
		return this.repo.findAll();
	}
	
	//Read by id
	
	public Dog getId(Long id) {
		Dog doggoFound = this.repo.findById(id).orElseThrow();
		return doggoFound;
	}
	
	//Update
	
	public Dog updateDog(Long id, Dog newDoggo) {
		Optional<Dog> existing = this.repo.findById(id);
		Dog existingDoggo = existing.get();
		
		existingDoggo.setName(newDoggo.getName());
		existingDoggo.setBreed(newDoggo.getBreed());
		existingDoggo.setAge(newDoggo.getAge());
		existingDoggo.setWeight(newDoggo.getWeight());
		
		return this.repo.saveAndFlush(existingDoggo);
	}
	
	//Delete
	
	public boolean removeDog(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
}
