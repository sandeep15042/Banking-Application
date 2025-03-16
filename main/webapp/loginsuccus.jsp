<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<h1>
<%  
response.getWriter().println("Login Successfull...");
RequestDispatcher rd=request.getRequestDispatcher("application.html");
rd.include(request, response);

%>
</h1>
 
</form>
</body>
</html>