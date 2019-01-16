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
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui.admin/skin/default/skin.css'/>"
          id="skin"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/static/h-ui.admin/css/style.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/eduManage/eduManageDetail.css'/>"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>
        DD_belatedPNG.fix('*');
    </script>
    <![endif]-->
    <title>角色管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学生成绩管理</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l"><a class="btn btn-primary radius" data-title="添加记录"
                           data-href="<c:url value='/admin/admin_student_add.jsp'/>" onclick="Hui_admin_tab(this)"
                           href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加记录</a></span>&nbsp;&nbsp;
        <span class="l"><a class="btn btn-primary radius" data-title="修改成绩"
                           data-href="<c:url value='/admin/admin_student_modify.jsp'/>" onclick="Hui_admin_tab(this)"
                           href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 修改成绩</a></span>
    </div>
</div>
<div class="bar6">
    <form action="<c:url value='/ScoreServlet'/>" method="post">
        <input type="hidden" name="method" value="selectAddminStudent">
        <input type="hidden" name="StudentpageQuery" value="1">
        <input type="text" placeholder="请输入学生学号" name="studentNo">
        <button type="submit"></button>
    </form>
</div>
<table class="table table-border table-bordered table-hover table-bg">
    <thead>
    <tr class="text-c">
        <th width="80">学号</th>
        <th width="110">姓名</th>
        <th width="150">专业</th>
        <th width="80">班级</th>
        <th width="60">课程</th>
        <th width="70">分数</th>
        <th width="60">删除记录</th>
        <th width="60">修改成绩</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${EvalatorpageQuery.items}" var="evalator">
        <tr class="text-c">
            <td>${evalator.studentNo}</td>
            <td>${evalator.studentName}</td>
            <td>${evalator.major}</td>
            <td>${evalator.className}</td>
            <td>${evalator.course}</td>
            <td>
                <c:if test="${evalator.score!=-1}">${evalator.score}</c:if>
                <c:if test="${evalator.score==-1}">未给出</c:if>
            </td>
            <td class="f-14"><a title="删除"
                                href="<c:url value='/ScoreServlet?method=Delete_Evalator&evalator_id=${evalator.studentNo}'/>"
                                class="ml-5"
                                style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
            <td><a style="text-decoration:none"
                   href="<c:url value='/admin/admin_student_modify.jsp?evalator_id=${evalator.studentNo}'/>"
                   title="修改成绩"><i class="Hui-iconfont">&#xe6de;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<div class="pagination" style="width:100%;">
    <ul style="margin: auto">
        <c:if test="${EvalatorpageQuery.currentPage!=1}">
            <li><a
                    href="<c:url value='/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=1'/>">首页</a></li>
            <li><a
                    href="<c:url value='/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage-1}'/>">上一页</a></li>
        </c:if>
        <c:if test="${EvalatorpageQuery.currentPage!=EvalatorpageQuery.totalPage}">
            <li><a
                    href="<c:url value='/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage+1}'/>">下一页</a></li>
            <li><a
                    href="<c:url value='/ScoreServlet?method=Admin_LoadStudentEvalator&EvalatorpageQuery=${EvalatorpageQuery.totalPage}'/>">尾页</a></li>
        </c:if>
    </ul>
</div>
<div style="color: red">${info}</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<c:url value='/admin/lib/jquery/1.9.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/lib/layer/2.4/layer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui/js/H-ui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui.admin/js/H-ui.admin.js'/>"></script>
<!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value='/admin/lib/datatables/1.10.0/jquery.dataTables.min.js'/>"></script>
</body>
</html>