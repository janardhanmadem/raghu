package com.apalya;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.*;

public class validate {
	public static boolean checkuser(String email,String realname){
		boolean st=false;
		try{
			System.out.println(email);
			System.out.println(realname);
					      Class.forName("com.mysql.jdbc.Driver");
					      System.out.println("\t class loaded successfully");		      
			     Connection conn = DriverManager.getConnection("jdbc:mysql://intranet.myplex.in/bugs","readnly","R51D0nLU");
			    java.sql.PreparedStatement ps=conn.prepareStatement("select *  from profiles where login_name=? and realname=?");
			    ps.setString(1, email);
			    ps.setString(2, realname);
			    java.sql.ResultSet rs=ps.executeQuery();
			    st=rs.next();
			    
		}catch(Exception e){
			System.out.println("error"+e.getMessage());
			e.printStackTrace();
		}
		return st;
	}

}
