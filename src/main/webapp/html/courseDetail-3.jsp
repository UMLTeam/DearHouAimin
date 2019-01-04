<%@page import="domian.textbook,service.Impl.*"%>
<%@ page language="java" import="java.util.*,service.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>课程概况-课程简介</title>
    <meta charset="utf-8">
    <link rel="icon" href="${pageContext.request.contextPath }/images/dgut.jpg">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/normal.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/courseDetail/normal.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/courseDetail/courseDetail.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/normal.js"></script>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
   textbookService service=new textbookService();
   List<textbook>books=service.getAll();
   request.setAttribute("books", books);
 %>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="top">
    <jsp:include page="/html/top.jsp"/>
</div>

<article class="content">

    <section id="banner">
        <img src="${pageContext.request.contextPath }/images/index/abouttop_03.jpg">
    </section>
    <section class="mainWrap relative">
        <div class="detailContent">
            <div class="column_1">
                <section class="leftNav">
                    <h3>课程概况</h3>
                    <ul>
                        <li><a href="courseDetail-1.jsp">课程简介</a></li>
                        <li><a href="courseDetail-2.jsp">课程特色</a></li>
                        <li class="current"><a href="courseDetail-3.jsp">教材与参考资料</a></li>
                        <li><a href="courseDetail-4.jsp">历史沿革</a></li>
                    </ul>
                </section>
            </div>
            <div class="column_2 ">
                <article class="mainContent">
                    <header class="contentNav">
                        <nav class="nav">
                            <a href="index.jsp">首页</a>·
                            <a href="courseDetail-1.jsp">课程概况</a>·
                            <a href="courseDetail-3.jsp">教材与参考资料</a>
                        </nav>
                        <h1>UML需求分析</h1>
                            <div class="inner">
          <table class=" tftable table table-border table-bordered table-bg table-hover table-sort table-responsive" width="750px">
			<thead>
				<tr class="text-c">
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
					<td >${x.academicYear }</td>
					<td>${x.academy }</td>
					<td>${x.classmate }</td>
					<td>${x.book }</td>
					<td>${x.author }</td>
					<td>${x.press }</td>
					<td>${x.pressInformation }</td>
					<td><a href="${pageContext.request.contextPath }/resource/${x.downloadlink }">下载</a></td>
				</tr>
			  </c:forEach>
			</table>
          </div>
                    </header>
                <!--<img src="../images/index/Tsinghua University.png">-->
                </article>
            </div>
        </div>
    </section>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[,1,2,3,4,5,6,7]}// 不参与排序的列
	]
});
</script>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="bottom"></div>
<!-- 通过js渲染，js代码在normal.js里 -->
<div id="copyrights"></div>
</body>
</html>