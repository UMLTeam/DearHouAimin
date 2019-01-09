<%@ page import="domain.TeachingPoints" %>
<%@ page import="service.Impl.TeachingHDPointsService" %><%--
  Created by IntelliJ IDEA.
  User: yangyuze
  Date: 2018/12/25
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    TeachingHDPointsService tps = new TeachingHDPointsService();
    TeachingPoints point = tps.getCurPoint();
    request.setAttribute("point",point);
%>
<!DOCTYPE html>
<html>
<head>
    <title>教学安排-教学难重点</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../style/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/education/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/education/educationDetail.css">
    <script type="text/javascript" src="../js/normal.js"></script>
</head>
<body>
<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>

<article class="content">

    <section id="banner">
        <img src="../images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>教学安排</h3>
                    <ul>
                        <li><a href="../html/educationalDetail-1.jsp">教学大纲</a></li>
                        <li><a href="../servlet/CalendarServlet?method=show">教学日历</a></li>
                        <li><a href="../html/educationalDetail-3.jsp">教学内容</a></li>
                        <li><a href="../html/educationalDetail-4.jsp">授课计划</a></li>
                        <li class="current"><a href="../html/educationalDetail-5.jsp">教学难重点</a></li>
                        <li><a href="../html/educationalDetail-6.jsp">教学方法与手段</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2" style="color:black;">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="/html/index.jsp">首页</a>·
                            <a href="educationalDetail-1.jsp">教学安排</a>·
                            <a href="">教学重难点</a>
                        </nav>
                        <h1>教学重难点</h1>
                    </header>
                </article>
                <strong>理论教学重难点：</strong><br/><br/>
                <c:if test="${!(empty point.theoryInfo)}">
                    ${requestScope.point.theoryInfo}
                </c:if>

                <strong>实验教学重难点：</strong><br/><br/>
                <c:if test="${!(empty point.experimentInfo)}">
                    ${requestScope.point.experimentInfo}
                </c:if>
                <br><br>
                <div style="text-align:right;">
                <c:if test="${!(empty point.time)}">
                    <strong>修改时间：</strong>  ${requestScope.point.time}
                </c:if>
                </div>
            </div>
        </div>
    </section>
</article>

<div id="bottom">
    <jsp:include page="/html/bottom.jsp"/>
</div>
<div id="copyrights">
    <jsp:include page="/html/copyright.jsp"/>
</div>
</body>
</html>