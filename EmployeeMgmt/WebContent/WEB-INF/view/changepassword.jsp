<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>

<script type="text/javascript">
//compare old passworfd filled here with password in DB

//toggle <div> for login page with status 
</script>

</head>
<body>
	<h1>Change password Page</h1>
	<br>
	<form method="post" action="/Employee/spring/changePassword">
		<div>
			<table>
				<tr>
					<td>UserID</td>
					<td><input type="text" id="username" name="userid"
						value="${loginModel.userid}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Old Password</td>
					<td><input type="password" name="oldPassword" id="password"></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type="password" name="newPassword" id="password"></td>
				</tr>
				<tr>
					<td>Confirm New Password</td>
					<td><input type="password" id="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</div>
	</form>
	<br> ${statusMessage}
	<br>  <div id="loginPageLink" hidden="true"> Go to <a href="/Employee/spring/login.jsp">Login</a> </div> 
</body>
</html>