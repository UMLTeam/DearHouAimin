<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="/lib/html5shiv.js"></script>
<script type="text/javascript" src="/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>课程概况</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 课程概况 <span class="c-gray en">&gt;</span> 教材与参考资料 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">
	        <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button></span>&nbsp;
	        <a class="btn btn-primary radius" data-title="添加教材" data-href="../admin/courseDetail/addcourseDetail-3.jsp" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加教材信息</a>
	    <span class="r">共有数据：<strong>${fn:length(books) }</strong> 条</span> 
	 </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="70">学年</th>
					<th width="90">学院</th>
					<th width="70">班级</th>
					<th width="120">书籍</th>
					<th width="50">作者</th>
					<th width="60">出版社</th>
					<th width="60">出版信息</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			  <c:forEach var="x" items="${books }">
			    <tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<td>${x.id }</td>
					<td >${x.academicYear }</td>
					<td>${x.academy }</td>
					<td>${x.classmate }</td>
					<td>${x.book }</td>
					<td>${x.author }</td>
					<td>${x.press }</td>
					<td>${x.pressInformation }</td>
					<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="article_edit('内容修改','/admin/courseDetail/editcourseDetail-3.jsp','${x.id}')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'${x.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			  </c:forEach>
			</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
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
    $.ajax({
			type: 'GET',
			url: '/textServlet?method=beforeUpdate&id='+id,
			dataType: 'json',
			success: function(data){
			     if (data.result == 1) {//请求成功
                    var index = layer.open({
		            type: 2,
		            title: title,
		            content: url
	               });
	             layer.full(index);
                } else {
                  layer.msg('404!',{icon:1,time:1000});  
                }
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
}
/*资讯-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'GET',
			url: '/textServlet?method=del&id='+id,
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