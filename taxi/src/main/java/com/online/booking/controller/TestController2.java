package com.online.booking.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/testApi2")
@Controller
public class TestController2 
{
	@RequestMapping("/showHomePage")
    public String showHome(){
    	return "register";
    }
	
	@RequestMapping("/thyme")
    public ModelAndView showCss(){
		ModelAndView testView  = new ModelAndView();
		testView.setViewName("about");
		testView.addObject("serverTime", new Date().toString());
    	return testView;
    }
	
}
