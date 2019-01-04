<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <head>
        <title>教学互动-师生互动</title>
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
                        <li><a href="../servlet/WeChatServlet?type=normalShow">微信群</a></li>
                        <li class="current"><a href="../servlet/TeachingArrangementServlet?type=showLeaveMsg">师生互动</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="../html/index.jsp">首页</a>·
                            <a href="../html/QQ.jsp">教学互动</a>·
                            <a href="">师生互动</a>
                        </nav>
                        <h1>留言板块</h1>
                    </header>
                    <section class="article" style="postion:relative">
                        <form action="../servlet/TeachingArrangementServlet?type=addLeaveMsg" method="post">
                            <div><input type="text" style="width:600px;height:80px;" name="leaveMsgContent"/></div>
                            <div><input type="submit" value="发表评论" style="color:black;margin-left:535px;"/></div>
                        </form>
                    </section>
                </article>
                <div>
                    <c:forEach var="leaveMsg" items="${requestScope.leaveMsgs }">
                        <p> 用户Id-${leaveMsg.userId}:&nbsp;
                                ${leaveMsg.leaveMsgContent}</p>
                        <br>
                    </c:forEach>
                </div>
            </div>

        </div>
    </section>

</article>
<div id="bottom">
    <jsp:include page="/html/bottom.jsp"/>
</div>
<div id="copyrights">
    <jsp:include page="/html/bottom.jsp"/>
</div>
</body>
</html>