package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "ColLoginServlet", value = "/ColLoginServlet")
public class ColLoginServlet extends HttpServlet {
    Connection com = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://127.0.0.1:3306/javaweb";
    String user = "root";
    String password = "root";

    public void init() {
        try {
            Class.forName(driver);
            com = DriverManager.getConnection(dburl, user, password);
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Statement stat = com.createStatement();
            String sql = "SELECT admin.num, admin.password FROM admin, teacher WHERE teacher.num = admin.num AND teacher.role = 'coladmin';";
            ResultSet rs = stat.executeQuery(sql);
            Admin admin = new Admin(request.getParameter("num"), request.getParameter("password"));
            boolean flag = false;
            while (rs.next()) {
                Admin admin1 = new Admin();
                admin1.setNum(rs.getString("num"));
                admin1.setPassword(rs.getString("password"));
                if (admin1.equals(admin)) {//登录成功
                    flag = true;
                    request.getSession().setAttribute("admin", "col");
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("colLogin.jsp");
            } else {
                response.sendRedirect("colAdmin.jsp");
            }
        } catch (Exception ignored) {
        }
    }
}
