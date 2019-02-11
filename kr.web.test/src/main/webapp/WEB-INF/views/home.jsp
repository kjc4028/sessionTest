<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="/resources/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<br>
user: 
<%
	 HttpSession session01 = request.getSession(); 
	/* HttpSession session01 = null; */
	
	if(session01 != null){
		session01.getAttribute("id");
		System.out.println("session02: " + session01);
		System.out.println("session01 attribute: " + session01.getAttribute("id"));
	}
	if(session01 == null){
		session01 = null;
		System.out.println("session03: " + session01);
	}
%>
<%= session01.getAttribute("id") %>

<a href = "/test/login/1">login1</a>
<a href = "/test/login/2">login2</a>
<a href = "/test/login/3">login3</a>
<a href = "/test/login/4">login4</a>
<a href = "/test/logout">logout</a>
</body>
</html>
