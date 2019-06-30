package programs.examples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import programs.examples.model.EmployeeInfo;
import programs.examples.service.ProfileService;
import programs.examples.utils.EmployeeStatusConstants;

@Controller
@SessionAttributes("userSession")
public class EmployeeProfileController 
{
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/profile.jsp", method = RequestMethod.GET)
	public ModelAndView userProfile(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int empid = 0;
		if (session != null)
			empid = (int) session.getAttribute("userSession");
		ModelAndView profileView = new ModelAndView();
		EmployeeInfo employeeInfo = profileService.getEmployeeInfo(empid);
		profileView.setViewName("profile");
		profileView.addObject("employee", employeeInfo);
		return profileView;
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute EmployeeInfo employeeInfo) {
		ModelAndView editProfileView = new ModelAndView();
		editProfileView.setViewName("profile");
	    String editProfileMessage = profileService.editEmployeeInfo(employeeInfo);
	    switch (editProfileMessage) {
		case EmployeeStatusConstants.PROFILE_UPDATED:
		      	
			break;
         
		default:
			break;
		}
		return editProfileView;
	}

}
