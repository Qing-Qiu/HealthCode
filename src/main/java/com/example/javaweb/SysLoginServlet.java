package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "SysLoginServlet", value = "/SysLoginServlet")
public class SysLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        if (password.equals("root")) {
            request.getSession().setAttribute("admin", "sys");
            response.sendRedirect("sysAdmin.jsp");
        } else {
            response.sendRedirect("sysLogin.jsp");
        }
    }
}
