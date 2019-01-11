package com.xtp.books.entity;

public class BookBean {
    public BookBean(String cover, String title, String author, String publisher, String date, String ISBN) {
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
        this.ISBN = ISBN;
    }

    public String cover;
    public String title;
    public String author;
    public String publisher;
    public String date;
    public String ISBN;
}
