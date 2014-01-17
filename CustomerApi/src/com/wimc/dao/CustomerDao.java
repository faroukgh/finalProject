package com.wimc.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wimc.classes.Customer;

public class CustomerDao {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public CustomerDao() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","willynex", "abba");
			System.out.println("CONNECTION ESTABLISHED");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Customer getCustomer()
	{
		Customer cm = new Customer("NULL", "NULL");
		String sql = "select * from customer where id = 1023";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next())
			{
				cm.setName(rs.getString(1));
				cm.setID(rs.getString(2));
			}
			return cm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return cm;
			
		}
	}

}
