package com.foodapp.maven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service("UserServiceDao")
public class UserDaoImpl implements UserDao {

	@Override
	public boolean Authenticate(String UserName,String Password,String Phone){
		 Connection conn = null;
		 Statement stmt = null;
		 boolean flag = false;
			
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/db","root","root");  
			stmt=conn.createStatement(); 
			String sql2 = "select * from FOODUSER"; 
			
			ResultSet rs=stmt.executeQuery(sql2); 
			while(rs.next()) {
				 String Uname1  = rs.getString("USERNAME");
		         String password2 = rs.getString("PASSWORD");
		         String phone = rs.getString("PHONE");
		         if(Uname1 != null && password2 != null && phone != null ) {
		        	 if(Uname1.equals(UserName) && password2.equals(Password) && phone.equalsIgnoreCase(Phone) ) {
			        	 flag= true;
			         }else {
			        	 	String sql = "INSERT INTO FOODUSER(USERNAME,PASSWORD,PHONE)" + 
									 "VALUES("+ "'" + UserName + "'" +"," + "'" + Password + "'"  + "," + "'" + Phone + "'"  + ")";
				        	 	stmt.executeUpdate(sql);
				        	 	flag = true;
				         }
		        	 
		         }
		         else {
	        		 flag = false;
	        	 }
		         
		         
			}
			
			conn.close();  
			}catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
		finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		return flag;
	}
}



