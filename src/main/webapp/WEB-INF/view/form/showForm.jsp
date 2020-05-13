<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/test.css">

<script src="${pageContext.request.contextPath}/resources/js/simpleTest.js">
</script>

<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to spring form</h1>
	<img src="${pageContext.request.contextPath}/resources/images/download.jpg"></img>

	<form action="processFormThree" >
		<input type="text" placeholder="Enter your name" name="studentName"></input>
		<input type="submit" value="submit"></input>
	</form>	
</body>
</html>