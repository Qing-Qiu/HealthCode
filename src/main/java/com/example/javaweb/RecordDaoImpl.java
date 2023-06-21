package com.example.javaweb;

import java.sql.*;
import java.util.ArrayList;

public class RecordDaoImpl implements RecordDao {
    public String queryCla(String cla) {

        return null;
    }

    public String queryCol(String col) {

        return null;
    }

    public String queryMaj(String maj) {

        return null;
    }

    public ArrayList<Record> queryRec() {
        String sql = "SELECT * FROM record;";
        Record record = new Record();
        ArrayList<Record> records = new ArrayList<Record>();
        try {
            Connection conn = getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                record.setName(rs.getString("name"));
                record.setColor(rs.getString("color"));
                record.setTime(rs.getString("time"));
                records.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public ArrayList<Object> queryStu() {

        return null;
    }

    public void insertStu(Object stu) {

    }

    public void insertTea(Object tea) {

    }
}
