package com.example.javaweb;

public class Record {
    private String name;
    private String color;
    private String time;
    private String num;
    private String idnum;
    private String col;
    private String maj;
    private String cla;
    private String role;

    public Record() {
    }

    public Record(String name, String color, String time, String num, String idnum, String col, String maj, String cla, String role) {
        this.name = name;
        this.color = color;
        this.time = time;
        this.num = num;
        this.idnum = idnum;
        this.col = col;
        this.maj = maj;
        this.cla = cla;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
