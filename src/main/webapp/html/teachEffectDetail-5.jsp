<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学效果-校外专家评价</title>
    <meta charset="utf-8">
    <link rel="icon" href="/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/teachEffectDetail.css'/>">
    <script type="text/javascript" src="../js/jquery.min.js"></script>

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
                        <li><a href="<c:url value='/teacher_evalution_servlet?method=LoadTeacherEvalator&EvalatorpageQuery=1'/>">教师自我评价</a></li>
                        <li><a href="<c:url value='/EvalatorServlet?method=LoadStudentEvalator&EvalatorpageQuery=1'/>">校内学生评价</a></li>
                        <li class="current"><a href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>">社会评价</a></li>
                        <li><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">教学评估及相关文件</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.html">首页</a>·
                            <a href="teachEffectDetail-5.jsp">教学效果</a>·
                            <a href="#">社会评价</a>
                        </nav>
                        <h1>社会评价</h1>
                    </header>
                    <section class="article">

                    </section>

                </article>
            </div>


            <div class="column_3">
                <table style="border-collapse:collapse;" border="1" bordercolor="#000000">
                    <tbody>
                    <tr>
                        <td valign="top" width="200">
                            <span>评价标题</span>
                        </td>
                        <td valign="top" width="200">
                            <span>发布时间</span>
                        </td>
                        <td valign="top"  width="200">
                            <span class="show"><a href="#">查看</a> </span>
                        </td>
                    </tr>

                    <c:forEach items="${EvalatorpageQuery.items}" var="evalator">
                        <tr>
                            <td valign="top">
                                <span>${evalator.evalutionTitle}</span>
                            </td>
                            <td valign="top">
                                <span>${evalator.evalutionTime}</span>
                            </td>
                            <td valign="top">
                                    <%--<span>${evalator.content}</span>--%>
                                <span><a href="#">查看</a> </span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="pagination" style="width:100%;">
                    <ul style="margin: auto">
                        <c:if test="${EvalatorpageQuery.currentPage!=1}">

                            <li><a style="float:left;" class="btn btn-primary radius" href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>">首页</a></li>
                            <li><a style="float:left;" class="btn btn-primary radius" href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage-1}'/>">上一页</a></li>
                        </c:if>
                        <c:if test="${EvalatorpageQuery.currentPage!=EvalatorpageQuery.totalPage}">
                            <li><a style="float:left;" class="btn btn-primary radius" href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage+1}'/>">下一页</a></li>
                            <li><a style="float:left;" class="btn btn-primary radius" href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=${EvalatorpageQuery.totalPage}'/>">尾页</a></li>
                        </c:if>
                    </ul>
                </div>

            </div>
        </div>
    </section>
</article>

<!-- 通过js渲染，js代码在normal.js里 -->
<div id="bottom"><jsp:include page="/html/bottom.jsp"/></div>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="copyright"><jsp:include page="/html/copyright.jsp"/></div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $(".show").click(function () {
            alert("dlhg");
            confirm("${evalator.content}"); //在页面上弹出确认对话框
        });
    });
</script>

</html>