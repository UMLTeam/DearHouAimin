<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="/static/h-ui.admin/css/style.css" />
</head>
<body>
<div class="page-container">


<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a class="btn btn-primary radius" href="javascript:;">教师添加</a></span>
		</div>
		<br>
	
	<form action="/TeacherTeamManager?type=teacherTeam-add" id="form" method="post">
	<p style="font-size:19px;">姓名：<input id="name" name="name" style="font-size:19px;"></input></p>
	<p style="font-size:19px;">简介信息：</p>	<script id="container" name="content" type="text/plain">
    </script>
			<p style="	font-size:19px;margin-top:10px;"><input type="submit" name="submit" value="确认添加"  class="btn btn-primary radius"></p>
	</form>
	
	</div>




		<!-- 加载编辑器的容器 -->

	<!-- 配置文件 -->
	<script type="text/javascript"
		src="/plugin/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript"
		src="/plugin/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('container', {
			toolbars : [ [ 'fullscreen', 'source', 'undo', 'redo', 'bold' ] ],
			autoHeightEnabled : true,
			autoFloatEnabled : true
		});
	</script>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>
</body>
</html>