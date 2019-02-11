package Controller;

import java.util.Date;

import Exception.PersonaException;
import Service.PersonaService;

@Controller
public class PersonaController{

	public String crearPersona(String nombre,String apellido,Integer edad,Date fecha) throws PersonaException{
		
		PersonaService pService = new PersonaService();
		pService.altaPersona(nombre, apellido, edad, fecha);
		if(pService != null){
			
			return "OK";
		}else{
			 throw new PersonaException("askjdghsj"); 
		}
		
	}
	
	
	
}
