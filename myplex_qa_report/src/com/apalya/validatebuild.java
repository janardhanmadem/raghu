package com.apalya;

import java.sql.Connection;
import java.sql.DriverManager;

public class validatebuild {
	public static boolean checkbuild(String target_milestone){
		boolean st=false;
		try{
			System.out.println("target_milestone");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://intranet.myplex.in/bugs","readnly","R51D0nLU");
			    java.sql.PreparedStatement ps=conn.prepareStatement("select * from cf_target_release where value=?");
			    ps.setString(1, target_milestone);
			    java.sql.ResultSet rs=ps.executeQuery();
			    st=rs.next();
			    
		}catch(Exception e){
			System.out.println("error"+e.getMessage());
			e.printStackTrace();
		}
		return st;
	}

}
