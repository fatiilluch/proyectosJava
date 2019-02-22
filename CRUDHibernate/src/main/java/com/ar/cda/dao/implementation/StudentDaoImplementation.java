package com.ar.cda.dao.implementation;

import java.util.List;

import javax.management.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ar.cda.dao.StudentDao;
import com.ar.cda.model.Student;

@Repository
public class StudentDaoImplementation implements StudentDao
{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Student student) 
	{
		session.getCurrentSession().getTransaction().begin();;
		session.getCurrentSession().save(student);	
		session.getCurrentSession().getTransaction().commit();
		session.getCurrentSession().close();
	}

	@Override
	public void edit(Student student) 
	{
		session.getCurrentSession().getTransaction().begin();;
		session.getCurrentSession().update(student);
		session.getCurrentSession().getTransaction().commit();
		session.getCurrentSession().close();
	}

	@Override
	public void delete(int studentId) 
	{
		session.getCurrentSession().getTransaction().begin();;
		session.getCurrentSession().delete(this.getStudent(studentId));
		session.getCurrentSession().getTransaction().commit();
		session.getCurrentSession().close();
	}

	@Override
	public Student getStudent(int studentId) 
	{
		return (Student) session.getCurrentSession().get(Student.class, studentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() 
	{
		session.getCurrentSession().getTransaction().begin();
		org.hibernate.Query query = session.getCurrentSession().createQuery("from Student");
		List <Student> students = query.list();
		session.getCurrentSession().getTransaction().commit();
		session.getCurrentSession().close();
		return students;
	}
}
