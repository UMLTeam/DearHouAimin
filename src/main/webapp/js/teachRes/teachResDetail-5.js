function Preview() {
	var file_list = document.getElementsByClassName("ny-right-content").item(0);
	var file_preview = document.getElementsByClassName("ny-right-file").item(0);
	var file_embed = document.getElementsByTagName("embed").item(0);
	if (file_list.style.display == "none") {
		file_preview.style.display = "none";
		file_list.style.display = "block";
		file_preview.innerHTML = "";
	} else {
		file_list.style.display = "none";
		file_preview.style.display = "block";
		file_preview.innerHTML = "<div class=\"file-top\"><a onclick=\"Preview()\"><img alt=\"\" src=\"../images/teachResource/fanhui.png\">返回</a></div><br>\
											<div class=\"file-show\">\
												<div class=\"file-show-title\">\
													<h1>面向对象分析与设计(UML)--期中考试试卷A-答案</h3><br>\
													发布人：侯爱民&nbsp;&nbsp;&nbsp;上传日期：2018-07-24\
												</div><br>\
											    <div>\
											    	<embed src=\"../resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf\" width=\"800\" height=\"800\">\
											    </div>   \
											</div>";
	}

}