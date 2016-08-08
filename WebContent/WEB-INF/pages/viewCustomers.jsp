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
		<spring:message code="label.viewCustomersFormHeader" />
	</div>
	<table border="1px" cellpadding="0">
		<thead>
			<tr>
				<td><spring:message code="label.name" /></td>
				<td><spring:message code="label.phoneNumber" /></td>
				<td><spring:message code="label.sex" /></td>
				<td><spring:message code="label.longitude" /></td>
				<td><spring:message code="label.latitude" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers }" var="customer">
			<tr>
				<td>${customer.name }</td>
				<td>${customer.phoneNumber }</td>
				<td>${customer.sex }</td>
				<td>${customer.longitude }</td>
				<td>${customer.latitude }</td>
				<td><input type="button" value='<spring:message code="label.viewBookingHistoryBtn" />' onclick='viewBookingHistory(${customer.id});'/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<table align="center" width="70%">
		<tr>
			<td><input type="button" value='<spring:message code="label.backBtn" />' onclick='window.location.href="cancel.view"'/></td>
		</tr>
	</table>
	
	<div id="message" style="display: none;">
	</div>
	<div id="searchResults" style="display: none;">
		<table border="1px">
			<thead>
				<tr>
					<td><spring:message code="label.name" /></td>
					<td><spring:message code="label.color" /></td>
					<td><spring:message code="label.longitude" /></td>
					<td><spring:message code="label.latitude" /></td>
					<td></td>
				</tr>
			</thead>
			<tbody id="results">
			</tbody>
		</table>
	</div>
	
</body>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/viewBookingHistory.js"></script>
</html>