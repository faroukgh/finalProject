package com.vdoctor.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection dbCon;
	private String userName="root";
	private String pass="";
	private String dbUrl="";
	private String driver="";
	
	public Connection getConnection(){
		try {
			Class.forName(driver).newInstance();
			dbCon= DriverManager.getConnection(dbUrl, userName, pass);
			if (dbCon!=null){
				
			}else {
				
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return dbCon;
		
	}
}
