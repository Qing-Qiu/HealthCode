<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>师生健康码管理系统</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="./img/meow.jpg" class="navbar-brand img-circle">
            <a class="navbar-brand" href="#">健康码系统</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right" id="login">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">管理员登录
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="sysLogin.jsp">系统管理</a></li>
                        <li><a href="schLogin.jsp">校级管理</a></li>
                        <li><a href="colLogin.jsp">院级管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3" id="code">
                    <h2 class="text-center">师生健康码</h2>
                    <h3 class="text-center">姓名：${name}</h3>
                    <h3 class="text-center" id="time"></h3>
                    <h3 class="text-center">
                        红码
                    </h3>
                    <div style="text-align: center">
                        <img src="img/red.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row"><br/></div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <footer class="footer text-center">
        <div class="container">
            <p>&copy; 2023 版权所有</p>
            <p>技术支持：XXX</p>
            <p>分享链接：<a href="#">Github</a> | <a href="#">QQ</a> | <a href="#">Wechat</a></p>
        </div>
    </footer>
</div><script type="text/javascript">
    window.onload = function () {
        showTime();
        window.setInterval("showTime()", 1000);
    }
    function showTime() {
        var oDt = new Date();
        var sTime = "";
        if (oDt.getHours() < 10) {
            sTime += "0" + oDt.getHours() + ":";
        } else sTime += oDt.getHours() + ":";
        if (oDt.getMinutes() < 10) {
            sTime += "0" + oDt.getMinutes() + ":";
        } else sTime += oDt.getMinutes() + ":";
        if (oDt.getSeconds() < 10) {
            sTime += "0" + oDt.getSeconds();
        } else sTime += oDt.getSeconds();
        document.getElementById("time").innerHTML = sTime;
    }
</script>
</body>
</html>