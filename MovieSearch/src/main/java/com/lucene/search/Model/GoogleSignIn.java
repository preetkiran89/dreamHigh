package com.lucene.search.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.lucene.search.Utils.MovieUtils;

@Component
public class GoogleSignIn {
	
	@Autowired
	private Environment env;
	
	private String id;
	private String email;
	boolean verigfied_email;
	private String name;
	private String given_name;
	private String family_name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerigfied_email() {
		return verigfied_email;
	}

	public void setVerigfied_email(boolean verigfied_email) {
		this.verigfied_email = verigfied_email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGiven_name() {
		if (MovieUtils.isEmpty(given_name))
			return env.getProperty("default_given_name");
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoogleSignIn [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", verigfied_email=");
		builder.append(verigfied_email);
		builder.append(", name=");
		builder.append(name);
		builder.append(", given_name=");
		builder.append(given_name);
		builder.append(", family_name=");
		builder.append(family_name);
		builder.append("]");
		return builder.toString();
	}

}
