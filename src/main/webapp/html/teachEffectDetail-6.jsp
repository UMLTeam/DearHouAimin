<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>教学效果-校外专家评价</title>
    <meta charset="utf-8">
    <link rel="icon" href="<c:url value='/images/dgut.jpg'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachEffect/teachEffectDetail.css'/>">
</head>
<body onload="Rendering();">
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>

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
                        <li><a href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>">社会评价</a></li>
                        <li class="current"><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">教学评估及相关文件</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="<c:url value ='/html/index.jsp'/>">首页</a>·
                            <a href="<c:url value ='/html/teachEffectDetail-4.jsp'/>">教学效果</a>·
                            <a href="#">校内学生评价</a>
                        </nav>
                        <h1>校内学生评价</h1>
                    </header>
                    <section class="article">

                    </section>

                </article>
            </div>
            <div class="column_3" style="width: 700px;">
                <h3>近三年学生网上评教</h3>
                <br>
                
     <!-- 列表样式 -->   
            <div class="column_3" style="width: 700px;">
                <h3 style="color:black;">评估文件案例列表</h3>
                <br>
                <table style="border-collapse:collapse;color:black;" border="1" bordercolor="#000000">
			    	<td width="80">评估文件名称</td>
			        <td width="150">评估文件主题</td>
			        <td width="150">评估文件时间</td>
			        <td width="150">评估文件下载</td>
			    <c:forEach items="${TeachFilepageQuery.items}" var="homework">
			        <tr>
			            <td>${homework.realname}</td>
			            <td>${homework.description}</td>
			            <td>${homework.timestamp}</td>
			            <td><a style = "color:blue;" title="下载" href="<c:url value='/TeachFileServlet?method=Download_Homework&id=${homework.id}'/>">  下载  </a></td>
			        </tr>
			    </c:forEach>
			    </tbody>
                </table>
                <div class="pagination" style = "color:black;">
				    <ul style="margin: auto">
				        <c:if test="${TeachFilepageQuery.currentPage!=1}">
				            <span><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">首页</a></span>
				            <span><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=${TeachFilepageQuery.currentPage-1}'/>">上一页</a></span>
				        </c:if>
				        <c:if test="${TeachFilepageQuery.currentPage!=TeachFilepageQuery.totalPage}">
				            <span><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=${TeachFilepageQuery.currentPage+1}'/>">下一页</a></span>
				            <span><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=${TeachFilepageQuery.totalPage}'/>">尾页</a></span>
				        </c:if>
				    </ul>
                </div>
            </div>
            
        </div>
    </section>
</article>

<!-- 通过js渲染，js代码在normal.js里 -->
<div id="bottom">
    <jsp:include page="/html/bottom.jsp" />
</div>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="copyrights">
    <jsp:include page="/html/copyright.jsp" />
</div>
</body>
</html>