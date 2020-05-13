<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../layouts/header.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div id="wrapper">
     <div id="header">
     <h2>Add New Customer</h2>
     </div>
     <div id="container">
         <h3>Save Customer</h3>
          <form:form action="saveOrUpdate"  modelAttribute="customer" method="POST">
          <form:hidden path="id"/>
          <table>
            <tbody>
             <tr>
               <td><label>First Name </label> </td>
               <td><form:input path="firstName" />
                 <form:errors path="firstName" cssClass="error-red"/> </td>
             </tr>
             <tr>
              <td><label> Last Name</label></td>
              <td><form:input path="lastName"  />
                 <form:errors path="lastName" cssClass="error-red"/></td>
             </tr>
             <tr>
              <td><label> Email</label></td>
              <td> <form:input path="email"/>
                <form:errors path="email" cssClass="error-red"/></td>
             </tr>
             <tr>
               <td><label></label></td>
               <td><input type="submit" value="save" class="save"></td>
             </tr>
            </tbody>
          </table>

    </form:form>
      <div style="clear;both;">
          <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
          </p>
      </div>
    
     </div>
   </div>
   
</body>
</html>