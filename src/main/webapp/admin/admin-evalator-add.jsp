<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周奕棉
  Date: 2018/12/24
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="<c:url value='/EvalatorServlet'/>" method="post">
    <input type="hidden" name="method" value="Add_Evalator">
    教师名称：<input name="course_teacher_name">
    <br/>
    时间：<input name="course_time">
    <br/>
    课程名称：<input name="course_name">
    <br/>
    课程性质:
    <select name="course_property">
        <option value ="专业课">专业课</option>
        <option value ="任选课">任选课</option>
        <option value="任选课">任选课</option>
    </select>
    <br/>
    分数：<input name="course_grade">
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
