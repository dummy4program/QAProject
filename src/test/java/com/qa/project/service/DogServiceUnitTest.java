package com.qa.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.project.entities.Dog;
import com.qa.project.repo.DogRepo;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceUnitTest {

	@InjectMocks
	private DogService service;
	
	@Mock
	private DogRepo repo;
	
	//Create
	
	@Test
	public void createTest() {
		
		Dog input = new Dog("Dave the Doggo", "Labrador", 3, 43.0);
		Dog output = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
				
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.addDog(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	//Read all
	
	@Test
	public void getAllDogs() {
		
		List<Dog> output = new ArrayList<>();
		output.add(new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAllDogs());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	//Read by ID
	
	@Test
	public void getId() {
		
		Long input = 1L;
		Dog output = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
		
		Mockito.when(this.repo.findById(input)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getId(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(input);
	}
	
	//Update
	
	@Test
	public void updateDog() {
		
		Long inputId = 1L;
		Dog inputDog = new Dog("Terry the Terror", "Terrier", 2, 18.0);
		Dog existingDog = new Dog(1L, "Dave the Doggo", "Labrador", 3, 43.0);
		Dog output = new Dog(1L, "Terry the Terror", "Terrier", 2, 18.0);
		
		Mockito.when(this.repo.findById(inputId)).thenReturn(Optional.of(existingDog));
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.updateDog(inputId, inputDog));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(inputId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
		
	}
	
	//Delete
	
	@Test
	public void removeDog() {
		
		Long input = 1L;
		boolean existingId = false;
//		boolean output = true; //only used in alternate method
		
		Mockito.doNothing().when(this.repo).deleteById(input);
		Mockito.when(this.repo.existsById(input)).thenReturn(existingId);
		
		
		assertTrue(this.service.removeDog(input));
		//alternative
//		assertEquals(output, this.service.removeDog(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(input);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(input);
		
	}
	
}