package com.nhuy.lesson18recyclerviewrecyclerview.model;

import java.util.List;

public class ListData {
    private int type;
    private List<Category> listCategory;
    private List<User> listUser;

    public ListData(int type, List<Category> listCategory, List<User> listUser) {
        this.type = type;
        this.listCategory = listCategory;
        this.listUser = listUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }
}
