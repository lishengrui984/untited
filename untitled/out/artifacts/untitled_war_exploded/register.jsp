<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2021/5/29
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        *{
            user-select: none;
        }
        body{
            background:  #00AAFF no-repeat;
            background-size: cover;
            background-attachment: fixed;
            text-align: center;
        }
        p{
            font-size: 42px;
            font-weight: 600;
        }
        input{
            background-color:  beige;
            width: 50%;
            height: 48px;
            margin-bottom: 10px;
            border: none;
            border-bottom: 2px solid darkgreen;
            outline: none;
            font-size: 22px;
        }
        .btn{
            background-color:  #00AAFF;
            width: 38%;
            height: 48px;
            border-radius: 8px;
            margin-top: 40px;
            font-size: 28px;
            font-weight: 600;
            color:  #006400;
        }
        .btn:hover{
            background-color: indigo;
        }
    </style>
</head>
<body>
<form action="register" method="post">
    <p>register</p>
    <input type="text" name="username" placeholder="用户名"><br>
    <input type="password" name="userpasswordOne" placeholder="密码"><br>
    <input type="password" name="userpasswordTwo" placeholder="确认密码"><br>
    <button class="btn">注册</button><br>
    <span style="color: red ;font-size: 12px">
            <%= request.getAttribute("msg")%>
        </span>
</form>
</body>
</html>
