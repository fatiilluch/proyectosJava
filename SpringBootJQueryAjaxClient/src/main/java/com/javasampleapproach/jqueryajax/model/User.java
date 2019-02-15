package com.javasampleapproach.jqueryajax.model;

import java.util.Date;

public class User {

	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private Date fecha;

	public User() {
		super();
		
	}

	public User(int id, String nombre, String apellido, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
