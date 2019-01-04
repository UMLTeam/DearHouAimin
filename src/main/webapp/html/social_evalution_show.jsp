<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>教学管理</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/normal.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/eduManage/eduManageDetail.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/eduManage/normal.css">
	<!-- 显示pdf容器样式 -->
	<style>
		.pdfobject-container {
		    max-width: 100%;
			width: 1000px;
			height: 1000px;
			border: 10px solid rgba(0,0,0,.2);
			margin: 0;
		}
	</style>
</head>

<body onload="Rendering();">
	<!-- 通过js渲染，js代码在normal.js里 -->
	<div id="top">
		<jsp:include page="/html/top.jsp"/>
	</div>

	<article class="content">
	    <section id="banner">
	        <img src="${pageContext.request.contextPath}/images/index/abouttop_03.jpg">
	    </section>
	    <section class="mainWrap relative">
	        <div class="detailContent">
	            <div class="column_1">
	                <section class="leftNav">
	                    <h3>教学管理</h3>
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
								<a href="${pageContext.request.contextPath}/html/index.jsp">首页</a>·
								<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">教学管理</a>·
								<a href="${pageContext.request.contextPath}/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1">社会评价</a>·
								<a href="">查看详情</a>
	                        </nav>
	                        <h1>社会评价</h1>
	                    </header>
	                    <section class="article">
							<div class="itemDetail newItemContent">
								<h2 style="color: black;">${social_evalution.evalutionTitle}</h2>
								<div style="color: black;">${social_evalution.content}</div>
							</div>
	                    </section>
	                </article>
	            </div>
	        </div>
	    </section>
	</article>

	<!-- 通过js渲染，js代码在normal.js里 -->
	<div id="bottom">
		<jsp:include page="/html/bottom.jsp"/>
	</div>
	<!-- 通过js渲染，js代码在normal.js里 -->
	<div id="copyrights">
		<jsp:include page="/html/copyright.jsp"/>
	</div>

</body>
</html>