<%--
  Author: BYX
  Date: 2022-10-04 - 13:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="shortcut icon" href="images/img.ico">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<div class="navigation">用户注册</div>
<div class="register-div">
    <form id="register-form" action="/ShoppingWEB/registerServlet" method="post">
        <ul class="ul">
            <li>
                <label for="username">用户名：</label>
                <input type="text" value="${u.username}" id="username" name="username" class="inp" placeholder="10位以下英文数字组成">
                <span class="error" style="display: none;" id="username-error">用户名不合法</span>
            </li>
            <li>
                <label for="password">密码：</label>
                <input type="password" value="${u.password}" id="password" name="password" class="inp" placeholder="6到12位英文、数字">
                <span class="error" id="password-error" style="display:none;">密码格式有误</span>
            </li>
            <li>
                <label for="repassword">确认密码：</label>
                <input type="password" value="${u.password}" id="repassword" class="inp">
                <span class="error" id="password-different" style="display:none;">密码不一致</span>
            </li>
            <li>
                <label for="phoneNumber">手机号码：</label>
                <input type="tel"  value="${u.phone}" name="phone" id="phoneNumber" class="inp">
                <span class="error" id="phone-error" style="display:none;">手机号不合法</span>
            </li>
            <li>
                <label for="email">邮箱：</label>
                <input type="text"  value="${u.email}" name="email" id="email" class="inp">
                <span class="error" id="email-error" style="display:none;">邮箱不合法</span>
            </li>
            <li>
                <h5 id="Error">${Error}</h5>
            </li>
            <li>
                <input type="submit" id="submit" value="注册">
                <input type="reset" id="reset" value="重置">
            </li>
            <a href="index.jsp" id="register-login">已有账号？去登录</a>
        </ul>
    </form>
</div>
<script src="JavaScript/register.js"></script>
</body>
</html>
