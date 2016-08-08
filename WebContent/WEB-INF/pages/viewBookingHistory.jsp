<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="header.homePage" /></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<spring:message code="label.viewBookingHistoryFormHeader" />
	</div>
	<table border="1px" cellpadding="0">
		<thead>
			<tr>
				<td><spring:message code="label.name" /></td>
				<td><spring:message code="label.color" /></td>
				<td><spring:message code="label.longitude" /></td>
				<td><spring:message code="label.latitude" /></td>
				<td><spring:message code="label.status" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rides }" var="ride">
			<tr>
				<td>${ride.car.name }</td>
				<td>${ride.car.color }</td>
				<td>${ride.car.longitude }</td>
				<td>${ride.car.latitude }</td>
				<td>${ride.status }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>