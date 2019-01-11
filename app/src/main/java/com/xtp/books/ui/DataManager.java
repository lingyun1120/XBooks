package com.xtp.books.ui;

import com.xtp.books.entity.BookBean;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public static List<BookBean> getBookList() {
        List<BookBean> list = new ArrayList<>();

        list.add(new BookBean("https://img10.360buyimg.com/n1/jfs/t18235/240/2449175150/214290/3e58a1b3/5af500e5N34ce84fe.jpg",
                "RxJava 2.x 实战", "沈哲", "电子工业出版社", "2018-4", "9787121337222"));

        list.add(new BookBean("https://img14.360buyimg.com/n1/jfs/t1759/57/1234940139/123217/182b5287/55e3ffb2N2c890d40.jpg",
                "Android开发艺术探索", "任玉刚", "电子工业出版社", "2015-9-1", "9787121269394"));

        return list;
    }
}
