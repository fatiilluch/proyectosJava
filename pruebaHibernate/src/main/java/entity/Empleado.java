package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  // de esta manera JPA reconoce a Empleado como entidad
@Table(name = "Empleado")
public class Empleado implements Serializable
{ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Cod_Empleado")
	private long codigo;
	
	@Column(name = "Nombre_Empleado")
	private String nombre;
	
	@Column(name = "Apellido_Empleado")
	private String apellido;
	
	@Column(name = "Edad_Empleado")
	private Integer edad;
	
	@Column(name = "FechaNac_Empleado")
	private Date fechaNac;
	
	Empleado(long unDni, String unNombre, String unApellido, Integer unaEdad, Date unaFecha)
	{
		this.codigo = unDni;
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.edad = unaEdad;
		this.fechaNac = unaFecha;
	}
	
	Empleado(){}
	
	public long getCodigo() { return codigo; }
	
	public void setCodigo(long codigo) { this.codigo = codigo; }
	
	public String getNombre() {	return nombre; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getApellido() { return apellido; }
	
	public void setApellido(String apellido) { this.apellido = apellido; }
	
	public Integer getEdad() { return edad; }
	
	public void setEdad(Integer edad) { this.edad = edad; }
	
	public Date getFechaNac() { return fechaNac; }
	
	public void setFechaNac(Date fechaNac) { this.fechaNac = fechaNac; }
	
	@Override
	public String toString()
	{
		return "Empleado: " +
			   "DNI: " + this.codigo + "\n" +
			   "Nombre: " + this.nombre + "\n" +
			   "Apellido: " + this.apellido + "\n" +
			   "Edad: " + this.edad + "\n" +
			   "Fecha de Nacimiento: " + this.fechaNac;
	}
}
