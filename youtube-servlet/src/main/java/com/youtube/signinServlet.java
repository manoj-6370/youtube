package com.youtube;

import java.io.File;    
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig   //this bcz our servlet contains text data as wellas other data like files,image or pdf.
public class signinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		resp.setContentType("text/html");
		PrintWriter writer= resp.getWriter();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		Part part=req.getPart("inputfile");           //for file
		String filename=part.getSubmittedFileName();
		//writer.println(filename);

		System.out.println(filename);
		System.out.println(name);
		System.out.println(password);


		try{
            Thread.sleep(2000);
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
			String url="jdbc:mysql://localhost:3306/sys";//jdbc:mysql://localhost:3306/sys
		//oracle.jdbc.OracleDriver	
		//	jdbc:oracle:thin:@localhost:1521:xe
			String uName="root";
			String uPassword="root";//root#007 server
			Connection con=DriverManager.getConnection(url,uName,uPassword);
			System.out.println("driver Registered....");
			Statement stm= con.createStatement();
			String sql="INSERT INTO youtube "
					+" VALUES "
					+"('"+name+"','"+password+"','"+email+"','"+filename+"')";
            System.out.println("8888888");
			int res=stm.executeUpdate(sql);
			System.out.println(res);

			//upload    // image uploading not working properly
			InputStream is=part.getInputStream();
			byte [] data=new byte[is.available()];
			is.read(data);//here 'data' will read 'is' not ('is' will read 'data')

			//String path=req.getRealPath("/"+filename);   //gives web folder path and connect with file name(File.separator)
            String path=req.getServletContext().getRealPath("")+"img";
            System.out.println(path);
//            System.out.println("44444444444444444444444444444444444"); 
//			System.out.println(path);
			FileOutputStream fos=new FileOutputStream(path+File.separator+filename);
			fos.write(data);
            fos.close();
			
			System.out.println(res);
			con.close();

			if(res==1) {
				writer.println("done");
				}
			else writer.println("error");

		}
		catch(IOException e ) {
			e.printStackTrace();
			writer.print("error");
		}
		catch(Exception e) {
			
		}




	}

}
