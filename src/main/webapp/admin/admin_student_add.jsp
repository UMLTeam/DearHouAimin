<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="<c:url value='/ScoreServlet'/>" method="post">
    <input type="hidden" name="method" value="Add_Evalator">
    学生姓名：<input name="studentName">
    <br/>
    学生学号：<input name="studentNo">
    <br/>
    专业：<input name="major">
    <br/>
    课程：<input name="course">
    <br/>
    班级：<input name="className">
    <br/>
    分数：<input type="number" name="grade">
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
