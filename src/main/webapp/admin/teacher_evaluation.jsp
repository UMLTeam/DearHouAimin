<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>专家评价</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 教学效果 <span
        class="c-gray en">&gt;</span> 专家评价
</nav>

<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
   href="<c:url value='/teacher_evalution_servlet?method=Admin_LoadTeacherEvalator&EvalatorpageQuery=1'/>" title="刷新">
    <i class="Hui-iconfont">&#xe68f;</i>
</a>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">

            <a class="btn btn-primary radius" data-title="添加评价" href="teacher_evaluation_add.jsp"">
                <i class="Hui-iconfont">&#xe600;</i> 添加评价
            </a>

        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="10%">ID</th>
                <th width="10%">教师姓名</th>
                <th width="10%">评价标题</th>
                <th>评价内容</th>
                <th width="10%">评价时间</th>
                <th width="10%">发布状态</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${EvalatorpageQuery.items}" var="evalator">
                <tr class="text-c">
                    <td>${evalator.evalutionId}</td>
                    <td>${evalator.teacherName}</td>
                    <td>${evalator.evalutionTitle}</td>
                    <td>${evalator.content}</td>
                    <td>${evalator.evalutionTime}</td>

                    <c:if test="${evalator.status == 0 }">
                        <td class="td-status">
                            <span class="label label-success radius"
                                  style="text-decoration:none;background: red;">未发布</span>
                        </td>
                    </c:if>

                    <c:if test="${evalator.status == 1 }">
                        <td class="f-14 td-manage">
                            <span class="label label-success radius">已发布</span>
                        </td>
                    </c:if>

                    <td class="f-14 td-manage">

                        <c:if test="${evalator.status == 0 }">
                            <a style="text-decoration:none"
                               href="<c:url value='/teacher_evalution_servlet?method=editStatus&status=1&evalutionId=${evalator.evalutionId}'/>"
                               title="审核">审核</a>
                        </c:if>

                        <c:if test="${evalator.status == 1 }">
                            <a style="text-decoration:none"
                               href="<c:url value='/teacher_evalution_servlet?method=editStatus&status=0&evalutionId=${evalator.evalutionId}'/>"
                               title="禁止">禁止</a>
                        </c:if>


                        <a title="删除"
                           href="<c:url value='/teacher_evalution_servlet?method=deleteEvalution&evalatorId=${evalator.evalutionId}'/>"
                           class="ml-5" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br/>
        <div class="pagination" style="width:100%;">
            <ul style="margin: auto">
                <c:if test="${EvalatorpageQuery.currentPage!=1}">
                    <li><a style="float:left;" class="btn btn-primary radius"
                           href="<c:url value='/teacher_evalution_servlet?method=Admin_LoadTeacherEvalator&EvalatorpageQuery=1'/>">首页</a>
                    </li>
                    <li><a style="float:left;" class="btn btn-primary radius"
                           href="<c:url value='/teacher_evalution_servlet?method=Admin_LoadTeacherEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage-1}'/>">上一页</a>
                    </li>
                </c:if>
                <c:if test="${EvalatorpageQuery.currentPage!=EvalatorpageQuery.totalPage}">
                    <li><a style="float:left;" class="btn btn-primary radius"
                           href="<c:url value='/teacher_evalution_servlet?method=Admin_LoadTeacherEvalator&EvalatorpageQuery=${EvalatorpageQuery.currentPage+1}'/>">下一页</a>
                    </li>
                    <li><a style="float:left;" class="btn btn-primary radius"
                           href="<c:url value='/teacher_evalution_servlet?method=Admin_LoadTeacherEvalator&EvalatorpageQuery=${EvalatorpageQuery.totalPage}'/>">尾页</a>
                    </li>
                </c:if>
            </ul>
        </div>


    </div>
</div>


</body>
</html>