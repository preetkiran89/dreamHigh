package org.spring.engine.beginner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorDisplayName implements BeanPostProcessor {
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Display name after intitialization" + beanName);
		return bean;
	}
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Display name before intitialization" + beanName);
		return bean;
	}
}
