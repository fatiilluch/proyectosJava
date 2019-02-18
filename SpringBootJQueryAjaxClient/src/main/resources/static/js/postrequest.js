$( document ).ready(function() {
	
	var url = window.location;
	
	// SUBMIT FORM
    $("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		firstname : $("#firstname").val(),
    		lastname :  $("#lastname").val()
    	}
    	
    	if (formData.firstname != "" && formData.lastname != "")
    	{
    		// DO POST
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : url + "/postcustomer",
    			data : JSON.stringify(formData),
    			dataType : 'json',
    			success : function(result) {
    				if(result.status == "Done"){
    					$("#postResultDiv").html("Done");
    				}else{
    					$("#postResultDiv").html("<strong>Error</strong>");
    				}
    				//console.log(result);
    			},
    			error : function(e) {
    				alert("Error!")
    				console.log("ERROR: ", e);
    			}
    		});
    	}
    	else 
    	{
    		alert(" Error, debe ingresar campos válidos ");
    	}
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#firstname").val("");
    	$("#lastname").val("");
    }
})