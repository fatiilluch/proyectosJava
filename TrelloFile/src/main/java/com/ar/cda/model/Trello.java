package com.ar.cda.model;

public class Trello {

    private String nombre;
    private String apellido;
    private Integer edad;
    
    public Trello (String nombre, String apellido, int edad) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.edad = edad;
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
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
    return this.nombre + " " + this.apellido + " " + this.edad;
    }    
}
