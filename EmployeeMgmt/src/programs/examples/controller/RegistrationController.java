package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.LoginModel;
import programs.examples.service.RegisterService;

@Controller
public class RegistrationController
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "/register.jsp", method = RequestMethod.GET)
    public ModelAndView registerEmployeePage(){
		ModelAndView model = new ModelAndView("register");
	    return model;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerEmployee(@ModelAttribute LoginModel loginModel){
		LOGGER.info(" REGISTER Controller [{}] ",loginModel.toString());
		ModelAndView model = new ModelAndView();
		if(!registerService.registerEmployeeByAdmin(loginModel)){
		  model.setViewName("register");
		  model.addObject("errorMessage", "Unable to register user, Please try again");
		  return model;
		}
		model.setViewName("registersuccess");
	    model.addObject("employee", loginModel);
	    return model;
    }
	
	
}
