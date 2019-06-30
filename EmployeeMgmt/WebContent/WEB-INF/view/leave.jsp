<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave page</title>

<script type="text/javascript">
	$.noConflict();
	jQuery(document).ready(function($) {
		$('.datepickerTo').datepicker();
		$('.datepickerFrom').datepicker();
	});

	function validate() {
		var fromDate = new Date(document.getElementById("fromDate").value);
		var toDate = new Date(document.getElementById("toDate").value);
		if (fromDate.getTime() > toDate.getTime())
			alert("fromdate > todate");
		if((toDate.getTime() -  fromDate.getTime())/86400000 > 3)
			alert("Leave is more than 3 days");
		
		
		return false;
	}
</script>

</head>
<body>
	<c:set var="session" scope="session" value="${userSession}" />
	<c:if test="${empty session}">
		<c:redirect url="${pagecontext.request.contextpath}/spring/login.jsp" />
	</c:if>

	<jsp:include page="index.jsp" />
	<br> session creation time :
	<c:out value="${sessionCreatedTime}" />
	<br> Last accessed time :
	<c:out value="${lastAccessedTime}" />

	<h1>Employee Leave</h1>
	<br>
	<form method="post" action="/Employee/spring/applyLeave"
		onsubmit="return validate();">
		<div class="">
			<table>
				<tr>
					<td>Name :</td>
					<td></td>
					<td>Department :</td>
					<td></td>
				</tr>
				<tr>
					<td>Approver :</td>
					<td></td>
					<td>Designation :</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>UserID</td>
					<td><input type="text" name="userId" id="userid"
						value="${userSession}" readonly /></td>
				</tr>
				<tr>
					<td>Reason for Leave</td>
					<td><input type="text" name="reason" id="reason" /></td>
				</tr>
				<tr>
					<td>From Date</td>
					<td><input type="text" name="fromDate" class="datepickerFrom"
						id="fromDate"></td>
				</tr>
				<tr>
					<td>To Date</td>
					<td><input type="text" name="toDate" class="datepickerTo"
						id="toDate"></td>
				</tr>
				<tr>
					<td>Leave Type</td>
					<td><select name="leaveType" id="leaveType">
							<option value="">Select Type</option>
							<option value="SL">SL</option>
							<option value="Casual">Casual</option>
							<option value="Optional">Optional</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Apply" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>