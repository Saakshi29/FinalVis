<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping cart here</title>
</head>
<body>
	
	<%--
		String[] selectedCars = (String[]) session.getAttribute("selectedCars");
		String[] selectedBooks = (String[]) session.getAttribute("selectedBooks");
		String[] selectedBikes = request.getParameterValues("bikes");
	--%>
	<h4>Selected books</h4>
	<ul>

	<c:forEach var="aBook" items="${selectedBooks}">
	<li>${aBook} </li>
	</c:forEach>
	</ul>
	<h4>Selected cars</h4>
	<ul>
	<c:forEach var="aCar" items="${selectedCars}">
	<li>${aCar} </li>
	</c:forEach>
	</ul>
	<h4>Selected Bikes</h4>
	<ul>
	<c:forEach var="aBike" items="${paramValues.bikes}">
	<li>${aBike} </li>
	</c:forEach>
	</ul>
	
	<%--
	<h4>Selected cars</h4>
	<ul>
		<%
			for (String aCar : selectedCars) {
		%>
		<li><%=aCar%></li>
		<%
			}
		%>
	</ul>
	
	<h4>Selected Bikes</h4>
	<ul>
		<%
			for (String aBike : selectedBikes) {
		%>
		<li><%=aBike%></li>
		<%
			}
		%>
	</ul>--%>
</body>
</html>