package org.spring.engine.beginner;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements Shape {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private List<String> points;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw()
	{
		System.out.println("Point A " + getPointA().getX() + getPointA().getY() + "::: point B" + getPointB().getX() + getPointB().getY()
				+ "::: Point C" + getPointC().getX() + getPointC().getY() + "Points:" + getPoints());
	}

	/*public void afterPropertiesSet() throws Exception {
		System.out.println("InitialisingBean method called for init");
	}

	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method called");
	}*/
	
	
	public void myInit() {
		System.out.println("Initialised method called");
	}
	
	public List<String> getPoints() {
		return points;
	}

	public void setPoints(List<String> points) {
		this.points = points;
	}

	public void myDestory() {
		System.out.println("cleaning up");
	}

}
