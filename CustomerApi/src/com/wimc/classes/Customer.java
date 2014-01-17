package com.wimc.classes;

public class Customer {

	String name;
	String ID;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String iD) {
		super();
		this.name = name;
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" : "+ ID;
	}
}
