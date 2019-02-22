package com.ar.cda.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ar.cda.dao.StudentDao;
import com.ar.cda.model.Student;
import com.ar.cda.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService 
{	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public void add(Student student) 
	{
		studentDao.add(student);
	}

	@Override
	@Transactional
	public void edit(Student student) 
	{
		studentDao.edit(student);
	}

	@Override
	@Transactional
	public void delete(int studentId) 
	{
		studentDao.delete(studentId);
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) 
	{
		return studentDao.getStudent(studentId);
	}

	@Override
	@Transactional
    	public List getAllStudents() 
    	{
        	return studentDao.getAllStudents();
    	}
}
