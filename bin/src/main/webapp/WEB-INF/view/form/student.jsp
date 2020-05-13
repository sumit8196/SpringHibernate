<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layouts/header.jsp"%>
<%-- <%@ include file="../layouts/meta.jsp" %>   --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/test.css"> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveStudent" modelAttribute="student">
		<div class="my-div">
			<div class="row">
				<div class="text-label col-sm-3">Id :</div>
				<div class="col-sm-9">
					<form:input path="id" class="form-control" />
					<form:errors path="id" cssClass="cssError" />
				</div>
			</div>

			<div class="row">
				<div class="text-label col-sm-3">First Name :</div>
				<div class="col-sm-9">
					<form:input path="firstName" class="form-control" />
					<form:errors path="firstName" cssClass="error-red" />
				</div>
			</div>

			<div class="row">
				<div class="text-label col-sm-3">Last Name :</div>
				<div class="col-sm-9">
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName" cssClass="error-red" />
				</div>
			</div>
			<div class="row">
				<div class="text-label col-sm-3">eMail :</div>
				<div class="col-sm-9">
					<form:input path="email" class="form-control" />
					<form:errors path="email" cssClass="error-red" />
				</div>
			</div>
			<div class="row">
				<div class="text-label col-sm-3">Father's Name :</div>
				<div class="col-sm-9">
					<form:input path="email" class="form-control" />
					<form:errors path="email" cssClass="error-red" />
				</div>
			<div class="row">
				<div class="text-label col-sm-3">Mother's Name :</div>
				<div class="col-sm-9">
					<form:input path="email" class="form-control" />
					<form:errors path="email" cssClass="error-red" />
				</div>
			</div>

			<input type="submit" class="nector-bottom" value="submit" />
		</div>
	</form:form>
</body>
</html>