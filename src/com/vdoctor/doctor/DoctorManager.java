package com.vdoctor.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vdoctor.connection.DatabaseConnection;


public class DoctorManager {
	private Connection conn=new DatabaseConnection().getConnection();
	private PreparedStatement psm;
	//private boolean status=false;
	private String query="";

	
	public Doctor getPatient(){
		
		Doctor selDoctor=new Doctor();
		query="select * from tbldoctor where specialization=?";
			
		
		try {
			psm = conn.prepareStatement(query);
			psm.setString(4, selDoctor.getSpecialization());
			ResultSet rs = psm.executeQuery();
			while(rs.next())
			{
				selDoctor.setfName(rs.getString("fname"));
				selDoctor.setSpecialization(rs.getString("specialization"));
				selDoctor.setHospital(rs.getString("hospital"));
				selDoctor.setPhone(rs.getInt("phone"));
				
				
				
			}
			return selDoctor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		return selDoctor;
		
	}
	

}
	
