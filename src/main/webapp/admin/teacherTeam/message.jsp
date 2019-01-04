<%@ page language="java" import="java.util.*,domian.Message" pageEncoding="UTF-8"%>
<%	
	Message message=(Message) request.getAttribute("message");
	response.setHeader("refresh", message.getRedirectTime()+";URL="+message.getRedirectUrl());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!doctype html>
<html>
 <head>
 	<meta charset="utf-8"></head>  
  <body>
	<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
		<tbody>
			<tr>
				<td>${requestScope.message.message}  </td>
			</tr>
			<tr><td>
				<c:if test="${requestScope.message.redirectTime < 10}">
					${requestScope.message.redirectTime}秒后将跳转页面。<br>
					如果没有跳转,请按 <a href="${requestScope.message.redirectUrl} ">这里</a>!!!
				</c:if>				
				<c:if test="${requestScope.message.redirectTime >= 10}">
					<a href="javascript:void(0);" onclick="history.go(-1);">返回上一步</a>
				</c:if>	
			</td></tr>
		</tbody>
	</table>    
  </body>
</html>
