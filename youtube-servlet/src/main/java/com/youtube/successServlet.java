package com.youtube;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class successServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       PrintWriter writer=resp.getWriter();

       writer.println("<h2>You have Successfully Registered</h2>");

       //Cookie Example

       Cookie[]cookies=req.getCookies();

       String name="";
       String email="";

       if(cookies==null) {
    	   writer.println("<h2>You are a new user go to home page and register</h2>");
       }
       else {
    	   for(Cookie c:cookies) {
    		   if(c.getName().equals("user_name")) {
    			   name=c.getValue();
    			  writer.println("<h2>Name: "+name+"</h2>");
    		   }
    		   else if(c.getName().equals("user_email")) {
    			   email=c.getValue();
    			  writer.println("<h2>Email Id: "+email+"</h2>");
    		   }
    	   }
       }


//       writer.println("<h2>name: "+name+"</h2>");
//       System.out.println(name);


}
}
