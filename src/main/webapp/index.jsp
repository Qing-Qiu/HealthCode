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
                        <li><a href="adminLogin.jsp">系统管理</a></li>
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
                <div class="col-md-4 col-md-offset-4">
                    <h2 class="text-center">师生登录</h2>
                    <form id="login_in" action="TSLoginServlet" method="post">
                        <div class="form-group">
                            <label for="name">姓名：</label>
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="num">学号/工号：</label>
                            <input type="text" class="form-control" id="num" name="num"
                                   placeholder="请输入学号/工号">
                        </div>
                        <div class="form-group">
                            <label for="idnum">身份证：</label>
                            <input type="text" class="form-control" id="idnum" name="idnum"
                                   placeholder="请输入身份证">
                        </div>
                        <div class="form-group">
                            <label>教师/学生：</label>
                            <label><input type="radio" name="role" value="1">教师</label>
                            <label><input type="radio" name="role" value="2">学生</label>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" id="btnLogin" style="width: 50%">登录</button>
                        </div>
                    </form>
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
</div>
<script type="text/javascript">
    window.onload = function () {
        var sName = localStorage.getItem("username");
        var sPwd = localStorage.getItem("password");
        if (sName && sPwd) {
            document.getElementById("login").innerHTML =
                '<li class="dropdown">\n' +
                '<a class="dropdown-toggle" data-toggle="dropdown" href="#">' +
                sName +
                '<span class="caret"></span></a>\n' +
                '<ul class="dropdown-menu">\n' +
                '<li><a href="#" onclick="log_out()">登出</a></li>\n' +
                '</ul>\n' +
                '</li>'
        }
    }

    function log_out() {
        localStorage.removeItem("username");
        localStorage.removeItem("password");
        location.reload();
    }
</script>
<script type="text/javascript">
    var form = $('#contact_us');
    $(document).ready(function () {
        form.bootstrapValidator({
            message: '输入值不合法',
            feedbackIcons: { //提示图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                email: {
                    validators: {
                        notEmpty: {
                            message: 'email不能为空'
                        },
                        emailAddress: {
                            message: '请输入正确的邮件地址如：123@qq.com'
                        }
                    }
                },
                advice: {
                    validators: {}
                }
            }
        });
    });
</script>
</body>
</html>