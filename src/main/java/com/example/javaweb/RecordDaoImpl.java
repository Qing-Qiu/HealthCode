package com.example.javaweb;

import java.sql.*;
import java.util.ArrayList;

public class RecordDaoImpl implements RecordDao {
    public ArrayList<Record> queryCla(String cla) {
        String sql = "SELECT record.name,color,time,num,idnum,college,major,class,'student' AS role FROM record,student WHERE record.name=student.name AND class=? " +
                "UNION SELECT record.name,color,time,num,idnum,college,major,class,role FROM record,teacher WHERE record.name=teacher.name AND class=? ORDER BY time;";
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, cla);
            stat.setString(2, cla);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                record.setNum(rs.getString("num"));
                record.setIdnum(rs.getString("idnum"));
                record.setCol(rs.getString("college"));
                record.setMaj(rs.getString("major"));
                record.setCla(rs.getString("class"));
                record.setRole(rs.getString("role"));
                records.add(record);
            }
            Dao.closeAll(conn, stat, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public ArrayList<Record> queryCol(String col) {
        String sql = "SELECT record.name,color,time,num,idnum,college,major,class,'student' AS role FROM record,student WHERE record.name=student.name AND college=? " +
                "UNION SELECT record.name,color,time,num,idnum,college,major,class,role FROM record,teacher WHERE record.name=teacher.name AND college=? ORDER BY time;";
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, col);
            stat.setString(2, col);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                record.setNum(rs.getString("num"));
                record.setIdnum(rs.getString("idnum"));
                record.setCol(rs.getString("college"));
                record.setMaj(rs.getString("major"));
                record.setCla(rs.getString("class"));
                record.setRole(rs.getString("role"));
                records.add(record);
            }
            Dao.closeAll(conn, stat, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public ArrayList<Record> queryMaj(String maj) {
        String sql = "SELECT record.name,color,time,num,idnum,college,major,class,'student' AS role FROM record,student WHERE record.name=student.name AND major=? " +
                "UNION SELECT record.name,color,time,num,idnum,college,major,class,role FROM record,teacher WHERE record.name=teacher.name AND major=? ORDER BY time;";
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, maj);
            stat.setString(2, maj);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                record.setNum(rs.getString("num"));
                record.setIdnum(rs.getString("idnum"));
                record.setCol(rs.getString("college"));
                record.setMaj(rs.getString("major"));
                record.setCla(rs.getString("class"));
                record.setRole(rs.getString("role"));
                records.add(record);
            }
            Dao.closeAll(conn, stat, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public ArrayList<Record> queryRec() {
        String sql = "SELECT record.name,color,time,num,idnum,college,major,class,'student' AS role FROM record,student WHERE record.name=student.name " +
                "UNION SELECT record.name,color,time,num,idnum,college,major,class,role FROM record,teacher WHERE record.name=teacher.name ORDER BY time;";
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                record.setNum(rs.getString("num"));
                record.setIdnum(rs.getString("idnum"));
                record.setCol(rs.getString("college"));
                record.setMaj(rs.getString("major"));
                record.setCla(rs.getString("class"));
                record.setRole(rs.getString("role"));
                records.add(record);
            }
            Dao.closeAll(conn, stat, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public ArrayList<Record> queryStu(String num) {
        String sql = "SELECT record.name,color,time,num,idnum,college,major,class FROM record,student WHERE record.name=student.name AND num=? ";
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, num);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                record.setNum(rs.getString("num"));
                record.setIdnum(rs.getString("idnum"));
                record.setCol(rs.getString("college"));
                record.setMaj(rs.getString("major"));
                record.setCla(rs.getString("class"));
                records.add(record);
            }
            Dao.closeAll(conn, stat, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public boolean insertStu(Student stu) {
        boolean flag = false;
        String sql = "INSERT INTO student VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, stu.getName());
            stat.setString(2, stu.getNum());
            stat.setString(3, stu.getIdnum());
            stat.setString(4, stu.getCol());
            stat.setString(5, stu.getMaj());
            stat.setString(6, stu.getCla());
            int affected_row = stat.executeUpdate();
            if (affected_row != 0) {
                flag = true;
            }
            Dao.closeAll(conn, stat, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertTea(Teacher tea) {
        boolean flag = false;
        String sql = "INSERT INTO teacher VALUES (?,?,?,?,?,?,?);";
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tea.getName());
            stat.setString(2, tea.getNum());
            stat.setString(3, tea.getIdnum());
            stat.setString(4, tea.getCol());
            stat.setString(5, tea.getMaj());
            stat.setString(6, tea.getCla());
            String role = "teacher";
            PreparedStatement stat1 = null;
            if (tea.getRole().equals("1")) {
                //系统管理员
                role = "sysadmin";
            } else if (tea.getRole().equals("2")) {
                //校级管理员
                sql = "INSERT INTO admin VALUES (?,?);";
                stat1 = conn.prepareStatement(sql);
                stat1.setString(1, tea.getNum());
                stat1.setString(2, "admin");
                role = "schadmin";
            } else if (tea.getRole().equals("3")) {
                //院级管理员
                sql = "INSERT INTO admin VALUES (?,?);";
                stat1 = conn.prepareStatement(sql);
                stat1.setString(1, tea.getNum());
                stat1.setString(2, "admin");
                role = "coladmin";
            }
            stat.setString(7, role);
            int affected_row = stat.executeUpdate();
            if (affected_row != 0) {
                flag = true;
                if (role.equals("schadmin") || role.equals("coladmin"))
                    stat1.executeUpdate();
            }
            Dao.closeAll(conn, stat, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
