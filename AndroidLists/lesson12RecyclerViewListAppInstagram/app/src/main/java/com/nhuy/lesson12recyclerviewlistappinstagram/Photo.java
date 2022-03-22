package com.nhuy.lesson12recyclerviewlistappinstagram;

public class Photo {

    //set ảnh từ thư mục drawable
    private int resourceId;

    public Photo(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
