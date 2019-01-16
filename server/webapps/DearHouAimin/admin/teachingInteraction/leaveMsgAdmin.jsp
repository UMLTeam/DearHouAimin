<%--
  Created by IntelliJ IDEA.
  User: linzerong
  Date: 2018/12/23
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<c:url value ='/lib/html5shiv.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/lib/respond.min.js'/>"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/h-ui/css/H-ui.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/h-ui.admin/css/H-ui.admin.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/lib/Hui-iconfont/1.0.8/iconfont.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/h-ui.admin/skin/default/skin.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/h-ui.admin/css/style.css'/>">
    <!--[if IE 6]>
    <script type="text/javascript" src="<c:url value='/lib/DD_belatedPNG_0.0.8a-min.js'/>"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>师生留言互动</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>教学安排 <span class="c-gray en">&gt;</span> 授课计划 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
	    <span class="l">
	        <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button></span>&nbsp;
        <a class="btn btn-primary radius" data-title="添加授课计划" data-href="teachingPlanAdd.jsp" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加授课计划</a>
        </span>
        <span class="r">共有数据：<strong>${fn:length(leaveMsgs)}</strong> 条</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="40">ID</th>
                <th width="80">留言内容</th>
                <th width="120">发布时间</th>
                <th width="120">发布用户Id</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <c:forEach var="leaveMsg" items="${requestScope.leaveMsgs }">
                <tr class="text-c">
                    <td>${leaveMsg.leaveMsgId }</td>
                    <td>${leaveMsg.leaveMsgContent }</td>
                    <td>${leaveMsg.publishedTime }</td>
                    <td>${leaveMsg.userId }</td>
                    <td><a href="<c:url value='/servlet/TeachingArrangementAdminServlet?type=delLeaveMsg&leaveMsgId=${leaveMsg.leaveMsgId}'/> ">删除</a></td>
                 <%--   <td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${x.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
            --%>    </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<c:url value='/lib/jquery/1.9.1/jquery.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/lib/layer/2.4/layer.js'/> "></script>
<script type="text/javascript" src="<c:url value='/static/h-ui/js/H-ui.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/static/h-ui.admin/js/H-ui.admin.js'/> "></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<c:url value='/lib/My97DatePicker/4.8/WdatePicker.js'/> "></script>
<script type="text/javascript" src="<c:url value='/lib/jquery.validation/1.14.0/jquery.validate.js'/> "></script>
<script type="text/javascript" src="<c:url value='/lib/jquery.validation/1.14.0/validate-methods.js'/> "></script>
<script type="text/javascript" src="<c:url value='/lib/jquery.validation/1.14.0/messages_zh.js'/> "></script>
<script type="text/javascript" src="<c:url value='/lib/webuploader/0.1.5/webuploader.min.js'/> "></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading":false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,0]}// 不参与排序的列
        ]
    });

    /*资讯-添加*/
    function article_add(title,url,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*资讯-编辑*/
    function article_edit(title,url,id,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*资讯-删除*/
    function article_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'GET',
                url: '/opencourses/textServlet?method=del&id='+id,
                dataType: 'json',
                success: function(data){
                    if (data.result == 1) {//请求成功
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!',{icon:1,time:1000});
                    } else {
                        layer.msg('删除失败!',{icon:1,time:1000});
                    }
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

</script>
</body>
</html>