<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
	<link rel="icon" href="/images/dgut.jpg">
	<link rel="stylesheet" type="text/css" href="/style/normal.css">
	<link rel="stylesheet" type="text/css" href="/style/index/index.css">
    <link rel="stylesheet" type="text/css" href="/style/login/login.css">
	<script type="text/javascript" src="/js/normal.js"></script>

</head>
<body>


<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>
 
	<div class="outlineDiv">
		<form>
			<div class="titleDiv">用户登录</div>
		  <div class="partDiv">
				<div class="partLeft"><img src="../images/login/man.png" width="40px" height="40px" alt=""/></div>
				<div class="partRight">
				  <input class="input" type="text" name="accountNumber" id="accountNumber"  placeholder="账号">
				  <br><span id="accountSpan"></span>
				</div>
			</div>
			<div class="partDiv">
				<div class="partLeft"><img src="../images/login/lock.png" width="40px" height="40px" alt=""/></div>
				<div class="partRight">
					<input class="input" type="password" name="password" id="password" placeholder="密码">
					<span id="passwordSpan"></span>
				</div>
		  </div>
		</form>
		<div ><input class="login" type="submit" value="立即登录"/></div>
		<div class="bottom">
			<div class="bottomLeft"><a href="/html/findPassword.jsp" target="_self">忘记密码</a></div>
			<div class="bottomRight"><a href="/html/register.jsp" target="_self">立即注册</a></div>
		</div>
	</div>
	
<div id="bottom">
    <jsp:include page="/html/bottom.jsp"/>
</div>

<div id="copyrights">
    <jsp:include page="/html/copyright.jsp"/>
</div>

</body>
</html>