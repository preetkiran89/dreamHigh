package org.spring.engine.beginner;

public class TriangleFactory {

	public Triangle draw() {
		System.out.println("Inside TriangleFactory class");
		return new Triangle(); 
	}
}
