package com.example.javaweb;

import java.util.ArrayList;

public interface RecordDao extends Dao {
    public ArrayList<Record> queryCla(String cla);

    public ArrayList<Record> queryCol(String col);

    public ArrayList<Record> queryMaj(String maj);

    public ArrayList<Record> queryRec();

    public ArrayList<Record> queryStu(String num);

    public boolean insertStu(Student stu);

    public boolean insertTea(Teacher tea);
}
