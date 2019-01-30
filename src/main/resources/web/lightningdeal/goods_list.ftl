<!DOCTYPE HTML>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">秒杀商品列表</div>
    <table class="table" id="goodslist">
        <tr><td>商品名称</td><td>商品图片</td><td>商品原价</td><td>秒杀价</td><td>库存数量</td><td>详情</td></tr>
        <tr  th:each="goods,goodsStat : ${goodsList}">

            <#list userList as user>
            </#list>

            <td th:text="${goods.goodsName}"></td>
            <td ><img th:src="@{${goods.goodsImg}}" width="100" height="100" /></td>
            <td th:text="${goods.goodsPrice}"></td>
            <td th:text="${goods.miaoshaPrice}"></td>
            <td th:text="${goods.stockCount}"></td>
            <td><a th:href="'/goods/to_detail/'+${goods.id}">详情</a></td>
        </tr>
    </table>
</div>
</body>
</html>
