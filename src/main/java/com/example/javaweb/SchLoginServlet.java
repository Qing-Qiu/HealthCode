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
            String sql="SELECT * FROM scl_admin;";
            ResultSet rs = stat.executeQuery(sql);
            SchAdmin schAdmin=new SchAdmin(request.getParameter("num"),request.getParameter("password"));
            boolean flag=false;
            while (rs.next()) {
                SchAdmin schAdmin1 = new SchAdmin();
                schAdmin1.setNum(rs.getString("num"));
                schAdmin1.setPassword(rs.getString("password"));
                if (schAdmin1.equals(schAdmin)) {//登录成功
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
