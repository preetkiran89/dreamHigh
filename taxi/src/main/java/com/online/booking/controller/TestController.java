package com.online.booking.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testApi")
public class TestController 
{
	@RequestMapping(value = "/getName")
    public String testApi(){
		String x = "amol singh";
		Pattern p = Pattern.compile("^"+"am");  
		Matcher matcher = p.matcher(x);
		
		 if (matcher.lookingAt()) {
             System.out.println("Found: " + x);
         }
    	return "Amol";
    }
}