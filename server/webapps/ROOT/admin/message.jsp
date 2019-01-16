<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <title>空白页</title>
  <!-- 显示pdf容器样式 -->
  <style>
    .btn{
      height: 28px;
      font-size: 18px;
      background-color: lightskyblue;
      padding: 4px 10px;
      cursor: pointer;
      border: 0px;
    }
  </style>
</head>
<body>
<div class="pd-20">
  <div style="margin: 10px 20px;">
    <a class="btn" href="${pageContext.request.contextPath}/OpenCoursePlanServlet?method=showBack">返回</a>
  </div>
  <h3 style="color: red;">${requestScope.message}</h3>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/static/h-ui.admin/js/H-ui.admin.js"></script>

</body>
</html>