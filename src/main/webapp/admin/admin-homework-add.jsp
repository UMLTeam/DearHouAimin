<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传作业</title>
<style type="text/css">
	
			body{ 
					 background-image:url('../images/bg.jpg');
					background-repeat:no-repeat;
					
					}
			#tool{
				width: 400px;
				height: 280px;
				position: absolute;
				left:50%;
				top:50%;
				margin-left: -200px;
				margin-top: -140px;
				border:1px;
				align:center;
				
			}
			#form{
				width: 300px;
				height: 160px;
				position: relative;
				left:50%;
				top:50%;
				margin-left: -150px;
				margin-top: -80px;
			}
</style>
	
</head>
<body>
<div id="tool">
<div id="form">
<fieldset>
<form action="<c:url value='/HomeworkServlet?method=Add_Homework'/>" method="post" enctype="multipart/form-data">
	
	<input  type="file" name="f"><br><br>
	作业主题:<input type="text" name="describ" ><br><br>
	<div id="submit" align="center">
	<input type="submit" value="上传作业" >
	</div>
</form>
</fieldset>
</div>
</div>
</body>
</html>