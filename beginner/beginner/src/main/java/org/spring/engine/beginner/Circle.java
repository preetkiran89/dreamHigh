package org.spring.engine.beginner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.*;

@Component
public class Circle implements Shape {

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	//@Required
	//@Autowired
	@Resource(name="pointA")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Circle has centre" + center.getX() + center.getY());
		
	}
	
	@PostConstruct
	public void initialise() {
		System.out.println("Init of circle called");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying circle");
	}
	
}
