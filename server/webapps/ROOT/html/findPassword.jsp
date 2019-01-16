<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/style/findPassword/findPassword.css" rel="stylesheet" type="text/css">
	<link rel="icon" href="/images/dgut.jpg">
	<link rel="stylesheet" type="text/css" href="/style/normal.css">
	<link rel="stylesheet" type="text/css" href="/style/index/index.css">
	<script type="text/javascript" src="/js/normal.js"></script>
</head>
<body>

<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>


<div class="outlineDiv">
		<form>
		  <div class="titleDiv">找回密码</div>

		  <div class="partDiv">
				<div class="partLeft">电子邮箱:</div>
				<div class="partRight">
					<input class="input" onBlur="emailCheck()" type="email" name="email" id="email" placeholder=" 请输入注册时的邮箱">
					<span id="emailSpan"></span>
				</div>
		  </div>
		  <div ><input class="login" type="submit" value="点击找回密码"/></div>
		</form>
		
	</div>
	
	<script type="text/javascript">
		function emailCheck(){
			var pattern = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$","i");//创建模式对象
			var str1=document.getElementById("email").value;//获取文本框的内容
			
			if(str1.length>=8 && pattern.test(str1)){//pattern.test() 模式如果匹配，会返回true，不匹配返回false
				document.getElementById("emailSpan").innerHTML=("");
				//return true;
			}else{
				document.getElementById("emailSpan").innerHTML=("*电子邮箱格式错误!");
				//return false;
			}
		}	
	</script>


<div id="bottom">
    <jsp:include page="/html/bottom.jsp"/>
</div>

<div id="copyrights">
    <jsp:include page="/html/copyright.jsp"/>
</div>


</body>
</html>