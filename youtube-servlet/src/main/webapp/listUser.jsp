<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="com.youtube.User"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


</head>
<body style="background-color: #e53935 red darken-1">

<h1>Hello</h1>

 <div align="center">
 <caption><h2>List of users</h2></caption>
        <table class="responsive-table" border="1" cellpadding="5">
            
            <thead>
            <tr>
                
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Filename</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach  items="${listuser}" var="user">
            
                <tr>
                    <td><c:out value="${user.getName()}" /></td>
                    <td><c:out value="${user.getEmail()}" /></td>
                    <td><c:out value="${user.getPassword()}" /></td>
                    <td><c:out value="${user.getFilename()}" /></td>
                </tr>
                
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>