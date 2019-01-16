<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8">

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
			<span class="l"><a class="btn btn-primary radius" href="javascript:;">青年教师培养方案</a></span>
		</div>
		
		<div class="mt-20">
		
			<table
				class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
				<thead>
					<tr class="text-c">
						<th style="font-size:19px;">青年教师培养方案<spa	n style="float:right;"><a style="text-decoration:none;" class="ml-5" href="/teacherTeam?type=trainingPlan-edits&id=${courseManager.id }" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a></span></th>
					</tr>
				</thead>
				<tbody>
				<tr><td>${trainingPlan.message}</td></tr>
				</tbody>
			</table>
		</div>

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