<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学资源-案例库</title>
    <meta charset="utf-8">
    <link rel="icon" href="/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="../style/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/teachRes/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/teachRes/teachResDetail.css">
    <link rel="stylesheet" type="text/css" href="../style/teachRes/teachResDetail-4.css">
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->
    <script type="text/javascript" src="../js/teachRes/teachResDetail-4.js"></script>
    <script type="text/javascript" src="../js/normal.js"></script>
</head>
<body onload="Rendering();">
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="top"></div>

<article class="content">

    <section id="banner">
        <img src="../images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>教学资源</h3>
                    <ul>
                        <li><a href="teachResDetail-1.html">课程课件</a></li>
                        <li><a href="teachResDetail-2.html">教学录像</a></li>
                        <li><a href="/ExerciseServlet.do?type=front-list">习题库</a></li>
                        <li class="current"><a href="teachResDetail-4.html">案例库</a></li>
                        <li><a href="teachResDetail-5.html">实验任务</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.html">首页</a>·
                            <a href="teachResDetail-1.html">教学资源</a>·
                            <a href="teachResDetail-3.html">案例库</a>
                        </nav>
                        <h1>案例库</h1>
                    </header>

                    <div id="resource">
                        <form class="search" action="" method="post">
                            <input class="searchInput" type="search" name="search">
                            <input class="searchSubmit" type="submit" value="文件搜索">
                        </form>
                        <table class="table" border="0" width="800px" cellpadding="2" cellspacing="1">
                            <tr class="firstRow">
                                <td>序号</td>
                                <td>文件名称</td>
                                <td>文件大小</td>
                                <td>上传时间</td>
                                <td>操作</td>
                            </tr>
                            <%--循环遍历资源--%>
                            <c:set var="trType" scope="session" value="${0}"/>
                            <c:forEach items="${sessionScope.resourceList}" var="resource" varStatus="status">
                                <c:choose>
                                    <c:when test="${status.index%2==0}">
                                        <tr class="trOdd">
                                        <c:set var="trType" scope="session" value="${1}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="tr">
                                        <c:set var="trType" scope="session" value="${0}"/>
                                    </c:otherwise>
                                </c:choose>
                                <td>${resource.id}</td>
                                <td class="tll"><img src="/images/teachResource/PPT.png"><c:out
                                        value="${resource.resName}"/></td>
                                <td><c:out value="${10000}"/></td>
                                <td><c:out value="${resource.resTime}"/></td>
                                <td>
                                    <a onclick="Preview(event)"><img src="/images/teachResource/preview.png"></a>
                                    <a href="${resource.resPath}" download="${resource.resName}">
                                        <img src="/images/teachResource/download.png">
                                    </a>
                                </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </article>
            </div>
        </div>
    </section>
</article>

<!-- 通过js渲染，js代码在normal.js里 -->
<div id="bottom"></div>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="copyrights"></div>
</body>
</html>