<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018-12-25
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>习题列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 课程概况 <span
        class="c-gray en">&gt;</span>
    课程简介 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
            href="javascript:location.replace(location.href);"
            title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin"
               class="input-text Wdate"
               style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax"
               class="input-text Wdate"
               style="width:120px;">
        <input type="text" name="" placeholder=" 习题名称" style="width:250px" class="input-text">
        <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜习题</button>
    </div>
    <!-- TO-DO:实现批量删除 -->
    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="data_del()"
                                                                class="btn btn-danger radius"><i
            class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius"
                                                          onclick="courseware_add('添加习题','/admin/exercise/exercise-add.jsp')"
                                                          href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加习题</a></span>
        <span class="r">共有数据：<strong>2</strong> 条</span>
    </div>
    <div class="mt-20">
        <table id="coursewrae-table" class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
            <tr class="text-c">
                <th width="40"><input type="checkbox" name="box" value="1"></th>
                <th width="80">ID</th>
                <th width="70">文件名称</th>
                <th width="70">文件大小</th>
                <th width="150">更新时间</th>
                <th width="60">发布状态</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.resourceList}" var="resource" varStatus="status">
                <tr class="text-c">
                    <td><input type="checkbox" name="box" value="1"></td>
                    <td>${resource.id}</td>
                    <td style="text-align: left">
                        <img src="/images/teachResource/PPT.png">
                        <a href="${resource.resPath}" download="${resource.resName}">${resource.resName}</a>
                    </td>
                    <td><c:out value="${10000}"/></td>
                    <td><c:out value="${resource.resTime}"/></td>
                    <td class="td-status"><span class="label label-success radius">已发布</span></td>
                    <td class="td-manage">
                        <a style="text-decoration:none" onClick="courseware_stop(this,${resource.id})" href="javascript:;" title="下架">
                            <i class="Hui-iconfont">&#xe6de;</i>
                        </a>
                        <a style="text-decoration:none" class="ml-5" onClick="courseware_edit('图库编辑','/admin/exercise/exercise-add.jsp',${resource.id})" href="javascript:;" title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                        <a style="text-decoration:none" class="ml-5" onClick="courseware_del(this,${resource.id})" href="javascript:;" title="删除">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- TO-DO:将公共模块提出来在公共的js文件，简化操作 -->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.js"></script>
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
                "aTargets": [0, 5]
            } // 制定列不参与排序
        ]
    });


    /*批量删除*/
    function data_del() {
        var checkedbox = $("[name=box]");
        for (var i = 0; i < checkedbox.length; i++) {
            if (checkedbox[i].checked) {
                checkedbox[i].parents('tr').remove();
            }
        }

        // $.ajax({
        //     url: '/ExerciseServlet.do?'
        //     mothod: POST,
        //
        // })
    }

    /*文件-添加*/
    function courseware_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*文件-查看*/
    function courseware_show(title, url, id) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*文件-审核*/
    function courseware_shenhe(obj, id) {
        layer.confirm('审核文章？', {
                btn: ['通过', '不通过'],
                shade: false
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend(
                    '<a class="c-primary" onClick="courseware_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {
                    icon: 6,
                    time: 1000
                });
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend(
                    '<a class="c-primary" onClick="courseware_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {
                    icon: 5,
                    time: 1000
                });
            });
    }

    /*文件-下架*/
    function courseware_stop(obj, id) {
        layer.confirm('确认要下架吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend(
                '<a style="text-decoration:none" onClick="courseware_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>'
            );
            $.ajax({
                url: '/ExerciseServlet.do?type=updateCheck&id='+id,
                method: 'POST',
                success: function (res) {
                    console.log(res)
                    if(res.data){
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已下架</span>');
                        $(obj).remove();
                        layer.msg('已下架!', {
                            icon: 5,
                            time: 1000
                        });
                    }
                    else{

                    }
                }
            })
        });
    }

    /*文件-发布*/
    function courseware_start(obj, id) {
        layer.confirm('确认要发布吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend(
                '<a style="text-decoration:none" onClick="courseware_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>'
            );
            $.ajax({
                url: '/ExerciseServlet.do?type=updateCheck&id='+id,
                method: 'POST',
                success: function (res) {
                    console.log(res)
                    if(res.data){
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                        $(obj).remove();
                        layer.msg('已发布!', {
                            icon: 5,
                            time: 1000
                        });
                    }
                    else{

                    }
                }
            })
        });
    }

    /*文件-申请上线*/
    function courseware_shenqing(obj, id) {
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {
            icon: 1,
            time: 2000
        });
    }

    /*文件-编辑*/
    function courseware_edit(title, url, id) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*文件-删除*/
    function courseware_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                url: '/ExerciseServlet.do?type=delete&id='+id,
                method: 'POST',
                success: function(res){
                    if(res.data){
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!', {
                            icon: 1,
                            time: 1000
                        });
                    }
                    else{

                    }
                }
            })

        });
    }
</script>
</body>

</html>
