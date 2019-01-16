<%@page import="domain.*"%>

<%@ page language="java"
	import="java.util.*,java.io.*,org.apache.poi.xwpf.usermodel.*,org.apache.poi.*,org.apache.poi.xwpf.extractor.XWPFWordExtractor"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" import="java.util.*,service.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
<title>课程概况-课程简介</title>
<meta charset="utf-8">
<link rel="icon"
	href="${pageContext.request.contextPath}/images/dgut.jpg">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/normal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/courseDetail/normal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/courseDetail/courseDetail.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/normal.js"></script>
</head>

<body>
	<%
		String path = application.getRealPath("");
		String ss;
		String[] strs = new String[] { "" };
		XWPFDocument xwdoc = new XWPFDocument(POIXMLDocument.openPackage(path + "/resource/面向对象分析与设计--课程简介.docx"));
		POIXMLTextExtractor ex = new XWPFWordExtractor(xwdoc);
		ss = ex.getText().trim();
		strs = ss.split("\n");
	%>
	<!-- 通过js渲染，js代码在normal.js里 -->
    <title>课程概况-课程简介</title>
    <meta charset="utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/images/dgut.jpg">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/normal.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/courseDetail/normal.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/courseDetail/courseDetail.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/normal.js"></script>
</head>

<body>
    <!-- 通过js渲染，js代码在normal.js里 -->
    <div id="top">
        <jsp:include page="/html/top.jsp"/>
    </div>

    <article class="content">

        <section id="banner">
            <img src="${pageContext.request.contextPath }/images/index/abouttop_03.jpg">
        </section>
        <section class="mainWrap relative">
            <div class="detailContent">
                <div class="column_1">
                    <section class="leftNav">
                        <h3>课程概况</h3>
                        <ul>
                            <li class="current"><a href="courseDetail-1.jsp">课程简介</a></li>
                            <li><a href="courseDetail-2.jsp">课程特色</a></li>
                            <li><a href="courseDetail-3.jsp">教材与参考资料</a></li>
                            <li><a href="courseDetail-4.jsp">历史沿革</a></li>
                        </ul>
                    </section>
                </div>
                <div class="column_2 ">
                    <article class="mainContent">
                        <header class="contentNav">
                            <nav class="nav">
                                <a href="index.jsp">首页</a>·
                                <a href="courseDetail-1.jsp">课程概况</a>·
                                <a href="courseDetail-1.jsp">课程简介</a>
                            </nav>
                            <h1>《面向对象分析与设计(UML)》课程简介</h1>
                        </header>
                        <section class="article">

                        
                        <%
                                         	for (int i = 1; i < strs.length; i++) {
                                         		if (strs[i] == null || strs[i].equals(""))
                                         			continue;
                                                %>
								<p><%=strs[i]%></p>
								<%
									}
									ex.close();
								%>
                        <!-- 
                        	<p>本课程旨在系统地介绍运用UML技术对软件系统进行面向对象的分析与设计。重点介绍了UML的十种模型图（用例图、类图、对象图、顺序图、协作图、状态图、活动图、组件图、包图、部署图）的建模原理及实际应用。</p>
                            <p>本课程旨在系统地介绍运用UML技术对软件系统进行面向对象的分析与设计。重点介绍了UML的十种模型图（用例图、类图、对象图、顺序图、协作图、状态图、活动图、组件图、包图、部署图）的建模原理及实际应用。</p>

                            <p>为了帮助学生能够理解概念、掌握知识、运用方法解决实际问题，在每个章节中配备了许多来自于现实应用的案例，通过习题和实验巩固知识的掌握，通过综合实训检验知识的运用。</p>
                            <p>为了体现课程的工程特点，按照CDIO工程教育模式，组织章节体系及教学内容。CDIO代表构思（Conceive）、设计（Design）、实现（Implement）和运作（Operate） ，它以产品研发到产品运行的生命周期为载体 ,让学生以主动的、 实践的、 课程之间有机联系的方式学习工程。CDIO培养大纲将工程毕业生的能力分为工程基础知识、个人能力、人际团队能力和工程系统能力四个层面。通过综合实训，完成CDIO工程教育模式的实践。用例图建摸和体系结构（组件图、包图、部署图）建摸完成C（Conceive）。静态建摸（类图、对象图）和动态建模（顺序图、协作图、状态图、活动图）完成D（Design）。使用JSP技术，开发《面向对象分析与设计(UML)》在线开放课程平台。完成I（Implement）。十个人一组，从需求分析、到系统设计、再到实现全过程，进行工程过程管理，完成O（Operate）。</p>
                            <p>Rational统一过程（RUP）提出了面向对象方法分析、设计和实现软件系统的生命周期模型。为了帮助学生更好地理解和体验RUP的生命周期模型，安排九个工作流中的六个核心工作流进行十种模型图的建模；安排四个Cycle生成四个版本的产品，每个Cycle进行四个阶段的迭代实践。</p>
                            <p>学生毕业，进入企业，走向软件开发工作一线后，前期会参加公司产品培训阶段的学习，合格者后期会进入新产品的研发团队，从事相关事务。为了帮助学生及早适应企业的工作节奏，培养学生的动手能力，安排逆向工程方式和正向工程方式进行项目实践。逆向工程方式，解剖他人开发的可运行的软件产品，培养学生在企业中前期学习的适应能力。正向工程方式，从需求分析到系统设计、实现全过程，十个人一组为单位，编程开发可运行的软件产品，培养学生在企业中后期研发的适应能力。</p>
                            <p>本课程适合软件工程、计算机科学与技术、网络工程等专业的大二或大三本科生学习和实践。可以作为软件系统开发类的课程的先行课程进行讲授。</p>

                         -->
                            

                        </section>
                    </article>
                    <br>
                    <br>

                    <a href="${pageContext.request.contextPath }/resource/面向对象分析与设计--课程简介.pdf">点击这里查看课程简介.pdf文件</a>

                    <a href="${pageContext.request.contextPath }/resource/面向对象分析与设计--课程简介.pdf">点击这里下载课程简介.pdf文件</a>
                </div>
                <div class="column_3">
                    <figure class="present">
                        <img hidden src="images/courseDetail/aoxin.jpg" class="portrait">
                    </figure>
                </div>
            </div>
        </section>
    </article>

	<div id="bottom">
		<jsp:include page="/html/bottom.jsp"/>
	</div>

	<div id="copyrights">
		<jsp:include page="/html/copyright.jsp"/>
	</div>
</body>

</html>