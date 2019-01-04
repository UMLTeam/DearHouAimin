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
							<li class="current"><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">开课计划</a></li>
							<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></li>
							<li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a></li>
							<li><a href="<c:url value ='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1'/>">班级名册</a></li>
							<li><a href="<c:url value ='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">作业案例</a></li>
						</ul>
	                </section>
	            </div>
	            <div class="column_2 ">
	                <article class="mainContent">
	                    <header class="contentNav">
	                        <nav class="nav">
								<a href="${pageContext.request.contextPath}/html/index.jsp">首页</a>·
								<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">教学管理</a>·
								<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">开课计划</a>·
								<a href="">查看详情</a>
	                        </nav>
	                        <h1>开课计划</h1>
	                    </header>
	                    <section class="article">
							<div class="itemDetail newItemContent">
								<h2 style="color: black;">${requestScope.term}</h2>
								<div id="my-pdf"></div>

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

<!-- 引入jq -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- 引入 显示pdf js组件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pdfobject.min.js"></script>
<script>
var $container = $("#my-pdf");
PDFObject.embed("${pageContext.request.contextPath}/${requestScope.path}", $container);
</script>
</body>
</html>