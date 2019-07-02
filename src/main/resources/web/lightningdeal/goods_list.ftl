<!DOCTYPE HTML>
<html>
<head>
    <title>商品列表</title>
    <!-- jquery -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="/js/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/js/bootstrap/js/bootstrap.min.js"></script>
    <!-- jquery-validator -->
    <script type="text/javascript" src="/js/jquery-validation/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/js/jquery-validation/localization/messages_zh.min.js"></script>
    <!-- layer -->
    <script type="text/javascript" src="/js/layer/layer.js"></script>
    <!-- md5.js -->
    <script type="text/javascript" src="/js/md5.min.js"></script>
    <!-- common.js -->
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">秒杀商品列表</div>
    <table class="table" id="goodslist">
        <tr>
            <td>商品名称</td>
            <td>商品图片</td>
            <td>商品原价</td>
            <td>秒杀价</td>
            <td>库存数量</td>
            <td>详情</td>
        </tr>
            <#list goodsList as goods>
                 <tr>
                     <td>${goods.goodsName}</td>
                     <td><img src="${goods.goodsImg}" width="100" height="100"/></td>
                     <td>${goods.goodsPrice}</td>
                     <td>${goods.miaoshaPrice}</td>
                     <td>${goods.stockCount}</td>
                     <td><a href="/goods_detail.htm?goodsId=${goods.id}">详情</a></td>
                 </tr>
            </#list>
    </table>
</div>
</body>
</html>
