<%--
  Author: BYX
  Date: 2022-10-02 - 17:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑商品信息</title>
    <link rel="stylesheet" href="css/addGoods.css">
    <link rel="shortcut icon" href="images/img.ico">
</head>
<body>
<div id="addDIV">

    <h1 id="addGoodsTitle">修改商品信息</h1>
    <form action="/ShoppingWEB/updateServlet" method="post">
        <ul>
            <li><input type="hidden" name="id" value="${goods.id}"></li>
            <input type="hidden" name="createTime" value="${brand.createTime}">
            <input type="hidden" name="updateTime" value="${brand.updateTime}">
            <li>
                <label for="goodsName">商品名称：</label>
                <input type="text" id="goodsName" name="name" class="inp" value="${goods.name}" required="required">
            </li>
            <li>
                <label for="goodsPrice">商品价格：</label>
                <input type="number" id="goodsPrice" name="price" class="inp" value="${goods.price}" required="required">
            </li>
            <li>
                <label for="goodsRank">商品排名：</label>
                <input type="number" id="goodsRank" name="rank" class="inp" value="${goods.rank}" required="required">
            </li>
            <li>
                <label for="goodsNumber">商品余量：</label>
                <input type="number" id="goodsNumber" name="number" class="inp" value="${goods.number}" required="required">
            </li>
            <li id="li1">
                <label for="goodsSize" id="goodsSizeLabel">商品规格：</label>
                <textarea name="goodsSize" id="goodsSize"  required="required">${goods.goodsSize}</textarea>
            </li>
            <li>
                <label>商品状态：</label>
                <c:if test="${goods.status==0}">
                    <label for="stop1">禁用</label><input type="radio" id="stop1" name="status" value="0" checked="checked">
                    <label for="go1">启用</label><input type="radio" name="status" value="1" id="go1">
                </c:if>
                <c:if test="${goods.status==1}">
                    <label for="stop2">禁用</label><input type="radio" id="stop2" name="status" value="0" >
                    <label for="go2">启用</label><input type="radio" id="go2" name="status" value="1" checked="checked">
                </c:if>
            </li>
            <li>
                <input type="submit" id="submitBTN" class="BTN" value="修改">
                <input type="reset" id="resetBTN" class="BTN">
            </li>
        </ul>
    </form>

</div>
</body>
</html>
