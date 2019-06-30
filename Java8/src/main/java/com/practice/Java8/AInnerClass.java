package com.practice.Java8;

import java.util.Comparator;

import com.practice.Model.Employee;

public class AInnerClass 
{
	public static void main(String[] args) {

		
		Task1 t = new TesterClass();
		System.out.println(t.anyDefaultMethod());
		
		Task1 task1 = () -> System.out.println("anytask method called with lambda expression");
		task1.anyTask();
		
		Comparator<Employee> empComparator = (o1,o2) -> o1.getId() - o2.getId();
		
		
 	}
}

@FunctionalInterface
interface Task1 {

	public void anyTask();

	public static void anyTask2(String x) {

	}
    
	default String anyDefaultMethod(){
		return "default string";
	}
}


class TesterClass implements Task1
{

	@Override
	public void anyTask() {
		
	}
	
	public String anyDefaultMethod(){
		return "kldjnlqkwndlqw";
	}
	
}