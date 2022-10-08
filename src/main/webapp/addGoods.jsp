<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加商品</title>
    <link rel="stylesheet" href="css/addGoods.css">
    <link rel="shortcut icon" href="images/img.ico">
</head>
<body>
<div id="addDIV">

    <h1 id="addGoodsTitle">添加商品</h1>
    <form action="/ShoppingWEB/addServlet" method="post">
        <ul>
            <li>
                <label for="goodsName">商品名称：</label>
                <input type="text" id="goodsName" name="name" class="inp" required>
            </li>
            <li>
                <label for="goodsPrice">商品价格：</label>
                <input type="number" id="goodsPrice" name="price" class="inp" required>
            </li>
            <li>
                <label for="goodsRank">商品排名：</label>
                <input type="number" id="goodsRank" name="rank" class="inp" required>
            </li>
            <li>
                <label for="goodsNumber">商品余量：</label>
                <input type="number" id="goodsNumber" name="number" class="inp" required>
            </li>
            <li id="li1">
                <label for="goodsSize" id="goodsSizeLabel">商品规格：</label>
                <textarea name="goodsSize" id="goodsSize" required></textarea>
            </li>
            <li>
                <label>商品状态：</label>
                <label for="open">启用</label><input type="radio" name="status" value="1" id="open" checked="checked">
                &nbsp;
                <label for="close">禁用</label><input type="radio" name="status" value="0" id="close">
            </li>
            <li>
                <input type="submit" id="submitBTN" class="BTN">
                <input type="reset" id="resetBTN" class="BTN">
            </li>
        </ul>
    </form>

    </div>
</body>
</html>
