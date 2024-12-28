<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ResultSet rs=(ResultSet) request.getAttribute("rs");
%>
<h1>Update page</h1>

   <form action="update">
   <input type="text" name="id"  value="<%=rs.getInt(1)  %>" readonly="readonly" placeholder="Enter Event Id">
   <input type="text" name="title" value="<%=rs.getString(2) %>" placeholder="Enter Event Title">
   <input type="text" name="loc" value="<%=rs.getString(3) %>" placeholder="Enter Event Location">
   <input type="text" name="date"  value="<%=rs.getString(4) %>" placeholder="Enter Event Date">
   <input type="text" name="guest" value="<%=rs.getString(5) %>" placeholder="Enter Event chief Guest Name">
   <button type="submit">submit</button>

   </form>

</body>
</html>