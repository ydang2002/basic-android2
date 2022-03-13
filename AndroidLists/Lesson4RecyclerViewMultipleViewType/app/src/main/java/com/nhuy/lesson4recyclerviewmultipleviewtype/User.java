package com.nhuy.lesson4recyclerviewmultipleviewtype;

public class User {

    private int resourcedId;
    private String name;
    //dùng để đặt cho hai trừng hợp: nếu như là true là user_featured còn fale la user_nomal
    private boolean isFeatured;

    public User(int resourcedId, String name, boolean isFeatured) {
        this.resourcedId = resourcedId;
        this.name = name;
        this.isFeatured = isFeatured;

    }

    public int getResourcedId() {
        return resourcedId;
    }

    public void setResourcedId(int resourcedId) {
        this.resourcedId = resourcedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }
}
