<%@ page language="java" import="java.util.*,java.io.*,org.apache.poi.xwpf.usermodel.*,org.apache.poi.*,org.apache.poi.xwpf.extractor.XWPFWordExtractor" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><html>
<%@ page isELIgnored="false" %>
<head>
<title>课程概况-课程简介</title>
<meta charset="utf-8">
<link rel="icon" href="${pageContext.request.contextPath }/images/dgut.jpg">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/normal.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/courseDetail/normal.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/courseDetail/courseDetail.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/normal.js"></script>

</head>
<body>
	<%
		String path = application.getRealPath("");
		String ss;
		String[] strs = new String[]{""};
		XWPFDocument xwdoc = new XWPFDocument(POIXMLDocument.openPackage(path + "/resource/面向对象分析与设计--课程特色.docx"));
		POIXMLTextExtractor ex = new XWPFWordExtractor(xwdoc);
		ss = ex.getText().trim();
		strs = ss.split("\n");
	%>
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
							<li><a href="courseDetail-1.jsp">课程简介</a></li>
							<li class="current"><a href="courseDetail-2.jsp">课程特色</a></li>
							<li><a href="courseDetail-3.jsp">教材与参考资料</a></li>
							<li><a href="courseDetail-4.jsp">历史沿革</a></li>
						</ul>
					</section>
				</div>
				<div class="column_2 ">
					<article class="mainContent">
						<header class="contentNav">
							<nav class="nav">
								<a href="index.jsp">首页</a>· <a href="courseDetail-1.jsp">课程概况</a>·
								<a href="courseDetail-2.jsp">课程特色</a>
							</nav>
							<h1><%=strs[0]%></h1>
						</header>

						<div id="container">

							<div id="buttons">
								<span class="on"></span> <span></span> <span></span> <span></span>
								<span></span>
							</div>
							<div id="des" class="article">
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
								
								<p> </p>
							</div>
						</div>

						<div id="inner">
							<p></p>
							<p></p>
							<p></p>
							<!--<img src="../images/index/7.png" style="width: 550px">-->
						</div>
					</article>
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
<script type="text/javascript">

	var wrap = document.getElementById("wrap");
	function next_pic() {
		index++;
		if (index > 4) {
			index = 0;
		}
		showCurrentDot();
		var newLeft;
		if (wrap.style.left === "-4620px") {
			newLeft = -1540;
		} else {
			newLeft = parseInt(wrap.style.left) - 770;
		}
		wrap.style.left = newLeft + "px";
	}
	// 下一张图方法实现
	function prev_pic() {
		index--;
		if (index < 0) {
			index = 4;
		}
		showCurrentDot();
		var newLeft;
		if (wrap.style.left === "0px") {
			newLeft = -3080;
		} else {
			newLeft = parseInt(wrap.style.left) + 770;
		}
		wrap.style.left = newLeft + "px";
	}
	// 上一张图方法实现
	var timer = null;
	function autoPlay() {
		timer = setInterval(function() {
			next_pic();
		}, 1000);
	}
	autoPlay();

	var container = document.getElementById("container");
	container.onmouseenter = function() {
		clearInterval(timer);
	}
	// 鼠标放置时，暂停轮播
	container.onmouseleave = function() {
		autoPlay();
	}
	// 鼠标离开时自动轮播
	var index = 0;
	var dots = document.getElementsByTagName("span");
	function showCurrentDot() {
		for (var i = 0; i < dots.length; i++) {
			dots[i].className = "";
		}
		dots[index].className = "on";
	}

	for (var i = 0; i < dots.length; i++) {
		(function(i) {
			dots[i].onclick = function() {
				var dis = index - i;
				if (index == 4 && parseInt(wrap.style.left) !== -3850) {
					dis = dis - 5;
				}
				//和使用prev和next相同，在最开始的照片5和最终的照片1在使用时会出现问题，导致符号和位数的出错，做相应地处理即可
				if (index == 0 && parseInt(wrap.style.left) !== -770) {
					dis = 5 + dis;
				}
				wrap.style.left = (parseInt(wrap.style.left) + dis * 770) + "px";
				index = i;
				showCurrentDot();
			}
		})(i);
	}
</script>
</html>
