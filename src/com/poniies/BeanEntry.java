package com.poniies;

import javax.servlet.http.HttpServletRequest;

public class BeanEntry {
	
	private String name;
	private String surname;
	private String number;
	private String sex;
	
	
	public BeanEntry(String name, String surname, String number, String sex) {
		super();
		this.name = name;
		this.surname = surname;
		this.number = number;
		this.sex = sex;
	}
	
	public BeanEntry(HttpServletRequest request) {
		this.name = request.getParameter("fname");
		this.surname = request.getParameter("lname");
		this.number = request.getParameter("number");
		
		String sex_ctrl =  request.getParameter("sex");
		
		if (sex_ctrl.equals("other")) {
			sex_ctrl=request.getParameter("other");
		}
		
		this.sex=sex_ctrl;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "BeanEntry [name=" + name + ", surname=" + surname + ", number=" + number + ", sex=" + sex + "]";
	}
}
