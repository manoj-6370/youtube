package com.youtube;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class resisterServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter writer=resp.getWriter();
	String name=req.getParameter("user_name");
	String email=req.getParameter("user_email");
	String password=req.getParameter("user_password");
	String gender=req.getParameter("user_gender");
	String course=req.getParameter("user_course");
	String condition=req.getParameter("condition");

	if(condition!=null){

	if(condition.equals("checked")) {
		writer.println("<h1>Welcome to the Servlet Page</h1>");
		writer.println("<h2>User Name:"+name+"</h2>");
		writer.println("<h2>User Email:"+email+"</h2>");
		writer.println("<h2>User Password:"+password+"</h2>");
		writer.println("<h2>User Gender:"+gender+"</h2>");
		writer.println("<h2>User Course:"+course+"</h2>");

		Cookie c1=new Cookie("user_name",name);
		Cookie c2=new Cookie("user_email",email);
		resp.addCookie(c1);
		resp.addCookie(c2);

		writer.println("<h3><a href='Success'>success</a></h3>");
//		RequestDispatcher rd=req.getRequestDispatcher("Success");
//        rd.include(req, resp);

	}
	else {
		writer.println("<h2>You have not checked the checkbox,please check the checkbox</h2>");
        writer.println("<h3><a href=\"index.html\">Home<a></h3>");


	}
	}
	else {
		writer.println("<h2>You have not checked the checkbox,please check the checkbox</h2>");
        writer.println("<h3><a href=\"index.html\">Home<a></h3>");

        RequestDispatcher rd=req.getRequestDispatcher("index.html");
        rd.include(req, resp);
	}
}
}
