package com.lucene.search.SpringConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lucene.search.Model.GoogleSignInProperties;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.lucene.search" })
@PropertySource(value = { "classpath:public.properties" })
public class SpringConfig
{
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// @Override
	// public void
	// configureDefaultServletHandling(DefaultServletHandlerConfigurer
	// configurer) {
	// configurer.enable();
	// }
	
	
	/* initializing google parameters */
	
     @Bean
     public GoogleSignInProperties getGoogleSignInProperties(){
    	 GoogleSignInProperties googleSignInProperties = new GoogleSignInProperties();
    	 googleSignInProperties.setClient_id(env.getProperty("client_id"));
    	 googleSignInProperties.setRedirect_uri(env.getProperty("redirect_uri"));
    	 googleSignInProperties.setApproval_prompt(env.getProperty("approval_prompt"));
    	 googleSignInProperties.setResponse_id(env.getProperty("response_id"));
    	 googleSignInProperties.setScope(env.getProperty("scope"));
    	 googleSignInProperties.setClient_secret(env.getProperty("client_secret"));
    	 googleSignInProperties.setGrant_type(env.getProperty("grant_type"));
    	 return googleSignInProperties;
     }
     
     public String getProperty(String key){
 		return env.getProperty(key);
 	}
}