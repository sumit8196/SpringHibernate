<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Your data is saved  which is:<br>
  ${user.name}<br>
  ${user.address}<br>
  ${user.category}<br>
  ${user.id}<br>
  ${user.courceCode}<br>
  Operating Systems:
  <ul>
    <c:forEach items="${user.operatingSystems}"  var="item" >
  <li> ${item} </li>
  </c:forEach>
  </ul>
  
  <br>

</body>
</html>