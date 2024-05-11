package com.youtube;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("httpServlet class doget method running.....");
		resp.setContentType("text/html");
		PrintWriter writer =resp.getWriter();
		writer.println("<h1>YouTube by myServlet class</h1>");
		writer.println("<h2>"+new Date().toString()+"</h2>");
		writer.println("<h3><a href=\"https://www.bing.com/ck/a?!&&p=9cb66d739d0ea382JmltdHM9MTcxMjg4MDAwMCZpZ3VpZD0yM2UzNGVjOS02MzZhLTZkNzMtMTRhNy01YWRjNjJmMTZjNzgmaW5zaWQ9NTIwOA&ptn=3&ver=2&hsh=3&fclid=23e34ec9-636a-6d73-14a7-5adc62f16c78&psq=youtube&u=a1aHR0cDovL2luLnlvdXR1YmUuY29tLw&ntb=1\">Youtube</a></h3>");
        writer.println("<h3><a href=\"index.html\">Home</a></h3>");
	}

}
