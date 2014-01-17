package com.vdoctor.patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

//import javax.xml.ws.handler.MessageContext;




import com.vdoctor.connection.DatabaseConnection;



public class PatientManager {
	private Connection conn=new DatabaseConnection().getConnection();
	private PreparedStatement psm;
	//private Statement stmt;
	private boolean status=false;
	//private Patient pat;
	private String query="";
	//private ResultSet rs;
	
	public boolean addPatient(Patient pat) {
		query="insert into tblpatient values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
			try {
				psm= conn.prepareStatement(query);
				psm.setString(1, pat.getfName());
				psm.setDate(2, (Date) pat.getDob());
				psm.setInt(3, pat.getAge());
				psm.setString(4, pat.getGender());
				psm.setInt(5, pat.getPhone());
				psm.setString(6, pat.getAddress());
				psm.setString(7, pat.getComplaint());
				psm.setString(8, pat.getFinding());
				psm.setString(9, pat.getTreatment());
				psm.setString(10, pat.getDoctor());
				psm.setString(11, pat.getHospital());
				psm.setDate(12, (Date) pat.getRecDate());
				psm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return status;
	}
		public Patient getPatient(){
			
			Patient selPatient=new Patient();
			query="select * from tblpatient where phone =?";
				
			
			try {
				psm = conn.prepareStatement(query);
				psm.setInt(5, selPatient.getPhone());
				ResultSet rs = psm.executeQuery();
				while(rs.next())
				{
					selPatient.setfName(rs.getString("fname"));
					selPatient.setAge(rs.getInt("age"));
					selPatient.setGender(rs.getString("gender"));
					selPatient.setPhone(rs.getInt("phone"));
					selPatient.setComplaint(rs.getString("complaint"));
					selPatient.setFinding(rs.getString("finding"));
					selPatient.setTreatment(rs.getString("treatment"));
					selPatient.setDoctor(rs.getString("doctor"));
					selPatient.setRecDate(rs.getDate("recDate"));
					
					
				}
				return selPatient;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
			
			
			
			
			return selPatient;
			
		}
		
	

	
	
	

}
