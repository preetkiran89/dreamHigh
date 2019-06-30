package programs.examples.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userSession")
public class LeaveController 
{
	
	@RequestMapping(value = "/leave.jsp", method = RequestMethod.GET)	
	public ModelAndView leave(HttpServletRequest request) {		
		HttpSession session = request.getSession(false);		
		ModelAndView leaveView = new ModelAndView();
		leaveView.setViewName("leave");
		if (session != null) {
			leaveView.addObject("sessionCreatedTime", new Date(session.getCreationTime()));
			leaveView.addObject("lastAccessedTime", new Date(session.getLastAccessedTime()));
		}		
		return leaveView;
	}
	
	@RequestMapping(value = "/applyLeave", method = RequestMethod.POST)
	public ModelAndView applyleave(@PathVariable int userId) {
		
		ModelAndView leaveView = new ModelAndView();
		leaveView.setViewName("leave");
		leaveView.addObject("empid", userId);
		return leaveView;
	}
}
