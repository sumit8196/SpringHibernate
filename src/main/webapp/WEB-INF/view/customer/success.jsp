<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ include file="../layouts/header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
   
   <c:when test="${isCustSaved}">
     Customer is added successfully:
   ${cust.firstName}
   ${cust.lastName}
   ${cust.email}
   </c:when>
   <c:otherwise>s
      Something bad happpened:Customer is not saved correctly...
   </c:otherwise>
   
   <a href="list">CLick here to see the list of customer</a>
</body>
</html>