<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学效果-校外专家评价</title>
    <meta charset="utf-8">
    <link rel="icon" href="/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/teachEffectDetail.css'/>">

</head>
<body onload="Rendering();">
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="top"><jsp:include page="/html/top.jsp"/></div>

<article class="content">

    <section id="banner">
        <img src="<c:url value='/images/index/abouttop_03.jpg'/>">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>教学效果</h3>
                    <ul>
                        <li><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=2&n=1'/>">校外专家评价</a></li>
                        <li><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=1&n=2'/>">校内督导评价</a></li>
                        <li class="current"><a href="<c:url value='/teacher_evalution_servlet?method=LoadTeacherEvalator&EvalatorpageQuery=1'/>">教师自我评价</a></li>
                        <li><a href="<c:url value='/EvalatorServlet?method=LoadStudentEvalator&EvalatorpageQuery=1'/>">校内学生评价</a></li>
                        <li><a href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>">社会评价</a></li>
                        <li><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">教学评估及相关文件</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.html">首页</a>·
                            <a href="teachEffectDetail-3.jsp">教学效果</a>·
                            <a href="#">教师自我评价</a>
                        </nav>
                        <h1>教师自我评价</h1>
                    </header>
                    <%--<section class="article">--%>
                        <%--<img src="/images/teachEffect/study.png" alt="" width="550">--%>
                    <%--</section>--%>

                </article>
            </div>
            <div class="column_3" style="width: 550px;">

                <h3>侯爱民自我评价</h3>
                <p style="text-align: left;">从2007-2008学年第1学期开始，至2018-2019学年第1学期止，总共为12届的学生讲授《面向对象分析与设计(UML)》、《软件需求分析与设计》课程。累计学生人数1300，累计学时700。</p>
                <br>
            </div>
        </div>
    </section>
</article>

<!-- 通过js渲染，js代码在normal.js里 -->
<div id="bottom"><jsp:include page="/html/bottom.jsp"/></div>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="copyright"><jsp:include page="/html/copyright.jsp"/></div>
</body>
</html>