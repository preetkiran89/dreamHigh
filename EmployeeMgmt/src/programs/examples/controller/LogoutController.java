package programs.examples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController
{
	@RequestMapping(value = "/logout.jsp")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView logoutView = new  ModelAndView("logout");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("userSession");
			session.invalidate();
		}    
		return logoutView;
	}
}
