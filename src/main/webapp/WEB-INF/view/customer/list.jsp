<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layouts/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<div id="content">
				<div>
					<input type="button" value="Add Customer"
						onclick="window.location.href='openAddForm'" class="add-button">
				</div>
				<div>
				   
				    <form:form action="search" method="GET" >
				     Search Customer:<input type="text" name="searchParams"/>
				      <input type="submit" value="Search" class="add-button">
				    </form:form>
				</div>
				<!-- Add  html table here  -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="customer" items="${customers}">
						<tr>
						<c:url var="updateLink" value="/customer/openUpdateForm">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><span><a href="${updateLink}">Update</a></span>
							<span><a href="${deleteLink}" onclick="if (!confirm('Do you want to delete this2?')) return false">Delete</a></span></td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>
</html>
