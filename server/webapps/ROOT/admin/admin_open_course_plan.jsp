<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="Bookmark" href="/favicon.ico" >
  <link rel="Shortcut Icon" href="/favicon.ico" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/html5shiv.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/respond.min.js"></script>
  <![endif]-->
  <link href="${pageContext.request.contextPath}/admin/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/admin/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/admin/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

  <!--[if IE 6]>
  <script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>开课计划</title>
  <style type="text/css">
    .pages {
      text-align: center;
      margin: 0 auto;
      width: 400px;
      height: 100px;
    }
    a, a:link {
      text-decoration: none;
      color: #4f608c;
    }
  </style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 开课计划</nav>




<div class="cl pd-5 bg-1 bk-gray mt-20">
  <form action="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=add"  method="post" enctype ="multipart/form-data">

    <select name="termValue">
      <c:forEach items="${requestScope.termArray}" var="item">
        <option value="${item.value}">${item.name}</option>
      </c:forEach>
    </select>
    请上传pdf格式的文件
    <input type="file" name="pdf" accept="application/pdf" >

    <input class="btn btn-primary radius" type="submit" value="添加">
  </form>
</div>

<div style="margin-top:20px">
  <table class="table table-border table-bordered table-hover table-bg">
    <thead>
    <tr class="text-c">
      <th width="200">学期</th>
      <th width="150">查看</th>
      <th width="150">删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.plans}" var="plan">
      <tr class="text-c">
        <td>${plan.termName}</td>
        <td><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showPDFAtBack&term=${plan.termName}&filePath=${plan.filePath}">查看</a></td>
        <td class="f-14"><a title="删除" href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=delete&id=${plan.id}" class="ml-5"
                            style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <!--翻页-->
  <div class="pages">
    <div style="margin: auto">
      <c:if test="${ requestScope.curPage != 0 }">
        <span><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showBack&page=${requestScope.curPage - 1}&size=4">上一页</a></span>
      </c:if>
      <span>当前第  ${requestScope.curPage + 1} 页</span>
      <c:if test="${ requestScope.nextPage }">
        <span><a href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showBack&page=${requestScope.curPage + 1}&size=4">下一页</a></span>
      </c:if>
    </div>
  </div>

  <!--翻页-->


<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
</body>
</html>