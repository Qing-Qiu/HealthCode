package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TSSubmitServlet", value = "/TSSubmitServlet")
public class TSSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Q1 = request.getParameterValues("radio1");
        String[] Q2 = request.getParameterValues("radio2");
        String[] Q3 = request.getParameterValues("radio3");
        String[] Q4 = request.getParameterValues("radio4");
        String[] Q5 = request.getParameterValues("radio5");
        String[] Q6 = request.getParameterValues("checkbox1");
        if (Q1[0].equals("1") || Q2[0].equals("1") || Q6.length == 1 && !Q6[0].equals("1")) {
            //yellow
            System.out.println("yellow");
            RequestDispatcher rd = request.getRequestDispatcher("yellow.jsp");
            rd.forward(request, response);
        } else if (Q3[0].equals("1") || Q4[0].equals("1") || Q6.length > 1) {
            //red
            System.out.println("red");
            RequestDispatcher rd = request.getRequestDispatcher("red.jsp");
            rd.forward(request, response);
        } else if (Q5[0].equals("1")) {
            //green
            System.out.println("green");
            RequestDispatcher rd = request.getRequestDispatcher("green.jsp");
            rd.forward(request, response);
        } else {
            //gold
            System.out.println("gold");
            RequestDispatcher rd = request.getRequestDispatcher("gold.jsp");
            rd.forward(request, response);
        }
    }
}
