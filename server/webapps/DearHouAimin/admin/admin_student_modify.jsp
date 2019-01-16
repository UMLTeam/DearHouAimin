<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    //这里要指定一下编码，否则会乱码
    request.setCharacterEncoding("UTF-8");
    String evalator_id = request.getParameter("evalator_id");
    request.setAttribute("evalator_id",evalator_id);
%>
<form action="<c:url value='/ScoreServlet'/>" method="post">
    <input type="hidden" name="method" value="moddifyStudent">
    学生学号：<input value="${evalator_id}" name="studentNo">
    <br/>
    分数：<input type="number" name="grade">
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
