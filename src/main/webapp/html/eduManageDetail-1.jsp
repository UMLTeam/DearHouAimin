<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>教学管理</title>
	<meta charset="utf-8">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/normal.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/eduManage/eduManageDetail.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/eduManage/normal.css">

	<!-- 开课计划列表样式 -->
	<style>
		table {
			color: #015249;
		}
		tr{
			height: 40px;
		}
		td{
			padding: 0 20px;
		}

		.page{
			width: 340px;
			padding-left: 80px;
			margin-top: 20px;
			color: black;
		}
		table a, .page a{
			margin: 0 10px;
			cursor: pointer;
		}
		table a:hover, .page a:hover{
			background-color: #04837e;
			color: white;
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
							<li><a href="<c:url value="/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1"/>">班级名册</a></li>
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
	                            <a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">开课计划</a>
	                        </nav>
	                        <h1>开课计划</h1>
	                    </header>
	                    <section class="article">

							<!--开课计划列表-->
							<table>
								<c:forEach items="${requestScope.plans}" var="plan">
									<tr>
										<td>${plan.termName}</td>
										<td>
											<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showPDFAtFront&term=${plan.termName}&filePath=${plan.filePath}">查看</a>
											<a href="${pageContext.request.contextPath}/${plan.filePath}">下载</a>
										</td>
									</tr>
								</c:forEach>
							</table>
							<!--开课计划列表-->
							<!--翻页-->
							<div class="page">
								<c:if test="${ requestScope.curPage != 0 }">
									<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront&page=${requestScope.curPage - 1}&size=4">上一页</a>
								</c:if>
								第 ${requestScope.curPage + 1} 页
								<c:if test="${ requestScope.nextPage }">
									<a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront&page=${requestScope.curPage + 1}&size=4">下一页</a>
								</c:if>
							</div>
							<!--翻页-->
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