package main.java.com.ar.cda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.ar.cda.model.Student;
import main.java.com.ar.cda.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) 
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
		List<Student> studentBusqueda = new ArrayList<Student>();
		Student error = new Student();
		switch (action.toLowerCase()) 
		{
			case "add":
						if (student.getApellido().equals("") || student.getNombre().equals("") || student.getLocalidad().equals("") || student.getSexo().equals("T") || student.getEdad() <= 12) //revisa que los campos estén completos 
						{ 
							break;
						} 
						else if (student.getSexo().equals("M") || student.getSexo().equals("F")) 
						{
							//si seleccionó un sexo, añade los datos a la base
							studentService.add(student);
							studentFinal = student;
							break;
						}
			case "delete":
						studentService.delete(student.getStudentId());
						studentFinal = new Student();
						break;
			case "edit":
						studentService.edit(student);
						studentFinal = student;
						break;
			// case "search":
			// studentBusqueda=studentService.busqueda(student.getNombre());
			//// Student searchedStudent =
			// studentService.getStudent(student.getStudentId());
			//// studentFinal = searchedStudent != null ? searchedStudent : new
			// Student() ;
			//// if(studentFinal.getNombre() == null) {error.setNombre("Usuario no
			// existe");}
			// break;
		}

			map.put("error", error);
			map.put("studentA", studentFinal);
			map.put("studentList", studentService.getAllStudents()); // en cada uso del controlador aplica el metodo que llama a toda la tabla
	
			return "student";
	}

	@RequestMapping(value = "/search.student", method = RequestMethod.POST)
	public String controllerBusqueda(@ModelAttribute Student student, BindingResult results, @RequestParam String n, @RequestParam String a, @RequestParam Integer e, @RequestParam String l, @RequestParam String s, Map<String, Object> map) 
	{
		List<Student> studentBusqueda = new ArrayList<Student>();
		Student studentIdOnly = new Student();
		
		if (n != "") 
		{
			studentBusqueda = studentService.busqueda("Nombre", n);
		}
		else 
			if (a != "") 
			{
				studentBusqueda = studentService.busqueda("Apellido", a);
			}
			else 
			{
				if (l != "") 
				{
					studentBusqueda = studentService.busqueda("Localidad", l);
				}
				else
				{
					if (e != null ) 
					{
						if(e > 12)
						{
							studentBusqueda = studentService.busquedaEdad("Edad", e);
						}
					}
					else 
					{
						studentBusqueda = studentService.busqueda("Sexo", s);
					}
				}
			}

//		switch (action) {
//		case "Nombre":
//			studentBusqueda = studentService.busqueda(action, n);
//			break;
//		case "Apellido":
//			studentBusqueda = studentService.busqueda(action, a);
//			break;
//		case "Localidad":
//			studentBusqueda = studentService.busqueda(action, l);
//			break;
//		case "Edad":
//			studentBusqueda = studentService.busquedaEdad(action, e);
//			break; 
//		case "Sexo":
//			studentBusqueda = studentService.busqueda(action, s);
//			break;
//		}

		map.put("studentList", studentService.getAllStudents()); // en cada uso del controlador aplica el metodo que llama a toda la tabla
		map.put("studentid", studentIdOnly);
		map.put("studentListBusqueda", studentBusqueda);
		return "student";
	}
}