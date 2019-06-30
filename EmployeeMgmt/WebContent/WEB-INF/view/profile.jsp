<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
  function enableFields(){
	  //document.getElementById("userid").disabled = false;
	  document.getElementById("fname").disabled = false;
	  document.getElementById("lname").disabled = false;
	  document.getElementById("secondaryEmail").disabled = false;
	  document.getElementById("submitButton").disabled = false;
	  document.getElementById("editButton").disabled = true;
  }
  
  function validate(){
	  return true;
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Profile</title>
</head>

<body>
    <c:set var="session" scope="session" value="${userSession}" />
	<c:if test="${empty session}">
		<c:redirect url="${pagecontext.request.contextpath}/spring/login.jsp" />
	</c:if>
	
	<jsp:include page="index.jsp" />
	<br>

	    <h1>Employee Personal Information</h1>
   <br>	
   
   <form method="post" action="/Employee/spring/editProfile" onsubmit="return validate();">
   <div>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" name="userId" id="userid" value="${employee.userId}" disabled/></td>     
         </tr>
         <tr>
            <td>First Name</td>
            <td><input type="text" name="fname" id="fname" value="${employee.fname}" disabled/></td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td><input type="text" name="lname" id="lname" value="${employee.lname}" disabled/></td>
         </tr>
         <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email" value="${employee.email}" disabled/></td>
         </tr>
         <tr>
            <td>Official Email</td>
            <td><input type="text" name="email_official" id="email_official" value="${employee.email_official}" disabled/></td>
         </tr>
<!--          <tr> -->
<!--             <td>Street</td> -->
<%--             <td><input type="text" name="street" id="street" value="${address.street}" disabled/></td> --%>
<!--          </tr> -->
<!--          <tr> -->
<!--             <td>City</td> -->
<%--             <td><input type="text" name="city" id="city" value="${address.city}" disabled/></td> --%>
<!--          </tr> -->
<!--          <tr> -->
<!--             <td>ZIP</td> -->
<%--             <td><input type="text" name="zip" id="zip" value="${address.zip}" disabled/></td> --%>
<!--          </tr> -->
<!--          <tr> -->
<!--             <td>County</td> -->
<%--             <td><input type="text" name="county" id="county" value="${address.county}" disabled/></td> --%>
<!--          </tr> -->
<!--          <tr> -->
<!--             <td>State</td> -->
<%--             <td><input type="text" name="state" id="state" value="${address.state}" disabled/></td> --%>
<!--          </tr> -->
         <tr>
          <td><input type="button" value="Edit" id="editButton" onclick="enableFields();" disabled /></td>
          <td><input type="submit" value="Submit" id="submitButton" disabled /></td>
         </tr>                  
      </table> 
   </div>
   </form>

</body>
</html>