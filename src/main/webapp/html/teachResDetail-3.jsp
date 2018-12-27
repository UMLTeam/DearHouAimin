<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学资源-习题库</title>
    <meta charset="utf-8">
    <link rel="icon" href="/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="../style/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/teachRes/normal.css">
    <link rel="stylesheet" type="text/css" href="../style/teachRes/teachResDetail.css">
    <script type="text/javascript" src="../js/normal.js"></script>
    <script type="text/javascript" src="../js/teachRes/teachResDetail-3.js"></script>
</head>
<body onload="Rendering();">
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="top"></div>

<article class="content">

    <section id="banner">
        <img src="../images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>教学资源</h3>
                    <ul>
                        <li><a href="teachResDetail-1.html">课程课件</a></li>
                        <li><a href="teachResDetail-2.html">教学录像</a></li>
                        <li class="current"><a href="teachResDetail-3.jsp">习题库</a></li>
                        <li><a href="teachResDetail-4.html">案例库</a></li>
                        <li><a href="teachResDetail-5.html">实验任务</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.html">首页</a>·
                            <a href="teachResDetail-1.html">教学资源</a>·
                            <a href="teachResDetail-3.jsp">习题库</a>
                        </nav>
                        <h1>习题库</h1>
                    </header>

                    <div id="resource">
                        <form class="search" action="" method="post">
                            <input class="searchInput" type="search" name="search">
                            <input class="searchSubmit" type="submit" value="文件搜索">
                        </form>
                        <table class="table" border="0" width="800px" cellpadding="2" cellspacing="1">
                        <tr class="firstRow">
                            <td>序号</td>
                            <td>文件名称</td>
                            <td>文件大小</td>
                            <td>上传时间</td>
                            <td>操作</td>
                        </tr>
                        <tr class="trOdd">
                            <td>1</td>
                            <td class="tll"><img src="../images/teachResource/PPT.png">《软件需求分析与设计》课程简介.pptx</td>
                            <td>1.2M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》课程简介.pptx" download="《软件需求分析与设计》课程简介.pptx">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="tr">
                            <td>2</td>
                            <td class="tll"><img src="../images/teachResource/WORD.png">西方经济学.pptx</td>
                            <td>1.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf" download="2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="trOdd">
                            <td>3</td>
                            <td class="tll"><img src="../images/teachResource/PDF.png">计算机操作系统.pdf</td>
                            <td>0.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》综合实践.pdf" download="《软件需求分析与设计》综合实践.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="tr">
                            <td>4</td>
                            <td class="tll"><img src="../images/teachResource/WORD.png">大学物理.doc</td>
                            <td>1.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》综合实践.pdf" download="《软件需求分析与设计》综合实践.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="trOdd">
                            <td>5</td>
                            <td class="tll"><img src="../images/teachResource/WORD.png">西方经济学.doc</td>
                            <td>1.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》综合实践.pdf" download="《软件需求分析与设计》综合实践.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="tr">
                            <td>6</td>
                            <td class="tll"><img src="../images/teachResource/WORD.png">西方经济学.doc</td>
                            <td>1.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》综合实践.pdf" download="《软件需求分析与设计》综合实践.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                        <tr class="trOdd">
                            <td>7</td>
                            <td class="tll" ><img src="../images/teachResource/xls.png">西方经济学.xls</td>
                            <td>1.3M</td>
                            <td>2018-12-17</td>
                            <td>
                                <a onclick="Preview(event)"><img src="../images/teachResource/preview.png"></a>
                                <a href="../resource/《软件需求分析与设计》综合实践.pdf" download="《软件需求分析与设计》综合实践.pdf">
                                    <img src="../images/teachResource/download.png">
                                </a>
                            </td>
                        </tr>
                    </table>
                    </div>

                </article>
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