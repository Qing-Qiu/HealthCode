package com.example.javaweb;

public class Student {
    private String name;
    private String num;
    private String idnum;
    private String col;
    private String maj;
    private String cla;

    public Student() {
    }

    public Student(String name, String num, String idnum) {
        this.name = name;
        this.num = num;
        this.idnum = idnum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Student) {
            Student t = (Student) obj;
            return this.name.equals(t.name) && this.num.equals(t.num) && this.idnum.equals(t.idnum);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getMaj() {
        return maj;
    }

    public void setMaj(String maj) {
        this.maj = maj;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}