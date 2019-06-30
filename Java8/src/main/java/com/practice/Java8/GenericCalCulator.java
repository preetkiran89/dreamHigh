package com.practice.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface Operation<T,V>{
	
	V mathOperation(T t1, T t2);
	
}

@FunctionalInterface
interface FuncInt<T> {

	void display(T t);

}

class FuncIntImpl implements FuncInt<String> {

	@Override
	public void display(String t) {
		// TODO Auto-generated method stub
		
	}

}


public class GenericCalCulator
{
     
	public void runLambdaExp(FuncInt<String> funcInt){
		funcInt.display("qjlkwedlkqjwd");
	}
	
	public static void main(String[] args) {
		Operation<Integer,Integer> sum = (a, b) -> { return (a+b); };
		//Operation<Integer,Integer> subtraction = (a, b) -> { return (a-b); };

		System.out.println(sum.mathOperation(3, 70));
		
		List<String> streamList = new ArrayList<>();
		
		Collections.sort(streamList, (o1, o2) -> o1.compareTo(o2));
		
		Collections.sort(streamList, String::compareTo);
		
		FuncInt<String> funcInt = (String s) -> System.out.println(s);
		
		new GenericCalCulator().runLambdaExp((s) -> System.out.println("this is lambda expression implementation"));
	 }
}
