<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<i>
<%  
response.getWriter().println("Transaction succusfully...");
RequestDispatcher rd=request.getRequestDispatcher("login.html");
rd.include(request, response);

%>
</i>
</body>
</html>