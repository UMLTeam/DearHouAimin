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
                var obj = document.getElementById('eighth');
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
                var obj = document.getElementById('eighth');
                obj.style.display = "none";
            }
        }
    </script>
</head>

<body>
    <div class="inner">
        <ul>
            <li><a href="/html/courseDetail-1.jsp">课程概况</a>
                <div class="detail">
                    <div><a href="/html/courseDetail-1.jsp">课程简介</a></div>
                    <div><a href="/html/courseDetail-2.jsp">课程特色</a></div>
                    <div><a href="/html/courseDetail-3.jsp">教材与参考资料</a></div>
                    <div><a href="/html/courseDetail-4.jsp">历史沿革</a></div>
                </div>
            </li>
            <li><a href="/teacherTeam?type=courseManager">教师队伍</a>
                <div class="detail">
                    <div><a href="/teacherTeam?type=courseManager">课程负责人</a></div>
                    <div><a href="/teacherTeam?type=teacherTeam">课程教学团队</a></div>
                    <div><a href="/teacherTeam?type=lecturer">主讲教师</a></div>
                    <div><a href="/teacherTeam?type=trainingPlan">青年教师培养</a></div>
                </div>
            </li>
            <li><a href="/html/educationalDetail-1.jsp">教学安排</a>
                <div class="detail">
                    <div><a href="/html/educationalDetail-1.jsp">教学大纲</a></div>
                    <div><a href="/servlet/CalendarServlet?method=show">教学日历</a></div>
                    <div><a href="/html/educationalDetail-3.jsp">教学内容</a></div>
                    <div><a href="/html/educationalDetail-4.jsp"">授课计划</a></div>
                    <div><a href="/html/educationalDetail-5.jsp">教学重难点</a></div>
                    <div><a href="/html/educationalDetail-6.jsp">教学方法与手段</a></div>
                </div>
            </li>
            <li><a href="educationReformDetail-1.html">教学研究改革</a>
                <div class="detail">
                    <div><a href="/html/educationReformDetail-1.html">改革措施</a></div>
                    <div><a href="/html/educationReformDetail-2.html">改革立项</a></div>
                    <div><a href="/html/educationReformDetail-3.html">改革成果</a></div>
                    <div><a href="/html/educationReformDetail-4.html">改革表彰和奖励</a></div>
                </div>
            </li>
            <li><a href="/ShowResourceServlet.do?resType=1">教学资源</a>
                <div class="detail">
                    <div><a href="/ShowResourceServlet.do?resType=1">课程课件</a></div>
                    <div><a href="/ShowResourceServlet.do?resType=2">教学录像</a></div>
                    <div><a href="/ShowResourceServlet.do?resType=3">习题库</a></div>
                    <div><a href="/ShowResourceServlet.do?resType=4">案例库</a></div>
                    <div><a href="/ShowResourceServlet.do?resType=5">实验任务</a></div>
                </div>
            </li>
            <li><a href="/OpenCoursePlanServlet?method=showFront">教学管理</a>
                <div class="detail">
                    <div><a href="<c:url value='/OpenCoursePlanServlet?method=showFront'/>">开课计划</a></div>
                    <div><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></div>
                    <div><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a></div>
                    <div><a href="<c:url value='/class_list_Servlet?method=LoadStudentClassList&classListpageQuery=1'/>">班级名册</a></div>
                    <div><a href="<c:url value ='/HomeworkServlet?method=LoadHomework&HomeworkpageQuery=1'/>">学生作业案例</a></div>
                </div>
            </li>
            <li><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=2&n=1'/>">教学效果</a>
                <div class="detail">
                    <div><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=2&n=1'/>">校外专家评价</a></div>
                    <div><a href="<c:url value='/Expert_EvaluationServlet?method=getOneContent&number=0&type=1&n=2'/>">校内督导评价</a></div>
                    <div><a href="<c:url value='/teacher_evalution_servlet?method=LoadTeacherEvalator&EvalatorpageQuery=1'/>">教师自我评价</a></div>
                    <div><a href="<c:url value='/EvalatorServlet?method=LoadStudentEvalator&EvalatorpageQuery=1'/>">校内学生评价</a></div>
                    <div><a href="<c:url value='/social_evalution_servlet?method=LoadSocialEvalator&EvalatorpageQuery=1'/>">社会评价</a></div>
                    <div><a href="<c:url value='/TeachFileServlet?method=LoadHomework&TeachFilepageQuery=1'/>">教学评估及相关文件</a></div>
                </div>
            </li>
            <li><a href="/html/QQ.jsp">教学互动</a>
                <div class="detail">
                    <div><a href="/html/QQ.jsp">QQ群</a></div>
                    <div><a href="/servlet/WeChatServlet?type=normalShow">微信群</a></div>
                    <div><a href="/servlet/TeachingArrangementServlet?type=showLeaveMsg">师生互动</a></div>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>
