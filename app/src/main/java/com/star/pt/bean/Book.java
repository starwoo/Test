package com.star.pt.bean;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class Book {
    private String title;
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[title:"+title+",name:"+name+"]";
    }
}
