<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>教师队伍-课程负责人</title>
    <meta charset="utf-8">
    <link rel="icon" href="/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="/style/normal.css">
    <link rel="stylesheet" type="text/css" href="/style/teacherTeam/normal.css">
    <link rel="stylesheet" type="text/css" href="/style/teacherTeam/teacherTeamDetail.css">
    <script type="text/javascript" src="/js/normal.js"></script>
</head>
<body>

<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>

<article class="content">

    <section id="banner">
        <img src="/images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>教师队伍</h3>
                    <ul>
                        <li><a href="/teacherTeam?type=courseManager">课程负责人</a></li>
                        <li class="current"><a href="/teacherTeam?type=teacherTeam">课程教学团队</a></li>
                        <li><a href="/teacherTeam?type=lecturer">主讲教师</a></li>
                        <li><a href="/teacherTeam?type=trainingPlan">青年教师培养</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                           <a href="/html/index.jsp">首页</a>·
                            <a href="/teacherTeam?type=courseManager">教师队伍</a>·
                            <a href="/teacherTeam?type=teacherTeam">课程教学团队</a>·
                             <a href="">${teacher.teacher_name }</a>
                        </nav>
                        <h1>${teacher.teacher_name }</h1>
                    </header>
                    <section class="article">${teacher.teacher_message }</section>

                </article>
            </div>
            <div class="column_3">
                <figure class="present">
                    <!--<img src="../images/teacherTeam/1.jpg" class="portrait">-->
                    <!--<figcaption style="text-align: center">校长</figcaption>-->
                    <!--<img src="../images/index/President-z.gif">-->
                </figure>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
</html>