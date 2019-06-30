package com.lucene.search.Controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.search.Model.GoogleSignIn;
import com.lucene.search.Service.GoogleSigninService;

@RestController
@RequestMapping("/restApi")
public class SearchController
{
	@Autowired
	private GoogleSigninService googleSigninService;
	
	@RequestMapping("/getSampleList")
	public String testPage() throws JSONException{
		JSONArray jsonArray = new JSONArray();
	    String[] countries = new String[]{"india","pakistan","nepal","bhutan"};
	    for(String country:countries){
	    	JSONObject json = new JSONObject();
	    	json.put("name", country);
	    	jsonArray.put(json);
	    }
	    return jsonArray.toString();
	}
	
	@RequestMapping(value ="/messages/{id}", method = RequestMethod.GET)
	public void displayId(@PathVariable("id") int id){
		System.out.println("Inside messages GET API , Id : "+id);
	}
	
	@RequestMapping(value ="/messages/{id}", method = RequestMethod.DELETE)
	public void deleteId(@PathVariable("id") int id){
		System.out.println("Inside messages DELETE API , Id : "+id);
	}
	
	@RequestMapping(value ="/messages/{id}", method = RequestMethod.PUT)
	public void updateId(@PathVariable("id") int id){
		System.out.println("Inside messages PUT API , Id : "+id);
	}
	
}
