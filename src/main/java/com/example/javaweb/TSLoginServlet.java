package com.example.javaweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TSLoginServlet", value = "/TSLoginServlet")
public class TSLoginServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Statement stat = com.createStatement();
            String sql;
            String[] role = request.getParameterValues("role");
            boolean flag = false;
            if (role[0].equals("1")) {
                sql = "SELECT * FROM teacherinfo;";
                ResultSet rs = stat.executeQuery(sql);
                Teacher teacher = new Teacher(new String(request.getParameter("name").getBytes("iso-8859-1"), "GBK"),
                        new String(request.getParameter("num").getBytes("iso-8859-1"), "GBK"),
                        new String(request.getParameter("idnum").getBytes("iso-8859-1"), "GBK"));
                while (rs.next()) {
                    Teacher teacher1 = new Teacher();
                    teacher1.setName(new String(rs.getString("name").getBytes("UTF-8"), "GBK"));
                    teacher1.setNum(new String(rs.getString("num").getBytes("UTF-8"), "GBK"));
                    teacher1.setIdnum(new String(rs.getString("idnum").getBytes("UTF-8"), "GBK"));
                    if (teacher1.equals(teacher)) {
                        flag = true;
                        request.setAttribute("name", new String(teacher.getName().getBytes("GBK"), "UTF-8"));
                        request.setAttribute("num", new String(teacher.getNum().getBytes("GBK"), "UTF-8"));
                        request.setAttribute("idnum", new String(teacher.getIdnum().getBytes("GBK"), "UTF-8"));
                        RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
                        rd.forward(request, response);
                        break;
                    }
                }
            } else {
                sql = "SELECT * FROM studentinfo;";
                ResultSet rs = stat.executeQuery(sql);
                Student student = new Student(new String(request.getParameter("name").getBytes("iso-8859-1"), "GBK"),
                        new String(request.getParameter("num").getBytes("iso-8859-1"), "GBK"),
                        new String(request.getParameter("idnum").getBytes("iso-8859-1"), "GBK"));
                while (rs.next()) {
//                    System.out.println(rs.getString("name")); //UTF-8
//                    System.out.println(request.getParameter("name")); //iso-8859-1
//                    System.out.println(new String(request.getParameter("name").getBytes("iso-8859-1"),"GBK"));//UTF-8
                    Student student1 = new Student();
                    student1.setName(new String(rs.getString("name").getBytes("UTF-8"), "GBK"));
                    student1.setNum(new String(rs.getString("num").getBytes("UTF-8"), "GBK"));
                    student1.setIdnum(new String(rs.getString("idnum").getBytes("UTF-8"), "GBK"));
                    if (student1.equals(student)) {
                        flag = true;
                        request.setAttribute("name", new String(student.getName().getBytes("GBK"), "UTF-8"));
                        request.setAttribute("num", new String(student.getNum().getBytes("GBK"), "UTF-8"));
                        request.setAttribute("idnum", new String(student.getIdnum().getBytes("GBK"), "UTF-8"));
                        RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
                        rd.forward(request, response);
                        break;
                    }
                }
            }
            if (!flag) {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception ignored) {
        }
    }
}
