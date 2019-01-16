<%--
  author: Heze
  Date: 19-1-1
  Time: 下午4:18
--%>
<%@ page import="domain.Resource" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<%
	String path=request.getParameter("path");
	String name = request.getParameter("name");
	request.setAttribute("path", path);
	request.setAttribute("name", name);
 %>
<head>
    <title>教学资源-教学录像</title>
    <meta charset="utf-8">
    <link rel="icon" href="<c:url value='/images/dgut.jpg'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/teachResDetail.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/teachResDetail-1.css'/>">
    <script type="text/javascript" src="<c:url value='/js/teachRes/teachResDetail-1.js'/>"></script>

    <!--dplayer-->
    <link href="https://cdn.bootcss.com/dplayer/1.25.0/DPlayer.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/hls.js@latest"></script>
	<script src="https://cdn.bootcss.com/flv.js/1.5.0/flv.js"></script>
    <style>
        .detailContent .column_2{
            width: 720px;
        }
        /*.dplayer_wrap{*/
            /*!*position: relative;*!*/
			/*!*max-width:700px;*!*/
			/*!*height:500px;*!*/
			/*!*margin:0 auto;*!*/
		/*}*/
	</style>
</head>
<body>

<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>

<article class="content">

    <section id="banner">
        <img src="../images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <jsp:include page="/html/left.jsp"/>
                    <script>
                        var liList=document.getElementById("leftUl").children;
                        for(var i=0;i<liList.length;i++){
                            if(i==1)
                                liList[i].setAttribute("class","current");
                        }
                    </script>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                             <a href="/html/index.jsp">首页</a>·
                            <a href="/ShowResourceServlet.do?resType=1">教学资源</a>·
                            <a href="/ShowResourceServlet.do?resType=2">教学录像</a>
                        </nav>
                        <h1>教学录像名称: ${name}</h1>
                    </header>
                   <div id="resource">
                        <a href="javascript:history.go(-1)"><img src="/images/teachResource/返回.png">返回</a><br><br>
                      	<div class="dplayer_wrap">
                            <div id="dplayer"></div>
                        </div>
						<script src="https://cdn.bootcss.com/dplayer/1.25.0/DPlayer.min.js"></script>
						<script>
							//console.log('${path}');
							var dp = new DPlayer({
								container: document.getElementById('dplayer'),
    							screenshot: true,
                                allowfullscreen: true,
    							video: {
        							url: '${path}',
    							},
    							//pic: '/resource/teachResDetail-2/picture/1.png',
       	 						//thumbnails:'/resource/teachResDetail-2/picture/1.png',
							});
					 </script>  
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
</html>
