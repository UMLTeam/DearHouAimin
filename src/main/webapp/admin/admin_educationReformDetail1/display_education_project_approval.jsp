<%@ page import="domain.dguterd2" %>
<!--_meta 作为公共模版分离出去-->
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/admin/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/admin/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/admin/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/admin/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/admin/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="/admin/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <style type="text/css">
        #edui1_bottombar {
            display: none !important;
        }
    </style>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>新增改革措施</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
    <script type="text/javascript" src="/admin/lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<%
    dguterd2 erd2 = (dguterd2) session.getAttribute("md_erd2");
%>
<body>
<article class="page-container">
    <div class="row cl">
        <div class="formControls col-xs-8 col-sm-9">
            <script id="container" name="erd_content" type="text/plain">
                    <%=erd2.getDguterd2_content() %>

            </script>
        </div>
    </div>
    </form>
</article>

<script type="text/javascript"
        src="/plugin/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript"
        src="/plugin/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var editor = UE.getEditor("container", {
        toolbars: [],
    })
</script>

</body>

</html>