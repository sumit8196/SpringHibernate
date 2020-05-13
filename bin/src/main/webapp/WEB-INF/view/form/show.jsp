<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
 .error-red{
   color:red;
 }
</style>
<title>Insert title here</title>
</head>
<body>
	<form:form action="submitForm" modelAttribute="user">
  Name :<form:input path="name" />
  <form:errors path="name" cssClass="error-red"> </form:errors>
		<br>
 Address:<form:input path="address" />
 <form:errors path="address" cssClass="error-red"></form:errors>
		<br>
 Description:<form:input path="description" />
		<br>
		Category Id :<form:input path="categoryid" />
 <form:errors path="categoryid" cssClass="error-red"></form:errors><br>
		
Category <form:select path="category" >
         <form:options items="${categoryOptions}" />	
		</form:select><br>
		Id: 
	101<form:radiobutton path="id" value="10101"/>
	102	<form:radiobutton path="id" value="10102"/>
	103	<form:radiobutton path="id" value="10103"/>
	104	<form:radiobutton path="id" value="10104"/><br>
	operatingSystems:  
	Window <form:checkbox path="operatingSystems" value="window"/>
	Linux<form:checkbox path="operatingSystems" value="linux"/>
	MacOS<form:checkbox path="operatingSystems" value="Mac OS"/><br>
	CourceCode: <form:input path="courceCode"/>
	       <form:errors path="courceCode" cssClass="error-red" /><br>
		 
		<input type="submit" value="submit" />
		<br>
	</form:form>

</body>
</html>