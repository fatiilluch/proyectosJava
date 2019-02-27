package main.java.com.ar.cda.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.ar.cda.dao.StudentDao;
import main.java.com.ar.cda.model.Student;

@Repository
public class StudentDaoImplementation implements StudentDao {
	@Autowired
	private SessionFactory session;
	
	//private Criteria crit;

	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);
	}

	@Override
	public void delete(int studentId) {
		session.getCurrentSession().delete(this.getStudent(studentId));
	}

	@Override
	public Student getStudent(int studentId) {
		return (Student) session.getCurrentSession().get(Student.class, studentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		return session.getCurrentSession().createQuery("from Student").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> busqueda(String columna, String Letra) {//Busca Students 
		return session.getCurrentSession().createCriteria(Student.class).add(Restrictions.like(columna, Letra + "%", MatchMode.ANYWHERE)).list();	

	}
}
