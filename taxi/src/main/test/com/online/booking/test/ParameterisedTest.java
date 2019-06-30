package com.online.booking.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterisedTest 
{
   Calculation calculation = new Calculation();
   
   @Parameter(0)
   public int a;   
   @Parameter(1)
   public int b;
   @Parameter(2)
   public int sum;
   
   @Parameters
   public static Collection<Object[]> data(){
	   Object[][] data = new Object[][]{{10,0,3}, {3,4,7}, {6,7,12}};
	   return Arrays.asList(data);
   }
   
   @Test(expected = ArithmeticException.class)
   public void testAddition(){	   
	   assertEquals(sum, calculation.divide(a, b));
   }
}

