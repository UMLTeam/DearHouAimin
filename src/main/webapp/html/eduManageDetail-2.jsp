<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>教学管理</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/eduManageDetail.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/normal.css'/>">
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
	                    <h3>教学管理</h3>
	                    <ul>
							<li><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showFront">开课计划</a></li>
							<li class="current"><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></li>
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
	                            <a href="index.html">首页</a>·
	                            <a href="eduManageDetail-1.jsp">教学管理</a>·
	                            <a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a>
	                        </nav>
	                        <h1>上课班级</h1>
	                    </header>
	                    <section class="article">
							<div class="itemDetail newItemContent">
								<div class="bar6">
									<form>
										<input type="text" placeholder="请输入搜索班级" name="cname">
										<button type="submit"></button>
									</form>
								</div>
								<br><br>
								<table class="planTable disCenter">
									<tbody>

										<tr>
											<td><h3>班级</h3></td>
											<td><h3>专业</h3></td>
											<td><h3>课程</h3></td>
										</tr>
                                        <c:forEach items="${classInfoQuery.items}" var="classInfo">
                                            <tr>
                                                <td><h3>${classInfo.class_name}</h3></td>
                                                <td><h3>${classInfo.specialty}</h3></td>
                                                <td><h3>${classInfo.course_name}</h3></td>
                                            </tr>
                                        </c:forEach>
									</tbody>
								</table>

                                <%--<div class="pagination">--%>
                                    <%--<ul style="margin: auto">--%>
                                        <%--<c:if test="${classInfoQuery.currentPage!=1}">--%>
                                            <%--<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">首页</a></li>--%>
                                            <%--<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.currentPage-1}'/>">上一页</a></li>--%>
                                        <%--</c:if>--%>
                                        <%--<c:if test="${classInfoQuery.currentPage!=classInfoQuery.totalPage}">--%>
                                            <%--<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.currentPage+1}'/>">下一页</a></li>--%>
                                            <%--<li><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.totalPage}'/>">尾页</a></li>--%>
                                        <%--</c:if>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
								<br>
								<div class="pages">
									<div style="margin: auto">
										<c:if test="${classInfoQuery.currentPage!=1}">
											<span><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">首页</a></span>
											<span><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.currentPage-1}'/>">上一页</a></span>
										</c:if>
										<c:if test="${classInfoQuery.currentPage!=classInfoQuery.totalPage}">
											<span><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.currentPage+1}'/>">下一页</a></span>
											<span><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=${classInfoQuery.totalPage}'/>">尾页</a></span>
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
		<jsp:include page="/html/bottom.jsp"/>
	</div>
	<!-- 通过js渲染，js代码在normal.js里 -->
	<div id="copyrights">
		<jsp:include page="/html/copyright.jsp"/>
	</div>
</body>
</html>