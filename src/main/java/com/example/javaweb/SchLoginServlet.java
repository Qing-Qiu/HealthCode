package com.example.javaweb;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "SchLoginServlet", value = "/SchLoginServlet")
public class SchLoginServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Statement stat = com.createStatement();
            String sql = "SELECT * FROM sch_admin;";
            ResultSet rs = stat.executeQuery(sql);
            SchAdmin schAdmin = new SchAdmin(request.getParameter("num"), request.getParameter("password"));
            boolean flag = false;
            while (rs.next()) {
                SchAdmin schAdmin1 = new SchAdmin();
                schAdmin1.setNum(rs.getString("num"));
                schAdmin1.setPassword(rs.getString("password"));
                if (schAdmin1.equals(schAdmin)) {//登录成功
                    flag = true;
                    request.getSession().setAttribute("admin", "sch");
                    break;
                }
            }
            if (!flag) {
                response.sendRedirect("schLogin.jsp");
            } else {
                response.sendRedirect("schAdmin.jsp");
            }
        } catch (Exception ignored) {
        }

    }
}
