<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <title>Upload File Request Page</title> -->
<!-- <script type="text/javascript" src="jquery-1.12.4.min.js"></script> -->
<!-- <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  -->
<!-- <link href="webapp/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body>

<nav class="navbar navbar-inverse"> </nav>

<div class="jumbotron">
  <h1>Trello File</h1>
 
<form method="GET" action="downloadFile" enctype="multipart/form-data">
		Buscar: <input type="file" class="file" name="file" /><br /> <br />
		<button type="submit" value="Descargar" class = "glyphicon glyphicon-download-alt"> Descargar</button>
</form>

<p>Formulario que envia Parametros</p>
        
        <form name="form" action="recibeDatos" method="GET">
                    
            Nombre:<input type="text" name="nombre">
            </br>
            Paterno:<input type="text" name="apellido">
            </br>
            Materno:<input type="text" name="edad">
            </br>
            <input type="submit" value="Enviar">
            
      </form>
      
 

</div>

<h2>Aca la variable: ${persona}</h2>


</body>
</html>