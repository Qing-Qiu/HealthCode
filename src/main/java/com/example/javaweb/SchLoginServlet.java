package com.example.javaweb;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

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
            String sql = "SELECT admin.num, admin.password FROM admin, teacher WHERE teacher.num = admin.num AND teacher.role = 'schadmin';";
            ResultSet rs = stat.executeQuery(sql);
            Admin schAdmin = new Admin(request.getParameter("num"), request.getParameter("password"));
            boolean flag = false;
            while (rs.next()) {
                Admin admin1 = new Admin();
                admin1.setNum(rs.getString("num"));
                admin1.setPassword(rs.getString("password"));
                if (admin1.equals(schAdmin)) {//登录成功
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
