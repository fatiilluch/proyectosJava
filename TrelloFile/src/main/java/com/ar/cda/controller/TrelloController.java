package com.ar.cda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value = "recibeDatos",params = {"nombre", "apellido", "edad" }, method = RequestMethod.GET)
    public String trello(Model model, 
    		 @RequestParam("nombre") String nombre,
    	     @RequestParam("apellido") String apellido,
    	     @RequestParam("edad") int edad) 
    {
    	Trello persona = new Trello (nombre, apellido, edad);
    	
    	model.addAttribute("persona",persona);
   
    	return "/recibeDatos";
    }
	
//	@RequestMapping("/trello")
//	public ModelAndView helloWorld()
//	{
//		ModelAndView model = new ModelAndView("trello");
//		model.addObject("msg", "HelloWorld");
//		
//		return model;
//	}
}

