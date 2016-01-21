<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<jsp:useBean id="pagedListHolder" scope="request" class="org.springframework.beans.support.PagedListHolder" />
<%
	int p = 0;
	pagedListHolder.setPageSize(10);
	pagedListHolder.setPage(p);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<h1 align="center">Users Data</h1>
	<div style="float: left">
		<form:form action="user.do" method="POST" commandName="user">
			<table class="table">
				<tr>
					<td>User ID</td>
					<td><form:input path="id" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>isAdmin</td>
					<td><form:input path="isAdmin" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="action" value="Add" />
						<input type="submit" name="action" value="Edit" /> <input
						type="submit" name="action" value="Delete" /> <input
						type="submit" name="action" value="Search" />
				</tr>
				<tr>
					<td colspan="2">Edit, Delete and Search commands work with ID
						field.</td>
				</tr>
			</table>
		</form:form>
	</div>

	<div>
					
		<form:form action="index" method="POST" commandName="user">
			<div align="center">
			<input type="submit" name="action" value="Update URL" style="margin-bottom:20px" />
			</div>
			<table border="1" align="center" style="border-collapse: collapse"
				cellpadding="5">
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>is Admin</th>
				<th>Date Created</th>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.age}</td>
						<td>${user.isAdmin}</td>
						<td>${user.dateCreated}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center">
					<a href="?page=prev">Prev</a> 
					<a href="?page=next"> Next</a>
					
				</tr>
			</table>
		</form:form>
	</div>


</body>
</html>