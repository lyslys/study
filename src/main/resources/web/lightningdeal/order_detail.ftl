<!DOCTYPE HTML>
<html>
<head>
    <title>订单详情</title>
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
  <div class="panel-heading">秒杀订单详情</div>
  <table class="table" id="goodslist">
        <tr>  
        <td>商品名称</td>  
        <td colspan="3">${goods.goodsName}</td>
     </tr>  
     <tr>  
        <td>商品图片</td>  
        <td colspan="2"><img src="${goods.goodsImg}" width="200" height="200" /></td>
     </tr>
      <tr>  
        <td>订单价格</td>  
        <td colspan="2">${orderInfo.goodsPrice}</td>
     </tr>
     <tr>
     		<td>下单时间</td>  
        	<td colspan="2">${orderInfo.createDate?string('yyyy-MM-dd hh:mm:ss')}</td>
     </tr>
     <tr>
     	<td>订单状态</td>  
        <td >
            <#if orderInfo.status == 0>
                <span>未支付</span>
            </#if>
            <#if orderInfo.status == 1>
                <span>待发货</span>
            </#if>
            <#if orderInfo.status == 2>
                <span>已发货</span>
            </#if>
            <#if orderInfo.status == 3>
                <span>已收货</span>
            </#if>
            <#if orderInfo.status == 4>
                <span>已退款</span>
            </#if>
            <#if orderInfo.status == 5>
                <span>已完成</span>
            </#if>
        </td>
        <td>
        	<button class="btn btn-primary btn-block" type="submit" id="payButton">立即支付</button>
        </td>
     </tr>
      <tr>
     		<td>收货人</td>  
        	<td colspan="2">XXX  18812341234</td>  
     </tr>
     <tr>
     		<td>收货地址</td>  
        	<td colspan="2">北京市昌平区回龙观龙博一区</td>  
     </tr>
  </table>
</div>

</body>
</html>
