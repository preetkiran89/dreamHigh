package com.online.booking.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

public class SampleJunit 
{
   Calculation calculation = new Calculation();
   int sum = calculation.add(3,  4);
   int divideAns = calculation.divide(10, 0);
   int expectedSum = 7;
   
   @Test
   public void testMethod(){
	   assertEquals(sum, expectedSum);
   }
   
   @Test(expected = ArithmeticException.class)
   public void testmethod2(){
	   assertEquals(0, divideAns);
   }
}
