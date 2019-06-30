package com.lucene.search.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lucene.search.Model.GoogleSignIn;
import com.lucene.search.Service.GoogleSigninService;
import com.lucene.search.Utils.MovieUtils;

@Controller
@RequestMapping("/")
public class HomePageController 
{
	@Autowired
	private Environment env;
	
	@Autowired
	private GoogleSigninService googleSigninService;
	
	@Autowired
	private GoogleSignIn googleSignIn;
	
	private ModelAndView getHomePageDefaultView(){
		ModelAndView homePageView = new ModelAndView();
		homePageView.setViewName("home");
		homePageView.addObject("googleUserInfo", googleSignIn);		
		return homePageView; 
	}
	
	@RequestMapping("/home")
	public ModelAndView testPage2(){
		ModelAndView homePageView = getHomePageDefaultView();
		return homePageView;
	}

	@RequestMapping(value = "/googleOAuthCallback", method = RequestMethod.GET)
	public ModelAndView googleOauth2Callback(@RequestParam("code") String code){
		ModelAndView homePageView = getHomePageDefaultView();
		String accessToken = googleSigninService.getAccessToken(code);
		GoogleSignIn googleSignIn = googleSigninService.getUserInfo(accessToken);
		//save user-info to our Database
		//open the home page
		homePageView.addObject("googleUserInfo", googleSignIn);
		googleSignIn.setUserSignedIn(MovieUtils.getUserSignInStatus(googleSignIn));
		return homePageView;
	}
}
