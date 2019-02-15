package com.javasampleapproach.jqueryajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.model.Customer;
import com.javasampleapproach.jqueryajax.model.User;

@RestController
public class RestWebController {

	List<Customer> cust = new ArrayList<Customer>();
	
	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	public Response getResource() {
		//hacer que guarde los clientes y que me mande a la grilla de una 
		Response response = new Response("Done", cust);
		postUser (cust.get(0));
		return response;
	}

	@RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Customer customer) {
		cust.add(customer);
		// Create Response Object
		Response response = new Response("Done", customer);
		postUser (customer);
		
		return response;
	}
	
	@RequestMapping(value = "/prueba", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Customer> postUser(Customer customer){
		
		List<Customer> listUser = new ArrayList<Customer>();
		
		Date fecha = new Date();
		
//		customer.setId(1);
//		customer.setApellido("asd");
//		customer.setNombre("franco");
//		customer.setFecha(fecha);
//		
		customer.getFirstname();
		customer.getLastname();
		
		listUser.add(customer);

		return listUser;
		
	}
	
}