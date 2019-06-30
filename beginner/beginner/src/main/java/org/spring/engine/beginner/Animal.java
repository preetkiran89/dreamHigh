package org.spring.engine.beginner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Animal {

	private String name;
	private String ownerOfAnimal;
	private List<String> animals;
	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Triangle> triangles = new HashMap<String, Triangle>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerOfAnimal() {
		return ownerOfAnimal;
	}
	public void setOwnerOfAnimal(String ownerOfAnimal) {
		this.ownerOfAnimal = ownerOfAnimal;
	}
	
	public List<String> getAnimals() {
		return animals;
	}
	public void setAnimals(List<String> animals) {
		this.animals = animals;
	}
	
	public Map<String, String> getFoods() {
		return foods;
	}
	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}
	
	public Map<String, Triangle> getTriangles() {
		return triangles;
	}
	public void setTriangles(Map<String, Triangle> triangles) {
		this.triangles = triangles;
	}
	@Override
	public String toString() {
		for(Entry<String, Triangle> e : triangles.entrySet()) {
		System.out.println("For Animal - key is:" + e.getKey() );
		e.getValue().draw();
		}
		return "Animal [name=" + name + ", ownerOfAnimal=" + ownerOfAnimal + ", animals=" + animals + ", foods=" + foods
				+ "]";
	}
	
}
