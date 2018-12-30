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
            <li><a href="courseDetail-1.html">课程概况</a>
                <div class="detail">
                    <div><a href="courseDetail-1.html">课程简介</a></div>
                    <div><a href="courseDetail-2.html">课程特色</a></div>
                    <div><a href="courseDetail-3.html">教材与参考资料</a></div>
                    <div><a href="courseDetail-4.html">历史沿革</a></div>
                </div>
            </li>
            <li><a href="teacherTeam.html">教师队伍</a>
                <div class="detail">
                    <div><a href="teacherTeamDetail-1.html">课程负责人</a></div>
                    <div><a href="teacherTeamDetail-2.html">课程教学团队</a></div>
                    <div><a href="teacherTeamDetail-3.html">主讲教师</a></div>
                    <div><a href="teacherTeamDetail-4.html">青年教师培养</a></div>
                </div>
            </li>
            <li><a href="educationalDetail-1.html">教学安排</a>
                <div class="detail">
                    <div><a href="educationalDetail-2.html">教学日历</a></div>
                    <div><a href="educationalDetail-3.html">教学内容</a></div>
                    <div><a href="educationalDetail-4.html">授课计划</a></div>
                    <div><a href="educationalDetail-5.html">教学重难点</a></div>
                    <div><a href="educationalDetail-6.html">教学方法与手段</a></div>
                </div>
            </li>
            <li><a href="educationReformDetail-1.html">教学研究改革</a>
                <div class="detail">
                    <div><a href="educationReformDetail-1.html">改革措施</a></div>
                    <div><a href="educationReformDetail-2.html">改革立项</a></div>
                    <div><a href="educationReformDetail-3.html">改革成果</a></div>
                    <div><a href="educationReformDetail-4.html">改革表彰和奖励</a></div>
                </div>
            </li>
            <li><a href="teachResDetail-1.html">教学资源</a>
                <div class="detail">
                    <div><a href="teachResDetail-1.html">课程课件</a></div>
                    <div><a href="teachResDetail-2.html">教学录像</a></div>
                    <div><a href="teachResDetail-3.html">习题库</a></div>
                    <div><a href="teachResDetail-4.html">案例库</a></div>
                    <div><a href="teachResDetail-5.html">实验任务</a></div>
                </div>
            </li>
            <li><a href="admission.html">教学管理</a>
                <div class="detail">
                    <div><a href="admissionDetail-1.html">开课计划</a></div>
                    <div><a href="<c:url value='/ClassInfoServlet?method=LoadClassInfo&classInfoPageQuery=1'/>">上课班级</a></div>
                    <div><a href="<c:url value='/ScoreServlet?method=LoadStudentEvalator&StudentpageQuery=1'/>">学生成绩</a></div>
                    <div><a href="admissionDetail-4.html">班级名册</a></div>
                    <div><a href="<c:url value='admissionDetail-4.html'/>">班级名册</a></div>
                </div>
            </li>
            <li><a href="<c:url value ='employment.html'/>">教学效果</a>
                <div class="detail">
                    <div><a href="<c:url value ='/html/teachEffectDetail-1.jsp'/>">校外专家评价</a></div>
                    <div><a href="<c:url value ='/html/teachEffectDetail-2.jsp'/>">校内督导评价</a></div>
                    <div><a href="<c:url value ='/html/teachEffectDetail-3.jsp'/>">教师自我评价</a></div>
                    <div><a href="<c:url value='/EvalatorServlet?method=LoadStudentEvalator&EvalatorpageQuery=1'/>">校内学生评价</a></div>
                    <div><a href="<c:url value ='/html/teachEffectDetail-1.jsp'/>">社会评价</a></div>
                    <div><a href="<c:url value ='/html/teachEffectDetail-2.jsp'/>">教学评估及相关文件</a></div>
                </div>
            </li>
            <li><a href="QQ.html">教学互动</a>
                <div class="detail">
                    <div><a href="QQ.html">QQ群</a></div>
                    <div><a href="WeChat.html">微信群</a></div>
                    <div><a href="leavenote.html">师生互动</a></div>
                </div>
            </li>
        </ul>
    </div>
</body>
</html>
