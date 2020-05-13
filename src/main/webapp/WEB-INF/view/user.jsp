<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Create User</title></head>
<body>
  <form:form action="createUser"  method="post">
	   <input type="submit" name="submit" value="Click here to fetch data"/>
  </form:form>
  <form:form action="openMailPage"  method="post">
	   <input type="submit" name="submit" value="Click here to send your  mail"/>
  </form:form>
</body>
</html>