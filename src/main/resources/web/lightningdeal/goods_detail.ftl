<!DOCTYPE HTML>
<html>
<head>
    <title>商品详情</title>
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
    <div class="panel-heading">秒杀商品详情</div>
    <if class="panel-body">
        <#if !user??>
            <span> 您还没有登录，请登陆后再操作<br/></span>
        </#if>
        <span>没有收货地址的提示。。。</span>
</div>
<table class="table" id="goodslist">
    <tr>
        <td>商品名称</td>
        <td colspan="3">${goods.goodsName}</td>
    </tr>
    <tr>
        <td>商品图片</td>
        <td colspan="3"><img src="${goods.goodsImg}" width="200" height="200"/></td>
    </tr>
    <tr>
        <td>秒杀开始时间</td>
        <td>${goods.startDate?string('yyyy-MM-dd hh:mm:ss')}</td>
        <td id="miaoshaTip">
        <input type="hidden" id="remainSeconds" value="${remainSeconds}"/>
            <#if miaoshaStatus == 0>
              <span>秒杀倒计时：<span id="countDown">${remainSeconds}</span>秒</span>
            </#if>
            <#if miaoshaStatus == 1>
              <span>秒杀进行中</span>
            </#if>
            <#if miaoshaStatus == 2>
                <span>秒杀已结束</span>
            </#if>
        </td>
        <td>
            <form id="miaoshaForm" method="post" action="/miaosha/do_miaosha">
                <button class="btn btn-primary btn-block" type="submit" id="buyButton">立即秒杀</button>
                <input type="hidden" name="goodsId" value="${goods.id}"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>商品原价</td>
        <td colspan="3">${goods.goodsPrice}</td>
    </tr>
    <tr>
        <td>秒杀价</td>
        <td colspan="3">${goods.miaoshaPrice}</td>
    </tr>
    <tr>
        <td>库存数量</td>
        <td colspan="3">${goods.stockCount}</td>
    </tr>
</table>
</div>
</body>
<script>
    $(function () {
        countDown();
    });

    function countDown() {
        var remainSeconds = $("#remainSeconds").val();
        var timeout;
        if (remainSeconds > 0) {//秒杀还没开始，倒计时
            $("#buyButton").attr("disabled", true);
            timeout = setTimeout(function () {
                $("#countDown").text(remainSeconds - 1);
                $("#remainSeconds").val(remainSeconds - 1);
                countDown();
            }, 1000);
        } else if (remainSeconds == 0) {//秒杀进行中
            $("#buyButton").attr("disabled", false);
            if (timeout) {
                clearTimeout(timeout);
            }
            $("#miaoshaTip").html("秒杀进行中");
        } else {//秒杀已经结束
            $("#buyButton").attr("disabled", true);
            $("#miaoshaTip").html("秒杀已经结束");
        }
    }

</script>
</html>
