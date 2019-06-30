package com.lucene.search.Model;

import org.springframework.stereotype.Component;

@Component
public class GoogleSignInProperties {

	private String scope;
	private String redirect_uri;
	private String response_id;
	private String client_id;
	private String approval_prompt;
	private String client_secret;
	private String grant_type;

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getResponse_id() {
		return response_id;
	}

	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getApproval_prompt() {
		return approval_prompt;
	}

	public void setApproval_prompt(String approval_prompt) {
		this.approval_prompt = approval_prompt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoogleSignInProperties [scope=");
		builder.append(scope);
		builder.append(", redirect_uri=");
		builder.append(redirect_uri);
		builder.append(", response_id=");
		builder.append(response_id);
		builder.append(", client_id=");
		builder.append(client_id);
		builder.append(", approval_prompt=");
		builder.append(approval_prompt);
		builder.append("]");
		return builder.toString();
	}

}
