<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>

<body>

	<jsp:include page="index.jsp" />
	<br>
    <br> session creation time : <c:out value="${sessionCreatedTime}" />
	<br> Last accessed time : <c:out value="${lastAccessedTime}" />
<!-- 	<h2> -->
<%-- 		You are logged in as <label>${userid}</label> --%>
<!-- 	</h2> -->

</body>
</html>