<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chm
  Date: 2018/12/26
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function extend(num) {

            if (num == 1) {
                var obj = document.getElementById('first');
                obj.style.display = "block";
            }
            else if (num == 2) {
                var obj = document.getElementById('second');
                obj.style.display = "block";
            }
            else if (num == 3) {
                var obj = document.getElementById('third');
                obj.style.display = "block";
            }
            else if (num == 4) {
                var obj = document.getElementById('fourth');
                obj.style.display = "block";
            }
            else if (num == 5) {
                var obj = document.getElementById('fifth');
                obj.style.display = "block";
            }
            else if (num == 6) {
                var obj = document.getElementById('sixth');
                obj.style.display = "block";
            }
            else if (num == 7) {
                var obj = document.getElementById('seven');
                obj.style.display = "block";
            }
            else {
                var obj = document.getElementById('eighth');
                obj.style.display = "block";
            }

        }

        function out(num) {
            if (num == 1) {
                var obj = document.getElementById('first');
                obj.style.display = "none";
            }
            else if (num == 2) {
                var obj = document.getElementById('second');
                obj.style.display = "none";
            }
            else if (num == 3) {
                var obj = document.getElementById('third');
                obj.style.display = "none";
            }
            else if (num == 4) {
                var obj = document.getElementById('fourth');
                obj.style.display = "none";
            }
            else if (num == 5) {
                var obj = document.getElementById('fifth');
                obj.style.display = "none";
            }
            else if (num == 6) {
                var obj = document.getElementById('sixth');
                obj.style.display = "none";
            }
            else if (num == 7) {
                var obj = document.getElementById('seven');
                obj.style.display = "none";
            }
            else {
                var obj = document.getElementById('eighth');
                obj.style.display = "none";
            }
        }
    </script>
</head>

<body>
<div class="header">
    <div class="topLine"></div>
    <section class="topwrap">
        <a href="index.jsp" class="logo"><img src="<c:url value='/images/logo.png'/>">
            <h2 class="title">在线开放课程平台</h2></a>
    </section>
    <section class="logininAndUp">
        <a href="/html/login.jsp">登录</a>
        <a href="/html/register.jsp">注册</a>
    </section>
    <section class="nav yahei">
        <ul id="nav">
            <li class="title"><a href="/html/index.jsp">首页</a></li>
            <li class="title" onmouseover="extend('1')" onmouseout="out('1')">
                <a href="/html/courseDetail-1.jsp">课程概况</a>
                <ul style="display: none;" id="first">
                    <li class="detail"><a href="/html/courseDetail-1.jsp" style="color: #fff;">课程简介</a></li>
                    <li class="detail"><a href="/html/courseDetail-2.jsp" style="color: #fff;">课程特色</a></li>
                    <li class="detail"><a href="/html/courseDetail-3.jsp" style="color: #fff;">教材与参考资料</a></li>
                    <li class="detail"><a href="/html/courseDetail-4.jsp" style="color: #fff;">历史沿革</a></li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('2')" onmouseout="out('2')">
                <a href="/teacherTeam?type=courseManager">教师队伍</a>
                <ul style="display: none;" id="second">
                    <li class="detail"><a href="/teacherTeam?type=courseManager" style="color: #fff;">课程负责人</a></li>
                    <li class="detail"><a href="/teacherTeam?type=teacherTeam" style="color: #fff;">课程教学团队</a></li>
                    <li class="detail"><a href="/teacherTeam?type=lecturer" style="color: #fff;">主讲教师</a></li>
                    <li class="detail"><a href="/teacherTeam?type=trainingPlan" style="color: #fff;">青年教师培养</a></li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('3')" onmouseout="out('3')">
                <a href="/html/educationalDetail-1.jsp">教学安排</a>
                <ul style="display: none;" id="third">
                    <li class="detail"><a href="/html/educationalDetail-1.jsp" style="color: #fff;">教学大纲</a></li>
                    <li class="detail"><a href="/servlet/CalendarServlet?method=show" style="color: #fff;">教学日历</a></li>
                    <li class="detail"><a href="/html/educationalDetail-3.jsp" style="color: #fff;">教学内容</a></li>
                    <li class="detail"><a href="/html/educationalDetail-4.jsp" style="color: #fff;">授课计划</a></li>
                    <li class="detail"><a href="/html/educationalDetail-5.jsp" style="color: #fff;">教学难重点</a></li>
                    <li class="detail"><a href="/html/educationalDetail-6.jsp" style="color: #fff;">教学方法与手段</a></li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('4')" onmouseout="out('4')">
                <a href="/html/educationReformDetail-1.html">教学研究改革</a>
                <ul style="display: none;" id="fourth">
                    <li class="detail"><a href="/html/educationReformDetail-1.html" style="color: #fff;">教学改革措施</a></li>
                    <li class="detail"><a href="/html/educationReformDetail-2.html" style="color: #fff;">教学改革立项</a></li>
                    <li class="detail"><a href="/html/educationReformDetail-3.html" style="color: #fff;">教学改革成果</a></li>
                    <li class="detail"><a href="/html/educationReformDetail-4.html" style="color: #fff;">教学改革表彰和奖励</a></li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('5')" onmouseout="out('5')">
                <a href="<c:url value='/ShowResourceServlet.do?resType=1'/> ">教学资源</a>
                <ul style="display: none;" id="fifth">
                    <li class="detail"><a href="<c:url value='/ShowResourceServlet.do?resType=1'/>" style="color: #fff;">课程课件</a></li>
                    <li class="detail"><a href="<c:url value='/ShowResourceServlet.do?resType=2'/>" style="color: #fff;">教学录像</a></li>
                    <li class="detail"><a href="<c:url value='/ShowResourceServlet.do?resType=3'/>" style="color: #fff;">习题库</a></li>
                    <li class="detail"><a href="<c:url value='/ShowResourceServlet.do?resType=4'/>" style="color: #fff;">案例库</a></li>
                    <li class="detail"><a href="<c:url value='/ShowResourceServlet.do?resType=5'/>" style="color: #fff;">实验任务</a></li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('6')" onmouseout="out('6')">
                <a href="<c:url value ='/OpenCoursePlanServlet?method=showFront'/>">教学管理</a>
                <ul style="display: none; " id="sixth">
                    <li class="detail"><a href="<c:url value ='/OpenCoursePlanServlet?method=showFront'/>"
                                          style="color: #fff;">开课计划</a></li>
                    <li class="detail"><a
                            href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>"
                            style="color: #fff;">上课班级</a></li>
                    <li class="detail"><a
                            href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>"
                            style="color: #fff;">学生成绩</a></li>
                    <li class="detail"><a href="<c:url value ='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1'/>"
                                          style="color: #fff;">班级名册</a></li>
                    <li class="detail"><a href="<c:url value ='/HomeworkServlet?method=LoadHomework&HomeworkpageQuery=1'/>" style="color: #fff;">学生作业案例</a>
                    </li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('7')" onmouseout="out('7')">
                <a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=2&n=1'/>">教学效果</a>
                <ul style="display: none; " id="seven">
                    <li class="detail"><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=2&n=1'/>" style="color: #fff;">校外专家评价</a>
                    </li>
                    <li class="detail"><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=1&n=2'/>" style="color: #fff;">校内督导评价</a>
                    </li>
                    <li class="detail"><a href="<c:url value='/teacher_evalution_servlet?method=LoadTeacherEvalator&EvalatorpageQuery=1'/>" style="color: #fff;">教师自我评价</a>
                    </li>
                    <li class="detail"><a
                            href="<c:url value='/EvalatorServlet?method=LoadStudentEvalator&EvalatorpageQuery=1'/>"
                            style="color: #fff;">校内学生评价</a></li>
                    <li class="detail"><a href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>" style="color: #fff;">社会评价</a>
                    </li>
                    <li class="detail"><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">教学评估及相关文件</a>
                    </li>
                </ul>
            </li>
            <li class="title" onmouseover="extend('8')" onmouseout="out('8')">
                <a href="../html/QQ.jsp">教学互动</a>
                <ul style="display: none;" id="eighth">
                    <li class="detail"><a href="../html/QQ.jsp" style="color: #fff;">QQ群</a></li>
                    <li class="detail"><a href="../servlet/WeChatServlet?type=normalShow" style="color: #fff;">微信群</a></li>
                    <li class="detail"><a href="../servlet/TeachingArrangementServlet?type=showLeaveMsg" style="color: #fff;">师生互动</a></li>
                </ul>
            </li>
        </ul>
    </section>
</div>
</body>
</html>
