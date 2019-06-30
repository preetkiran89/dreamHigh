package com.lucene.search.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.lucene.search.Model.GoogleSignIn;
import com.lucene.search.SpringConfig.SpringConfig;

@Component
public class MovieUtils {
    
	@Autowired
	private Environment env;
	
	private static SpringConfig springConfig;
	
	@Autowired
	public void setSpringConfig(SpringConfig springConfig){
		MovieUtils.springConfig = springConfig;
	}
	
	public static boolean isEmpty(String abc) {
		if (abc == null || abc.trim().length() == 0)
			return true;
		return false;
	}
	
	public static boolean getUserSignInStatus(GoogleSignIn googleSignIn) {
		if (googleSignIn != null && !googleSignIn.getGiven_name().equals("Guest"))
			return true;
		else
			return false;
	}
}
