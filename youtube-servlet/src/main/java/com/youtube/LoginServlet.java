package com.youtube;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");


		try {
			Thread.sleep(2000);
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String userName="system";
			String userPassword="system";
			Connection con=DriverManager.getConnection(url,userName,userPassword);
			System.out.println("Driver is Registered... ");
			Statement stm=con.createStatement();
			String sql="INSERT INTO LOGIN "
					+" VALUES "
					+ "('"+name+"','"+email+"','"+password+"')";

			int res=stm.executeUpdate(sql);
			con.close();
			System.out.println(res);
			if(res==1) {
				System.out.println("done");
				writer.println("done");
			}
			else writer.println("error");

		} catch (SQLException e) {
			e.printStackTrace();
			writer.println("error");
		}
		catch(Exception e) {
			e.printStackTrace();
			writer.println("error");

		}

	}
}
