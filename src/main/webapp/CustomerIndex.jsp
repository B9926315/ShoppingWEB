<%--
  Author: BYX
  Date: 2022-10-04 - 16:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MSJD,Your First</title>
    <link rel="shortcut icon" href="images/img.ico">
    <link rel="stylesheet" href="css/CustomerIndex..css">
</head>
<body>
<h1 id="welcome">尊敬的${user},欢迎来到MSJD</h1>
<a href="/ShoppingWEB/customerIndexServlet"><button id="AllBTN">展示所有</button></a><br>
<form action="/ShoppingWEB/selectByCustomerServlet" method="post" id="searchForm">
    <label hidden>状态:</label>
    <select name="status" id="status" hidden>
        <option value="">所有</option>
        <option value="1" selected>启用</option>
        <option value="0">禁用</option>
    </select>
    <%--    品牌--%>
    <label for="brandName">品牌:</label><input type="text" id="brandName" name="brandName0" value="${goods1.name}">
    <%--    价格区间--%>
    <label for="brandPriceMin">价格区间:</label>
    <input type="number" min="0" id="brandPriceMin" name="brandPriceMin" value="${goods1.priceMin}">
    <label for="brandPriceMax">-</label>
    <input type="number" min="0" id="brandPriceMax" name="brandPriceMax" value="${goods1.priceMax}">
    <%--    数量区间--%>
    <label for="brandNumberMin">库存区间:</label>
    <input type="number" min="0" name="brandNumberMin" id="brandNumberMin" value="${goods1.numberMin}">
    <label for="brandNumberMax">-</label>
    <input type="number" min="0" name="brandNumberMax" id="brandNumberMax" value="${goods1.numberMax}">
    <%--    提交按钮--%>
    <input type="submit" name="searchSubmit" value="搜索" id="searchSubmit">
</form>
<table id="CustomerGoodsList">
    <tbody>
    <c:forEach items="${goods}" var="good">
        <tr align="left">
            <td id="img">
                <img src="${good.images}" alt="图片暂时失效" class="phoneIMG" width="400px">
            </td>
            <td id="information">
                <span id="name">商品名称：${good.name}</span><br>
                <span id="size">商品描述：${good.goodsSize}</span><br>
                <span id="number">商品余量：${good.number}</span><br>
                <span id="money">￥${good.price}</span><br>
                <a href="/ShoppingWEB/numberServlet?id=${good.id}" onclick="return confirm('确认购买？')"><button class="input-btn">立即购买</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
