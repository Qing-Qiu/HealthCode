<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.util.ArrayList" %>
<%

%>
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
                    <h2 class="text-center">学院信息查询</h2>
                    <form id="login_in" action="queryCol.jsp" method="post">
                        <div class="form-group">
                            <label for="col">学院：</label>
                            <input type="text" class="form-control" id="col" name="col"
                                   placeholder="请输入学院信息">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" id="btnLogin" style="width: 50%">查询</button>
                        </div>
                    </form>
                </div>
                <div>
                    <%
                        try {
                            Connection connection = null;
                            Connection com = null;
                            String driver = "com.mysql.cj.jdbc.Driver";
                            String dburl = "jdbc:mysql://127.0.0.1:3306/javaweb";
                            String user = "root";
                            String password = "root";
                            Class.forName(driver);
                            com = DriverManager.getConnection(dburl, user, password);
                            String sql = "SELECT * FROM col WHERE college = ? ;";
                            PreparedStatement stat = com.prepareStatement(sql);
                            String col = request.getParameter("col");
                            stat.setString(1, col);
                            ResultSet rs = stat.executeQuery();
                            ArrayList<String> stringArrayList = new ArrayList<String>();
                            while (rs.next()) {
                                if (col.equals(rs.getString("college"))) {//匹配成功
                                    stringArrayList.add(rs.getString("num"));
                                }
                            }
                            if (!stringArrayList.isEmpty())
                                for (String num : stringArrayList) {
//                                    System.out.println(num + " ");
                                    out.println(num + " ");
                                }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("error");
                        }
                    %>
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
</body>
</html>