<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="layouts/header.jsp" %>  
<%@ include file="layouts/meta.jsp" %>  

</head>
<body>
<h1>Welcome to our page</h1>
<a href="hello/showForm">Click here to change lowerCase to UpperCase</a><br>
<a href="hello/showUserForm">Click here to open form</a><br>
<a href="checkDbConnection">Click here to check db connection</a><br>
<a href="showStudentForm">Click here to add user</a><br>

</body>
<%@ include file="layouts/footer.jsp" %>
</html>