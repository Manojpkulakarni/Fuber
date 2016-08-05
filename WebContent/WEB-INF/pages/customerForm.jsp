<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="header.homePage" /></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<spring:message code="label.customerFormHeader" />
	</div>
	<form:form commandName="customer" action="addCustomer.view" method="POST">
		<table>
			<tr>
				<td><spring:message code="label.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="errorClass" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.phoneNumber" /></td>
				<td><form:input path="phoneNumber" /></td>
				<td><form:errors path="phoneNumber" cssClass="errorClass" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.sex" /></td>
				<td><form:radiobutton path="sex" label="Male" value="Male"/>
					<form:radiobutton path="sex" label="Female" value="Female"/>
				</td>
				<td><form:errors path="sex" cssClass="errorClass" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.longitude" /></td>
				<td><form:input path="longitude" /></td>
				<td><form:errors path="longitude" cssClass="errorClass" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.latitude" /></td>
				<td><form:input path="latitude" /></td>
				<td><form:errors path="latitude" cssClass="errorClass" /></td>
			</tr>
			<tr>
				<td><input type="submit" value='<spring:message code="label.submitBtn" />' /></td>
				<td><input type="button" value='<spring:message code="label.CancelBtn" />' onclick='window.location.href="cancel.view"'/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>