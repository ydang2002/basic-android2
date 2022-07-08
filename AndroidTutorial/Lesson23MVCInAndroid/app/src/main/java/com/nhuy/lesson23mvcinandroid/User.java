package com.nhuy.lesson23mvcinandroid;

import android.text.TextUtils;
import android.util.Patterns;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //check email có hợp lệ không
    public boolean isValidEmail(){
        //!TextUtils.isEmpty(email): email không được rỗng
        //Patterns.EMAIL_ADDRESS: thõa mã email
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //Check Password
    public boolean isValidPassword(){
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }
}
