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
            String sql="SELECT * FROM col_admin;";
            ResultSet rs = stat.executeQuery(sql);
            ColAdmin colAdmin=new ColAdmin(request.getParameter("num"),request.getParameter("password"));
            boolean flag=false;
            while (rs.next()) {
                ColAdmin colAdmin1 = new ColAdmin();
                colAdmin1.setNum(rs.getString("num"));
                colAdmin1.setPassword(rs.getString("password"));
                if (colAdmin1.equals(colAdmin)) {//登录成功
                    flag=true;
                    sql="SELECT * FROM ;";          //打卡情况数据表
                    rs = stat.executeQuery(sql);
                    ArrayList<Record> recordArrayList=null;
                    recordArrayList=new ArrayList<Record>();
                    while(rs.next()){
                        Record rc=new Record();

                        recordArrayList.add(rc);
                    }
                    break;
                }
            }
            if(!flag){

            }
        }catch (Exception ignored) {
        }
    }
}
