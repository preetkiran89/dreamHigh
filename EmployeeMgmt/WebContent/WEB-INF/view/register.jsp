<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
     <h1>Register Employee</h1>
   <br>	
   <form method="post" action="/Employee/spring/register">
   <div>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" name="userid" id="userid"/></td>     
         </tr>
         <tr>
            <td>Password</td>
            <td><input type="password" name="password_hash" id="password_hash"/></td>
         </tr>
         <tr>
            <td>Confirm Password</td>
            <td><input type="password" id="confirmpassword"></td>
         </tr>
         <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email"/></td>
         </tr>
         <tr>
          <td><input type="submit" value="Register"/></td>
         </tr>                  
      </table>
      <br>
      ${errorMessage} 
   </div>
   </form>
</body>
</html>