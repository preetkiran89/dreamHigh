$(document).ready(function(e) {

			var googleOAuthurl = googleSignInParams.oauth2_url
					+ "client_id="+ googleSignInParams.client_id
					+ "&redirect_uri="+ googleSignInParams.redirect_uri
					+ "&scope="+ googleSignInParams.scope
					+ "&response_type="+ googleSignInParams.response_type
					+ "&approval_prompt"+ googleSignInParams.approval_prompt;
			
	
			
	document.getElementById('googleOAuthUrl').href = googleOAuthurl;		
	
	var options = {
		url : function(phrase) {
			return "restApi/getSampleList?phrase=" + phrase + "&format=json";
		},

		getValue : "name"
	};

	$(".form-control").easyAutocomplete(options);
	
	
});