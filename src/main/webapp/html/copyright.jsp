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
<div class="mainWrap">
    <div class="link">
        <ul>
            <li>友情链接</li>
            <li><a href="http://www.dgut.edu.cn">东莞理工学院</a></li>
            <li><a href="http://jwc.dgut.edu.cn">东莞理工学院教务处</a></li>
            <li><a href="http://sw.dgut.edu.cn">东莞理工学院计算机与网络安全学院</a></li>
        </ul>
    </div>
    <div class="final">
        <ul>
            <li class="left">© 2018,UML Group 2</li>
            <li class="right">联系我们</li>
        </ul>
    </div>
</div>
</body>
</html>
