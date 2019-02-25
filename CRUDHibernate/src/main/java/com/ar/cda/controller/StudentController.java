package com.ar.cda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ar.cda.model.Student;
import com.ar.cda.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/index")
	public String setupForm(Map <String, Object> map) 
	{
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudents());
		return "student";
	}

	@RequestMapping(value = "/student.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult results, @RequestParam String action, Map<String, Object> map) 
	{
		Student studentFinal = new Student();
		switch(action.toLowerCase())
		{
		case "add":	studentService.add(student);
					studentFinal = student;
					break;
		case "delete": studentService.delete(student.getStudentId());
					   studentFinal = new Student();
					   break;
		case "edit": studentService.edit(student);
					 studentFinal = student;
					 break;
		case "search": Student searchedStudent = studentService.getStudent(student.getStudentId());
					   studentFinal = searchedStudent != null ? searchedStudent : new Student() ;
					   break;
		}
		map.put("student", studentFinal);
		map.put("studentList", studentService.getAllStudents());
		
		return "student";
	}
}