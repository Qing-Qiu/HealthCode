package com.example.javaweb;

import java.util.ArrayList;

public interface RecordDao extends Dao {
    public String queryCla(String cla);

    public String queryCol(String col);

    public String queryMaj(String maj);

    public ArrayList<Record> queryRec();

    public ArrayList<Object> queryStu();

    public void insertStu(Object stu);

    public void insertTea(Object tea);
}
