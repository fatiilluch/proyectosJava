package test;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Empleado;

public class TestEmpleados {
	// @PersistenceContext(unitName = "Persistencia")
	private static EntityManager manager;

	private static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		// manager.persist(entity); --> insertar cosas
		// manager.merge(entity) --> modifica cosas
		// manager.remove(entity); --> elimina cosas
		// manager.find(entityClass, primaryKey) --> obtiene una entidad de una
		// BD a partir de su PK
		// manager.getTransaction() --> metodo para hacer una transaccion
		// (permite insertar multiples elementos)
		// manager.createQuery(deleteQuery) --> querys que nos permiten obtener
		// de la BD lo que busquemos

		/* Creamos el gestor de persistencia (EM) */ 
		manager = emf.createEntityManager();// lo que se hace en muchos sistemas web es iniciar el manager cuando se necesita y borrarlo cuando finaliza la ejecucuion, porque hay veces que los usuarios tardan en llenar los formularios y demas, por lo tanto gaastan recursos  

		// //Esto devuelve todos los empleados del sistema
		// @SuppressWarnings("unchecked")
		// List <Empleado> empleados = manager.createQuery("FROM
		// Empleado").getResultList();
		// System.out.println("En esta base de datos hay " + empleados.size() +
		// " empleados");

		
		insertInicial();
		//supongamos que queremos saber los del empleado numero 10L. 
		//existe un metodo llamado "find" que nos permite obtener elementos a partir de su modificador
		
		manager.getTransaction().begin();
		Empleado e = manager.find(Empleado.class, 10L);
		e.setNombre("Fulana");
		e.setApellido("Perez");
		
	//	manager.merge(entity); // podemos obtener una entidad administrad a partir de una entidad no administrada 
		
		manager.getTransaction().commit();
		
		// metodo que me permita imprimir todos los elementos de la BD por comodidad
		imprimiTodo();
		manager.close(); //aqui, cualquier entity deja de estar administrada
	}

	private static void insertInicial() 
	{
		Empleado e = new Empleado(10L, "Fatima", "Lluch", 25, LocalDate.of(1993, 6, 17));
		Empleado e2 = new Empleado(11L, "Natalia María", "Giai", 25, LocalDate.of(1993, 6, 26));
		
		// En una transaccion se pueden hacer varias operaciones con la BD y no
		// se hace efectiva hasta que llega al "commit"
		manager.getTransaction().begin();
		manager.persist(e); // con persist podes almacenar elementos en la base de datos
								// si necesitamos hacerle un cambio a algun
								// empleado, lo podemos hacer entre begin() y
		manager.persist(e2);    // commit() y automaticamente sera persistida
								// (se haran los cambios sin necesidad de llamar
								// a los metodos)
		manager.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	private static void imprimiTodo() {
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay " + empleados.size() + " empleado/s en el sistema");

		for (Empleado emple : empleados) {
			System.out.println(emple.toString());
		}
	}
}
