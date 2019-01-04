<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.QQGroup" %>
<%@ page import="service.Impl.QQGroupService" %>
<%@ page import="java.sql.SQLException" %>
<!doctype html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    QQGroupService tas = new QQGroupService();
    QQGroup qqGroup = null;
    try {
        qqGroup = tas.getQQGroupByUse();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    request.setAttribute("qqGroup",qqGroup);
%>
<html>
<head>
    <head>
        <title>教学互动-QQ群</title>
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
                        <li class="current"><a href="../html/QQ.jsp">QQ群</a></li>
                        <li><a href="../servlet/WeChatServlet?type=normalShow">微信群</a></li>
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
                            <a href="">QQ群</a>
                        </nav>
                        <h1>请通过以下任一方式加入群聊</h1>
                        <p>
                            UMl群聊，欢迎大家通过加入群聊。您宝贵的意见，是我们前进的动力！
                        <p>
                            （群里有可爱的小姐姐哦！）
                        </p>
                        </p>
                    </header>
                    <section class="article">
                        <c:if test="${!(empty qqGroup.QRcode)}">
                            <p>
                                通过扫描二维码直接进入群聊
                            </p>

                            <image src="${requestScope.qqGroup.QRcode}" style="width:270px;height:370"/>
                        </c:if>
                    </section>
                    <c:if test="${!(empty requestScope.qqGroup.idkey)}">
                        <section class="article">
                            <p>通过点击以下连接进入群聊</p>
                                ${requestScope.qqGroup.idkey}
                        </section>
                    </c:if>
                    <c:if test="${!(empty requestScope.qqGroup.groupid)}">
                        <section class="article">
                            <p>群号：${requestScope.qqGroup.groupid}</p>
                        </section>
                    </c:if>
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
