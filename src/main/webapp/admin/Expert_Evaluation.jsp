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
        class="c-gray en">&gt;</span> 专家评价 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form class="form form-horizontal" action="${pageContext.request.contextPath}/Expert_EvaluationServlet"
              method="post">
            <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
            <span class="select-box inline">
		<select name="type" class="select">
			<option value="0">全部分类</option>
			<option value="1">校内督导评价</option>
			<option value="2">校外专家评价</option>
		</select>
		</span>
            <input type="hidden" name="method" value="LoadExpert_Evaluation">
            <input type="hidden" name="EvaluationpageQuery" value="1">
            <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" data-title="添加评价" data-href="Expert_Evaluation_add.jsp"
               onclick="Hui_admin_tab(this)" href="javascript:;">
                <i class="Hui-iconfont">&#xe600;</i> 添加评价</a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="80">编号</th>
                <th>标题</th>
                <th width="80">分类</th>
                <th width="120">更新时间</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.EvaluationpageQuery.items }" var="i" varStatus="n">
                <tr class="text-c">
                    <td>${n.index+1 }</td>
                    <td class="text-l"><a style="cursor:pointer" class="text-primary"
                                          href="<c:url value='/Expert_EvaluationServlet?method=showContentById&id=${i.evaluation_id }'/>">${i.title }</a>
                    </td>
                    <td>
                        <c:if test="${i.type eq 1}">校内督导评价</c:if>
                        <c:if test="${i.type eq 2}">校外专家评价</c:if>
                    </td>
                    <td>${i.time }</td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5"
                           href="<c:url value='/Expert_EvaluationServlet?method=editContentById&id=${i.evaluation_id }'/>"
                           title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5"
                           href="javascript:deleteContent('${i.evaluation_id }')"
                           title="删除">
                            <i class="Hui-iconfont">&#xe6e2;</i></a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="text-align:center;margin:0 auto;width:400px;height:100px;">
            <div style="margin: auto">
                <c:if test="${EvaluationpageQuery.currentPage!=1}">
                    <span><a href="<c:url value='/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=1&type=${sessionScope.type }'/>">首页</a></span>
                    <span><a href="<c:url value='/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=${EvaluationpageQuery.currentPage-1}&type=${sessionScope.type }'/>">上一页</a></span>
                </c:if>
                <c:if test="${EvaluationpageQuery.currentPage!=EvaluationpageQuery.totalPage}">
                    <span><a href="<c:url value='/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=${EvaluationpageQuery.currentPage+1}&type=${sessionScope.type }'/>">下一页</a></span>
                    <span><a href="<c:url value='/Expert_EvaluationServlet?method=LoadExpert_Evaluation&EvaluationpageQuery=${EvaluationpageQuery.totalPage}&type=${sessionScope.type }'/>">尾页</a></span>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<c:url value='/admin/lib/jquery/1.9.1/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/lib/layer/2.4/layer.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui/js/H-ui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/static/h-ui.admin/js/H-ui.admin.js'/>"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value='/admin/lib/My97DatePicker/4.8/WdatePicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/admin/lib/laypage/1.2/laypage.js'/>"></script>
<script type="text/javascript">
    function deleteContent(id) {
        var flag = window.confirm("您确定要删除该评价吗?");
        if (flag) {
            window.location.href = "${pageContext.request.contextPath}/Expert_EvaluationServlet?method=deleteContent&id=" + id;
        }

    }

    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 5]}// 不参与排序的列
        ]
    });


</script>


</body>
</html>