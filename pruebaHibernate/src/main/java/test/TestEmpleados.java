package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Empleado;

public class TestEmpleados 
{
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	public static void main(String[] args)
	{
//		manager.persist(entity); --> insertar cosas
//		manager.merge(entity) --> modifica cosas
//      manager.remove(entity); --> elimina cosas
//		manager.find(entityClass, primaryKey) --> obtiene una entidad de una BD a partir de su PK
//		manager.getTransaction() --> metodo para hacer una transaccion (permite insertar multiples elementos)
//		manager.createQuery(deleteQuery) --> querys que nos permiten obtener de la BD lo que busquemos
		
		/* Creamos el gestor de persistencia (EM) */
		manager = emf.createEntityManager();
		
		//Esto devuelve todos los empleados del sistema
		@SuppressWarnings("unchecked")
		List <Empleado> empleados =  manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta base de datos hay " + empleados.size() + "empleados");
	}
}
