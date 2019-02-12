package com.ar.cda.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ar.cda.model.Trello;

@Controller
public class TrelloController {

	// /**
	// * @param response
	// * @param file
	// * @throws Exception
	// */
	// @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
	// @ResponseBody
	// public void descargarArchivo(HttpServletResponse response, String file)
	// throws Exception
	// {
	// TrelloService trelloService = new TrelloService();
	// byte[] archivo = trelloService.leerArchivo(file).getBytes();
	// response.setContentType("application/octet-stream");
	// response.setHeader("Content-Disposition", "filename =
	// ArchivoTrello.json");
	// trelloService.leerArchivoJSON(file);
	// OutputStream outputStream = response.getOutputStream();
	// outputStream.write(archivo);
	// outputStream.close();
	// }

	// //ver pagina www.uv.es/grimo/teaching/springMVC4pasoapaso/

	@SuppressWarnings({ "unchecked" })
  @RequestMapping(value = "recibeDatos", method = RequestMethod.GET)
  public String trello(HttpServletRequest req) throws ParseException 
  {	
	File file = new File("C:\\workspace2\\pruebaDos.json");
	Object object = new Object();
	JSONObject datos = new JSONObject();
	JSONArray array = new JSONArray();
	
	if(file.exists() && file.length()!=0)
	{
		try
		{
			FileReader fr = new FileReader(file); // lee el archivo 
			JSONParser parser = new JSONParser(); //creo el parser
			object = parser.parse(fr); //guardamos en el objeto lo que se va a leer
			array.put(object); //ponemos el archivo en un array
			
			datos.put("nombre",req.getParameter("nombre"));
			datos.put("apellido", req.getParameter("apellido"));
			datos.put("edad", req.getParameter(String.valueOf("edad")));
				
			array.put(datos);
				
			FileWriter writer = new FileWriter("C:\\workspace2\\pruebaDos.json");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(array.toString());
			bw.newLine();
			bw.flush();
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	else
	{
		try
		{
			datos.put("nombre",req.getParameter("nombre"));
			datos.put("apellido", req.getParameter("apellido"));
			datos.put("edad", req.getParameter(String.valueOf("edad")));
				
			array.put(datos);
				
			FileWriter writer = new FileWriter("C:\\workspace2\\pruebaDos.json");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(array.toString());
			bw.newLine();
			bw.flush();
			bw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	return "redirect:trello.jsp";
  }
	
}
		
//    	return "recibeDatos";
//    }
	

}

