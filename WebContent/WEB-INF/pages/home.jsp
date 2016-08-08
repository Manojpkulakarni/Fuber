<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="header.homePage"/></title>
</head>
<body>
<div>${param.message}</div>
<div>${param.errorMessage}</div>
<a href="carForm.view"><spring:message code="label.carForm.href" /></a>
<br />
<a href="customerForm.view"><spring:message code="label.customerForm.href" /></a>
<br />
<a href="viewCars.view"><spring:message code="label.view.cars.href" /></a>
<br />
<a href="viewCustomers.view"><spring:message code="label.view.customers.href" /></a>
<br />
<a href="bookCarForm.view"><spring:message code="label.book.car.href" /></a>
<br />
<a href="confirmCarForm.view"><spring:message code="label.confirm.car.href" /></a>
<br />
<a href="releaseCarForm.view"><spring:message code="label.release.car.href" /></a>
</body>
</html>