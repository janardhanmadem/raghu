package com.apalya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
	
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	String email=request.getParameter("email");
	String realname=request.getParameter("realname");
	if(validate.checkuser(email,realname)){
		request.setAttribute("realname",realname);
		out.println("<h2><font face='Calibri'>Username or Password correct</font></h2>");
		RequestDispatcher rs=request.getRequestDispatcher("welcome.html");
		
		rs.forward(request, response);
	}else{
		out.println("<h2><font face='Calibri'>Username or Password Incorrect</font></h2>");
		RequestDispatcher rs=request.getRequestDispatcher("index.html");
		rs.include(request, response);
	}
}
}