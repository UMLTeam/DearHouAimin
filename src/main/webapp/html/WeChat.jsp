<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <head>
        <title>教学互动-微信群</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../style/normal.css">
        <link rel="stylesheet" type="text/css" href="../style/interaction/QQ.css">
        <script type="text/javascript" src="../js/normal.js"></script>
        <link rel="stylesheet" type="text/css" href="../style/interaction/normal.css">
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
                    <h3>教学互动</h3>
                    <ul>
                        <li><a href="../html/QQ.jsp">QQ群</a></li>
                        <li class="current"><a href="../servlet/WeChatServlet?type=normalShow">微信群</a></li>
                        <li><a href="../servlet/TeachingArrangementServlet?type=showLeaveMsg">师生互动</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="../html/index.jsp">首页</a>·
                            <a href="../html/QQ.jsp">教学互动</a>·
                            <a href="../servlet/WeChatServlet?type=normalShow">微信群</a>
                        </nav>
                        <h1>请扫描二维码加入微信群</h1>
                    </header>
                    <section class="article" style="text-align: center">
                        <c:forEach var="weChat" items="${requestScope.photos }">
                            <img src="../${weChat.src}" style="width:270px;height:370px;">
                        </c:forEach>
                    </section>
                </article>
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
