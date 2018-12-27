<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>

<a href="html/index.jsp">index</a>
<%
    response.setHeader("Refresh","0;url=/html/index.jsp");
%>
</body>
</html>
