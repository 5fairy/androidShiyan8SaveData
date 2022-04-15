package com.example.shiyan8savedata;

public class Book {
    private int bId;
    private String bName;
    private String bAuthor;
    private double bPrice;
    private int bPages;
    private int categoryId;

    public Book(String bName, double bPrice, int categoryId) {
        this.bName = bName;
        this.bPrice = bPrice;
        this.categoryId = categoryId;
    }

    public Book(int bId, String bName, String bAuthor, double bPrice, int bPages, int categoryId) {
        this.bId = bId;
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bPrice = bPrice;
        this.bPages = bPages;
        this.categoryId = categoryId;
    }

    public int getbId() {
        return bId;
    }

    public String getbName() {
        return bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public double getbPrice() {
        return bPrice;
    }

    public int getbPages() {
        return bPages;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
