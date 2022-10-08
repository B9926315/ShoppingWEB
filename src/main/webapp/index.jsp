<%--
  Author: BYX
  Date: 2022-10-03 - 21:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MSJD,Welcome!</title>
</head>
<link rel="stylesheet" href="css/login.css">
<link rel="shortcut icon" href="images/img.ico">
<body>
<div class="login">
    <h1 class="login-font">登录</h1>
    <span id="backInformation">${KindError}</span>
    <span id="backInformation1">${Error}</span>
    <form action="/ShoppingWEB/login0Servlet" id="login-form" method="post">
        <table class="login-table" cellspacing="2px" cellpadding="0">
            <tr class="input-tr">
                <td class="left-td"><label for="username" class="special0">用户名：</label></td>
                <td><input type="text" value="${cookie.username.value}" id="username" class="input" name="username" required></td>
            </tr>
            <tr class="input-tr">
                <td class="left-td"><label for="password" class="special0">密&nbsp;&nbsp;码：</label></td>
                <td><input type="password" value="${cookie.password.value}" id="password" class="input" name="password" required></td>
            </tr>
            <tr>
                <td class="special0"><span class="customer-span">用户类型： </span></td>
                <td>
                    <label for="customer"  class="special0">顾客</label><input type="radio" value="1" id="customer" name="user-category"> &nbsp;
                    <label for="boss"  class="special0">商家</label><input type="radio" value="0" id="boss" name="user-category" checked>&nbsp;
                </td>
            </tr>
            <tr id="login-top">
                <td id="rememberTD">
                    <label for="remember">记住</label><input type="radio" name="remember" value="1" id="remember">
                </td>
            </tr>
            <tr>
                <td class="login-td"><input type="submit" value="登录" class="login-box special0" id="btn-login"></td>
                <td class="login-td"><input type="reset" value="重置" class="reset-box special0"></td>
            </tr>
            <tr>
                <td class="no-username"><a href="register.jsp">没有账号？点击注册</a></td>
            </tr>
        </table>
    </form>
</div>
<script src="JavaScript/index.js"></script>
</body>
</html>