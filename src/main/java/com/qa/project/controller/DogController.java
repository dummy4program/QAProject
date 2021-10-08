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
	
	//mapping HTTP requests to service CRUD methods and setting HTTP response codes for successful execution
	
	//Create
	
	@PostMapping("/create")
	public ResponseEntity<Dog> addDog(@RequestBody Dog newDog) {
		return new ResponseEntity<Dog>(this.service.addDog(newDog), HttpStatus.CREATED);
	}
	
	//Read
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return new ResponseEntity<List<Dog>>(this.service.getAllDogs(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Dog> getId(@PathVariable Long id) {
		return new ResponseEntity<Dog>(this.service.getId(id), HttpStatus.OK);
	} //example of PathVariable usage here would be ..."/get/1" at the end of URL path for entry with id 1
	
	//Update
	
	@PutMapping("/update")
	public ResponseEntity<Dog> updateDog(@PathParam("id") Long id, @RequestBody Dog newDog) {
		return new ResponseEntity<Dog>(this.service.updateDog(id, newDog), HttpStatus.ACCEPTED);
	} //example of PathParam usage here would be ..."/update?id=2" at the end of URL path for entry with id 2
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> removeDog(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.removeDog(id), HttpStatus.NO_CONTENT);
	} //example of PathVariable usage here would be ..."/delete/3" at the end of URL path for entry with id 3
	
}
