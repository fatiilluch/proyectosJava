function mostrarGrilla(){
    $("#divGrilla").removeClass("ocultar");
	}

	function configurarGrilla(){
		
		$("#grid").jqGrid({    
			url: "/getallcustomer", 
			type : 'GET',
  			datatype: "JSON",
  			colModel: [       
//  			           { label: 'ID', name: 'id', width: 0, key:true },
//  			           { label: 'APELLIDO', name: 'apellido', width: 100 },
//  			           { label: 'NOMBRE', name: 'nombre', width: 100 },
//  			           { label: 'FECHA', name: 'fecha', width: 100 }
  				{ label: 'firstname', name: 'firstname', width: 0, key:true },
	           { label: 'lastname', name: 'lastname', width: 100 },
  			],
  			viewrecords: true,
  			height: 250          
   });  
}

//	$('document').ready(function(){
//		configurarGrilla();
//	});