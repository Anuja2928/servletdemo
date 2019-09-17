<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
  <%
      String user = request.getParameter("username");
    %>
<h1>hello ......  <% out.println(user);%></h1>
<a href ="index.html"> Home</a>

</body>
</html>