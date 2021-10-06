package com.qa.project.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dog")
public class Dog {

	//Attributes
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String breed;
	private int age;
	private double weight;
	
	
	
	//Constructor
	
	public Dog(Long id, String name, String breed, int age, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
	}
	
	public Dog(String name, String breed, int age, double weight) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
	}
	
	public Dog() {
		
	}
	
	//Getters and setters

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//hashCode and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(age, breed, id, name, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return age == other.age && Objects.equals(breed, other.breed) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", age=" + age + ", weight=" + weight + "]";
	}
	
}
