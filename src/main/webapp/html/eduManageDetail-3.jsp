<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>教学管理</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/eduManageDetail.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/normal.css'/>">
	<%----%>

</head>
<script type="text/javascript">
	function F_Open_dialog() 
	{ 
		document.getElementById("btn_file").click(); 
	} 

</script>
<body onload="Rendering()">
	<!-- 通过js渲染，js代码在normal.js里 -->
	<div id="top">
		<jsp:include page="/html/top.jsp" />
	</div>

	<article class="content">

		<section id="banner">
			<img src="<c:url value='/images/index/abouttop_03.jpg'/>">
		</section>
		<section class="mainWrap relative">
			<div class="detailContent">
				<div class="column_1">
					<section class="leftNav">
						<h3>教学管理</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">开课计划</a></li>
							<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></li>
							<li class="current"><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a></li>
							<li><a href="<c:url value="/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1"/>">班级名册</a></li>
							<li><a href="<c:url value ='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">作业案例</a></li>
						</ul>
					</section>
				</div>
				<div class="column_2 ">
					<article class="mainContent">
						<header class="contentNav">
							<nav class="nav">
								<a href="index.html">首页</a>·
								<a href="eduManageDetail-1.jsp">教学管理</a>·
								<a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a>
							</nav>
							<h1>学生成绩</h1>
						</header>
						<section class="article">
							<div class="itemDetail newItemContent">
								<div class="bar6">
									<form action="<c:url value='/ScoreServlet'/>" method="post">
										<input type="hidden" name="method" value="selectStudent">
										<input type="hidden" name="StudentpageQuery" value="1">
										<input type="text" placeholder="请输入学生学号" name="studentNo">
										<button type="submit"></button>
									</form>
								</div>
								<table class="planTable disCenter">
									<tbody>
									<br><br>
									<table class="planTable disCenter">
										<tbody>
										<tr>
											<td><h3>学号</h3></td>
											<td><h3>姓名</h3></td>
											<td><h3>专业</h3></td>
											<td><h3>班级</h3></td>
											<td><h3>课程</h3></td>
											<td><h3>分数</h3></td>
										</tr>
										<c:forEach items="${StudentpageQuery.items}" var="evalator">
											<tr>
												<td><h3>${evalator.studentNo}</h3></td>
												<td><h3>${evalator.studentName}</h3></td>
												<td><h3>${evalator.major}</h3></td>
												<td><h3>${evalator.className}</h3></td>
												<td><h3>${evalator.course}</h3></td>
												<td><c:if test="${evalator.score!=-1}"><h3>${evalator.score}</h3></c:if>

													<c:if test="${evalator.score==-1}">未给出</c:if>
												</td>
												<%--<td><h3>${evalator.score}</h3></td>--%>
											</tr>
										</c:forEach>
										<%--<tr><td><h3>2016软件工程卓越1班</h3></td><td><h3>软件工程</h3></td><td><h3>面向对象分析与设计</h3></td><td><a href="../resource/16软卓一班.xlsx" download="《软件需求分析与设计》课程简介.pptx">下载</a>--%>
											<%--<input type="file" id="btn_file" style="display:none"><a onclick="F_Open_dialog()">|上传</a>--%>
										<%--</td></tr>--%>
										<%--<tr><td><h3>2016软件工程卓越2班</h3></td><td><h3>软件工程</h3></td><td><h3>面向对象分析与设计</h3></td><td><a href="../resource/16软卓二班.xlsx" download="《软件需求分析与设计》课程简介.pptx">下载</a>--%>
											<%--<input type="file" id="btn_file" style="display:none"><a onclick="F_Open_dialog()">|上传</a>--%>
										<%--</td></tr>--%>
										<%--<tr><td><h3>2016软件工程1班</h3></td><td><h3>软件工程</h3></td><td><h3>面向对象分析与设计</h3></td><td><a href="../resource/16软卓二班.xlsx" download="《软件需求分析与设计》课程简介.pptx">下载</a>--%>
											<%--<input type="file" id="btn_file" style="display:none"><a onclick="F_Open_dialog()">|上传</a>--%>
										<%--</td></tr>--%>
										<%--<tr><td><h3>2016软件工程2班</h3></td><td><h3>软件工程</h3></td><td><h3>面向对象分析与设计</h3></td><td><a href="../resource/16软卓二班.xlsx" download="《软件需求分析与设计》课程简介.pptx">下载</a>--%>
											<%--<input type="file" id="btn_file" style="display:none"><a onclick="F_Open_dialog()">|上传</a>--%>
										<%--</td></tr>--%>
										<%--<tr><td><h3>2016网络工程1班</h3></td><td><h3>网络工程</h3></td><td><h3>面向对象分析与设计</h3></td><td><a href="../resource/16软卓二班.xlsx" download="《软件需求分析与设计》课程简介.pptx">下载</a>--%>
											<%--<input type="file" id="btn_file" style="display:none"><a onclick="F_Open_dialog()">|上传</a>--%>
										<%--</td></tr>--%>
									</tbody>
								</table>
								<br><br>
									<%--<div class="pagination">--%>
										<%--<ul style="margin: auto">--%>
											<%--<c:if test="${StudentpageQuery.currentPage!=1}">--%>
												<%--<li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">首页</a></li>--%>
												<%--<li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.currentPage-1}'/>">上一页</a></li>--%>
											<%--</c:if>--%>
											<%--<c:if test="${StudentpageQuery.currentPage!=StudentpageQuery.totalPage}">--%>
												<%--<li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.currentPage+1}'/>">下一页</a></li>--%>
												<%--<li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.totalPage}'/>">尾页</a></li>--%>
											<%--</c:if>--%>
										<%--</ul>--%>
									<%--</div>--%>
									<div class="pages">
										<div style="margin: auto">
											<c:if test="${StudentpageQuery.currentPage!=1}">
												<span><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">首页</a></span>
												<span><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.currentPage-1}'/>">上一页</a></span>
											</c:if>
											<c:if test="${StudentpageQuery.currentPage!=StudentpageQuery.totalPage}">
												<span><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.currentPage+1}'/>">下一页</a></span>
												<span><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=${StudentpageQuery.totalPage}'/>">尾页</a></span>
											</c:if>
										</div>
									</div>
								<%--<div class="pages">--%>
									<%--<p><a href="">首页&nbsp&nbsp&nbsp</a><a href="">上一页&nbsp&nbsp&nbsp</a><a href="">下一页&nbsp&nbsp&nbsp</a><a href="">尾页</a></p>--%>
								<%--</div>--%>
							</div>
						</section>

					</article>
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