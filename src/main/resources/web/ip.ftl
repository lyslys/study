<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>模版引擎</title>
</head>
<body>
<script>
    var ip = "${ip}";
    // alert(ip);
    var url = "http://"+ip+"/studyIndex";
    // alert(url);
    window.location.href = url;
</script>
<marquee direction="right" >

    <h1 style="color: red">${ip}</h1>

</marquee>
</body>
</html>