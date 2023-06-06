package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "QueryColServlet", value = "/QueryColServlet")
public class QueryColServlet extends HttpServlet {
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
            String sql = "SELECT * FROM col WHERE col = ? ;";
            PreparedStatement stat = com.prepareStatement(sql);
            String col = request.getParameter("col");
            stat.setString(1, col);
            ResultSet rs = stat.executeQuery();
            ArrayList<String> stringArrayList = new ArrayList<String>();
            while (rs.next()) {
                if (col.equals(rs.getString("col"))) {//匹配成功
                    stringArrayList.add(rs.getString("num"));
                }
            }
            request.setAttribute("numArrayList", stringArrayList);
            RequestDispatcher rd = request.getRequestDispatcher("");
            rd.forward(request, response);
        } catch (Exception ignored) {
        }

    }
}
