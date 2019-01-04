<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
<!--simditor-->
<link rel="stylesheet" type="text/css" href="/lib/simditor/styles/simditor.css" />
	
<title>历史沿革</title>
</head>
<body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 
	<span class="c-gray en">&gt;</span> 课程概况 
	<span class="c-gray en">&gt;</span> 历史沿革 
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i>
	</a>
</nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" id="search_h" placeholder=" 关键字" style="width:250px" class="input-text" value="">
		<button id="" class="btn btn-success" type="button" onClick="searchHistory()"><i class="Hui-iconfont">&#xe665;</i> 搜历史沿革</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a href="javascript:;" onclick="delBatch()" class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
			</a> 
			<a class="btn btn-primary radius" onclick="history_add()" href="javascript:;">
				<i class="Hui-iconfont">&#xe600;</i> 添加条目
			</a>
		</span>
		<span class="r">共有数据：<strong id="totalNum_h">1</strong> 条</span>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input type="checkbox" value="" onClick="selectPage()"></th>
					<th width="80">ID</th>
					<th width="100">详情</th>
					<th width="150">更新时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody id="item_h">
				<!-- <tr class="text-c">
					<td><input name="" type="checkbox" value=""></td>
					<td>001</td>
					<td style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">1、2006-2007 学年，软件学院，软件工程专业普通班1-2班, 《面向对象分析与设计(UML)》,张洁。 </td>
					<td>2018-12-11 13:19:42</td>
					<td class="td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="history_edit(this)" href="javascript:;" title="编辑">
							<i class="Hui-iconfont">&#xe6df;</i>
						</a>
						<a style="text-decoration:none" class="ml-5" onClick="history_del(this)" href="javascript:;" title="删除">
							<i class="Hui-iconfont">&#xe6e2;</i>
						</a>
					</td>
				</tr> -->
			</tbody>
		</table>
	</div>
	<div>
		<div class="btn btn-primary radius" style="float:right;margin:5px" id="nextPage">下一页</div>
		<div class="btn btn-primary" style="float:right;margin:5px" id="curPage">1</div>
		<div class="btn btn-primary radius" style="float:right;margin:5px" id="upPage">上一页</div>
	</div>
</div>
<input type="hidden" id="model_h" value="add"/>
<div id="simditor_box" style="width:700px;height:500px;margin-left:auto;margin-right:auto;position:fixed;left:0;right:0;top:-500px;z-index: -10000">
	<textarea id="simditor_container" name="container" type="text/plain"  style="width:700px;height:400px;" autofocus></textarea>
	<input class="btn btn-primary radius" type="button" value="提交" onClick="submitHistory()" style="font-size:large;margin-right:10px;margin-top:10px"/>
	<input class="btn btn-primary radius" type="button" value="取消" onClick="cancelEdit()" style="font-size:large;margin-right:10px;margin-top:10px"/>
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
	
<!--simditor-->
<script type="text/javascript" src="/lib/simditor/scripts/jquery.min.js"></script>
<script type="text/javascript" src="/lib/simditor/scripts/module.js"></script>
<script type="text/javascript" src="/lib/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="/lib/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="/lib/simditor/scripts/simditor.js"></script>

<script type="text/javascript">
	
//simditor
var editor
var delBatchs="";
var beforePage=1;
$(document).ready(load);
function load(){
	"use strict";
	getHistory(1);
	initSimditor();
	$("#nextPage").on("click",nextPage);
	$("#upPage").on("click",upPage);
}
	

function initSimditor(){
	"use strict";
	Simditor.locale ='zh-CN';//设置中文
	editor=new Simditor({
	textarea:$('#simditor_container'),  //textarea的id
	placeholder: '这里输入文字...',
	toolbar:['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
	pasteImage: true,//允许粘贴图片
	//defaultImage:'/res/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
	upload:{
		url:'', //文件上传的接口地址
		params:null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
		fileKey:'upload_file', //服务器端获取文件数据的参数名
		connectionCount:3,
		leaveConfirm:'正在上传文件'
	}
	});
}
	
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});
//ajax错误回调函数
function ajaxErr(data){
	"use strict";
	layer.msg('请求数据错误,status='+data,{icon:2,time:2000});
}
//显示结果,data为json格式
function showData(json){
	"use strict";
	var inner="";
	for(var key in json){//遍历json对象的每个key/value对,p为key
			inner+="<tr class=\"text-c\"><td><input name=\"\" type=\"checkbox\" value=\"\" onClick=\"selectBatch(this)\"></td><td>";
			inner+=json[key].id;
			inner+="</td><td>";
			inner+=json[key].detail;
			inner+="</td><td>";
			inner+=json[key].date;
			inner+="</td><td class=\"td-manage\"><a style=\"text-decoration:none\" class=\"ml-5\" onClick=\"history_edit(this)\" href=\"javascript:;\" title=\"编辑\"><i class=\"Hui-iconfont\">&#xe6df;</i></a><a style=\"text-decoration:none\" class=\"ml-5\" onClick=\"deleteSingle(this)\" href=\"javascript:;\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td></tr>";
	}
	$("#item_h").html(inner);
}
function refresh(){
	"use strict";
	window.location.replace(window.location.href);
}
function nextPage(){
	"use strict";
	beforePage=parseInt($("#curPage").html());
	$("#curPage").html(beforePage+1);
	getHistory(beforePage+1);
}
function upPage(){
	"use strict";
	beforePage=parseInt($("#curPage").html());
	$("#curPage").html(beforePage-1);
	getHistory(beforePage-1);
}
function getHistory(page){
	"use strict";
	var sendData="type=get&page="+page;
	jqu_ajax("history-service.jsp",sendData,true,"text","application/x-www-form-urlencoded",getHistory_SUC_CB,ajaxErr);
}

function getHistory_SUC_CB(data){
	"use strict";
	var obj = JSON.parse(data);		//json格式数据解析
	if("1"===obj.resultCode){
		$("#totalNum_h").html(obj.total);
		showData(obj.jsonData);
		return;
	}
	else if("upover"===obj.resultCode){
		layer.msg('已经是第一页了!',{icon:2,time:2500});
	}
	else if("lastover"===obj.resultCode){
		layer.msg('已经是最后一页了!',{icon:2,time:2500});
	}
	$("#curPage").html(beforePage);
}
	
//搜索
function searchHistory(){
	"use strict";
	var key=$("#search_h").val();
	if(key.length<1){
		layer.msg('请输入关键字!',{icon:2,time:2500});
		return;
	}
	var sendData="type=search&key="+key;
	jqu_ajax("history-service.jsp",sendData,true,"text","application/x-www-form-urlencoded",searchHistory_SUC_CB,ajaxErr);
}
function searchHistory_SUC_CB(data){
	"use strict";
	var obj = JSON.parse(data);		//json格式数据解析
	$("#totalNum_h").html(obj.total);
	showData(obj.jsonData);
}

//历史-添加
function history_add(){
	"use strict";
	$("#simditor_box").css("z-index","10000");
	$("#simditor_box").animate({display:'inline',top:'20px'},500,null);
	$("#model_h").val("add");
}

//历史-编辑
function history_edit(obj){
	"use strict";
	$("#simditor_box").css("z-index","10000");
	$("#simditor_box").animate({display:'inline',top:'20px'},500,null);
	var content=obj.parentNode.parentNode.children[2].innerHTML;
	var id=obj.parentNode.parentNode.children[1].innerHTML;
	editor.setValue(content);
	$("#model_h").val(id);
}

//历史-删除
//全选某一页
function selectPage(){
	"use strict";
	var page=$("#item_h").children();
	for(var i=page.length-1;i>=0;i--){
		delBatchs+=page.eq(i).children().eq(1).html();
		delBatchs+=",";
	}
}
//点击前面的选择
function selectBatch(obj){
	"use strict";
	delBatchs+=obj.parentNode.parentNode.children[1].innerHTML;
	delBatchs+=",";
}
//点击批量删除
function delBatch(){
	"use strict";
	if(delBatchs.length>0){
		delBatchs=delBatchs.substring(0,delBatchs.length-1);
		history_del(delBatchs);
		return;
	}
	layer.msg('请选择条目!',{icon:2,time:2500});
}
//删除单条记录
function deleteSingle(obj){
	"use strict";
	 var id=obj.parentNode.parentNode.children[1].innerHTML;
	 history_del(id);
}
function history_del(str){
	"use strict";
	layer.confirm('确认要删除吗？',function(index){
		var sendData="type=del&id="+str;
		jqu_ajax("history-service.jsp",sendData,true,"text","application/x-www-form-urlencoded",
				 function(data){
					var obj = JSON.parse(data);
					if("1"===obj.resultCode){
						delBatchs="";
						refresh();
						layer.msg('已删除!',{icon:1,time:2500});
					}
					else{
						layer.msg('删除失败!',{icon:2,time:2500});
					}
				},
				 ajaxErr);
	});
}
//点击提交或者修改
function submitHistory(){
	"use strict";
	var model=$("#model_h").val();
	var id=model;
	model="add"===model?"add":"edit";
	var editorContent=editor.getValue();
	if(editorContent.length<1){
		layer.msg('请输入文字!',{icon:2,time:2500});
	}
	var sendData="type="+model+"&id="+id+"&content="+editorContent;
	jqu_ajax("history-service.jsp",sendData,true,"text","application/x-www-form-urlencoded",submitHistory_SUC_CB,ajaxErr);
}
function submitHistory_SUC_CB(data){
	"use strict";
	var obj = JSON.parse(data);		//json格式数据解析
	if("1"===obj.resultCode){
		//添加/修改成功
		cancelEdit();
		refresh()
		layer.msg('修改、添加成功!',{icon:1,time:2500});
	}
	else{
		//添加/修改失败
		layer.msg('修改、添加失败!',{icon:2,time:2500});
	}
}
	
//收起编辑器
function cancelEdit(){
	"use strict";
	$("#simditor_box").animate({display:'inline',top:'-500px',zIndex:'-10000'},500,null);
	editor.setValue("");
}
	
//-----------------------------------------------------------------------
//参数	1.请求地址,2.发送的数据,3.是(true)否(false)异步,4.请求返回的数据类型,5.是(true)否(false)设置请求头类型，
//		 6.若6为ture则设置为请求头类型，false为null, 7.请求成功后的回调函数,8.请求失败后的回调函数
//返回值(无).
function jqu_ajax(jqu_url,jqu_data,jqu_isAsync,jqu_respType,contentType,jqu_suc_cbfunc,jqu_err_cbfunc){
	"use strict";
	var jqu_xmlhttp;
	if (window.XMLHttpRequest){
		jqu_xmlhttp=new XMLHttpRequest();					//创建XMLHttpRequest 对象, code for IE7+, Firefox, Chrome, Opera, Safari
	}
	else{			
		jqu_xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");	// code for IE6, IE5
	}
	jqu_xmlhttp.onreadystatechange=jqu_statechange;
	jqu_xmlhttp.responseType = jqu_respType;
	jqu_xmlhttp.open("POST",jqu_url,jqu_isAsync);					
	if(null!==contentType){
		jqu_xmlhttp.setRequestHeader("Content-type",contentType);
	}
	jqu_xmlhttp.send(jqu_data);

	function jqu_statechange(){										
		if (4===jqu_xmlhttp.readyState){
			if(200===jqu_xmlhttp.status){
				if(null!==jqu_suc_cbfunc){
					jqu_suc_cbfunc(jqu_xmlhttp.responseText);
				}
			}
			else{
				if(null!==jqu_err_cbfunc){
					jqu_err_cbfunc(jqu_xmlhttp.status);
				}
			}
		}
	}
}
</script>
</body>
</html>