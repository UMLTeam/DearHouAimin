<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学安排-教学日历</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../style/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/education/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/education/educationDetail.css">
    <script type="text/javascript" src="../js/pdfobject.min.js"></script>
    <script type="text/javascript" src="../js/normal.js"></script>
    <style>
        /* Only resize the element if PDF is embedded */
        .pdfobject-container {
            width: 800px;
            height: 600px;
        }
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
                    <h3>教学安排</h3>
                    <ul>
                        <li><a href="../html/educationalDetail-1.jsp">教学大纲</a></li>
                        <li class="current"><a href="../servlet/CalendarServlet?method=show">教学日历</a></li>
                        <li><a href="../html/educationalDetail-3.jsp">教学内容</a></li>
                        <li><a href="../html/educationalDetail-4.jsp">授课计划</a></li>
                        <li><a href="../html/educationalDetail-5.jsp">教学难重点</a></li>
                        <li><a href="../html/educationalDetail-6.jsp">教学方法与手段</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent" style="width: 600px">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.jsp">首页</a>·
                            <a href="educationalDetail-1.jsp">教学安排</a>·
                            <a href="">教学日历</a>
                        </nav>
                        <h1>教学日历</h1>
                    </header>
               <!--     <div id="my-container"></div>
                    <script>
                        PDFObject.embed("pdf/教学日历.pdf", "#my-container");
                    </script> -->
                </article>
                <div>
                    <embed src="../${calendar.pdfUrl}" width="800" height="800">
                </div>
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
    function next_pic () {
        index++;
        if(index > 4){
            index = 0;
        }
        showCurrentDot();
        var newLeft;
        if(wrap.style.left === "-4620px"){
            newLeft = -1540;
        }else{
            newLeft = parseInt(wrap.style.left)-770;
        }
        wrap.style.left = newLeft + "px";
    }
    // 下一张图方法实现
    function prev_pic () {
        index--;
        if(index < 0){
            index = 4;
        }
        showCurrentDot();
        var newLeft;
        if(wrap.style.left === "0px"){
            newLeft = -3080;
        }else{
            newLeft = parseInt(wrap.style.left)+770;
        }
        wrap.style.left = newLeft + "px";
    }
    // 上一张图方法实现
    var timer = null;
    function autoPlay () {
        timer = setInterval(function () {
            next_pic();
        },2000);
    }
    autoPlay();

    var container = document.getElementById("container");
    container.onmouseenter = function () {
        clearInterval(timer);
    }
    // 鼠标放置时，暂停轮播
    container.onmouseleave = function () {
        autoPlay();
    }
    // 鼠标离开时自动轮播
    var index = 0;
    var dots = document.getElementsByTagName("span");
    function showCurrentDot () {
        for(var i=0; i<dots.length; i++){
            dots[i].className = "";
        }
        dots[index].className = "on";
    }

    for (var i=0; i<dots.length; i++){
        (function(i){
            dots[i].onclick = function () {
                var dis = index - i;
                if(index == 4 && parseInt(wrap.style.left)!==-3850){
                    dis = dis - 5;
                }
                //和使用prev和next相同，在最开始的照片5和最终的照片1在使用时会出现问题，导致符号和位数的出错，做相应地处理即可
                if(index == 0 && parseInt(wrap.style.left)!== -770){
                    dis = 5 + dis;
                }
                wrap.style.left = (parseInt(wrap.style.left) + dis * 770)+"px";
                index = i;
                showCurrentDot();
            }
        })(i);
    }
</script>
</html>
