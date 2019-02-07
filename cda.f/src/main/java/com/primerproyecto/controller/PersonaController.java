package com.primerproyecto.controller;

import com.primerproyecto.entity.Persona;
import com.primerproyecto.service.PersonaService;

public class PersonaController {

	private Persona personaInfo;
	
	private String mensajeUsuario;
	
	private PersonaService personaService;
	
	/* Esta clase es la que se conecta el jsp(pantalla en html)  y el java, y se usa como orquestador **/
	public String guardarPersona() {
		
		try {
			personaService.guardarPersona(personaInfo);
			setMensajeUsuario("Se creo con exito");		
			return "SUCCESS";
		} catch (Exception e) {
			setMensajeUsuario(e.getMessage());
			return "FAILED";
		}
		
		
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	
	
}
