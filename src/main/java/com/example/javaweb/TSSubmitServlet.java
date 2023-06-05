package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TSSubmitServlet", value = "/TSSubmitServlet")
public class TSSubmitServlet extends HttpServlet {
    Connection com = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://127.0.0.1:3306/javaweb?useUnicode=true&characterEncoding=UTF-8";
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
        String[] Q1 = request.getParameterValues("radio1");
        String[] Q2 = request.getParameterValues("radio2");
        String[] Q3 = request.getParameterValues("radio3");
        String[] Q4 = request.getParameterValues("radio4");
        String[] Q5 = request.getParameterValues("radio5");
        String[] Q6 = request.getParameterValues("checkbox1");
        String color;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        if (Q3[0].equals("1") || Q4[0].equals("1") || Q6.length > 1) {
            //red
            color = "red";
            System.out.println("red");
            try {
                String sql;
                sql = "INSERT INTO record VALUES (?,?,?)";
                PreparedStatement stat = com.prepareStatement(sql);
                stat.setString(1, (String) request.getSession().getAttribute("name"));
                stat.setString(2, color);
                stat.setString(3, formatter.format(date));
                stat.executeUpdate();
            } catch (Exception ignore) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("red.jsp");
            rd.forward(request, response);
        } else if (Q1[0].equals("1") || Q2[0].equals("1") || Q6.length == 1 && !Q6[0].equals("1")) {
            //yellow
            color = "yellow";
            System.out.println("yellow");
            try {
                String sql;
                sql = "INSERT INTO record VALUES (?,?,?)";
                PreparedStatement stat = com.prepareStatement(sql);
                stat.setString(1, (String) request.getSession().getAttribute("name"));
                stat.setString(2, color);
                stat.setString(3, formatter.format(date));
                stat.executeUpdate();
            } catch (Exception ignore) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("yellow.jsp");
            rd.forward(request, response);
        } else if (Q5[0].equals("1")) {
            //green
            color = "green";
            System.out.println("green");
            try {
                String sql;
                sql = "INSERT INTO record VALUES (?,?,?)";
                PreparedStatement stat = com.prepareStatement(sql);
                stat.setString(1, (String) request.getSession().getAttribute("name"));
                stat.setString(2, color);
                stat.setString(3, formatter.format(date));
                stat.executeUpdate();
            } catch (Exception ignore) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("green.jsp");
            rd.forward(request, response);
        } else {
            //gold
            color = "gold";
            System.out.println("gold");
            try {
                String sql;
                sql = "INSERT INTO record VALUES (?,?,?)";
                PreparedStatement stat = com.prepareStatement(sql);
                stat.setString(1, (String) request.getSession().getAttribute("name"));
                stat.setString(2, color);
                stat.setString(3, formatter.format(date));
                stat.executeUpdate();
            } catch (Exception ignore) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("gold.jsp");
            rd.forward(request, response);
        }
    }
}
