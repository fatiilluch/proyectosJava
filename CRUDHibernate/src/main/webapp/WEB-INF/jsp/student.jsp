<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>

<style>

#error {
background-color:lightblue;
color: rgb(245, 140, 247);
}

</style>

</head>

<body>
	<h1>Students Data</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6">
				<form:form action="student.do" method="POST" commandName="student">
					<table>
						<tr>
							<td>Student ID</td>
							<td><form:input path="studentId" /></td>
						</tr>
						<tr>
							<td>First name</td>
							<td><form:input path="Nombre" /></td>
						</tr>
						<tr>
							<td>Last name</td>
							<td><form:input path="Apellido" /></td>
						</tr>
						<tr>
							<td>Localidad</td>
							<td><form:input path="Localidad" /></td>
						</tr>
						<tr>
							<td>Sexo</td>
							<td><form:input path="Sexo" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="action"
								value="Add" /> <input type="submit" name="action" value="Edit" />
								<input type="submit" name="action" value="Delete" /> <input
								type="submit" name="action" value="Search" /></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="col-6">
				<h1 id="error" class="text-center">${error.getNombre()}</h1>
			</div>
		</div>
	
	<br>
<div class="row">
<div class="col-8">
	<table border="1" class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido</th>
				<th scope="col">Localidad</th>
				<th scope="col">Sexo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<th scope="row">${student.studentId}
					</td>
					<td>${student.getNombre()}</td>
					<td>${student.getApellido()}</td>
					<td>${student.getLocalidad()}</td>
					<td>${student.getSexo()}</td>
					<%--     	<td>${student.yearLevel}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>
