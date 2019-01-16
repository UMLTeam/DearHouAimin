<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>


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
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->


    <title>显示专家评价</title>

</head>
<body>
<article class="page-container">
    <div style="width: 700px; height: 500px; margin:0 auto;">
        <div style="width: 700px; height: 50px; text-align:center;">
            ${sessionScope.editContent.title }
        </div>
        <br>
        <div style="width: 700px; height: 500px;">
            ${sessionScope.editContent.content }
        </div>
    </div>


</article>

</body>
</html>