<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/12/24
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加上课班级</title>
    <%
        String path = request.getContextPath();
    %>
</head>
<body>
<form action="<%=path%>/ClassInfoServlet" method="post">
    <input type="hidden" name="method" value="Add_ClassInfo">
        <p> 班级名称：
            <input type="text" name="class_name">
        </p>
        <p> 专业：
            <input type="text" name="specialty">
        </p>
        <p> 课程名称：
            <input type="text" name="course_name">
        </p>
        <p>
            <input type="submit" value="确定">
        </p>
</form>
</body>
</html>
