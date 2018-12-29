<%--
  Created by IntelliJ IDEA.
  User: 13226
  Date: 2018/12/29
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>教学资源</h3>
    <ul id="leftUl">
        <li><a href="/courseWareServlet?type=show&page=1&pageSize=3">课程课件</a></li>
        <li><a href="/videoServlet?type=show&page=1&pageSize=3">教学录像</a></li>
        <li><a href="/ExerciseServlet.do?type=front-list">习题库</a></li>
        <li><a href="/html/CheckResourceServlet.do?type=4">案例库</a></li>
        <li><a href="/experimentalTaskServlet?type=showPages&page=1&pageSize=4">实验任务</a></li>
    </ul>
</body>
</html>
