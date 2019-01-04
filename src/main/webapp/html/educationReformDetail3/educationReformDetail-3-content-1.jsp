<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>教学研究改革-改革成果</title>
		<meta charset="utf-8">
		<link rel="icon" href="/UML/images/dgut.jpg">
		<link rel="stylesheet" type="text/css" href="/html/style/normal.css">
		<link rel="stylesheet" type="text/css" href="/html/style/educationReform/normal.css">
		<link rel="stylesheet" type="text/css" href="/html/style/educationReform/educationReformDetail.css">
		<script type="text/javascript" src="/html/js/educationReformDetail/normal.js"></script>
		<style type="text/css">
			.content .mainContent .article>.present>ul>li {
				list-style: disc;
				/* 实心圆 */
				margin-bottom: 0.4em;
			}
			
			.content .mainContent .article>.present .fRight {
				float: right;
				color: #999;
			}
			
			.content .mainContent .article>.present .educationReformDetail-3-content-table,
			.content .mainContent .article>.present .educationReformDetail-3-content-table td {
				width: auto;
				border: 2px solid #04837e;
				border-collapse: collapse;
				/*合并边框*/
				text-align: center;
			}
			
			.content .mainContent .article>.present .educationReformDetail-3-content-table .th {
				column-span: all;
				font-weight: bold;
			}
		</style>
	</head>

	<body onload="Rendering();">
		<!-- 通过js渲染，js代码在normal.js里 -->
		<div id="top"></div>

		<article class="content">

			<section id="banner">
				<img src="/images/index/abouttop_03.jpg">
			</section>
			<section class="mainWrap relative">
				<div class="detailContent">
					<div class="column_1">
						<section class="leftNav">
							<h3>教学研究改革</h3>
							<ul>
								<li>
									<a href="/html/educationReformDetail-1.html">改革措施</a>
								</li>
								<li>
									<a href="/html/educationReformDetail-2.html">改革立项</a>
								</li>
								<li class="current">
									<a href="/html/educationReformDetail-3.html">改革成果</a>
								</li>
								<li>
									<a href="/html/educationReformDetail-4.html">改革表彰和奖励</a>
								</li>
							</ul>
						</section>
					</div>
					<div class="column_2 ">
						<article class="mainContent">
							<header class="contentNav">
								<nav class="nav">
									<a href="/html/index.html">首页</a>·
									<a href="/html/educationReformDetail-3.html">教学研究改革</a>·
									<a href="/html/educationReformDetail-3.html">改革成果</a>
								</nav>
								<h1>改革成果</h1>
							</header>
							<section class="article">
								<figure class="present">
									<!-- <img src="../images/educationReform/reformResult.jpeg" width="864" height="648" class="portrait"> -->
									<!--<img src="../images/index/President-z.gif">-->
									<!-- <ul>
								<li><a href="#">2012-2014年法学教师教改论文</a><span class="fRight">2017-05-03</span></li>
								<li><a href="#">2012-2014年法学教师教改论文</a><span class="fRight">2016-11-25</span></li>
							</ul> -->
							
									
										<table class="educationReformDetail-3-content-table">
											<tr>
												<td class="th">${requestScope.achievement.title}</td>
											</tr>
											<tr>
												<td class="thead">序号</td>
												<td class="thead">论文题目</td>
												<td class="thead">第一作者</td>
												<td class="thead">发表/出版时间</td>
												<td class="thead">发表刊物/论文集</td>
											</tr>
											<c:forEach items="${requestScope.achievement.achievementItems}" var="row1" >
										  		<tr>
											   <td>${row1.id}</td>
											   <td>${row1.title}</td>
											   <td>${row1.author}</td>
											   <fmt:formatDate var="myItemDate"
													value="${row1.publish_time}"
													pattern="yyyy-MM-dd" />
											   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${row1.publish_time}" type="both"/></td>
											    <td>${row1.publication}</td>
											   </tr>
										   </c:forEach>
										</table>
									
								</figure>
							</section>

						</article>
					</div>				
					<div class="column_3">

					</div>
				</div>
			</section>
		</article>

		<!-- 通过js渲染，js代码在normal.js里 -->
		<div id="bottom"></div>
		<!-- 通过js渲染，js代码在normal.js里 -->
		<div id="copyrights"></div>
	</body>
</html>
