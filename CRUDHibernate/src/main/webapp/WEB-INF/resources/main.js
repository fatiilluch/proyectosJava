$(document).ready(
		function() {
			$("#add").click(function() {
						if ($("#Nombre").val() == "" || $("#Apellido").val() == "" || $("#Localidad").val() == "" || $("#Sexo option:selected").val() == "T" || $("#Edad").val() <= 12) 
						{
							alert("No ha ingresado los datos correctos.");
						} 
						else 
							if ($("#Sexo option:selected").val() == "T") 
							{
								alert("Debe seleccionar un sexo.");
							}
						});
				}); // termina el ready
