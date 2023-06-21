<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.example.javaweb.Teacher" %>
<%@ page import="com.example.javaweb.RecordDao" %>
<%@ page import="com.example.javaweb.RecordDaoImpl" %>
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
            <ul class="nav navbar-nav navbar-left" id="query"></ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">师生登录</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <h2 class="text-center">添加教师信息</h2>
                    <form id="login_in" action="insertTea.jsp" method="post">
                        <div class="form-group">
                            <label for="name">姓名：</label>
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="idnum">身份证号：</label>
                            <input type="text" class="form-control" id="idnum" name="idnum"
                                   placeholder="请输入身份证号">
                        </div>
                        <div class="form-group">
                            <label for="num">工号：</label>
                            <input type="text" class="form-control" id="num" name="num"
                                   placeholder="请输入工号">
                        </div>
                        <div class="form-group">
                            <label for="col">学院：</label>
                            <input type="text" class="form-control" id="col" name="col"
                                   placeholder="请输入学院信息">
                        </div>
                        <div class="form-group">
                            <label for="maj">专业：</label>
                            <input type="text" class="form-control" id="maj" name="maj"
                                   placeholder="请输入专业信息">
                        </div>
                        <div class="form-group">
                            <label for="cla">班级：</label>
                            <input type="text" class="form-control" id="cla" name="cla"
                                   placeholder="请输入班级信息">
                        </div>
                        <div class="form-group">
                            <label>角色：</label><br/>
                            <label><input type="radio" name="role" value="1">系统管理员</label>
                            <label><input type="radio" name="role" value="2">校级管理员</label>
                            <label><input type="radio" name="role" value="3">院级管理员</label>
                            <label><input type="radio" name="role" value="4" checked="checked">普通教师</label>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" id="btnLogin" style="width: 50%">添加</button>
                        </div>
                        <div>
                            <%
                                if (request.getParameter("num") != null) {
                                    String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
                                    String num = request.getParameter("num");
                                    String idnum = request.getParameter("idnum");
                                    String col = request.getParameter("col");
                                    String maj = new String(request.getParameter("maj").getBytes("iso-8859-1"), "UTF-8");
                                    String cla = request.getParameter("cla");
                                    String[] role = request.getParameterValues("role");
                                    Teacher teacher = new Teacher();
                                    teacher.setName(name);
                                    teacher.setNum(num);
                                    teacher.setIdnum(idnum);
                                    teacher.setCol(col);
                                    teacher.setMaj(maj);
                                    teacher.setCla(cla);
                                    teacher.setRole(role[0]);
                                    RecordDao dao = new RecordDaoImpl();
                                    boolean flag = dao.insertTea(teacher);
                                    if (flag) out.print("添加成功！<br />");
                                    else out.print("添加失败！<br />");
                                }
                            %>
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
<script>
    window.onload = function () {
        var type = '<%=session.getAttribute("admin")%>';
        if (type === 'col') {
            document.getElementById("query").innerHTML =
                `<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">查询信息
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">专业信息</a></li>
                        <li><a href="#">班级信息</a></li>
                        <li><a href="#">学生信息</a></li>
                        <li><a href="#">打卡信息</a></li>
                    </ul>
                </li>`;
        } else if (type === 'sch') {
            document.getElementById("query").innerHTML =
                `<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">查询信息
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="queryCol.jsp">学院信息</a></li>
                        <li><a href="queryMaj.jsp">专业信息</a></li>
                        <li><a href="queryCla.jsp">班级信息</a></li>
                        <li><a href="queryStu.jsp">学生信息</a></li>
                        <li><a href="queryRec.jsp">打卡信息</a></li>
                    </ul>
                </li>`;
        } else if (type === 'sys') {
            document.getElementById("query").innerHTML =
                `
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">查询信息
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="queryCol.jsp">学院信息</a></li>
                        <li><a href="queryMaj.jsp">专业信息</a></li>
                        <li><a href="queryCla.jsp">班级信息</a></li>
                        <li><a href="queryStu.jsp">学生信息</a></li>
                        <li><a href="queryRec.jsp">打卡信息</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">导入信息
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="insertTea.jsp">教师信息</a></li>
                        <li><a href="insertStu.jsp">学生信息</a></li>
                    </ul>
                </li>`;
        }
    }
</script>
<script type="text/javascript">
    var form = $('#login_in');
    $(document).ready(function () {
        form.bootstrapValidator({
            message: '输入值不合法',
            feedbackIcons: { //提示图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '姓名不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 8
                        }
                    }
                },
                num: {
                    validators: {
                        notEmpty: {
                            message: '学号不能为空'
                        },
                        stringLength: {
                            min: 12,
                            max: 12,
                            message: '请输入12位学号'
                        }
                    }
                },
                idnum: {
                    validators: {
                        notEmpty: {
                            message: '身份证不能为空'
                        },
                        stringLength: {
                            min: 18,
                            max: 18,
                            message: '请输入18位身份证'
                        }
                    }
                },
                col: {
                    validators: {
                        notEmpty: {
                            message: '请选择选项'
                        },
                        stringLength: {
                            min: 4,
                            max: 4,
                            message: '请输入正确的学院信息'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>