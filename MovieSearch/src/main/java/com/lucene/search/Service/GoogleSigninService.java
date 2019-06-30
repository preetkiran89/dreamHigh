package com.lucene.search.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.lucene.search.Model.GoogleSignIn;
import com.lucene.search.Model.GoogleSignInProperties;

@Service
public class GoogleSigninService 
{
	@Autowired
	private Environment env;

	@Autowired
	private GoogleSignInProperties getGoogleSignInProperties;

	public String getAccessToken(String code) {
		String accessToken = null;
		StringBuilder getAccessTokenParams = new StringBuilder();
		try {
			getAccessTokenParams.append("code=").append(code);
			getAccessTokenParams.append("&redirect_uri=").append(getGoogleSignInProperties.getRedirect_uri());
			getAccessTokenParams.append("&client_id=").append(getGoogleSignInProperties.getClient_id());
			getAccessTokenParams.append("&client_secret=").append(getGoogleSignInProperties.getClient_secret());
			getAccessTokenParams.append("&grant_type=").append(getGoogleSignInProperties.getGrant_type());
			byte[] postData = getAccessTokenParams.toString().getBytes(StandardCharsets.UTF_8);
			URL url = new URL(env.getProperty("oauth2_token_url"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setUseCaches(false);
			DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
			writer.write(postData);
			writer.flush();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuilder responseString = new StringBuilder();
			String line = null;
			while ((line = in.readLine()) != null) {
				responseString.append(line);
			}
			JSONObject jsonObject = new JSONObject(responseString.toString());
			accessToken = jsonObject.getString("access_token");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
	public GoogleSignIn getUserInfo(String accessToken){
		GoogleSignIn googleSignIn = new GoogleSignIn();
		StringBuilder getUserInfoUrl = new StringBuilder();
		try {
			getUserInfoUrl.append(env.getProperty("user_info_url")).append("access_token=").append(accessToken);
			URL url = new URL(getUserInfoUrl.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setUseCaches(false);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuilder responseString = new StringBuilder();
			String line = null;
			while ((line = in.readLine()) != null) {
				responseString.append(line);
			}
			Gson gson = new Gson();
			googleSignIn = gson.fromJson(responseString.toString(), GoogleSignIn.class);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return googleSignIn;
	}
}
