package com.example.javaweb;

import java.util.Objects;

public class SchAdmin {
    private String num;

    private String password;

    public SchAdmin() {
    }

    public SchAdmin(String num, String password) {
        this.num = num;
        this.password = password;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchAdmin schAdmin = (SchAdmin) o;
        return Objects.equals(num, schAdmin.num) && Objects.equals(password, schAdmin.password);
    }
}
