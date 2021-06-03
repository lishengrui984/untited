<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2021/5/29
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>start</title>
    <style>
        body {
            border: none;
            margin: 0;
            padding: 0;
            width: 100%;
        }

        li {
            list-style: none;
            float: left;
            width: 60px;
            text-align: center;
        }

        .title {
            float: left;
            margin: 0px 0 0 15%;
            width: 200px;
        }

        .b1 {
            vertical-align: bottom;
            margin-left: 15%;
            width: 76%;
        }

        .b2 {
            vertical-align: bottom;
            margin-left: 15%;
            padding: 0.5%;
            background-color: #00aaff;
            border: none;
            border-radius: 5px;
            color: #ffffff;
            font-size: 20px;
        }

        .cont1 {
            float: left;
            vertical-align: bottom;
            margin-left: 15%;
            width: 20%;
            height: 300px;
        }

        .cont2 {
            float: left;
            vertical-align: bottom;
            margin-left: 2%;
            width: 26%;
            height: 300px;
        }

        .p1 {
            font-size: 35px;
            margin: 0;
        }

        .b3 {
            background-color: rgb(128, 138, 144);
            border: none;
            border-radius: 5px;
            padding: 1%;
            color: #FFFFFF;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div id="" style=" font-size: 20px;float: left;  width: 100%; height: 80px;">
	<span class="title">
	    603创新实验室
	</span>
    <li>首页</li>
    <li>问答</li>
    <li>博客</li>
    <li>资源库</li>
    <li>公告</li>
    <form >
        <button style="background-color: #00aaff;border-radius: 5px; float: right; border: none; margin-right: 4%; color: #ffffff;">
            <%=session.getAttribute("uname")%>
        </button>
    </form>
</div>


<div style="height: 380px;">
    <div id="" class="b1">
        <p><span style="font-size: 80px;">603小社区</span>仅供实验室内部人员使用，打造我们自己的圈子！</p>
    </div>
    <p class="b1">603小社区致力于为帮助更多在学习编程路上的小伙伴解决学习问题，提高质量的教程，输出高质量的博文，在这里你可以交到很多朋友，学到更多的知识，即使再小的帆也能远航！</p>
    <button class="b2">了解更多>></button>
</div>

<div style="width: 100%; float: left;">
    <div class="cont1">
        <p class="p1">问答</p>
        <p>提供高质量问答服务，致力于解决社区中小伙伙伴遇到的问题，并给出解决方案，做到学有所伴，问有所答！</p>
        <button class="b3">前往>></button>
    </div>
    <div class="cont2">
        <p class="p1">博客</p>
        <p>给社群小伙伴提供记录自己学的地方，推出个人博客，优化博客样式，更加方便的管理和展现文章，同时优质的文章会被更多的人看到！</p>
        <button class="b3">前往>></button>
    </div>
    <div class="cont2">
        <p class="p1">教程</p>
        <p>很多时候，小伙伴找不到具体的学习流程，导致浪费了很多的时间，所以列出教程给大家规划学习路线，让大家能够少走弯路，高效的学习！</p>
        <button class="b3">前往>></button>
    </div>

</div>


</body>
</html>