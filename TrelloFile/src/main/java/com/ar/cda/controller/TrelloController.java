package com.ar.cda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ar.cda.model.Trello;

@Controller
public class TrelloController 
{   
    //Con AJAX
    @RequestMapping(value = "recibeDatos",params = {"nombre", "apellido", "edad" }, method = RequestMethod.GET)
    public String trello(Model model, 
    		 @RequestParam("nombre") String nombre,
    	     @RequestParam("apellido") String apellido,
    	     @RequestParam("edad") int edad) 
    {
    	Trello persona = new Trello (nombre, apellido, edad);
    	
    	model.addAttribute("persona",persona);
   
    	return "recibeDatos";
    }
    
    //Sin AJAX
    @RequestMapping(value = "recibeDatos")
    public String trello(Model model, HttpServletRequest request) 
    {
  	Trello persona = new Trello (request.getParameter("nombre"), request.getParameter("apellido"),Integer.parseInt(request.getParameter("edad")));
  	
  	model.addAttribute("persona",persona);
 
  	return "recibeDatos";
  }
}
