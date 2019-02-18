package com.javasampleapproach.jqueryajax.model;

public class Customer {
    private String firstname;
    private String lastname;
    private Integer id;
     
    public Customer(){}
     
    public Customer(String firstname, String lastname, Integer id){
        this.firstname = firstname;
        this.lastname = lastname;
        this.setId(id);
    }
     
    // firstname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
     
    // lastname
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}