<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>模版引擎</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<marquee direction="right" >

    <h1 style="color: #ff0bc2">梁氏家族，傲视天下</h1>

</marquee>

<video id="v" src="/my/298190.mp4" controls="controls"></video>
<img src="/images/meta10.png">

<br/>


<#if vList?exists>
    <#list vList as v>
    <button onclick="show(this.value)" value="${v}">${v}</button><br/>
    </#list>
</#if>

<script>
    function show(value) {
        document.getElementById("v").src="/my"+value ;
        document.getElementById("v").play()
    }
</script>

</body>
</html>

