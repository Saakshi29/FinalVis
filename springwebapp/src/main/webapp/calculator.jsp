<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator here</title>
</head>
<body>
	<form action="cal">
		Number1 <input name=n1> <br> Number2 <input name=n2>
		<br> <input name=op value="+" type=submit> <input name=op
			value="-" type=submit> <input name=op value="*" type=submit>
		<input name=op value="/" type=submit>
	</form>

	<c:if test="${not(empty(result))}">
Result : ${param.n1} ${param.op} ${param.n2} =  ${result}
</c:if>

</body>
</html>