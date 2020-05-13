<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <script src="https://ajax.googleapis.com/ajax/libs/d3js/5.15.0/d3.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>
 
</h1>
</head>
<body>

  <form:form action="sendMail"  method="post">
	Mail Id  : <input type="text" name="gmail" placeholder="Enter your mail id"/><br>
	Password : <input type="password" name="password" placeholder="Enter your passord here"/>
	         <input type="submit"  value="submit" value="submit"/>
  </form:form>

<%-- <c:if test="${userDetails}" >
   Congratulation, Your Mail has been sent successfully.
</c:if>  
<c:else>
  Oppps , something went wrong.
</c:else> --%>
<script>
    function sendMail() {
		
	}
    
</script>
</body>
</html>
