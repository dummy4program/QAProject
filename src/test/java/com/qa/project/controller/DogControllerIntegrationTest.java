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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project.entities.Dog;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DogControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
	
	Dog input = new Dog("Dave the Doggo", "Labrador", 3, 43.0);
	String jsonInput = this.mapper.writeValueAsString(input);
	Dog output = new Dog(2L, "Dave the Doggo", "Labrador", 3, 43.0);
	String jsonOutput = this.mapper.writeValueAsString(output);

	mvc.perform(post("/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(jsonInput))
			.andExpect(status().isCreated())
			.andExpect(content().json(jsonOutput));
	}
	
	//Read all
	
	@Test
	public void readTest() throws Exception {
			
		List<Dog> output = new ArrayList<>();
		output.add(new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0));
		String jsonOutput = this.mapper.writeValueAsString(output);
			
		mvc.perform(get("/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonOutput));
	}
	
	//Read by ID
	
	@Test
	public void readIdTest() throws Exception {
			
		Dog output = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
		String jsonOutput = this.mapper.writeValueAsString(output);
			
		mvc.perform(get("/get/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonOutput));
		}
	
	//Update
	
	@Test
	public void updateTest() throws Exception {
			
		Dog inputDog = new Dog("Terry the Terror", "Terrier", 2, 18.0);
		String jsonInput = this.mapper.writeValueAsString(inputDog);
		Dog output = new Dog(1L, "Terry the Terror", "Terrier", 2, 18.0);
		String jsonOutput = this.mapper.writeValueAsString(output);
			
		mvc.perform(put("/update?id=1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInput))
				.andExpect(status().isAccepted())
				.andExpect(content().json(jsonOutput));
		}
	
	@Test
	public void deleteTest() throws Exception {
		
		mvc.perform(delete("/delete/1")).andExpect(status().isNoContent());
	}
	
}
