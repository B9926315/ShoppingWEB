<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <link rel="stylesheet" href="css/goodsList.css">
    <link rel="shortcut icon" href="images/img.ico">
</head>
<body>
<h1 id="goodsListTableTitle">商品管理</h1>
<input type="button" value="新增商品" id="addGoods">
<a href="/ShoppingWEB/selectAllServlet"><button id="AllBTN">展示所有</button></a><br>
<form action="/ShoppingWEB/selectByConditionsServlet" method="post" id="searchForm">
    <label>状态:</label>
    <select name="status" id="status">
        <option value="" selected>所有</option>
        <option value="1">启用</option>
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
<table id="goodsListTable">
    <thead>
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>价格</th>
        <th>排名</th>
        <th>剩余数量</th>
        <th>商品规格</th>
        <th>状态</th>
        <th>上架时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goods}" var="good" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${good.name}</td>
            <td>${good.price}</td>
            <td>${good.rank}</td>
            <td>${good.number}</td>
            <td>${good.goodsSize}</td>
            <c:if test="${good.status==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${good.status==0}">
                <td>禁用</td>
            </c:if>
            <td>${good.createTime}</td>
            <td>${good.updateTime}</td>
            <td><a href="/ShoppingWEB/selectByIdServlet?id=${good.id}">编辑</a>
                <a href="/ShoppingWEB/deleteByIdServlet?id=${good.id}" onclick="return confirm('确认删除？')">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="JavaScript/goodsList.js"></script>
</body>
</html>
