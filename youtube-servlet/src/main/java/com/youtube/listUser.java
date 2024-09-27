package com.youtube;

import java.io.IOException;   
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class listUser extends HttpServlet{
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/sys";
		String uName="root";
		String uPassword="root";
		Connection con=DriverManager.getConnection(url,uName,uPassword);
		System.out.println("driver Registered....");
		
		PreparedStatement ps=con.prepareStatement("SELECT NAME,PASSWORD,EMAIL,FILENAME FROM youtube");
		ResultSet rs=ps.executeQuery();
		
		List <User> listuser=new ArrayList<User>();
		
		while(rs.next()) {
			
			String name=rs.getString("name");
			String email=rs.getString("email");
			String password=rs.getString("password");
			String filename=rs.getString("filename");
			User user=new User(name,email,password,filename);
			listuser.add(user);
			
		}
		
		 request.setAttribute("listuser", listuser);
	        RequestDispatcher view = request.getRequestDispatcher("listUser.jsp");
	        view.forward(request, response);
		
		con.close();
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
