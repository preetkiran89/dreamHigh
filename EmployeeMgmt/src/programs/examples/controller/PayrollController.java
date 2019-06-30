package programs.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.EmployeeInfo;
import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.service.AuthenticationService;
import programs.examples.service.ProfileService;
import programs.examples.utils.EmployeeStatusConstants;

@Controller
public class PayrollController 
{
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private ProfileService profileService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
		
	@RequestMapping(value = "/payroll", method = RequestMethod.GET)
	public ModelAndView getPayroll(@ModelAttribute LoginModel loginModel) {
		
		return null;
	}
	
}
