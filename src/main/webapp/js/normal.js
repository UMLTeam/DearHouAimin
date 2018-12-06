function extend(num){
	
	if(num==1)
	{
		var obj = document.getElementById('first');
		obj.style.display = "block";
	}
	else if(num==2)
	{
		var obj = document.getElementById('second');
		obj.style.display = "block";
	}
	else if(num==3)
	{
		var obj = document.getElementById('third');
		obj.style.display = "block";
	}
	else if(num==4)
	{
		var obj = document.getElementById('fourth');
		obj.style.display = "block";
	}
	else if(num==5)
	{
		var obj = document.getElementById('fifth');
		obj.style.display = "block";
	}
	else if(num==6){
		var obj = document.getElementById('sixth');
		obj.style.display = "block";
	}
	else if(num==7){
		var obj = document.getElementById('seven');
		obj.style.display = "block";
	}
	else{
		var obj = document.getElementById('eight');
		obj.style.display = "block";
	}

}

function out(num){
	if(num==1)
	{
		var obj = document.getElementById('first');
		obj.style.display = "none";
	}
	else if(num==2)
	{
		var obj = document.getElementById('second');
		obj.style.display = "none";
	}
	else if(num==3)
	{
		var obj = document.getElementById('third');
		obj.style.display = "none";
	}
	else if(num==4)
	{
		var obj = document.getElementById('fourth');
		obj.style.display = "none";
	}
	else if(num==5)
	{
		var obj = document.getElementById('fifth');
		obj.style.display = "none";
	}
	else if(num==6)
	{
		var obj = document.getElementById('sixth');
		obj.style.display = "none";
	}
	else if(num==7){
		var obj = document.getElementById('seven');
		obj.style.display = "none";
	}
	else{
		var obj = document.getElementById('eight');
		obj.style.display = "none";
	}
}

function Rendering(){
	document.getElementById("top").innerHTML="<div class=\"header\"><div class=\"topLine\"></div>\
			<section class=\"topwrap\">\
				<a href=\"index.html\" class=\"logo\"><img src=\"../images/logo.png\"><h2 class=\"title\">在线开放课程平台</h2></a>\
			</section>\
			<section class=\"logininAndUp\">\
				<a href=\"index.html\">登录</a>\
				<a href=\"index.html\">注册</a>\
			</section>\
			<section class=\"nav yahei\">\
				<ul id=\"nav\">\
					<li class=\"title\"><a href=\"index.html\">首页</a></li>\
					<li class=\"title\" onmouseover=\"extend('1')\" onmouseout=\"out('1')\">\
						<a href=\"courseDetail-1.html\">课程概况</a>\
						<ul style=\"display: none;\" id=\"first\">\
							<li class=\"detail\"><a href=\"courseDetail-1.html\" style=\"color: #fff;\">课程简介</a></li>\
							<li class=\"detail\"><a href=\"courseDetail-2.html\" style=\"color: #fff;\">课程特色</a></li>\
							<li class=\"detail\"><a href=\"courseDetail-3.html\" style=\"color: #fff;\">教材与参考资料</a></li>\
							<li class=\"detail\"><a href=\"courseDetail-4.html\" style=\"color: #fff;\">历史沿革</a></li>\
						</ul>\
					</li>\
					<li class=\"title\" onmouseover=\"extend('2')\" onmouseout=\"out('2')\">\
						<a href=\"teacherDetail-1.html\">教师队伍</a>\
						<ul style=\"display: none;\" id=\"second\">\
							<li class=\"detail\"><a href=\"teacherTeamDetail-1.html\" style=\"color: #fff;\">课程负责人</a></li>\
							<li class=\"detail\"><a href=\"teacherTeamDetail-2.html\" style=\"color: #fff;\">课程教学团队</a></li>\
							<li class=\"detail\"><a href=\"teacherTeamDetail-3.html\" style=\"color: #fff;\">主讲教师</a></li>\
							<li class=\"detail\"><a href=\"teacherTeamDetail-4.html\" style=\"color: #fff;\">青年教师培养</a></li>\
						</ul>\
					</li>\
					<li class=\"title\"><a href=\"yuanxi.html\">教学安排</a></li>\
					<li class=\"title\"><a href=\"teacherTeam.html\">教学研究改革</a></li>\
					<li class=\"title\" onmouseover=\"extend('5')\" onmouseout=\"out('5')\">\
						<a href=\"education.html\">教学资源</a>\
					</li>\
					<li class=\"title\" onmouseover=\"extend('6')\" onmouseout=\"out('6')\">\
						<a href=\"scienceStudy.html\">教学管理</a>\
					</li>\
					<li class=\"title\" onmouseover=\"extend('7')\" onmouseout=\"out('7')\">\
						<a href=\"admission.html\">教学效果</a>\
						<ul style=\"display: none; \" id=\"seven\">\
							<li class=\"detail\"><a href=\"admissionDetail-1.html\" style=\"color: #fff;\">本科生招生</a></li>\
							<li class=\"detail\"><a href=\"admissionDetail-2.html\" style=\"color: #fff;\">研究生招生</a></li>\
							<li class=\"detail\"><a href=\"admissionDetail-3.html\" style=\"color: #fff;\">国际学生招生</a></li>\
							<li class=\"detail\"><a href=\"admissionDetail-4.html\" style=\"color: #fff;\">学生职业发展</a></li>\
						</ul>\
					</li>\
					<li class=\"title\" onmouseover=\"extend('8')\" onmouseout=\"out('8')\">\
						<a href=\"employment.html\">教学互动</a>\
						<ul style=\"display: none;\" id=\"eight\">\
							<li class=\"detail\"><a href=\"employment.html\" style=\"color: #fff;\">招聘计划</a></li>\
							<li class=\"detail\"><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/employ/employ-2.html\" style=\"color: #fff;\">招聘信息</a></li>\
							<li class=\"detail\"><a href=\"http://zhaopin.rsc.tsinghua.edu.cn/zpgl/user/goToLogin.dox\" style=\"color: #fff;\">我要招聘</a></li>\
						</ul>\
					</li>\
				</ul>\
			</section>\
		</div>";

	document.getElementById("bottom").innerHTML="<div class=\"inner\">\
			<ul>\
				<li><a href=\"courseDetail-1.html\">课程概况</a>\
					<div class=\"detail\">\
						<div><a href=\"courseDetail-1.html\">课程简介</a></div>\
						<div><a href=\"courseDetail-2.html\">课程特色</a></div>\
						<div><a href=\"courseDetail-3.html\">教材与参考资料</a></div>\
						<div><a href=\"courseDetail-4.html\">历史沿革</a></div>\
					</div>\
				</li>\
				<li><a href=\"teacherTeam.html\">教师队伍</a>\
					<div class=\"detail\">\
						<div><a href=\"teacherTeamDetail-1.html\">课程负责人</a></div>\
						<div><a href=\"teacherTeamDetail-2.html\">课程教学团队</a></div>\
						<div><a href=\"teacherTeamDetail-3.html\">主讲教师</a></div>\
						<div><a href=\"teacherTeamDetail-4.html\">青年教师培养</a></div>\
					</div>\
				</li>\
				<li><a href=\"teacherTeam.html\">教学安排</a>\
					<div class=\"detail\">\
						<div><a href=\"teacherTeam.html\">概况</a></div>\
						<div><a href=\"teacherTeam.html\">杰出人才</a></div>\
					</div>\
				</li>\
				<li><a href=\"education.html\">教学研究改革</a></li>\
				<li><a href=\"scienceStudy.html\">教学资源</a></li>\
				<li><a href=\"admission.html\">教学管理</a>\
					<div class=\"detail\">\
						<div><a href=\"admissionDetail-1.html\">本科生招生</a></div>\
						<div><a href=\"admissionDetail-2.html\">研究生招生</a></div>\
						<div><a href=\"admissionDetail-3.html\">国际学生招生</a></div>\
						<div><a href=\"admissionDetail-4.html\">学生职业发展</a></div>\
					</div>\
				</li>\
				<li><a href=\"employment.html\">教学效果</a>\
					<div class=\"detail\">\
						<div><a href=\"employment.html\">招聘计划</a></div>\
						<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/employ/employ-2.html\">招聘计划</a></div>\
						<div><a href=\"http://zhaopin.rsc.tsinghua.edu.cn/zpgl/user/goToLogin.dox\">我要应聘</a></div>\
					</div>\
				</li>\
				<li><a href=\"go.html\">教学互动</a>\
					<div class=\"detail\">\
						<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-1.html\">校园生活</a></div>\
						<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-2.html\">校园生活</a></div>\
						<div><a href=\"http://www.tsinghua.edu.cn/publish/newthu/newthu_cnt/intothu/intothu-3.html\">实用信息</a></div>\
					</div>\
				</li>\
			</ul>\
		</div>";

	document.getElementById("copyrights").innerHTML="<div class=\"mainWrap\">\
    		<div class=\"link\">\
    			<ul>\
	        		<li>友情链接</li>\
	        		<li><a href=\"http://www.dgut.edu.cn\">东莞理工学院</a></li>\
	            	<li><a href=\"http://jwc.dgut.edu.cn\">东莞理工学院教务处</a></li>\
	            	<li><a href=\"http://sw.dgut.edu.cn\">东莞理工学院计算机与网络安全学院</a></li>\
            	</ul>\
    		</div>\
    		<div class=\"final\">\
    			<ul>\
            		<li class=\"left\">© 2018,UML Group 2</li>\
            		<li class=\"right\">联系我们</li>\
            	</ul>\
    		</div>\
        </div>";
}
