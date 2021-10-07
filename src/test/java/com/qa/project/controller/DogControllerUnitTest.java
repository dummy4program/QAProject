package com.qa.project.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project.entities.Dog;
import com.qa.project.service.DogService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DogControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DogService service;
	
	//Create
	
	@Test
	public void createTest() throws Exception {
		Dog input = new Dog("Dave the Doggo", "Labrador", 3, 43.0);
		String jsonInput = this.mapper.writeValueAsString(input);
		Dog output = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
		String jsonOutput = this.mapper.writeValueAsString(output);
	
		Mockito.when(this.service.addDog(input)).thenReturn(output);
	
		mvc.perform(post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInput))
				.andExpect(status().isCreated())
				.andExpect(content().json(jsonOutput));
	
		Mockito.verify(this.service, Mockito.times(1)).addDog(input);
	}
	
	//Read all
	
	@Test
	public void readTest() throws Exception {
		
		List<Dog> output = new ArrayList<>();
		output.add(new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0));
		String jsonOutput = this.mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAllDogs()).thenReturn(output);
		
		mvc.perform(get("/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonOutput));
	
		Mockito.verify(this.service, Mockito.times(1)).getAllDogs();
	}
	
	//Read by ID
	
	@Test
	public void readIdTest() throws Exception {
		
		Long input = 1L;
		Dog output = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
		String jsonOutput = this.mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getId(input)).thenReturn(output);
		
		mvc.perform(get("/get/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonOutput));
	
		Mockito.verify(this.service, Mockito.times(1)).getId(input);
	}
	
	//Update
	
	@Test
	public void updateTest() throws Exception {
		
		Long inputId = 1L;
		Dog inputDog = new Dog("Terry the Terror", "Terrier", 2, 18.0);
		String jsonInput = this.mapper.writeValueAsString(inputDog);
		Dog output = new Dog(1L, "Terry the Terror", "Terrier", 2, 18.0);
		String jsonOutput = this.mapper.writeValueAsString(output);
		
		Mockito.when(this.service.updateDog(inputId,inputDog)).thenReturn(output);
		
		mvc.perform(put("/update?id=1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInput))
				.andExpect(status().isAccepted())
				.andExpect(content().json(jsonOutput));
	
		Mockito.verify(this.service, Mockito.times(1)).updateDog(inputId, inputDog);
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		Long input = 1L;
		boolean existingId = false;
		
		Mockito.when(this.service.removeDog(input)).thenReturn(existingId);
		
		mvc.perform(delete("/delete/1")).andExpect(status().isNoContent());
		
		Mockito.verify(this.service, Mockito.times(1)).removeDog(input);
	}
	
}
