package com.wimc.tester;

import com.wimc.classes.Customer;
import com.wimc.dao.CustomerDao;

public class MyTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		Customer c = dao.getCustomer();
		System.out.println(c);
		
	}

}
