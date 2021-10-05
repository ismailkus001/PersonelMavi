package com.proje.person.model;

public class Person {
	private Integer id,age;
	private String name,surname,email,city,gender,TCKN;
	
	
	
	public Person(Integer id,  String name, String surname, String email, String city, String gender,Integer age,String TCKN) {
		this(name,surname,email,city,gender,age,TCKN);
		this.id=id;
	
	
	}
	public Person( String name,String surname, String email,String city, String gender,Integer age,String TCKN)
	{
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.TCKN=TCKN;
	
	}
	public String getTCKN() {
		return TCKN;
	}
	public void setTCKN(String tCKN) {
		TCKN = tCKN;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
