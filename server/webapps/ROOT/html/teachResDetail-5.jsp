<%@ page import="domain.Resource" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>教学资源-实验任务</title>
    <meta charset="utf-8">
    <link rel="icon" href="<c:url value='/images/dgut.jpg'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/normal.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/teachResDetail.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/teachResDetail-4.css'/>">
    <script type="text/javascript" src="<c:url value='/js/teachRes/teachResDetail-5.js'/>"></script>
</head>
<body>
<!-- 分页操作-->
<%
    ArrayList<Resource> list = (ArrayList<Resource>) request.getSession().getAttribute("resources");
    int page_current = 1; //当前页数
    int page_begin = 0; //起始点,注意:下标从0开始
    int page_end = 9; //终点,每页十条信息
    int total_count = 0;
    if (list != null)
        total_count = list.size(); //信息的总量
    int page_total = total_count / 10 + (total_count % 10 != 0 ? 1 : 0);
    if (request.getParameter("begin") != null) {
        page_current = Integer.parseInt(request.getParameter("begin")); //获取当前页数
    }
    page_begin = (page_current - 1) * 10;
    page_end = page_begin + 9 > total_count ? total_count : page_begin + 9;
    request.getSession().setAttribute("page_current", page_current); //保存到session中
    request.getSession().setAttribute("page_total", page_total);
%>
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
                    <jsp:include page="/html/left.jsp"/>
                    <script type="text/javascript">
                        var liList=document.getElementById("leftUl").children;
                        for(var i=0;i<liList.length;i++){
                            if(i==4)
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
                            <a href="/ShowResourceServlet.do?resType=5">实验任务</a>
                        </nav>
                        <h1>实验任务</h1>
                    </header>

                    <div id="resource">
                        <form action="/ShowResourceServlet.do" class="search" action="" method="post">
                            <input type="hidden" name="resType" value="5"/>
                            <input class="searchInput" type="search" name="search" id="search"/>
                            <input type="submit" name="search" id="" value="文件搜索"/>
                        </form>
                        <form id="myform" method="post" action="">
                            <table class="table" border="0" width="800px" cellpadding="2" cellspacing="1">
                                <tr class="firstRow">
                                    <td>序号</td>
                                    <td>文件名称</td>
                                    <td>上传时间</td>
                                    <td>操作</td>
                                </tr>
                                <%--循环遍历资源--%>
                                <c:set var="trType" scope="session" value="${0}"/>
                                <c:forEach items="${sessionScope.resources}"  var="resource" begin="<%=page_begin %>" end="<%=page_end %>">
                                    <c:choose>
                                        <c:when test="${trType==0}">
                                            <tr class="trOdd">
                                            <c:set var="trType" scope="session" value="${1}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <tr class="tr">
                                            <c:set var="trType" scope="session" value="${0}"/>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><c:out value="${resource.id}"/></td>
                                    <td><c:out value="${resource.resName}"/></td>
                                    <td><c:out value="${resource.resTime}"/></td>
                                    <td>
                                        <a onclick="Preview(event)"><img src="<c:url value='/images/teachResource/preview.png'/>"></a>
                                        <a href="<c:out value="${resource.resPath}"/>" download="<c:out value="${resource.resPath}"/>">
                                            <img src="<c:url value='/images/teachResource/download.png'/>">
                                        </a>
                                    </td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                        <div class="tranPage">
                            <table>
                                <tr>
                                    <td><a href="/html/teachResDetail-5.jsp?begin=1" onclick="getOnePage('first','');">首页</a></td>
                                    <c:if test="${sessionScope.page_current != 1 }">
                                        <td><a href="/html/teachResDetail-5.jsp?begin=${sessionScope.page_current - 1 }" onclick="getOnePage('pre','');">上一页</a></td>
                                    </c:if>
                                    <td>[${sessionScope.page_current } / ${sessionScope.page_total }]</td>
                                    <c:if test="${sessionScope.page_current != sessionScope.page_total }">
                                        <td><a href="/html/teachResDetail-5.jsp?begin=${sessionScope.page_current + 1 }">下一页</a></td>
                                    </c:if>
                                    <td><a href="/html/teachResDetail-5.jsp?begin=${sessionScope.page_total }" onclick="getOnePage('last','');">尾页</a></td>
                                </tr>
                            </table>
                        </div>
                        <input type="hidden" name="page" id="page" value="${requestScope.pageInformation.page}">
                        <input type="hidden" name="pageSize" id="pageSize" value="${requestScope.pageInformation.pageSize}">
                        <input type="hidden" name="totalPageCount" id="totalPageCount" value="${requestScope.pageInformation.totalPageCount}">
                        <input type="hidden" name="allRecordCount" id="allRecordCount" value="${requestScope.pageInformation.allRecordCount}">
                        <input type="hidden" name="orderField" id="orderField" value="${requestScope.pageInformation.orderField}">
                        <input type="hidden" name="order" id="order" value="${requestScope.pageInformation.order}">
                        <input type="hidden" name="ids" id="ids" value="${requestScope.pageInformation.ids}">
                        <input type="hidden" name="searchSql" id="searchSql" value="${requestScope.pageInformation.searchSql}">
                        <input type="hidden" name="result" id="result" value="${requestScope.pageInformation.result}">
                        </form>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
</html>