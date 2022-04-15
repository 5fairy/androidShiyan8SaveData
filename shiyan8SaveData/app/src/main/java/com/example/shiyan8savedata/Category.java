package com.example.shiyan8savedata;

public class Category {
    private int cId;
    private String cName;
    private int cCode;

    public Category(int cId, String cName, int cCode) {
        this.cId = cId;
        this.cName = cName;
        this.cCode = cCode;
    }

    public int getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public int getcCode() {
        return cCode;
    }
}
