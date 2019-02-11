package com.ar.cda.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ar.cda.model.Trello;

@Controller
public class TrelloController {

//    /**
//     * @param response
//     * @param file
//     * @throws Exception
//     */
//    @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
//    @ResponseBody
//    public void descargarArchivo(HttpServletResponse response, String file) throws Exception
//    {	
//      TrelloService trelloService = new TrelloService();
//      byte[] archivo = trelloService.leerArchivo(file).getBytes();
//      response.setContentType("application/octet-stream"); 
//      response.setHeader("Content-Disposition", "filename = ArchivoTrello.json"); 
//      trelloService.leerArchivoJSON(file);
//      OutputStream outputStream = response.getOutputStream();
//      outputStream.write(archivo);
//      outputStream.close();
//      }
    
//	//ver pagina www.uv.es/grimo/teaching/springMVC4pasoapaso/

  @RequestMapping(value = "recibeDatos")
  public String trello(Model model, HttpServletRequest request) 
  {
  	Trello persona = new Trello (request.getParameter("nombre"), request.getParameter("apellido"),Integer.parseInt(request.getParameter("edad")));
  	
  	model.addAttribute("persona",persona);
 
  	return "recibeDatos";
  }
	
	
//	//@ResponseBody
//    @RequestMapping(value = "recibeDatos",params = {"nombre", "apellido", "edad" }, method = RequestMethod.GET)
//    public String trello(Model model, 
//    		 @RequestParam("nombre") String nombre,
//    	     @RequestParam("apellido") String apellido,
//    	     @RequestParam("edad") int edad) 
//    {
//    	Trello persona = new Trello (nombre, apellido, edad);
//    	
//    	model.addAttribute("persona",persona);
//   
//    	return "recibeDatos";
//    }
	

}

