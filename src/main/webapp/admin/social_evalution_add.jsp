<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>

<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>

<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/simditor-2.3.5/styles/simditor.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/simditor-2.3.5/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/simditor-2.3.5/scripts/module.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/simditor-2.3.5/scripts/hotkeys.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/simditor-2.3.5/scripts/uploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/simditor-2.3.5/scripts/simditor.min.js"></script>


<script>
	$(document).ready(function(){
		//初始化文本编辑器
		var editor = new Simditor({
			//textarea的id
			textarea: $('#content'),
			//工具条都包含哪些内容
			toolbar:['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', 'ol', 'ul', 'code', 'table',  'link', 'image', 'hr', 'indent', 'outdent', 'alignment'],
			//若需要上传功能，上传的参数设置。
			upload : {
				url : 'things_web/ArticleController/publish_Article.action', //文件上传的接口地址
				params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
				fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名
				connectionCount: 3,
				leaveConfirm: '正在上传文件'
			}
		});
	});
</script>

<title>新增社会评价评价</title>

</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="<c:url value='/social_evalution_servlet'/>" method="post">

		<input type="hidden" name="method" value="addEvalution">



		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>评价标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="articletitle" name="evalutionTitle">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">评价内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<script id="Editor" type="text/plain" style="width:600px;height:300px" ></script>
				<textarea name="content" id="content" class="required span6" rows="6" title="* Please enter your message"></textarea>
			</div>
		</div>


		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>

	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>


<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	//表单验证
	$("#form-article-add").validate({
		rules:{
			articletitle:{
				required:true,
			},
			articletitle2:{
				required:true,
			},
			articlecolumn:{
				required:true,
			},
			articletype:{
				required:true,
			},
			articlesort:{
				required:true,
			},
			keywords:{
				required:true,
			},
			abstract:{
				required:true,
			},
			author:{
				required:true,
			},
			sources:{
				required:true,
			},
			allowcomments:{
				required:true,
			},
			commentdatemin:{
				required:true,
			},
			commentdatemax:{
				required:true,
			},

		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

	var uploader = WebUploader.create({
		auto: true,
		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });


	
});

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>