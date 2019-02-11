package Modelo;

import java.util.Date;

public class Persona {

	private String nombre;
	private String apellido;
	private Integer edad;
	private Date fecha;
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, Integer edad, Date fecha) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fecha = fecha;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
