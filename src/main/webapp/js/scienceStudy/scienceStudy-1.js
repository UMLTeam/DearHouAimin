function onload_ui() {
	document.getElementById("top").innerHTML = "<div class=\"header\">\
		<div class=\"topLine\"></div>\
		<section class=\"topwrap\">\
			<a href=\"index.html\" class=\"logo\"><img src=\"../images/logo.png\"></a>\
			<section class=\"search\">\
				<div class=\"ext\">\
					<a href=\"#\">English version</a>\
					<form id=\"searchForm\" target=\"_blank\">\
						<input type=\"text\" name=\"query\">\
					</form>\
				</div>\
			</section>\
		</section>\
		<section class=\"nav yahei\">\
			<ul id=\"nav\">\
				<li class=\"title\"><a href=\"index.html\">首页</a></li>\
				<li class=\"title\"><a href=\"http://news.tsinghua.edu.cn/publish/thunews/index.html\">清华新闻</a></li>\
				<li class=\"title\" onmouseover=\"extend('1')\" onmouseout=\"out('1')\">\
					<a href=\"index.html\">学校概况</a>\
					<ul style=\"display: none;\" id=\"first\">\
						<li class=\"detail\"><a href=\"indexDetail-1.html\" style=\"color: #fff;\">校长致辞</a></li>\
						<li class=\"detail\"><a href=\"indexDetail-2.html\" style=\"color: #fff;\">学校沿革</a></li>\
						<li class=\"detail\"><a href=\"indexDetail-3.html\" style=\"color: #fff;\">历任领导</a></li>\
						<li class=\"detail\"><a href=\"indexDetail-4.html\" style=\"color: #fff;\">现任领导</a></li>\
						<li class=\"detail\"><a href=\"indexDetail-5.html\" style=\"color: #fff;\">组织机构</a></li>\
						<li class=\"detail\"><a href=\"indexDetail-6.html\" style=\"color: #fff;\">统计资料</a></li>\
					</ul>\
				</li>\
				<li class=\"title\"><a href=\"yuanxi.html\">院系设置</a></li>\
				<li class=\"title\"><a href=\"teacherTeam.html\">师资队伍</a></li>\
				<li class=\"title\" onmouseover=\"extend('2')\" onmouseout=\"out('2')\">\
					<a href=\"education.html\">教育教学</a>\
				</li>\
				<li class=\"title\" onmouseover=\"extend('3')\" onmouseout=\"out('3')\">\
					<a href=\"scienceStudy.html\">科学研究</a>\
				</li>\
				<li class=\"title\" onmouseover=\"extend('4')\" onmouseout=\"out('4')\">\
					<a href=\"admission.html\">招生就业</a>\
					<ul style=\"display: none; \" id=\"fourth\">\
						<li class=\"detail\"><a href=\"admissionDetail-1.html\" style=\"color: #fff;\">本科生招生</a></li>\
						<li class=\"detail\"><a href=\"admissionDetail-2.html\" style=\"color: #fff;\">研究生招生</a></li>\
						<li class=\"detail\"><a href=\"admissionDetail-3.html\" style=\"color: #fff;\">国际学生招生</a></li>\
						<li class=\"detail\"><a href=\"admissionDetail-4.html\" style=\"color: #fff;\">学生职业发展</a></li>\
					</ul>\
				</li>\
				<li class=\"title\" onmouseover=\"extend('5')\" onmouseout=\"out('5')\">\
					<a href=\"employment.html\">人才招聘</a>\
					<ul style=\"display: none;\" id=\"fifth\">\
						<li class=\"detail\"><a href=\"employment.html\" style=\"color: #fff;\">招聘计划</a></li>\
						<li class=\"detail\"><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/employ/employ-2.html\" style=\"color: #fff;\">招聘信息</a></li>\
						<li class=\"detail\"><a href=\"http://zhaopin.rsc.tsinghua.edu.cn/zpgl/user/goToLogin.dox\" style=\"color: #fff;\">我要招聘</a></li>\
					</ul>\
				</li>\
				<li class=\"title\"><a href=\"http://lib.tsinghua.edu.cn/dra/\">图书馆</a></li>\
				<li class=\"title\" onmouseover=\"extend('6')\" onmouseout=\"out('6')\">\
					<a href=\"go.html\">走进清华</a>\
					<ul style=\"display: none;\" id=\"sixth\">\
						<li class=\"detail\"><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-1.html\" style=\"color: #fff;\">校园生活</a></li>\
						<li class=\"detail\"><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-2.html\" style=\"color: #fff;\">校园风光</a></li>\
						<li class=\"detail\"><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-2.html\" style=\"color: #fff;\">实用信息</a></li>\
					</ul>\
				</li>\
			</ul>\
		</section>\
	</div>";

	document.getElementById("bottom").innerHTML = "<div class=\"inner\">\
		<ul>\
			<li><a href=\"index.html\">学校概况</a>\
				<div class=\"detail\">\
					<div><a href=\"indexDetail-1.html\">校长致辞</a></div>\
					<div><a href=\"indexDetail-2.html\">学校沿革</a></div>\
					<div><a href=\"indexDetail-3.html\">历任领导</a></div>\
					<div><a href=\"indexDetail-4.html\">现任领导</a></div>\
					<div><a href=\"indexDetail-5.html\">组织机构</a></div>\
					<div><a href=\"indexDetail-6.html\">统计资料</a></div>\
				</div>\
			</li>\
			<li><a href=\"yuanxi.html\">院系设置</a>\
				<div class=\"detail\">\
				</div>\
			</li>\
			<li><a href=\"teacherTeam.html\">师资队伍</a>\
				<div class=\"detail\">\
					<div><a href=\"teacherTeam.html\">概况</a></div>\
					<div><a href=\"teacherTeam.html\">杰出人才</a></div>\
				</div>\
			</li>\
			<li><a href=\"education\">教育教学</a></li>\
			<li><a href=\"scienceStudy.html\">科学研究</a></li>\
			<li><a href=\"admission.html\">招生就业</a>\
				<div class=\"detail\">\
					<div><a href=\"admissionDetail-1.html\">本科生招生</a></div>\
					<div><a href=\"admissionDetail-2.html\">研究生招生</a></div>\
					<div><a href=\"admissionDetail-3.html\">国际学生招生</a></div>\
					<div><a href=\"admissionDetail-4.html\">学生职业发展</a></div>\
				</div>\
			</li>\
			<li><a href=\"employment.html\">人才招聘</a>\
				<div class=\"detail\">\
					<div><a href=\"employment.html\">招聘计划</a></div>\
					<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/employ/employ-2.html\">招聘计划</a></div>\
					<div><a href=\"http://zhaopin.rsc.tsinghua.edu.cn/zpgl/user/goToLogin.dox\">我要应聘</a></div>\
				</div>\
			</li>\
			<li><a href=\"go.html\">走进清华</a>\
				<div class=\"detail\">\
					<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-1.html\">校园生活</a></div>\
					<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-2.html\">校园生活</a></div>\
					<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-3.html\">实用信息</a></div>\
				</div>\
			</li>\
		</ul>\
	</div>";
}