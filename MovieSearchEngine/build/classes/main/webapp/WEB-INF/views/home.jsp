<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- JS file -->
<script src="../static/js/jquery.easy-autocomplete.min.js"></script>

<!-- CSS file -->
<link rel="stylesheet" href="../static/css/easy-autocomplete.min.css">

<!-- Additional CSS Themes file - not required-->
<link rel="stylesheet" href="../static/css/easy-autocomplete.themes.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../static/js/config.js"></script>
<script type="text/javascript" src="../static/js/home.js"></script>
<link rel="stylesheet" href="../static/css/test.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div style="position: absolute; top: 0; right: 0; color: blue; margin-right: 30px; margin-top: 20px">
<%-- 		<h4><span class="label label-default"><c:out value="${googleUserInfo.getGiven_name()}"/> </span></h4> --%>
		
		<c:choose>
			<c:when test="${googleSignIn.isUserSignedIn() == true }">
               <h4><span class="label label-default"><c:out value="${googleUserInfo.getGiven_name()}"/> </span></h4>            
			</c:when>
			<c:otherwise>
			   <a href="#" class="btn btn-default" id="googleOAuthUrl">Google Sign-In</a> 
               <h4><span class="label label-default"><c:out value="${googleUserInfo.getGiven_name()}"/> </span></h4>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="input-group">
					<div class="input-group-btn search-panel">
						<div class="col-sm-2">
							<select class="form-control" id="gender" style="width: auto;">
								<option selected>Filter By</option>
								<option value="movies">Movies</option>
								<option value="titles">Titles</option>
								<option value="Names">Names</option>
								<option value="tvepisodes">TV Episodes</option>
							</select>

						</div>
					</div>
					<input type="hidden" name="search_param" value="all"
						id="search_param"> <input type="text" class="form-control"
						name="x" placeholder="Find Movies,Titles or Episodes ...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>