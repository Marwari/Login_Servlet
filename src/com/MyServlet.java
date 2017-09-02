package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uname=request.getParameter("uname");
		String psw=request.getParameter("pswd");
		
		UserDao udao=new UserDao();
		User u=new User();
		u.setUsername(uname);
		u.setPassword(psw);
		
		String result=udao.addUser(u);
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Success</h1><hr>");
		pw.println("<h3>Hey, <strong><u><i>"+uname+"</i></u></strong> your account is successfully created. ");
		pw.println("You are now free to use. :) </h3>");
		pw.println("<br><br>If you want to login now <b><a href='login.html'>Login Here</a></b><br>");
		pw.println("</body>");
		pw.println("<footer>"+result+"<footer></html>");
		
		
	}
}
