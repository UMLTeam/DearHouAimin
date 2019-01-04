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
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/eduManageDetail.css'/>"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>班级名册管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 班级花名册管理</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a class="btn btn-primary radius" data-title="添加花名册" data-href="<c:url value='/admin/class_list_add.jsp'/>" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加花名册</a></span>
        <span class="r"><form action="<c:url value='/class_list_Servlet?method=searchByName&addr=jsp'/>" method="post"><input type="text" name="searchName" id="" placeholder=" 班级名" style="width:250px" class="input-text"><button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查找名单</button></form></span></div>
</div>
<table class="table table-border table-bordered table-hover table-bg">
    <thead>
    <tr class="text-c">
        <th width="80">班级ID</th>
        <th width="150">班级名称</th>
        <th width="150">所属专业</th>
        <th width="80">课程</th>
        <th width="60">名单表</th>
        <th width="80">删除名单</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${classListpageQuery.items}" var="class_list">
        <tr class="text-c">
            <td>${class_list.class_id}</td>
            <td>${class_list.class_name}</td>
            <td>${class_list.major}</td>
            <td>${class_list.course}</td>
            <td><a title="下载查看" href="<c:url value='/class_list_Servlet?method=Download_Class_File&class_id=${class_list.class_id}'/>" download="${class_list.class_file_name}">${class_list.class_file_name}</a></td>
            <td class="f-14"><a title="删除" href="<c:url value='/class_list_Servlet?method=deleteClassList&class_id=${class_list.class_id}'/>"class="ml-5"
                                style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pages">
    <div style="margin: auto">
        <c:if test="${classListpageQuery.currentPage!=1}">
            <span><a href="<c:url value='/class_list_Servlet?method=Admin_LoadClassList&classListpageQuery=1'/>">首页</a></span>
            <span><a href="<c:url value='/class_list_Servlet?method=Admin_LoadClassList&classListpageQuery=${classListpageQuery.currentPage-1}'/>">上一页</a></span>
        </c:if>
        <c:if test="${classListpageQuery.currentPage!=StudentpageQuery.totalPage}">
            <span><a href="<c:url value='/class_list_Servlet?method=Admin_LoadClassList&classListpageQuery=${classListpageQuery.currentPage+1}'/>">下一页</a></span>
            <span><a href="<c:url value='/class_list_Servlet?method=Admin_LoadClassList&classListpageQuery=${classListpageQuery.totalPage}'/>">尾页</a></span>
        </c:if>
    </div>
</div>
<div style="color: red">${info}</div><!-- 什么意思？ -->
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