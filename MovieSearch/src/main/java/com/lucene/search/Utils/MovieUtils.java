package com.lucene.search.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lucene.search.SpringConfig.SpringConfig;

@Component
public class MovieUtils {
    
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
}
