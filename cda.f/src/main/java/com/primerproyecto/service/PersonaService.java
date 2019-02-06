package com.primerproyecto.service;

import com.primerproyecto.dao.PersonaDao;
import com.primerproyecto.entity.Persona;

public class PersonaService {

	private PersonaDao personaDao;
	
	public void guardarPersona(Persona personaInfo) throws Exception {
		Persona personaBuscada = personaDao.findPersonaByNroDNI(personaInfo.getDni());
		if(personaBuscada==null) {
			personaDao.guardar(personaInfo);
		}
		else {
			throw new Exception("Error ya existe en la base de datos una persona con este dni " + personaInfo.getDni());
		}
	}

}
