<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <![endif]-->
    <title>教学改革措施</title>
    <style type="text/css">
        a {
            text-decoration: none;
        }
    </style>
</head>

<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 教学研究改革 <span
        class="c-gray en">&gt;</span>改革措施
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="text-c">
        <span class="select-box inline">
		<select onclick="mbar(this)" name="select" class="select" value="">
            <option value="">分类</option>
            <option value="/educationReformDetail1Action?type=comeInto">全部分类</option>
			<option value="/educationReformDetail1Action?type=erd1-type&erd1_type=教学方式">教学方式</option>
            <option value="/educationReformDetail1Action?type=erd1-type&erd1_type=教学手段">教学手段</option>
            <option value="/educationReformDetail1Action?type=erd1-type&erd1_type=教学体系">教学体系</option>
            <option value="/educationReformDetail1Action?type=erd1-type&erd1_type=考核方式">考核方式</option>
		</select>
		</span>
        <span class="select-box inline">
        <form action="/educationReformDetail1Action?type=findName" method="post">
            <input type="text" name="MeasuresName" placeholder=" 措施名称" style="width:250px" class="input-text">
            <button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </form>
        </span>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a class="btn btn-primary radius" data-title="添加措施方案"
                   data-href="/admin/admin_educationReformDetail1/add_education_reform_measures.jsp"
                   onclick="Hui_admin_tab(this)" href="javascript:;"><i
                        class="Hui-iconfont">&#xe600;</i> 添加措施方案</a></span> <span
            class="r">共有数据：<strong><%=session.getAttribute("count")%></strong> 条</span></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="80">ID</th>
                <th>标题</th>
                <th width="80">分类</th>
                <th width="80">来源</th>
                <th width="120">更新时间</th>
                <th width="60">发布状态</th>
                <th width="150">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${erd1List }" var="dguterd1">
                <tr class="text-c">
                    <td>${dguterd1.dguterd1_id}</td>
                    <td class="text-c">
                        <a style="cursor:pointer" class="text-primary" title="查看"
                           href="/educationReformDetail1Action?type=see&seeid=${dguterd1.dguterd1_id}">${dguterd1.dguterd1_title}</a>
                    </td>
                    <td>${dguterd1.dguterd1_type}</td>
                    <td>${dguterd1.dguterd1_origin}</td>
                    <td>${dguterd1.dguterd1_date}</td>
                    <c:choose>
                        <c:when test="${dguterd1.dguterd1_state==0}">
                            <td class="td-status"><span class="label label-success radius">未发布</span></td>
                        </c:when>
                        <c:when test="${dguterd1.dguterd1_state==1}">
                            <td class="td-status"><span class="label label-success radius">已发布</span></td>
                        </c:when>
                    </c:choose>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none"
                           onClick="article_change(this,${dguterd1.dguterd1_id },${dguterd1.dguterd1_state })"
                           href="javascript:;" title="状态"><i class="Hui-iconfont">&#xe6de;</i></a>
                            <%--<a style="text-decoration:none" class="ml-5" onClick="article_edit('教学措施编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>--%>
                        <a style="text-decoration:none" class="ml-5"
                           href="/educationReformDetail1Action?type=getOneObject&id=${dguterd1.dguterd1_id}"
                           title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5"
                           onClick="article_del(this,${dguterd1.dguterd1_id })" href="javascript:;" title="删除"><i
                                class="Hui-iconfont">&#xe6e2;</i></a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/admin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    function mbar(sobj) {
        var docurl = sobj.options[sobj.selectedIndex].value;
        if (docurl != "") {
            open(docurl, '_self');
            sobj.selectedIndex = 0;
            sobj.blur();
        }
    }

    $('.table-sort').dataTable({
        "aaSorting": [
            [1, "desc"]
        ], //默认第几个排序
        "bStateSave": true, //状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {
                "orderable": false,
                "aTargets": [0, 6]
            } // 不参与排序的列
        ]
    });

    /*资讯-添加*/
    function article_add(title, url, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*资讯-编辑*/
    function article_edit(title, url, id, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*资讯-删除*/
    function article_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '/educationReformDetail1Action?type=delete',
                dataType: 'json',
                data: {
                    "operator1": id,
                },
                success: function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {
                        icon: 1,
                        time: 1000
                    });
                },
                error: function (data) {
                    layer.msg('删除失败!', {
                        icon: 1,
                        time: 1000
                    });
                },
            });
        });
    }

    /*资讯-审核*/
    function article_shenhe(obj, id) {
        layer.confirm('审核文章？', {
                btn: ['通过', '不通过', '取消'],
                shade: false,
                closeBtn: 0
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {
                    icon: 6,
                    time: 1000
                });
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {
                    icon: 5,
                    time: 1000
                });
            });
    }

    /*资讯-下架*/
    function article_change(obj, id, state) {
        if (state == 1) {
            layer.confirm('确认要下架吗？', function (index) {
                $(obj).parents("tr").find(".td-manage").prepend("<a style='text-decoration:none;' onClick='article_change(this," + id + ",0)' href='javascript:;'title='发布'><i class='Hui-iconfont'>&#xe6de;</i></a>");
                $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
                $(obj).remove();
                $.ajax({
                    type: 'POST',
                    url: '/educationReformDetail1Action?type=state',
                    dataType: 'json',
                    data: {
                        "operator1": id,
                        "operator2": 0,
                    },
                    success: function (data) {
                        if (data == "1") {
                            layer.msg('已下架!', {
                                icon: 6,
                                time: 1000
                            });
                        } else {
                            layer.msg('下架失败!', {
                                icon: 1,
                                time: 1000
                            });
                        }
                    },
                    error: function (data) {
                        layer.msg('下架失败!', {
                            icon: 1,
                            time: 1000
                        });
                    },
                });
            });
        } else {
            layer.confirm('确认要发布吗？', function (index) {
                $(obj).parents("tr").find(".td-manage").prepend("<a style='text-decoration:none;' onClick='article_change(this," + id + ",1)' href='javascript:;'title='下架'><i class='Hui-iconfont'>&#xe6de;</i></a>");
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                $.ajax({
                    type: 'POST',
                    url: '/educationReformDetail1Action?type=state',
                    dataType: 'json',
                    data: {
                        "operator1": id,
                        "operator2": 1,
                    },
                    success: function (data) {
                        console.log(data);
                        if (data == "1") {
                            layer.msg('已发布!', {
                                icon: 6,
                                time: 1000
                            });
                        } else {
                            layer.msg('发布失败!', {
                                icon: 1,
                                time: 1000
                            });
                        }
                    },
                    error: function (data) {
                        layer.msg('发布失败!', {
                            icon: 1,
                            time: 1000
                        });
                    },
                });

            });
        }

    }


    function article_start(obj, id) {

    }

    /*资讯-申请上线*/
    function article_shenqing(obj, id) {
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {
            icon: 1,
            time: 2000
        });
    }
</script>
</body>

</html>