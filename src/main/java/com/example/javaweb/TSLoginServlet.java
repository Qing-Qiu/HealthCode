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
            String sql;
            String[] role = request.getParameterValues("role");
            boolean flag = false;
            if (role[0].equals("1")) {
                sql = "SELECT * FROM teacherinfo;";
                ResultSet rs = stat.executeQuery(sql);
                Teacher teacher = new Teacher(request.getParameter("name"), request.getParameter("num"), request.getParameter("idnum"));
                while (rs.next()) {
                    Teacher teacher1 = new Teacher();
                    teacher1.setName(rs.getString("name"));
                    teacher1.setNum(rs.getString("num"));
                    teacher1.setIdnum(rs.getString("idnum"));
                    if (teacher1.equals(teacher)) {
                        flag = true;
                        request.setAttribute("Teacher", teacher);
                        RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
                        rd.forward(request, response);
                        break;
                    }
                }
            } else {
                sql = "SELECT * FROM studentinfo;";
                ResultSet rs = stat.executeQuery(sql);
                Student student = new Student(request.getParameter("name"), request.getParameter("num"), request.getParameter("idnum"));
                while (rs.next()) {
                    Student student1 = new Student();
                    student1.setName(rs.getString("name"));
                    student1.setNum(rs.getString("num"));
                    student1.setIdnum(rs.getString("idnum"));
                    if (student1.equals(student)) {
                        flag = true;
                        request.setAttribute("Student", student);
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
