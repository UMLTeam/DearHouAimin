<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui/css/H-ui.min.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui.admin/css/H-ui.admin.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/lib/Hui-iconfont/1.0.8/iconfont.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui.admin/skin/default/skin.css'/>" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui.admin/css/style.css'/>"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>作业管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生作业案例管理</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a class="btn btn-primary radius" data-title="添加作业" data-href="<c:url value='/admin/admin-homework-add.jsp'/>" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加作业</a></span></div>
</div>
<table class="table table-border table-bordered table-hover table-bg">
    <thead>
    <tr class="text-c">
        <th width="80">作业名称</th>
        <th width="150">作业主题</th>
        <th width="150">作业时间</th>
        <th width="150">作业下载</th>
        <th width="80">删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${HomeworkpageQuery.items}" var="homework">
        <tr class="text-c">
            <td>${homework.realname}</td>
            <td>${homework.description}</td>
            <td>${homework.timestamp}</td>
            <td class="f-14"><a title="下载" href="<c:url value='/HomeworkServlet?method=Download_Homework&id=${homework.id}'/>"class="ml-5"
                                style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a></td>
            <td class="f-14"><a title="删除" href="<c:url value='/HomeworkServlet?method=Delete_Homework&id=${homework.id}'/>"class="ml-5"
                                style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination" style="margin: auto">
    <ul style="margin: auto">
        <c:if test="${HomeworkpageQuery.currentPage!=1}">
            <span><a href="<c:url value='/HomeworkServlet?method=Admin_LoadHomework&HomeworkpageQuery=1'/>">首页</a></li>
            <span><a href="<c:url value='/HomeworkServlet?method=Admin_LoadHomework&HomeworkpageQuery=${HomeworkpageQuery.currentPage-1}'/>">上一页</a></span>
        </c:if>
        <c:if test="${HomeworkpageQuery.currentPage!=HomeworkpageQuery.totalPage}">
            <span><a href="<c:url value='/HomeworkServlet?method=Admin_LoadHomework&HomeworkpageQuery=${HomeworkpageQuery.currentPage+1}'/>">下一页</a></span>
            <span><a href="<c:url value='/HomeworkServlet?method=Admin_LoadHomework&HomeworkpageQuery=${HomeworkpageQuery.totalPage}'/>">尾页</a></span>
        </c:if>
    </ul>
</div>
<div style="color: red">${info}</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<c:url value='/admin/lib/jquery/1.9.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/lib/layer/2.4/layer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui/js/H-ui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui.admin/js/H-ui.admin.js'/>"></script> <!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value='/admin/lib/datatables/1.10.0/jquery.dataTables.min.js'/>"></script>
</body>
</html>