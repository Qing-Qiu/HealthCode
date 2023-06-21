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
            stat.setString(1,cla);
            stat.setString(2,cla);
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
            Dao.closeAll(conn,stat,rs);
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
            stat.setString(1,col);
            stat.setString(2,col);
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
            Dao.closeAll(conn,stat,rs);
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
            stat.setString(1,maj);
            stat.setString(2,maj);
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
            Dao.closeAll(conn,stat,rs);
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
            Dao.closeAll(conn,stat,rs);
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
            stat.setString(1,num);
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
            Dao.closeAll(conn,stat,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public void insertStu(Object stu) {

    }

    public void insertTea(Object tea) {

    }
}
