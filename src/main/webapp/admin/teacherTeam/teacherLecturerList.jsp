<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<span class="l"><a class="btn btn-primary radius" href="javascript:;">主讲教师列表</a></span>
				 <span
				class="r">共有数据：<strong>${fn:length(LecturerList)}</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
				<thead>
					<tr class="text-c">
						<th width="40">ID</th>
						<th width="40">姓名</th>
						<th>简介</th>
						<th width="120">操作</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${LecturerList }" var="teacher">
					<tr class="text-c">
						<td>${teacher.id}</td>
						<td>${teacher.teacher_name}</td>
						<td class="text-l">${teacher.teacher_message}</td>
						<td class="f-14 td-manage">
							<a style="text-decoration: none" class="ml-5" href="/TeacherTeamManager?type=lecturer-del&name=${teacher.teacher_name}"
							title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		<p>添加主讲教师：</p>
			<span class="l">
			<form action="/TeacherTeamManager?type=lecturer-add" method="post">
				<select id="name" name="name" class="btn btn-primary radius">
				<c:forEach items="${NotLecturerList}" var="teacher">
					<option value="${teacher.teacher_name}">${teacher.teacher_name}</option>
				</c:forEach>
				</select>
				<input type="submit" value="确认添加" class="btn btn-primary radius">
			</form>
			
<!-- 			<a class="btn btn-primary radius" data-title="添加教师" -->
<!-- 				data-href="article-add.html" href="/teacherTeamAdd.jsp"><i class="Hui-iconfont">&#xe600;</i> 添加教师</a> -->
				</span>
		</div>
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