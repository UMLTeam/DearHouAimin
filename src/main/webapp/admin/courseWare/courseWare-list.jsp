<%--
  Created by IntelliJ IDEA.
  User: chm
  Date: 18-12-28
  Time: 上午12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/style/teachRes/normal.css'/>">
    <script type="text/javascript" src="<c:url value='/js/teachRes/courseWare-list.js'/>"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>课件列表</title>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 课程概况 <span class="c-gray en">&gt;</span>
    课程简介 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);"
            title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <form id="courseWare" method="post" action="/courseWareServlet?type=adminShow">
        <div class="page-container">
            <div class="text-c"> 日期范围：
                <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate"
                       style="width:120px;">
                -
                <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate"
                       style="width:120px;">
                <input type="text" name="courseWareName" id="courseWareName" placeholder=" 课件名称" style="width:250px" class="input-text">
                <button name="searchCourseWare" id="searchCourseWare" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜课件</button>
            </div>
            <!-- TO-DO:实现批量删除 -->
            <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="data_del()" class="btn btn-danger radius"><i
                    class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="courseware_add('添加课件','courseware-add.html')"
                                                                  href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加课件</a></span> <span class="r">共有数据：<strong><c:out value="${requestScope.pageInformation.allRecordCount}"/> </strong> 条</span>
            </div>
            <div class="mt-20">
                <table id="coursewrae-table" class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="40"><input type="checkbox" name="box" value="1"></th>
                        <th width="80">ID</th>
                        <th width="70">课件类型</th>
                        <th width="70">课件大小</th>
                        <th width="70">上传用户</th>
                        <th>课件名称</th>
                        <th width="150">标签</th>
                        <th width="150">更新时间</th>
                        <th width="60">发布状态</th>
                        <th width="100">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.resources}"  var="resource">
                            <tr class="text-c">
                                <td><input type="checkbox" name="box" value="1"></td>
                                <td><c:out value="${resource.id}"/></td>
                                <td>PPT</td>
                                <td>1.1M</td>
                                <td>侯爱民</td>
                                <td class="text-l"><a href="https://view.officeapps.live.com/op/view.aspx?src=http://www.niracler.com/resource/《软件需求分析与设计》课程简介.pptx" target="_blank">《软件需求分析与设计》课程简介</a></td>
                                <td class="text-c"><c:out value="${resource.resName}"/></td>
                                <td><c:out value="${resource.resTime}"/></td>
                                <td class="td-status">
                                    <c:choose>
                                        <c:when test="${resource.isCheck == '0'}">
                                            <span class="label label-default radius">下架</span>
                                        </c:when>
                                        <c:when test="${resource.isCheck == '1'}">
                                            <span class="label label-success radius">已发布</span>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td class="td-manage">
                                    <a style="text-decoration:none" href="javascript:;" onClick="
                                        <c:choose>
                                             <c:when test="${resource.isCheck=='0'}">courseware_start(this)"  title="发布"</c:when>
                                             <c:when test="${resource.isCheck=='1'}">courseware_stop(this)"  title="下架"</c:when>
                                        </c:choose>
                                    >
                                        <i class="Hui-iconfont">&#xe6de;</i>
                                    </a>
                                    <a style="text-decoration:none" class="ml-5" onClick="courseware_edit('课件编辑','courseware-add.html')" href="javascript:;" title="编辑">
                                        <i class="Hui-iconfont">&#xe6df;</i>
                                    </a>
                                    <a style="text-decoration:none" class="ml-5" onClick="courseware_del(this)" href="javascript:;" title="删除">
                                        <i class="Hui-iconfont">&#xe6e2;</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%--<div class="tranPage">--%>
        <table>
            <tr>
                <td><a href="javascript:void(0);" onclick="getOnePage('first','');">首页</a></td>
                <td><a href="javascript:void(0);" onclick="getOnePage('pre','');">上一页</a></td>
                <td>[${requestScope.pageInformation.page}/${requestScope.pageInformation.totalPageCount}]</td>
                <td><a href="javascript:void(0);" onclick="getOnePage('next','');">下一页</a></td>
                <td><a href="javascript:void(0);" onclick="getOnePage('last','');">尾页</a></td>
            </tr>
        </table>
        <%--</div>--%>
        <input type="hidden" name="page" id="page" value="${requestScope.pageInformation.page}">
        <input type="hidden" name="pageSize" id="pageSize" value="${requestScope.pageInformation.pageSize}">
        <input type="hidden" name="totalPageCount" id="totalPageCount" value="${requestScope.pageInformation.totalPageCount}">
        <input type="hidden" name="allRecordCount" id="allRecordCount" value="${requestScope.pageInformation.allRecordCount}">
        <input type="hidden" name="orderField" id="orderField" value="${requestScope.pageInformation.orderField}">
        <input type="hidden" name="order" id="order" value="${requestScope.pageInformation.order}">
        <input type="hidden" name="ids" id="ids" value="${requestScope.pageInformation.ids}">
        <input type="hidden" name="searchSql" id="searchSql" value="${requestScope.pageInformation.searchSql}">
        <input type="hidden" name="result" id="result" value="${requestScope.pageInformation.result}">
    </form>
    </div>
</div>
<!-- TO-DO:将公共模块提出来在公共的js文件，简化操作 -->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

    $('.table-sort').dataTable({
        "aaSorting": [
            [1, "desc"]
        ], //默认第几个排序
        "bStateSave": true, //状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {
                "orderable": false,
                "aTargets": [0, 8]
            } // 制定列不参与排序
        ]
    });
    /*批量删除*/
    function data_del(){
        var checkedbox = $("[name=box]");
        for(var i=0;i<checkedbox.length;i++){
            if(checkedbox[i].checked){
                checkedbox[i].parents('tr').remove();
            }
        }
    }

    /*课件-添加*/
    function courseware_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*课件-查看*/
    function courseware_show(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*课件-审核*/
    function courseware_shenhe(obj) {
        layer.confirm('审核文章？', {
                btn: ['通过', '不通过'],
                shade: false
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend(
                    '<a class="c-primary" onClick="courseware_start(this)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {
                    icon: 6,
                    time: 1000
                });
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend(
                    '<a class="c-primary" onClick="courseware_shenqing(this)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {
                    icon: 5,
                    time: 1000
                });
            });
    }

    /*课件-下架*/
    function courseware_stop(obj) {
        layer.confirm('确认要下架吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend(
                '<a style="text-decoration:none" onClick="courseware_start(this)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>'
            );
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
            $(obj).remove();
            layer.msg('已下架!', {
                icon: 5,
                time: 1000
            });
        });
    }

    /*课件-发布*/
    function courseware_start(obj) {
        layer.confirm('确认要发布吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend(
                '<a style="text-decoration:none" onClick="courseware_stop(this)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>'
            );
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
            $(obj).remove();
            layer.msg('已发布!', {
                icon: 6,
                time: 1000
            });
        });
    }

    /*课件-申请上线*/
    function courseware_shenqing(obj) {
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {
            icon: 1,
            time: 2000
        });
    }

    /*课件-编辑*/
    function courseware_edit(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*课件-删除*/
    function courseware_del(obj) {
        layer.confirm('确认要删除吗？', function (index) {
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {
                icon: 1,
                time: 1000
            });
        });
    }
</script>
</body>
</html>
