<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Datos recibidos</h1>
        <!-- recibiendo parametros -->
   
        <table border="1">
            <tr>
                <th colspan="2">Datos que se reciben:</th>
            </tr>
            <!-- imprimiendo parametros que fueron rescatados -->
            <tr> 
                <td>Nombre:</td><td>${persona.nombre }</td>
            </tr>
            <tr>
                <td>Apellido:</td><td>${persona.apellido }</td>
            </tr>
            <tr>
                <td>Edad:</td><td>${persona.edad }</td>
            </tr>
        </table>
 

</body>
</html>