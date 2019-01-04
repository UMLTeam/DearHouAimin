<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>班级名册</title>
    <meta charset="utf-8">
    <link rel="icon" href="<c:url value='/images/dgut.jpg'/>">
   <link rel="stylesheet" type="text/css" href="../style/normal.css">
	<link rel="stylesheet" type="text/css" href="../style/eduManage/eduManageDetail.css">
	<link rel="stylesheet" type="text/css" href="../style/eduManage/normal.css">
</head>
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
                        <li><a href="<c:url value='/OpenCoursePlanServlet?method=showFront'/>">开课计划</a></li>
                        <li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></li>
                        <li><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a></li>
                        <li class="current"><a href="<c:url value="/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1"/>">班级名册</a></li>
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
								<a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1'/>">班级名册</a>
							</nav>
							<h1>班级名册</h1>
						</header>
						<section class="article">
							<div class="itemDetail newItemContent">
								<div class="bar6">
									<form action="<c:url value='/class_list_Servlet?method=searchByName&addr=html'/>" method="post">
										<input type="text" name="searchName" id="" placeholder=" 班级名" style="width:250px" class="input-text">
										<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i></button>
									</form>
								</div>
								<table class="planTable disCenter">
									<tbody>
									<br><br>
									<table class="planTable disCenter">
										<tbody>
										<tr>
											<td><h3>班级id</h3></td>
											<td><h3>班级名称</h3></td>
											<td><h3>所属专业</h3></td>
											<td><h3>课程名称</h3></td>
											<td><h3>下载</h3></td>
											
										</tr>
										<c:forEach items="${classListpageQuery.items}" var="class_list">
											<tr>
												<td><h3>${class_list.class_id}</h3></td>
												<td><h3>${class_list.class_name}</h3></td>
												<td><h3>${class_list.major}</h3></td>
												<td><h3>${class_list.course}</h3></td>
												<td><h3> <a href="<c:url value='/class_list_Servlet?method=Download_Class_File&class_id=${class_list.class_id}'/>" download="${class_list.class_file_name}">下载</a></h3></td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br><br>
									
									
                <div class="pages">
										<div style="margin: auto">
											<c:if test="${classListpageQuery.currentPage!=1}">
												<span><a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1'/>">首页</a></span>
												<span><a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=${classListpageQuery.currentPage-1}'/>">上一页</a></span>
											</c:if>
											<c:if test="${classListpageQuery.currentPage!=StudentpageQuery.totalPage}">
												<span><a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=${classListpageQuery.currentPage+1}'/>">下一页</a></span>
												<span><a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=${classListpageQuery.totalPage}'/>">尾页</a></span>
											</c:if>
										</div>
									</div>
								
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