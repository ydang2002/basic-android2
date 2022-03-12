package com.nhuy.lesson4recyclerviewstaggeredgridlayoutmannager;

public class User {
    //xét ành thừ thư mục drawable
    private int resourceId;
    private String name;

    public User(int resourId, String name) {
        this.resourceId = resourId;
        this.name = name;
    }

    public int getResourId() {
        return resourceId;
    }

    public void setResourId(int resourId) {
        this.resourceId = resourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
