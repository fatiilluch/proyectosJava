package com.ar.cda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tablaPruebas")
public class Student 
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO) //for autonumber
	private int id;
	
	@Column
	private String Nombre;
	
	@Column
	private String Apellido;
	
//	@Column
//	private int añoCursada;
	
	public Student(int studentId, String nombre, String apellido, int añoCursada) 
	{
		this.id = studentId;
		this.Nombre = nombre;
		this.Apellido = apellido;
		//this.añoCursada = añoCursada;
	}

	public Student() {}
	
	public int getStudentId() 
	{
		return id;
	}
	
	public void setStudentId(int studentId) 
	{
		this.id = studentId;
	}
	
	public String getNombre() 
	{
		return Nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.Nombre = nombre;
	}
	
	public String getApellido() 
	{
		return Apellido;
	}
	
	public void setApellido(String apellido) 
	{
		this.Apellido = apellido;
	}
	
//	public int getAnioCursada() 
//	{
//		return añoCursada;
//	}
//	
//	public void setAnioCursada(int añoCursada) 
//	{
//		this.añoCursada = añoCursada;
//	}
}