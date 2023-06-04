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
                <div class="col-md-6 col-md-offset-3">
                    <h2 class="text-center">师生信息填报</h2>
                    <form id="info">
                        <div class="form-group">
                            <label for="name">姓名：</label>
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="${name}" disabled="disabled">
                        </div>
                        <div class="form-group">
                            <label for="num">学号/工号：</label>
                            <input type="text" class="form-control" id="num" name="num"
                                   placeholder="${num}" disabled="disabled">
                        </div>
                        <div class="form-group">
                            <label for="idnum">身份证：</label>
                            <input type="text" class="form-control" id="idnum" name="idnum"
                                   placeholder="${idnum}" disabled="disabled">
                        </div>
                        <div class="form-group">
                            <label for="phonenum">手机号：</label>
                            <input type="text" class="form-control" id="phonenum" name="phonenum"
                                   placeholder="请输入手机号">
                        </div>
                        <div class="form-group">
                            <label>本人近期（14天内）是否去过重点疫区？</label>
                            <label><input type="radio" name="radio1" value="1">是</label>
                            <label><input type="radio" name="radio1" value="2">否</label>
                        </div>
                        <div class="form-group">
                            <label>本人近期（14天内）是否去过国外？</label>
                            <label><input type="radio" name="radio2" value="1">是</label>
                            <label><input type="radio" name="radio2" value="2">否</label>
                        </div>
                        <div class="form-group">
                            <label>本人近期（14天内）是否接触过新冠确诊病人或疑似病人？</label>
                            <label><input type="radio" name="radio3" value="1">是</label>
                            <label><input type="radio" name="radio3" value="2">否</label>
                        </div>
                        <div class="form-group">
                            <label>本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？</label>
                            <label><input type="radio" name="radio4" value="1">是</label>
                            <label><input type="radio" name="radio4" value="2">否</label>
                        </div>
                        <div class="form-group">
                            <label>本人是否打过新冠疫苗？</label>
                            <label><input type="radio" name="radio5" value="1">未打过</label>
                            <label><input type="radio" name="radio5" value="2">已打1针</label>
                            <label><input type="radio" name="radio5" value="3">已打2针</label>
                            <label><input type="radio" name="radio5" value="4">已打3针</label>
                        </div>
                        <div class="form-group">
                            <label>当前健康状况？</label>
                            <label><input type="checkbox" name="checkbox1" value="1">无异常</label>
                            <label><input type="checkbox" name="checkbox1" value="2">发烧（≥37.3°C）</label>
                            <label><input type="checkbox" name="checkbox1" value="3">乏力</label>
                            <label><input type="checkbox" name="checkbox1" value="4">干咳</label>
                            <label><input type="checkbox" name="checkbox1" value="5">比赛</label>
                            <label><input type="checkbox" name="checkbox1" value="6">流涕</label>
                            <label><input type="checkbox" name="checkbox1" value="7">咽痛</label>
                            <label><input type="checkbox" name="checkbox1" value="8">腹泻</label>
                        </div>
                        <div class="form-group">
                            <label><input type="radio" name="radio6" value="1">本人郑重承诺：填报信息真实，愿意承担相应的法律责任。</label>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" id="btnLogin" style="width: 50%">提交</button>
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