package org.spring.engine.beginner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");//FilePathXmlApplicationContext
		context.registerShutdownHook(); //context itself shuts it down once done
		/*Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();*/
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
		
		Animal animal = (Animal) context.getBean("animal"); //learner constructor-arg/props tag and maps & List
		System.out.println(animal.toString());
		
		Logger logger = (Logger) context.getBean("logger");
		logger.getConsoleWriter("Hii there!!");
		logger.getFileWriter("Hii there again from File!!!");
	}
}
