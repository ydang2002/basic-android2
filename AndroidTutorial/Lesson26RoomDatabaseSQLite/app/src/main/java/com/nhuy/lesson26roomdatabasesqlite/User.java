package com.nhuy.lesson26roomdatabasesqlite;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//đặt tên bảng
@Entity(tableName = "user")
public class User implements Serializable {

    //trường id làm khóa chính, id tự động tăng
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;
    private String address;

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
