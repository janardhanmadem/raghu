package com.apalya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ex1 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    Date today = new Date();
    out.println("<html>");
    out.println("<head><title>Bug Report</title></head>");
    out.println("<body>");
    out.println("<center><h1><font face='Arial'>Bug Report</font></h1></center>");
    
    Connection conn = null;
    Statement stmt_1=null,stmt_2 = null,stmt_3=null,stmt_4=null;
    ResultSet rs_1=null,rs_2=null,rs_3=null,rs_4=null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://intranet.myplex.in/bugs","readnly","R51D0nLU");
      stmt_1 = conn.createStatement();
      stmt_2=conn.createStatement();
      stmt_3=conn.createStatement();
      stmt_4=conn.createStatement();
      String x=(String)request.getAttribute("target_milestone");
      System.out.println(" Target Release is "+x);
      out.println("<h2><font face='Calibri'>Targeted Release : "+x+"</font></h2>");
      
      out.println("<p><font face='Calibri'>Time Stamp: " + today + "</font></p>");
      String query_1="select @row :=@row+1 as Sno,bug_id as 'Bug ID',short_desc as 'Summary',cf_build_number as 'Build Number',bug_severity as 'Bug Severity',bug_status as 'Bug Status' from bugs,(SElECT @row:=0)r where (bug_status ='ASSIGNED' OR bug_status ='NEEDS INFO' OR bug_status ='REOPENED' OR bug_status ='RESOLVED' OR bug_status ='VERIFIED') AND cf_target_release='"+x+"' and bug_severity='critical (S1)'";
      String query_2="select @row :=@row+1 as Sno,bug_id as 'Bug ID',short_desc as 'Summary',cf_build_number as 'Build Number',bug_severity as 'Bug Severity',bug_status as 'Bug Status' from bugs,(SElECT @row:=0)r where (bug_status ='ASSIGNED' OR bug_status ='NEEDS INFO' OR bug_status ='REOPENED' OR bug_status ='RESOLVED' OR bug_status ='VERIFIED') AND cf_target_release='"+x+"' and bug_severity='major (S2)'";
      String query_3="select @row :=@row+1 as Sno,bug_id as 'Bug ID',short_desc as 'Summary',cf_build_number as 'Build Number',bug_severity as 'Bug Severity',bug_status as 'Bug Status' from bugs,(SElECT @row:=0)r where (bug_status ='ASSIGNED' OR bug_status ='NEEDS INFO' OR bug_status ='REOPENED' OR bug_status ='RESOLVED' OR bug_status ='VERIFIED') AND cf_target_release='"+x+"' and bug_severity='normal (S3)'";
      String query_4="select @row :=@row+1 as 'Sno',bug_id as 'Bug ID',short_desc as 'Summary',cf_build_number as 'Build Number',bug_severity as 'Bug Severity',bug_status as 'Bug Status' from bugs,(SElECT @row:=0)r where bug_status ='CLOSED' AND cf_target_release='"+x+"' ORDER by bug_severity";
     
      rs_1=stmt_1.executeQuery(query_1);
      rs_2=stmt_2.executeQuery(query_2);
      rs_3=stmt_3.executeQuery(query_3);
      rs_4=stmt_4.executeQuery(query_4);
   
     //Print first table
    			 int rowCount_1 = 0;
                 out.println("<center><h3><font face='Calibri'> Critical Bugs</font></h3></center>");  
    			 out.println("<P ALIGN='center'><TABLE BORDER=3 bordercolor=#2E64FE bgcolor=#FFFFFF width=75% cellspacing=2 cellpadding=3  >");
    			 ResultSetMetaData rsmd_1 = rs_1.getMetaData();
    			 int columnCount_1 = rsmd_1.getColumnCount();
    			 
    			 // table header
    			 out.println("<TR>");
    			 for (int i = 0; i < columnCount_1; i++) {
    					   out.println("<TH><font face='Arial'>" + rsmd_1.getColumnLabel(i + 1) + "</font></TH>");
    			   
    			   }
    			 out.println("</TR>");
    			 // the data
    			 while (rs_1.next()) {
    				 rowCount_1++;
    			  out.println("<TR>");
    			  for (int i = 0; i < columnCount_1; i++) {
    				  if(i==0){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_1.getString(i + 1) + "</font></TD>");  
    				  }else if(i==1){
    					  out.println("<TH><font face='Calibri'><a href=https://intranet.myplex.in/bugzilla/show_bug.cgi?id=" + rs_1.getString(i + 1) + ">" + rs_1.getString(i + 1) + "</a></font></TH>");
    				  }else if(i==3){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_1.getString(i + 1) + "</font></TD>");
    				  }
    				  else if(i==4){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_1.getString(i + 1) + "</font></TD>");  
    				  }else if(i==5){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_1.getString(i + 1) + "</font></TD>"); 
    				  }else{
    					  out.println("<TD><font face='Calibri'>" + rs_1.getString(i + 1) + "</font></TD>");
    				  }
    			    }
    			  out.println("</TR>");
    			  }
    			 out.println("</TABLE></P>");
      
    			// }
    			 //2nd table print
    		     int row_count_2=0;
    		     out.println("<center><h3><font face='Calibri'> Major Bugs</font></h3></center>"); 
    		    out.println("<P ALIGN='center'><TABLE BORDER=3 bordercolor=#2E64FE bgcolor=#FFFFFF width=75% cellspacing=2 cellpadding=3 >");
    			 ResultSetMetaData rsmd_2 = rs_2.getMetaData();
    			 int columnCount_2 = rsmd_2.getColumnCount();
    			 // table header
    			 out.println("<TR>");
    			 for (int i = 0; i < columnCount_2; i++) {
    			   out.println("<TH><font face='Arial'>" + rsmd_2.getColumnLabel(i + 1) + "</font></TH>");
    			   }
    			 out.println("</TR>");
    			 // the data
    			 while (rs_2.next()) {
    				 row_count_2++;
    			  out.println("<TR>");
    			  for (int i = 0; i < columnCount_2; i++) {
    				  if(i==0){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_2.getString(i + 1) + "</font></TD>");  
    				  }else if(i==1){
    					  out.println("<TH><font face='Calibri'><a href=https://intranet.myplex.in/bugzilla/show_bug.cgi?id=" + rs_2.getString(i + 1) + ">" + rs_2.getString(i + 1) + "</a></font></TH>");
    				  }else if(i==3){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_2.getString(i + 1) + "</font></TD>");
    				  }else if(i==4){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_2.getString(i + 1) + "</font></TD>");  
    				  }else if(i==5){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_2.getString(i + 1) + "</font></TD>"); 
    				  }else{
    					  out.println("<TD><font face='Calibri'>" + rs_2.getString(i + 1) + "</font></TD>");
    				  }
    			    }
    			  out.println("</TR>");
    			  }
    			 out.println("</TABLE></P>");
    			 
    			 //3rd table
    			 int row_count_3=0;
    			 out.println("<center><h3><font face='Calibri'> Minor Bugs</font></h3></center>"); 
     		    out.println("<P ALIGN='center'><TABLE BORDER=3 bordercolor=#2E64FE bgcolor=#FFFFFF width=75% cellspacing=2 cellpadding=3 >");
     			 ResultSetMetaData rsmd_3 = rs_3.getMetaData();
     			 int columnCount_3 = rsmd_3.getColumnCount();
     			 // table header
     			 out.println("<TR>");
     			 for (int i = 0; i < columnCount_3; i++) {
     			   out.println("<TH><font face='Arial'>" + rsmd_3.getColumnLabel(i + 1) + "</font></TH>");
     			   }
     			 out.println("</TR>");
     			 // the data
     			 while (rs_3.next()) {
     				 row_count_3++;
     			  out.println("<TR>");
     			  for (int i = 0; i < columnCount_3; i++) {
     				 if(i==0){
   					  out.println("<TD align='center'><font face='Calibri' >" + rs_3.getString(i + 1) + "</font></TD>");  
   				  }else if(i==1){
   					  out.println("<TH><font face='Calibri'><a href=https://intranet.myplex.in/bugzilla/show_bug.cgi?id=" + rs_3.getString(i + 1) + ">" + rs_3.getString(i + 1) + "</a></font></TH>");
   				  }else if(i==3){
					  out.println("<TD align='center'><font face='Calibri' >" + rs_3.getString(i + 1) + "</font></TD>");
				  }else if(i==4){
   					  out.println("<TD align='center'><font face='Calibri' >" + rs_3.getString(i + 1) + "</font></TD>");  
   				  }else if(i==5){
   					  out.println("<TD align='center'><font face='Calibri' >" + rs_3.getString(i + 1) + "</font></TD>"); 
   				  }else{
   					  out.println("<TD><font face='Calibri'>" + rs_3.getString(i + 1) + "</font></TD>");
   				  }
     			    }
     			  out.println("</TR>");
     			  }
     			 out.println("</TABLE></P>");
     			 
     			 //4th table print
     			int row_count_4=0;
     			out.println("<center><h3><font face='Calibri'> Closed Bugs</font></h3></center>"); 
     			out.println("<P ALIGN='center'><TABLE BORDER=3 bordercolor=#2E64FE bgcolor=#FFFFFF width=75% cellspacing=2 cellpadding=3 >");
    			 ResultSetMetaData rsmd_4 = rs_4.getMetaData();
    			 int columnCount_4 = rsmd_4.getColumnCount();
    			 // table header
    			 out.println("<TR>");
    			 for (int i = 0; i < columnCount_4; i++) {
    			   out.println("<TH><font face='Arial'>" + rsmd_4.getColumnLabel(i + 1) + "</font></TH>");
    			   }
    			 out.println("</TR>");
    			 // the data
    			 while (rs_4.next()) {
    				 row_count_4++;
    			  out.println("<TR>");
    			  for (int i = 0; i < columnCount_4; i++) {
    				
    				  if(i==0){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_4.getString(i + 1) + "</font></TD>");  
    				  }else if(i==1){
    					  out.println("<TH><font face='Calibri'><a href=https://intranet.myplex.in/bugzilla/show_bug.cgi?id=" + rs_4.getString(i + 1) + ">" + rs_4.getString(i + 1) + "</a></font></TH>");
    				  }else if(i==3){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_4.getString(i + 1) + "</font></TD>");
    				  }else if(i==4){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_4.getString(i + 1) + "</font></TD>");  
    				  }else if(i==5){
    					  out.println("<TD align='center'><font face='Calibri' >" + rs_4.getString(i + 1) + "</font></TD>"); 
    				  }else{
    					  out.println("<TD><font face='Calibri'>" + rs_4.getString(i + 1) + "</font></TD>");
    				  }
    				 
    			    }
    			  out.println("</TR>");
    			  }
    			 out.println("</TABLE></P>");
    			 
    			 return ;
    			
    	  
      
    } catch (SQLException e) {
      out.println("An error occured while retrieving " + "Bug status " 
          + e.toString());
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
    	e.printStackTrace();
      throw (new ServletException(e.toString()));
    } finally {
      try {
        if (stmt_1!= null) {
          stmt_1.close();
        }else if(stmt_2!=null){
        	stmt_2.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
    	  ex.printStackTrace();
    	  ex.printStackTrace();
      }
    }
    out.println("</center>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}