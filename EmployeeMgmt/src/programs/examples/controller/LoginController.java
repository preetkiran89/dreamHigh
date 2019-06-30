package programs.examples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.EmployeeInfo;
import programs.examples.model.LoginModel;
import programs.examples.model.PasswordChangeModel;
import programs.examples.service.AuthenticationService;
import programs.examples.service.ProfileService;
import programs.examples.utils.EmployeeStatusConstants;

@Controller
@SessionAttributes("userSession")
public class LoginController
{	
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private ProfileService profileService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
		
	@RequestMapping(value = "/login.jsp" , method = RequestMethod.GET)
	public ModelAndView userLoginPage(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null)
			session.invalidate();
		return new ModelAndView("Login");		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute LoginModel loginModel) {
		LOGGER.info("Employee trying to login [{}] ", loginModel.toString());
		ModelAndView loginView = new ModelAndView();		
		loginView.addObject("loginModel", loginModel);
		String login = authenticationService.authenticateUser(loginModel);
		switch (login) {
		case "Authenticated":
			EmployeeInfo employeeInfo = profileService.getEmployeeInfo(loginModel.getUserid());
			loginView.setViewName("dashboard");
			loginView.addObject("userid",employeeInfo.getUserId());
			loginView.addObject("userSession", employeeInfo.getUserId());
			break;
		case "Authenticated First time Login":
			loginView.setViewName("changepassword");

			break;
		case "Not Authenticated":
			loginView.setViewName("Login");
			loginView.addObject("invalid", "invalid user/password , Please try again");
			break;
		default:
			loginView.setViewName("Login");
			loginView.addObject("invalid", "Login Error , Please try again");
			break;
		}

		return loginView;
	}
	
	@RequestMapping(value = "/changePassword" , method = RequestMethod.POST)
	public ModelAndView userPasswordChange(@ModelAttribute PasswordChangeModel passwordChangeModel){
		LOGGER.info("Employee trying to change password [{}] ",passwordChangeModel.getUserid());
		ModelAndView passwordChangeView = new ModelAndView();
		String passwordStatus = authenticationService.changePasswordFirstTimeUser(passwordChangeModel);
		  switch(passwordStatus){
		    case EmployeeStatusConstants.PASSWORD_CHANGED:
		    	passwordChangeView.addObject("statusMessage", EmployeeStatusConstants.PASSWORD_CHANGED);		    	
		    	passwordChangeView.setViewName("changepassword");
		    	break;
		    case EmployeeStatusConstants.PASSWORD_CHANGE_ERROR:
		    	passwordChangeView.addObject("statusMessage", EmployeeStatusConstants.PASSWORD_CHANGE_ERROR);
		    	passwordChangeView.setViewName("changepassword");
		    	break;	
		    default:
		    	passwordChangeView.addObject("statusMessage", "Unable to change Password , Please try again");		    	
		    	passwordChangeView.setViewName("changepassword");
		  }
		return passwordChangeView;
	}
	
}
