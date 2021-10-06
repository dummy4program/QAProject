package com.qa.project.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.entities.Dog;
import com.qa.project.service.DogService;

@RestController
public class DogController {

	private DogService service;
	
	public DogController(DogService service) {
		this.service = service;
	}
	
	//CRUD HTTP request mapping
	
	//Create
	
	@PostMapping("/create")
	public ResponseEntity<Dog> addDog(@RequestBody Dog doggo) {
		return new ResponseEntity<Dog>(this.service.addDog(doggo), HttpStatus.CREATED);
	}
	
	//Read
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return new ResponseEntity<List<Dog>>(this.service.getAllDogs(), HttpStatus.OK);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Dog> getId(@PathVariable Long id) {
		return new ResponseEntity<Dog>(this.service.getId(id), HttpStatus.OK);
	}
	
	//Update
	
	@PutMapping("/update")
	public ResponseEntity<Dog> updateDog(@PathParam("id") Long id, @RequestBody Dog doggo) {
		return new ResponseEntity<Dog>(this.service.updateDog(id, doggo), HttpStatus.ACCEPTED);
	}
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> removeDog(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.removeDog(id), HttpStatus.NO_CONTENT);
	}
	
}
