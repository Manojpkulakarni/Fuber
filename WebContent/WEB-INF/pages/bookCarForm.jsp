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
		<spring:message code="header.book.car" />
	</div>
	<table>
		<tr>
			<td><spring:message code="label.name" /></td>
			<td>
				<select id="customer" name="customer">
					<option value="">Select</option>
					<c:forEach items="${customers }" var="customer">
						<option value="${customer.id }">${customer.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="button" value='<spring:message code="label.searchBtn" />' onclick='getAvailableCars();'/></td>
			<td><input type="button" value='<spring:message code="label.CancelBtn" />' onclick='window.location.href="cancel.view"'/></td>
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
				</tr>
			</thead>
			<tbody id="results">
			</tbody>
		</table>
		<table align="center" width="80%">
			<tr>
				<td><input type="button" value='<spring:message code="label.bookBtn" />' onclick='bookCar();'/></td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/bookForm.js"></script>
</html>