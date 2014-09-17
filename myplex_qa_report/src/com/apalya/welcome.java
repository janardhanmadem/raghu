package com.apalya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class welcome extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String x=(String)request.getAttribute("realname");
		//out.println("<h1><font face='Calibri'>Welcome User  "+x+"</font></h1>");
		System.out.println("name is "+x);
		String target_milestone=request.getParameter("target_milestone");
		if(validatebuild.checkbuild(target_milestone)){
			RequestDispatcher rs=request.getRequestDispatcher("ex1");
			request.setAttribute("target_milestone",target_milestone);
			rs.forward(request, response);
			
		}else{
			out.println("<h2><center><font face='Calibri'>you enter wrong Target Release Number</font></center></h2>");
			RequestDispatcher rs=request.getRequestDispatcher("welcome.html");
			rs.include(request, response);
		}
		
	}

}
