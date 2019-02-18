function mostrarGrilla(){
    $("#divGrilla").removeClass("ocultar");
	}

	function configurarGrilla(){
		
		$("#getBtn").jqGrid({    
			url: "/prueba", 
			type : 'GET',
  			datatype: "JSON",
  			colModel: [       
  			           { label: 'ID', name: 'id', width: 0, key:true },
  			           { label: 'NOMBRE', name: 'firstname', width: 100 },
  			           { label: 'APELLIDO', name: 'lastname', width: 100 }
  			],
  			viewrecords: true,
  			height: 250          
   });  
}

	$('document').ready(function(){
		configurarGrilla();
		$('#customerForm').trigger("reloadGrid");
	});