<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
<style>
ul {
	list-style-type: disc;
	margin: 0;
	padding: 0;
	overflow: auto;
	background-color: #343;
}

li {
	float: left;
}

li a {
	display: inline-table;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
</style>
</head>
<body>

	<ul>
		<li><a href="#home">Bus</a></li>
		<li><a href="/Employee/spring/payroll">Hotel</a></li>
		<li><a href="/Employee/spring/reimbursement">Tour</a></li>
		<li><a href="/Employee/spring/attendance">Offers</a></li>
		<li><a href="/Employee/spring/leave.jsp">Support</a></li>
		<li><a href="/Employee/spring/benefits">Benefits</a></li>
		<li><a href="/Employee/spring/help">My Account</a></li>
		<ul class="dropdown-menu">
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
		</ul>
	</ul>
	<br> You are logged in as ${userSession}
</body>
</html>