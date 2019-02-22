<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Student </title>
</head>
<body>

<h1> Student Data </h1>
<form:form action="student.do" method="POST" commandName="tablaPruebas">
	<table>
		<tr>
			<td>ID de la persona</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><form:input path="Nombre" /></td>
		</tr>
		<tr>
			<td>Apellido</td>
			<td><form:input path="Apellido" /></td>
		</tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>Nombre</th>
	<th>Apellido</th>
	<c:forEach items="${student}" var="student">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.nombre}</td>
			<td>${student.apellido}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>