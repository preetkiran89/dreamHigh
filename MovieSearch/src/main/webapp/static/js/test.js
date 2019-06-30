$(document).ready(function(e) {

			var googleOAuthurl = googleSignInParams.oauth2_url
					+ "client_id="+ googleSignInParams.client_id
					+ "&redirect_uri="+ googleSignInParams.redirect_uri
					+ "&scope="+ googleSignInParams.scope
					+ "&response_type="+ googleSignInParams.response_type
					+ "&approval_prompt"+ googleSignInParams.approval_prompt;
			
	//alert(googleOAuthurl);
	
	document.getElementById('googleOAuthUrl').href = googleOAuthurl;		
	
	var options = {
		url : function(phrase) {
			return "restApi/getSampleList?phrase=" + phrase + "&format=json";
		},

		getValue : "name"
	};

	$(".form-control").easyAutocomplete(options);
	
	
});

//function googleOauth(){
//	$.ajax({
//		  url: googleSignInParams.oauth2_url,
//		  type: "get", //send it through get method
//		  data: { 
//			  client_id : '52424919169-remgpb2h4nhdua57plc1cem4p0qo4if8.apps.googleusercontent.com',
//			  response_type : 'code',
//			  redirect_uri : 'http://localhost:8080/MovieSearch/webapi/googleOAuthCallback',
//			  scope : 'email',	
//			  approval_prompt : 'force'
//			  //grant_type : 'authorization_code'	
//		  },
//		  beforeSend: function(xhr){xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');},
//		  success: function(response) {
//		    //Do Something
//		  },
//		  error: function(xhr) {
//		    //Do Something to handle error
//		  }
//	});
//}