package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uname=request.getParameter("uname");
		String psw=request.getParameter("pswd");
		String npsw=request.getParameter("npswd");

		
		UserDao cdao=new UserDao();
		User c=new User();
		c.setUsername(uname);
		c.setPassword(psw);
		c.setNewpassword(npsw);
		
		boolean result= cdao.changeUser(c);
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Success</h1><hr>");
		if(result){
		pw.println("<h3>Hey, <strong><u><i>"+uname+"</i></u></strong> your password has been successfully changed. ");
		pw.println("From now use your new password. :) </h3>");
		pw.println("<br><br>If you want to <b><a href='login.html'>Login</a><b><br>");
		pw.println("</body>");
		pw.println("<footer>"+result+"<footer></html>");
		}
		else {
			pw.println("<h3>Hey, <strong><u><i>"+uname+"</i></u></strong> your password is not changed. ");
		pw.println("</h3>");
		pw.println("<br><br>If you want to <b><a href='login.html'>Login</a><b><br>");
		pw.println("</body>");
		pw.println("<footer>"+result+"<footer></html>");
		RequestDispatcher dis=request.getRequestDispatcher("change.html");
		dis.include(request, response);
		}
	}
}
