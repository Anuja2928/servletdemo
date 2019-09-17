package com.bv.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;

import com.bv.connection.DBConnect;


public class LoginDao {
	
	
	public static boolean validateuser(String username,String password)

	{
		boolean status= false;
		Connection con=DBConnect.getConnection();
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			PreparedStatement ps=con.prepareStatement(  
			"select name,pass from userreg1 where name=? and pass=?");  
			ps.setString(1,username);  
			ps.setString(2,password);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			
			if(status)
			{
				return status;
			          
			}
		}
		catch(Exception e){System.out.println(e);}  
			return status;  
			}  

	}
	
	

