package Service;

import java.util.Date;

import Modelo.Persona;
import Utils.Validate;

public class PersonaService {

	public Persona altaPersona(String nombre,String apellido,Integer edad,Date fecha)
	{
		Persona p = new Persona();
		Validate validate = new Validate();
		if(validate.validarNombre(nombre).equals("OK")){
			p.setNombre(nombre);
			p.setApellido(apellido);
			p.setEdad(edad);
			p.setFecha(fecha);
			return p;
		}else{
			return p;
		}	
	}
	
	
	
	
}
