package com.example.javaweb;

public class Record {
    private String name;
    private String color;
    private String time;

    public Record() {
    }

    public Record(String name, String color, String time) {
        this.name = name;
        this.color = color;
        this.time = time;
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
}
