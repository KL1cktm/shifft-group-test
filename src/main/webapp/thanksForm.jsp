<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("name");
%>
<h1>Welcome, <%= username %>!</h1>
</body>
</html>