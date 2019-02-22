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
		session.getCurrentSession().save(student);	
	}

	@Override
	public void edit(Student student) 
	{
		session.getCurrentSession().update(student);
	}

	@Override
	public void delete(int studentId) 
	{
		session.getCurrentSession().delete(this.getStudent(studentId));
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
		return session.getCurrentSession().createQuery("from Student");
	}
}
